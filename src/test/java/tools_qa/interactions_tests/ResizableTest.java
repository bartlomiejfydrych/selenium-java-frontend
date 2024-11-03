package tools_qa.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;
import tools_qa.pages.normal.interactions_pages.ResizablePage;

import static org.assertj.core.api.Assertions.assertThat;

public class ResizableTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    InteractionsPage interactionsPage;
    ResizablePage resizablePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        resizablePage = new ResizablePage(driver);
    }

    @Test
    public void shouldEnlargeBoxToItsMaximumSize() {

        // -------
        // ARRANGE
        // -------

        int width = 500;
        int height = 300;

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToResizablePage();

        resizablePage.resizeBoxWithRestriction(width, height);

        // ------
        // ASSERT
        // ------

        assertThat(resizablePage.getBoxWithRestriction().getSize().getWidth()).isEqualTo(width);
        assertThat(resizablePage.getBoxWithRestriction().getSize().getHeight()).isEqualTo(height);
    }

    @Test
    public void shouldReduceBoxToSmallestSize() {

        // -------
        // ARRANGE
        // -------

        int width = 20;
        int height = 20;

        // ---
        // ACT
        // ---

        homePage.goToInteractionsPage();

        trainingPage.removeFooterAndAds();

        interactionsPage.goToResizablePage();

        resizablePage.resizeBoxWithoutRestriction(width, height);

        // ------
        // ASSERT
        // ------

        assertThat(resizablePage.getBoxWithoutRestriction().getSize().getWidth()).isEqualTo(width);
        assertThat(resizablePage.getBoxWithoutRestriction().getSize().getHeight()).isEqualTo(height);
    }
}
