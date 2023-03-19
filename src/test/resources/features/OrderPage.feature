Feature: verification of new orders in the Cydeo Web Tables Program


  Scenario: Order Place Verification of Cydeo Web Tables Program

    Given user is logged in to web table app with the user name and password

    When user enters Order page
    And user selects "MoneyCog" from Product dropdown menu
    And user enters "2" as quantity
    And user types "Muhtar Mahmoud" as Customer name
    And user enter "Third" to the Street field
    And user enter "Arlington" as City name
    And user enters "VA" as State name
    And user enters "22202" as Zip code
    And user selects card type as "Visa"
    And user enters Card number Card Number
    And user enters Expire Date "04/25"
    And user clicks Process Order
    Then user should see new order in the table on View all orders page "Muhtar Mahmoud"


  Scenario Outline: Order Place Verification of Cydeo Web Tables Program


    Given user is logged in to web table app with the user name and password

    When user enters Order page
    And user selects "<Product>" from Product dropdown menu
    And user enters "<Quantity>" as quantity
    And user types "<Name>" as Customer name
    And user enter "<Street>" to the Street field
    And user enter "<City>" as City name
    And user enters "<State>" as State name
    And user enters "<Zip>" as Zip code
    And user selects card type as "<Card>"
    And user enters Card number Card Number
    And user enters Expire Date "<ExpDate>"
    And user clicks Process Order
    Then user should see new order in the table on View all orders page "<ExpectedResult>"
    @sampletable
    Examples:

      | Name           | Product   | Quantity | Street        | City      | State | Zip   | Card       | ExpDate | ExpectedResult |
      | Muhtar Mahmoud | MoneyCog  | 2        | Miller Street | Arlington | VA    | 22202 | Visa       | 22/25   | Muhtar Mahmoud |
      | Adam           | Familybea | 3        | Miller Street | Arlington | VA    | 22203 | Visa       | 17/28   | Adam           |
      | Erdogan        | MoneyCog  | 3        | South Ball    | Arlington | VA    | 22202 | MasterCard | 19/29   | Erdogan        |
