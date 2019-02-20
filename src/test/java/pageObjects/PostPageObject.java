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

    @FindBy(css = ".editor-title textarea")
    private WebElement titleTextBar;

    public boolean visualEditorButtonIsVisible() {
        visualEditorButton = waitForElement(visualEditorButton);
        return visualEditorButton.isDisplayed();
    }

    public String titleTextAreaGetText() {
        String text;
        return text = titleTextBar.getText();
    }

    public boolean titleTextAreaTextIsVisible(String s) {
        if (titleTextAreaGetText().equals(s) && !(titleTextAreaGetText().equals("")))
            return true;
        return false;
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