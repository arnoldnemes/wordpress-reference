package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySitesPageObject extends BasePageObject {

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
    }

    public boolean blogPostsMenuButtonIsVisible() {
        blogPostsMenuButton = waitForElement(blogPostsMenuButton);
        return blogPostsMenuButton.isDisplayed();
    }

    public void clickBlogPostsMenuButton() {
        blogPostsMenuButton.click();
    }

    public boolean addNewPostButtonIsVisible() {
        addNewPostButton = waitForElement(addNewPostButton);
        return addNewPostButton.isDisplayed();
    }

    public void clickAddNewPostButton() {
        addNewPostButton.click();
    }
}