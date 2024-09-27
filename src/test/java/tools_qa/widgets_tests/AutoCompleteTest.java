package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.AutoCompletePage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoCompleteTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    AutoCompletePage autoCompletePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        autoCompletePage = new AutoCompletePage(driver);
    }

    @Test
    public void shouldWriteAllColorsAndClearInput() {

        // -------
        // ARRANGE
        // -------

        List<String> colorList = Arrays.asList(
                "Aqua",
                "Yellow",
                "White",
                "Red",
                "Blue",
                "Green",
                "Purple",
                "Voilet", // NOTE: Another typo on site. Should be "Violet".
                "Magenta",
                "Indigo",
                "Black"
        );

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeAdFrameAndFooter();

        widgetsPage.goToAutoCompletePage();

        autoCompletePage.writeColors(colorList);

        // ------
        // ASSERT
        // ------

        for (int i = 0; i < colorList.size(); i++) {
            assertThat(autoCompletePage.getColorsInInput().get(i).getText()).isEqualTo(colorList.get(i));
        }

        // Clear
        autoCompletePage.clickClearMultipleColorInputButton();

        assertThat(autoCompletePage.getColorsInInput()).isEmpty();
    }

    @Test
    public void shouldWriteColorAndClearThatColor() {

        // -------
        // ARRANGE
        // -------


        // ---
        // ACT
        // ---


        // ------
        // ASSERT
        // ------


    }

    @Test
    public void shouldWriteOnlyOneColor() {

        // -------
        // ARRANGE
        // -------


        // ---
        // ACT
        // ---


        // ------
        // ASSERT
        // ------


    }
}
