package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaPages {

    public WikipediaPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "searchInput")
   public WebElement searchBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;
    @FindBy(css = "span.mw-page-title-main")
    public WebElement wikiHeader;
    @FindBy(xpath = "(//tr/td/a)[1]")
    public WebElement wikiPic;
    @FindBy(css = "div.fn")
    public WebElement wikiPicText;




}
