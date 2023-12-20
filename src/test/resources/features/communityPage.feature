@community
Feature: community page

  @wip
  Scenario: verify community page
    Given user opens home page
    When user selects header option "Community."
    Then verify user is on community page
    