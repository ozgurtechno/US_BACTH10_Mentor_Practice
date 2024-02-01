Feature: Login Function
  As a user I want to be able to login
  with my valid username and password

  Scenario Outline: Login with valid username and password
    Given Navigate to Katalon Web Site
    And Enter "<username>" and "<password>"
    When Click on Login Button
    Then User should login successfully

    Examples:
      | username | password |
      | John Doe | ThisIsNotAPassword |

  Scenario Outline: Login with invalid username and password
    Given Navigate to Katalon Web Site
    And Enter "<username>" and "<password>"
    When Click on Login Button
    Then User should get error
    Examples:
      | username | password |
      | Invalid | ThisIsNotAPassword |
      | John Doe | Invalid |
      | Invalid | Invalid |
      | John Doe |  |
      |  | ThisIsNotAPassword |