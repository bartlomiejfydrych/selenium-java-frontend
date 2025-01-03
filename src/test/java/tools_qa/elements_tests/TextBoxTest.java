package tools_qa.elements_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.models.TextBoxForm;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.elements_pages.ElementsPage;
import tools_qa.pages.normal.elements_pages.TextBoxPage;
import tools_qa.providers.TextBoxFormProvider;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextBoxTest extends TestBase {

    private HomePage homePage;
    private TrainingPage trainingPage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void shouldFillTextBoxes() {

        // -------
        // ARRANGE
        // -------

        TextBoxForm textBoxForm = TextBoxFormProvider.getRandomTextBoxForm();
        String expectedFullNameParagraph = "Name:" + textBoxForm.getFullName();
        String expectedEmailParagraph = "Email:" + textBoxForm.getEmail();
        String expectedCurrentAddressParagraph = "Current Address :" + textBoxForm.getCurrentAddress().replace("\n", " ");
        String expectedPermanentAddressParagraph = "Permananet Address :" + textBoxForm.getPermanentAddress().replace("\n", " ");

        // ---
        // ACT
        // ---

        homePage.goToElementsPage();
        trainingPage.removeFooterAndAds();
        elementsPage.goToTextBoxPage();
        textBoxPage.fillTextBoxForm(textBoxForm)
                .clickSubmit();

        // ------
        // ASSERT
        // ------

        assertThat(textBoxPage.getFullNameParagraph().getText()).isEqualTo(expectedFullNameParagraph);
        assertThat(textBoxPage.getEmailParagraph().getText()).isEqualTo(expectedEmailParagraph);
        assertThat(textBoxPage.getCurrentAddressParagraph().getText()).isEqualTo(expectedCurrentAddressParagraph);
        assertThat(textBoxPage.getPermanentAddressParagraph().getText()).isEqualTo(expectedPermanentAddressParagraph);
    }
}

/*

// ------
// NOTES:
// ------

I wanted to leave this in the test as a single example, but I couldn't look at it, so I made a Builder here too.
I'm posting an example of directly generating data in the test using Faker here as a cheat sheet for myself.

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

*/
