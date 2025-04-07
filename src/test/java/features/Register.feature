Feature: User authentication via registration

  Background:
    Given the user opens the browser
    And navigates to the login and register page at "https://askomdch.com/account/"

  Scenario: User registers with a new email and password
    When the user enters "Mahendra" "mahendraqa27@gmail.com" and "Qwerty123@" in the registration form
    And clicks the register button
    Then the user should be logged in and redirected to the account dashboard

  Scenario: User fails to register with an existing email
    When the user enters an already registered email address and any password
    And clicks the register button
    Then an error message "Error: An account is already registered with your email address. Please log in." should be displayed

  Scenario: User attempts to register without filling required fields
    When the user leaves the email or password field empty in the registration form
    And clicks the register button
    Then an error message "Error: Please provide a valid email address." should be displayed