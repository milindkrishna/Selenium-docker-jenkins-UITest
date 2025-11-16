# Java-Selenium-Docker-Jenkins
Java Selenium Testing with Docker

# Run using CMD - Run in Chrome in Remote webdriver
mvn clean test "-Dbrowser=chrome" "-Dselenium.grid.enabled=true"

# Run using CMD - Run in Firefox in Remote webdriver
mvn clean test "-Dbrowser=firefox -Dselenium.grid.enabled=true"

# Run using CMD - Run in Chrome in Local webdriver
mvn clean test "-Dbrowser=chrome -Dselenium.grid.enabled=false"
