package tools_qa.pages.normal.interactions_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class DragabblePage extends BasePage {

    // https://demoqa.com/dragabble

    // NOTE: The creators made a mistake in the name of this sub-page. It should be "Draggable"

    // -----------
    // CONSTRUCTOR
    // -----------

    public DragabblePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // SIMPLE
    @FindBy(css = "#dragBox")
    private WebElement simpleDragMeBox;
    // AXIS RESTRICTED
    @FindBy(css = "#draggableExample-tab-axisRestriction")
    private WebElement axisTab;
    @FindBy(css = "#restrictedX")
    private WebElement axisOnlyXBox;
    @FindBy(css = "#restrictedY")
    private WebElement axisOnlyYBox;
    // CONTAINER RESTRICTED
    @FindBy(css = "#draggableExample-tab-containerRestriction")
    private WebElement containerTab;
    @FindBy(css = "#containmentWrapper .draggable")
    private WebElement containerBoxInContainer;
    @FindBy(css = ".draggable .ui-widget-header")
    private WebElement containerTextInContainer;
    // CURSOR STYLE
    @FindBy(css = "#draggableExample-tab-cursorStyle")
    private WebElement cursorTab;
    @FindBy(css = "#cursorCenter")
    private WebElement cursorCenterBox;
    @FindBy(css = "#cursorTopLeft")
    private WebElement cursorTopLeftBox;
    @FindBy(css = "#cursorBottom")
    private WebElement cursorBottomBox;

    // -------
    // METHODS
    // -------

    public DragabblePage setPositionLeft(WebElement movedElement, String targetLeft) {
        String script = "arguments[0].style.left = arguments[1];";
        jse.executeScript(script, movedElement, targetLeft);
        return this;
    }

    public DragabblePage setPositionTop(WebElement movedElement, String targetTop) {
        String script = "arguments[0].style.top = arguments[1];";
        jse.executeScript(script, movedElement, targetTop);
        return this;
    }

    public DragabblePage setPositionLeftAndTop(WebElement movedElement, String targetLeft, String targetTop) {
        setPositionLeft(movedElement, targetLeft);
        setPositionTop(movedElement, targetTop);
        return this;
    }

    public DragabblePage clickAxisRestrictedTab() {
        axisTab.click();
        return this;
    }

    public DragabblePage clickContainerRestrictedTab() {
        containerTab.click();
        return this;
    }

    public DragabblePage clickCursorStyleTab() {
        cursorTab.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    // SIMPLE

    public WebElement getSimpleDragMeBox() {
        return simpleDragMeBox;
    }

    // AXIS RESTRICTED

    public WebElement getAxisOnlyXBox() {
        return axisOnlyXBox;
    }

    public WebElement getAxisOnlyYBox() {
        return axisOnlyYBox;
    }

    // CONTAINER RESTRICTED

    public WebElement getContainerBoxInContainer() {
        return containerBoxInContainer;
    }

    public WebElement getContainerTextInContainer() {
        return containerTextInContainer;
    }

    // CURSOR STYLE

    public WebElement getCursorCenterBox() {
        return cursorCenterBox;
    }

    public WebElement getCursorTopLeftBox() {
        return cursorTopLeftBox;
    }

    public WebElement getCursorBottomBox() {
        return cursorBottomBox;
    }
}
