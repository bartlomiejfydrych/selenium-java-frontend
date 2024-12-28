package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.configuration.Config;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.UploadAndDownloadPage;
import tools_qa.providers.DriverProvider;
import tools_qa.providers.UrlProvider;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class UploadAndDownloadTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    ElementsPage elementsPage;
    UploadAndDownloadPage uploadAndDownloadPage;

    // File download path configuration
    String generalDownloadPath = Config.getDownloadFilePath();
    String downloadDir = "UploadAndDownload";
    String downloadPath = Paths.get(generalDownloadPath, downloadDir).toString();

    @Override
    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver(Config.getBrowser(), downloadPath);
        driver.get(UrlProvider.homePage);
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToUploadAndDownloadPage() {
        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToUploadAndDownloadPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldDownloadFile() {

        // ---
        // ACT
        // ---

        navigateToUploadAndDownloadPage();
        uploadAndDownloadPage.clickDownloadButton();

        Path downloadedFile = uploadAndDownloadPage.downloadFile(downloadPath, "sampleFile.jpeg", 5);

        // ------
        // ASSERT
        // ------

        assertThat(Files.exists(downloadedFile)).isTrue();

        // -----------
        // DELETE FILE
        // -----------

        uploadAndDownloadPage.deleteDownloadedFile(downloadedFile);

        // ------
        // ASSERT
        // ------

        assertThat(Files.notExists(downloadedFile)).isTrue();
    }

    @Test
    public void shouldUploadFile() {

        // -------
        // ARRANGE
        // -------

        String expectedUploadedFilePathText = "C:\\fakepath\\UploadAndDownloadTest_UploadFile.png";

        // ---
        // ACT
        // ---

        navigateToUploadAndDownloadPage();
        uploadAndDownloadPage.uploadFile();

        // ------
        // ASSERT
        // ------

        assertThat(uploadAndDownloadPage.getUploadedFilePathText().getText()).isEqualTo(expectedUploadedFilePathText);
    }
}
