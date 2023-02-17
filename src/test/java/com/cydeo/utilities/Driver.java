package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Creating a private constructor, so we are closing
    //access to the object of this class from outside the class
    private Driver() {
    }

    //We make WebDriver private, because we want to close access from outside the class.
    //We make it static because we will use it in a static method.
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            //we will get our browser type value from config.properties file
            //we will use this value in the switch statement below:
            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType.toLowerCase()){

                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }
        }
        return driver;


    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();//this line will terminate the existing session. the value will not even be null
            driver=null;
        }
    }
}
