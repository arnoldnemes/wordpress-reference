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
import java.util.List;

public class WordPressBlogPostStepDef {
    private WebDriver driver;
    private HomePagePageObject homePagePageObject;
    private LogInPagePageObject logInPagePageObject;
    private ReaderPagePageObject readerPagePageObject;
    private MySitesPageObject mySitesPageObject;
    private PostPageObject postPageObject;
    private Logger log = Logger.getLogger(WordPressBlogPostStepDef.class.getName());

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
        homePagePageObject.waitForWordPressLogo();
        homePagePageObject.waitForLogInButton();
        homePagePageObject.waitForGetStartedButton();
        log.info("Given was run");
    }

    @Then("^the WordPress logo should be visible$")
    public void the_WordPress_logo_should_be_visible() {
        assertThat("The WordPress logo is not visible.", homePagePageObject.wordPressLogoIsVisible(), is(true));
        log.info("Then was run");
    }

    @And("^the (\\w+\\s\\w+) button should be visible$")
    public void the_log_in_button_should_be_visible(String buttonName) {
        assertThat("The " + buttonName + " button is not visible.", homePagePageObject.buttonIsVisibleOnHomePage(buttonName), is(true));
        log.info("And was run");
    }

    //2.

    @When("^the Log In button is clicked$")
    public void the_button_is_clicked() {
        logInPagePageObject.clickLogInButton();
        log.info("When was run");
    }

    @Then("^the Back to WordPress button should be visible$")
    public void the_Back_to_WordPress_button_should_be_visible() {
        assertThat("The Back to WordPress button is not visible.", logInPagePageObject.backToWordPressButtonIsVisible(), is(true));
        log.info("Then was run");
    }

    @And("^the continue button should be visible$")
    public void the_continue_button_should_be_visible() {
        assertThat("The continue button is not visible.", logInPagePageObject.continueButtonIsVisible(), is(true));
        log.info("And was run");
    }

    @And("^the Log in to your account text should be visible$")
    public void the_Log_in_to_your_account_text_should_be_visible() {
        assertThat("The Log in to your account text is not visible.", logInPagePageObject.logInToYourAccountText(), is(equalTo("Log in to your account.")));
        log.info("And was run");
    }

    @And("^the continue with google button should be visible$")
    public void the_continue_with_google_button_should_be_visible() {
        assertThat("The continue with google button is not visible.", logInPagePageObject.continueWithGoogleButtonIsVisible(), is(true));
        log.info("And was run");
    }

    //3.

    @And("^the (\\w+@\\w+.\\w+) email address is typed into the email input field$")
    public void the_email_address_is_typed_into_the_email_input_field(String emailOrUsername) {
        assertThat("The " + emailOrUsername + " email failed to type into the email input field.", logInPagePageObject.emailOrUsernameInputFieldIsVisible(), is(true));
        logInPagePageObject.writeTextToEmailOrUsernameInputField(emailOrUsername);
        log.info("And was run");
    }

    @And("^the Continue button is clicked$")
    public void the_continue_button_is_clicked() {
        logInPagePageObject.clickOnContinueButton();
        log.info("And was run");
    }

    @Then("^the password input field should be visible$")
    public void the_password_input_field_should_be_visible() {
        assertThat("The password input field is not visible.", logInPagePageObject.passwordInputFieldIsVisible(), is(true));
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
        assertThat("The Welcome to Reader image is not visible.", readerPagePageObject.welcomeToReaderImageIsVisible(),
                is(true));
        assertThat("The Reader button is not active.", readerPagePageObject.readerButtonGetClass(),
                stringContainsInOrder(Arrays.asList("is", "active")));
        assertThat("The search bar is not visible.", readerPagePageObject.searchBarIsVisible(), is(true));
        log.info("Then was run");
    }

    //4

    @Given("^the user is logged in to WordPress page$")
    public void the_user_is_logged_in_to_WordPress_page() {
        the_WordPress_site_is_opened();
        the_button_is_clicked();
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
        assertThat("The My Sites button is not visible.", mySitesPageObject.mySitesButtonIsVisible(), is(true));
        mySitesPageObject.clickMySitesButton();
        log.info("When was run");
    }

    @And("^the Blog Posts menu is clicked$")
    public void the_Blog_posts_menu_is_clicked() {
        assertThat("The Blog Posts menu button is not visible.", mySitesPageObject.blogPostsMenuButtonIsVisible(), is(true));
        mySitesPageObject.clickBlogPostsMenuButton();
        log.info("And was run");
    }

    @And("^the Add New Post button is clicked$")
    public void the_Add_New_Post_button_is_clicked() {
        assertThat("The Add New Post button is not visible.", mySitesPageObject.addNewPostButtonIsVisible(), is(true));
        mySitesPageObject.clickAddNewPostButton();
        log.info("And was run");
    }

    @Then("^the Edit with a Visual editor button should be (visible|hidden)$")
    public void the_Edit_with_a_Visual_editor_button_should_be_visible(String visibility) {
        assertThat("The Edit with a Visual editor button is not " + visibility + ".", visibility.equals("visible"),
                is(equalTo(postPageObject.visualEditorButtonIsVisible())));
        log.info("Then was run");
    }

    @Then("^the (\\w+) text should be (visible|hidden)$")
    public void the_title_placeholder_should_be_visible(String text, String visibility) {
        assertThat("The " + text + " is not " + visibility + ".", visibility.equals("visible"),
                is(equalTo(postPageObject.titleTextAreaTextIsVisible(text))));
        log.info("Then was run");
    }

    @When("^the (\\w+) text is typed into the title text bar$")
    public void the_text_is_typed_into_the_title_text_bar(String title) {
        postPageObject.sendTextToTitleTextBar(title);
        log.info("When was run");
    }

    @When("^the text bar is cleared$")
    public void the_title_text_bar_is_cleared() {
        postPageObject.clearTitleTextBar();
        log.info("When was run");
    }

    //5

    @And("^the Edit with a visual editor button is clicked$")
    public void the_Edit_with_a_visual_editor_button_is_clicked() {
        postPageObject.clickEditWithAVisualEditorButton();
        log.info("And was run");
    }

    @Then("^the Add button should be visible$")
    public void the_button_should_be_visible() {
        assertThat("The Add button is not visible.", postPageObject.addDropdownIsVisible(), is(true));
        log.info("Then was run");
    }

    @When("^the Add dropdown is clicked$")
    public void the_Add_dropdown_is_clicked() {
        postPageObject.clickAddDropdown();
        log.info("When was run");
    }

    @Then("^the following (.+) type buttons should be visible:$")
    public void the_following_buttons_should_be_visible(String type, List<String> dropdown) {
        postPageObject.addDropdownButtonsElementsAreVisible(dropdown, type);
        log.info("Then was run");
    }

    //6

    @And("^the (.+) dropdown button is clicked$")
    public void the_dropdown_button_is_clicked(String dropdown) {
        postPageObject.clickTheAddDropdownButtonsElements(dropdown);
        log.info("And was run");
    }

    @Then("^the popup window should be visible$")
    public void the_popup_window_should_be_visible() {
        assertThat("The popup window is not visible.", postPageObject.popupWindowIsVisible(), is(true));
        log.info("Then was run");
    }

    @And("^the (Cancel|Insert) button should be visible$")
    public void the_button_should_be_visible_on_the_popup_window(String buttonName) {
        assertThat("The " + buttonName + " button is not visible.",
                postPageObject.popupButtonsIsVisible(buttonName), is(true));
        log.info("And was run");
    }

    @And("^the Media library dropdown button should be visible$")
    public void the_Media_library_dropdown_button_should_be_visible() {
        assertThat("The Media library dropdown button is not visible.",
                postPageObject.mediaLibraryDropdownButtonIsVisible(), is(true));
        log.info("And was run");
    }

    @And("^the (Insert|Cancel) button should be (disabled|enabled)$")
    public void the_Insert_button_should_be_disabled(String buttonName, String state) {
        assertThat("The " + buttonName + " button is not " + state + ".",
                postPageObject.theButtonIsDisabled(state), is(true));
        log.info("And was run");
    }

    @When("^the Media library dropdown is clicked$")
    public void the_Media_library_dropdown_is_clicked() {
        postPageObject.clickMediaLibraryDropdownButton();
        log.info("And was run");
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        BasePageObject basePageObject = new BasePageObject(driver);
        if (scenario.isFailed()) {
            basePageObject.takeScreenshot();
            log.info("The '" + scenario.getName() + "' scenario is failed.");
        } else {
            log.info("The scenario ran successfully.");
        }
        driver.close();
        driver.quit();
    }
}