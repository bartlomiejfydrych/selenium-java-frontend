package testerczaki.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testerczaki.base.TestBase;
import testerczaki.pages.commons.HomePage;
import testerczaki.pages.normal.NiestandardoweListyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NiestandardoweListyTest extends TestBase {

    // https://dawidkaruga.pl/testerczaki/listy

    private HomePage homePage;
    private NiestandardoweListyPage niestandardoweListyPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        niestandardoweListyPage = new NiestandardoweListyPage(driver);
    }

    @Test
    public void z1ShouldCorrectlyClickElement3OnList() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";

        // ---
        // ACT
        // ---

        homePage.goToNiestandardoweListyPage();
        niestandardoweListyPage.z1ClickWybierzButton()
                .z1ClickElement(3);

        // ------
        // ASSERT
        // ------

        assertThat(niestandardoweListyPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(niestandardoweListyPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void z2ShouldCorrectlyFindAndClickElement2OnList() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";
        String textToSearch = "Element 2";

        // ---
        // ACT
        // ---

        homePage.goToNiestandardoweListyPage();
        niestandardoweListyPage.z2ClickWybierzButton()
                .z2WriteWyszukajText(textToSearch)
                .z2ClickElement(1);

        // ------
        // ASSERT
        // ------

        assertThat(niestandardoweListyPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(niestandardoweListyPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
    }

    @Test
    public void shouldCorrectlyCompleteAllTasksInOneTest() {

        // -------
        // ARRANGE
        // -------

        String expectedMessage = "Zadanie wykonane prawidłowo. Gratulacje!";
        String textToSearch = "Element 2";

        // ---
        // ACT
        // ---

        homePage.goToNiestandardoweListyPage();
        niestandardoweListyPage.z1ClickWybierzButton()
                .z1ClickElement(3)
                .z2ClickWybierzButton()
                .z2WriteWyszukajText(textToSearch)
                .z2ClickElement(1);

        // ------
        // ASSERT
        // ------

        assertThat(niestandardoweListyPage.getZ1Alert().isDisplayed()).isTrue();
        assertThat(niestandardoweListyPage.getZ1Alert().getText()).isEqualTo(expectedMessage);
        assertThat(niestandardoweListyPage.getZ2Alert().isDisplayed()).isTrue();
        assertThat(niestandardoweListyPage.getZ2Alert().getText()).isEqualTo(expectedMessage);
    }
}
