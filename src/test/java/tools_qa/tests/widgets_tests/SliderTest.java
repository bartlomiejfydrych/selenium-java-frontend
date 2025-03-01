package tools_qa.tests.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.SliderPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends TestBase {

    // https://demoqa.com/slider

    private HomePage homePage;
    private TrainingPage trainingPage;
    private WidgetsPage widgetsPage;
    private SliderPage sliderPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        sliderPage = new SliderPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToSliderPage() {
        homePage.goToWidgetsPage();
        trainingPage.removeFooterAndAds();
        widgetsPage.goToSliderPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldMoveSliderTo100And0And50UsingJavaScript() {

        // -------
        // ARRANGE
        // -------

        String attribute = "value";
        int sliderMaxValue = 100;
        int sliderMinValue = 0;
        int sliderMiddleValue = 50;

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToSliderPage();

        // 100
        sliderPage.moveSliderUseJavaScript(sliderMaxValue);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(Integer.toString(sliderMaxValue));
        // 0
        sliderPage.moveSliderUseJavaScript(sliderMinValue);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(Integer.toString(sliderMinValue));
        // 50
        sliderPage.moveSliderUseJavaScript(sliderMiddleValue);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(Integer.toString(sliderMiddleValue));
    }

    @Test
    public void shouldMoveSliderTo100And0And50UsingXOffSetPosition() {

        // -------
        // ARRANGE
        // -------

        String attribute = "value";
        String expectedSliderMaxValue = "100";
        String expectedSliderMinValue = "0";
        String expectedSliderMiddleValue = "50";

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToSliderPage();

        // 100
        sliderPage.moveSliderUseXOffSetPosition(323);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMaxValue);
        // 0
        sliderPage.moveSliderUseXOffSetPosition(-429);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMinValue);
        // 50
        sliderPage.moveSliderUseXOffSetPosition(3);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMiddleValue);
    }

    @Test
    public void shouldMoveSliderTo100And0And50UsingKeyboard() {

        // -------
        // ARRANGE
        // -------

        String attribute = "value";
        String expectedSliderMaxValue = "100";
        String expectedSliderMinValue = "0";
        String expectedSliderMiddleValue = "50";

        // ------------
        // ACT + ASSERT
        // ------------

        navigateToSliderPage();

        // 100
        sliderPage.moveSliderUseKeyboard(75);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMaxValue);
        // 0
        sliderPage.moveSliderUseKeyboard(-100);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMinValue);
        // 50
        sliderPage.moveSliderUseKeyboard(50);
        assertThat(sliderPage.getSliderValueInput().getDomProperty(attribute)).isEqualTo(expectedSliderMiddleValue);
    }
}
