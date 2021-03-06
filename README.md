[![Build Status](https://api.travis-ci.org/jane-gerashchenko/ssclassifiedtest.svg?branch=master)](https://travis-ci.org/jane-gerashchenko/ssclassifiedtest)

# SSClassifiedTest

[SSClassified](www.ss.com/en) - is a portal of private ads, widely used in Latvia.

1. Tech stack:
    * Java
    * Maven
    * [Selenide](http://selenide.org/) library for UI tests
    * JUnit as test runner
2. UI tests:
    * Search page:
      * Default state of search page
      * Search with empty string
      * Search for advertisement
    * Favorites page:
      * Default state of Favorites page
      * Opening advertisement and adding it to the favorite list
      * Selecting advertisement via checkbox, adding it to favorites list and deleting from the list.
3. [Allure](http://allure.qatools.ru/) for reporting.
4. [Travis](https://travis-ci.org) as CI

## Instruction

In order to run test you can use IDE or you need to call `mvn clean test` command inside the project folder.
To be able to get report you need to install `allure` with `brew install allure`. 
Report is generated using `allure serve allure-results/` command inside the project folder. 
Or you can look at the example of the report in `allure-report-example/index.html`.