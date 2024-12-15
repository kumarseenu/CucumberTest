Feature: End-to-End API Testing

  Scenario: Create, retrieve, update, and delete a resource
    Given I set up the base API endpoint
    When I send a POST request to create a new resource
    Then I should receive a status code of 201
    And the response should contain the title "Test Title"

    When I send a GET request to retrieve the created resource
    Then I should receive a status code of 200
    And the response should contain the title "Test Title"

    When I send a PUT request to update the resource
    Then I should receive a status code of 200
    And the response should contain the updated title "Updated Title"

    When I send a DELETE request to delete the resource
    Then I should receive a status code of 200
