package hardcore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EmailPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
    private final String MAIL_URL = "https://10minutemail.net";

    @FindBy(xpath = "//button[@id='copy-button']")
    private WebElement copyEmailButton;

    @FindBy(xpath = "//a[contains (text(), 'Google Cloud Platform Price Estimate')]")
    private WebElement openNewLetter;

    @FindBy(xpath = "//i[contains (@class, 'fa fa-refresh')]//ancestor::a")
    private WebElement refreshButton;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage openEmailPage(){
        driver.navigate().to(MAIL_URL);
        return this;
    }

    public String copyMailAddress() throws IOException, UnsupportedFlavorException {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='fe_text']")));
        copyEmailButton.click();
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        return myText;
    }

    public EmailPage refresh(){
        refreshButton.click();
        return new EmailPage(driver);
    }

    public String getTotalCostFromEmailPage(){
        new WebDriverWait(driver, 200)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains (text(), 'Google Cloud Platform Price Estimate')]")));
        openNewLetter.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains (text(), 'USD')]")));
        String monthlyCost = driver.findElement(By.xpath("//h3[contains (text(), 'USD')]")).getText();
        logger.info("We've got result by email");
        return monthlyCost;
    }
}
