package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class DroppablePage extends BasePage {

    // https://demoqa.com/droppable

    // -----------
    // CONSTRUCTOR
    // -----------

    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // SIMPLE
    @FindBy(css = "#draggable")
    private WebElement simpleDragMeBox;
    @FindBy(css = ".simple-drop-container #droppable")
    private WebElement simpleDropHereBox;
    // ACCEPT
    @FindBy(css = "#droppableExample-tab-accept")
    private WebElement acceptTab;
    @FindBy(css = "#acceptable")
    private WebElement acceptAcceptableBox;
    @FindBy(css = "#notAcceptable")
    private WebElement acceptNotAcceptableBox;
    @FindBy(css = ".accept-drop-container #droppable")
    private WebElement acceptDropHereBox;
    // PREVENT PROPOGATION
    @FindBy(css = "#droppableExample-tab-preventPropogation")
    private WebElement preventPropogationTab;
    @FindBy(css = "#dragBox")
    private WebElement preventDragMeBox;
    @FindBy(css = "#notGreedyDropBox")
    private WebElement preventUpperOuterDroppableBox;
    @FindBy(css = "#notGreedyInnerDropBox")
    private WebElement preventUpperInnerDroppableBox;
    @FindBy(css = "#greedyDropBox")
    private WebElement preventBottomOuterDroppableBox;
    @FindBy(css = "#greedyDropBoxInner")
    private WebElement preventBottomInnerDroppableBox;
    // REVERT DRAGGABLE
    @FindBy(css = "#droppableExample-tab-revertable")
    private WebElement revertDraggableTab;
    @FindBy(css = "#revertable")
    private WebElement revertWillRevertBox;
    @FindBy(css = "#notRevertable")
    private WebElement revertNotRevertBox;
    @FindBy(css = "#droppableExample-tabpane-revertable #droppable")
    private WebElement revertDropHereBox;

    // -------
    // METHODS
    // -------

    public DroppablePage moveElementToAnotherElement(WebElement movedElement, WebElement targetElement) {
        actions.clickAndHold(movedElement)
                .moveToElement(targetElement)
                .release()
                .perform();
        return this;
    }

    public DroppablePage clickAcceptTab() {
        acceptTab.click();
        return this;
    }

    public DroppablePage clickPreventPropogationTab() {
        preventPropogationTab.click();
        return this;
    }

    public DroppablePage clickRevertDraggableTab() {
        revertDraggableTab.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // SIMPLE

    public WebElement getSimpleDragMeBox() {
        return simpleDragMeBox;
    }

    public WebElement getSimpleDropHereBox() {
        return simpleDropHereBox;
    }

    // ACCEPT

    public WebElement getAcceptAcceptableBox() {
        return acceptAcceptableBox;
    }

    public WebElement getAcceptNotAcceptableBox() {
        return acceptNotAcceptableBox;
    }

    public WebElement getAcceptDropHereBox() {
        return acceptDropHereBox;
    }

    // PREVENT PROPOGATION (on the website they wrote it with a typo)

    public WebElement getPreventDragMeBox() {
        return preventDragMeBox;
    }

    public WebElement getPreventUpperOuterDroppableBox() {
        return preventUpperOuterDroppableBox;
    }

    public WebElement getPreventUpperInnerDroppableBox() {
        return preventUpperInnerDroppableBox;
    }

    public WebElement getPreventBottomOuterDroppableBox() {
        return preventBottomOuterDroppableBox;
    }

    public WebElement getPreventBottomInnerDroppableBox() {
        return preventBottomInnerDroppableBox;
    }

    // REVERT DRAGGABLE

    public WebElement getRevertWillRevertBox() {
        return revertWillRevertBox;
    }

    public WebElement getRevertNotRevertBox() {
        return revertNotRevertBox;
    }

    public WebElement getRevertDropHereBox() {
        return revertDropHereBox;
    }
}
