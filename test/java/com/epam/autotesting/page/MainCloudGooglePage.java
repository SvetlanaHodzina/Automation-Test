package com.epam.autotesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainCloudGooglePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    final String CLOUD_URL = "https://cloud.google.com/";
    final String INFO_SEARCH = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//body[@class='cws-page-devsite']")
    public static WebElement mainPageContent;

    @FindBy(xpath = "//input[contains(@name,'q')]")
    public static WebElement searchInput;

    @Override
    public MainCloudGooglePage openPage() {
        driver.navigate().to(CLOUD_URL);
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(mainPageContent));
        logger.info("Main cloud google page is loaded");
        return this;
    }

    public SearchResultsCloudGooglePage searchForPricingCalculatorLink() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(searchInput)).click();
        searchInput.sendKeys(INFO_SEARCH + Keys.ENTER);
        return new SearchResultsCloudGooglePage();
    }
}