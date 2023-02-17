package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class BrowserUtils {

    //This method will switch to the given URL and verify if the  title contains given String
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> WindowIds = driver.getWindowHandles();

        for (String eachWindowId : WindowIds) {

            driver.switchTo().window(eachWindowId);
            if(driver.getCurrentUrl().equals(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));



    }

    //This method will log in the crm software by passing the driver
    public static void login_crm(WebDriver driver){

        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");
//        3. Enter valid username

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk1@cybertekschool.com");
//        4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys("UserUser");
//        5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
//        6. Verify title is as expected:
        //Assert.assertTrue(Driver.getDriver().getTitle().equals("Portal"), "title test is failed. the current title is: " +"\"" + Driver.getDriver().getTitle()+"\"");
//        Expected: Portal

    }

    //This method will log in the crm software by passing the driver, username and password
    public static void login_crm(WebDriver driver, String username, String password){

        // 2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");
//        3. Enter valid username

        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys(username);
//        4. Enter valid password
        driver.findElement(By.xpath("//input[@name='USER_PASSWORD']")).sendKeys(password);
//        5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@class='login-btn']")).click();
//        6. Verify title is as expected:
        //Assert.assertTrue(driver.getTitle().equals("Portal"), "title test is failed. the current title is: " +"\"" + driver.getTitle()+"\"");
//        Expected: Portal

    }

    //this method will assert actual title with the expected title. driver and expected title passes
    public static void verifyTitle(WebDriver driver, String expectedTitle){


        Assert.assertEquals(driver.getTitle(),expectedTitle);



    }
}
