package com.cydeo.pages;

import com.cydeo.utilities.Drivertemp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoDropdownPage {

    public CydeoDropdownPage(){
        PageFactory.initElements(Drivertemp.getDriver(),this);
    }
    @FindBy(id = "month")
    public WebElement monthsDropdown;



}
