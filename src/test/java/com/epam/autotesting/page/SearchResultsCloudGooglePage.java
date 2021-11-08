package com.epam.autotesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsCloudGooglePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//h1[@class='devsite-search-title']")
    public static WebElement searchResults;

    @FindBy(xpath = "//b[text()='Google Cloud Platform Pricing Calculator']")
    WebElement pricingCalculatorLink;

    @FindBy(xpath = "//a[@href='https://cloud.google.com/products/calculator?hl=en']")
    WebElement pricingCalculatorHrefLink;

    @Override
    public SearchResultsCloudGooglePage openPage() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(searchResults));
        logger.info("You are in the 'Search results' Page");
        return this;
    }

    public PricingCalculatorPage linkToPricingCalculatorLink() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(pricingCalculatorLink));
        if (driver.findElement(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']")).isEnabled()) {
            new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(pricingCalculatorLink)).click();
        } else if (driver.findElement(By.xpath("//a[@href='https://cloud.google.com/products/calculator?hl=en']")).isEnabled()) {
            new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(pricingCalculatorHrefLink)).click();
        }
        logger.info("You are linked to 'Pricing Calculator Page'");
        return new PricingCalculatorPage();
    }
}
