package tools_qa.providers;

import com.github.javafaker.Faker;
import tools_qa.models.TableRow;

public class TableRowProvider {

    public static TableRow getRandomTableRow() {
        Faker faker = new Faker();
        return new TableRow.TableRowBuilder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .age(Integer.toString(faker.number().numberBetween(1, 110)))
                .salary(Integer.toString(faker.number().numberBetween(2000, 15000)))
                .department(faker.job().title())
                .build();
    }
}
