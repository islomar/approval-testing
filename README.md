# Automatic generation of tests
* Here we are trying the automatic generation of tests as an alternative to the manual approval testing strategy from the other branches of this repo. 
* The tool used is [EvoSuite](https://github.com/EvoSuite/evosuite)
* http://www.evosuite.org/
* http://www.evosuite.org/documentation/intellij-idea-plugin/


## Important remarks
* This kind of automatic test generation should ONLY be used for creating a safety net before refactoring. **Theses tests should not stay**, they should be substituted for business descriptive tests who clearly explain the behaviour of the business code using the proper business domain language.
* We only interested in getting a 100% test coverage.
* The set up and configuration needed can be quite complex, e.g. http://www.evosuite.org/documentation/maven-plugin/ or http://www.evosuite.org/documentation/tutorial-part-1/
* EvoSuite limitations:
    * The current version of EvoSuite is not compatible with TestNG, **it requires JUnit**.
    * In order to run the test coverage from IntelliJ, you need to:
        * Configure JaCoCo as the coverage runner (from "Edit Configuration").
        * substitute `separateClassLoader = true` for `separateClassLoader = false`. More info [here](http://www.evosuite.org/documentation/measuring-code-coverage/).
    * Debugging in IntelliJ doesn't work out of the box.
    * The documentation looks a little bit chaotic and clumsy to me.
    * The line coverage shown is 100%, but the is no real business case coverage. The tests generated just check that nothing breaks, but no serious business logic at all.
* As usual, this is just a tool to be used in the right context. Still, I have a deep concern that these generated tests look like "serious test" and people would be leaning to leave them as definitive tests.

        
## How to set it up
* You need Java 1.8 and Maven 3.1 or higher installed


## How to run the tests
* From the command line, run `mvn clean test`
* To create a coverage report, run `mvn clean test jacoco:restore-instrumented-classes jacoco:report`


## How to generate the tests
1. Option 1: install the IntelliJ plugin and 
2. From the terminal, follow these steps: 
    1. `mvn compile evosuite:generate`
    1. `mvn -DmemoryInMB=2000 -Dcores=2 -evosuite:generate evosuite:export test`
2. From the terminal: `mvn -DmemoryInMB=2000 -Dcores=4 -Dsearch_budget=300 -evosuite:generate evosuite:export test`


## TO DO
* Set up PIT: http://www.evosuite.org/documentation/measuring-code-coverage/
* Better explore EvoSuite configuration parameters: is it possible to generate stronger tests?


## Further readings
* https://www.diffblue.com/blog/java/testing/java-unit-test-generator-comparison-diffblue-cover-vs-evosuite-vs-randoop-vs-squaretest/
* [Do Automatically Generated Unit Tests Find Real Faults? An Empirical Study of Effectiveness and Challenges](http://www.evosuite.org/wp-content/papercite-data/pdf/ase15_faults.pdf)
* Other options: [Randoop](https://randoop.github.io/randoop/), Diffblue Cover.