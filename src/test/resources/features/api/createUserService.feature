Feature: all login scenarios


  Scenario: verify successful user creation
    Given create user with "email" and "password"
    When user hits POST create user service request
    Then validate create user service success response

