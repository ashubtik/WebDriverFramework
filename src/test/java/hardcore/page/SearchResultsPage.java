package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement calculatorLink;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage goToCalculatorPage(){
        calculatorLink.click();
        return new CalculatorPage(driver);
    }
}
