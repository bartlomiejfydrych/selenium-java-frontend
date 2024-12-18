package tools_qa.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.DroppablePage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    InteractionsPage interactionsPage;
    DroppablePage droppablePage;

    WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        droppablePage = new DroppablePage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    // SIMPLE

    @Test
    public void shouldDragElementIntoBox() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getSimpleDragMeBox();
        WebElement dropBox = droppablePage.getSimpleDropHereBox();
        String expectedDropBoxText = "Dropped!";
        String expectedBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "353px";
        String expectedTopPosition = "47px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.moveElementToAnotherElement(dragBox, dropBox);

        // ------
        // ASSERT
        // ------

        assertThat(dropBox.getText()).isEqualTo(expectedDropBoxText);
        assertThat(dropBox.getCssValue("background-color")).isEqualTo(expectedBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    // ACCEPT

    @Test
    public void shouldDragAndAcceptAcceptableElement() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getAcceptAcceptableBox();
        WebElement dropBox = droppablePage.getAcceptDropHereBox();
        String expectedDropBoxText = "Dropped!";
        String expectedBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "353px";
        String expectedTopPosition = "47px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickAcceptTab()
                .moveElementToAnotherElement(dragBox, dropBox);

        // ------
        // ASSERT
        // ------

        assertThat(dropBox.getText()).isEqualTo(expectedDropBoxText);
        assertThat(dropBox.getCssValue("background-color")).isEqualTo(expectedBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    @Test
    public void shouldDragAndNotAcceptNotAcceptableElement() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getAcceptNotAcceptableBox();
        WebElement dropBox = droppablePage.getAcceptDropHereBox();
        String expectedDropBoxText = "Drop here";
        String expectedBackgroundColor = "rgba(0, 0, 0, 0)";
        String expectedLeftPosition = "353px";
        String expectedTopPosition = "-17px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickAcceptTab()
                .moveElementToAnotherElement(dragBox, dropBox);

        // ------
        // ASSERT
        // ------

        assertThat(dropBox.getText()).isEqualTo(expectedDropBoxText);
        assertThat(dropBox.getCssValue("background-color")).isEqualTo(expectedBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    // PREVENT PROPOGATION

    @Test
    public void shouldDragElementToInnerBoxAndInfluenceOuterBox() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getPreventDragMeBox();
        WebElement innerDropBox = droppablePage.getPreventUpperInnerDroppableBox();
        WebElement outerDropBox = droppablePage.getPreventUpperOuterDroppableBox();
        String expectedOuterDropBoxText = "Dropped!\n" + "Dropped!";
        String expectedInnerDropBoxText = "Dropped!";
        String expectedBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "357px";
        String expectedTopPosition = "117px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickPreventPropogationTab()
                .moveElementToAnotherElement(dragBox, innerDropBox);

        // ------
        // ASSERT
        // ------

        assertThat(outerDropBox.getText()).isEqualTo(expectedOuterDropBoxText);
        assertThat(outerDropBox.getCssValue("background-color")).isEqualTo(expectedBackgroundColor);
        assertThat(innerDropBox.getText()).isEqualTo(expectedInnerDropBoxText);
        assertThat(innerDropBox.getCssValue("background-color")).isEqualTo(expectedBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    @Test
    public void shouldDragElementToInnerBoxAndNotInfluenceOuterBox() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getPreventDragMeBox();
        WebElement innerDropBox = droppablePage.getPreventBottomInnerDroppableBox();
        WebElement outerDropBox = droppablePage.getPreventBottomOuterDroppableBox();
        String expectedOuterDropBoxText = "Outer droppable\n" + "Dropped!";
        String expectedInnerDropBoxText = "Dropped!";
        String expectedOuterBoxBackgroundColor = "rgba(0, 0, 0, 0)";
        String expectedInnerBoxBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "357px";
        String expectedTopPosition = "391px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickPreventPropogationTab()
                .moveElementToAnotherElement(dragBox, innerDropBox);

        // ------
        // ASSERT
        // ------

        assertThat(outerDropBox.getText()).isEqualTo(expectedOuterDropBoxText);
        assertThat(outerDropBox.getCssValue("background-color")).isEqualTo(expectedOuterBoxBackgroundColor);
        assertThat(innerDropBox.getText()).isEqualTo(expectedInnerDropBoxText);
        assertThat(innerDropBox.getCssValue("background-color")).isEqualTo(expectedInnerBoxBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    // REVERT DRAGGABLE

    @Test
    public void shouldDragElementToBoxAndRevertHim() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getRevertWillRevertBox();
        WebElement dropBox = droppablePage.getRevertDropHereBox();
        String expectedDropBoxText = "Dropped!";
        String expectedDropBoxBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "0px";
        String expectedTopPosition = "0px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickRevertDraggableTab()
                .moveElementToAnotherElement(dragBox, dropBox);

        webElementMethods.waitForElementToStopMoving(dragBox);

        // ------
        // ASSERT
        // ------

        assertThat(dropBox.getText()).isEqualTo(expectedDropBoxText);
        assertThat(dropBox.getCssValue("background-color")).isEqualTo(expectedDropBoxBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    @Test
    public void shouldDragElementToBoxAndNotRevertHim() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = droppablePage.getRevertNotRevertBox();
        WebElement dropBox = droppablePage.getRevertDropHereBox();
        String expectedDropBoxText = "Dropped!";
        String expectedDropBoxBackgroundColor = "rgba(70, 130, 180, 1)";
        String expectedLeftPosition = "353px";
        String expectedTopPosition = "-17px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDroppablePage();

        droppablePage.clickRevertDraggableTab()
                .moveElementToAnotherElement(dragBox, dropBox);

        // ------
        // ASSERT
        // ------

        assertThat(dropBox.getText()).isEqualTo(expectedDropBoxText);
        assertThat(dropBox.getCssValue("background-color")).isEqualTo(expectedDropBoxBackgroundColor);
        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }
}
