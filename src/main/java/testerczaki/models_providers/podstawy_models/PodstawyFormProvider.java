package testerczaki.models_providers.podstawy_models;

import com.github.javafaker.Faker;

public class PodstawyFormProvider {

    private static final Faker faker = new Faker();

    public static PodstawyForm getRandomPodstawyForm() {
        return new PodstawyForm.PodstawyFormBuilder()
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
