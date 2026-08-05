# Cucumber, Selenium, TestNG and RestAssured framework

This repository contains a BDD automation framework for UI, mobile-web and API testing. Cucumber scenarios run through TestNG and support parallel execution, Selenium WebDriver, RestAssured and Extent reporting.

Current POC applications:

- UI: https://app.eazygrade.com
- API sample: https://dummyjson.com

# Prerequisites

- Java 21
- Maven 3.9.x
- Chrome or Firefox for UI execution


# Usage
Clone the repository:
``` git clone https://github.com/ishanm120/cucumber_selenium_maven.git ```


# Framework capabilities

- UI and mobile-web automation
- API automation
- Configurable retry, disabled by default
- Extent reports and Cucumber reports
- Parallel scenario execution
- GitHub Actions validation


# Run tests

Run API work-in-progress tests:

``` mvn test "-Dcucumber.filter.tags=@api and @wip" ```

Run UI tests in headless mode:

``` mvn test "-Dcucumber.filter.tags=@ui" -Dheadless=true ```

Configuration can be overridden without changing committed files:

``` mvn test -Dbrowser=firefox -DthreadCount=1 "-Dcucumber.filter.tags=@ui" ```

Reports are generated under `reports/` and `target/cucumber-reports/`.

# Customization
Update `src/test/resources/configs/global.properties`, pass a Maven system property, or provide the equivalent uppercase environment variable.

- `threadCount`: parallel scenario threads
- `retryCount`: retry count; default is `0` so failures remain visible
- `headless`: run UI tests without a visible browser
- `browserVersion`: optional; blank lets Selenium Manager use the available version

System properties and environment variables take precedence over the properties file. For example, `apiBaseUrl` can be supplied as `-DapiBaseUrl=...` or `API_BASE_URL`.

# Contribution workflow

1. Create a story branch such as `feature/EZYGRD-1`.
2. Reuse existing feature files, step definitions, Page Objects and API services where appropriate.
3. Do not commit credentials or environment secrets.
4. Run the affected tests and attach the report to a draft pull request.
5. Obtain the required approvals and passing checks before merging to `master`.

# Contributing
Feel free to submit issues or pull requests if you find any bugs or have suggestions for improvements.

# License
This project is licensed under the MIT License. See the LICENSE file for more information.
