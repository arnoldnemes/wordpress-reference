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

    @FindBy(css = "span[data-e2e-sidebar='Blog Posts']")
    private WebElement blogPostsMenuButton;

    @FindBy(css = ".empty-content__action.button.is-primary")
    private WebElement addNewPostButton;

    public boolean mySitesButtonIsVisible() {
        mySitesButton = waitForElement(mySitesButton);
        return mySitesButton.isDisplayed();
    }

    public void clickMySitesButton() {
        mySitesButton.click();
        log.info("The My Sites button is clicked.");
    }

    public boolean blogPostsMenuButtonIsVisible() {
        blogPostsMenuButton = waitForElement(blogPostsMenuButton);
        return blogPostsMenuButton.isDisplayed();
    }

    public void clickBlogPostsMenuButton() {
        blogPostsMenuButton.click();
        log.info("The Blog Posts menu button is clicked.");
    }

    public boolean addNewPostButtonIsVisible() {
        addNewPostButton = waitForElement(addNewPostButton);
        return addNewPostButton.isDisplayed();
    }

    public void clickAddNewPostButton() {
        addNewPostButton.click();
        log.info("The Add New Post button is clicked.");
    }
}