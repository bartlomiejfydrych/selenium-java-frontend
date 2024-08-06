package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.PracticeForm;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticeFormProvider {

    public static PracticeForm getRandomPracticeForm() {
        Faker faker = new Faker();
        String state = getRandomState();
        return new PracticeForm.PracticeFormBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .mobileNumber(faker.phoneNumber().phoneNumber())
                .currentAddress(getRandomCurrentAddress())
                .state(state)
                .city(getRandomCity(state))
                .build();
    }

    // -------
    // METHODS
    // -------

    public static String getRandomCurrentAddress() {
        Faker faker = new Faker();
        String country = faker.address().country();
        String city = faker.address().city();
        String zipCode = faker.address().zipCode();
        String streetName = faker.address().streetName();
        String streetNumber = faker.address().streetAddressNumber();
        String buildingNumber = faker.address().buildingNumber();
        String currentAddress = country + "\n"
                + city + "\n"
                + zipCode + "\n"
                + streetName + " " + streetNumber + "/" + buildingNumber;
        return currentAddress;
    }

    public static String getRandomState() {
        Random random = new Random();
        String randomState = stateList.get(random.nextInt(stateList.size()));
        return randomState;
    }

    public static String getRandomCity(String state) {
        Random random = new Random();
        String randomCity = "";
        switch(state) {
            case "NCR":
                randomCity = cityNcrList.get(random.nextInt(cityNcrList.size()));
                break;
            case "Uttar Pradesh":
                randomCity = cityUttarPradeshList.get(random.nextInt(cityUttarPradeshList.size()));
                break;
            case "Haryana":
                randomCity = cityHaryanaList.get(random.nextInt(cityHaryanaList.size()));
                break;
            case "Rajasthan":
                randomCity = cityRajasthanList.get(random.nextInt(cityRajasthanList.size()));
                break;
            default:
                throw new IllegalArgumentException("Invalid state: " + state);
        }
        return randomCity;
    }

    // ----
    // DATA
    // ----

    // State

    static List<String> stateList = Arrays.asList(
            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"
    );

    // City

    static List<String> cityNcrList = Arrays.asList(
            "Delhi",
            "Gurgaon",
            "Noida"
    );

    static List<String> cityUttarPradeshList = Arrays.asList(
            "Agra",
            "Lucknow",
            "Merrut"
    );

    static List<String> cityHaryanaList = Arrays.asList(
            "Karnal",
            "Panipat"
    );

    static List<String> cityRajasthanList = Arrays.asList(
            "Jaipur",
            "Jaiselmer"
    );
}
