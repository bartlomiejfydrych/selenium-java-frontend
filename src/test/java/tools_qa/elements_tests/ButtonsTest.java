package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.ButtonsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ButtonsTest extends TestBase {

    @Test
    public void shouldCorrectClickAllButtonTypes() {

        // -------
        // ARRANGE
        // -------

        ButtonsPage buttonsPage = new ButtonsPage(driver);
        String expectedDoubleClickMessage = "You have done a double click";
        String expectedRightClickMessage = "You have done a right click";
        String expectedClickMessage = "You have done a dynamic click";

        // ---
        // ACT
        // ---

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToButtonsPage()
                .clickDoubleClickMeButton()
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
