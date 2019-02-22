package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class PostPageObject extends BasePageObject {

    public PostPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[title='Edit with a visual editor']")
    private WebElement visualEditorButton;

    @FindBy(css = ".editor-title textarea")
    private WebElement titleTextBar;

    @FindBy(css = "a[title='Edit with a visual editor']")
    private WebElement editWithAVisualEditorButton;

    @FindBy(css = "#mceu_0-open")
    private WebElement addDropdown;

    @FindAll(@FindBy(xpath = "//span[text()='\" + l + \"']\""))
    private List<WebElement> list;

    public boolean visualEditorButtonIsVisible() {
        visualEditorButton = waitForElement(visualEditorButton);
        return visualEditorButton.isDisplayed();
    }

    public String titleTextAreaGetText() {
        return titleTextBar.getText();
    }

    public boolean titleTextAreaTextIsVisible(String s) {
        return titleTextAreaGetText().equals(s) && !(titleTextAreaGetText().equals(""));
    }

    public void sendTextToTitleTextBar(String s) {
        titleTextBar.sendKeys(s);
    }

    public void clearTitleTextBar() {
        titleTextBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        titleTextBar.sendKeys(Keys.BACK_SPACE);
    }

    public void clickEditWithAVisualEditorButton() {
        editWithAVisualEditorButton = waitForElement(editWithAVisualEditorButton);
        editWithAVisualEditorButton.click();
    }

    public boolean addDropdownIsVisible() {
        addDropdown = waitForElement(addDropdown);
        return addDropdown.isDisplayed();
    }

    public void clickAddDropdown() {
        addDropdown.click();
    }

    public void addDropdownButtonsElementsAreVisible(List<String> dropdown) {
        for (String dd : dropdown) {
            assertThat("The " + dd + " button is not visible!", findElementByXpath(dd).isDisplayed(), is(true));
        }
    }
}