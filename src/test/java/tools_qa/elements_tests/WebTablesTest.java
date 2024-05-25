package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.WebTablesPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest extends TestBase {

    @Test
    public void shouldSearchFindCorrectElementByLastName() {

        String textToSearch = "Gentry";

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToWebTablesPage()
                .writeTextToSearch(textToSearch);

        WebTablesPage webTablesPage = new WebTablesPage(driver);
        List<WebElement> firstRowCells = webTablesPage.getFirstRowCells();

        assertThat(firstRowCells.get(1).getText()).isEqualTo(textToSearch);
    }

    @Test
    public void shouldCreateFindEditAndDeleteRow() {

    }
}
