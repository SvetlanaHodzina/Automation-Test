package com.epam.autotesting.test;

import com.epam.autotesting.model.Computer;
import com.epam.autotesting.page.MainCloudGooglePage;
import com.epam.autotesting.page.PricingCalculatorPage;
import com.epam.autotesting.service.ComputerRenter;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CalculatingTotalEstimationCostTest extends RequiredConditions {

    @Test(description = "Verifies getting total estimated monthly cost of the product by pricing calculator")
    public void verifyCalculatedTotalEstimationMonthlyCost() {

        Computer engine = ComputerRenter.withCredentialsFromProperty();

        new MainCloudGooglePage()
                .openPage()
                .searchForPricingCalculatorLink()
                .linkToPricingCalculatorLink();
        String calculatedTotalEstimatedMonthlyCost = new PricingCalculatorPage()
                .calculateTotalEstimationMonthlyCost(engine).getAmountOfTheCalculatedCost();

        assertThat(calculatedTotalEstimatedMonthlyCost, containsString("USD"));
    }
}