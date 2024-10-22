package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.ToolTipsPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ToolTipsTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    ToolTipsPage toolTipsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        toolTipsPage = new ToolTipsPage(driver);
    }

    @Test
    public void shouldHoverOverButton() {

        // -------
        // ARRANGE
        // -------

        String expectedHoverText = "You hovered over the Button";

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToToolTipsPage();

        toolTipsPage.hoverOverButton();

        // ------
        // ASSERT
        // ------

        assertThat(toolTipsPage.getTooltipText().getText()).isEqualTo(expectedHoverText);
    }

    @Test
    public void shouldHoverOverInput() {

        // -------
        // ARRANGE
        // -------

        String expectedHoverText = "You hovered over the text field";

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToToolTipsPage();

        toolTipsPage.hoverOverInput();

        // ------
        // ASSERT
        // ------

        assertThat(toolTipsPage.getTooltipText().getText()).isEqualTo(expectedHoverText);
    }

    @Test
    public void shouldHoverOverContrary() {

        // -------
        // ARRANGE
        // -------

        String expectedHoverText = "You hovered over the Contrary";

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToToolTipsPage();

        toolTipsPage.hoverOverContraryText();

        // ------
        // ASSERT
        // ------

        assertThat(toolTipsPage.getTooltipText().getText()).isEqualTo(expectedHoverText);
    }

    @Test
    public void shouldHoverOver11032() {

        // -------
        // ARRANGE
        // -------

        String expectedHoverText = "You hovered over the 1.10.32";

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToToolTipsPage();

        toolTipsPage.hoverOver11032Text();

        // ------
        // ASSERT
        // ------

        assertThat(toolTipsPage.getTooltipText().getText()).isEqualTo(expectedHoverText);
    }
}
