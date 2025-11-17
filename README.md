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


https://kroki.io/mermaid/svg/eNqVVl1v4jgUfedXWB1pX3YZCtkdqWhnpBJSShcSRCgzUtSHEAzxEmJkO5SR-PF77TgfZprSjdRics_x_fQxWxYeYrQYtBA8PFtt1febIT7ihB4wQ98p2_FDGOEbBZHP0FkGJeClfG17QyfwacYijGy6xn-vWOfbU3gM0e_IxwlOSbZHC8wFzzk4Xbcu3C4x44SmQE8Fo0nlcjReBCMiHrMVmuMD5URQ9lM5KHZur2m0w6z9L053JOXt57F01ejJHnfsIWqjpxxeeXpy3H_Grh9oA0TOjvUstf1hPHEKzIYkebIzcsAJSTEa4g1JiYBUKuLgeTwZBoOMJGvki3CbU_bHFEUJDuE_3R9go4qwcPxFIJN4Ey7ey26oaoGc9EgYTfc4FTe1Nk1nnu8EGmODW8rz3T0WxbAtC83Iy0XloOzniJE1spOMC8wqH_J5fB4EJQwapzz0_4RHrVRiNqVsTdIQuvlikI0vldsBo68cgnZhvLjpTqX2OPemTjewY0b3WKFQV3lbunYf_XV3e_vSQOoZpJ5B6jaRLIPk5vMYhUm4qvexeB7Gc-fB-9ENHgjDG3p6I77ubSOtZ9KMCLvdRppl0t6LUc7RW2tjIG3PXdyPXWeeT6ZzwlEmiiMbwuwz5WEaHnEK514ff4l1R43jerHV1OzuaD4eTqW2qFmbFsrC9Wx93sLrzziVCa2_CpbV0pp49v1EcScUcr5G3oQJx-9HKdWHCY5-Q_dMkE0YiVqkc2fmzRd-UEeWw-6OildVfM6PheMuAuck4Ij-ap54Iz-o6jKh25rRt-eO4_qPHjj0I4ZxymMqeGdJ1pg2S-yUplI8Sbo1KwyN9b2JLjI0k1MtarEQh36nk8gCxpQLdYSrMGAEA_hDS4JfdfPnOEzagsC5UIWQFnB3ERFcIqjd_naeZTxW18VZinxLi70yfcermNJdZ0aT5FwIb6smwgoF3tb8XNfl1oVOK9iCke0WrpdzLsStUpKV1c7FF6zyFrswuvikNfiszkCrOAzKmvcnpyplbZWHRr9QMOBDb89SFhttWr-u2HtX7FajvVCga4DeNUCzC0MjqkoYr_OKxzjacTlpG7I9l4f8Y-jyXFceig30TOypwAgGaMgIXN9V2eFTIYYE7jmyko3Lf5OY1b8K630MZl2DGS25jut9EGdVhSlrpSkMRzWxNdNu1W5RkDidarmyYFUEXC171dLKj1oufzxL_tdEjDDcHqE6SVpIrwNzAb2Ok0raNFrhQWRMgmqKWsWpQ4Ecc1-wkJvBRw2ulWyVEB5jbmqV0bH7KMKcE7ht0JGE57ryXtS-rLOkSQnNCSC11a51GXQpXEdEOgdl1aIvfoKfAgS_UpP-p83d5g8YGrrD_U-WZel1-5WsRdy3DqcaUcasSZu7j5LM-ub0u4_TpfQXgX5pJvUMUqFDOfHLexkC8T_0rbpt
