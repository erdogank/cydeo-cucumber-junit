package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Drivertemp {

    //Creating a private constructor, so we are closing
    //access to the object of this class from outside the class
    private Drivertemp() {
    }

    //We make WebDriver private, because we want to close access from outside the class.
    //We make it static because we will use it in a static method.
    //private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get() == null){

            //we will get our browser type value from config.properties file
            //we will use this value in the switch statement below:
            String browserType = ConfigurationReader.getProperty("browser");

            switch(browserType.toLowerCase()){

                case "chrome":

                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set( new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;


            }
        }
        return driverPool.get();


    }

    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit();//this line will terminate the existing session. the value will not even be null
            driverPool.remove();
        }
    }
}
