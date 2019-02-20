package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPageObject extends BasePageObject {

    public PostPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[title='Edit with a visual editor']")
    private WebElement visualEditorButton;

    @FindBy(css = "textarea[placeholder='Title']")
    private WebElement titleTextBar;

    public boolean visualEditorButtonIsVisible() {
        visualEditorButton = waitForElement(visualEditorButton);
        return visualEditorButton.isDisplayed();
    }

    public String titleTextAreaGetPlaceholder() {
        String placeholder;
        return placeholder = titleTextBar.getAttribute("placeholder");
    }

    public boolean placeholderIsVisible() {
        return titleTextBar.isDisplayed();
    }

    public void sendTextToTitleTextBar(String s) {
        titleTextBar.sendKeys(s);
    }

    public void deleteTitleTextBar(String s) {
        for (int i = s.length(); i > 0; i--) {
            titleTextBar.sendKeys(Keys.BACK_SPACE);
        }
    }
}