package com.epam.autotesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsCloudGooglePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//h1[@class='devsite-search-title']")
    public static WebElement searchResults;

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement pricingCalculatorLink;

    @Override
    public SearchResultsCloudGooglePage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchResults));
        logger.info("You are in the 'Search results' Page");
        return this;
    }

    public PricingCalculatorPage linkToPricingCalculatorLink() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pricingCalculatorLink)).click();
        logger.info("You are linked to 'Pricing Calculator Page'");
        return new PricingCalculatorPage();
    }
}