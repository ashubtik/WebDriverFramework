package hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement calculatorLink;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToCalculatorPage(){
        calculatorLink.click();
        logger.info("Calculator opened successfully");
        return new CalculatorPage(driver);
    }
}
