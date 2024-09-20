package tools_qa.alerts_frame_windows_tests;

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
                .switchTabOrWindowAndMaximize(1);

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
                .switchTabOrWindowAndMaximize(1);

        // ------
        // ASSERT
        // ------

        assertThat(browserWindowsPage.getNewTabWindowText().getText()).isEqualTo(expectedNewWindowText);
        assertThat(browserWindowsPage.getNewTabWindowBody().getCssValue(cssValue)).isEqualTo(colorGrayRGB);
    }
}

/*
NOTE:
    There was supposed to be a third test here to check the new message window.
But:
    After navigating to this window Selenium stops.
    There is no error, nor are any further actions performed.
    The browser and the window remain open all the time and must be closed manually.
This window:
    - Has a URL about:blank
    - Has empty "page source"
    - Has only simple HTML
I tried to perform this test in the following ways:
    - Go to the window and get the text using standard methods
    - Go to the window, go back to the previous window and go to that window again
    - Go to the window and get the text using JavaScript
    - Checking if Selenium treats this window as an alert
    - Go to the window, download the page source and look for the text there
    - After opening the window (with or without switching to it), press the key combination "Ctrl + A", "Ctrl + C"
    and try to get the text from the clipboard
Additional comment:
    I wonder if Playwright would be able to handle a window like that. I might check that out in the future.
*/
