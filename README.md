Project Overview

A comprehensive Java Selenium UI Testing Framework that integrates Docker containerization, Selenium Grid, and Jenkins CI/CD pipeline for automated browser testing. This project demonstrates modern test automation architecture with flexible browser support and grid execution capabilities.

Key Features

1. Java Selenium Testing Framework
Built with Java and Selenium WebDriver
Supports multiple browsers: Chrome and Firefox
TestNG-based test execution framework
Maven-based project structure for dependency management
2. Selenium Grid Integration
Configurable Selenium Grid support via system property
Remote WebDriver execution capability
Enables parallel and distributed test execution
Grid console accessible at http://localhost:4444/grid/console
3. Docker Containerization
Fully dockerized test environment
Docker Compose setup for Selenium Hub and browser nodes
Eliminates dependency installation overhead
Consistent test execution across environments
VNC viewer support for test visualization
4. Jenkins CI/CD Pipeline
Automated build and test pipeline (Jenkinsfile present)
Integration with Docker for containerized test execution
Continuous testing on code commits
Jenkins Blue Ocean plugin support for pipeline visualization

Execution Modes

The project supports flexible execution configurations:
# Run tests with Chrome on Selenium Grid
mvn clean test "-Dbrowser=chrome" "-Dselenium.grid.enabled=true"

# Run tests with Firefox on Selenium Grid
mvn clean test "-Dbrowser=firefox" "-Dselenium.grid.enabled=true"

# Run tests with Chrome locally (without Grid)
mvn clean test "-Dbrowser=chrome" "-Dselenium.grid.enabled=false"

Technical Architecture

Components:
Selenium Hub: Coordinates and distributes test execution across browser nodes
Chrome/Firefox Nodes: Browser-specific containers where tests execute
Test Container: Contains compiled Selenium tests ready for execution
Jenkins: Orchestrates the entire CI/CD workflow

Test Configuration:
Dynamic browser selection (Chrome/Firefox)
Remote WebDriver with Grid Hub connection
Configurable Selenium Hub host via system properties
TestNG test reports and Extent Reports generation

Benefits
✅ Portability: Run tests anywhere Docker is available
✅ Scalability: Easily scale browser nodes using Docker Compose
✅ Consistency: Same environment across dev, test, and production
✅ Parallel Execution: Run multiple tests simultaneously on Grid
✅ Cross-Browser Testing: Execute same tests on different browsers
✅ CI/CD Ready: Seamless integration with Jenkins pipeline
✅ No Setup Overhead: Eliminate local browser driver installation

Use Cases
Automated UI regression testing
Cross-browser compatibility testing
Parallel test execution for faster feedback
Integration testing in CI/CD pipelines
Continuous deployment validation
Headless browser testing in containerized environments

This project exemplifies modern DevOps practices by combining test automation, containerization, and continuous integration for efficient and reliable UI testing workflows.
