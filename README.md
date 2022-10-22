# JDI Light project template
For run new UI test automation just download and open this project
Powered by [JDI Light](https://github.com/jdi-testing/jdi-light) and Selenium

# Instruction:
1. Download template and unpack in appropriate folder

2. Open project in IDE (for example IntelliJIdea)

3. For running demo tests:
    * Maven: just use "mvn clean install" command
    * IDE: run by click on "example" folder in src/test and select "Run tests"

4. Logs: Observe test run results in Console log

5. Reporting: After running tests just run **allure:serve** in maven plugins

6. Use as template for your project: 
    * just remove all content from **src/main/.../example** folder, add your package you Page Objects
    * replace tests in **src/test/.../example** folder with your tests

7. TestNg Retry and before after listeners: You can also modify rules of retry tests (now it is 1 retry for each test)
and actions before/after all tests (now it prints test name and result) in **org.mytests.tests.testng** folder
