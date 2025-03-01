package tools_qa.tests.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.ProgressBarPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgressBarTest extends TestBase {

    // https://demoqa.com/progress-bar

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private ProgressBarPage progressBarPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        progressBarPage = new ProgressBarPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToProgressBarPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToProgressBarPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldWaitUntilBarIsFullAndGreenAndResetItToZero() {

        // -------
        // ARRANGE
        // -------

        String progressBarValue100 = "100";
        String progressBarValue0 = "0";
        String progressBarColorGreen = "rgba(40, 167, 69, 1)";
        String progressBarColorBlue = "rgba(23, 162, 184, 1)";
        String progressBarAttribute = "aria-valuenow";
        String progressBarCss = "background-color";

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToProgressBarPage();

        // 100
        progressBarPage.clickStartStopButton()
                .waitForProgressBar(progressBarValue100);

        assertThat(progressBarPage.getProgressBar().getDomAttribute(progressBarAttribute)).isEqualTo(progressBarValue100);
        assertThat(progressBarPage.getProgressBar().getCssValue(progressBarCss)).isEqualTo(progressBarColorGreen);

        // Reset
        progressBarPage.clickResetButton()
                        .waitForProgressBar(progressBarValue0);

        assertThat(progressBarPage.getProgressBar().getDomAttribute(progressBarAttribute)).isEqualTo(progressBarValue0);
        assertThat(progressBarPage.getProgressBar().getCssValue(progressBarCss)).isEqualTo(progressBarColorBlue);
    }

    @Test
    public void shouldStopProgressBarAt1And50And99() {

        // -------
        // ARRANGE
        // -------

        String progressBarValue1 = "1";
        String progressBarValue50 = "50";
        String progressBarValue99 = "99";
        String progressBarColorBlue = "rgba(23, 162, 184, 1)";
        String progressBarAttribute = "aria-valuenow";
        String progressBarCss = "background-color";

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToProgressBarPage();

        // 1
        progressBarPage.clickStartStopButton()
                .waitForProgressBarAndClickStop(progressBarValue1);

        assertThat(progressBarPage.getProgressBar().getDomAttribute(progressBarAttribute)).isEqualTo(progressBarValue1);
        assertThat(progressBarPage.getProgressBar().getCssValue(progressBarCss)).isEqualTo(progressBarColorBlue);

        // 50
        progressBarPage.clickStartStopButton()
                .waitForProgressBarAndClickStop(progressBarValue50);

        assertThat(progressBarPage.getProgressBar().getDomAttribute(progressBarAttribute)).isEqualTo(progressBarValue50);
        assertThat(progressBarPage.getProgressBar().getCssValue(progressBarCss)).isEqualTo(progressBarColorBlue);

        // 99
        progressBarPage.clickStartStopButton()
                .waitForProgressBarAndClickStop(progressBarValue99);

        assertThat(progressBarPage.getProgressBar().getDomAttribute(progressBarAttribute)).isEqualTo(progressBarValue99);
        assertThat(progressBarPage.getProgressBar().getCssValue(progressBarCss)).isEqualTo(progressBarColorBlue);
    }
}
