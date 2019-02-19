Feature: valami

  @asd
  Scenario: 1. The home page should be visible
    Given the WordPress site is opened
    Then the WordPress logo should be visible
    And the Log In button should be visible
    And the Get Started button should be visible

  @asd
  Scenario: 2.  The log in page should be visible
    Given the WordPress site is opened
    When the Log In button is clicked
    Then the Back to WordPress button should be visible
    And the continue button should be visible
    And the Log in to your account text should be visible
    And the continue with google button should be visible

  @asd
  Scenario: 3. The Log In should be successfully and the reader page should be visible
    Given the WordPress site is opened
    When the Log In button is clicked
    And the notfunx@gmail.com email address is typed into the email input field
    And the continue button is clicked
    Then the password input field should be visible
    When the test123456 password is typed into the password input field
    And the Log In button is clicked on the Log In page
    Then the Reader page should be visible