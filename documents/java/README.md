# ☕Java - notatki

## 📑Spis

1. [Builder](#1)
2. [Plik konfiguracyjny - config.properties](#2)
3. TODO: JavaFaker
   https://www.baeldung.com/java-faker

## 📄Opis

### 1. Builder <a name="1"></a>

**Linki:** (więcej szukać pod hasłem `java builder`)  
https://devcave.pl/effective-java/wzorzec-projektowy-builder

Wzorzec projektowy Builder w Javie to konstrukcyjny wzorzec projektowy, który pozwala na tworzenie skomplikowanych
obiektów krok po kroku. Używany jest do oddzielenia procesu tworzenia obiektu od jego reprezentacji, co umożliwia
tworzenie różnych reprezentacji tego samego obiektu. Wzorzec ten jest szczególnie przydatny, gdy obiekty mają wiele
parametrów konfiguracyjnych lub gdy proces tworzenia obiektu jest złożony.

1. Tworzymy w katalogu `main->java` package o nazwie `models`
2. W katalogu `models` tworzymy klasę np. `User`, którą będziemy chcieli budować
3. Deklarujemy w niej:
   - Zmienne
   - Konstruktor
   - Gettery
   - Klasę `UserBuilder`:
     - Zmienne
     - Konstruktor dla każdej zmiennej
     - Metodę `build()`
4. W katalogu `main->java->providers` tworzymy klasę `UserProvider`, która będzie budować obiekt na podstawie naszego modelu
5. W niej przy pomocy `JavaFaker` możemy budować nasz obiekt
   - Można też coś utworzyć na sztywno
   - Można też tworzyć coś pobierając dane z bazy danych
6. W klasie `Page` pod którą robimy dany builder tworzymy metody uzupełniające pola
7. Następnie tworzymy metodę, która ma wypełnić cały formularz używając stworzonych metod wraz z naszym modelem
    ```
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
    ```
8. W teście tworzymy obiekt z metody, która generuje dla niego dane za pomocą Fakera i używamy jako argument
   ```
   TableRow addedTableRow = TableRowProvider.getRandomTableRow();
   webTablesPage.fillRowForm(editedTableRow);
   ```

Przykładowy kod jest w linku lub zastosowany tutaj:
- `java` -> `tools_qa` -> `models` -> `TableRow`
- `java` -> `tools_qa` -> `providers` -> `TableRowProvider`
- `java` -> `tools_qa` -> `pages` -> `normal` -> `elements_pages` -> `WebTablesPage`
- `test` -> `java` -> `tools_qa` -> `elements_tests` -> `WebTablesTest`

---

### 2. Plik konfiguracyjny - config.properties <a name="2"></a>

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
```
browser=chrome
isHeadless=false
appUrl=https://demoqa.com
defaultWait=10
```

**Config.java - Klasa czytająca dane z pliku**  
W `java` dodajemy katalog `configuration`, a w nim tworzymy klasę `Config.java`.  
Deklarujemy w nim obiekt klasy `Properties`:
```
private static Properties properties;
```
Następnie piszemy mechanizm, który zapewni, że plik z config.properties będzie wczytany tylko raz i później re-używany
do wszystkich metod, które pobierają informacje z tego pliku konfiguracyjnego:
```
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
```
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
```
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