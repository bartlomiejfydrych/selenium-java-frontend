package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.BrokenLinksImagesPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class BrokenLinksImagesTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private BrokenLinksImagesPage brokenLinksImagesPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
    }

    // -------
    // HELPERS
    // -------

    private void navigateToBrokenLinksImagesPage() {
        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToBrokenLinksImagesPage();
    }

    // -----
    // TESTS
    // -----

    @Test
    public void shouldValidImageLoadAndHaveCorrectWidthAndHeight() {

        // -------
        // ARRANGE
        // -------

        WebElement validImage = brokenLinksImagesPage.getValidImage();
        int expectedImageWidth = 347;
        int expectedImageHeight = 100;

        // ---
        // ACT
        // ---

        navigateToBrokenLinksImagesPage();
        int responseCode = brokenLinksImagesPage.getHttpStatus(validImage, "src");
        int actualImageWidth = brokenLinksImagesPage.getImageWidth(validImage);
        int actualImageHeight = brokenLinksImagesPage.getImageHeight(validImage);

        // ------
        // ASSERT
        // ------

        assertThat(responseCode).isEqualTo(200);
        assertThat(actualImageWidth).isEqualTo(expectedImageWidth);
        assertThat(actualImageHeight).isEqualTo(expectedImageHeight);
    }

    @Test
    public void shouldBrokenImageNotBeDisplayed() {

        // -------
        // ARRANGE
        // -------

        WebElement brokenImage = brokenLinksImagesPage.getBrokenImage();
        int expectedImageWidth = 0;
        int expectedImageHeight = 0;

        // ---
        // ACT
        // ---

        navigateToBrokenLinksImagesPage();
        int responseCode = brokenLinksImagesPage.getHttpStatus(brokenImage, "src");
        int actualImageWidth = brokenLinksImagesPage.getImageWidth(brokenImage);
        int actualImageHeight = brokenLinksImagesPage.getImageHeight(brokenImage);

        // ------
        // ASSERT
        // ------

        /*
        NOTE:
        Even though the image is not displayed his URL returns 200.
        I think it's worth checking this in case an image is not displayed due to problems with his URL.
        */

        assertThat(responseCode).isEqualTo(200);
        assertThat(actualImageWidth).isEqualTo(expectedImageWidth);
        assertThat(actualImageHeight).isEqualTo(expectedImageHeight);
    }

    @Test
    public void shouldOpenValidLink() {

        // -------
        // ARRANGE
        // -------

        WebElement validLink = brokenLinksImagesPage.getValidLink();
        String expectedUrl = "https://demoqa.com/";

        // ---
        // ACT
        // ---

        navigateToBrokenLinksImagesPage();
        int responseCode = brokenLinksImagesPage.getHttpStatus(validLink, "href");

        brokenLinksImagesPage.clickValidLink();
        String currentUrl = driver.getCurrentUrl();

        // ------
        // ASSERT
        // ------

        assertThat(responseCode).isEqualTo(301);
        assertThat(currentUrl).isEqualTo(expectedUrl);
    }

    @Test
    public void shouldOpenBrokenLink() {

        // -------
        // ARRANGE
        // -------

        WebElement brokenLink = brokenLinksImagesPage.getBrokenLink();
        String expectedUrl = "https://the-internet.herokuapp.com/status_codes/500";

        // ---
        // ACT
        // ---

        navigateToBrokenLinksImagesPage();
        int responseCode = brokenLinksImagesPage.getHttpStatus(brokenLink, "href");

        brokenLinksImagesPage.clickBrokenLink();
        String currentUrl = driver.getCurrentUrl();

        // ------
        // ASSERT
        // ------

        assertThat(responseCode).isEqualTo(500);
        assertThat(currentUrl).isEqualTo(expectedUrl);
    }
}
