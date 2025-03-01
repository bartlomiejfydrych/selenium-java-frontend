package tools_qa.tests.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ButtonsPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ButtonsTest extends TestBase {

    // https://demoqa.com/buttons

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private ButtonsPage buttonsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void shouldCorrectClickAllButtonTypes() {

        // -------
        // ARRANGE
        // -------

        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedClickMessage = "You have done a dynamic click";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToButtonsPage();
        buttonsPage.clickDoubleClickMeButton()
                .clickRightClickMeButton()
                .clickClickMeButton();

        // ------
        // ASSERT
        // ------

        assertThat(buttonsPage.getDoubleClickMessage().isDisplayed()).isTrue();
        assertThat(buttonsPage.getDoubleClickMessage().getText()).isEqualTo(expectedDoubleClickMessage);
        assertThat(buttonsPage.getRightClickMessage().isDisplayed()).isTrue();
        assertThat(buttonsPage.getRightClickMessage().getText()).isEqualTo(expectedRightClickMessage);
        assertThat(buttonsPage.getClickMessage().isDisplayed()).isTrue();
        assertThat(buttonsPage.getClickMessage().getText()).isEqualTo(expectedClickMessage);
    }
}
