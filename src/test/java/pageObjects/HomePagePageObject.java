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

    public void waitForWordpressLogo() {
        wordpressLogo = waitForElement(wordpressLogo);
    }

    public void waitForLogInButton() {
        logInButton = waitForElement(logInButton);
    }

    public void waitForGetStartedButton() {
        getStartedButton = waitForElement(getStartedButton);
    }

    public boolean wordpressLogoIsVisible() {
        return wordpressLogo.isDisplayed();
    }

    public boolean logInButtonIsVisible() {
        return logInButton.isDisplayed();
    }

    public boolean getStartedButtonIsVisible() {
        return getStartedButton.isDisplayed();
    }
}