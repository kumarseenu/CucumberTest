Feature: User Login

  Scenario: User login with valid credentials
    Given I have the following login credentials
      | username | password     | expectedResult          |
      | student  | Password123  | logged-in-successfully  |
    When I attempt to login with these credentials
    Then the login result should be as expected

  Scenario: User login with invalid credentials
    Given I have the following login credentials
      | username | password     | expectedResult          |
      | student  | Password124  | practice-test-login     |
    When I attempt to login with these credentials
    Then the login result should be as expected