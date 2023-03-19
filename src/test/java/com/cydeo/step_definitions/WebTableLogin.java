package com.cydeo.step_definitions;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLogin {

    com.cydeo.pages.WebTableLogin webTableLogin = new com.cydeo.pages.WebTableLogin();

    @Given("User is on the login page of Web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> data) {

        webTableLogin.userName.sendKeys(data.get("username"));
        webTableLogin.password.sendKeys(data.get("password"));
        BrowserUtils.waitFor(3);
        webTableLogin.loginButton.click();



    }
    @Then("User should see url contains {string}")
    public void user_should_see_url_contains(String string) {

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(string));

    }
}
