package com.epam.autotesting.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConnector{
    private static WebDriver driver;

    public static synchronized WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    System.setProperty("webdriver.firefox.driver", "C:\\Webdrivers\\geckodriver.exe");
                }
                case "msedge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    System.setProperty("webdriver.msedge.driver", "C:\\Webdrivers\\msedgedriver.exe");
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}