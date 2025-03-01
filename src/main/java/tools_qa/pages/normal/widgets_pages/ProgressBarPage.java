package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools_qa.pages.base.BasePage;

import java.time.Duration;

public class ProgressBarPage extends BasePage {

    // https://demoqa.com/progress-bar

    // -----------
    // CONSTRUCTOR
    // -----------

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#startStopButton")
    private WebElement startStopButton;
    @FindBy(css = "#resetButton")
    private WebElement resetButton;
    @FindBy(css = ".progress-bar")
    private WebElement progressBar;

    // -------
    // METHODS
    // -------

    public ProgressBarPage clickStartStopButton() {
        startStopButton.click();
        return this;
    }

    public ProgressBarPage clickResetButton() {
        resetButton.click();
        return this;
    }

    public ProgressBarPage waitForProgressBar(String expectedValue) {
        defaultWait.pollingEvery(Duration.ofMillis(1));
        defaultWait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", expectedValue));
        return this;
    }

    public ProgressBarPage waitForProgressBarAndClickStop(String expectedValue) {
        waitForProgressBar(expectedValue);
        clickStartStopButton();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getProgressBar() {
        return progressBar;
    }
}
