Feature: Sauce Demo Search
  As a user
  I want to search for products
  So I can find what I want to buy

  Scenario: Search for a product
    Given I open Sauce Demo
    When I search for "jacket"
    Then the title should contain "Sauce Demo"
