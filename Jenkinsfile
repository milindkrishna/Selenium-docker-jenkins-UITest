pipeline {
    agent {
        label 'mk_node_agent'  // Use Windows node agent
    }
    
    options {
        timeout(time: 1, unit: 'HOURS')
        timestamps()
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository from GitHub...'
                git branch: 'main', url: "https://github.com/milindkrishna/Selenium-docker-jenkins-UITest.git"
                echo 'Repository cloned successfully'
                
                // Check if pom.xml exists in current directory or strykerUITest subdirectory
                script {
                    bat '''
                        @echo off
                        setlocal enabledelayedexpansion
                        echo Checking directory structure...
                        echo Current directory: %cd%
                        echo.
                        
                        if exist "pom.xml" (
                            echo ^✓ Found pom.xml in current directory
                        ) else if exist "strykerUITest\\pom.xml" (
                            echo ^✓ Found pom.xml in strykerUITest subdirectory
                        ) else (
                            echo ERROR: pom.xml not found!
                            echo Current contents:
                            dir
                            exit /b 1
                        )
                    '''
                }
            }
        }
        
        stage('Determine Module Path') {
            steps {
                script {
                    def modulePath = fileExists('pom.xml') ? '.' : (fileExists('strykerUITest/pom.xml') ? 'strykerUITest' : null)
                    if (modulePath == null) {
                        error "pom.xml not found in expected locations"
                    }
                    env.MODULE_PATH = modulePath
                    echo "Module path set to: ${env.MODULE_PATH}"
                }
            }
        }
        
        stage('Prepare Environment') {
            steps {
                dir("${env.MODULE_PATH}") {
                    echo 'Preparing test environment...'
                    bat '''
                        @echo off
                        echo Working Directory: %cd%
                        echo.
                        echo Verifying dependencies:
                        echo ========================================
                        java -version 2>&1
                        echo.
                        mvn -version
                        echo.
                        docker --version
                        echo.
                        docker-compose --version
                        echo ========================================
                    '''
                }
            }
        }
        
        stage('Start Selenium Grid') {
            steps {
                dir("${env.MODULE_PATH}") {
                    script {
                        try {
                            timeout(time: 5, unit: 'MINUTES') {
                                echo 'Starting Selenium Hub & Nodes using Docker Compose...'
                                bat '''
                                    @echo off
                                    echo Starting Docker Compose containers...
                                    echo Current directory: %cd%
                                    echo.
                                    
                                    if not exist "docker-compose.yml" (
                                        if not exist "docker-compose.yaml" (
                                            echo ERROR: docker-compose file not found
                                            dir
                                            exit /b 1
                                        )
                                    )
                                    
                                    docker-compose up -d
                                    if %ERRORLEVEL% neq 0 (
                                        echo ERROR: Failed to start Docker Compose
                                        exit /b 1
                                    )
                                    
                                    echo.
                                    echo Waiting for Selenium Grid to stabilize...
                                    REM Wait 30 seconds for Grid containers to be fully ready
                                    ping 127.0.0.1 -n 31 > nul
                                    
                                    echo Verifying Grid is running...
                                    docker-compose ps
                                    echo.
                                    echo Docker Compose containers started successfully
                                '''
                            }
                        } catch (Exception e) {
                            echo "Docker Compose startup error: ${e.getMessage()}"
                            currentBuild.result = 'UNSTABLE'
                        }
                    }
                }
            }
        }
        
        stage('Run Selenium Tests') {
            steps {
                dir("${env.MODULE_PATH}") {
                    script {
                        echo 'Running Maven Selenium tests with Selenium Grid...'
                        try {
                            bat '''
                                @echo off
                                setlocal enabledelayedexpansion
                                
                                echo.
                                echo Current directory: %cd%
                                echo ========================================
                                echo Running Maven Selenium tests
                                echo ========================================
                                echo.
                                
                                if not exist "pom.xml" (
                                    echo ERROR: pom.xml not found in %cd%
                                    exit /b 1
                                )
                                
                                echo Executing: mvn clean test
                                mvn clean test -Dbrowser=chrome -Dselenium.grid.enabled=true -Dselenium.grid.url=http://localhost:4444
                                
                                if %ERRORLEVEL% neq 0 (
                                    echo.
                                    echo ERROR: Test execution failed with exit code %ERRORLEVEL%
                                    exit /b 1
                                )
                                echo.
                                echo SUCCESS: All tests completed
                            '''
                        } catch (Exception e) {
                            echo "Maven test execution failed: ${e.getMessage()}"
                            currentBuild.result = 'FAILURE'
                            error("Test execution failed: ${e.getMessage()}")
                        }
                    }
                }
            }
        }
    }
    
    post {
        success {
            echo '════════════════════════════════════════════'
            echo '✓ All tests passed successfully!'
            echo '════════════════════════════════════════════'
            script {
                dir("${env.MODULE_PATH}") {
                    bat '''
                        @echo off
                        echo Test reports available at:
                        echo   - target/test-output/index.html
                        echo   - target/test-output/testng-results.xml
                        echo.
                        if exist "target\test-output" (
                            dir target\test-output
                        )
                    '''
                }
            }
        }
        
        failure {
            echo '════════════════════════════════════════════'
            echo '✗ Tests failed - check logs below'
            echo '════════════════════════════════════════════'
            script {
                dir("${env.MODULE_PATH}") {
                    bat '''
                        @echo off
                        echo Test failure details:
                        echo   - target/test-output/
                        echo   - target/surefire-reports/
                        echo.
                        if exist "target\test-output" (
                            dir target\test-output
                        )
                    '''
                }
            }
        }
        
        unstable {
            echo '⚠ Pipeline completed with warnings or timeouts'
        }
        
        always {
            echo 'Cleaning up Docker containers...'
            script {
                dir("${env.MODULE_PATH}") {
                    bat '''
                        @echo off
                        echo Stopping Selenium Grid...
                        docker-compose down --remove-orphans
                        if %ERRORLEVEL% equ 0 (
                            echo Docker containers cleaned up successfully
                        ) else (
                            echo Warning: Cleanup encountered an issue but continuing...
                        )
                    '''
                }
            }
        }
    }
}

