package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class ElementsPage extends BasePage {

    // Konstruktor

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    // Web Elementy

    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Text Box']")
    private WebElement textBoxButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Check Box']")
    private WebElement checkBoxButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Radio Button']")
    private WebElement radioButtonButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Web Tables']")
    private WebElement webTablesButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Buttons']")
    private WebElement buttonsButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Links']")
    private WebElement linksButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Broken Links - Images']")
    private WebElement brokenLinksImagesButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Upload and Download']")
    private WebElement uploadAndDownloadButton;
    @FindBy(xpath = "//div[contains(@class,'element-list')]/ul/li/span[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesButton;
    // Ad
    @FindBy(css = "#fixedban")
    private WebElement adFrame;
    // Footer
    @FindBy(css = "footer")
    private WebElement footer;

    // Metody

    public ElementsPage removeAdFrameAndFooter() {
        jse.executeScript("arguments[0].remove();", adFrame);
        jse.executeScript("arguments[0].remove();", footer);
        return this;
    }

    public TextBoxPage goToTextBoxPage() {
        textBoxButton.click();
        return new TextBoxPage(driver);
    }

    public CheckBoxPage goToCheckBoxPage() {
        checkBoxButton.click();
        return new CheckBoxPage(driver);
    }

    public RadioButtonPage goToRadioButtonPage() {
        radioButtonButton.click();
        return new RadioButtonPage(driver);
    }

    public WebTablesPage goToWebTablesPage() {
        webTablesButton.click();
        return new WebTablesPage(driver);
    }

    public ButtonsPage goToButtonsPage() {
        buttonsButton.click();
        return new ButtonsPage(driver);
    }

    public LinksPage goToLinksPage() {
        linksButton.click();
        return new LinksPage(driver);
    }

    public BrokenLinksImagesPage goToBrokenLinksImagesPage() {
        brokenLinksImagesButton.click();
        return new BrokenLinksImagesPage(driver);
    }
}
