Feature: Login feature of the web table application.

  Scenario: Login function of WebTable app
  Given User is on the login page of Web table app
  When  User enters below credentials
    | username | Test |
    | password | Tester |
  Then  User should see url contains "orders"



