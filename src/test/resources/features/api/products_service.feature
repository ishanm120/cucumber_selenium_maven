@api
Feature: all login scenarios

  Scenario: verify successful user creation
    When user hits GET products details service
    Then validate response of products

  @wip
  Scenario: verify count of products
    When user hits GET products details service
    Then user should see "110" products

  Scenario: verify search product by id
    When user hits GET product by id service with product id "1"
    Then user should following information for product with id "1":
      | title       | iPhone 9                                    |
      | description | An apple mobile which is nothing like apple |
      | price       | 549                                         |
      | brand       | Apple                                       |
      | category    | smartphones                                 |

  Scenario: verify addition of product
    When user hits POST add product service with following information:
      | title       | iPhone 9                                    |
      | description | An apple mobile which is nothing like apple |
      | price       | 549                                         |
      | brand       | Apple                                       |
      | category    | smartphones                                 |
    Then verify product is added successfully with title "iPhone 9"

  Scenario: verify addition of product
    When user hits update product by id service with product id "1"
      | title | iPhone 15 pro max |
      | price | 600               |
    Then verify product is updated successfully with title "iPhone 15 pro max"

