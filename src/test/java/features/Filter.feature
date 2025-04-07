Feature: Filter products by price on the store page

  Background:
    Given the user opens the browser
    And navigates to the store page

  Scenario: User filters products under a specific price
    When the user sets the maximum price to $50 using the price slider
    And clicks the "Filter" button
    Then only products priced $50 or less should be displayed

  Scenario: User filters products between $30 and $70
    When the user sets the minimum price to $30 and the maximum price to $70 using the price slider
    And clicks the "Filter" button
    Then only products within the $30 to $70 price range should be displayed

  Scenario: No products found for selected price range
    When the user sets the maximum price to $150
    And clicks the "Filter" button
    Then a message "No products were found matching your selection." should be displayed