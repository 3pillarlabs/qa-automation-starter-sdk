# QA Automation Starter SDK
[![Build Status](https://travis-ci.org/3pillarlabs/qa-automation-starter-sdk.svg?branch=develop)](https://travis-ci.org/3pillarlabs/qa-automation-starter-sdk) [![Code Quality](https://sonarcloud.io/api/project_badges/measure?project=3pillar-engineering-github&metric=alert_status)](https://sonarcloud.io/api/project_badges/measure?project=3pillar-engineering-github)

This SDK provides common libraries and utilities for a test automation framework across web, APIs and mobile. There are two ways to use this SDK:
* Clone the SDK and add application specific test data, tests and page objects.
* Clone the SDK and set it up as a dependency for an application specific test automation framework.

## Highlights
* Element Hierarchy - A hierarchy of elements with standard behavior for each element.
* No Waits - Ability to write operations in the page object methods assuming total synchronous behavior. All waits are handled by the framework.
* Listeners - A collection of most useful listeners such as a listener to integrate test execution with TestRails.
* Reports - Ability to customise reports.
* Spring Boot - the test automation framework works as a Spring Boot application.
* Depedency Injection - the framework uses Spring to instantiate test classes and inject dependencies.
* Test Data Framework - framework that provides test data stored in JSON files. Modeled on [Fixjures](https://github.com/douglasrodrigo/fixjures) and [Fixture-Factory](https://github.com/six2six/fixture-factory)

## Technology Stack
* Java 8
* TestNG
* Selenium Webdriver
* RestAssured
* Appium
* Logging - slf4j, logback
* Gradle

## CI/CD
* Build Status - TravisCI
* Code Quality - CodeClimate

## Structure
The SDK is a multi-module Java application.
```
build.gradle
settings.gradle
common/
  src/
    main/java
    test/java
web/
  src/
    main/java
    test/java
api/
  src/
    main/java
    test/java
mobile/
  src/
    main/java
    test/java
web-sample-app/
  src/
    main/java
    test/java
api-sample-app/
  src/
    main/java
    test/java
mobile-sample-app/
  src/
    test/java
```

## Writing Tests

This is just an initial idea. In the actual implementation the test class may extend an abstract class or adhere to an interface.

```java
/**
 * Login Tests
 */
public class LoginTest {

  // inject page object
  @Inject
  private LoginPage loginPage;

  @Test(dataProvider = "validUsers")
  public void successfulLogin(Set<User> users) {
    for (User user : users) {
      loginPage.login(user);
    }
  }
}

/**
 * Page object for Login page
 */
 public class LoginPage {

   // inject the WebDriver instance
   @Inject
   private WebDriver webDriver;

   // inject other Page Objects
   @Inject
   private DashboardPage dashboard;

   // declare the fields
   @PageElement(tag = By.ByName, value = "login.UserName")
   private TextField userName;

   @PageElement(tag = By.ByName, value = "login.Password")
   private TextField password;

   @PageElement(tag = By.ByTagName, value = "button")
   private Button submit;

   public DashboardPage login(User user) {
     try {
       userName.setText(user.getUserName());
       password.setText(user.getPassword());
       submit.click();
       return dashboard;
     } catch (WebException e) {
       logger.error(e.message, e);
       return this;
     }
   }
 }

 /**
  * Data provider
  */
public class UserDataProvider {

  @DataProvider(name = "validUsers")
  public static Object[][] validUsers() {
    // Use the Data framework to fetch valid users
  }
}
```
