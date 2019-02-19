package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePageObject;
import pageObjects.HomePagePageObject;
import pageObjects.LogInPagePageObject;
import pageObjects.ReaderPagePageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Arrays;

public class WordPressBlogPostStepDef {
    private WebDriver driver;
    static Logger log = Logger.getLogger(WordPressBlogPostStepDef.class.getName());

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
        log.info("given lefutott");
    }

    @Then("^the WordPress logo should be visible$")
    public void the_wordpress_logo_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        assertThat(true, is(equalTo(homePagePageObject.wordpressLogoIsVisible())));
        log.info("then lefutott");
    }

    @And("^the Log In button should be visible$")
    public void the_log_in_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        assertThat(true, is(equalTo(homePagePageObject.logInButtonIsVisible())));
        log.info("log in button visible");
    }

    @And("^the Get Started button should be visible$")
    public void the_Get_Started_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        assertThat(true, is(equalTo(homePagePageObject.getStartedButtonIsVisible())));
        log.info("get started is visible");
    }

    //2.

    @When("^the Log In button is clicked$")
    public void the_Log_In_button_is_clicked() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickLogInButton();
        log.info("log in button is clicked");
    }

    @Then("^the Back to WordPress button should be visible$")
    public void the_Back_to_WordPress_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat(true, is(equalTo(logInPagePageObject.backToWordPressButtonIsVisible())));
        log.info("back to wordpress button is visible");
    }

    @And("^the continue button should be visible$")
    public void the_continue_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat(true, is(equalTo(logInPagePageObject.continueButtonIsVisible())));
        log.info("continue button is visible");
    }

    @And("^the Log in to your account text should be visible$")
    public void the_Log_in_to_your_account_text_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat("Log in to your account.", is(equalTo(logInPagePageObject.logInToYourAccountText())));
        log.info("the log in to your... text is visible");
    }

    @And("^the continue with google button should be visible$")
    public void the_continue_with_google_button_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat(true, is(equalTo(logInPagePageObject.continueWithGoogleButtonIsVisible())));
        log.info("the continue with google is visible");
    }

    //3.

    @And("^the (.*) email address is typed into the email input field$")
    public void the_email_address_is_typed_into_the_email_input_field(String emailOrUsername) {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat(true, is(equalTo(logInPagePageObject.emailOrUsernameInputFieldIsVisible())));
        logInPagePageObject.writeTextToEmailOrUsernameInputField(emailOrUsername);
        log.info("the " + emailOrUsername + " email adress is typed into the email input field");
    }

    @And("^the continue button is clicked$")
    public void the_continue_button_is_clicked() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickOnContinueButton();
        log.info("the continue button is clicked");
    }

    @Then("^the password input field should be visible$")
    public void the_password_input_field_should_be_visible() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        assertThat(true, is(equalTo(logInPagePageObject.passwordInputFieldIsVisible())));
        log.info("the password input field should be visible");
    }

    @When("^the (.*) password is typed into the password input field$")
    public void the_password_is_typed_into_the_password_input_field(String password) {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.writeTextToPasswordInputField(password);
        log.info("the " + password + " password is typed into the password input field");
    }

    @And("^the Log In button is clicked on the Log In page$")
    public void the_Log_in_button_is_clicked_on_the_Log_in_page() {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        logInPagePageObject.clickLogInButtonOnLogInPage();
        log.info("the Log In button is clicked on the Log In page");
    }

    @Then("^the Reader page should be visible$")
    public void the_Reader_page_should_be_visible() {
        ReaderPagePageObject readerPagePageObject = new ReaderPagePageObject(driver);
        assertThat(true, is(equalTo(readerPagePageObject.welcomeToReaderImageIsVisible())));
        assertThat(readerPagePageObject.readerButtonGetClass(), stringContainsInOrder(Arrays.asList("is", "active")));
        assertThat(true, is(equalTo(readerPagePageObject.searchBarIsVisible())));
        log.info("the Reader page should be visible");
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