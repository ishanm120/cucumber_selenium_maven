@api
Feature: all login scenarios

  Scenario: verify successful response for facility details
    Given user hits GET facility details service for facility "6183"
    Then validate response of facility

  @wip
  Scenario: testing api test for github actions
    Given enter github action details
    Then verify success execution
