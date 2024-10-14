package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.ProgressBarPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

public class ProgressBarTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    ProgressBarPage progressBarPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        progressBarPage = new ProgressBarPage(driver);
    }

    @Test
    public void shouldWaitUntilBarIsFullAndGreenAndResetItToZero() {

        // -------
        // ARRANGE
        // -------

        // ------------
        // ACT + ASSERT
        // ------------

    }

    @Test
    public void shouldStopProgressBarAt1And100() {

        // -------
        // ARRANGE
        // -------

        // ------------
        // ACT + ASSERT
        // ------------

    }
}
