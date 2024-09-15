package alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.BrowserWindowsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class BrowserWindowsTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    BrowserWindowsPage browserWindowsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
    }

    @Test
    public void shouldOpenNewTab() {

        // -------
        // ARRANGE
        // -------

        String expectedNewTabText = "This is a sample page";
        String cssValue = "background-color";
        String colorGrayRGB = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToBrowserWindowsPage();

        browserWindowsPage.clickNewTabButton()
                .switchTabOrWindow(1);

        // ------
        // ASSERT
        // ------

        assertThat(browserWindowsPage.getNewTabWindowText().getText()).isEqualTo(expectedNewTabText);
        assertThat(browserWindowsPage.getNewTabWindowBody().getCssValue(cssValue)).isEqualTo(colorGrayRGB);
    }

    @Test
    public void shouldOpenNewWindow() {

        // -------
        // ARRANGE
        // -------

        String expectedNewWindowText = "This is a sample page";
        String cssValue = "background-color";
        String colorGrayRGB = "rgba(169, 169, 169, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToBrowserWindowsPage();

        browserWindowsPage.clickNewWindowButton()
                .switchTabOrWindow(1);

        // ------
        // ASSERT
        // ------

        assertThat(browserWindowsPage.getNewTabWindowText().getText()).isEqualTo(expectedNewWindowText);
        assertThat(browserWindowsPage.getNewTabWindowBody().getCssValue(cssValue)).isEqualTo(colorGrayRGB);
    }

    @Test
    public void shouldOpenNewWindowMessage() {

        // -------
        // ARRANGE
        // -------

        String expectedNewWindowText = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToBrowserWindowsPage();

        browserWindowsPage.clickNewWindowMessageButton()
                .switchTabOrWindow(1);

        // ------
        // ASSERT
        // ------

        assertThat(browserWindowsPage.getNewTabWindowBody().getText()).isEqualTo(expectedNewWindowText);
    }
}
