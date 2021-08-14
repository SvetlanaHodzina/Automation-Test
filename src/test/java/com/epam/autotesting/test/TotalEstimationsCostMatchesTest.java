package com.epam.autotesting.test;

import com.epam.autotesting.model.Computer;
import com.epam.autotesting.page.MainCloudGooglePage;
import com.epam.autotesting.page.PricingCalculatorPage;
import com.epam.autotesting.page.TemporaryEmailMailpoofPage;
import com.epam.autotesting.service.ComputerRenter;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TotalEstimationsCostMatchesTest extends RequiredConditions {

    @Test(description = "Verifies the equalness of the total estimated " +
            "monthly cost - by pricing calculator and the one emailed")
    public void verifyEqualityOfTotalEstimatedMonthlyCosts() {

        Computer engine = ComputerRenter.withCredentialsFromProperty();

        new MainCloudGooglePage()
                .openPage()
                .searchForPricingCalculatorLink()
                .linkToPricingCalculatorLink();
        String calculatedTotalEstimatedMonthlyCost = new PricingCalculatorPage()
                .calculateTotalEstimationMonthlyCost(engine).getAmountOfTheCalculatedCost();
        new PricingCalculatorPage().emailEstimate();

        String tab1 = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        TemporaryEmailMailpoofPage email = new TemporaryEmailMailpoofPage()
                .openPage()
                .dismissPrivacyPolicy()
                .createRandomEmailAddress()
                .copyRandomEmail();
        String tab2 = driver.getWindowHandle();

        driver.switchTo().window(tab1);
        new PricingCalculatorPage().sendEmailForEstimationCost();

        driver.switchTo().window(tab2);
        String inboxTotalEstimatedMonthlyCost = email.getInboxTotalEstimatedMonthlyCost();

        assertThat(calculatedTotalEstimatedMonthlyCost, containsString(inboxTotalEstimatedMonthlyCost));
    }
}
