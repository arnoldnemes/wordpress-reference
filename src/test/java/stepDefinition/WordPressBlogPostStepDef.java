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

import static org.hamcrest.Matchers.*;

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
    public void the_Back_to_WordPress_button_should_be_visible() throws InterruptedException {
        LogInPagePageObject logInPagePageObject = new LogInPagePageObject(driver);
        Thread.sleep(2000);
        logInPagePageObject.backToWordPressButtonIsVisible();
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