package hardcore.page;

import hardcore.model.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage extends AbstractPage{
    private final String INSTANCE_XPATH = "//iframe[contains (@name, 'goog_')]";
    private final String DROPDOWN_SOFTWARE_XPATH = "//div[contains (@class, 'md-select-menu-container md-active')]//div[contains (text(), '%s')]//ancestor::md-option";
    private final String DROPDOWN_MACHINE_CLASS_XPATH = "//md-option[contains (@id, 'select_option_79')]//div[contains (text(), '%s')]//ancestor::md-option";
    private final String DROPDOWN_MACHINE_TYPE_XPATH = "//div[contains (text(), '%s')]//ancestor::md-option";
    private final String DROPDOWN_LOCATION_XPATH = "//md-option[contains (@id, 'select_option_211')]//div[contains (text(), '%s')]//ancestor::md-option";
    private final String DROPDOWN_COMMITTED_USAGE_XPATH = "//md-option[contains (@id, 'select_option_98')]//div[contains (text(), '%s')]//ancestor::md-option";

    @FindBy(xpath = "//div[@title='Compute Engine']//div[@class='hexagon-in2']")
    private WebElement computeEngine;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_58']")
    private WebElement softwareOptions;

    @FindBy(xpath = "//*[@id='select_value_label_59']")
    private WebElement machineClassOptions;

    @FindBy(xpath = "//*[@id='select_value_label_62']")
    private WebElement machineTypeOptions;

    @FindBy(xpath = "//*[@id='select_value_label_63']")
    private WebElement locationOptions;

    @FindBy(xpath = "//*[@id='select_value_label_64']")
    private WebElement committedUsageOptions;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage clickComputeEngine() {
        computeEngine.click();
        return this;
    }

        public CalculatorPage setNumberOfInstances (TestData testData){
            WebElement instances = driver.findElement(By.xpath("//input[@id='input_65']"));
            instances.sendKeys(testData.getInstances());
            return this;
        }

        public CalculatorPage setSoftware (TestData testData){
            By xpath = By.xpath(String.format(DROPDOWN_SOFTWARE_XPATH, testData.getSoftware()));
            softwareOptions.click();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
            return this;
        }

        public CalculatorPage setMachineClass(TestData testData){
            By xpath = By.xpath(String.format(DROPDOWN_MACHINE_CLASS_XPATH, testData.getMachineClass()));
            machineClassOptions.click();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
            return this;
        }

        public CalculatorPage setMachineType(TestData testData){
            By xpath = By.xpath(String.format(DROPDOWN_MACHINE_TYPE_XPATH, testData.getMachineType()));
            machineTypeOptions.click();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
            return this;
        }

        public CalculatorPage addSustainedUseDiscounts(){
            List<WebElement> SustainedUseDiscounts = driver.findElements(By.xpath("//div[@class='md-container md-ink-ripple']"));
            SustainedUseDiscounts.get(0).click();
            return this;
        }

        public CalculatorPage setLocation(TestData testData) {
            By xpath = By.xpath(String.format(DROPDOWN_LOCATION_XPATH, testData.getLocation()));
            locationOptions.click();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
            return this;
        }

        public CalculatorPage setCommittedUsage(TestData testData){
            By xpath = By.xpath(String.format(DROPDOWN_COMMITTED_USAGE_XPATH, testData.getCommittedUsage()));
            committedUsageOptions.click();
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(xpath)).click();
            return this;
        }

        public CalculatorPage addToEstimate(){
            List<WebElement> estimate = driver.findElements(By.xpath("//button[contains (text(), 'Add to Estimate')]"));
            estimate.get(0).click();
            return this;
        }

        public CalculatorPage emailEstimate(){
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='email_quote']"))).click();
            return this;
        }

        public CalculatorPage switchToFrame(){
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(INSTANCE_XPATH)));
            driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

        public CalculatorPage typeMailAddress(String emailAddress) {
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
            driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailAddress);
            return this;
        }

        public CalculatorPage sendEmail(){
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Send Email']"))).click();
            return this;
        }

        public String getTotalCostFromCalculatorPage(){
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains (text(), 'Total Estimated Cost')]")));
            String totalEstimatedCost = driver.findElement(By.xpath("//b[contains (text(), 'Total Estimated Cost')]")).getText();
            return totalEstimatedCost;
        }
    }

