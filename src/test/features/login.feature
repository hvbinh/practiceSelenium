Feature: login
  Scenario: login with correct username, password
    Given i am on login page
    When i input username
    And i input password
    And i click on submit button
    Then the system navigate to Home app