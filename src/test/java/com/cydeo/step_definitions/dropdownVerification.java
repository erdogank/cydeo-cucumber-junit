package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoDropdownPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class dropdownVerification {

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cydeo.com/dropdown");
    }
    @Then("User should be able to see below info in month dropdown")
    public void user_should_be_able_to_see_below_info_in_month_dropdown(List<String> months) {
        CydeoDropdownPage cydeoDropdownPage = new CydeoDropdownPage();

        Select selectMonths = new Select(cydeoDropdownPage.monthsDropdown);
        List<WebElement> actualMonths = selectMonths.getOptions();
        List<String> actualMontslist= new ArrayList<>();
        for (WebElement each : actualMonths) {
            actualMontslist.add(each.getText());

        }

        //we cannot modify given arraylist so I made a copy of it to sort
        List<String> copyOfExpected =new ArrayList<>(months);
        //sorted copyof given list and expected list to compare if they have the same elements
        Collections.sort(copyOfExpected);
        Collections.sort(actualMontslist);

       // System.out.println(months);

        //Assert.assertEquals(months,actualMonths);
        //System.out.println(actualMontslist);
        //Assert.assertTrue(actualMontslist.equals(months));
        Assert.assertEquals(copyOfExpected,actualMontslist);


    }

}
