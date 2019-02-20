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

  Scenario: 3. The Log In should be successfully and the reader page should be visible
    Given the WordPress site is opened
    When the Log In button is clicked
    And the notfunx@gmail.com email address is typed into the email input field
    And the continue button is clicked
    Then the password input field should be visible
    When the test123456 password is typed into the password input field
    And the Log In button is clicked on the Log In page
    Then the Reader page should be visible

  Scenario: 4. After log in the placeholder should be visible on the blog post page
    Given the user is logged in to WordPress page
    When the My Sites button is clicked
    And the Blog Posts menu is clicked
    And the Add New Post button is clicked
    Then the Edit with a Visual editor button should be visible
    And the Title placeholder should be visible true

    When the Test text is typed into the title text bar
    Then the Title placeholder should be visible false

    When the Test text is deleted from the title text bar
    Then the Title placeholder should be visible true