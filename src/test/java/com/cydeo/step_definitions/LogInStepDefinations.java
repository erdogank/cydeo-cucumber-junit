package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepDefinations {

    @Given("user am on the home page of the application")
    public void user_am_on_the_home_page_of_the_application() {
        System.out.println("user is on the homepage");
    }
    @When("user enter the librarian username")
    public void user_enter_the_librarian_username() {
        System.out.println("user enters the librarian username");
    }
    @When("user enter the librarian password")
    public void user_enter_the_librarian_password() {
        System.out.println("user enters the librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("user now on the dashboard");
    }


    @When("user enter the student username")
    public void user_enter_the_student_username() {
        System.out.println("user enters student username");
    }
    @When("user enter the student password")
    public void user_enter_the_student_password() {
        System.out.println("user enters student password");
    }



    @When("user enter the admin username")
    public void user_enter_the_admin_username() {
        System.out.println("user enters admin username");
    }
    @When("user enter the admin password")
    public void user_enter_the_admin_password() {
        System.out.println("user enters admin password");
    }




}
