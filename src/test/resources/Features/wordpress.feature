Feature: valami

  Scenario: 1. The home page should be visible
    Given the wordpress site is opened
    Then the wordpress logo should be visible
    And the Log In button should be visible
    And the Get Started button should be visible