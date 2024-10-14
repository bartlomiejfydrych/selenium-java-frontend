package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.Keys;
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

    public SliderPage moveSliderUseJavaScript(int sliderValue) {
        jse.executeScript("arguments[0].value = arguments[1];", sliderBar, sliderValue);
        jse.executeScript("arguments[0].value = arguments[1];", sliderValueInput, sliderValue);
        return this;
    }

    public SliderPage moveSliderUseXOffSetPosition(int xOffSet) {
        actions.dragAndDropBy(sliderBar, xOffSet, 0).perform();
        return this;
    }

    public SliderPage moveSliderUseKeyboard(int numberOfSliderMovesToOneSide) {
        if (numberOfSliderMovesToOneSide > 0) {
            for (int i = 0; i < numberOfSliderMovesToOneSide; i++) {
                sliderBar.sendKeys(Keys.ARROW_RIGHT);
            }
        } else if (numberOfSliderMovesToOneSide < 0) {
            for (int i = 0; i < Math.abs(numberOfSliderMovesToOneSide); i++) {
                sliderBar.sendKeys(Keys.ARROW_LEFT);
            }
        }
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSliderValueInput() {
        return sliderValueInput;
    }
}

/*

------
NOTES:
------

For the person viewing this code, I wanted to include an explanation here of why I used the above methods and how
I understand how they work.

I used different ways of moving the slider here, because when I found them while browsing the Internet, I decided it
was worth knowing and practicing all of them to be better prepared for any eventuality.

----------------------------------------
moveSliderUseJavaScript(int sliderValue)
----------------------------------------

DESCRIPTION:
There is no built-in method in Selenium to move the slider to specific values, but we can do it using JavaScript,
which will allow us to directly set the slider position via its "value" attribute.

USAGE:
This method can be useful for sliders where we have a very large range of values, or we need to set the exact slider
position for further testing.

ADVANTAGES:
The advantage of this method is that it is the fastest, most accurate and safest.

DISADVANTAGES:
The disadvantage of this method is that it does not simulate the exact user behavior, because it changes the slider
position rigidly. There is no "catching" and "moving" process.
When we change the position of the slider, the input displaying its value remains unchanged and in it, we also have to
simulate the change of its value using JS.

-----------------------------------------
moveSliderUseXOffSetPosition(int xOffSet)
-----------------------------------------

DESCRIPTION:
A standard Selenium method that moves a given element along the X-axis and Y-axis.

USAGE:
This method is useful when we want to check whether the slider itself affects the sliding movement for the minimum
and maximum value.

ADVANTAGES:
The advantage of this method is that it simulates the user's behavior, i.e. grabbing the element and moving it.

DISADVANTAGES:
The disadvantage of this method is that you have to repeat the test many times to guess by trial and error what value
we should move the element.
With sliders that have a large range of values, it is difficult to hit the exact value. Additionally, this method is
very unstable because it depends on the size of the window.

-------------------------------------------------------
moveSliderUseKeyboard(int numberOfSliderMovesToOneSide)
-------------------------------------------------------

DESCRIPTION:
A method that moves the slider left or right using the keyboard keys.

USAGE:
We can use this method when we want to check if the slider supports keyboard usage and when we want to get a fairly
accurate value. With sliders with small values we can get an accurate value, but with sliders with large values we can't.

ADVANTAGES:
The advantage of this method is that it also simulates user behavior to some extent and is more reliable and accurate
than moving the slider along the X axis.

DISADVANTAGES:
The disadvantage of this method is that it takes a long time to execute. It is not recommended for sliders with large
values.

*/
