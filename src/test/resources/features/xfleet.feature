Feature: All users should be able to log in

  Background:
    Given The user is on the log in page

  Scenario Outline: All users should log in with valid credentials
    When user types his, her "<username>"
    And user types his, her "<password>"
    And user clicks Log In button
    Then user should be on his, her own "<homepage>"

    Examples: Valid username and password combinations:

      | userName        | passWord    | homePage        |
      | user1           | UserUser123 | Quick Launchpad |
      | user2           | UserUser123 | Quick Launchpad |
      | user3           | UserUser123 | Quick Launchpad |
      | storemanager51  | UserUser123 | Dashboard       |
      | storemanager52  | UserUser123 | Dashboard       |
      | storemanager53  | UserUser123 | Dashboard       |
      | salesmanager101 | UserUser123 | Dashboard       |
      | salesmanager102 | UserUser123 | Dashboard       |
      | salesmanager103 | UserUser123 | Dashboard       |




