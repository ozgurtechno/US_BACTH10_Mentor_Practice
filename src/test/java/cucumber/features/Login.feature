Feature: Login Function
  As a user i want to be able to login
  with my valid username and password

  Scenario: Login with valid username and password
    Given Navigate to Katalon Web Site
    And username "John Doe" and password "ThisIsNotAPassword"
    When Click on Login Button
    Then User should login successfully


#    Task 1 : Run this Scenario
  Scenario Outline: Data for username and password
    Given Navigate to Katalon Web Site
    And "<username>" and "<password>"
    When Click on Login Button
    Then User should get error
    Examples:
    |username|password|
    |John Doe|ThisIsNotAPassword1|
    |J0hn Doe|ThisIsNotAPassword|
    |        |ThisIsNotAPassword|
    |John Doe|                  |