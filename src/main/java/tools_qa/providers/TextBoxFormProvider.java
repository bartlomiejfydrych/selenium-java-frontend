package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.TextBoxForm;

public class TextBoxFormProvider {

    public static TextBoxForm getRandomTextBoxForm() {
        Faker faker = new Faker();
        return new TextBoxForm.TextBoxFormBuilder()
                .fullName(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .currentAddress(getRandomCurrentAddress())
                .permanentAddress(getRandomPermanentAddress())
                .build();
    }

    // -------
    // METHODS
    // -------

    public static String getRandomCurrentAddress() {
        Faker faker = new Faker();
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
        return currentAddress;
    }

    public static String getRandomPermanentAddress() {
        Faker faker = new Faker();
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
        return permanentAddress;
    }
}
