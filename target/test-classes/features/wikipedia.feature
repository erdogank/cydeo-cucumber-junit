@smoke
Feature: Wikipedia Search Functionality Title Verification
  user should see certain title and header when he/she searches a keyword on wikipedia


  Scenario: Title verification of wikipedia

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title


  Scenario: Wikipedia Search Functionality Header Verification

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification

    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  @scenariOutline
  Scenario Outline: Wikipedia Search Functionality Title Verification

    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedHeader>" is in the image header

    Examples: search values for this scenario are as follows:

      | searchValue  | expectedTitle | expectedHeader |
      | Steve Jobs   | Steve Jobs    | Steve Jobs     |
      | Bob Marley   | Bob Marley    | Bob Marley     |
      | Marie Curie  | Marie Curie   | Marie Curie    |
      | Chuck Norris | Chuck Norris  | Chuck Norris   |
      | Lady Gaga    | Lady Gaga     | Lady Gaga      |




