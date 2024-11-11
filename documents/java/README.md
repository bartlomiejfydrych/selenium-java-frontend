# ☕Java — notatki

## 📑Spis

- [Builder](#builder)
- [Plik konfiguracyjny — config.properties](#config)
- [Enum](#enum)
- [ENV — Zmienne środowiskowe](#env)
3. TODO: JavaFaker
   https://www.baeldung.com/java-faker

---

## Builder <a name="builder"></a>

**Linki:** (więcej szukać pod hasłem `java builder`)  
https://devcave.pl/effective-java/wzorzec-projektowy-builder

Wzorzec projektowy Builder w Javie to konstrukcyjny wzorzec projektowy, który pozwala na tworzenie skomplikowanych
obiektów krok po kroku. Używany jest do oddzielenia procesu tworzenia obiektu od jego reprezentacji, co umożliwia
tworzenie różnych reprezentacji tego samego obiektu. Wzorzec ten jest szczególnie przydatny, gdy obiekty mają wiele
parametrów konfiguracyjnych lub gdy proces tworzenia obiektu jest złożony.

1. Tworzymy w katalogu `main->java` package o nazwie `models`
2. W katalogu `models` tworzymy klasę np. `TableRow`, którą będziemy chcieli budować
3. Deklarujemy w niej:
   - Zmienne
   - Konstruktor
   - Gettery
   - Klasę `TableRowBuilder`:
     - Zmienne
     - Konstruktor dla każdej zmiennej
     - Metodę `build()`
    ```Java
    package tools_qa.models;
    
    public class TableRow {
    
        private String firstName;
        private String lastName;
        private String email;
        private String age;
        private String salary;
        private String department;
    
        public TableRow(String firstName, String lastName, String email, String age, String salary, String department) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }
    
        public String getAge() {
            return age;
        }
    
        public String getFirstName() {
            return firstName;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public String getEmail() {
            return email;
        }
    
        public String getSalary() {
            return salary;
        }
    
        public String getDepartment() {
            return department;
        }
    
        public static final class TableRowBuilder {
    
            private String firstName;
            private String lastName;
            private String email;
            private String age;
            private String salary;
            private String department;
    
            public TableRowBuilder firstName(String firstName) {
                this.firstName = firstName;
                return this;
            }
    
            public TableRowBuilder lastName(String lastName) {
                this.lastName = lastName;
                return this;
            }
    
            public TableRowBuilder email(String email) {
                this.email = email;
                return this;
            }
    
            public TableRowBuilder age(String age) {
                this.age = age;
                return this;
            }
    
            public TableRowBuilder salary(String salary) {
                this.salary = salary;
                return this;
            }
    
            public TableRowBuilder department(String department) {
                this.department = department;
                return this;
            }
    
            public TableRow build() {
                return new TableRow(firstName, lastName, email, age, salary, department);
            }
        }
    }
    ```
4. W katalogu `main->java->providers` tworzymy klasę `TableRowProvider`, która będzie budować obiekt na podstawie naszego modelu
5. W niej przy pomocy `JavaFaker` możemy budować nasz obiekt
   - Można też coś utworzyć na sztywno
   - Można też tworzyć coś pobierając dane z bazy danych
   ```Java
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
                    .age(Integer.toString(faker.number().numberBetween(1, 99)))
                    .salary(Integer.toString(faker.number().numberBetween(2000, 999999999)))
                    .department(faker.job().field())
                    .build();
        }
    }
   ```
6. W klasie `Page` pod którą robimy dany builder tworzymy metody uzupełniające pola
7. Następnie tworzymy metodę, która ma wypełnić cały formularz używając stworzonych metod wraz z naszym modelem
    ```Java
    public WebTablesPage fillRowForm(TableRow tableRow) {
        writeFirstName(tableRow.getFirstName());
        writeLastName(tableRow.getLastName());
        writeEmail(tableRow.getEmail());
        writeAge(tableRow.getAge());
        writeSalary(tableRow.getSalary());
        writeDepartment(tableRow.getDepartment());
        clickSubmitButton();
        return this;
    }

    // Registration form

    public WebTablesPage writeFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public WebTablesPage writeLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public WebTablesPage writeEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return this;
    }

    public WebTablesPage writeAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
        return this;
    }

    public WebTablesPage writeSalary(String salary) {
        salaryInput.clear();
        salaryInput.sendKeys(salary);
        return this;
    }

    public WebTablesPage writeDepartment(String department) {
        departmentInput.clear();
        departmentInput.sendKeys(department);
        return this;
    }

    public WebTablesPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
    ```
8. W teście tworzymy obiekt z metody, która generuje dla niego dane za pomocą Fakera i używamy jako argument
   ```Java
   TableRow addedTableRow = TableRowProvider.getRandomTableRow();
   webTablesPage.fillRowForm(addedTableRow);
   ```

Przykładowy kod jest w linku lub zastosowany tutaj:
- `java` -> `tools_qa` -> `models` -> `TableRow`
- `java` -> `tools_qa` -> `providers` -> `TableRowProvider`
- `java` -> `tools_qa` -> `pages` -> `normal` -> `elements_pages` -> `WebTablesPage`
- `test` -> `java` -> `tools_qa` -> `elements_tests` -> `WebTablesTest`

---

## Plik konfiguracyjny — config.properties <a name="config"></a>

**Linki:**  
https://www.baeldung.com/java-properties  
https://crunchify.com/java-properties-file-how-to-read-config-properties-values-in-java/  
https://mkyong.com/java/java-properties-file-examples/  
https://www.numpyninja.com/post/how-to-read-property-file-in-java

**Wstęp**  
Dane związane z konfiguracją/ustawieniami projektu i jego środowiskiem powinny być przechowywane w osobnym pliku,
którego zmiany nie będą za każdym razem commitowane. Jest to szczególnie ważne, jeżeli potrzebujemy gdzieś trzymać dane
dostępowe takie jak loginy i hasła, aby nie pojawiły się na repozytorium projektu.

**config.properties - Tworzenie pliku**  
W katalogu `resources` tworzymy plik o nazwie `config.properties`, którego zawartość może wyglądać tak:
```Java
browser=chrome
isHeadless=false
appUrl=https://demoqa.com
defaultWait=10
```

**Config.java - Klasa czytająca dane z pliku**  
W `java` dodajemy katalog `configuration`, a w nim tworzymy klasę `Config.java`.  
Deklarujemy w nim obiekt klasy `Properties`:
```Java
private static Properties properties;
```
Następnie piszemy mechanizm, który zapewni, że plik z config.properties będzie wczytany tylko raz i później re-używany
do wszystkich metod, które pobierają informacje z tego pliku konfiguracyjnego:
```Java
static {
    properties = new Properties();
    try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("tools_qa/config.properties")) {
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new RuntimeException("Configuration file 'config.properties' not found");
        }
    } catch (IOException e) {
        throw new RuntimeException("Error loading configuration file", e);
    }
}
```
Następnie metody pobierające konkretne dane z pliku konfiguracyjnego:
```Java
public static Browser getBrowser() {
    return Browser.valueOf(properties.getProperty("browser").trim().toUpperCase());
}

public static String getAppUrl() {
    return properties.getProperty("appUrl");
}

public static boolean isHeadless() {
    return Boolean.parseBoolean(properties.getProperty("isHeadless"));
}

public static int getDefaultWait() {
    return Integer.parseInt(properties.getProperty("defaultWait"));
}
```

**Przykład użycia danych**  
```Java
public class TestBase {

    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver(Config.getBrowser());
        
------------
ANOTHER FILE
------------

public class UrlProvider {
    private static String baseUrl = Config.getAppUrl();

------------
ANOTHER FILE
------------

public class DriverProvider {

    public static WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");

                if (Config.isHeadless()) {
                    options.addArguments("--headless");
                }

------------
ANOTHER FILE
------------

public abstract class BasePage {

    private void initDriver(WebDriver driver) {
        defaultWait = new WebDriverWait(driver, Duration.ofSeconds(Config.getDefaultWait()));
```

## Enum <a name="enum"></a>

**Enum** w Javie to specjalny typ danych, który pozwala na definiowanie zbioru stałych wartości (enumeracji). Każda
z tych stałych jest unikalną instancją typu wyliczeniowego. Enumy są szczególnie przydatne, gdy chcemy ograniczyć
możliwe wartości dla zmiennej do skończonego zbioru.

### Charakterystyka enumów

1. **Zdefiniowany zbiór wartości:** Enumy definiują zamknięty zbiór wartości, co pozwala na ograniczenie zakresu
możliwych wartości, jakie może przyjąć zmienna.
2. **Typ bezpieczny:** Enumy są typami bezpiecznymi w czasie kompilacji. Oznacza to, że kompilator sprawdza, czy
zmienne są przypisane do jednej z wartości enumu.
3. **Możliwość dodawania metod:** Enumy w Javie mogą zawierać metody, co umożliwia dodawanie zachowań specyficznych
dla poszczególnych wartości enumu.
4. **Możliwość implementacji interfejsów:** Enumy mogą implementować interfejsy, co pozwala na ich integrację
w szerszych strukturach kodu.

### Definiowanie i używanie enumów

Oto przykład definicji enumu w Javie:
```Java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

### Użycie enumu

```Java
public class Main {
    public static void main(String[] args) {
        Day today = Day.MONDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Today is Monday.");
                break;
            case TUESDAY:
                System.out.println("Today is Tuesday.");
                break;
            // Dodaj pozostałe dni tygodnia
            default:
                System.out.println("Today is another day.");
                break;
        }
    }
}
```

### Enumy z polami i metodami

Enumy mogą mieć własne pola, konstruktory i metody. Oto bardziej zaawansowany przykład:
```Java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private final double mass;   // w kilogramach
    private final double radius; // w metrach

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    // Uniwersalna stała grawitacyjna w m^3 / kg s^2
    public static final double G = 6.67300E-11;

    // Powierzchniowa grawitacja dla planety
    public double surfaceGravity() {
        return G * mass / (radius * radius);
    }

    // Waga na planecie
    public double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }

    public static void main(String[] args) {
        double earthWeight = 175;
        double mass = earthWeight / EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Your weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
    }
}
```

W powyższym przykładzie enum `Planet` zawiera pola `mass` i `radius`, które są inicjalizowane w konstruktorze. Posiada
również metody do obliczania powierzchniowej grawitacji i wagi na poszczególnych planetach.

---

## ENV — Zmienne środowiskowe <a name="env"></a>

Do ustawiania i zarządzania zmiennymi środowiskowymi możemy użyć biblioteki `dotenv-java`.

**Nazwa:**  
`Dotenv Java`

**Link do GitHub (dokumentacja):**  
https://github.com/cdimascio/dotenv-java

**Link do Maven:**  
https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java

1. Dodajemy ją w Maven (oczywiście aktualną wersję, poniżej tylko przykład):
    ```maven
    <!-- https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java -->
    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>dotenv-java</artifactId>
        <version>3.0.2</version>
    </dependency>
    ```
2. Tworzymy plik `.env` w głównym katalogu projektu lub gdzie chcemy np.:
    ```
    USERNAME=yourUsername
    PASSWORD=yourPassword
    ```
3. Wczytujemy zmienne środowiskowe z pliku `.env`:
    ```java
    import io.github.cdimascio.dotenv.Dotenv;
    
    public class EnvExample {
        public static void main(String[] args) {
            Dotenv dotenv = Dotenv.load();
            String username = dotenv.get("USERNAME");
            String password = dotenv.get("PASSWORD");
    
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
    ```
