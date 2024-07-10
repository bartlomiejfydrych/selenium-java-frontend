package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.UploadAndDownloadPage;
import tools_qa.utils.FileManagement;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class UploadAndDownloadTest extends TestBase {

    @Test
    public void shouldDownloadFile() throws InterruptedException {

        //--------
        // ARRANGE
        //--------

        String downloadDir = "tools_qa/UploadAndDownload";
        driver = FileManagement.createChromeDriverForDownloads(downloadDir);
        UploadAndDownloadPage uploadAndDownloadPage = new UploadAndDownloadPage(driver);

        //----
        // ACT
        //----

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToUploadAndDownloadPage()
                .clickDownloadButton();

        Path downloadedFile = uploadAndDownloadPage.downloadFile(downloadDir, "sampleFile.jpeg", 5);

        //-------
        // ASSERT
        //-------

        assertThat(Files.exists(downloadedFile)).isTrue();

        //------------
        // DELETE FILE
        //------------

        uploadAndDownloadPage.deleteDownloadedFile(downloadedFile);
    }
}
