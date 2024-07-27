package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.LinksPage;


import static org.assertj.core.api.Assertions.assertThat;

public class LinksTest extends TestBase {

    HomePage homePage;
    ElementsPage elementsPage;
    LinksPage linksPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        linksPage = new LinksPage(driver);
    }

    @Test
    public void shouldOpenHomeLinkInNewTab() {

        // -------
        // ARRANGE
        // -------

        String expectedUrl = "https://demoqa.com/";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        elementsPage.removeAdFrameAndFooter()
                .goToLinksPage();

        linksPage.clickNewTabHomeLink()
                .switchTab(1);

        // ------
        // ASSERT
        // ------

        assertThat(driver.getCurrentUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void shouldOpenHomeDynamicLinkInNewTab() {

        // -------
        // ARRANGE
        // -------

        String expectedUrl = "https://demoqa.com/";

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();

        elementsPage.removeAdFrameAndFooter()
                .goToLinksPage();

        linksPage.clickNewTabHomeDynamicLink()
                .switchTab(1);

        // ------
        // ASSERT
        // ------

        assertThat(driver.getCurrentUrl()).isEqualTo(expectedUrl);
    }

    @Test
    public void shouldOpenAllApiCallLinks() {

        // -------
        // ARRANGE
        // -------

        String expectedCreatedMessage = "Link has responded with staus 201 and status text Created";
        String expectedNoContentMessage = "Link has responded with staus 204 and status text No Content";
        String expectedMovedMessage = "Link has responded with staus 301 and status text Moved Permanently";
        String expectedBadRequestMessage = "Link has responded with staus 400 and status text Bad Request";
        String expectedUnauthorizedMessage = "Link has responded with staus 401 and status text Unauthorized";
        String expectedForbiddenMessage = "Link has responded with staus 403 and status text Forbidden";
        String expectedNotFoundMessage = "Link has responded with staus 404 and status text Not Found";

        // ------------
        // ACT + ASSERT
        // ------------

        homePage.goToElementsPage();

        elementsPage.removeAdFrameAndFooter()
                .goToLinksPage();

        /*
        NOTE:
        I know these assertions are a bit weird, but I decided to use
        "defaultWait.until(ExpectedConditions.textToBePresentInElement(linkResponseMessage, expectedText));"
        instead of Thread.sleep()
        */

        // Created

        linksPage.clickCreatedLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedCreatedMessage)).isEqualTo(expectedCreatedMessage);

        // No Content

        linksPage.clickNoContentLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedNoContentMessage)).isEqualTo(expectedNoContentMessage);

        // Moved

        linksPage.clickMovedLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedMovedMessage)).isEqualTo(expectedMovedMessage);

        // Bad Request

        linksPage.clickBadRequestLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedBadRequestMessage)).isEqualTo(expectedBadRequestMessage);

        // Unauthorized

        linksPage.clickUnauthorizedLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedUnauthorizedMessage)).isEqualTo(expectedUnauthorizedMessage);

        // Forbidden

        linksPage.clickForbiddenLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedForbiddenMessage)).isEqualTo(expectedForbiddenMessage);

        // Not Found

        linksPage.clickNotFoundLink();
        assertThat(linksPage.getTextLinkResponseMessage(expectedNotFoundMessage)).isEqualTo(expectedNotFoundMessage);
    }
}
