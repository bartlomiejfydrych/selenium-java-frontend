package tools_qa.tests.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.NestedFramesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedFramesTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private AlertsFrameWindowsPage alertsFrameWindowsPage;
    private NestedFramesPage nestedFramesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToNestedFramesPage() {
        homePage.goToAlertsFrameWindowsPage();
        trainingPage.removeFooterAndAds();
        alertsFrameWindowsPage.goToNestedFramesPage();
    }

    // ----
    // TEST
    // ----

    @Test
    public void shouldGetTextFromParentFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFramePageSource = "<html><head></head><body>Parent frame<iframe srcdoc=\"<p>Child Iframe</p>\"></iframe></body></html>";
        String expectedFrameText = "Parent frame";

        // ---
        // ACT
        // ---

        navigateToNestedFramesPage();
        nestedFramesPage.switchToParentFrame();
        String pageSource = nestedFramesPage.getPageSource();

        // ------
        // ASSERT
        // ------

        assertThat(pageSource).isEqualTo(expectedFramePageSource);
        assertThat(nestedFramesPage.getParentFrameBody().getText()).isEqualTo(expectedFrameText);
    }

    @Test
    public void shouldGetTextFromChildFrame() {

        // -------
        // ARRANGE
        // -------

        String expectedFramePageSource = "<html><head></head><body><p>Child Iframe</p></body></html>";
        String expectedFrameText = "Child Iframe";

        // ---
        // ACT
        // ---

        navigateToNestedFramesPage();
        nestedFramesPage.switchToParentFrame()
                .switchToChildFrame();
        String pageSource = nestedFramesPage.getPageSource();

        // ------
        // ASSERT
        // ------

        assertThat(pageSource).isEqualTo(expectedFramePageSource);
        assertThat(nestedFramesPage.getParentFrameBody().getText()).isEqualTo(expectedFrameText);
    }
}
