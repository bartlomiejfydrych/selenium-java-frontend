package tools_qa.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonException;
import tools_qa.pages.base.BasePage;

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

    public void waitForElementToStopMoving(WebElement webElement) {
        Point initialLocation = webElement.getLocation();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Point finalLocation = webElement.getLocation();
            if (initialLocation.equals(finalLocation)) {
                break;
            }
            initialLocation = finalLocation;
        }
    }
}
