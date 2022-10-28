Feature: Login
  Is user logged correctly?

  Scenario: Happy path
    Given Correct user and password
    When I want to login with correct data
    Then I should be told "Login successfully"

  Scenario: Expect to fail by password
    Given Correct user and incorrect password
    When I want to login with correct user
    Then I should be told "Incorrect password"

  Scenario: Expect to fail by user
    Given Correct password and incorrect user
    When I want to login with correct password
    Then I should be told "Incorrect user"

  Scenario: Expect to fail by user and password
    Given Incorrect user and password
    When I want to login with incorrect data
    Then I should be told "Incorrect user and password"