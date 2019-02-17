Feature: valami

  Scenario: 1. The home page should be visible
    Given the WordPress site is opened
    Then the WordPress logo should be visible
    And the Log In button should be visible
    And the Get Started button should be visible

  Scenario: 2.  The log in page should be visible
    Given the WordPress site is opened
    When the Log In button is clicked
    Then the Back to WordPress button should be visible
    And the continue button should be visible
    And the Log in to your account text should be visible
    And the continue with google button should be visible
