[![Build Status](https://api.travis-ci.org/jane-gerashchenko/ssclassifiedtest.svg?branch=master)](https://travis-ci.org/jane-gerashchenko/ssclassifiedtest)

# SSClassifiedTest

[SSClassified](www.ss.com/en) - is a portal of private ads, widely used in Latvia.

1. Tech stack:
    * Java
    * Maven
    * [Selenide](http://selenide.org/) library for UI test
    * JUnit as test runner
2. UI test:
    * Search for ad
    * Adding ad to memo as a favorite
    * Verify that ad has been added to the favorite list
3. Use [Allure](http://allure.qatools.ru/) for reporting.
4. Use [Travis](https://travis-ci.org) as CI

## Instruction

In order to run test you can use IDE or you need to call `mvn clean test` command inside the project folder.
To be able to get report you need to install `allure` with `brew install allure`. 
Report is generated using `allure serve allure-results/` command inside the project folder. 
Or you can look at the example of the report in `allure-report-example/index.html`.