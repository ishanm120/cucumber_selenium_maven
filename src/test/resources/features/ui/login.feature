@EZYGRD-1 @login @ui
Feature: EazyGrade login
  As an authorized EazyGrade user
  I want a secure and validated login form
  So that I can access the dashboard

  Background:
    Given the user opens the EazyGrade login page

  @sanity @regression
  Scenario: Display the login form
    Then the login page is displayed

  @regression @negative
  Scenario: User ID is mandatory
    When the user enters Password "sample_password"
    And the user clicks Login
    Then User ID required validation is displayed

  @regression @negative
  Scenario: Password is mandatory
    When the user enters User ID "sample_user"
    And the user clicks Login
    Then Password required validation is displayed

  @regression @negative
  Scenario: User ID and Password are mandatory
    When the user clicks Login
    Then User ID required validation is displayed
    And Password required validation is displayed

  @regression @negative
  Scenario: Reject invalid credentials
    When the user submits invalid login credentials
    Then a login error is displayed

  @regression
  Scenario: Show the password without changing its value
    When the user enters Password "sample_password"
    Then the password is masked
    When the user records the password and toggles its visibility
    Then the password is visible and unchanged

  @sanity @regression @requiresCredentials
  Scenario: Log in using the Login button
    When the user logs in with configured valid credentials
    Then the user is redirected to the dashboard

  @regression @requiresCredentials
  Scenario: Log in by pressing Enter
    When the user submits configured valid credentials using Enter
    Then the user is redirected to the dashboard
