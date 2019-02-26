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
    And the Continue button is clicked
    Then the password input field should be visible
    When the test123456 password is typed into the password input field
    And the Log In button is clicked on the Log In page
    Then the Reader page should be visible

  Scenario: 4. After log in the title text should be visible on the blog post page
  when the title text bar is cleared the text shouldn't be visible
    Given the user is logged in to WordPress page
    When the My Sites button is clicked
    And the Blog Posts menu is clicked
    And the Add New Post button is clicked
    Then the Edit with a Visual editor button should be visible

    When the Test text is typed into the title text bar
    Then the Test text should be visible

    When the text bar is cleared
    Then the Test text should be hidden

  Scenario: 5. The Add drop down button's elements should be visible
    Given the user is logged in to WordPress page
    When the My Sites button is clicked
    And the Blog Posts menu is clicked
    And the Add New Post button is clicked
    And the Edit with a visual editor button is clicked
    Then the Add button should be visible

    When the Add dropdown is clicked
    Then the following buttons should be visible: span
      | Media              |
      | Media from Google  |
      | Free photo library |
      | Contact form       |
      | Payment button     |

  Scenario Outline: 6. The popup should be visible after the Add dropdown elements are clicked
    Given the user is logged in to WordPress page
    When the My Sites button is clicked
    And the Blog Posts menu is clicked
    And the Add New Post button is clicked
    Then the Add button should be visible

    When the Add dropdown is clicked
    And the <button> dropdown button is clicked
    Then the popup window should be visible
    And the Cancel button should be visible
    And the Insert button should be visible
    And the Media library dropdown button should be visible
    And the Insert button should be disabled
    And the Cancel button should be enabled


    When the Media library dropdown is clicked
    Then the following buttons should be visible: button
      | WordPress library               |
      | Photos from your Google library |
      | Free photo library              |

    Examples:
      | button             |
      | Media              |
      | Media from Google  |
      | Free photo library |