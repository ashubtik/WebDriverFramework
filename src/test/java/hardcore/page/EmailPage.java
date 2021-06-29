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
    private final String MAIL_URL = "https://10minemail.net/";

    @FindBy(xpath = "//button[@class='icon__btn copy__btn']")
    private WebElement copyEmailButton;

    @FindBy(xpath = "//span[contains (text(), 'Google Cloud')]")
    private WebElement openNewLetter;

    public EmailPage(WebDriver driver) {
        super(driver);
    }

    public EmailPage openEmailPage(){
        driver.navigate().to(MAIL_URL);
        logger.info("https://10minemail.com opened successfully");
        return this;
    }

    public String copyMailAddress() throws IOException, UnsupportedFlavorException {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='icon__btn copy__btn']")));
        copyEmailButton.click();
        String myText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        logger.info("Email address was copied successfully");
        return myText;
    }

    public String getTotalCostFromEmailPage(){
        new WebDriverWait(driver, 200)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains (text(), 'Google Cloud')]"))).click();
//        openNewLetter.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains (text(), 'USD')]")));
        String monthlyCost = driver.findElement(By.xpath("//h3[contains (text(), 'USD')]")).getText();
        logger.info("We've got result by email");
        return monthlyCost;
    }
}
