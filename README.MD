# Resolver

This project has tests to verify, different types components on a web page. The project is in Page Object Pattern Framework. It is written in Java, using selenium.

## Getting Started

To get started install the required software and run the test to verify.

### Prerequisites

Install the below prerequisites

```
- Java
- Maven
- Any IDE
- Chrome browser
```

## Running the tests

To run the tests use any of the two ways mentioned below.
```Add USERNAME and PASSWORD in src/main/resources/config.properties```
- Running using maven
    - Open the project in terminal and run below command
    ```$ mvn clean test``` 
- Running testng.xml through IDE  
    - Import the project to IntelliJIdea/any IDE, Build the project. Right click on testng.xml and select run.

## Project Folder Structure

### src
- src is the root folder which consists of Main folder and test folder
    #### main
    - Main has Java which consists of the java related files supporting the frame Work. It has Pages and utils folders.
        ##### Pages
        - Pages consists of the pages to support the framework. Pages contain objects and methods for a particular page.
        ##### Utils
        - This folder consists all the utilities required for the framework.
        ###### Fetching configuration from config properties file and creating constant variables. 
        - config.properties file in resources consists of configuration properties and test data for project.
        - Configutil class will fetch the properties file. 
        - Config class will convert all the properties in config to static final variables 
        ###### Driver Factory
        - The Driver factory class will create a driver required for the test`
        ###### WebElementUtils
        - This class consists of the utilities used by webdriver extracted.
    #### test
    - This folder consists of tests inside ```Java->tests```
    #### resources
    - This folder consists of resources required for the project.
        ##### drivers
        - Consists of chrome and gecko driver for running the tests.
        ##### config.properties
        - This file consists of properties and test data.
        - Please add user name and password.
        