Feature: Browse and interact with the page store

  Background:
    Given the user opens the browser
    And navigates to the store page

  Scenario: User views product details from the store page
    When the user scrolls through the product list
    And clicks on a product named "Blue Denim Shorts"
    Then the product detail page for "Blue Denim Shorts" should be displayed

  Scenario: User adds a product to the cart
    Given the user is on the product detail page for "Blue Shoes"
    When the user clicks the "Add to cart" button
    Then the shopping cart should contain 1 unit of "Blue Shoes"

  Scenario: User searches for a product by keyword
    When the user searches for "shirt" in the store search bar
    Then the search results should display products related to "shirt"
    And the user should see at least one product listed