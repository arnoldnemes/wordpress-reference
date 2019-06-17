package pageObjects;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class BasePageObject {
    private WebDriver driver;
    private Logger log = Logger.getLogger(BasePageObject.class.getName());

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for web element until it will be visible.
     *
     * @param el
     * @return a web element
     */

    void waitForElement(WebElement el) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(el));
    }


    /**
     * Create a .png screenshot to src/test/resources folder.
     *
     * @throws IOException
     */
    public void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(file, new File("src\\test\\resources"));
        log.info("Screenshot was taken.");
    }

    /**
     * Find the span element with the parameter name by xpath.
     *
     * @param s
     * @return a web element
     */
    public WebElement findSpanElementByXpath(String s) {
        return driver.findElement(By.xpath("//span[text()='" + s + "']"));
    }

    /**
     * Find the button element with the parameter name by xpath.
     *
     * @param s
     * @return a web element
     */
    public WebElement findButtonElementByXpath(String s) {
        return driver.findElement(By.xpath("//button[text()='" + s + "']"));
    }
}