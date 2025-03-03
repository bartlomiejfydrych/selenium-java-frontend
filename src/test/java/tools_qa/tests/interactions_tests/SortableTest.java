package tools_qa.tests.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;
import tools_qa.pages.normal.interactions_pages.SortablePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SortableTest extends TestBase {

    // https://demoqa.com/sortable

    private HomePage homePage;
    private TrainingPage trainingPage;
    private InteractionsPage interactionsPage;
    private SortablePage sortablePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        sortablePage = new SortablePage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToSortablePage() {
        homePage.goToInteractionsPage();
        trainingPage.removeFooterAndAds();
        interactionsPage.goToSortablePage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldSortListInReverseOrder() {

        // -------
        // ARRANGE
        // -------

        List<String> expectedElementsOrderList = List.of(
                "Six",
                "Five",
                "Four",
                "Three",
                "Two",
                "One"
        );
        WebElement oneElement = sortablePage.getOneListElement();
        WebElement twoElement = sortablePage.getTwoListElement();
        WebElement threeElement = sortablePage.getThreeListElement();
        WebElement fourElement = sortablePage.getFourListElement();
        WebElement fiveElement = sortablePage.getFiveListElement();
        WebElement sixElement = sortablePage.getSixListElement();

        // ---
        // ACT
        // ---

        navigateToSortablePage();
        sortablePage.moveElementToAnotherElement(sixElement, oneElement)
                        .moveElementToAnotherElement(fiveElement, oneElement)
                        .moveElementToAnotherElement(fourElement, oneElement)
                        .moveElementToAnotherElement(threeElement, oneElement)
                        .moveElementToAnotherElement(twoElement, oneElement);

        // ------
        // ASSERT
        // ------

        List<String> actualElementsOrderList = sortablePage.getListElementsAsText();
        assertThat(actualElementsOrderList).isEqualTo(expectedElementsOrderList);
    }

    @Test
    public void shouldSortGridInReverseOrder() {

        // -------
        // ARRANGE
        // -------

        List<String> expectedElementsOrderList = List.of(
                "Nine",
                "Eight",
                "Seven",
                "Six",
                "Five",
                "Four",
                "Three",
                "Two",
                "One"
        );
        WebElement oneElement = sortablePage.getOneGridElement();
        WebElement twoElement = sortablePage.getTwoGridElement();
        WebElement threeElement = sortablePage.getThreeGridElement();
        WebElement fourElement = sortablePage.getFourGridElement();
        WebElement fiveElement = sortablePage.getFiveGridElement();
        WebElement sixElement = sortablePage.getSixGridElement();
        WebElement sevenElement = sortablePage.getSevenGridElement();
        WebElement eightElement = sortablePage.getEightGridElement();
        WebElement nineElement = sortablePage.getNineGridElement();

        // ---
        // ACT
        // ---

        navigateToSortablePage();
        sortablePage.clickGridTab()
                .moveElementToAnotherElement(nineElement, oneElement)
                .moveElementToAnotherElement(eightElement, oneElement)
                .moveElementToAnotherElement(sevenElement, oneElement)
                .moveElementToAnotherElement(sixElement, oneElement)
                .moveElementToAnotherElement(fiveElement, oneElement)
                .moveElementToAnotherElement(fourElement, oneElement)
                .moveElementToAnotherElement(threeElement, oneElement)
                .moveElementToAnotherElement(twoElement, oneElement);

        // ------
        // ASSERT
        // ------

        List<String> actualElementsOrderList = sortablePage.getGridElementsAsText();
        assertThat(actualElementsOrderList).isEqualTo(expectedElementsOrderList);
    }
}
