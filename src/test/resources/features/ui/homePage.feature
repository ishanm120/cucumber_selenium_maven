@home @ui
Feature: Home page

  Scenario: verify home page
    Given I open home page
    Then verify user is on homepage

    @smoke
  Scenario: verify home page pass test
    Given user opens home page
    Then sample step to pass

  Scenario: verify home page fail test
    Given user opens home page
    Then sample step to fail

    @smoke
  Scenario: verify home page fail test
    Given user opens home page
    Then sample step to fail

