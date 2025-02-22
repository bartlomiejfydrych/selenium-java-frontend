package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.PrzeciagnijUpuscPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PrzeciagnijUpuscTest extends TestBase {

    private HomePage homePage;
    private PrzeciagnijUpuscPage przeciagnijUpuscPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        przeciagnijUpuscPage = new PrzeciagnijUpuscPage(driver);
    }

    @Test
    public void z1ShouldCorrectlyMoveAllElementsFromGrupaAToGrupaB() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToPrzeciagnijUpuscPage();
        przeciagnijUpuscPage.z1MoveElementyToGrupaB();

        // ------
        // ASSERT
        // ------

        assertThat(przeciagnijUpuscPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(przeciagnijUpuscPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z2ShouldCorrectlySortItemsInListFrom1To5() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToPrzeciagnijUpuscPage();
        przeciagnijUpuscPage.z2SortElementy();

        // ------
        // ASSERT
        // ------

        assertThat(przeciagnijUpuscPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(przeciagnijUpuscPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z3ShouldCorrectlyMoveAllElementsFromGrupaXToGrupaY() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToPrzeciagnijUpuscPage();
        przeciagnijUpuscPage.z3MoveElementyToGrupaY();

        // ------
        // ASSERT
        // ------

        assertThat(przeciagnijUpuscPage.getZ3Alert().isDisplayed()).isTrue();
        assertThat(przeciagnijUpuscPage.getZ3Alert().getText()).isEqualTo(expectedMessage);
    }
}
