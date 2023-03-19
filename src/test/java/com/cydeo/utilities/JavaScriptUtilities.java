package com.cydeo.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class JavaScriptUtilities {

    //this method flash the selected elements background color at the amount given in the loop
    //the desired color will be get through changeColor() method


    public static void flash(WebElement element, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String bgColor = element.getCssValue(("backgroundColor"));
        for(int i =0; i<50; i++){
            changeColor("#FFFF00",element,driver); //FFFF00 code for yellow
            changeColor(bgColor, element,driver);
        }

    }
    //this method will change the background color of any element
    public static void changeColor(String color, WebElement element,WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = '"+ color +"'",element);

        try{
            Thread.sleep(20);
        }catch(InterruptedException e){

        }
    }

    //This method will draw a border with the desired color and thickness around any WebElement
    public static void drawBorder(WebElement element, WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'",element);
    }

    //This method will draw a border and screenshot of the web page
    public static void drawBorderAndShot(WebElement element, WebDriver driver) {

        drawBorder(element,driver);
        File src = ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File("C://screenshot/1.png");
        try {
            FileUtils.copyFile(src,target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //This method will get the title of the page using JS
    public static String getTitleByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript(("return document.title;")).toString();
        return title;
    }

    //this method will click the element by JS
    public static void click(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);

    }

    //this method will create an alert
    public static void generateAlert(WebDriver driver, String message){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('"+ message+"')");
    }

    //This method will refresh the page with JS
    public static void refreshByJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("history.go(0)");

    }

    //This method will scroll down the page till we find the element
    public static void scrollIntoView(WebElement element,WebDriver driver){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * This method will scroll the page all the way down
     * @param driver
     */
    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
}
