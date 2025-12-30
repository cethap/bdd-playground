Feature: Search and API Testing
  As a user
  I want to verify search functionality using Appium
  And check API responses

  Scenario: Sauce Demo Search using Appium (Android)
    Given I open Sauce Demo using Appium on "Android"
    When I search for "jacket" using Appium
    Then the title should contain "Sauce Demo" using Appium

  Scenario: Sauce Demo Search using Appium (iOS)
    Given I open Sauce Demo using Appium on "iOS"
    When I search for "jacket" using Appium
    Then the title should contain "Sauce Demo" using Appium


