package tools_qa.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.DragabblePage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DragabbleTest extends TestBase {

    // NOTE: The creators made a mistake in the name of this sub-page. It should be "Draggable"

    private HomePage homePage;
    private TrainingPage trainingPage;
    private InteractionsPage interactionsPage;
    private DragabblePage dragabblePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        dragabblePage = new DragabblePage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToDragabblePage() {
        homePage.goToInteractionsPage();
        trainingPage.removeFooterAndAds();
        interactionsPage.goToDragabblePage();
    }

    // -----
    // TESTS
    // -----

    // SIMPLE

    @Test
    public void shouldDragSimpleElementToSetLocation() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = dragabblePage.getSimpleDragMeBox();
        String expectedLeftPosition = "785px";
        String expectedTopPosition = "47px";

        // ---
        // ACT
        // ---

        navigateToDragabblePage();
        dragabblePage.setPositionLeftAndTop(dragBox, expectedLeftPosition, expectedTopPosition);

        // ------
        // ASSERT
        // ------

        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }

    // AXIS RESTRICTED

    @Test
    public void shouldDragAxisElementXAndYToSetLocation() {

        // -------
        // ARRANGE
        // -------

        // BOX X
        WebElement dragBoxX = dragabblePage.getAxisOnlyXBox();
        String expectedBoxXLeftPosition = "573px";
        String expectedBoxXTopPosition = "0px";
        // BOX Y
        WebElement dragBoxY = dragabblePage.getAxisOnlyYBox();
        String expectedBoxYLeftPosition = "0px";
        String expectedBoxYTopPosition = "-95px";

        // ---
        // ACT
        // ---

        navigateToDragabblePage();
        dragabblePage.clickAxisRestrictedTab()
                .setPositionLeft(dragBoxX, expectedBoxXLeftPosition)
                .setPositionTop(dragBoxY, expectedBoxYTopPosition);

        // ------
        // ASSERT
        // ------

        // BOX X
        assertThat(dragBoxX.getCssValue("left")).isEqualTo(expectedBoxXLeftPosition);
        assertThat(dragBoxX.getCssValue("top")).isEqualTo(expectedBoxXTopPosition);
        // BOX Y
        assertThat(dragBoxY.getCssValue("left")).isEqualTo(expectedBoxYLeftPosition);
        assertThat(dragBoxY.getCssValue("top")).isEqualTo(expectedBoxYTopPosition);
    }

    // CONTAINER RESTRICTED

    @Test
    public void shouldDragContainerElementsToSetLocation() {

        // -------
        // ARRANGE
        // -------

        // Box in container
        WebElement dragBoxInContainer = dragabblePage.getContainerBoxInContainer();
        String expectedBoxInContainerLeftPosition = "673px";
        String expectedBoxInContainerTopPosition = "106px";
        // Text in container
        WebElement dragTextInContainer = dragabblePage.getContainerTextInContainer();
        String expectedTextInContainerLeftPosition = "13px";
        String expectedTextInContainerTopPosition = "86px";

        // ---
        // ACT
        // ---

        navigateToDragabblePage();
        dragabblePage.clickContainerRestrictedTab()
                .setPositionLeftAndTop(dragBoxInContainer, expectedBoxInContainerLeftPosition, expectedBoxInContainerTopPosition)
                .setPositionLeftAndTop(dragTextInContainer, expectedTextInContainerLeftPosition, expectedTextInContainerTopPosition);

        // ------
        // ASSERT
        // ------

        // Box in container
        assertThat(dragBoxInContainer.getCssValue("left")).isEqualTo(expectedBoxInContainerLeftPosition);
        assertThat(dragBoxInContainer.getCssValue("top")).isEqualTo(expectedBoxInContainerTopPosition);
        // Text in container
        assertThat(dragTextInContainer.getCssValue("left")).isEqualTo(expectedTextInContainerLeftPosition);
        assertThat(dragTextInContainer.getCssValue("top")).isEqualTo(expectedTextInContainerTopPosition);
    }

    // CURSOR STYLE

    @Test
    public void shouldDragCursorElementsToSetLocation() {

        // -------
        // ARRANGE
        // -------

        // Top left box
        WebElement dragTopLeftBox = dragabblePage.getCursorTopLeftBox();
        String expectedTopLeftBoxLeftPosition = "784.25px";
        String expectedTopLeftBoxTopPosition = "-130px";
        // Center box
        WebElement dragCenterBox = dragabblePage.getCursorCenterBox();
        String expectedCenterBoxLeftPosition = "784.25px";
        String expectedCenterBoxTopPosition = "100px";
        // Bottom box
        WebElement dragBottomBox = dragabblePage.getCursorBottomBox();
        String expectedBottomBoxLeftPosition = "784.25px";
        String expectedBottomBoxTopPosition = "-20px";

        // ---
        // ACT
        // ---

        navigateToDragabblePage();
        dragabblePage.clickCursorStyleTab()
                .setPositionLeftAndTop(dragTopLeftBox, expectedTopLeftBoxLeftPosition, expectedTopLeftBoxTopPosition)
                .setPositionLeftAndTop(dragCenterBox, expectedCenterBoxLeftPosition, expectedCenterBoxTopPosition)
                .setPositionLeftAndTop(dragBottomBox, expectedBottomBoxLeftPosition, expectedBottomBoxTopPosition);

        // ------
        // ASSERT
        // ------

        // Top left box
        assertThat(dragTopLeftBox.getCssValue("left")).isEqualTo(expectedTopLeftBoxLeftPosition);
        assertThat(dragTopLeftBox.getCssValue("top")).isEqualTo(expectedTopLeftBoxTopPosition);
        // Center box
        assertThat(dragCenterBox.getCssValue("left")).isEqualTo(expectedCenterBoxLeftPosition);
        assertThat(dragCenterBox.getCssValue("top")).isEqualTo(expectedCenterBoxTopPosition);
        // Bottom box
        assertThat(dragBottomBox.getCssValue("left")).isEqualTo(expectedBottomBoxLeftPosition);
        assertThat(dragBottomBox.getCssValue("top")).isEqualTo(expectedBottomBoxTopPosition);
    }
}
