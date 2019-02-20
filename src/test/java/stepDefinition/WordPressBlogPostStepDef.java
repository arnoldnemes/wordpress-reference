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
import pageObjects.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Arrays;

public class WordPressBlogPostStepDef {
    private WebDriver driver;
    private HomePagePageObject homePagePageObject;
    private LogInPagePageObject logInPagePageObject;
    private ReaderPagePageObject readerPagePageObject;
    private MySitesPageObject mySitesPageObject;
    private PostPageObject postPageObject;
    Logger log = Logger.getLogger(WordPressBlogPostStepDef.class.getName());

    @Before()
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePagePageObject = new HomePagePageObject(driver);
        logInPagePageObject = new LogInPagePageObject(driver);
        readerPagePageObject = new ReaderPagePageObject(driver);
        mySitesPageObject = new MySitesPageObject(driver);
        postPageObject = new PostPageObject(driver);
    }

    //1.

    @Given("^the WordPress site is opened$")
    public void the_WordPress_site_is_opened() {
        driver.get("https://wordpress.com");
        driver.manage().window().fullscreen();
        homePagePageObject.waitForWordpressLogo();
        homePagePageObject.waitForLogInButton();
        homePagePageObject.waitForGetStartedButton();
        log.info("Given was run");
    }

    @Then("^the WordPress logo should be visible$")
    public void the_wordpress_logo_should_be_visible() {
        assertThat(true, is(equalTo(homePagePageObject.wordpressLogoIsVisible())));
        log.info("Then was run");
    }

    @And("^the Log In button should be visible$")
    public void the_log_in_button_should_be_visible() {
        assertThat(true, is(equalTo(homePagePageObject.logInButtonIsVisible())));
        log.info("And was run");
    }

    @And("^the Get Started button should be visible$")
    public void the_Get_Started_button_should_be_visible() {
        assertThat(true, is(equalTo(homePagePageObject.getStartedButtonIsVisible())));
        log.info("And was run");
    }

    //2.

    @When("^the Log In button is clicked$")
    public void the_Log_In_button_is_clicked() {
        logInPagePageObject.clickLogInButton();
        log.info("When was run");
    }

    @Then("^the Back to WordPress button should be visible$")
    public void the_Back_to_WordPress_button_should_be_visible() {
        assertThat(true, is(equalTo(logInPagePageObject.backToWordPressButtonIsVisible())));
        log.info("Then was run");
    }

    @And("^the continue button should be visible$")
    public void the_continue_button_should_be_visible() {
        assertThat(true, is(equalTo(logInPagePageObject.continueButtonIsVisible())));
        log.info("And was run");
    }

    @And("^the Log in to your account text should be visible$")
    public void the_Log_in_to_your_account_text_should_be_visible() {
        assertThat("Log in to your account.", is(equalTo(logInPagePageObject.logInToYourAccountText())));
        log.info("And was run");
    }

    @And("^the continue with google button should be visible$")
    public void the_continue_with_google_button_should_be_visible() {
        assertThat(true, is(equalTo(logInPagePageObject.continueWithGoogleButtonIsVisible())));
        log.info("And was run");
    }

    //3.

    @And("^the (\\w+@\\w+.com) email address is typed into the email input field$")
    public void the_email_address_is_typed_into_the_email_input_field(String emailOrUsername) {
        assertThat(true, is(equalTo(logInPagePageObject.emailOrUsernameInputFieldIsVisible())));
        logInPagePageObject.writeTextToEmailOrUsernameInputField(emailOrUsername);
        log.info("And was run");
    }

    @And("^the continue button is clicked$")
    public void the_continue_button_is_clicked() {
        logInPagePageObject.clickOnContinueButton();
        log.info("And was run");
    }

    @Then("^the password input field should be visible$")
    public void the_password_input_field_should_be_visible() {
        assertThat(true, is(equalTo(logInPagePageObject.passwordInputFieldIsVisible())));
        log.info("Then was run");
    }

    @When("^the (\\w+) password is typed into the password input field$")
    public void the_password_is_typed_into_the_password_input_field(String password) {
        logInPagePageObject.writeTextToPasswordInputField(password);
        log.info("When was run");
    }

    @And("^the Log In button is clicked on the Log In page$")
    public void the_Log_in_button_is_clicked_on_the_Log_in_page() {
        logInPagePageObject.clickLogInButtonOnLogInPage();
        log.info("And was run");
    }

    @Then("^the Reader page should be visible$")
    public void the_Reader_page_should_be_visible() {
        assertThat(true, is(equalTo(readerPagePageObject.welcomeToReaderImageIsVisible())));
        assertThat(readerPagePageObject.readerButtonGetClass(), stringContainsInOrder(Arrays.asList("is", "active")));
        assertThat(true, is(equalTo(readerPagePageObject.searchBarIsVisible())));
        log.info("Then was run");
    }

    //4

    @Given("^the user is logged in to WordPress page$")
    public void the_user_is_logged_in_to_WordPress_page() {
        the_WordPress_site_is_opened();
        the_Log_In_button_is_clicked();
        the_email_address_is_typed_into_the_email_input_field("notfunx@gmail.com");
        the_continue_button_is_clicked();
        the_password_input_field_should_be_visible();
        the_password_is_typed_into_the_password_input_field("test123456");
        the_Log_in_button_is_clicked_on_the_Log_in_page();
        the_Reader_page_should_be_visible();
        log.info("Given was run");
    }

    @When("^the My Sites button is clicked$")
    public void the_My_Sites_button_is_clicked() {
        assertThat(true, is(equalTo(mySitesPageObject.mySitesButtonIsVisible())));
        mySitesPageObject.clickMySitesButton();
        log.info("When was run");
    }

    @And("^the Blog Posts menu is clicked$")
    public void the_Blog_posts_menu_is_clicked() {
        assertThat(true, is(equalTo(mySitesPageObject.blogPostsMenuButtonIsVisible())));
        mySitesPageObject.clickBlogPostsMenuButton();
        log.info("And was run");
    }

    @And("^the Add New Post button is clicked$")
    public void the_Add_New_Post_button_is_clicked() {
        assertThat(true, is(equalTo(mySitesPageObject.addNewPostButtonIsVisible())));
        mySitesPageObject.clickAddNewPostButton();
        log.info("And was run");
    }

    @Then("^the Edit with a Visual editor button should be (visible|hidden)$")
    public void the_Edit_with_a_Visual_editor_button_should_be_visible(String visibility) {
        assertThat(visibility.equals("visible"), is(equalTo(postPageObject.visualEditorButtonIsVisible())));
        log.info("Then was run");
    }

    @Then("^the (\\w+) text should be (visible|hidden)$")
    public void the_title_placeholder_should_be_visible(String text, String visibility) {
        assertThat(visibility.equals("visible"), is(equalTo(postPageObject.titleTextAreaTextIsVisible(text))));
        log.info("Then was run");
    }

    @When("^the (\\w+) text is typed into the title text bar$")
    public void the_text_is_typed_into_the_title_text_bar(String title) {
        postPageObject.sendTextToTitleTextBar(title);
        log.info("When was run");
    }

    @When("^the (\\w+) text is deleted from the title text bar$")
    public void the_text_is_deleted_from_the_title_text_bar(String title) {
        postPageObject.deleteTitleTextBar(title);
        log.info("When was run");
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