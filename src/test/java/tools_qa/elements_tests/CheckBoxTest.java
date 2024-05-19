package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.CheckBoxPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckBoxTest extends TestBase {

    @Test
    public void shouldCheckAllCheckBoxes() {

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrame()
                .goToCheckBoxPage()
                .clickExpandAll()
                .clickHomeCheckBox();

        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        assertThat(checkBoxPage.getAssertHomeCheckBox().isSelected()).isTrue();
    }
}
