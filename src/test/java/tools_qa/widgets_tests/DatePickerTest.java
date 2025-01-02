package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.DatePickerPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import java.text.ParseException;

import static org.assertj.core.api.Assertions.assertThat;

public class DatePickerTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private DatePickerPage datePickerPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        datePickerPage = new DatePickerPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToDatePickerPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToDatePickerPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldSelectDate() throws ParseException {

        // -------
        // ARRANGE
        // -------

        String date = datePickerPage.generateRandomDateAndTime(true);
        String formattedDate = datePickerPage.convertDate(date);

        // ---
        // ACT
        // ---

        navigateToDatePickerPage();
        datePickerPage.selectDate(date);

        // ------
        // ASSERT
        // ------

        assertThat(datePickerPage.getSelectDateInput().getDomProperty("value")).isEqualTo(formattedDate);
    }

    @Test
    public void shouldSelectDateAndTime() throws ParseException {

        // -------
        // ARRANGE
        // -------

        String dateAndTime = datePickerPage.generateRandomDateAndTime(false);
        String formattedDateAndTime = datePickerPage.convertDateAndTime(dateAndTime);

        // ---
        // ACT
        // ---

        navigateToDatePickerPage();
        datePickerPage.selectDateAndTime(dateAndTime);

        // ------
        // ASSERT
        // ------

        assertThat(datePickerPage.getSelectDateAndTimeInput().getDomProperty("value")).isEqualTo(formattedDateAndTime);
    }
}
