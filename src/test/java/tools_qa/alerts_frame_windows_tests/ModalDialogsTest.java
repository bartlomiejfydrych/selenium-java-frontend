package tools_qa.alerts_frame_windows_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.AlertsFrameWindowsPage;
import tools_qa.pages.normal.alerts_frame_windows_pages.ModalDialogsPage;
import tools_qa.utils.WebElementMethods;

import static org.assertj.core.api.Assertions.assertThat;

public class ModalDialogsTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    AlertsFrameWindowsPage alertsFrameWindowsPage;
    ModalDialogsPage modalDialogsPage;

    WebElementMethods webElementMethods;

    @Override
    @BeforeEach
    public void setUp(){
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        modalDialogsPage = new ModalDialogsPage(driver);

        webElementMethods = new WebElementMethods(driver);
    }

    @Test
    public void shouldOpenAndGetTextFromSmallModal() {

        // -------
        // ARRANGE
        // -------

        String expectedModalHeader = "Small Modal";
        String expectedModalText = "This is a small modal. It has very less content";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToModalDialogsPage();

        modalDialogsPage.clickSmallModalButton();

        webElementMethods.waitForElementToStopMoving(modalDialogsPage.getModalWindow());

        String modalHeader = modalDialogsPage.getModalHeader().getText();
        String modalText = modalDialogsPage.getSmallModalBody().getText();

        modalDialogsPage.clickSmallModalCloseButton();

        // ------
        // ASSERT
        // ------

        assertThat(modalHeader).isEqualTo(expectedModalHeader);
        assertThat(modalText).isEqualTo(expectedModalText);
    }

    @Test
    public void shouldOpenAndGetTextFromLargeModal() {

        // -------
        // ARRANGE
        // -------

        String expectedModalHeader = "Large Modal";
        String expectedModalText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown" +
                " printer took a galley of type and scrambled it to make a type specimen book." +
                " It has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset" +
                " sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like" +
                " Aldus PageMaker including versions of Lorem Ipsum.";

        // ---
        // ACT
        // ---

        homePage.goToAlertsFrameWindowsPage();

        trainingPage.removeFooterAndAds();

        alertsFrameWindowsPage.goToModalDialogsPage();

        modalDialogsPage.clickLargeModalButton();

        webElementMethods.waitForElementToStopMoving(modalDialogsPage.getModalWindow());

        String modalHeader = modalDialogsPage.getModalHeader().getText();
        String modalText = modalDialogsPage.getLargeModalBody().getText();

        modalDialogsPage.clickLargeModalCloseButton();

        // ------
        // ASSERT
        // ------

        assertThat(modalHeader).isEqualTo(expectedModalHeader);
        assertThat(modalText).isEqualTo(expectedModalText);
    }
}
