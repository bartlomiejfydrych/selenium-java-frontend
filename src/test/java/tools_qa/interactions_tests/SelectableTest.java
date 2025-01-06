package tools_qa.interactions_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.interactions_pages.InteractionsPage;
import tools_qa.pages.normal.interactions_pages.SelectablePage;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectableTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private InteractionsPage interactionsPage;
    private SelectablePage selectablePage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        interactionsPage = new InteractionsPage(driver);
        selectablePage = new SelectablePage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToSelectablePage() {
        homePage.goToInteractionsPage();
        trainingPage.removeFooterAndAds();
        interactionsPage.goToSelectablePage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldSelectAllElementsOnList() {

        // -------
        // ARRANGE
        // -------

        String attributeClass = "class";
        String cssValueBackgroundColor = "background-color";
        String expectedClassName = "active";
        String expectedBackgroundColor = "rgba(0, 123, 255, 1)";

        // ---
        // ACT
        // ---

        navigateToSelectablePage();
        selectablePage.clickCrasListElement()
                .clickDapibusListElement()
                .clickMorbiListElement()
                .clickPortaListElement();

        // ------
        // ASSERT
        // ------

        assertThat(selectablePage.getCrasListElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getCrasListElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getDapibusListElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getDapibusListElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getMorbiListElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getMorbiListElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getPortaListElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getPortaListElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
    }

    @Test
    public void shouldSelectAllElementsOnGrid() {

        // -------
        // ARRANGE
        // -------

        String attributeClass = "class";
        String cssValueBackgroundColor = "background-color";
        String expectedClassName = "active";
        String expectedBackgroundColor = "rgba(0, 123, 255, 1)";

        // ---
        // ACT
        // ---

        navigateToSelectablePage();
        selectablePage.clickGridTab()
                .clickOneGridElement()
                .clickTwoGridElement()
                .clickThreeGridElement()
                .clickFourGridElement()
                .clickFiveGridElement()
                .clickSixGridElement()
                .clickSevenGridElement()
                .clickEightGridElement()
                .clickNineGridElement();

        // ------
        // ASSERT
        // ------

        assertThat(selectablePage.getOneGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getOneGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getTwoGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getTwoGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getThreeGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getThreeGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getFourGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getFourGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getFiveGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getFiveGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getSixGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getSixGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getSevenGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getSevenGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getEightGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getEightGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
        assertThat(selectablePage.getNineGridElement().getDomAttribute(attributeClass)).contains(expectedClassName);
        assertThat(selectablePage.getNineGridElement().getCssValue(cssValueBackgroundColor)).isEqualTo(expectedBackgroundColor);
    }
}
