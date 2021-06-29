package hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String GOOGLE_CLOUD_URL = "https://cloud.google.com";

    @FindBy(name = "q")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchSubmit;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openGoogleCloud() {
        driver.get(GOOGLE_CLOUD_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        logger.info("https://cloud.google.com opened successfully");
        return this;
    }

    public MainPage openSearchPanel(String request) {
        searchButton.click();
        searchButton.sendKeys(request);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        return this;
    }

    public SearchResultsPage getSearchResults() {
        searchSubmit.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")));
        return new SearchResultsPage(driver);
    }


}
