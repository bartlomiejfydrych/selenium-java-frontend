package tools_qa.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.DroppablePage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DroppableTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    InteractionsPage interactionsPage;
    DroppablePage droppablePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        droppablePage = new DroppablePage(driver);
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

    }

    @Test
    public void shouldDragAndNotAcceptNotAcceptableElement() {

    }

    // PREVENT PROPOGATION

    @Test
    public void shouldDragElementToInnerBoxAndInfluenceOuterBox() {

    }

    @Test
    public void shouldDragElementToInnerBoxAndNotInfluenceOuterBox() {

    }

    // REVERT DRAGGABLE

    @Test
    public void shouldDragElementToBoxAndRevertHim() {

    }

    @Test
    public void shouldDragElementToBoxAndNotRevertHim() {

    }
}
