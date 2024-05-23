package tools_qa.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import tools_qa.pages.base.BasePage;

import java.lang.reflect.InvocationTargetException;

public class WebElementMethods extends BasePage {

    public WebElementMethods(WebDriver driver) {
        super(driver);
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement webElement) {
        try {
            actions.moveToElement(webElement).click().perform();
            return true;
        } catch (JsonException e) {
            return false;
        }
    }
}
