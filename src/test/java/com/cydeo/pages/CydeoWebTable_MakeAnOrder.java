package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CydeoWebTable_MakeAnOrder extends CydeoWebTable_BasePage{

    public CydeoWebTable_MakeAnOrder(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(name = "product")
    public WebElement productDropDown;
    @FindBy(name = "quantity")
    public WebElement quantity;
    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement street;

    @FindBy(name = "city")
    public WebElement city;

    @FindBy(name = "state")
    public WebElement state;

    @FindBy(name = "zip")
    public WebElement zip;
    @FindBy(xpath ="//label/input")
    public List<WebElement> cardTypes;

    @FindBy(name = "cardNo")
    public WebElement cardNumber;

    @FindBy(name = "cardExp")
    public WebElement expireDate;

    @FindBy(xpath ="//button[.='Process Order']")
    public WebElement processOrderButton;


}
