package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadAndDownloadPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#downloadButton")
    private WebElement downloadButton;
    @FindBy(css = "#uploadFile")
    private WebElement selectFileButton;
    @FindBy(css = "#uploadedFilePath")
    private WebElement uploadedFilePathText;

    // -------
    // METHODS
    // -------

    // DOWNLOAD FILE

    public UploadAndDownloadPage clickDownloadButton() {
        downloadButton.click();
        return this;
    }

    private static Path waitForFileDownload(String downloadDir, String expectedFileName, int timeoutInSeconds) throws InterruptedException {
        Path filePath = Paths.get(downloadDir, expectedFileName);
        for (int i = 0; i < timeoutInSeconds; i++) {
            if (Files.exists(filePath)) {
                return filePath;
            }
            Thread.sleep(1000);
        }
        return null;
    }

    public Path downloadFile(String downloadFilePath, String expectedFileName, int timeoutInSeconds) throws InterruptedException {
        try {
            Path downloadedFile = waitForFileDownload(downloadFilePath, expectedFileName, timeoutInSeconds);
            return downloadedFile;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Plik nie został pobrany");
        }
    }

    public void deleteDownloadedFile(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPLOAD FILE

    public void uploadFile() {
        File fileToUpload = new File("src/main/resources/tools_qa/UploadAndDownload/UploadAndDownloadTest_UploadFile.png");
        selectFileButton.sendKeys(fileToUpload.getAbsolutePath());
    }

    // -------
    // GETTERS
    // -------

    public WebElement getUploadedFilePathText() {
        return uploadedFilePathText;
    }
}
