package tools_qa.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.FramesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FramesTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    FramesPage framesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        framesPage = new FramesPage(driver);
    }

    @Test
    public void shouldGetTextFromBigFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFrameText = "This is a sample page";
        String cssProperty = "background-color";
        String expectedBackgroundColor = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToFramesPage();

        framesPage.switchToBigFrame();

        // ------
        // ASSERT
        // ------

        assertThat(framesPage.getFrameHeading().getText()).isEqualTo(expectedFrameText);
        assertThat(framesPage.getFrameBody().getCssValue(cssProperty)).isEqualTo(expectedBackgroundColor);
    }

    @Test
    public void shouldGetTextFromSmallFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFrameText = "This is a sample page";
        String cssProperty = "background-color";
        String expectedBackgroundColor = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToFramesPage();

        framesPage.switchToSmallFrame();

        // ------
        // ASSERT
        // ------

        assertThat(framesPage.getFrameHeading().getText()).isEqualTo(expectedFrameText);
        assertThat(framesPage.getFrameBody().getCssValue(cssProperty)).isEqualTo(expectedBackgroundColor);
    }
}
