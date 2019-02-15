package stepDefinition;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import log.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePageObject;
import pageObjects.HomePagePageObject;

import java.io.IOException;

public class WordPressBlogPostStepDef {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //1.

    @Given("^the wordpress site is opened$")
    public void the_wordpress_site_is_opened() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        driver.get("https://wordpress.com");
        driver.manage().window().fullscreen();
        homePagePageObject.waitForWordpressLogo();
        homePagePageObject.waitForLogInButton();
        homePagePageObject.waitForGetStartedButton();
        Log.info("The wordpress site is opened!");
    }

    @Then("^the wordpress logo should be visible$")
    public void the_wordpress_logo_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        final Logger logger = Logger.getLogger(WordPressBlogPostStepDef.class);
        homePagePageObject.wordpressLogoIsVisible();
        Log.info("The wordpress logo is visible!");
    }

    @And("^the Log In button should be visible$")
    public void the_log_in_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        homePagePageObject.logInButtonIsVisible();
        Log.info("The Log In button is visible");
    }

    @And("^the Get Started button should be visible$")
    public void the_Get_Started_button_should_be_visible() {
        HomePagePageObject homePagePageObject = new HomePagePageObject(driver);
        homePagePageObject.getStartedButtonIsVisible();
        Log.info("The Get Started button is visible");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        BasePageObject basePageObject = new BasePageObject(driver);
        if (scenario.isFailed()) {
            basePageObject.takeScreenshot();
            //Log.info(scenario.getName() + " scenario is failed! Screenshot is taken!");
        }
        driver.close();
        driver.quit();
    }
}