# Java-Selenium
Java Selenium Testing with Docker

# Repo Link
https://github.com/pgupta584/Java-Selenium

# Clone Repo
git clone https://github.com/pgupta584/Java-Selenium.git

# Run Using Maven
mvn clean test

# Run using CMD - Run in Chrome in Remote webdriver
mvn clean test -Dbrowser=chrome -Dselenium.grid.enabled=true

# Run using CMD - Run in Firefox in Remote webdriver
mvn clean test -Dbrowser=firefox -Dselenium.grid.enabled=true

# Run using CMD - Run in Chrome in Local webdriver
mvn clean test -Dbrowser=chrome -Dselenium.grid.enabled=false
