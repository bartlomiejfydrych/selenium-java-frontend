package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.CheckBoxPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckBoxTest extends TestBase {

    @Test
    public void shouldExpandAllAndCheckAllCheckBoxes() {

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrame()
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
    }

    @Test
    public void shouldUncheckSomeCheckBoxes() {

    }
}
