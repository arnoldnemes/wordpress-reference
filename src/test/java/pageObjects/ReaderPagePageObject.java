package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReaderPagePageObject extends BasePageObject {

    public ReaderPagePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".empty-content__illustration")
    private WebElement welcomeToReaderImage;

    @FindBy(css = ".masterbar__item.masterbar__reader.is-active")
    private WebElement readerButton;

    @FindBy(css = "input[type='search']")
    private WebElement searchBar;

    /**
     * Wait for the Welcome to Reader image.
     *
     * @return true if the Welcome to Reader image is visible, false if not.
     */
    public boolean welcomeToReaderImageIsVisible() {
        waitForElement(welcomeToReaderImage);
        return welcomeToReaderImage.isDisplayed();
    }

    /**
     * @return the reader button class name in String.
     */
    public String readerButtonGetClass() {
        String className = readerButton.getAttribute("class");
        return className;
    }

    public boolean searchBarIsVisible() {
        waitForElement(searchBar);
        return searchBar.isDisplayed();
    }
}