package tools_qa.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.NestedFramesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NestedFramesTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    NestedFramesPage nestedFramesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        nestedFramesPage = new NestedFramesPage(driver);
    }

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

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToNestedFramesPage();

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

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToNestedFramesPage();

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
