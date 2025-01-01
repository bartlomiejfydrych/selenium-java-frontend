package tools_qa.pages.normal.alerts_frame_windows_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

public class ModalDialogsPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public ModalDialogsPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Small modal
    @FindBy(css = "#showSmallModal")
    private WebElement smallModalButton;
    @FindBy(css = ".modal-body")
    private WebElement smallModalBody;
    @FindBy(css = "#closeSmallModal")
    private WebElement smallModalCloseButton;
    // Large modal
    @FindBy(css = "#showLargeModal")
    private WebElement largeModalButton;
    @FindBy(css = ".modal-body p")
    private WebElement largeModalBody;
    @FindBy(css = "#closeLargeModal")
    private WebElement largeModalCloseButton;
    // For both modals
    @FindBy(css = ".modal .modal-dialog .modal-content")
    private WebElement modalWindow;
    @FindBy(css = ".modal-title")
    private WebElement modalHeader;

    // -------
    // METHODS
    // -------

    // Small modal

    public ModalDialogsPage clickSmallModalButton() {
        smallModalButton.click();
        waitForModal();
        return this;
    }

    public ModalDialogsPage clickSmallModalCloseButton() {
        smallModalCloseButton.click();
        return this;
    }

    // Large modal

    public ModalDialogsPage clickLargeModalButton() {
        largeModalButton.click();
        waitForModal();
        return this;
    }

    public ModalDialogsPage clickLargeModalCloseButton() {
        largeModalCloseButton.click();
        return this;
    }

    // -------
    // HELPERS
    // -------

    private void waitForModal() {
        defaultWait.until(ExpectedConditions.visibilityOf(modalWindow));
    }

    // -------
    // GETTERS
    // -------

    public WebElement getModalWindow() {
        return modalWindow;
    }

    public WebElement getModalHeader() {
        return modalHeader;
    }

    public WebElement getSmallModalBody() {
        return smallModalBody;
    }

    public WebElement getLargeModalBody() {
        return largeModalBody;
    }
}
