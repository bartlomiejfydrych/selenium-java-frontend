# ☕Java — notatki

## 📑Spis

- [Builder](#builder)
- [Plik konfiguracyjny — config.properties](#config)
- [Enum](#enum)
- [ENV — Zmienne środowiskowe](#env)
- [Pliki — ścieżki](#files_paths)
- [Generics — typy generyczne](#generics)
- [Allure Report — konfiguracja](#allure_report_configuration)
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
    import tools_qa.models_providers.elements_models.web_tables.TableRow;
    
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
    try (InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("tools_qa/configs/config.properties")) {
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
2. Musimy zdecydować gdzie będziemy chcieli umieścić plik `.env`:
   - Główny katalog z projektem:
     - Projekt używa wielu narzędzi, które domyślnie szukają .env w katalogu głównym (np. docker-compose, narzędzia CI/CD).
     - Chcesz wyraźnie oddzielić pliki środowiskowe od kodu aplikacji.
     - W zespole są deweloperzy korzystający z różnych języków, gdzie trzymanie .env w katalogu głównym jest standardem.
   - Katalog `/resources`:
     - Twój projekt jest ściśle związany z Javą i korzysta z ekosystemu JVM (np. Spring Boot).
     - Chcesz, aby pliki środowiskowe były automatycznie dostępne w classpath.
     - Potrzebujesz bardziej uporządkowanej struktury w projekcie.
   - Ważne uwagi:
     - Jeśli stworzymy sam plik `.env` w głównym katalogu z projektem lub w katalogu `src/main/resources`, to wtedy
       w deklaracji obiektu wystarczy samo:  
       `Dotenv dotenv = Dotenv.load();`
     - Natomiast jeśli utworzymy go gdzieś indziej lub umieścimy w jakimś pod-katalogu, to wtedy będzie konieczne podanie
       ścieżki do tego pliku w deklaracji obiektu:  
       `Dotenv dotenv = Dotenv.configure().directory("./environment").load();`
3. Przed dodaniem pliku musimy nasz `.env` dopisać w `.gitignore`:
   ```gitignore
   # Project environment
   environment/.env
   ```
4. Jeśli na zmienne środowiskowe stworzyliśmy osobny katalog warto dodać w nim plik `.env.example`.  
   Możemy do niego zapisywać puste zmienne środowiskowe, aby reszta członków zespołu miała do pobrania jakiś wzornik.
5. Tworzymy plik `.env` w głównym katalogu projektu lub gdzie chcemy np.:
    ```.env
    USERNAME=yourUsername
    PASSWORD=yourPassword
    ```
6. Wczytujemy zmienne środowiskowe z pliku `.env`:
    ```java
    import io.github.cdimascio.dotenv.Dotenv;
    
    public class EnvExample {
        public static void main(String[] args) {
            Dotenv dotenv = Dotenv.load();
            // lub
            Dotenv dotenv = Dotenv.configure().directory("./environment").load();
            String username = dotenv.get("USERNAME");
            String password = dotenv.get("PASSWORD");
    
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
    ```

---

## Pliki — ścieżki <a name="files_paths"></a>

Przy deklaracji ścieżek do plików **nie należy** ich podawać/zapisywać bezpośrednio z ukośnikami np.:  
`String path = "C:/KatalogA/KatalogB/KatalogC/plik.txt"`

**Dlaczego?**  
Różne systemy używają różnych ukośników, raz jest tak `/`, a raz tak `\`.  
Przez to jest szansa, że nasz kod nie zadziała na innym systemie operacyjnym.

**Rozwiązaniem** tego problemu będzie:  
Korzystanie pod to z dedykowanych metod, które będą dostosowywały ukośniki do systemu, na którym kod będzie uruchamiany.  
W Java służy do tego metoda:  
`Paths.get()`

**Przykłady** zastosowania w różnych miejscach kodu:
```java
// --------------------------------------------------
public static String getDownloadFilePath() {
    return Paths.get(properties.getProperty("downloadFilePath")).toAbsolutePath().toString();
}
// --------------------------------------------------
prefs.put("download.default_directory", Paths.get(downloadFilePath).toAbsolutePath().toString());
// --------------------------------------------------
Path filePath = Paths.get(downloadDir, expectedFileName);
// --------------------------------------------------
public void uploadFile() {
    Path fileToUploadPath = Paths.get("src/main/resources/tools_qa/UploadAndDownload/UploadAndDownloadTest_UploadFile.png").toAbsolutePath();
    File fileToUpload = fileToUploadPath.toFile();
    selectFileButton.sendKeys(fileToUpload.getAbsolutePath());
}
// --------------------------------------------------
String generalDownloadPath = Config.getDownloadFilePath();
String downloadDir = "UploadAndDownload";
String downloadPath = Paths.get(generalDownloadPath, downloadDir).toString();
// --------------------------------------------------
private static final String GENERAL_FILES_PATH = Config.getDownloadFilePath();
private static final String COOKIES_DIR = "Auth";
private static final String COOKIES_FILE_PATH = Paths.get(GENERAL_FILES_PATH, COOKIES_DIR, "cookies.txt").toString();
// --------------------------------------------------
```

**Dodatkowo:**  
Każdy użytkownik będzie miał ten projekt w innych/różnych miejscach systemu.
Dlatego w pliku konfiguracyjnym `config.properties` nie podajemy pełnej ścieżki absolutnej.  
Podajemy tylko ścieżkę względną:
```config
mainResourcesPath=src\\main\\resources\\tools_qa
testResourcesPath=src\\test\\resources\\tools_qa
```

Żeby "dokleić" początek tej ścieżki, czyli w moim przypadku:  
`E:\\Nauka\\Projekty\\selenium-java-frontend`

Należy użyć `System.getProperty("user.dir")`.

**Przykład:**
```java
// Helper method to resolve path based on user directory
private static String getResolvedPath(String key, String defaultPath) {
    return Paths.get(System.getProperty("user.dir"), getProperty(key, defaultPath)).toAbsolutePath().toString();
}
```

---

## Generics — typy generyczne <a name="generics"></a>

**Link:**  
https://www.youtube.com/watch?v=K1iu1kXkVoA

Zapisuję to tutaj jako ciekawostkę z kursu, jeżeli miałoby się to kiedyś przydać.  

**Typy generyczne \<T\>** - Jest to metoda generyczna, która przyjmuję listę dowolnych obiektów i zwraca jeden z nich.

### Przykładowy kod 1 - prosty

```java
public <T> T getRandomElement(List<T> list) {
    return list.get(new Random().nextInt(list.size()));
}
```

### Przykładowy kod 2 - rozbudowany z wyjaśnieniem

#### 1. **Co oznacza `Class<?> pageClass`?**

**Class\<?\>** jest to typ generyczny reprezentujący dowolną klasę w Javie.  
Składnik `<?>` oznacza **"dowolny typ"** (ang. "wildcard type"), w kontekście metody, np.:

```java
private void navigateToPage(WebElement button, Class<?> pageClass) {
    waitForElementToBeClickable(button);
    button.click();
}
```

- **`Class<?>`**: Oznacza, że argument `pageClass` może być dowolną klasą (np. `BookStoreApplicationPage.class`,
  `ElementsPage.class`, itp.).
- **Dlaczego wildcard?** Używamy `<?>`, ponieważ metoda jest ogólna i nie ogranicza się do konkretnego typu klasy.
- Klasa `Class` w Javie jest częścią refleksji, co oznacza, że możemy używać jej do przechowywania metadanych o klasach
  w czasie działania programu.

#### 2. **Co oznacza `BookStoreApplicationPage.class`?**

`BookStoreApplicationPage.class` to odniesienie do **obiektu reprezentującego klasę** `BookStoreApplicationPage`.
W Javie każda klasa ma skojarzony obiekt typu `Class`, który przechowuje informacje o tej klasie.

Przykład:
- `BookStoreApplicationPage.class` pozwala na dostęp do informacji o klasie `BookStoreApplicationPage` w czasie
  działania programu (np. jej nazwa, metody, pola itp.).
- Jest to część mechanizmu refleksji, ale w naszym przypadku najczęściej jest używane do przekazania klasy jako
  argumentu (dla celów informacyjnych lub instancjacji).

#### **Dlaczego jest to używane w tym kontekście?**

W metodzie `navigateToPage`:

```java
private void navigateToPage(WebElement button, Class<?> pageClass) {
    waitForElementToBeClickable(button);
    button.click();
}
```

Argument `Class<?> pageClass` nie jest obecnie wykorzystywany wewnątrz metody. Jest to konstrukcja pozwalająca na
przekazanie dodatkowej informacji (np. typu strony, do której nawigujemy), co mogłoby być użyte w bardziej
zaawansowanych implementacjach.

Przykładowe potencjalne użycie:

```java
private void navigateToPage(WebElement button, Class<?> pageClass) {
    waitForElementToBeClickable(button);
    button.click();
    System.out.println("Navigated to: " + pageClass.getSimpleName());
}
```

- Tutaj `pageClass.getSimpleName()` zwraca nazwę klasy (np. `"BookStoreApplicationPage"`).

#### **Porównanie `Class` z instancją klasy:**
Jeśli mamy:

```java
BookStoreApplicationPage page = new BookStoreApplicationPage(driver);
```

To:
1. `page` – jest instancją klasy (obiektem).
2. `BookStoreApplicationPage.class` – jest obiektem typu `Class` reprezentującym klasę `BookStoreApplicationPage`.

#### **Podsumowanie:**

- **`Class<?>`**: To generyczna klasa reprezentująca dowolną klasę w Javie.
- **`BookStoreApplicationPage.class`**: Reprezentuje klasę `BookStoreApplicationPage` i jest częścią mechanizmu refleksji.
- W kontekście metody `navigateToPage` przekazywanie `Class<?> pageClass` może być pomocne do identyfikacji klasy
  strony, do której się przenosimy, nawet jeśli w tej chwili jest to tylko nadmiarowe.

---

## Allure Report — konfiguracja <a name="allure_report_configuration"></a>

**Link do dokumentacji:**  
https://allurereport.org/docs/

1. Dodajemy **Allure Report** dependencies do Maven:
   - W Maven Repository wyszukujemy `Allure JUnit 5`
   - Dodajemy dependencies najnowszej wersji do naszego `pom.xml`
   ```java
   <!-- https://mvnrepository.com/artifact/io.qameta.allure/allure-junit5 -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-junit5</artifactId>
        <version>2.29.1</version>
        <scope>test</scope>
    </dependency>
   ```
   - W `pom.xml` klikamy ikonę załadowania dependencies ponownie
2. Dodajemy do zmiennych środowiskowych zmienną o nazwie `JAVA_HOME`:
   - Zmienna środowiskowa `JAVA_HOME` musi posiadać ścieżkę do miejsca, w którym jest zainstalowane nasze SDK/JDK/JRE
   - Żeby zdobyć ścieżkę do naszego SDK/JDK to:
     - Klikamy "hamburger menu"
     - Rozwijamy `File`
     - Klikamy `Project Structure...`
     - Mamy mieć otwartą zakładkę `Project`
     - Klikamy przycisk `Edit` przy naszym SDK
     - Kopiujemy ścieżkę z `JDK home path:`  
       `C:\Users\Bartek\.jdks\corretto-21.0.5`
   - Ustawiany zmienną środowiskową `JAVA_HOME` (Windows 10):
     - Otwieramy `Ten komputer`
     - Prawym -> `Właściwości`
     - W kolumnie po lewej `Zaawansowane ustawienia systemu`
     - Mając otwartą zakładkę `Zaawansowane` klikamy przycisk`Zmienne środowiskowe...`
     - W zmiennych systemowych i zmiennych dla użytkownika klikamy przycisk `Nowa...`
     - Nazwa zmiennej: `JAVA_HOME`
     - Wartość zmiennej: Wklejamy skopiowaną ścieżkę `C:\Users\Bartek\.jdks\corretto-21.0.5`
     - OK -> OK -> OK
3. Pobieramy **Allure Report** dla systemu Windows:  
   (dzięki temu będą rozpoznawane jego polecenia w konsoli)
   - Wchodzimy tutaj:  
     https://allurereport.org/docs/install-for-windows/#install-from-an-archive
   - Wchodzimy na link do GitHub dla najnowszej wersji:  
     https://github.com/allure-framework/allure2/releases/tag/2.32.0
   - Pobieramy plik `allure-2.32.0.zip`
   - Zapisałem i rozpakowałem go gdzieś niedaleko projektu:  
     `E:\Nauka\allure_java`
   - Kopiujemy lub zapisujemy sobie gdzieś ścieżkę do katalogu `bin`:  
     `E:\Nauka\allure_java\allure-2.32.0\bin`
4. Dodajemy ścieżkę katalogu `bin` do `Path` w zmiennych środowiskowych systemu (Windows 10):
    - Otwieramy `Ten komputer`
    - Prawym -> `Właściwości`
    - W kolumnie po lewej `Zaawansowane ustawienia systemu`
    - Mając otwartą zakładkę `Zaawansowane` klikamy przycisk`Zmienne środowiskowe...`
    - W zmiennych systemowych i zmiennych dla użytkownika zaznaczamy zmienną `Path`
    - Klikamy `Edytuj...`
    - Klikamy `Nowy`
    - Wklejamy naszą skopiowaną ścieżkę do katalogu bin:  
      `E:\Nauka\allure_java\allure-2.32.0\bin`
    - OK -> OK -> OK
5. Tworzymy plik konfiguracyjny, w którym wskażemy lokalizację miejsca, do którego będą generowane pliki raportowe:
   - Link pomocniczy: https://allurereport.org/docs/junit5/
   - W katalogu **test** tworzymy katalog `resources`
   - W katalogu **resources** tworzymy plik `allure.properties`
   - W pliku tym umieszczamy taką linijkę:
     `allure.results.directory=output/allure_results`
   - **Musimy pamiętać, aby po każdych testach czyścić zawartość tego katalogu (usuwać go)**
6. Jeżeli ustawiliśmy inny katalog niż `target` to musimy nasz katalog **dodać do .gitignore**:  
   (Jeżeli chcemy zachować pusty katalog w repo to dodajemy do niego pliczek `.gitkeep`)
   ```.gitignore
   # output
    output/*
    !output/.gitkeep
   ```
7. Wywołujemy otwarcie raportu za pomocą konsoli:
   - Uruchamiamy jakieś nasze testy
   - W katalogu `output/allure_results` pojawiają się pliki raportowe
   - W IDE otwieramy terminal
   - Wpisujemy polecenie `allure serve output/allure_results`
8. (Opcjonalne) Tworzymy **funkcję czyszczącą** generowane pliki z Allure:  
   Chciałem, by przed **WSZYSTKIMI** testami katalog z plikami Allure był zawsze czyszczony.  
   Niestety, JUnit nie ma takiej możliwości, a adnotacja `@BeforeAll` dotyczy tylko "przed każdą klasą".  
   Poniżej jest jakieś rozwiązanie, ale uznałem je za zbyt przekombinowane:  
   https://stackoverflow.com/questions/43282798/in-junit-5-how-to-run-code-before-all-tests
     - Do pliku `config.properties`, który znajduje się w `src/main/resources/tools_qa/configs/config.properties`
       dodajemy nową zmienną:
       ```config.properties
       clearAllureReportFiles=true
       ```
     - W pliku `TestBase.java` tworzymy metodę czyszczącą:
       ```java
       // -------
       // HELPERS
       // -------

       // Allure report files are generated every time the tests are run. This method will clean them up regularly.
       private static void cleanAllureResultsDirectory() {
           Path allureResultsPath = Paths.get("output", "allure_results");
           try {
               if (Files.exists(allureResultsPath)) {
                   try (Stream<Path> paths = Files.walk(allureResultsPath)) {
                       paths.sorted((path1, path2) -> path2.compareTo(path1)) // First internal files, then directories.
                               .forEach(path -> {
                                   try {
                                       Files.delete(path);
                                   } catch (IOException e) {
                                       System.err.println("Error deleting file: " + path);
                                   }
                               });
                   }
               }
           } catch (IOException e) {
               System.err.println("Error cleaning allure_results directory: " + e.getMessage());
           }
       }
       ```
     - Dodajemy adnotację `@BeforeAll` w której będzie ona wywoływana w zależności od ustawienia w konfiguracji: 
       ```java
       @BeforeAll
           public static void setUpAll() {
               /*
               NOTE:
               Since I don't use the Allure report for further learning, I added deleting its files so that it doesn't fill up my disk.
               Set 'clearAllureReportFiles=true' in [config.properties] if you need to use the Allure report.
               */
               if (Config.getClearAllureReportFiles()) {
                   cleanAllureResultsDirectory();
               }
           }
       ```
     - Dodajemy adnotację `@AfterAll` logi, które będą nam przypominać o pilnowaniu tego:
       ```java
       @AfterAll
       public static void cleanUpAll() {
           System.out.println("Remember to check and delete the directory: [project/output/allure_results] before running the tests again." +
                    "(If in [config.properties] is set 'clearAllureReportFiles=false').");
           System.out.println("If you want to fully use 'Allure Report' remember to set 'clearAllureReportFiles=true' in [config.properties].");
       }
       ```
9. Instalujemy plugin pozwalający na generowanie raportu bezpośrednio z IDE:
   - Klikamy "hamburger menu"
   - Rozwijamy `File`
   - Klikamy `Settings...`
   - Zaznaczamy `Plugins` po lewej
   - Mamy otwartą zakładkę `Marketplace`
   - Wyszukujemy `Allure`
   - Wybieramy i instalujemy `Allure Report`
   - Apply -> Restart IDE -> OK
10. Dzięki temu pluginowi możemy klikać prawym na katalog `allure_results` i generować raport z menu IDE
11. Do konfiguracji raportów Allure z serwerem można używać wtyczki:  
    `Allure TestOps Support`
