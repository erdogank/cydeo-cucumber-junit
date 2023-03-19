Feature: Examples of cucumber data table implementation

@datatable
  Scenario: list of fruits I like
    Then user should see fruits I like

      | kiwi      | 1 |
      | banana    | 2 |
      | cucumber  | 4 |
      | orange    | 3 |
      | mango     | 6 |
      | grape     | 5 |
      | tangerine | 7 |
    #ctrl+alt+l to line up

