package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostPageObject extends BasePageObject {

    private Logger log = Logger.getLogger(PostPageObject.class.getName());

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

    @FindBy(css = ".dialog__content")
    private WebElement popupWindow;

    @FindBy(css = "button[data-e2e-button='cancel']")
    private WebElement popupCancelButton;

    @FindBy(css = "button[data-e2e-button='confirm']")
    private WebElement popupInsertButton;

    @FindBy(css = ".button.button.media-library__source-button.is-borderless")
    private WebElement mediaLibraryDropdownButton;

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
        log.info("The '" + s + "' text was sent to the title bar.");
    }

    public void clearTitleTextBar() {
        titleTextBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        titleTextBar.sendKeys(Keys.BACK_SPACE);
        log.info("Title text bar cleared.");
    }

    public void clickEditWithAVisualEditorButton() {
        editWithAVisualEditorButton = waitForElement(editWithAVisualEditorButton);
        editWithAVisualEditorButton.click();
        log.info("The Edit with a visual editor button is clicked.");
    }

    public boolean addDropdownIsVisible() {
        addDropdown = waitForElement(addDropdown);
        return addDropdown.isDisplayed();
    }

    public void clickAddDropdown() {
        addDropdown = waitForElement(addDropdown);
        addDropdown.click();
        log.info("The Add dropdown is clicked.");
    }

    public void addDropdownButtonsElementsAreVisible(List<String> dropdown, String type) {
        switch (type) {
            case "span":
                for (String dd : dropdown) {
                    assertThat("The " + dd + " button is not visible!", findSpanElementByXpath(dd).isDisplayed(), is(true));
                }
                break;
            case "button":
                for (String dd : dropdown) {
                    assertThat("The " + dd + " button is not visible!", findButtonElementByXpath(dd).isDisplayed(), is(true));
                }
                break;
        }
    }

    public void clickTheAddDropdownButtonsElements(String dropdown) {
        findSpanElementByXpath(dropdown).click();
        log.info("The '" + dropdown + "' button is clicked.");
    }

    public boolean popupWindowIsVisible() {
        popupWindow = waitForElement(popupWindow);
        return popupWindow.isDisplayed();
    }

    public boolean popupButtonsIsVisible(String buttonName) {
        switch (buttonName) {
            case "Cancel":
                popupCancelButton = waitForElement(popupCancelButton);
                return popupCancelButton.isDisplayed();
            case "Insert":
                popupInsertButton = waitForElement(popupInsertButton);
                return popupInsertButton.isDisplayed();
        }
        return false;
    }

    public boolean mediaLibraryDropdownButtonIsVisible() {
        mediaLibraryDropdownButton = waitForElement(mediaLibraryDropdownButton);
        return mediaLibraryDropdownButton.isDisplayed();
    }

    public boolean theButtonIsDisabled(String state) {
        switch (state) {
            case "disabled":
                return !popupInsertButton.isEnabled();
            case "enabled":
                return popupCancelButton.isEnabled();
        }
        return false;
    }

    public void clickMediaLibraryDropdownButton() {
        mediaLibraryDropdownButton = waitForElement(mediaLibraryDropdownButton);
        mediaLibraryDropdownButton.click();
        log.info("Media library dropdown button was clicked.");
    }
}