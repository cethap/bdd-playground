Feature: Search and API Testing
  As a user
  I want to verify search functionality using different tools
  And check API responses

  Scenario: Sauce Demo Search using Selenium
    Given I open Sauce Demo using Selenium
    When I search for "jacket" using Selenium
    Then the title should contain "Sauce Demo" using Selenium

  Scenario: Sauce Demo Search using Playwright
    Given I open Sauce Demo using Playwright
    When I search for "jacket" using Playwright
    Then the title should contain "Sauce Demo" using Playwright

  Scenario: Verify API response using RestAssured
    Given I target the JSONPlaceholder API
    When I request the user with ID 1
    Then the response status code should be 200
    And the username should be "Bret"
