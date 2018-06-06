[![Build Status](https://api.travis-ci.org/jane-gerashchenko/ssclassifiedtest.svg?branch=master)](https://travis-ci.org/jane-gerashchenko/ssclassifiedtest)

# SSClassifiedTest

1. Tech stack:
    * Java
    * Maven
    * [Selenide](http://selenide.org/) library for UI test
    * JUnit as test runner
2. UI test:
    * Search for ad
    * Adding ad to memo as a favorite
3. Use [Allure](http://allure.qatools.ru/) for reporting.
4. Use [Travis](https://travis-ci.org) as CI

## Instruction

In order to run test you can use IDE or you need to call `mvn clean test` task inside the project folder.
In order to get report you need to call `allure serve allure-results/` task inside the project folder. But to be able to do so
you need to install `allure` with `brew install allure`. Or you can look at the example of the report in `allure-report-example/index.html`.