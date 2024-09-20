package tools_qa.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    AlertsPage alertsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    @Test
    public void shouldOpenAlert() {

        // -------
        // ARRANGE
        // -------

        String alertText;
        String expectedAlertText = "You clicked a button";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeAdFrameAndFooter();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertButton()
                .waitForAlert();

        alertText = alertsPage.getAlertText();

        alertsPage.acceptAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertText).isEqualTo(expectedAlertText);
    }
}
