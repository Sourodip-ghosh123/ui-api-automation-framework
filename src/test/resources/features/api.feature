Feature: API Tests

  Scenario: GET user data
    Given API is available at "https://jsonplaceholder.typicode.com"
    When I send GET request to "/users/1"
    Then response status should be 200
    And response should contain "Leanne Graham"

  Scenario: Create post
    Given API is available at "https://jsonplaceholder.typicode.com"
    When I send POST request to "/posts" with payload
      | title  | foo |
      | body   | bar |
      | userId | 1   |
    Then response status should be 201
    And response should contain "foo"
