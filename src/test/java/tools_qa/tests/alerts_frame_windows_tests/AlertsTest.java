package tools_qa.tests.alerts_frame_windows_tests;

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

    private HomePage homePage;
    private TrainingPage trainingPage;
    private AlertsFrameWindowsPage alertsFrameWindowsPage;
    private AlertsPage alertsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToAlertsPage() {
        homePage.goToAlertsFrameWindowsPage();
        trainingPage.removeFooterAndAds();
        alertsFrameWindowsPage.goToAlertsPage();
    }

    // ----
    // TEST
    // ----

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

        navigateToAlertsPage();
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

        navigateToAlertsPage();
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

        navigateToAlertsPage();
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

        navigateToAlertsPage();
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

        navigateToAlertsPage();
        alertsPage.clickAlertPromptButton()
                .writeTextInAlertAndAccept(textWriteInAlert);

        // ------
        // ASSERT
        // ------

        assertThat(alertsPage.getPromptAlertText().getText()).isEqualTo(expectedTextAfterAction);
        assertThat(alertsPage.getPromptAlertText().getCssValue(cssProperty)).isEqualTo(expectedTextColor);
    }
}
