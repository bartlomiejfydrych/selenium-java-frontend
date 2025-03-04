package tools_qa.tests.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.FramesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FramesTest extends TestBase {

    // https://demoqa.com/frames

    private HomePage homePage;
    private TrainingPage trainingPage;
    private AlertsFrameWindowsPage alertsFrameWindowsPage;
    private FramesPage framesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        framesPage = new FramesPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToFramesPage() {
        homePage.goToAlertsFrameWindowsPage();
        trainingPage.removeFooterAndAds();
        alertsFrameWindowsPage.goToFramesPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldGetTextFromBigFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFramePageSource = "<html><head></head><body style=\"background-color:#a9a9a9\"><h1 id=\"sampleHeading\">This is a sample page</h1></body></html>";
        String expectedFrameText = "This is a sample page";
        String cssProperty = "background-color";
        String expectedBackgroundColor = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        navigateToFramesPage();
        framesPage.switchToBigFrame();
        String pageSource = framesPage.getPageSource();

        // ------
        // ASSERT
        // ------

        assertThat(pageSource).isEqualTo(expectedFramePageSource);
        assertThat(framesPage.getFrameHeading().getText()).isEqualTo(expectedFrameText);
        assertThat(framesPage.getFrameBody().getCssValue(cssProperty)).isEqualTo(expectedBackgroundColor);
    }

    @Test
    public void shouldGetTextFromSmallFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFramePageSource = "<html><head></head><body style=\"background-color:#a9a9a9\"><h1 id=\"sampleHeading\">This is a sample page</h1></body></html>";
        String expectedFrameText = "This is a sample page";
        String cssProperty = "background-color";
        String expectedBackgroundColor = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        navigateToFramesPage();
        framesPage.switchToSmallFrame();
        String pageSource = framesPage.getPageSource();

        // ------
        // ASSERT
        // ------

        assertThat(pageSource).isEqualTo(expectedFramePageSource);
        assertThat(framesPage.getFrameHeading().getText()).isEqualTo(expectedFrameText);
        assertThat(framesPage.getFrameBody().getCssValue(cssProperty)).isEqualTo(expectedBackgroundColor);
    }
}
