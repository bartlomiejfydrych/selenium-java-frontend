package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.PracticeForm;

public class PracticeFormProvider {

    Faker faker = new Faker();

    public static PracticeForm getRandomPracticeForm() {
        Faker faker = new Faker();
        return new PracticeForm.PracticeFormBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .mobileNumber(faker.phoneNumber().phoneNumber())

    }

    // -------
    // METHODS
    // -------

    public void getRandomCurrentAddress() {
        String
    }

    // ----
    // DATA
    // ----
}
