package hardcore.test;

import hardcore.model.TestData;
import hardcore.page.CalculatorPage;
import hardcore.page.EmailPage;
import hardcore.page.MainPage;
import hardcore.service.TestDataCreator;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

public class CalculatorTest extends AdditionalConditions{
    private final String REQUEST = "Google Cloud Platform Pricing Calculator";

    @Test (description = "My first automated test")
    public void totalCostInMailEqualsCalculatorValue() throws IOException, UnsupportedFlavorException
    {
        TestData testData = TestDataCreator.dropdownOptions();
        CalculatorPage googleCloud = new MainPage(driver)
                .openGoogleCloud()
                .openSearchPanel(REQUEST)
                .getSearchResults()
                .goToCalculatorPage()
                .switchToFrame()
                .clickComputeEngine()
                .setNumberOfInstances(testData.getInstances())
                .setSoftware(testData.getSoftware())
                .setMachineClass(testData.getMachineClass())
                .setMachineType(testData.getMachineType())
                .addSustainedUseDiscounts()
                .setLocation(testData.getLocation())
                .setCommittedUsage(testData.getCommittedUsage())
                .addToEstimate()
                .emailEstimate();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        EmailPage emailPage = new EmailPage(driver)
                .openEmailPage();
        String email = emailPage
                .copyMailAddress();
        driver.switchTo().window(tabs.get(0));
        googleCloud.switchToFrame()
                .typeMailAddress(email)
                .sendEmail();
        String calculatorCost = googleCloud
                .getTotalCostFromCalculatorPage();
        driver.switchTo().window(tabs.get(1));
        String emailCost = emailPage
                .getTotalCostFromEmailPage();

        Assert.assertTrue(calculatorCost.contains(emailCost));
    }
}
