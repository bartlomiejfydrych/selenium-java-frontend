package tools_qa.pages.normal.widgets_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tools_qa.pages.base.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SelectMenuPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // SELECT VALUE
    @FindBy(css = "#withOptGroup")
    private WebElement selectValueSelect;
    @FindBy(css = "#withOptGroup .css-1uccc91-singleValue")
    private WebElement selectValueValue;
    // SELECT ONE
    @FindBy(css = "#selectOne")
    private WebElement selectOneSelect;
    @FindBy(css = "#selectOne .css-1uccc91-singleValue")
    private WebElement selectOneValue;
    // OLD STYLE SELECT MENU
    @FindBy(css = "#oldSelectMenu")
    private WebElement oldStyleSelectMenuSelect;
    // MULTI SELECT DROP DOWN
    @FindBy(xpath = "(//*[contains(@class, 'css-2b097c-container')])[3]")
    private WebElement multiSelectDropDownSelect;
    @FindBy(css = ".css-12jo7m5")
    private List<WebElement> multiSelectDropDownValue;
    // STANDARD MULTI SELECT
    @FindBy(css = "#cars")
    private WebElement standardMultiSelectSelect;

    // -------
    // METHODS
    // -------

    // SELECT VALUE

    public SelectMenuPage selectValueInSelectValue(String value) {
        selectValueSelect.click();
        String selectValueSelector = "//div[text()='" + value + "']";
        WebElement selectValueLocator = driver.findElement(By.xpath(selectValueSelector));
        selectValueLocator.click();
        return this;
    }

    // SELECT ONE

    public SelectMenuPage selectValueInSelectOne(String value) {
        selectOneSelect.click();
        String selectValueSelector = "//div[text()='" + value + "']";
        WebElement selectValueLocator = driver.findElement(By.xpath(selectValueSelector));
        selectValueLocator.click();
        return this;
    }

    // OLD STYLE SELECT MENU

    public SelectMenuPage selectValueInOldStyleSelectMenu(String value) {
        Select select = new Select(oldStyleSelectMenuSelect);
        select.selectByVisibleText(value);
        return this;
    }

    // MULTI SELECT DROP DOWN

    public SelectMenuPage selectValueInMultiSelectDropDown(List<String> values) {
        multiSelectDropDownSelect.click();
        for (String value : values) {
            String selectValueSelector = "//div[text()='" + value + "']";
            WebElement selectValueLocator = driver.findElement(By.xpath(selectValueSelector));
            selectValueLocator.click();
        }
        return this;
    }

    // STANDARD MULTI SELECT

    public SelectMenuPage selectValueInStandardMultiSelect(List<String> values) {
        Select select = new Select(standardMultiSelectSelect);
        for (String value : values) {
            select.selectByVisibleText(value);
        }
        return this;
    }

    // -------
    // HELPERS
    // -------

    public String getRandomElementFromList(List<String> list) {
        Random random = new Random();
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public List<String> getRandomElementsFromList(List<String> list) {
        Random random = new Random();
        int numberOfElementsToPick = random.nextInt(list.size()) + 1;
        List<String> copyList = new ArrayList<>(list);
        Collections.shuffle(copyList, random);
        return copyList.subList(0, numberOfElementsToPick);
    }

    // -------
    // GETTERS
    // -------

    public WebElement getSelectValueValue() {
        return selectValueValue;
    }

    public WebElement getSelectOneValue() {
        return selectOneValue;
    }

    public WebElement getOldStyleSelectMenuSelect() {
        return oldStyleSelectMenuSelect;
    }

    public List<WebElement> getMultiSelectDropDownValue() {
        return multiSelectDropDownValue;
    }

    public WebElement getStandardMultiSelectSelect() {
        return standardMultiSelectSelect;
    }
}
