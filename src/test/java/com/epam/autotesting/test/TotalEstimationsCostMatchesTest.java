package com.epam.autotesting.test;

import com.epam.autotesting.page.MainCloudGooglePage;
import com.epam.autotesting.page.PricingCalculatorPage;
import com.epam.autotesting.page.SearchResultsCloudGooglePage;
import com.epam.autotesting.page.TemporaryEmailMailpoofPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TotalEstimationsCostMatchesTest extends RequiredConditions {

    @Test(description = "Verifies the equalness of the total estimated " +
            "monthly cost - by pricing calculator and the one emailed")
    public void verifyEqualityOfTotalEstimatedMonthlyCosts() {

        MainCloudGooglePage search = new MainCloudGooglePage().openPage();
        search.searchForPricingCalculatorLink();
        new SearchResultsCloudGooglePage().linkToPricingCalculatorLink();
        PricingCalculatorPage pricePage = new PricingCalculatorPage();
        pricePage.calculateTotalEstimationMonthlyCost();
        String calculatedTotalEstimatedMonthlyCost = pricePage.getAmountOfTheCalculatedCost();
        pricePage.emailEstimate();

        JavascriptExecutor jem = (JavascriptExecutor) driver;
        jem.executeScript("window.scrollBy(0,1300)", "");
        String tab1 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        TemporaryEmailMailpoofPage email = new TemporaryEmailMailpoofPage()
                .openPage();
        email.dismissPrivacyPolicy();
        email.createRandomEmailAddress();
        email.copyRandomEmail();
        String tab2 = driver.getWindowHandle();

        driver.switchTo().window(tab1);
        pricePage.sendEmailForEstimationCost();

        driver.switchTo().window(tab2);
        String inboxTotalEstimatedMonthlyCost = new TemporaryEmailMailpoofPage()
                .getInboxTotalEstimatedMonthlyCost();
        int inboxLength = inboxTotalEstimatedMonthlyCost.length();
        boolean totalEstimationsCostMatchesTest = calculatedTotalEstimatedMonthlyCost
                .regionMatches(true, 22, inboxTotalEstimatedMonthlyCost, 0, inboxLength);

        assertThat(totalEstimationsCostMatchesTest, is(equalTo(true)));
    }
}