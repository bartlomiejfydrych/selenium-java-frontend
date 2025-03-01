package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.MenuPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/menu

    private HomePage homePage;
    private MenuPage menuPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        menuPage = new MenuPage(driver);
    }

    @Test
    public void z1ShouldCorrectlyClickLink2OnSimpleMenu() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z1ClickLink2Button();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z2ShouldCorrectlyClickLink3OnMobileMenu() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z2ClickRozwinListeButton()
                .z2ClickLink3Button();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z3ShouldCorrectlyClickLink3COnClickMenu() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z3ClickLink3Button()
                .z3ClickLink3C();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ3Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ3Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z4ShouldCorrectlyClickLink3BOnHoverMenu() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z4ClickLink3BButton();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ4Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ4Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z5ShouldCorrectlyClickLink3B5OnHover2ndMenu() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z5ClickLink3B5Button();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ5Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ5Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldCorrectlyCompleteAllTasksInOneTest() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToMenuPage();
        menuPage.z1ClickLink2Button()
                .z2ClickRozwinListeButton()
                .z2ClickLink3Button()
                .z3ClickLink3Button()
                .z3ClickLink3C()
                .z4ClickLink3BButton()
                .z5ClickLink3B5Button();

        // ------
        // ASSERT
        // ------

        assertThat(menuPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
        assertThat(menuPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
        assertThat(menuPage.getZ3Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ3Alert().getText()).isEqualTo(expectedMessage);
        assertThat(menuPage.getZ4Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ4Alert().getText()).isEqualTo(expectedMessage);
        assertThat(menuPage.getZ5Alert().isDisplayed()).isTrue();
        assertThat(menuPage.getZ5Alert().getText()).isEqualTo(expectedMessage);
    }
}
