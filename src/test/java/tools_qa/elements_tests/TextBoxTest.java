package tools_qa.elements_tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.TextBoxPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextBoxTest extends TestBase {

    @Test
    public void shouldFillTextBoxes() {

        //----------
        // VARIABLES
        //----------

        // Init Faker
        Faker faker = new Faker();

        // Generate data
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        // Current Address
        String currentAddressCountry = faker.address().country();
        String currentAddressCity = faker.address().city();
        String currentAddressZipCode = faker.address().zipCode();
        String currentAddressStreetName = faker.address().streetName();
        String currentAddressStreetNumber = faker.address().streetAddressNumber();
        String currentAddressBuildingNumber = faker.address().buildingNumber();
        String currentAddress = currentAddressCountry + "\n"
                + currentAddressCity + "\n"
                + currentAddressZipCode + "\n"
                + currentAddressStreetName + " " + currentAddressStreetNumber + "/" + currentAddressBuildingNumber;
        // Permanent Address
        String permanentAddressCountry = faker.address().country();
        String permanentAddressCity = faker.address().city();
        String permanentAddressZipCode = faker.address().zipCode();
        String permanentAddressStreetName = faker.address().streetName();
        String permanentAddressStreetNumber = faker.address().streetAddressNumber();
        String permanentAddressBuildingNumber = faker.address().buildingNumber();
        String permanentAddress = permanentAddressCountry + "\n"
                + permanentAddressCity + "\n"
                + permanentAddressZipCode + "\n"
                + permanentAddressStreetName + " " + permanentAddressStreetNumber + "/" + permanentAddressBuildingNumber;

        // Expected data
        String expectedNameParagraph = "Name:" + fullName;
        String expectedEmailParagraph = "Email:" + email;
        String expectedCurrentAddressParagraph = "Current Address :"
                + currentAddressCountry + " "
                + currentAddressCity + " "
                + currentAddressZipCode + " "
                + currentAddressStreetName + " "
                + currentAddressStreetNumber + "/"
                + currentAddressBuildingNumber;
        String expectedPermanentAddressParagraph = "Permananet Address :"
                + permanentAddressCountry + " "
                + permanentAddressCity + " "
                + permanentAddressZipCode + " "
                + permanentAddressStreetName + " "
                + permanentAddressStreetNumber + "/"
                + permanentAddressBuildingNumber;

        //---------------
        // TEST EXECUTION
        //---------------

        new HomePage(driver)
                .goToElementsPage()
                .removeAdFrameAndFooter()
                .goToTextBoxPage()
                .writeFullName(fullName)
                .writeEmail(email)
                .writeCurrentAddress(currentAddress)
                .writePermanentAddress(permanentAddress)
                .clickSubmit();

        //-----------
        // ASSERTIONS
        //-----------

        // Get current data
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        String nameParagraph = textBoxPage.getNameParagraph();
        String emailParagraph = textBoxPage.getEmailParagraph();
        String currentAddressParagraph = textBoxPage.getCurrentAddressParagraph();
        String permanentAddressParagraph = textBoxPage.getPermanentAddressParagraph();

        assertThat(nameParagraph).isEqualTo(expectedNameParagraph);
        assertThat(emailParagraph).isEqualTo(expectedEmailParagraph);
        assertThat(currentAddressParagraph).isEqualTo(expectedCurrentAddressParagraph);
        assertThat(permanentAddressParagraph).isEqualTo(expectedPermanentAddressParagraph);
    }
}
