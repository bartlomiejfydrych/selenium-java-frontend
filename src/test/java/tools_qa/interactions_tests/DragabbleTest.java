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

public class DragabbleTest  extends TestBase {

    // NOTE: The creators made a mistake in the name of this sub-page. It should be "Draggable"

    HomePage homePage;
    TrainingPage trainingPage;
    InteractionsPage interactionsPage;
    DragabblePage dragabblePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        dragabblePage = new DragabblePage(driver);
    }

    // SIMPLE

    @Test
    public void shouldDragElementToMyLocation() {

        // -------
        // ARRANGE
        // -------

        WebElement dragBox = dragabblePage.getSimpleDragMeBox();
        String expectedLeftPosition = "785px";
        String expectedTopPosition = "47px";

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToDragabblePage();

        dragabblePage.setPositionLeftAndTop(dragBox, expectedLeftPosition, expectedTopPosition);

        // ------
        // ASSERT
        // ------

        assertThat(dragBox.getCssValue("left")).isEqualTo(expectedLeftPosition);
        assertThat(dragBox.getCssValue("top")).isEqualTo(expectedTopPosition);
    }
}
