package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySitesPageObject extends BasePageObject {

    private Logger log = Logger.getLogger(MySitesPageObject.class.getName());

    public MySitesPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-tip-target='my-sites']")
    private WebElement mySitesButton;

    @FindBy(xpath = "//span[text()='Site']")
    private WebElement siteDropdownButton;

    @FindBy(css = ".empty-content__action.button.is-primary")
    private WebElement addNewPostButton;

    @FindBy(css = "span[data-e2e-sidebar='Posts']")
    private WebElement postsButton;

    /**
     * Check the My Sites button is visible.
     *
     * @return true if the My Sites button is visible, false if not.
     */
    public boolean mySitesButtonIsVisible() {
        waitForElement(mySitesButton);
        return mySitesButton.isDisplayed();
    }

    /**
     * Click the My Sites button.
     */
    public void clickMySitesButton() {
        mySitesButton.click();
        log.info("The My Sites button is clicked.");
    }

    /**
     * Check the Site dropdown button is visible.
     *
     * @return true if the Site dropdown visible, false if not.
     */
    public boolean siteDropdownButtonIsVisible() {
        waitForElement(siteDropdownButton);
        return siteDropdownButton.isDisplayed();
    }

    /**
     * Click the Site dropdown button.
     */
    public void clickSiteDropdownButton() {
        siteDropdownButton.click();
        log.info("The Site dropdown button is clicked.");
    }

    /**
     * Check the Add New Post button is visible.
     *
     * @return true if the Add New Post button is visible, false if not.
     */
    public boolean addNewPostButtonIsVisible() {
        waitForElement(addNewPostButton);
        return addNewPostButton.isDisplayed();
    }

    /**
     * Click the Add New Post button.
     */
    public void clickAddNewPostButton() {
        addNewPostButton.click();
        log.info("The Add New Post button is clicked.");
    }

    /**
     * Click the Posts button.
     */
    public void clickPostsButton() {
        postsButton.click();
        log.info("The Post button is clicked.");
    }

    /**
     * Check the Posts button is visible.
     *
     * @return true if the Posts button is visible, false if not.
     */
    public boolean postsButtonIsVisible() {
        waitForElement(postsButton);
        return postsButton.isDisplayed();
    }
}