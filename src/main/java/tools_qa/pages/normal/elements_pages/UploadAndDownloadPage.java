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

    // https://demoqa.com/upload-download

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
        throw new RuntimeException("File was not downloaded within the timeout period: " + expectedFileName);
    }

    public Path downloadFile(String downloadFilePath, String expectedFileName, int timeoutInSeconds) {
        try {
            Path downloadedFile = waitForFileDownload(downloadFilePath, expectedFileName, timeoutInSeconds);
            return downloadedFile;
        } catch (Exception e) {
            throw new RuntimeException("Error during file download: " + e.getMessage(), e);
        }
    }

    public void deleteDownloadedFile(Path filePath) {
        try {
            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting file: " + filePath, e);
        }
    }

    // UPLOAD FILE

    public void uploadFile() {
        Path fileToUploadPath = Paths.get("src/main/resources/tools_qa/test_files/elements_files/upload_and_download/UploadAndDownloadTest_UploadFile.png").toAbsolutePath();
        File fileToUpload = fileToUploadPath.toFile();
        if (!fileToUpload.exists()) {
            throw new IllegalArgumentException("File does not exist: " + fileToUploadPath);
        }
        selectFileButton.sendKeys(fileToUpload.getAbsolutePath());
    }

    // -------
    // GETTERS
    // -------

    public WebElement getUploadedFilePathText() {
        return uploadedFilePathText;
    }
}
