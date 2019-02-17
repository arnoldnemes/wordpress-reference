package pageObjects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePageObject {
    private WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     *
     * @return
     */
    private WebDriverWait explicitWait() {
        WebDriverWait wait;
        return wait = new WebDriverWait(driver, 5);
    }

    /**
     * Wait for web element until it is visible.
     * @param el
     * @return a web element
     */
    public WebElement waitForElement(WebElement el) {
        return explicitWait().until(ExpectedConditions.visibilityOf(el));
    }

    /**
     * Create a .png screenshot to src/test/resources folder.
     * @throws IOException
     */
    public void takeScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(file, new File("src\\test\\resources"));
    }
}