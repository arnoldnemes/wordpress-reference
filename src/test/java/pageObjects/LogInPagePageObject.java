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

    @FindBy(css = "#password")
    private WebElement passwordInputField;

    @FindBy(css = ".button.form-button.is-primary")
    private WebElement logInButtonOnLogInPage;

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

    /**
     * Check the Email or Username input field is visible.
     *
     * @return ture is the Email or Username input field is visible, false if not.
     */
    public boolean emailOrUsernameInputFieldIsVisible() {
        emailOrUsernameInputField = waitForElement(emailOrUsernameInputField);
        return emailOrUsernameInputField.isDisplayed();
    }

    /**
     * Write the text what the function get from the parameter.
     *
     * @param
     */
    public void writeTextToEmailOrUsernameInputField(String s) {
        emailOrUsernameInputField.sendKeys(s);
    }

    /**
     * Click the Continue button on the Log In page.
     */
    public void clickOnContinueButton() {
        continueButton.click();
    }

    /**
     * Wait for the Password field web element.
     *
     * @return true if the Password field is visible, false if not.
     */
    public boolean passwordInputFieldIsVisible() {
        passwordInputField = waitForElement(passwordInputField);
        return passwordInputField.isDisplayed();
    }

    /**
     * Write the password what the function get from the parameter.
     *
     * @param s
     */
    public void writeTextToPasswordInputField(String s) {
        passwordInputField.sendKeys(s);
    }

    /**
     * Click the Log In button on the Log In page.
     */
    public void clickLogInButtonOnLogInPage() {
        logInButtonOnLogInPage.click();
    }
}