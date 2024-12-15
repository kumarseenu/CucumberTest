#Feature: User Login
#
#  Scenario Outline: User login with valid and invalid credentials
#    Given I navigate to the login page
#    When I enter the username "<username>" and password "<password>"
#    And I clicks on the login button
#    Then I should see "<result>"
#
#    Examples:
#      | username        | password        | result                         |
#      | student         | Password123     | logged-in-successfully         |
#      | student         | Password124     | practice-test-login            |