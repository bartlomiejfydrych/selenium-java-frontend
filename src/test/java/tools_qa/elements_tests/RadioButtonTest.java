package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.RadioButtonPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class RadioButtonTest extends TestBase {

    @Test
    public void shouldCheckYesRadioButton() {

        //----------
        // VARIABLES
        //----------

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        String expectedText = "Yes";

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToRadioButtonPage()
                .clickYesRadioButton();

        //-----------
        // ASSERTIONS
        //-----------

        String actualText = radioButtonPage.getConfirmationText();

        assertThat(radioButtonPage.getYesRadioButton().isSelected()).isTrue();
        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test
    public void shouldCheckImpressiveRadioButton() {

        //----------
        // VARIABLES
        //----------

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        String expectedText = "Impressive";

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToRadioButtonPage()
                .clickImpressiveRadioButton();

        //-----------
        // ASSERTIONS
        //-----------

        String actualText = radioButtonPage.getConfirmationText();

        assertThat(radioButtonPage.getImpressiveRadioButton().isSelected()).isTrue();
        assertThat(actualText).isEqualTo(expectedText);
    }

    @Test
    public void shouldNotCheckNoRadioButton() {

        //----------
        // VARIABLES
        //----------

        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);
        WebElement noRadioButton = radioButtonPage.getNoRadioButton();
        WebElementMethods webElementMethods = new WebElementMethods(driver);

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToRadioButtonPage();

        //-----------
        // ASSERTIONS
        //-----------

        assertThat(webElementMethods.isElementClickable(noRadioButton)).isFalse();
    }
}
