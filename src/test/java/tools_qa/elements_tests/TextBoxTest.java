package tools_qa.elements_tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;

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

        // Test execution
        new HomePage(driver)
                .goToElementsPage()
                .goToTextBoxPage()
                .writeFullName(fullName)
                .writeEmail(email)
                .writeCurrentAddress(
                        "New York"
                );
//                .writePermanentAddress()
//                .clickSubmit()

        // Assertion
    }
}
