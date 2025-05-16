Feature: Login Tests

  Scenario: Successful login
    Given user is on login page
    When user enters username "testuser" and password "Password123"
    And clicks login button
    Then user should see dashboard

  Scenario: Invalid login
    Given user is on login page
    When user enters username "bad" and password "wrong"
    And clicks login button
    Then error message "Invalid credentials" is displayed

  Scenario: Logout flow
    Given user is on login page
    When user enters username "testuser" and password "Password123"
    And clicks login button
    When user logs out
    Then user should be redirected to login page
