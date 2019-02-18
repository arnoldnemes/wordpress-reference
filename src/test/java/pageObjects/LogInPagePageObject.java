package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPagePageObject extends BasePageObject {

    public LogInPagePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in .x-nav-link.x-link")
    private WebElement logInButton;

    @FindBy(css = ".button.form-button.is-primary")
    private WebElement continueButton;

    @FindBy(css = "div[class='login__form-header']")
    private WebElement logInToYourAccountText;

    @FindBy(css = ".social-buttons__service-name")
    private WebElement continueWithGoogleButton;

    @FindBy(css = ".logged-out-form__back-link")
    private WebElement backToWordPressButton;

    @FindBy(css = "input[type='text']")
    private WebElement emailOrUsernameInputField;

    /**
     * Click the Log In button.
     */
    public void clickLogInButton() {
        logInButton.click();
    }

    /**
     * Check the Continue button is visible.
     *
     * @return true if the Continue button is visible, false if not.
     */
    public boolean continueButtonIsVisible() {
        continueButton = waitForElement(continueButton);
        return continueButton.isDisplayed();
    }

    /**
     * @return the given element's text.
     */
    public String logInToYourAccountText() {
        return logInToYourAccountText.getText();
    }

    /**
     * Check the ContinueWithGoogle button is visible.
     *
     * @return true if the ContinueWithGoogle button is visible, false if not.
     */
    public boolean continueWithGoogleButtonIsVisible() {
        continueWithGoogleButton = waitForElement(continueWithGoogleButton);
        return continueWithGoogleButton.isDisplayed();
    }

    /**
     * Check the Back to WordPress button is visible.
     *
     * @return true if the Back to WordPress button is visible, false if not.
     */
    public boolean backToWordPressButtonIsVisible() {
        backToWordPressButton = waitForElement(backToWordPressButton);
        return backToWordPressButton.isDisplayed();
    }
}