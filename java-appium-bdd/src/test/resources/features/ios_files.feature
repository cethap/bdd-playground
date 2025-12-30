@files
Feature: iOS Files App Automation

  Scenario: Browse folders in Files App
    Given I launch the Files app on iOS
    When I tap on the "Browse" tab
    Then I should see the "On My iPhone" folder
