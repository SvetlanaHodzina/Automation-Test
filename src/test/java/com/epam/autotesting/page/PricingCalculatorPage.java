package com.epam.autotesting.page;

import com.epam.autotesting.model.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;

public class PricingCalculatorPage extends AbstractPage {
    
    private final Logger logger = (Logger) LogManager.getRootLogger();

    public final String OUTER_FRAME_XPATH = "//html//body//div[@id='maia-main']";
    public final String PAGE_TITLE_XPATH = "//html//body//div//h2[text()='Google Cloud Pricing Calculator']";
    public final String NUMBER_INSTANCES_XPATH = "//input[@id='input_74']";
    public final String MENU_BUTTON_OS_XPATH = "//md-select-value[@id='select_value_label_66']";
    public final String OS_ELEMENT_XPATH = "//md-option[@id='select_option_76']";
    public final String MENU_BUTTON_VMCLASS_XPATH = "//md-select[@id='select_91']";
    public final String VM_CLASS_ELEMENT_XPATH = "//md-option[@id='select_option_89']//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_SERIES_XPATH = "//md-select[@id='select_99']";
    public final String SERIES_ELEMENT_XPATH = "//md-option[@id='select_option_214']//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_MACHINETYPE_XPATH = "//md-select[@id='select_101']";
    public final String MACHINETYPE_ELEMENT_XPATH = "//md-option[@id='select_option_417']//div[contains(text(),'%s')]";
    public final String CHECKBOX_ADDGPU_ELEMENT_XPATH = "//md-checkbox[contains(@aria-label,'Add GPUs') " +
            "and contains(@ng-model,'listingCtrl.computeServer.addGPUs')]";
    public final String MENU_BUTTON_NUMBER_GPU_XPATH = "//md-select-value[@id='select_value_label_449']/span";
    public final String NUMBER_GPU_ELEMENT_XPATH = "//div[@id='select_container_452']//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_TYPE_GPU_XPATH = "//md-select-value[@id='select_value_label_450']";
    public final String TYPE_GPU_ELEMENT_XPATH = "//div[@id='select_container_454']//md-option//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_LOCAL_SSD_XPATH = "//md-select-value[@id='select_value_label_411']";
    public final String LOCAL_SSD_ELEMENT_XPATH = "//div[@id='select_container_413']//md-option//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_LOCATION_XPATH = "//md-select-value[@id='select_value_label_72']";
    public final String LOCATION_ELEMENT_XPATH = "//div[@id='select_container_108']//md-option//div[contains(text(),'%s')]";
    public final String MENU_BUTTON_USAGE_XPATH = "//md-select-value[@id='select_value_label_73']";
    public final String USAGE_ELEMENT_XPATH = "//div[@id='select_container_115']//md-option//div[contains(text(),'%s')]";

    @FindBy(xpath = "//main[@class='devsite-main-content']")
    private WebElement openedSite;

    @FindBy(xpath = "//h2[@class ='md-title']/b")
    private WebElement calculatedTotalEstimatedCost;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//button[@ng-click='cloudCartCtrl.showEmailForm();']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@id='input_534']")
    private WebElement inputEmailAddress;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    @Override
    public PricingCalculatorPage openPage() {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(openedSite));
        return this;
    }

    public PricingCalculatorPage goToIframe() {
        int outerFrameSize = driver.findElements(By.tagName("iframe")).size();
        logger.info("Total number of outer iframes is: " + outerFrameSize);
        driver.switchTo().frame(0);
        logger.info("You are switched to the required outer iframe.");
        String outerFrame = driver.findElement(xpath(OUTER_FRAME_XPATH)).getAttribute("id");
        logger.info("Title of the required outer iframe is:  " + outerFrame);

        int innerFrameSize = driver.findElements(By.tagName("iframe")).size();
        logger.info("Number of inner iframes inside the outer one: " + innerFrameSize);
        driver.switchTo().frame("myFrame");
        logger.info("You are switched to the required inner iframe #myFrame.");
        String title = driver.findElement(xpath(PAGE_TITLE_XPATH)).getAttribute("innerText");
        logger.info("Title of the page is: " + title);
        return this;
    }

    public PricingCalculatorPage quitIframe() {
        driver.switchTo().defaultContent();
        return this;
    }

    public PricingCalculatorPage inputNumberOfInstances(String instances) {
        WebElement numberOfInstances = driver.findElement(xpath(NUMBER_INSTANCES_XPATH));
        numberOfInstances.click();
        numberOfInstances.sendKeys(instances);
        logger.info("Number of instances: " + numberOfInstances.getAttribute("value"));
        return this;
    }

    public PricingCalculatorPage inputOS(String os) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_OS_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath(String.format(OS_ELEMENT_XPATH, os)))).click();
        logger.info("Operating system is " + os);
        return this;
    }

    public PricingCalculatorPage inputVMClass(String vmClass) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath(MENU_BUTTON_VMCLASS_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath
                        (String.format(VM_CLASS_ELEMENT_XPATH, vmClass)))).click();
        logger.info("Virtual machine Class is " + vmClass);
        return this;
    }

    public PricingCalculatorPage inputSeries(String series) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath(MENU_BUTTON_SERIES_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath
                        (String.format(SERIES_ELEMENT_XPATH, series)))).click();
        logger.info("Series is " + series);
        return this;
    }

    public PricingCalculatorPage inputMachineType(String machineType) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath(MENU_BUTTON_MACHINETYPE_XPATH))).click();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement machineTYPE = driver.findElement((xpath(String.format(MACHINETYPE_ELEMENT_XPATH, machineType))));
        je.executeScript("arguments[0].scrollIntoView(true);", machineTYPE);
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(machineTYPE)).click();
        logger.info("Machine type is " + machineType);
        return this;
    }

    public PricingCalculatorPage addGPU() {
        WebElement checkboxAddGPUs = driver.findElement((xpath(CHECKBOX_ADDGPU_ELEMENT_XPATH)));
        checkboxAddGPUs.click();
        logger.info("GPU is added");
        return this;
    }

    public PricingCalculatorPage inputNumberOfGPUs(String numberGPU) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_NUMBER_GPU_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(NUMBER_GPU_ELEMENT_XPATH, numberGPU)))).click();
        logger.info("Number of GPUs is " + numberGPU);
        return this;
    }

    public PricingCalculatorPage inputTypeOfGPUs(String typeGPU) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_TYPE_GPU_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(String.format(TYPE_GPU_ELEMENT_XPATH, typeGPU)))).click();
        logger.info("Type of GPUs is " + typeGPU);
        return this;
    }

    public PricingCalculatorPage inputLocalSSD(String localSSD) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_LOCAL_SSD_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(String.format(LOCAL_SSD_ELEMENT_XPATH, localSSD)))).click();
        logger.info("Local SSD is " + localSSD);
        return this;
    }

    public PricingCalculatorPage inputDataCentreLocation(String dataCentreLocation) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_LOCATION_XPATH))).click();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement location = driver.findElement(xpath(String.format(LOCATION_ELEMENT_XPATH, dataCentreLocation)));
        je.executeScript("arguments[0].scrollIntoView(true);", location);
        location.click();
        logger.info("Datacentre location is " + dataCentreLocation);
        return this;
    }

    public PricingCalculatorPage inputCommittedUsage(String usage) {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(xpath(MENU_BUTTON_USAGE_XPATH))).click();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath(String.format(USAGE_ELEMENT_XPATH, usage)))).click();
        logger.info("Committed usage is " + usage);
        return this;
    }

    public PricingCalculatorPage calculateTotalEstimationMonthlyCost(Computer engine) {
        goToIframe();
        inputNumberOfInstances(engine.getInstances());
        inputOS(engine.getOs());
        inputVMClass(engine.getVmClass());
        inputSeries(engine.getSeries());
        inputMachineType(engine.getMachineType());
        quitIframe();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");

        goToIframe();
        addGPU();
        inputLocalSSD(engine.getLocalSSD());
        inputDataCentreLocation(engine.getDataCentreLocation());
        inputNumberOfGPUs(engine.getNumberGPU());
        inputTypeOfGPUs(engine.getTypeGPU());
        inputCommittedUsage(engine.getUsage());
        buttonAddToEstimate.click();
        logger.info("Total Estimated Cost has been calculated");
        return this;
    }

    public String getAmountOfTheCalculatedCost() {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(calculatedTotalEstimatedCost));
        logger.info("Calculated Total Estimated Cost is " + calculatedTotalEstimatedCost.getText());
        return calculatedTotalEstimatedCost.getText();
    }

    public PricingCalculatorPage emailEstimate() {
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(buttonEmailEstimate));
        buttonEmailEstimate.click();
        quitIframe();
        return this;
    }

    public PricingCalculatorPage sendEmailForEstimationCost() {
        JavascriptExecutor jem = (JavascriptExecutor) driver;
        jem.executeScript("window.scrollBy(0,1300)", "");
        goToIframe();
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(inputEmailAddress));
        inputEmailAddress.sendKeys(Keys.CONTROL + "v");
        new WebDriverWait(driver, ofSeconds(this.WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.textToBePresentInElementValue(inputEmailAddress, ""));
        sendEmailButton.click();
        quitIframe();
        return this;
    }
}
