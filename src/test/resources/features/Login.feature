@test
Feature: Login feature of the library application

  User Story:
  As a user, I should be able to login with correct credentials to different accounts and
  dashboard should be displayed.
  Accounts are: librarian, student, admin

  Scenario: Login as librarian
    Given user am on the home page of the application
    When user enter the librarian username
    And user enter the librarian password
    Then user should see the dashboard

    @student
    Scenario: Login as student
      Given user am on the home page of the application
      When user enter the student username
      And user enter the student password
      Then user should see the dashboard

      Scenario:Login as admin
        Given user am on the home page of the application
      When user enter the admin username
      And user enter the admin password
      Then user should see the dashboard

