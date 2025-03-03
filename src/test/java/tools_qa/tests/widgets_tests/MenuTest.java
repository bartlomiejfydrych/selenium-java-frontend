package tools_qa.tests.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.MenuPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends TestBase {

    // https://demoqa.com/menu

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private MenuPage menuPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        menuPage = new MenuPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToMenuPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToMenuPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldFromItem1GoToItem3() {

        // -------
        // ARRANGE
        // -------

        String expectedButtonColor = "rgb(0, 63, 32) none repeat scroll 0% 0% / auto padding-box border-box";
        String cssValue = "background";

        // ---
        // ACT
        // ---

        navigateToMenuPage();
        menuPage.hoverOverMainItem3();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getMenuButtons().get(7).getCssValue(cssValue)).isEqualTo(expectedButtonColor);
    }

    @Test
    public void shouldGoToSubSubItem2() {

        // -------
        // ARRANGE
        // -------

        String expectedButtonColor = "rgb(0, 63, 32) none repeat scroll 0% 0% / auto padding-box border-box";
        String cssValue = "background";

        // ---
        // ACT
        // ---

        navigateToMenuPage();
        menuPage.hoverOverSubSubItem2();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getMenuButtons().get(6).getCssValue(cssValue)).isEqualTo(expectedButtonColor);
    }
}
