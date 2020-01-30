# Automatic generation of tests
* Here we are trying the automatic generation of tests as an alternative to the manual approval testing strategy from the other branches of this repo. 
* The tool used is [EvoSuite](https://github.com/EvoSuite/evosuite)
* http://www.evosuite.org/
* http://www.evosuite.org/documentation/intellij-idea-plugin/


## Important remarks
* This kind of automatic test generation should ONLY be used for creating a safety net before refactoring. **Theses tests should not stay**, they should be substituted for business descriptive tests who clearly explain the behaviour of the business code using the proper business domain language.
* We only interested in getting a 100% test coverage.
* Limitations:
    * The current version of EvoSuite is not compatible with TestNG, **it requires JUnit**.
    * In order to run the test coverage from IntelliJ, you need to:
        * Configure JaCoCo as the coverage runner (from "Edit Configuration").
        * substitute `separateClassLoader = true` for `separateClassLoader = false`. More info [here](http://www.evosuite.org/documentation/measuring-code-coverage/).


## How to set it up
* You need Java 1.8 and Maven installed