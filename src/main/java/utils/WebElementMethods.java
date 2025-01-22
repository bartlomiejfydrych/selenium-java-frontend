package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementMethods {

    private final WebDriver driver;
    private final Actions actions;

    // -----------
    // CONSTRUCTOR
    // -----------

    public WebElementMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    // -------
    // METHODS
    // -------

    /**
     * Checks if a web element is present and displayed.
     *
     * @param webElement the WebElement to check
     * @return true if the element is present and displayed, false otherwise
     */
    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if a web element is clickable.
     *
     * @param webElement the WebElement to check
     * @return true if the element is clickable, false otherwise
     */
    public boolean isElementClickable(WebElement webElement) {
        try {
            actions.moveToElement(webElement).click().perform();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits for a web element to stop moving.
     *
     * @param webElement    the WebElement to monitor
     * @param timeoutMillis maximum time to wait in milliseconds
     */
    public void waitForElementToStopMoving(WebElement webElement, long timeoutMillis) {
        long startTime = System.currentTimeMillis();
        Point initialLocation = webElement.getLocation();

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            sleep(100);
            Point currentLocation = webElement.getLocation();
            if (initialLocation.equals(currentLocation)) {
                return;
            }
            initialLocation = currentLocation;
        }
        throw new RuntimeException("Timeout waiting for element to stop moving");
    }

    /**
     * Waits for a web element's CSS value to stabilize.
     *
     * @param webElement    the WebElement to monitor
     * @param cssValue      the CSS property to observe
     * @param timeoutMillis maximum time to wait in milliseconds
     */
    public void waitForElementToStopColorChanging(WebElement webElement, String cssValue, long timeoutMillis) {
        long startTime = System.currentTimeMillis();
        String initialColorValue = webElement.getCssValue(cssValue);

        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            sleep(100);
            String currentColorValue = webElement.getCssValue(cssValue);
            if (initialColorValue.equals(currentColorValue)) {
                return;
            }
            initialColorValue = currentColorValue;
        }
        throw new RuntimeException("Timeout waiting for element CSS value to stabilize");
    }

    // -------
    // HELPERS
    // -------

    /**
     * Utility method to sleep for a specified duration.
     *
     * @param millis the time to sleep in milliseconds
     */
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during sleep", e);
        }
    }
}
