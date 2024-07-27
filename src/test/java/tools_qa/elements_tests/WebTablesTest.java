package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.models.TableRow;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.WebTablesPage;
import tools_qa.providers.TableRowProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTablesTest extends TestBase {

    HomePage homePage;
    ElementsPage elementsPage;
    WebTablesPage webTablesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        webTablesPage = new WebTablesPage(driver);
    }

    @Test
    public void shouldAddFindEditAndDeleteRow() {

        // -------
        // ADD ROW
        // -------

        TableRow addedTableRow = TableRowProvider.getRandomTableRow();

        homePage.goToElementsPage();

        elementsPage.removeAdFrameAndFooter()
                .goToWebTablesPage();

        webTablesPage.clickAddNewRowButton()
                .fillRowForm(addedTableRow);

        // --------
        // FIND ROW
        // --------

        webTablesPage.writeTextToSearch(addedTableRow.getFirstName());
        List<WebElement> firstRowCellsFromAdd = webTablesPage.getFirstRowCells();
        // Assert added row
        assertThat(firstRowCellsFromAdd.get(0).getText()).isEqualTo(addedTableRow.getFirstName());
        assertThat(firstRowCellsFromAdd.get(1).getText()).isEqualTo(addedTableRow.getLastName());
        assertThat(firstRowCellsFromAdd.get(2).getText()).isEqualTo(addedTableRow.getAge());
        assertThat(firstRowCellsFromAdd.get(3).getText()).isEqualTo(addedTableRow.getEmail());
        assertThat(firstRowCellsFromAdd.get(4).getText()).isEqualTo(addedTableRow.getSalary());
        assertThat(firstRowCellsFromAdd.get(5).getText()).isEqualTo(addedTableRow.getDepartment());

        // --------
        // EDIT ROW
        // --------

        TableRow editedTableRow = TableRowProvider.getRandomTableRow();

        webTablesPage
                .clickEditFirstRowButton()
                .fillRowForm(editedTableRow);

        // --------
        // FIND ROW
        // --------

        webTablesPage.writeTextToSearch(editedTableRow.getFirstName());
        List<WebElement> firstRowCellsFromEdit = webTablesPage.getFirstRowCells();
        // Assert edited row
        assertThat(firstRowCellsFromEdit.get(0).getText()).isEqualTo(editedTableRow.getFirstName());
        assertThat(firstRowCellsFromEdit.get(1).getText()).isEqualTo(editedTableRow.getLastName());
        assertThat(firstRowCellsFromEdit.get(2).getText()).isEqualTo(editedTableRow.getAge());
        assertThat(firstRowCellsFromEdit.get(3).getText()).isEqualTo(editedTableRow.getEmail());
        assertThat(firstRowCellsFromEdit.get(4).getText()).isEqualTo(editedTableRow.getSalary());
        assertThat(firstRowCellsFromEdit.get(5).getText()).isEqualTo(editedTableRow.getDepartment());

        // ----------
        // DELETE ROW
        // ----------

        webTablesPage.clickDeleteFirstRowButton();
        List<WebElement> firstRowCellsFromDelete = webTablesPage.getFirstRowCells();
        // Assert deleted row
        assertThat(firstRowCellsFromDelete.get(0).getText()).isEqualTo(" ");
        assertThat(firstRowCellsFromDelete.get(1).getText()).isEqualTo(" ");
        assertThat(firstRowCellsFromDelete.get(2).getText()).isEqualTo(" ");
        assertThat(firstRowCellsFromDelete.get(3).getText()).isEqualTo(" ");
        assertThat(firstRowCellsFromDelete.get(4).getText()).isEqualTo(" ");
        assertThat(firstRowCellsFromDelete.get(5).getText()).isEqualTo(" ");
        assertThat(webTablesPage.getNoDataField().isDisplayed()).isTrue();
        assertThat(webTablesPage.getNoDataField().getText()).isEqualTo("No rows found");
    }

    @Test
    public void shouldPaginationWork() {

        // -------
        // ARRANGE
        // -------

        TableRow tableRow1 = TableRowProvider.getRandomTableRow();
        TableRow tableRow2 = TableRowProvider.getRandomTableRow();
        TableRow tableRow3 = TableRowProvider.getRandomTableRow();

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        elementsPage.removeAdFrameAndFooter()
                .goToWebTablesPage();

        webTablesPage.clickAddNewRowButton()
                .fillRowForm(tableRow1)
                .clickAddNewRowButton()
                .fillRowForm(tableRow2)
                .clickAddNewRowButton()
                .fillRowForm(tableRow3)
                .selectRowsPerPage("5")
                .clickNextPageButton();

        // ------
        // ASSERT
        // ------

        List<WebElement> firstRowCells = webTablesPage.getFirstRowCells();

        assertThat(firstRowCells.get(0).getText()).isEqualTo(tableRow3.getFirstName());
        assertThat(firstRowCells.get(1).getText()).isEqualTo(tableRow3.getLastName());
        assertThat(firstRowCells.get(2).getText()).isEqualTo(tableRow3.getAge());
        assertThat(firstRowCells.get(3).getText()).isEqualTo(tableRow3.getEmail());
        assertThat(firstRowCells.get(4).getText()).isEqualTo(tableRow3.getSalary());
        assertThat(firstRowCells.get(5).getText()).isEqualTo(tableRow3.getDepartment());
    }
}
