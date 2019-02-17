package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePageObject extends BasePageObject {

    public HomePagePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".x-icon.x-icon--logo")
    private WebElement wordpressLogo;

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in .x-nav-link.x-link")
    private WebElement logInButton;

    @FindBy(css = ".x-nav-link.x-nav-link--primary.x-link")
    private WebElement getStartedButton;

    /**
     * Wait until the WordPress logo is visible.
     */
    public void waitForWordpressLogo() {
        wordpressLogo = waitForElement(wordpressLogo);
    }

    /**
     * Wait until the Log In button is visible.
     */
    public void waitForLogInButton() {
        logInButton = waitForElement(logInButton);
    }

    /**
     * Wait until the Get Started button is visible.
     */
    public void waitForGetStartedButton() {
        getStartedButton = waitForElement(getStartedButton);
    }

    /**
     * Check the WordPress logo is visible.
     *
     * @return true if the WordPress logo is visible, false if not.
     */
    public boolean wordpressLogoIsVisible() {
        return wordpressLogo.isDisplayed();
    }

    /**
     * Check the Log In button is visible.
     *
     * @return true if the Log In button is visible, false if not.
     */
    public boolean logInButtonIsVisible() {
        return logInButton.isDisplayed();
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