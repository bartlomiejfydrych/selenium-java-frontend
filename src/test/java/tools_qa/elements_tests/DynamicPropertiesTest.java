package tools_qa.elements_tests;

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

    HomePage homePage;
    TrainingPage trainingPage;
    ElementsPage elementsPage;
    DynamicPropertiesPage dynamicPropertiesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver);
    }

    @Test
    public void shouldXpathWorkOnTextWithRandomId() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "This text has random Id";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToDynamicPropertiesPage();

        String actualText = dynamicPropertiesPage.getRandomIdText().getText();

        // ------
        // ASSERT
        // ------

        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test
    public void shouldButtonBeClickableAfterFiveSeconds() {

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToDynamicPropertiesPage();

        WebElement buttonClickable = dynamicPropertiesPage.waitForButtonBeClickable();

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

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToDynamicPropertiesPage();

        String buttonStartColor = dynamicPropertiesPage.getButtonColor();

        boolean colorChanged = dynamicPropertiesPage.waitForButtonChangeColor(buttonStartColor);

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

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToDynamicPropertiesPage();

        WebElement buttonVisible = dynamicPropertiesPage.waitForButtonBeVisible();

        // ------
        // ASSERT
        // ------

        assertThat(buttonVisible.isDisplayed()).isTrue();
    }
}
