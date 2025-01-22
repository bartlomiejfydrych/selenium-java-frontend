package tools_qa.models_providers.forms_models.practice_form;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class PracticeFormProvider {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static PracticeForm getRandomPracticeForm() {
        String state = getRandomElementFromList(stateList);
        return new PracticeForm.PracticeFormBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .gender(getRandomElementFromList(genderList))
                .mobileNumber(faker.number().digits(10))
                .dateOfBirth(getRandomDateOfBirth())
                .subjectList(getRandomSublist(subjectList, 5))
                .hobbyList(getRandomSublist(hobbyList, 3))
                .currentAddress(generateRandomCurrentAddress())
                .state(state)
                .city(getRandomElementFromList(stateCityMap.get(state)))
                .build();
    }

    public static PracticeForm getRandomPracticeFormRequiredData() {
        return new PracticeForm.PracticeFormOnlyRequiredDataBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .gender(getRandomElementFromList(genderList))
                .mobileNumber(faker.number().digits(10))
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

    private static String getRandomDateOfBirth() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(1900, Calendar.JANUARY, 1);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(2100, Calendar.DECEMBER, 31);
        Date randomDate = faker.date().between(startCalendar.getTime(), endCalendar.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy d", Locale.ENGLISH);
        String formattedDate = dateFormat.format(randomDate);
        return formattedDate;
    }

    private static String generateRandomCurrentAddress() {
        return String.format("%s\n%s\n%s\n%s %s/%s",
                faker.address().country(),
                faker.address().city(),
                faker.address().zipCode(),
                faker.address().streetName(),
                faker.address().streetAddressNumber(),
                faker.address().buildingNumber());
    }

    // ----
    // DATA
    // ----

    // Gender
    private static final List<String> genderList = List.of("Male", "Female", "Other");

    // Subjects
    private static final List<String> subjectList = List.of(
            "English",
            "Chemistry",
            "Computer Science",
            "Commerce",
            "Economics",
            "Social Studies",
            "Arts",
            "History",
            "Accounting",
            "Physics",
            "Biology",
            "Hindi",
            "Civics"
    );

    // Hobbies
    private static final List<String> hobbyList = List.of("Sports", "Reading", "Music");

    // State
    private static final List<String> stateList = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    // City
    private static final Map<String, List<String>> stateCityMap = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );
}
