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

    /**
     * Check the Visual Editor button is visible.
     *
     * @return true if the Visual Editor button is visible, false if not.
     */
    public boolean visualEditorButtonIsVisible() {
        waitForElement(visualEditorButton);
        return visualEditorButton.isDisplayed();
    }

    /**
     * @return the title area's text.
     */
    public String titleAreaGetText() {
        return titleTextBar.getText();
    }

    /**
     * Check the title area's text equals with the text passed by parameter.
     *
     * @param s
     * @return true if the title areas"s text equals with the text passed by parameter, and the title area's text not empty
     * else false.
     */
    public boolean titleAreaTextIsVisible(String s) {
        return titleAreaGetText().equals(s) && !(titleAreaGetText().equals(""));
    }

    /**
     * Send the text passed by parameter to the title bar.
     *
     * @param s
     */
    public void sendTextToTitleTextBar(String s) {
        titleTextBar.sendKeys(s);
        log.info("The '" + s + "' text was sent to the title bar.");
    }

    /**
     * Delete the text from the title text bar.
     */
    public void clearTitleTextBar() {
        titleTextBar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        titleTextBar.sendKeys(Keys.BACK_SPACE);
        log.info("Title text bar cleared.");
    }

    /**
     * Check the Edit with a visual editor button is visible.
     *
     * @return true if the Edit with a visual editor button is visible, false if not.
     */
    public boolean editWithAVisualEditorButtonIsVisible() {
        waitForElement(editWithAVisualEditorButton);
        return editWithAVisualEditorButton.isDisplayed();
    }

    /**
     * Click the Edit with a visual editor button.
     */
    public void clickEditWithAVisualEditorButton() {
        editWithAVisualEditorButton.click();
        log.info("The Edit with a visual editor button is clicked.");
    }

    /**
     * Check the Add Dropdown button is visible.
     *
     * @return true if the Add Dropdown button is visible, false if not.
     */
    public boolean addDropdownIsVisible() {
        waitForElement(addDropdown);
        return addDropdown.isDisplayed();
    }

    /**
     * Click on the Add Dropdown button.
     */
    public void clickAddDropdown() {
        addDropdown.click();
        log.info("The Add dropdown is clicked.");
    }

    /**
     * Check the given type dropdown button is visible.
     *
     * @param dropdown
     * @param type
     */
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

    /**
     * Click the dropdown button passed by parameter.
     *
     * @param dropdown
     */
    public void clickTheAddDropdownButtonsElements(String dropdown) {
        findSpanElementByXpath(dropdown).click();
        log.info("The '" + dropdown + "' button is clicked.");
    }

    /**
     * Check the popup window is visible.
     *
     * @return true if the popup window is visible, false if not.
     */
    public boolean popupWindowIsVisible() {
        waitForElement(popupWindow);
        return popupWindow.isDisplayed();
    }

    /**
     * Check the cancel and insert button is visible on the popup window.
     *
     * @param buttonName
     * @return true if visible, false if not.
     */
    public boolean popupButtonsIsVisible(String buttonName) {
        switch (buttonName) {
            case "Cancel":
                waitForElement(popupCancelButton);
                return popupCancelButton.isDisplayed();
            case "Insert":
                waitForElement(popupInsertButton);
                return popupInsertButton.isDisplayed();
        }
        return false;
    }

    /**
     * Check the Media Library dropdown button is visible.
     *
     * @return true if the Media Library dropdown button is visible, false if not.
     */
    public boolean mediaLibraryDropdownButtonIsVisible() {
        waitForElement(mediaLibraryDropdownButton);
        return mediaLibraryDropdownButton.isDisplayed();
    }

    /**
     * Check the buttons state.
     *
     * @param state
     * @return true if the insert button is disabled and the cancel button is enabled
     * false if the insert button is enabled and the cancel button is disabled.
     */
    public boolean theButtonIsDisabled(String state) {
        switch (state) {
            case "disabled":
                return !popupInsertButton.isEnabled();
            case "enabled":
                return popupCancelButton.isEnabled();
        }
        return false;
    }

    /**
     * Click the Media Library dropdown button.
     */
    public void clickMediaLibraryDropdownButton() {
        waitForElement(mediaLibraryDropdownButton);
        mediaLibraryDropdownButton.click();
        log.info("Media library dropdown button was clicked.");
    }
}