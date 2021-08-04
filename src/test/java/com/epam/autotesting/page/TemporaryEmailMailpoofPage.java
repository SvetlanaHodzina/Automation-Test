package com.epam.autotesting.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TemporaryEmailMailpoofPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    public String TEMP_EMAIL_URL = "https://mailpoof.com/";

    @FindBy(xpath = "//h3[@class='page_title']")
    public WebElement headingTempEmailPage;

    @FindBy(xpath = "//div[@class='cookie_policy_close']")
    public WebElement dismissButtonPrivacyPolicy;

    @FindBy(xpath = "//input[@action='Random']")
    public WebElement buttonCreateRandomTempEmail;

    @FindBy(xpath = "//div[@action='copy']")
    public WebElement buttonCopyTempEmail;

    @FindBy(xpath = "//div[@id='mails']//div[@class='subject']")
    public WebElement buttonTempEmailInbox;

    @FindBy(xpath = "//tr//td[2]/h3")
    public WebElement receivedTotalEstimatedCost;

    @Override
    public TemporaryEmailMailpoofPage openPage() {
        driver.navigate().to(TEMP_EMAIL_URL);
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(headingTempEmailPage));
        return this;
    }

    public TemporaryEmailMailpoofPage dismissPrivacyPolicy() {

        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(dismissButtonPrivacyPolicy));
        dismissButtonPrivacyPolicy.click();
        logger.info("PrivacyPolicy is dismissed");
        return this;
    }
    public TemporaryEmailMailpoofPage createRandomEmailAddress() {
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("scroll(0, 250)");
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonCreateRandomTempEmail));
        buttonCreateRandomTempEmail.click();
        logger.info("Free temporary email address is random created");
        return this;
    }

    public TemporaryEmailMailpoofPage copyRandomEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonCopyTempEmail)).click();
        return this;
    }

    public String getInboxTotalEstimatedMonthlyCost() {
        new WebDriverWait(driver, Duration.ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonTempEmailInbox));
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        buttonTempEmailInbox.click();
        String inboxTotalEstimatedMonthlyCost = receivedTotalEstimatedCost.getAttribute("innerText");
        logger.info("Inbox Total Estimated Monthly Cost is  " + inboxTotalEstimatedMonthlyCost);
        return inboxTotalEstimatedMonthlyCost;
    }
}
