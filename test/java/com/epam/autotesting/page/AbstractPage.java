package com.epam.autotesting.page;

import com.epam.autotesting.driver.WebDriverConnector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage{

    protected WebDriver driver;

    public final int WAIT_TIMEOUT_SECONDS = 50;
    protected abstract AbstractPage openPage();

    protected AbstractPage()
    {
        driver = WebDriverConnector.getDriver();
        PageFactory.initElements(driver, this);
    }
}