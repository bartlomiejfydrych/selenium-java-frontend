package tools_qa.tests.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.DynamicPropertiesPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicPropertiesTest extends TestBase {

    // https://demoqa.com/dynamic-properties

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private DynamicPropertiesPage dynamicPropertiesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToDynamicPropertiesPage() {
        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToDynamicPropertiesPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldXpathWorkOnTextWithRandomId() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "This text has random Id";

        // ---
        // ACT
        // ---

        navigateToDynamicPropertiesPage();

        String actualText = dynamicPropertiesPage.getRandomIdText().getText();
        String textFirstID = dynamicPropertiesPage.getRandomIdText().getDomAttribute("id");
        driver.navigate().refresh();
        String textSecondID = dynamicPropertiesPage.getRandomIdText().getDomAttribute("id");

        // ------
        // ASSERT
        // ------

        assertThat(actualText).isEqualTo(expectedText);
        assertThat(textSecondID).isNotEqualTo(textFirstID);
    }

    @Test
    public void shouldButtonBeClickableAfterFiveSeconds() {

        // ---
        // ACT
        // ---

        navigateToDynamicPropertiesPage();

        WebElement buttonClickable = dynamicPropertiesPage.waitForButtonToBeClickable();

        // ------
        // ASSERT
        // ------

        assertThat(buttonClickable.isEnabled()).isTrue();
    }

    @Test
    public void shouldButtonChangeColorAfterSomeTime() {

        // -------
        // ARRANGE
        // -------

        String expectedColor = "rgba(220, 53, 69, 1)";

        // ---
        // ACT
        // ---

        navigateToDynamicPropertiesPage();

        String buttonStartColor = dynamicPropertiesPage.getButtonColor();
        boolean colorChanged = dynamicPropertiesPage.waitForButtonColorChange(buttonStartColor);
        String buttonEndColor = dynamicPropertiesPage.getButtonColor();

        // ------
        // ASSERT
        // ------

        assertThat(colorChanged).isTrue();
        assertThat(buttonEndColor).isEqualTo(expectedColor);
    }

    @Test
    public void shouldButtonBeVisibleAfterFiveSeconds() {

        // ---
        // ACT
        // ---

        navigateToDynamicPropertiesPage();

        WebElement buttonVisible = dynamicPropertiesPage.waitForButtonToBeVisible();

        // ------
        // ASSERT
        // ------

        assertThat(buttonVisible.isDisplayed()).isTrue();
    }
}
