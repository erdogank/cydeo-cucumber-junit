package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    static String browser;

    //Creating a private constructor, so we are closing
    //access to the object of this class from outside the class
    private Driver() {
    }

    //We make WebDriver private, because we want to close access from outside the class.
    //We make it static because we will use it in a static method.
    //private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get() == null){
            if (System.getProperty("BROWSER") == null){
                browser = ConfigurationReader.getProperty("browser");

            }else{
                browser = System.getProperty("BROWSER");
            }
            System.out.println(browser);

            //we will get our browser type value from config.properties file
            //we will use this value in the switch statement below:
            //String browserType = ConfigurationReader.getProperty("browser");

            switch(browser.toLowerCase()){

                case "remote-chrome":
                    try {
                        // assign your grid server address
                        String gridAddress = "54.210.192.221";
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

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
