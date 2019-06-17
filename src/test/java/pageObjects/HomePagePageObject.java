package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePageObject extends BasePageObject {

    public HomePagePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".x-icon.x-icon--logo")
    private WebElement wordPressLogo;

    @FindBy(css = "a[title='Log In']")
    private WebElement logInButton;

    @FindBy(css = "a[title='Get Started']")
    private WebElement getStartedButton;

    /**
     * Wait until the WordPress logo is visible.
     */
    public void waitForWordPressLogo() {
        waitForElement(wordPressLogo);
    }

    /**
     * Wait until the Log In button is visible.
     */
    public void waitForLogInButton() {
        waitForElement(logInButton);
    }

    /**
     * Wait until the Get Started button is visible.
     */
    public void waitForGetStartedButton() {
        waitForElement(getStartedButton);
    }

    /**
     * Check the WordPress logo is visible.
     *
     * @return true if the WordPress logo is visible, false if not.
     */
    public boolean wordPressLogoIsVisible() {
        return wordPressLogo.isDisplayed();
    }

    /**
     * Check the given button is visible.
     *
     * @return true if the given button is visible, false if not.
     */
    public boolean buttonIsVisibleOnHomePage(String s) {
        switch (s) {
            case "Get Started":
                return getStartedButton.isDisplayed();
            case "Log In":
                return logInButton.isDisplayed();
            default:
                System.out.println("The button is not found");
        }
        return false;
    }

    /**
     * Check the Get Started button is visible.
     *
     * @return true if the Get Started button is visible, false if not.
     */
    public boolean getStartedButtonIsVisible() {
        return getStartedButton.isDisplayed();
    }
}