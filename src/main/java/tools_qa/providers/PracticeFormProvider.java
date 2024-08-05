package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.PracticeForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticeFormProvider {

    public static PracticeForm getRandomPracticeForm() {
        Faker faker = new Faker();
        return new PracticeForm.PracticeFormBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .mobileNumber(faker.phoneNumber().phoneNumber())
                .currentAddress(getRandomCurrentAddress())


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

    public String getRandomState() {
        Random random = new Random();
        String randomState = stateList.get(random.nextInt(stateList.size()));
        return randomState;
    }

    public String getRandomCity(String state) {
        switch(state) {
            case "NCR":

        }
    }

    // ----
    // DATA
    // ----

    // State

    List<String> stateList = Arrays.asList(
            "NCR",
            "Uttar Pradesh",
            "Haryana",
            "Rajasthan"
    );

    // City

    List<String> cityNcrList = Arrays.asList(
            "Delhi",
            "Gurgaon",
            "Noida"
    );

    List<String> cityUttarPradeshList = Arrays.asList(
            "Agra",
            "Lucknow",
            "Merrut"
    );

    List<String> cityHaryanaList = Arrays.asList(
            "Karnal",
            "Panipat"
    );

    List<String> cityRajasthanList = Arrays.asList(
            "Jaipur",
            "Jaiselmer"
    );
}
