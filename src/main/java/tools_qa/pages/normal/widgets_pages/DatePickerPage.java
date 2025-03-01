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

    // https://demoqa.com/date-picker

    // NOTE: I tried to refactor this code using GPT chat, but it was buggy and very unreadable, so I left it as is.

    // -----------
    // CONSTRUCTOR
    // -----------

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // DATE
    @FindBy(css = "#datePickerMonthYearInput")
    private WebElement selectDateInput;
    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthDateSelect;
    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearDateSelect;
    private final String dayDateSelectXpath = "//div[@class='react-datepicker__month']/div/div"; // [contains(@aria-label,'November') and text()='27']
    @FindBy(xpath = dayDateSelectXpath)
    private WebElement dayDateSelect;
    // DATE AND TIME
    @FindBy(css = "#dateAndTimePickerInput")
    private WebElement selectDateAndTimeInput;
    // Month
    @FindBy(css = ".react-datepicker__month-read-view")
    private WebElement monthDateAndTimeSelect;
    private final String monthDateAndTimeSelectXpath = "//div[@class='react-datepicker__month-option']";
    @FindBy(xpath = monthDateAndTimeSelectXpath)
    private WebElement monthDateAndTimeOption;
    @FindBy(xpath = "//div//span[@class='react-datepicker__month-option--selected']")
    private WebElement monthActualDateAndTimeOption;
    // Year
    @FindBy(css = ".react-datepicker__year-read-view")
    private WebElement yearDateAndTimeSelect;
    private final String yearDateAndTimeSelectXpath = "//div[@class='react-datepicker__year-option']";
    @FindBy(xpath = yearDateAndTimeSelectXpath)
    private WebElement yearDateAndTimeOption;
    @FindBy(xpath = "//div//span[@class='react-datepicker__year-option--selected']")
    private WebElement yearActualDateAndTimeOption;
    // Day
    private final String dayDateAndTimeXpath = "//div[@class='react-datepicker__month']/div/div"; // [contains(@aria-label,'November') and text()='27']
    @FindBy(xpath = dayDateAndTimeXpath)
    private WebElement dayDateAndTimeOption;
    // Time
    private final String timeDateAndTimeXpath = "//ul[@class='react-datepicker__time-list']/li"; // [text()='00:00']
    @FindBy(xpath = timeDateAndTimeXpath)
    private WebElement timeDateAndTimeOption;

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
        // If time is not cut off, modify the year within the range of currentYear +/- 5
        if (!cutOffTime) {
            // Extract the current year
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            // Generate a random year within the range currentYear +/- 5
            int randomYear = currentYear + (random.nextInt(11) - 5); // Generate a number between -5 and +5
            // Replace the year in the formatted date
            formattedDate = formattedDate.replaceFirst("\\d{4}", String.valueOf(randomYear));
            // Return date with time and modified year
            return formattedDate + " " + formattedTime;
        } else {
            // Return only the date if time is cut off
            return formattedDate;
        }
    }

    // Date

    public DatePickerPage selectDate(String dateWithoutTime) {
        // Split date String
        String[] dateParts = dateWithoutTime.split(" ");
        String month = dateParts[0];
        String year = dateParts[1];
        String day = dateParts[2];
        // Open calendar
        selectDateInput.click();
        WebElement monthSelectAfterWait = defaultWait.until(ExpectedConditions.elementToBeClickable(monthDateSelect));
        // Select month
        Select selectMonth = new Select(monthSelectAfterWait);
        selectMonth.selectByVisibleText(month);
        // Select year
        Select selectYear = new Select(yearDateSelect);
        selectYear.selectByValue(year);
        // Select day
        String daySelectOptionXpath = dayDateSelectXpath + "[contains(@aria-label,'" + month + "') and text()='" + day + "']";
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
        // Split date and time String
        String[] dateAndTimeParts = dateWithTime.split(" ");
        String month = dateAndTimeParts[0];
        String year = dateAndTimeParts[1];
        String day = dateAndTimeParts[2];
        String time = dateAndTimeParts[3];
        // Get current month and year
        Calendar calendar = Calendar.getInstance();
        String currentMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(calendar.getTime());
        String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
        // Open calendar
        selectDateAndTimeInput.click();
        defaultWait.until(ExpectedConditions.elementToBeClickable(monthDateAndTimeSelect));
        // Select month
        monthDateAndTimeSelect.click();
        defaultWait.until(ExpectedConditions.elementToBeClickable(monthActualDateAndTimeOption));
        if (month.equals(currentMonth)) {
            // If the month is the current month, click the current month locator
            monthActualDateAndTimeOption.click();
        } else {
            // Otherwise, select the desired month
            String monthSelectOptionXpath = monthDateAndTimeSelectXpath + "[text()='" + month + "']";
            WebElement monthSelectOptionLocator = driver.findElement(By.xpath(monthSelectOptionXpath));
            monthSelectOptionLocator.click();
        }
        // Select year
        yearDateAndTimeSelect.click();
        defaultWait.until(ExpectedConditions.elementToBeClickable(yearActualDateAndTimeOption));
        if (year.equals(currentYear)) {
            // If the year is the current year, click the current year locator
            yearActualDateAndTimeOption.click();
        } else {
            // Otherwise, select the desired year
            String yearSelectOptionXpath = yearDateAndTimeSelectXpath + "[text()='" + year + "']";
            WebElement yearSelectOptionLocator = driver.findElement(By.xpath(yearSelectOptionXpath));
            yearSelectOptionLocator.click();
        }
        // Select day
        String daySelectOptionXpath = dayDateAndTimeXpath + "[contains(@aria-label,'" + month + "') and text()='" + day + "']";
        WebElement daySelectOptionLocator = driver.findElement(By.xpath(daySelectOptionXpath));
        daySelectOptionLocator.click();
        // Select time
        String timeSelectOptionXpath = timeDateAndTimeXpath + "[text()='" + time + "']";
        WebElement timeSelectOptionLocator = driver.findElement(By.xpath(timeSelectOptionXpath));
        timeSelectOptionLocator.click();
        return this;
    }

    public String convertDateAndTime(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM yyyy d HH:mm", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM d, yyyy h:mm a", Locale.ENGLISH);
        Date date = inputFormat.parse(inputDate);
        String formattedDate = outputFormat.format(date);
        return formattedDate;
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
