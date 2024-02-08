Feature: Book Appointment
#  Scenario Outline runs the same with different data sets multiple times

  Background: Login with valid username and password
    Given Navigate to Katalon Web Site
    And Enter "John Doe" and "ThisIsNotAPassword"
    When Click on Login Button
    Then User should login successfully

  @SmokeTest
  Scenario: Book appointment
    Given Fill out the form
      | 1            |
      | "12/05/2023" |
    When Click on Submit Button
    Then Appointment should be completed