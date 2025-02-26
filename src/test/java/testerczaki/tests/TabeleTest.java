package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.models_providers.tabele_models.TabeleData;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.TabelePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TabeleTest extends TestBase {

    private HomePage homePage;
    private TabelePage tabelePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        tabelePage = new TabelePage(driver);
    }

    @Test
    public void shouldCorrectlyRetrieveDataFromTableAndEnterItIntoAppropriateFields() {

        // -------
        // ARRANGE
        // -------

        String imie = "Janusz";
        String miasto = "Warszawa";
        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToTabelePage();
        List<TabeleData> tableData = tabelePage.getDataFromTable();
        double sredniaWieku = tabelePage.calculateAverageAge(tableData);
        int wiekJanusza = tabelePage.getAgeForName(tableData, imie);
        String imieMieszkancaWarszawy = tabelePage.getNameOfCityResident(tableData, miasto);
        tabelePage.writeSrednia(sredniaWieku)
                .writeWiek(wiekJanusza)
                .writeImie(imieMieszkancaWarszawy)
                .clickSprawdzButton();

        // ------
        // ASSERT
        // ------

        assertThat(tabelePage.getAlert().isDisplayed()).isTrue();
        assertThat(tabelePage.getAlert().getText()).isEqualTo(expectedMessage);
    }
}
