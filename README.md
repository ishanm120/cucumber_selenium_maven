# Cucumber7.x Selenium 4.15 TestNG 7.7.1 UI and API

This repository contains unning Cucumber tests using TestNG with Cucumber 7.x. The project demonstrates how to set up and configure your test framework to execute Cucumber scenarios for UI and API in parallel with TestNG.

# Prerequisites
Java 8 or higher
Maven 3.x

# Project Structure




# Usage
Clone the repository:
``` git clone https://github.com/naveenanimation20/Cucumber7.xTestNGLatestPOC.git ```


# Navigate to the project directory:
``` cd Cucumber7.xTestNGLatestPOC ```

# Run the tests 
  option 1:  with Maven: You can use different tags to run 
``` mvn test "-Dcucumber.filter.tags=@api and @wip" ```

 option 2: with testRunner Class: You can use different tags to run 
``` Right click on testRunner class and run ```

 option 3: with textNG.xml Class:  
``` Right click on textNG.xml class and run ```


The tests will execute in parallel, and you can view the test results in the target/cucumber-reports directory.

# Customization
``` To adjust the level of parallelism, edit global.properties and change the threadCount. ```
``` To adjust the number of retries, edit Retry.java class and update  maxTry. ```

# Contributing
Feel free to submit issues or pull requests if you find any bugs or have suggestions for improvements.

# License
This project is licensed under the MIT License. See the LICENSE file for more information.
