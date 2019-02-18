package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePageObject;
import pageObjects.HomePagePageObject;
import pageObjects.LogInPagePageObject;
import pageObjects.ReaderPagePageObject;

import java.io.IOException;

public class WordPressBlogPostStepDef {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //1.

    @Given("^the WordPress site is opened$")
    public void the_wordpress_site_is_opened() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        driver.get("https://wordpress.com");
        driver.manage().window().fullscreen();
        homePagePageObject.waitForWordpressLogo();
        homePagePageObject.waitForLogInButton();
        homePagePageObject.waitForGetStartedButton();
    }

    @Then("^the WordPress logo should be visible$")
    public void the_wordpress_logo_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        Assert.assertTrue(homePagePageObject.wordpressLogoIsVisible());
    }

    @And("^the Log In button should be visible$")
    public void the_log_in_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        Assert.assertTrue(homePagePageObject.logInButtonIsVisible());
    }

    @And("^the Get Started button should be visible$")
    public void the_Get_Started_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        Assert.assertTrue(homePagePageObject.getStartedButtonIsVisible());
    }

    //2.

    @When("^the Log In button is clicked$")
    public void the_Log_In_button_is_clicked() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickLogInButton();
    }

    @Then("^the Back to WordPress button should be visible$")
    public void the_Back_to_WordPress_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertTrue(logInPagePageObject.backToWordPressButtonIsVisible());
    }

    @And("^the continue button should be visible$")
    public void the_continue_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertTrue(logInPagePageObject.continueButtonIsVisible());
    }

    @And("^the Log in to your account text should be visible$")
    public void the_Log_in_to_your_account_text_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertEquals("Log in to your account.", logInPagePageObject.logInToYourAccountText());
    }

    @And("^the continue with google button should be visible$")
    public void the_continue_with_google_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertTrue(logInPagePageObject.continueWithGoogleButtonIsVisible());
    }

    //3.

    @And("^the (.*) email address is typed into the email input field$")
    public void the_email_address_is_typed_into_the_email_input_field(String emailOrUsername) {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertTrue(logInPagePageObject.emailOrUsernameInputFieldIsVisible());
        logInPagePageObject.writeTextToEmailOrUsernameInputField(emailOrUsername);
    }

    @And("^the continue button is clicked$")
    public void the_continue_button_is_clicked() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickOnContinueButton();
    }

    @Then("^the password input field should be visible$")
    public void the_password_input_field_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Assert.assertTrue(logInPagePageObject.passwordInputFieldIsVisible());
    }

    @When("^the (.*) password is typed into the password input field$")
    public void the_password_is_typed_into_the_password_input_field(String password) {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.writeTextToPasswordInputField(password);
    }

    @And("^the Log In button is clicked on the Log In page$")
    public void the_Log_in_button_is_clicked_on_the_Log_in_page() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickLogInButtonOnLogInPage();
    }

    @Then("^the Reader page should be visible$")
    public void the_Reader_page_should_be_visible() {
        ReaderPagePageObject readerPagePageObject = new ReaderPagePageObject(driver);
        Assert.assertTrue(readerPagePageObject.welcomeToReaderImageIsVisible());
        Assert.assertTrue(readerPagePageObject.readerButtonClassIsActive());
        Assert.assertTrue(readerPagePageObject.searchBarIsVisible());
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        BasePageObject basePageObject = new BasePageObject(driver);
        if (scenario.isFailed()) {
            basePageObject.takeScreenshot();
        }
        driver.close();
        driver.quit();
    }
}