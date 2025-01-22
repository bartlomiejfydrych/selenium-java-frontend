package tools_qa.models_providers.elements_models.web_tables;

import com.github.javafaker.Faker;

public class TableRowProvider {

    private static final Faker faker = new Faker();

    public static TableRow getRandomTableRow() {
        return new TableRow.TableRowBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(Integer.toString(faker.number().numberBetween(1, 99)))
                .salary(Integer.toString(faker.number().numberBetween(2000, 999999999)))
                .department(faker.job().field())
                .build();
    }
}
