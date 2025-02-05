package tools_qa.tests.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.AccordianPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AccordianTest extends TestBase {

    /*
    NOTE:
    There is a typo on the page and the correct name is "Accordions"
    but I use the name as it is on the page to be consistent.
    */

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private AccordianPage accordianPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        accordianPage = new AccordianPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToAccordianPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToAccordianPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldManuallyCloseFirstSection() {

        // ---
        // ACT
        // ---

        navigateToAccordianPage();
        accordianPage.clickSection1Button()
                .waitForElementToBeHidden(accordianPage.getSection1Text());

        // ------
        // ASSERT
        // ------

        assertThat(accordianPage.getSection1Text().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection2Text1().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection2Text2().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection3Text().isDisplayed()).isFalse();
    }

    @Test
    public void shouldManuallyOpenSecondSectionAndAutomaticallyCloseFirstSection() {

        // -------
        // ARRANGE
        // -------

        String expectedSection2Text1 = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a" +
                " piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock," +
                " a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin" +
                " words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical" +
                " literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33" +
                " of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC." +
                " This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line" +
                " of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";
        String expectedSection2Text2 = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those" +
                " interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also" +
                " reproduced in their exact original form, accompanied by English versions from the 1914 translation" +
                " by H. Rackham.";

        // ---
        // ACT
        // ---

        navigateToAccordianPage();
        accordianPage.clickSection2Button()
                .waitForElementToBeVisible(accordianPage.getSection2Text1())
                .waitForElementToBeVisible(accordianPage.getSection2Text2());

        // ------
        // ASSERT
        // ------

        assertThat(accordianPage.getSection2Text1().isDisplayed()).isTrue();
        assertThat(accordianPage.getSection2Text1().getText()).isEqualTo(expectedSection2Text1);
        assertThat(accordianPage.getSection2Text2().getText()).isEqualTo(expectedSection2Text2);
        assertThat(accordianPage.getSection1Text().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection3Text().isDisplayed()).isFalse();
    }

    @Test
    public void shouldManuallyCloseFirstSectionAndOpenManuallyThirdSection() {

        // -------
        // ARRANGE
        // -------

        String expectedSection3Text = "It is a long established fact that a reader will be distracted by the readable" +
                " content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a" +
                " more-or-less normal distribution of letters, as opposed to using 'Content here, content here'," +
                " making it look like readable English. Many desktop publishing packages and web page editors now" +
                " use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web" +
                " sites still in their infancy. Various versions have evolved over the years, sometimes by accident," +
                " sometimes on purpose (injected humour and the like).";

        // ---
        // ACT
        // ---

        navigateToAccordianPage();
        accordianPage.clickSection1Button()
                .waitForElementToBeHidden(accordianPage.getSection1Text())
                .clickSection3Button()
                .waitForElementToBeVisible(accordianPage.getSection3Text());

        // ------
        // ASSERT
        // ------

        assertThat(accordianPage.getSection3Text().isDisplayed()).isTrue();
        assertThat(accordianPage.getSection3Text().getText()).isEqualTo(expectedSection3Text);
        assertThat(accordianPage.getSection1Text().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection2Text1().isDisplayed()).isFalse();
        assertThat(accordianPage.getSection2Text2().isDisplayed()).isFalse();
    }
}
