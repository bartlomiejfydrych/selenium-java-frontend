package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.RegisterUser;

public class RegisterUserProvider {

    private static final Faker faker = new Faker();

    public static RegisterUser getRandomRegisterUser() {
        return new RegisterUser.RegisterUserBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .userName(faker.name().username())
                .password(faker.internet().password())
                .build();
    }
}
