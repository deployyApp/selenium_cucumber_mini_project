Feature: Filter products by category from the store page

  Background:
    Given the user opens the browser
    And navigates to the store page

  Scenario: User filters products by "Men" category
    When the user clicks on the "Men" category from the sidebar
    Then only products from the "Men" category should be displayed
    And the category heading should be "Men"

  Scenario: User filters products by "Women" category
    When the user clicks on the "Women" category from the sidebar
    Then only products from the "Women" category should be displayed
    And the category heading should be "Women"
