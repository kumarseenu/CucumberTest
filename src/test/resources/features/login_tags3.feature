Feature: User Login

  @Smoke
  Scenario Outline: User login with valid credentials
    Given I navigate to the login page
    When I enter the username "<username>" and password "<password>"
    And I clicks on the login button
    Then I should see "<result>"

    Examples:
      | username        | password        | result                         |
      | student         | Password123     | logged-in-successfully         |

  @Sanity
  Scenario Outline: User login with incorrect credentials
    Given I navigate to the login page
    When I enter the username "<username>" and password "<password>"
    And I clicks on the login button
    Then I should see "<result>"

    Examples:
      | username        | password        | result                         |
      | student         | Password124     | practice-test-login            |

  @Regression
  Scenario Outline: User login with invalid credentials
    Given I navigate to the login page
    When I enter the username "<username>" and password "<password>"
    And I clicks on the login button
    Then I should see "<result>"

    Examples:
      | username        | password        | result                         |
      | 1234567         | 1234$#566gh     | practice-test-login            |