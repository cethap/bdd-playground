# Java BDD Project with Appium

This project is a BDD test automation framework for Mobile (Android/iOS) using Appium, Cucumber, and JUnit 5.

## Prerequisites

1. Java JDK 17+
2. Maven
3. Appium Server
   - Install: `npm install -g appium`
   - Install driver: `appium driver install uiautomator2`
4. Android Studio / Android SDK (for Android Emulators)

## Running Tests

1. Start Appium Server:
   ```bash
   appium
   ```

2. Run tests:
   ```bash
   mvn test
   ```

## Structure

- `src/test/java/pages`: Page Objects (Screen Objects)
- `src/test/java/steps`: Cucumber Step Definitions
- `src/test/java/utils`: Utilities (BasePage, etc.)
- `src/test/resources/features`: Gherkin Feature Files

## Capabilities

The project is configured for Android Emulator with Chrome browser by default.
See `SearchSteps.java` to modify capabilities.
