Feature: verification of new orders in the Cydeo Web Tables Program

  Scenario: Order Place Verification of Cydeo Web Tables Program

    Given user is on the Order page
    When user enters enters appropriate test data
    And user cick to Process Order
    Then user should see new order in the table on View all orders page
