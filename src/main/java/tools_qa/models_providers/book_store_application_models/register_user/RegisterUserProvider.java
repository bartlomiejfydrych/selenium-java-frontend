package tools_qa.models_providers.book_store_application_models.register_user;

import com.github.javafaker.Faker;

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
