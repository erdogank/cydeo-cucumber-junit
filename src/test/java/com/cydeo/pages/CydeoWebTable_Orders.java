package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoWebTable_Orders extends CydeoWebTable_BasePage{

    public CydeoWebTable_Orders(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//tr[1]/td[1]")
    public WebElement orderListFirstRowName;
}
