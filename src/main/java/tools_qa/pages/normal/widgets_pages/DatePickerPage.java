package tools_qa.pages.normal.widgets_pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tools_qa.pages.base.BasePage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class DatePickerPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Date
    @FindBy(css = "#datePickerMonthYearInput")
    private WebElement selectDateInput;
    @FindBy(css = "react-datepicker__month-select")
    private WebElement monthSelect;
    @FindBy(css = "react-datepicker__year-select")
    private WebElement yearSelect;
    private final String daySelectXpath = "//div[@class='react-datepicker__month']/div/div"; // // [contains(@aria-label,'November') and text()='27']
    @FindBy(xpath = daySelectXpath)
    private WebElement daySelect;
    // Date and time
    @FindBy(css = "#dateAndTimePickerInput")
    private WebElement selectDateAndTimeInput;

    // -------
    // METHODS
    // -------

    public String generateRandomDateAndTime(boolean cutOffTime) {
        Faker faker = new Faker();
        // Set the date range from January 1, 1900 to December 31, 2100
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(1900, Calendar.JANUARY, 1);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(2100, Calendar.DECEMBER, 31);
        // Generating a random date with Faker
        Date randomDate = faker.date().between(startCalendar.getTime(), endCalendar.getTime());
        // Date formatting
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(randomDate);
        // Generate random hour and minutes (00, 15, 30, 45)
        Random random = new Random();
        int randomHour = random.nextInt(24);  // Random hour from 0 to 23
        int[] validMinutes = {0, 15, 30, 45}; // Only these minute values
        int randomMinute = validMinutes[random.nextInt(validMinutes.length)];
        // Formatting time as "hh:mm"
        String formattedTime = String.format("%02d:%02d", randomHour, randomMinute);
        // Returning date with or without time, depending on the value of 'cutOffTime'
        if (cutOffTime) {
            return formattedDate;  // Only date
        } else {
            return formattedDate + " " + formattedTime;  // Date and time
        }
    }

    // Date

    public DatePickerPage selectDate(String dateWithoutTime) {
        String[] dateParts = dateWithoutTime.split(" ");
        String month = dateParts[0];
        String year = dateParts[1];
        String day = dateParts[2];
        selectDateInput.click();
        WebElement monthSelectAfterWait = defaultWait.until(ExpectedConditions.elementToBeClickable(monthSelect));
        Select selectMonth = new Select(monthSelectAfterWait);
        selectMonth.selectByVisibleText(month);
        Select selectYear = new Select(yearSelect);
        selectYear.selectByValue(year);
        String daySelectOptionXpath = daySelectXpath + "[contains(@aria-label,'" + month + "') and text()='" + day + "']";
        WebElement daySelectOptionLocator = driver.findElement(By.xpath(daySelectOptionXpath));
        daySelectOptionLocator.click();
        return this;
    }

    public String convertDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM yyyy d", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = inputFormat.parse(inputDate);
        String formattedDate = outputFormat.format(date);
        return formattedDate;
    }

    // Date and time

    public DatePickerPage selectDateAndTime(String dateWithTime) {

        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSelectDateInput() {
        return selectDateInput;
    }

    public WebElement getSelectDateAndTimeInput() {
        return selectDateAndTimeInput;
    }
}