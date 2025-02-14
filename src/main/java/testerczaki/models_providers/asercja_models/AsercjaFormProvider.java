package testerczaki.models_providers.asercja_models;

import com.github.javafaker.Faker;

public class AsercjaFormProvider {

    private static final Faker faker = new Faker();

    public static AsercjaForm getRandomAsercjaForm() {
        return new AsercjaForm.AsercjaFormBuilder()
                .imie(faker.name().firstName())
                .nazwisko(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .miasto(faker.address().city())
                .ulica(generateRandomStreetAddress())
                .build();
    }

    // -------
    // METHODS
    // -------

    private static String generateRandomStreetAddress() {
        return String.format("%s %s/%s",
                faker.address().streetName(),
                faker.address().streetAddressNumber(),
                faker.address().buildingNumber());
    }
}
