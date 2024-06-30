package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

public class UploadAndDownloadPage extends BasePage {

    //------------
    // CONSTRUCTOR
    //------------

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    //-------------
    // WEB ELEMENTS
    //-------------

    @FindBy(css = "#downloadButton")
    private WebElement downloadButton;
    @FindBy(css = "uploadFile")
    private WebElement selectFileButton;

    //--------
    // METHODS
    //--------


}
