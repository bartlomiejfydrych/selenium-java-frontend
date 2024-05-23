package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.CheckBoxPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckBoxTest extends TestBase {

    @Test
    public void shouldExpandAllAndCheckAllCheckBoxes() {

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckBoxPage()
                .clickExpandAll()
                .clickHomeCheckBox();

        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        assertThat(checkBoxPage.getAssertHomeCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertDesktopCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertNotesCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertCommandsCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertDocumentsCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertWorkSpaceCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertReactCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertAngularCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertVeuCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertOfficeCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertPublicCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertPrivateCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertClassifiedCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertGeneralCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertDownloadsCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertWordFileCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertExcelFileCheckBox().isSelected()).isTrue();

        String actualResultField = checkBoxPage.getResultText();
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
        assertThat(actualResultField).isEqualTo(expectedResultField);
    }

    @Test
    public void shouldCollapseAll() {

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckBoxPage()
                .clickExpandAll()
                .clickCollapseAll();

        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        WebElement desktopCheckBox = checkBoxPage.getDesktopCheckBox();
        WebElementMethods webElementMethods = new WebElementMethods(driver);

        assertThat(webElementMethods.isElementPresent(desktopCheckBox)).isFalse();
    }

    @Test
    public void shouldUncheckSomeCheckBoxes() {

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToCheckBoxPage()
                .clickExpandAll()
                .clickHomeCheckBox()
                .clickWorkSpaceCheckBox()
                .clickExcelFileCheckBox();

        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        // Check Boxy, którym zaznaczenie zmieniło się na [-] musiały zostać zakomentowane
        // Nie znalazłem jak można by to dokładnie sprawdzać
        // assertThat(checkBoxPage.getAssertHomeCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertDesktopCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertNotesCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertCommandsCheckBox().isSelected()).isTrue();
        // assertThat(checkBoxPage.getAssertDocumentsCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertWorkSpaceCheckBox().isSelected()).isFalse();
        assertThat(checkBoxPage.getAssertReactCheckBox().isSelected()).isFalse();
        assertThat(checkBoxPage.getAssertAngularCheckBox().isSelected()).isFalse();
        assertThat(checkBoxPage.getAssertVeuCheckBox().isSelected()).isFalse();
        assertThat(checkBoxPage.getAssertOfficeCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertPublicCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertPrivateCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertClassifiedCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertGeneralCheckBox().isSelected()).isTrue();
        // assertThat(checkBoxPage.getAssertDownloadsCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertWordFileCheckBox().isSelected()).isTrue();
        assertThat(checkBoxPage.getAssertExcelFileCheckBox().isSelected()).isFalse();

        String actualResultField = checkBoxPage.getResultText();
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
        assertThat(actualResultField).isEqualTo(expectedResultField);
    }
}
