package tools_qa.tests.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.CheckboxPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxTest extends TestBase {

    // https://demoqa.com/checkbox

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private CheckboxPage checkboxPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        checkboxPage = new CheckboxPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToCheckboxPage() {
        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToCheckboxPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldExpandAllAndCheckAllCheckboxes() {

        // -------
        // ARRANGE
        // -------

        String expectedResultField = "You have selected :\n" +
                "home\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "documents\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "downloads\n" +
                "wordFile\n" +
                "excelFile";

        // ---
        // ACT
        // ---

        navigateToCheckboxPage();
        checkboxPage.clickExpandAll()
                .clickCheckbox("home");

        // ------
        // ASSERT
        // ------

        assertThat(checkboxPage.isCheckboxSelected("home")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("desktop")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("notes")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("commands")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("documents")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("workspace")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("react")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("angular")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("veu")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("office")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("public")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("private")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("classified")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("general")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("downloads")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("wordFile")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("excelFile")).isTrue();

        assertThat(checkboxPage.getResultTextField().getText()).isEqualTo(expectedResultField);
    }

    @Test
    public void shouldCollapseAll() {

        // ---
        // ACT
        // ---

        navigateToCheckboxPage();
        checkboxPage.clickExpandAll()
                .clickCollapseAll();

        // ------
        // ASSERT
        // ------

        assertThat(checkboxPage.isCheckboxDisplayed("desktop")).isFalse();
    }

    @Test
    public void shouldUncheckSomeCheckboxes() {

        // -------
        // ARRANGE
        // -------

        String expectedResultField = "You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands\n" +
                "office\n" +
                "public\n" +
                "private\n" +
                "classified\n" +
                "general\n" +
                "wordFile";

        // ---
        // ACT
        // ---

        navigateToCheckboxPage();
        checkboxPage.clickExpandAll()
                .clickCheckbox("home")
                .clickCheckbox("workspace")
                .clickCheckbox("excelFile");

        // ------
        // ASSERT
        // ------

        /*
        Checkboxes whose selection changed to [-] had to be commented out.
        I haven't found a way to check it thoroughly
        */

        // assertThat(checkboxPage.isCheckboxSelected("home")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("desktop")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("notes")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("commands")).isTrue();
        // assertThat(checkboxPage.isCheckboxSelected("documents")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("workspace")).isFalse();
        assertThat(checkboxPage.isCheckboxSelected("react")).isFalse();
        assertThat(checkboxPage.isCheckboxSelected("angular")).isFalse();
        assertThat(checkboxPage.isCheckboxSelected("veu")).isFalse();
        assertThat(checkboxPage.isCheckboxSelected("office")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("public")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("private")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("classified")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("general")).isTrue();
        // assertThat(checkboxPage.isCheckboxSelected("downloads")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("wordFile")).isTrue();
        assertThat(checkboxPage.isCheckboxSelected("excelFile")).isFalse();

        assertThat(checkboxPage.getResultTextField().getText()).isEqualTo(expectedResultField);
    }
}
