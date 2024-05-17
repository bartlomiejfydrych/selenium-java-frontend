package tools_qa.elements_tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.normal.elements_pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    @Test
    public void shouldFillTextBoxes() {

        // Init Faker
        Faker faker = new Faker();

        // Test data
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

        // Test execution
        new HomePage(driver)
                .goToElementsPage()
                .goToTextBoxPage()
                .writeFullName(fullName)
                .writeEmail(email)
                .writeCurrentAddress(currentAddress)
                .writePermanentAddress(permanentAddress)
                .clickSubmit();
        // Assertion
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        String nameParagraph = textBoxPage.getNameParagraph();
        String emailParagraph = textBoxPage.getEmailParagraph();
        String currentAddressParagraph = textBoxPage.getCurrentAddressParagraph();
        String permanentAddressParagraph = textBoxPage.getPermanentAddressParagraph();
        System.out.println(nameParagraph);
        System.out.println(emailParagraph);
        System.out.println(currentAddressParagraph);
        System.out.println(permanentAddressParagraph);
    }
}
