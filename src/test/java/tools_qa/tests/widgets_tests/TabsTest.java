package tools_qa.tests.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.TabsPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TabsTest extends TestBase {

    // https://demoqa.com/tabs

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private TabsPage tabsPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        tabsPage = new TabsPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToTabsPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToTabsPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldSwitchToOriginTab() {

        // -------
        // ARRANGE
        // -------

        String expectedTabText1 = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in" +
                " a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock," +
                " a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin" +
                " words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical" +
                " literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33" +
                " of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC." +
                " This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line" +
                " of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.";
        String expectedTabText2 = "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those" +
                " interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also" +
                " reproduced in their exact original form, accompanied by English versions from the 1914 translation" +
                " by H. Rackham.";

        // ---
        // ACT
        // ---

        navigateToTabsPage();
        tabsPage.clickOriginTab();

        // ------
        // ASSERT
        // ------

        assertThat(tabsPage.getOriginTabText1().getText()).isEqualTo(expectedTabText1);
        assertThat(tabsPage.getOriginTabText2().getText()).isEqualTo(expectedTabText2);
    }

    @Test
    public void shouldSwitchToUseTab() {

        // -------
        // ARRANGE
        // -------

        String expectedTabText = "It is a long established fact that a reader will be distracted by the readable" +
                " content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a" +
                " more-or-less normal distribution of letters, as opposed to using 'Content here, content here'," +
                " making it look like readable English. Many desktop publishing packages and web page editors now" +
                " use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many" +
                " web sites still in their infancy. Various versions have evolved over the years, sometimes by" +
                " accident, sometimes on purpose (injected humour and the like).";

        // ---
        // ACT
        // ---

        navigateToTabsPage();
        tabsPage.clickUseTab();

        // ------
        // ASSERT
        // ------

        assertThat(tabsPage.getUseTabText().getText()).isEqualTo(expectedTabText);
    }

    @Test
    public void shouldSwitchToUseTabAndWhatTab() {

        // -------
        // ARRANGE
        // -------

        String expectedTabText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown" +
                " printer took a galley of type and scrambled it to make a type specimen book. It has survived" +
                " not only five centuries, but also the leap into electronic typesetting, remaining essentially" +
                " unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem" +
                " Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including" +
                " versions of Lorem Ipsum.";

        // ---
        // ACT
        // ---

        navigateToTabsPage();
        tabsPage.clickUseTab()
                .clickWhatTab();

        // ------
        // ASSERT
        // ------

        assertThat(tabsPage.getWhatTabText().getText()).isEqualTo(expectedTabText);
    }

    @Test
    public void shouldNotSwitchToMoreTab() {

        // ---
        // ACT
        // ---

        navigateToTabsPage();
        tabsPage.clickMoreTab();

        // ------
        // ASSERT
        // ------

        assertThat(tabsPage.getMoreTabButton().getDomAttribute("aria-selected")).isEqualTo("false");
    }
}
