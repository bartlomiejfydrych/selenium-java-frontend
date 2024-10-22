package tools_qa.alerts_frame_windows_tests;

import com.github.javafaker.Faker;
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

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertButton();

        alertText = alertsPage.getAlertText();

        alertsPage.acceptAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertText).isEqualTo(expectedAlertText);
    }

    @Test
    public void shouldWaitForAlert() {

        // -------
        // ARRANGE
        // -------

        String alertText;
        String expectedAlertText = "This alert appeared after 5 seconds";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertFiveSecondsButton();

        alertText = alertsPage.getAlertText();

        alertsPage.acceptAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertText).isEqualTo(expectedAlertText);
    }

    @Test
    public void shouldAcceptConfirmAlert() {

        // -------
        // ARRANGE
        // -------

        String expectedTextAfterAction = "You selected Ok";
        String cssProperty = "color";
        String expectedTextColor = "rgba(40, 167, 69, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertConfirmButton()
                .acceptAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertsPage.getConfirmAlertText().getText()).isEqualTo(expectedTextAfterAction);
        assertThat(alertsPage.getConfirmAlertText().getCssValue(cssProperty)).isEqualTo(expectedTextColor);
    }

    @Test
    public void shouldDismissConfirmAlert() {

        // -------
        // ARRANGE
        // -------

        String expectedTextAfterAction = "You selected Cancel";
        String cssProperty = "color";
        String expectedTextColor = "rgba(40, 167, 69, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertConfirmButton()
                .dismissAlert();

        // ------
        // ASSERT
        // ------

        assertThat(alertsPage.getConfirmAlertText().getText()).isEqualTo(expectedTextAfterAction);
        assertThat(alertsPage.getConfirmAlertText().getCssValue(cssProperty)).isEqualTo(expectedTextColor);
    }

    @Test
    public void shouldWriteTextInPromptAlert() {

        // -------
        // ARRANGE
        // -------

        Faker faker = new Faker();
        String textWriteInAlert = faker.lorem().sentence();
        String expectedTextAfterAction = "You entered " + textWriteInAlert;
        String cssProperty = "color";
        String expectedTextColor = "rgba(40, 167, 69, 1)";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToAlertsPage();

        alertsPage.clickAlertPromptButton()
                .writeTextInAlert(textWriteInAlert);

        // ------
        // ASSERT
        // ------

        assertThat(alertsPage.getPromptAlertText().getText()).isEqualTo(expectedTextAfterAction);
        assertThat(alertsPage.getPromptAlertText().getCssValue(cssProperty)).isEqualTo(expectedTextColor);
    }
}
