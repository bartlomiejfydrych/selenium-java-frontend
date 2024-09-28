package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.DatePickerPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

public class DatePickerTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    DatePickerPage datePickerPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        datePickerPage = new DatePickerPage(driver);
    }

    @Test
    public void shouldSelectDate() {

        // -------
        // ARRANGE
        // -------

        // ---
        // ACT
        // ---

        // ------
        // ASSERT
        // ------

    }
}
