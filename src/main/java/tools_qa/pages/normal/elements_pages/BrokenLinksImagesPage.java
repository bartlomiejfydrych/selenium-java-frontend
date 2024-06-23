package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class BrokenLinksImagesPage extends BasePage {

    //------------
    // CONSTRUCTOR
    //------------

    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    //-------------
    // WEB ELEMENTS
    //-------------

    @FindBy(xpath = "(//img[@src='/images/Toolsqa.jpg'])[2]")
    private WebElement validImage;
    @FindBy(css = "img[src='/images/Toolsqa_1.jpg']")
    private WebElement brokenImage;
    @FindBy(css = "a[href='http://demoqa.com']")
    private WebElement validLink;
    @FindBy(css = "a[href='http://the-internet.herokuapp.com/status_codes/500']")
    private WebElement brokenLink;

    //--------
    // METHODS
    //--------

    // Images

    public int getHttpStatus(WebElement webElement, String attributeName) {
        int responseCode = 0;
        try {
            String elementUrl = webElement.getAttribute(attributeName);
            URL url = new URI(elementUrl).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            responseCode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the HTTP status of Web Element");
        }
        return responseCode;
    }

    public int getImageWidth(WebElement webElement) {
        return ((Long) jse.executeScript("return arguments[0].naturalWidth;", webElement)).intValue();
    }

    public int getImageHeight(WebElement webElement) {
        return ((Long) jse.executeScript("return arguments[0].naturalHeight", webElement)).intValue();
    }

    // Links

    public BrokenLinksImagesPage clickValidLink() {
        validLink.click();
        return this;
    }

    public BrokenLinksImagesPage clickBrokenLink() {
        brokenLink.click();
        return this;
    }

    //--------
    // GETTERS
    //--------

    // Images

    public WebElement getValidImage() {
        return validImage;
    }

    public WebElement getBrokenImage() {
        return brokenImage;
    }

    // Links

    public WebElement getValidLink() {
        return validLink;
    }

    public WebElement getBrokenLink() {
        return brokenLink;
    }
}
