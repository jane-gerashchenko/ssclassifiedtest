# SSClassifiedTest

1. Tech stack:
    * Java
    * [Selenide](http://selenide.org/) library for UI test
    * JUnit as test runner
2. UI test:
    * Search for ad
    * Adding ad to memo as a favorite
3. Use [Allure](http://allure.qatools.ru/) for reporting.

## Instruction

In order to run test you can use IDE or you need to call `mvn clean test` task inside the project folder.
In order to get report you need to call `allure serve allure-results/` task inside the project folder. But to be able to do so
you need to install `allure` with `brew install allure`. In case you do not have `brew` you can look at the example
of the report in `allure-report-example/index.html`.