package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.SliderPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SliderTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    SliderPage sliderPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        sliderPage = new SliderPage(driver);
    }

    @Test
    public void shouldMoveSliderTo100And0And50UsingSelenium() {

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

        homePage.goToWidgetsPage();

        trainingPage.removeAdFrameAndFooter();

        widgetsPage.goToSliderPage();

        sliderPage.moveSlider(323);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMaxValue));

        sliderPage.moveSlider(-429);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMinValue));

        sliderPage.moveSlider(214);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMiddleValue));
    }

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

        homePage.goToWidgetsPage();

        trainingPage.removeAdFrameAndFooter();

        widgetsPage.goToSliderPage();

        sliderPage.moveSliderByJS(sliderMaxValue);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMaxValue));

        sliderPage.moveSliderByJS(sliderMinValue);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMinValue));

        sliderPage.moveSliderByJS(sliderMiddleValue);
        assertThat(sliderPage.getSliderValueInput().getAttribute(attribute)).isEqualTo(Integer.toString(sliderMiddleValue));
    }
}
