@api @dependsOnMethod
Feature: all login scenarios

  @dependsOn @loginDepends
  Scenario: e-verify user is logged in
    Given create user
    When enter user credentials
    And click on submit button
    Then verify user is logged in

  @dependent @loginDepends
  Scenario: e-verify profile page
    Given login with created user
    Then verify profile page

  @dependent @loginDepends
  Scenario: e-upload profile photo
    Given login with created user
    When upload image
    Then verify image uploaded

  @dependent @loginDepends
  Scenario: e-verify photo is changed
    Given login with created user
    When replace the current photo
    Then verify photo is changed

  @dependsOn @searchDepends
  Scenario: e-verify search page
    Given open application
    When search for dress
    Then verify search result page

  @dependent @searchDepends
  Scenario: e-verify listing on search page
    Given user is on search result page
    Then verify listing on page

  Scenario: e-verify login page
    Given open application
    Then verify login page


