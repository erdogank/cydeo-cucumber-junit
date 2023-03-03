package com.cydeo.pages;

import com.cydeo.utilities.Drivertemp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoWebTable_Login {

    public CydeoWebTable_Login(){
        PageFactory.initElements(Drivertemp.getDriver(),this);
    }
    @FindBy(name = "username")
    public WebElement nameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button")
    public WebElement loginButton;


}
