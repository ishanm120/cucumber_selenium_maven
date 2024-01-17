Feature: all login scenarios

  @api @wip
  Scenario: verify successful response for facility details
    Given user hits GET facility details service for facility "6183"
    Then validate response of facility

