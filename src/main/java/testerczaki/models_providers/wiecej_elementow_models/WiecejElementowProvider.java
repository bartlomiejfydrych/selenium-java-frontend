package testerczaki.models_providers.wiecej_elementow_models;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WiecejElementowProvider {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static WiecejElementowForm getRandomWiecejElementowForm() {
        return new WiecejElementowForm.WiecejElementowBuilder()
                .imie(faker.name().firstName())
                .nazwisko(faker.name().lastName())
                .kraj(getRandomElementFromList(krajList))
                .jezykProgramowania(getRandomSublist(jezykProgramowaniaList, 5))
                .oSobie(faker.lorem().sentence() + "\n" + faker.lorem().sentence())
                .plec(getRandomElementFromList(plecList))
                .build();
    }

    // -------
    // METHODS
    // -------

    private static String getRandomElementFromList(List<String> list) {
        String randomElement = list.get(random.nextInt(list.size()));
        return randomElement;
    }

    private static List<String> getRandomSublist(List<String> list, int maxAmountOfElements) {
        int numberOfElementsToGet = random.nextInt(maxAmountOfElements) + 1;
        return new ArrayList<>(list.subList(0, numberOfElementsToGet));
    }

    // ----
    // DATA
    // ----

    // Kraj
    private static final List<String> krajList = List.of(
            "Polska",
            "Rosja",
            "Niemcy",
            "Tonga",
            "Meksyk"
    );

    // Język programowania
    private static final List<String> jezykProgramowaniaList = List.of(
            "Python",
            "Java",
            "C#",
            "JavaScript",
            "PHP"
    );

    // Płeć
    private static final List<String> plecList = List.of(
            "Mężczyzna",
            "Kobieta",
            "Inne"
    );
}
