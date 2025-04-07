Feature: User authentication via login and registration

  Background:
    Given the user opens the browser
    And navigates to the login and register page at "https://askomdch.com/account/"

  Scenario: User logs in with valid credentials
    When the user enters a valid username and password
    And clicks the log in button
    Then the user should be logged in and redirected to the account dashboard

  Scenario: User fails to log in with invalid credentials
    When the user enters an invalid username or password
    And clicks the log in button
    Then an error message "Error: The username x is not registered on this site. If you are unsure of your username, try your email address instead." should be displayed