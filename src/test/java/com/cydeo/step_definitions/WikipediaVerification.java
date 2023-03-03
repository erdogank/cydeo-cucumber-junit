package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaPages;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikipediaVerification {
    WikipediaPages wikipediaPages = new WikipediaPages();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");

    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {

        wikipediaPages.searchBox.sendKeys(string);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaPages.searchButton.click();

    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));

    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String string) {

        Assert.assertEquals(string,wikipediaPages.wikiHeader.getText());

    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String string) {
    Assert.assertTrue(wikipediaPages.wikiPic.isDisplayed());
    Assert.assertEquals(string,wikipediaPages.wikiPicText.getText());
    }
}
