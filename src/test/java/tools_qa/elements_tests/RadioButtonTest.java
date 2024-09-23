package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.RadioButtonPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class RadioButtonTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    ElementsPage elementsPage;
    RadioButtonPage radioButtonPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test
    public void shouldCheckYesRadioButton() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "Yes";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToRadioButtonPage();

        radioButtonPage.clickYesRadioButton();

        // ------
        // ASSERT
        // ------

        String actualText = radioButtonPage.getConfirmationText().getText();

        assertThat(radioButtonPage.getYesRadioButton().isSelected()).isTrue();
        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test
    public void shouldCheckImpressiveRadioButton() {

        // -------
        // ARRANGE
        // -------

        String expectedText = "Impressive";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToRadioButtonPage();

        radioButtonPage.clickImpressiveRadioButton();

        // ------
        // ASSERT
        // ------

        String actualText = radioButtonPage.getConfirmationText().getText();

        assertThat(radioButtonPage.getImpressiveRadioButton().isSelected()).isTrue();
        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test
    public void shouldNotCheckNoRadioButton() {

        // -------
        // ARRANGE
        // -------

        WebElement noRadioButton = radioButtonPage.getNoRadioButton();
        WebElementMethods webElementMethods = new WebElementMethods(driver);

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        trainingPage.removeAdFrameAndFooter();

        elementsPage.goToRadioButtonPage();

        // ------
        // ASSERT
        // ------

        assertThat(webElementMethods.isElementClickable(noRadioButton)).isFalse();
    }
}
