package tools_qa.models_providers.elements_models.text_box;

import com.github.javafaker.Faker;

public class TextBoxFormProvider {

    private static final Faker faker = new Faker();

    public static TextBoxForm getRandomTextBoxForm() {
        return new TextBoxForm.TextBoxFormBuilder()
                .fullName(faker.name().fullName())
                .email(faker.internet().emailAddress())
                .currentAddress(generateRandomAddress())
                .permanentAddress(generateRandomAddress())
                .build();
    }

    // -------
    // METHODS
    // -------

    private static String generateRandomAddress() {
        return String.format("%s\n%s\n%s\n%s %s/%s",
                faker.address().country(),
                faker.address().city(),
                faker.address().zipCode(),
                faker.address().streetName(),
                faker.address().streetAddressNumber(),
                faker.address().buildingNumber());
    }
}
