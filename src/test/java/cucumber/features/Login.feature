Feature: Login Function
  As a user I want to be able to login
  with my valid username and password

  Scenario: Login with valid username and password
    Given Navigate to Katalon Web Site
    And Enter "John Doe" and "ThisIsNotAPassword"
    When Click on Login Button
    Then User should login successfully


#    Task 1 : Run this Scenario
#    Task 2 : Send username and password from this scenario to login steps