package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.BrokenLinksImagesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class BrokenLinksImagesTest extends TestBase {

    @Test
    public void shouldValidImageLoadAndHaveCorrectWidthAndHeight() {

        //----------
        // VARIABLES
        //----------

        BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
        WebElement validImage = brokenLinksImagesPage.getValidImage();
        int expectedImageWidth = 347;
        int expectedImageHeight = 100;

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToBrokenLinksImagesPage();

        int responseCode = brokenLinksImagesPage.getHttpStatus(validImage, "src");
        int actualImageWidth = brokenLinksImagesPage.getImageWidth(validImage);
        int actualImageHeight = brokenLinksImagesPage.getImageHeight(validImage);

        //-----------
        // ASSERTIONS
        //-----------

        assertThat(responseCode).isEqualTo(200);
        assertThat(actualImageWidth).isEqualTo(expectedImageWidth);
        assertThat(actualImageHeight).isEqualTo(expectedImageHeight);
    }

    @Test
    public void shouldBrokenImageNotBeDisplayed() {

        //----------
        // VARIABLES
        //----------

        BrokenLinksImagesPage brokenLinksImagesPage = new BrokenLinksImagesPage(driver);
        WebElement brokenImage = brokenLinksImagesPage.getBrokenImage();
        int expectedImageWidth = 0;
        int expectedImageHeight = 0;

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToBrokenLinksImagesPage();

        int responseCode = brokenLinksImagesPage.getHttpStatus(brokenImage, "src");
        int actualImageWidth = brokenLinksImagesPage.getImageWidth(brokenImage);
        int actualImageHeight = brokenLinksImagesPage.getImageHeight(brokenImage);

        //-----------
        // ASSERTIONS
        //-----------

        /*
        NOTE:
        Even though the image is not displayed his URL returns 200.
        I think it's worth checking this in case an image is not displayed due to problems with his URL.
        */

        assertThat(responseCode).isEqualTo(200);
        assertThat(actualImageWidth).isEqualTo(expectedImageWidth);
        assertThat(actualImageHeight).isEqualTo(expectedImageHeight);
    }
}
