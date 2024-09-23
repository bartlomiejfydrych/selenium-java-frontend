package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.AccordianPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

public class AccordianTest extends TestBase {

    /*
    NOTE:
    There is a typo on the page and the correct name is "Accordions"
    but I use the name as it is on the page to be consistent.
    */

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    AccordianPage accordianPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        accordianPage = new AccordianPage(driver);
    }

    @Test
    public void shouldCloseSection() {

    }
}
