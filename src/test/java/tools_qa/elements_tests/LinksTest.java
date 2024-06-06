package tools_qa.elements_tests;

import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.LinksPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class LinksTest extends TestBase {

    @Test
    public void shouldOpenHomeLinkInNewTab() {

        //----------
        // VARIABLES
        //----------

        String expectedUrl = "https://demoqa.com/";

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToLinksPage()
                .clickNewTabHomeLink()
                .switchTab(1);

        //-----------
        // ASSERTIONS
        //-----------

        assertThat(driver.getCurrentUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void shouldOpenHomeDynamicLinkInNewTab() {

        //----------
        // VARIABLES
        //----------

        String expectedUrl = "https://demoqa.com/";

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToLinksPage()
                .clickNewTabHomeDynamicLink()
                .switchTab(1);

        //-----------
        // ASSERTIONS
        //-----------

        assertThat(driver.getCurrentUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void shouldOpenAllApiCallLinks() throws InterruptedException {

        //----------
        // VARIABLES
        //----------

        LinksPage linksPage = new LinksPage(driver);
        String expectedCreatedMessage = "Link has responded with staus 201 and status text Created";
        String expectedNoContentMessage = "Link has responded with staus 204 and status text No Content";
        String expectedMovedMessage = "Link has responded with staus 301 and status text Moved Permanently";
        String expectedBadRequestMessage = "Link has responded with staus 400 and status text Bad Request";
        String expectedUnauthorizedMessage = "Link has responded with staus 401 and status text Unauthorized";
        String expectedForbiddenMessage = "Link has responded with staus 403 and status text Forbidden";
        String expectedNotFoundMessage = "Link has responded with staus 404 and status text Not Found";

        //----------------------------
        // TEST EXECUTION + ASSERTIONS
        //----------------------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToLinksPage();

        // Created

        linksPage.clickCreatedLink();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedCreatedMessage);

        // No Content

        linksPage.clickNoContentLink();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedNoContentMessage);

        // Moved

        linksPage.clickMovedLink();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedMovedMessage);

        // Bad Request

        linksPage.clickBadRequestLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedBadRequestMessage);

        // Unauthorized

        linksPage.clickUnauthorizedLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedUnauthorizedMessage);

        // Forbidden

        linksPage.clickForbiddenLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedForbiddenMessage);

        // Not Found

        linksPage.clickNotFoundLink();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        assertThat(linksPage.getTextLinkResponseMessage()).isEqualTo(expectedNotFoundMessage);
    }
}
