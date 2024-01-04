@community @ui @wip
Feature: community page

  Scenario: verify community page
    Given user opens home page
    When user selects header option "Community."
    Then verify user is on community page

  Scenario: verify community page pass test
    Given user opens home page
    When user selects header option "Community."
    Then sample step to pass

  Scenario: verify community page fail test
    Given user opens home page
    When user selects header option "Community."
    Then sample step to fail

    