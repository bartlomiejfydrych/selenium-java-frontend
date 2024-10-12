package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class SliderPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = ".range-slider")
    private WebElement sliderBar;
    @FindBy(css = ".range-slider__tooltip")
    private WebElement sliderPointer;
    @FindBy(css = "#sliderValue")
    private WebElement sliderValueInput;

    // -------
    // METHODS
    // -------

    public SliderPage moveSlider(int xOffSet) {
        // Start 672
        // Max 1159
        // Min 510
        System.out.println("Slider bar width: " + sliderBar.getSize().getWidth());
        System.out.println("(Before) Slider pointer position X: " + sliderPointer.getLocation().getX());
        actions.dragAndDropBy(sliderBar, xOffSet, 0).perform();
        System.out.println("(After) Slider pointer position X: " + sliderPointer.getLocation().getX());
        return this;
    }

    // TODO: Zrobić test przesuwania z klawiatury

    /*
    NOTE:
    There is no built-in method in Selenium to move the slider to specific values, but we can do it using JavaScript,
    which will allow us to directly set the slider position via its value attribute.
    The advantage of this method is that it is the fastest and most precise.
    The disadvantage of this method is that it does not simulate the exact behavior of the user. When we change the
    position of the slider, the input displaying its value remains unchanged and in it, we also have to simulate the
    change of its value using JS.
    This method can be useful for sliders in which we have a very large range of values.
    */
    public SliderPage moveSliderByJS(int sliderValue) {
        jse.executeScript("arguments[0].value = arguments[1];", sliderBar, sliderValue);
        jse.executeScript("arguments[0].value = arguments[1];", sliderValueInput, sliderValue);
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSliderValueInput() {
        return sliderValueInput;
    }
}
