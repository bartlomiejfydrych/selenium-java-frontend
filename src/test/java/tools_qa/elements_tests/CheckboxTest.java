package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.CheckboxPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxTest extends TestBase {

    @Test
    public void shouldExpandAllAndCheckAllCheckboxes() {

        //--------
        // ARRANGE
        //--------

        CheckboxPage checkboxPage = new CheckboxPage(driver);
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

        //----
        // ACT
        //----

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckboxPage()
                .clickExpandAll()
                .clickHomeCheckbox();

        //-------
        // ASSERT
        //-------

        assertThat(checkboxPage.getAssertHomeCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertDesktopCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertNotesCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertCommandsCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertDocumentsCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertWorkSpaceCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertReactCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertAngularCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertVeuCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertOfficeCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertPublicCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertPrivateCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertClassifiedCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertGeneralCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertDownloadsCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertWordFileCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertExcelFileCheckbox().isSelected()).isTrue();

        String actualResultField = checkboxPage.getResultText();
        assertThat(actualResultField).isEqualTo(expectedResultField);
    }

    @Test
    public void shouldCollapseAll() {

        //--------
        // ARRANGE
        //--------

        CheckboxPage checkboxPage = new CheckboxPage(driver);
        WebElement desktopCheckBox = checkboxPage.getDesktopCheckbox();
        WebElementMethods webElementMethods = new WebElementMethods(driver);

        //----
        // ACT
        //----

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckboxPage()
                .clickExpandAll()
                .clickCollapseAll();

        //-------
        // ASSERT
        //-------

        assertThat(webElementMethods.isElementPresent(desktopCheckBox)).isFalse();
    }

    @Test
    public void shouldUncheckSomeCheckboxes() {

        //--------
        // ARRANGE
        //--------

        CheckboxPage checkboxPage = new CheckboxPage(driver);
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

        //----
        // ACT
        //----

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckboxPage()
                .clickExpandAll()
                .clickHomeCheckbox()
                .clickWorkSpaceCheckbox()
                .clickExcelFileCheckbox();

        //-------
        // ASSERT
        //-------

        /*
        Checkboxes whose selection changed to [-] had to be commented out.
        I haven't found a way to check it thoroughly
        */

        // assertThat(checkboxPage.getAssertHomeCheckBox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertDesktopCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertNotesCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertCommandsCheckbox().isSelected()).isTrue();
        // assertThat(checkboxPage.getAssertDocumentsCheckBox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertWorkSpaceCheckbox().isSelected()).isFalse();
        assertThat(checkboxPage.getAssertReactCheckbox().isSelected()).isFalse();
        assertThat(checkboxPage.getAssertAngularCheckbox().isSelected()).isFalse();
        assertThat(checkboxPage.getAssertVeuCheckbox().isSelected()).isFalse();
        assertThat(checkboxPage.getAssertOfficeCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertPublicCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertPrivateCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertClassifiedCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertGeneralCheckbox().isSelected()).isTrue();
        // assertThat(checkboxPage.getAssertDownloadsCheckBox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertWordFileCheckbox().isSelected()).isTrue();
        assertThat(checkboxPage.getAssertExcelFileCheckbox().isSelected()).isFalse();

        String actualResultField = checkboxPage.getResultText();
        assertThat(actualResultField).isEqualTo(expectedResultField);
    }
}
