package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.RegisterUser;

public class RegisterUserProvider {

    public static RegisterUser getRandomRegisterUser() {
        Faker faker = new Faker();
        return new RegisterUser.RegisterUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .userName(faker.name().username())
                .password(faker.internet().password())
                .build();
    }
}
