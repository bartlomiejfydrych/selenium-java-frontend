# 📑Spis treści

1. [🔧Konfiguracja](#configuration)
   - [Tworzenie nowego projektu](#create_new_project)
   - [Instalacja pluginów](#plugin_installation)
   - [Dodawanie projektu do GitHub](#adding_project_to_github)
   - [Dodawanie dependencies do Maven](#adding_dependencies_to_maven)
   - [Dalsze kroki — rozpoczęcie pisania testów](#next_steps_writing_tests)
2. [🧩Dodatkowe](#additional)
   - [Typo — poprawienie błędów w tekście dla plików (głównie Markdown) pisanych w języku polskim](#typo_pl)
   - [Maven dependencies — ustawianie zmiennych dla numerów wersji](#maven_dependencies_variables)
3. [🔌Pluginy do IDE — opis](#plugins_description)
   - [.ignore](#ignore)
   - [Rainbow Brackets](#rainbow_brackets)
   - [Key Promoter X](#key_promoter_x)
   - [Lombok](#lombok)
   - [Allure Report](#allure_report_plugin)
4. [📚Dependencies — opis](#dependencies_description)
   - [⭐Uniwersalne](#universal)
     - [JUnit Jupiter (Aggregator)](#junit_jupiter_aggregator)
     - [JUnit Platform Suite (Aggregator)](#junit_platform_suite_aggregator)
     - [AssertJ Core](#assertj_core)
     - [Java Faker](#java_faker)
     - [Dotenv Java](#dotenv_java)
     - [Allure Report](#allure_report_dependency)
   - [🎨Frontend](#frontend)
     - [Selenium Java](#selenium_java)
     - [Selenium Support](#selenium_support)
     - [WebDriverManager](#web_driver_manager)
   - [🌐Backend](#backend)
     - [REST Assured](#rest_assured)
     - [JSON Schema Validator](#json_schema_validator)
     - [Project Lombok](#project_lombok)
     - [Jackson Databind](#jackson_databind)
     - [Jakarta JSON Processing API](#jakarta_json_processing_api)

---

# 🔧Konfiguracja <a name="configuration"></a>

## Tworzenie nowego projektu <a name="create_new_project"></a>

1. Instalujemy `IntelliJ IDEA`
    - `JDK` — Jest już wbudowane w IDE. Nie trzeba go pobierać osobno tak jak kiedyś
    - `Zmienne środowiskowe` — nimi również nie musimy się przejmować tak jak kiedyś
2. Klikamy **utworzenie nowego projektu**
    - Jeżeli już jesteśmy w jakimś projekcie to:
        - Klikamy na `Hamburger Menu` w lewym, górnym rogu
        - Klikamy `New`
        - Klikamy `Project`
3. Podajemy **nazwę projektu**
    - Dla projektów Git najlepiej stosować format `nazwa-mojego-projektu`
4. Wybieramy **lokalizację** projektu
5. Pomijamy `Create new Git repository`, ponieważ lepiej to zrobić jak będziemy mieć już skonfigurowany plik `.gitignore`
6. Wybieramy `język: Java`
7. Wybieramy `Build system: Maven`
    - Maven jest fajny do zarządzania frameworkami
8. Wybieramy `JDK`
    - Jeżeli nie ma na liście, to pobieramy  
      Może być dowolne np. z Amazona.  
      W tym projekcie użyłem `Amazon Corretto 21.0.6`.  
      Z Oracle może być ten problem, że mają inne prawa autorskie oraz są powiązane z Chinami (podobno).
    - `JDK` warto wybierać jak najnowsze (ale też nie takie, które dopiero co wyszło) oraz wybierać wersję
      z długotrwałym wsparciem, czyli oznaczone jako **(LTS) Long Term Support**
9. Można zaznaczyć `Add sample code`
    - Żeby lepiej się orientować w katalogach. Potem się go usunie
10. Kasujemy plik `.gitignore`
    - Stworzymy za chwilę własny za pomocą pluginu `.ignore`
    - Możemy też zostawić i wkleić do niego gotowy szablon z internetu

## Instalacja pluginów <a name="plugin_installation"></a>

11. Instalujemy **pluginy**:
    - Klikamy `Hamburger Menu`
    - Klikamy `Settings`
    - Wybieramy z menu po lewej `Plugins`
    - W zakładce `Marketplace` wyszukujemy pluginy, które nas interesują
    - Klikamy `Install` przy wybranym pluginie
    - W zakładce `Installed` mamy listę pluginów, które są już zainstalowane
    - Wyszukujemy i instalujemy następujące **pluginy**:
      - .ignore
      - Rainbow Brackets
      - Key Promoter X
      - Lombok
      - Allure Report

## Dodawanie projektu do GitHub <a name="adding_project_to_github"></a>

12. Generujemy plik `.gitignore` za pomocą pluginu `.ignore`
    - Klikamy `prawym na katalog z projektem`
    - Klikamy `New`
    - Klikamy `.ignore File`
    - Klikamy `.gitignore File (Git)`
    - Na liście wyszukujemy i zaznaczamy następujące templatki:
        - `JetBrains / IntelliJ`
        - `Java`
        - `Maven`
    - Klikamy `Generate`
13. Wrzucamy projekt na `GitHub`
    - Klikamy `Hamburger Menu`
    - Klikamy `VCS`
    - Klikamy `Share Project on GitHub`
    - Podajemy `nazwę` repozytorium
    - Zaznaczamy/Odznaczamy `Private`
    - Możemy dodać `opis`, ale jeżeli mamy już plik `README` w projekcie to lepiej zostawić puste
    - Klikamy `Share`

## Dodawanie dependencies do Maven <a name="adding_dependencies_to_maven"></a>

14. Wpisujemy w google `maven repository` lub wchodzimy na stronę:  
    https://mvnrepository.com/
    - Wyszukujemy interesujący nas framework
    - Klikamy na niego
    - Klikamy w najbardziej aktualną i stabilną wersję
    - Kopiujemy `<dependencies>` z zakładki `Maven`
15. Otwieramy plik `pom.xml` i tam to wklejamy
    - Pod `<properties>` musimy dodać `<dependencies></dependencies>`
    - Pomiędzy `<dependencies>` wklejamy nasze `<dependency>` z repozytorium `Maven`
16. Wrzucamy następujące `<dependencies>`:
    - **Uniwersalne**
        - JUnit Jupiter (Aggregator)
        - JUnit Platform Suite (Aggregator)
        - Java Faker
        - AssertJ Core
        - Dotenv Java
        - Allure Report
        - Logback Classic (opcjonalne, żeby nie denerwowały nas warningi `SLF4J`, które może powodować `Allure Report`)
    - **Frontend**
        - Selenium Java
        - Selenium Support
        - WebDriverManager
    - **Backend**
        - REST Assured
        - JSON Schema Validator
        - Project Lombok (opcjonalne)
        - Jackson Databind (opcjonalne)
        - Jakarta JSON Processing API (opcjonalne)
17. Jeżeli chcemy, możemy w `<properties>` zdefiniować sobie zmienne dla numerów wersji naszych dependencies  
    (Instrukcja jak to zrobić jest w niższych sekcjach tego dokumentu)
18. Po wklejeniu naszych dependencies gdzieś w okolicach prawego, górnego rogu powinna pojawić się `ikona Mavena`.  
    Klikamy w nią.  
    Sprawi to, że `dependencies` zostaną **pobrane i zainstalowane** do naszego projektu.  
    Niektóre `dependencies` będą podkreślone z informacjami, że mają jakieś **luki w zabezpieczeniach**.  
    No ale **nic** się z tym za bardzo **nie zrobi**.
19. Warto się upewnić czy `dependencies` zostały dodane do projektu:
    - Klikamy na pasku po prawej na `ikonę Mavena (m)`
    - Rozwijamy katalog `Dependencies`
    - Patrzymy czy są wszystkie, które podaliśmy w `pom.xml`
20. Możemy **rozpocząć pisanie testów**

## Dalsze kroki — rozpoczęcie pisania testów <a name="next_steps_writing_tests"></a>

📌DOKOŃCZYĆ!  
Dalsze kroki opisujące jak rozpocząć pisanie testów znajdują się w:  
&emsp;📁text  
&emsp;&emsp;📁text  
Dalsze kroki w `README` katalogu `selenium-java`

---

# 🧩Dodatkowe <a name="additional"></a>

## ✔Typo — poprawienie błędów w tekście dla plików (głównie Markdown) pisanych w języku polskim <a name="typo_pl"></a>

1. Klikamy `Hamburger Menu` w lewym, górnym rogu
2. Klikamy `File`
3. Klikamy `Settings`
4. Rozwijamy `Editor`
5. Klikamy `Natural Languages`
6. Klikamy `+`
7. Szukamy na liście `Polski`
8. Klikamy `Apply`
9. Klikamy `OK`

## ⓂMaven dependencies — ustawianie zmiennych dla numerów wersji <a name="maven_dependencies_variables"></a>

1. W sekcji z `<properties>` dodajemy coś zgodnie z poniższym przykładem:
    ```Java
    <properties>
        <<u góry jakieś rzeczy od Mavena, które były już w pliku>>
        
        <selenium.version>4.16.1</selenium.version>
        <testng.version>7.9.0</testng.version>
        <assertJ.version>3.25.3</assertJ.version>
        <javafaker.version>1.0.2</javafaker.version>
    </properties>
    ```
2. `<selenium.version>` to nazwa naszej zmiennej.
3. Podstawiamy ją w naszym `dependency` w miejscu numeru wersji jako `${selenium.version}`:  
   Przed:
    ```Java
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.19.1</version>
    </dependency>
    ```
   Po:
    ```Java
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>${selenium.version}</version>
    </dependency>
    ```

---

# 🔌Pluginy do IDE — opis <a name="plugins_description"></a>

## .ignore <a name="ignore"></a>

### **.ignore – Wtyczka do zarządzania plikami ignorowanymi w projektach**

🔹 **`.ignore`** to wtyczka do popularnych środowisk IDE, takich jak **IntelliJ IDEA**, **PyCharm**, **WebStorm**,
czy **Android Studio**, ułatwiająca zarządzanie plikami ignorowanymi przez systemy kontroli wersji, np. **Git**.

### **📌 Kluczowe funkcje wtyczki `.ignore`**
✅ **Automatyczne generowanie plików `.gitignore`** – wspiera różne technologie i języki, oferując gotowe szablony.  
✅ **Podpowiedzi składni** – IntelliSense dla reguł ignorowania plików.  
✅ **Podświetlanie składni** – ułatwia edycję plików `.gitignore`, `.dockerignore`, `.npmignore` itd.  
✅ **Sugerowanie plików do ignorowania** – na podstawie struktury projektu.  
✅ **Szybkie dodawanie plików do `.gitignore`** – kliknij prawym przyciskiem na plik → "Add to .gitignore".  
✅ **Obsługa wielu systemów kontroli wersji** – Git, Mercurial, Bazaar, Darcs itp.

### **📦 Instalacja w IntelliJ IDEA**
1️⃣ Otwórz **File → Settings → Plugins** (lub `Ctrl + Alt + S`).  
2️⃣ Wyszukaj **“.ignore”** w zakładce Marketplace.  
3️⃣ Kliknij **Install** i zrestartuj IDE.

### **📁 Obsługiwane formaty plików**
- `.gitignore`
- `.dockerignore`
- `.npmignore`
- `.cvsignore`
- `.bzrignore`
- `.hgignore`
- `.tfignore`
- `.boringignore`

### **🎯 Dlaczego warto używać `.ignore`?**
🔹 Ułatwia zarządzanie ignorowanymi plikami.  
🔹 Redukuje błędy w konfiguracji `.gitignore`.  
🔹 Automatyzuje tworzenie reguł dla różnych technologii.  
🔹 Przyspiesza workflow w repozytorium Git.

## Rainbow Brackets <a name="rainbow_brackets"></a>

### **🌈 Rainbow Brackets – Wtyczka do podświetlania nawiasów w IDE**

**Rainbow Brackets** to wtyczka do **IntelliJ IDEA**, **PyCharm**, **WebStorm**, **Android Studio** i innych IDE
z rodziny **JetBrains**, która podświetla nawiasy w różnych kolorach, ułatwiając analizę kodu.

### **📌 Kluczowe funkcje wtyczki Rainbow Brackets**
✅ **Kolorowe podświetlanie nawiasów** – różne poziomy zagnieżdżenia otrzymują różne kolory.  
✅ **Obsługa wielu języków programowania** – działa m.in. w **Java, Python, JavaScript, Kotlin, HTML, XML, JSON** i wielu innych.  
✅ **Łatwa identyfikacja błędów** – pomaga znaleźć brakujące lub źle zamknięte nawiasy.  
✅ **Dostosowywanie kolorów** – użytkownik może zmieniać schemat kolorów według własnych preferencji.  
✅ **Wsparcie dla ciemnych i jasnych motywów**.  
✅ **Współpraca z innymi wtyczkami** – działa z **Material Theme UI, Atom Material Icons**, itp.

### **📦 Instalacja w IntelliJ IDEA**
1️⃣ **Otwórz:** `File → Settings → Plugins` (lub `Ctrl + Alt + S`).  
2️⃣ **Wyszukaj:** "Rainbow Brackets" w zakładce **Marketplace**.  
3️⃣ **Kliknij:** **Install**, a następnie **Restart IDE**.

### **🎨 Przykład działania i dostosowanie kolorów**

Przed instalacją:
```java
public void exampleMethod() {
    if (condition) {
        while (true) {
            doSomething();
        }
    }
}
```

Po instalacji **Rainbow Brackets**:
- `{ }`, `[ ]`, `( )` będą miały różne kolory, zależnie od poziomu zagnieżdżenia.

Możesz edytować kolory w **File → Settings → Editor → Color Scheme → Rainbow Brackets**.

### **🎯 Dlaczego warto używać Rainbow Brackets?**
🔹 Zwiększa **czytelność kodu** w dużych projektach.  
🔹 Pomaga znaleźć **brakujące lub nadmiarowe nawiasy**.  
🔹 Przyspiesza **debugowanie** i **analizę kodu**.  
🔹 Jest **prosta w użyciu** i nie wpływa na wydajność IDE.

## Key Promoter X <a name="key_promoter_x"></a>

### **⌨️ Key Promoter X – Wtyczka do nauki skrótów klawiszowych w IDE**

**Key Promoter X** to popularna wtyczka do **IntelliJ IDEA**, **PyCharm**, **WebStorm**, **Android Studio** i innych
IDE z rodziny **JetBrains**, która pomaga użytkownikom nauczyć się skrótów klawiszowych poprzez automatyczne podpowiedzi.

### **📌 Kluczowe funkcje wtyczki Key Promoter X**
✅ **Podpowiada skróty klawiszowe** – wyświetla powiadomienia, gdy użytkownik użyje myszy zamiast klawiatury.  
✅ **Pokazuje liczbę użyć myszy** – informuje, ile razy kliknąłeś daną opcję zamiast użyć skrótu.  
✅ **Lista najczęściej używanych operacji** – pomaga określić, które skróty warto zapamiętać w pierwszej kolejności.  
✅ **Automatycznie proponuje nowe skróty** – uczy bardziej efektywnego korzystania z IDE.  
✅ **Obsługa własnych skrótów** – integruje się z niestandardowymi skrótami zdefiniowanymi w IDE.

### **📦 Instalacja w IntelliJ IDEA**
1️⃣ **Otwórz:** `File → Settings → Plugins` (lub `Ctrl + Alt + S`).  
2️⃣ **Wyszukaj:** "Key Promoter X" w zakładce **Marketplace**.  
3️⃣ **Kliknij:** **Install**, a następnie **Restart IDE**.

### **🎯 Jak działa Key Promoter X?**
Jeśli klikniesz np. **"Refactor"** w menu zamiast użyć skrótu klawiszowego, pojawi się powiadomienie:

🔹 **"Refactor (Ctrl + Alt + Shift + T) – użyj skrótu zamiast myszy!"**

Im częściej ignorujesz skróty, tym bardziej wtyczka przypomina, aby z nich korzystać. 😃

### **🎓 Dlaczego warto używać Key Promoter X?**
🚀 **Przyspiesza pracę w IDE** – dzięki skrótom działasz znacznie szybciej.  
📈 **Zwiększa produktywność** – mniej klikania, więcej kodowania.  
🧠 **Uczy efektywnej pracy** – idealne narzędzie dla początkujących i zaawansowanych programistów.

Chcesz szybciej nauczyć się skrótów klawiszowych i pracować wydajniej? **Key Promoter X to must-have!** 🔥

## Lombok <a name="lombok"></a>

### **🍃 Lombok – Wtyczka do IntelliJ IDEA i JetBrains IDEs**

**Lombok** to **biblioteka** dla Javy, która **automatycznie generuje kod**, eliminując konieczność ręcznego pisania
**getterów, setterów, konstruktorów** i innych standardowych metod. Wtyczka **Lombok Plugin** w IntelliJ IDEA zapewnia
pełne wsparcie dla tej biblioteki, umożliwiając poprawne działanie adnotacji Lomboka w IDE.

### **📌 Kluczowe funkcje wtyczki Lombok**
✅ **Obsługa adnotacji Lomboka** w IntelliJ IDEA i innych JetBrains IDEs.  
✅ **Automatyczne generowanie kodu** w tle bez konieczności ręcznego pisania metod.  
✅ **Poprawne działanie funkcji "Go to Definition"** dla metod generowanych przez Lomboka.  
✅ **Rozwiązywanie błędów kompilacji związanych z Lombokiem**.

### **📦 Instalacja w IntelliJ IDEA**
1️⃣ **Otwórz:** `File → Settings → Plugins` (lub `Ctrl + Alt + S`).  
2️⃣ **Wyszukaj:** "Lombok Plugin" w zakładce **Marketplace**.  
3️⃣ **Kliknij:** **Install**, a następnie **Restart IDE**.  
4️⃣ **Upewnij się, że Lombok jest włączony:**
- Przejdź do `File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors`
- Zaznacz **"Enable annotation processing"**

### **🎯 Jak działa Lombok w IntelliJ IDEA?**
Po zainstalowaniu wtyczki możesz używać adnotacji **Lombok** w swoim kodzie, np.:

```java
import lombok.Data;

@Data // Automatycznie generuje gettery, settery, toString, equals i hashCode
public class User {
    private String name;
    private int age;
}
```

➡️ Bez Lomboka musiałbyś ręcznie pisać **gettery, settery i inne metody**!

### **💡 Najpopularniejsze adnotacje Lomboka**
🔹 `@Getter` i `@Setter` → Generują gettery i settery dla pól klasy.  
🔹 `@Data` → Generuje **toString()**, **equals()**, **hashCode()**, gettery i settery.  
🔹 `@AllArgsConstructor` i `@NoArgsConstructor` → Tworzą konstruktory z wszystkimi lub żadnym parametrem.  
🔹 `@Builder` → Tworzy wzorzec **Builder** dla klasy.  
🔹 `@Slf4j` → Automatycznie dodaje logger **SLF4J**.

### **🎓 Dlaczego warto używać Lomboka?**
🚀 **Mniej boilerplate code** – nie musisz pisać setek linii zbędnego kodu.  
📈 **Lepsza czytelność** – kod staje się bardziej przejrzysty.  
⚡ **Szybsza praca** – nie musisz generować metod ręcznie.

Jeśli chcesz **przyspieszyć pracę i uprościć kod w Javie**, **Lombok Plugin** to **must-have**! 🔥

## Allure Report <a name="allure_report_plugin"></a>

### **📊 Allure Report – Wtyczka do IntelliJ IDEA**

**Allure Report** to **zaawansowane narzędzie do generowania raportów testowych**. Wtyczka **Allure Plugin** dla
IntelliJ IDEA integruje Allure z IDE, umożliwiając szybkie generowanie, przeglądanie i analizowanie raportów
bez wychodzenia z IntelliJ.

### **📌 Co robi wtyczka Allure Report?**
✅ **Integruje raporty Allure z IntelliJ IDEA** – pozwala otwierać i analizować wyniki testów bez wychodzenia z IDE.  
✅ **Dodaje nową zakładkę "Allure"**, w której można wizualizować raporty w graficznej formie.  
✅ **Automatycznie wykrywa katalog `allure-results`** i generuje raport jednym kliknięciem.  
✅ **Obsługuje TestNG, JUnit 4/5, Cucumber i inne frameworki** testowe.  
✅ **Pozwala przeglądać szczegóły testów** – błędy, logi, załączniki (np. screenshoty).

### **🔧 Jak zainstalować wtyczkę?**
1️⃣ Otwórz **IntelliJ IDEA** i przejdź do:
- `File → Settings → Plugins` (Windows/Linux)
- `IntelliJ IDEA → Preferences → Plugins` (Mac)  
  2️⃣ Wyszukaj: **"Allure Report"** w zakładce **Marketplace**.  
  3️⃣ Kliknij **Install**, a potem **Restart IDE**.

### **📂 Jak używać wtyczki?**
1️⃣ **Uruchom testy**, które zapisują wyniki do `allure-results`.  
2️⃣ W **dolnym panelu IntelliJ** przejdź do zakładki **"Allure"**.  
3️⃣ Kliknij **"Generate Report"**, aby zobaczyć wyniki w IDE.  
4️⃣ Możesz nawigować po testach, sprawdzać błędy i załączniki.

### **📢 Zalety wtyczki Allure Report w IntelliJ IDEA**
🚀 **Nie trzeba otwierać raportów w przeglądarce** – wszystko działa w IDE.  
🔍 **Szybki podgląd wyników testów** bez dodatkowych poleceń w terminalu.  
📊 **Wizualizacja błędów, logów i statystyk** testów.  
🛠️ **Łatwa integracja z popularnymi frameworkami** testowymi.

Jeśli pracujesz z Allure, ta wtyczka **znacznie ułatwia życie**! 🔥

---

# 📚Dependencies — opis <a name="dependencies_description"></a>

## ⭐Uniwersalne <a name="universal"></a>

### JUnit Jupiter (Aggregator) <a name="junit_jupiter_aggregator"></a>

`JUnit Jupiter (Aggregator)` to zależność dla **JUnit 5**, która zapewnia pełną funkcjonalność silnika testowego
**JUnit Jupiter**. Jest to **główna implementacja testów** w JUnit 5, zawierająca **adnotacje, asercje i mechanizmy
testowania**.

#### **📌 Co to jest JUnit Jupiter?**
JUnit 5 składa się z trzech głównych modułów:
1. **JUnit Platform** – uruchamia testy i integruje różne silniki testowe.
2. **JUnit Jupiter** – nowoczesna implementacja testów dla JUnit 5.
3. **JUnit Vintage** – wsparcie dla testów JUnit 3 i 4.

**JUnit Jupiter** jest **domyślnym silnikiem testowym** w JUnit 5 i dostarcza **adnotacje** oraz **API do pisania testów**.

#### **📦 Jak dodać zależność?**

**Dla Maven (pom.xml)**
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>
```

**Dla Gradle (build.gradle.kts)**
```kotlin
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}
```

#### **🛠️ Jak używać?**

**✅ Przykładowy test w JUnit 5 (Jupiter)**
```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Uruchamiane przed wszystkimi testami");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Uruchamiane przed każdym testem");
    }

    @Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result, "Dodawanie nie działa poprawnie!");
    }

    @Test
    void testBoolean() {
        assertTrue(10 > 5, "10 powinno być większe od 5");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Uruchamiane po każdym teście");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Uruchamiane po wszystkich testach");
    }
}
```

#### **📢 Kluczowe funkcje JUnit Jupiter**
✅ **Nowoczesna składnia i API** – pełne wsparcie dla **Lambda Expressions** i **Java 8+**  
✅ **Więcej adnotacji** – np. `@BeforeAll`, `@BeforeEach`, `@AfterEach`, `@AfterAll`  
✅ **Bogate API asercji** – `assertEquals()`, `assertTrue()`, `assertThrows()` itd.  
✅ **Dynamiczne testy** – `@TestFactory` do tworzenia testów w locie  
✅ **Tagowanie testów** – `@Tag("slow")`, `@Tag("fast")`

#### **🎯 Dlaczego warto używać JUnit Jupiter?**
`JUnit Jupiter` to **główna implementacja testów w JUnit 5**, która:  
🔹 Usprawnia pisanie testów dzięki nowoczesnemu API.  
🔹 Wspiera **dynamiczne testy** i **parametryzację**.  
🔹 Pozwala na **lepsze organizowanie testów** w projektach Java.

Jeśli chcesz korzystać z **JUnit 5**, to `JUnit Jupiter` jest absolutnie kluczowym dependency! 🚀

### JUnit Platform Suite (Aggregator) <a name="junit_platform_suite_aggregator"></a>

`JUnit Platform Suite (Aggregator)` to zależność używana do uruchamiania testów w **JUnit 5**, pozwalająca na
konfigurację i uruchamianie testów z różnych pakietów i klas w ramach jednej **suity testowej**.

#### **📌 Co to jest JUnit Platform Suite?**
JUnit 5 składa się z trzech głównych modułów:
1. **JUnit Platform** – uruchamia testy i integruje różne silniki testowe.
2. **JUnit Jupiter** – implementacja dla testów JUnit 5.
3. **JUnit Vintage** – wsparcie dla testów JUnit 3 i 4.

**JUnit Platform Suite** to mechanizm pozwalający na **grupowanie i uruchamianie testów** z różnych klas, pakietów
i frameworków w ramach jednej konfiguracji.

#### **📦 Jak dodać zależność?**

**Dla Maven (pom.xml)**
```xml
<dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-suite</artifactId>
    <version>1.10.0</version>
</dependency>
```

**Dla Gradle (build.gradle.kts)**
```kotlin
dependencies {
    testImplementation("org.junit.platform:junit-platform-suite:1.10.0")
}
```

#### **🛠️ Jak używać?**

Tworząc klasę testową, można użyć **JUnit 5 Platform Suite** do uruchomienia wielu testów jednocześnie.

**✅ Przykład użycia**
```java
import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("com.example.tests") // Wybiera wszystkie testy z pakietu
@IncludeTags("smoke") // Uruchamia tylko testy oznaczone jako "smoke"
public class TestSuite {
}
```
📌 **Co robi ten kod?**  
✔ **@Suite** – oznacza klasę jako zestaw testów.  
✔ **@SelectPackages("com.example.tests")** – uruchamia testy z określonego pakietu.  
✔ **@IncludeTags("smoke")** – filtruje testy po tagach.

#### **📢 Główne zalety JUnit Platform Suite**
✅ **Grupowanie testów** – można uruchamiać wiele testów na raz.  
✅ **Filtracja testów** – można wybierać testy po pakietach, klasach, tagach.  
✅ **Integracja z JUnit 5, TestNG i innymi frameworkami**.  
✅ **Łatwa konfiguracja w Maven/Gradle**.

Jeśli potrzebujesz **zbiorczego uruchamiania testów w JUnit 5**, to `JUnit Platform Suite` jest idealnym rozwiązaniem! 🚀

### AssertJ Core <a name="assertj_core"></a>

🔹 **AssertJ Core** to biblioteka do **asercji w testach jednostkowych**, która **rozszerza możliwości JUnit**.
Jest nowoczesną alternatywą dla wbudowanych asercji w **JUnit** i **Hamcrest**, oferując **bardziej czytelną, płynną
składnię (Fluent API)**.

#### **📦 Dodanie do projektu**

**Maven (pom.xml)**
```xml
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.24.2</version>
    <scope>test</scope>
</dependency>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    testImplementation("org.assertj:assertj-core:3.24.2")
}
```

#### **🛠️ Jak używać AssertJ?**

**✅ Przykładowe asercje**

```java
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class AssertJTest {

    @Test
    void testBasicAssertions() {
        int result = 5;

        // Klasyczne JUnit
        // assertEquals(5, result);

        // Lepsza wersja w AssertJ
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testStringAssertions() {
        String text = "Hello AssertJ";

        assertThat(text)
                .isNotEmpty()
                .startsWith("Hello")
                .endsWith("AssertJ")
                .contains("lo As");
    }

    @Test
    void testListAssertions() {
        var numbers = java.util.List.of(1, 2, 3, 4, 5);

        assertThat(numbers)
                .hasSize(5)
                .contains(3)
                .doesNotContain(10)
                .startsWith(1, 2)
                .endsWith(4, 5);
    }

    @Test
    void testExceptionAssertions() {
        assertThatThrownBy(() -> { throw new IllegalArgumentException("Błąd!"); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Błąd!");
    }
}
```

#### **📌 Kluczowe zalety AssertJ**
✅ **Czytelniejsza składnia** – `assertThat(value).isEqualTo(expected)` zamiast `assertEquals(expected, value)`.  
✅ **Fluent API** – możliwość łączenia wielu asercji w jednej linii.  
✅ **Zaawansowane asercje** – np. **sprawdzanie wyjątków, kolekcji, dat** itp.  
✅ **Wsparcie dla Java 8+** – m.in. **Stream API, Optional, Lambda Expressions**.

#### **🎯 Dlaczego warto używać AssertJ?**
🔹 **Lepsza czytelność kodu** – testy są bardziej zrozumiałe.  
🔹 **Większa elastyczność** – zaawansowane operacje na **Stringach, kolekcjach, wyjątkach**.  
🔹 **Lepsza obsługa błędów** – komunikaty błędów są bardziej szczegółowe niż w JUnit/Hamcrest.

👉 **AssertJ Core** to świetne rozszerzenie do **JUnit 5**! 🚀

### Java Faker <a name="java_faker"></a>
### Dotenv Java <a name="dotenv_java"></a>
### Allure Report <a name="allure_report_dependency"></a>

## 🎨Frontend <a name="frontend"></a>

### Selenium Java <a name="selenium_java"></a>
### Selenium Support <a name="selenium_support"></a>
### WebDriverManager <a name="web_driver_manager"></a>

## 🌐Backend <a name="backend"></a>

### REST Assured <a name="rest_assured"></a>
### JSON Schema Validator <a name="json_schema_validator"></a>
### Project Lombok <a name="project_lombok"></a>
### Jackson Databind <a name="jackson_databind"></a>
### Jakarta JSON Processing API <a name="jakarta_json_processing_api"></a>






















---

### Lista z opisem

#### Uniwersalne

<details>
    <summary>1. JUnit Jupiter (Aggregator)</summary>

> *Dependency o nazwie **"JUnit Jupiter (Aggregator)"** w kontekście projektów Java jest związana z platformą testową JUnit 5, która składa się z kilku modułów. **"JUnit Jupiter"** jest jednym z tych modułów, odpowiedzialnym za obsługę testów opartych na nowej składni, wprowadzonej w JUnit 5.  
> Aggregator dependency jest zestawem zależności, który agreguje lub grupuje różne moduły lub artefakty w jedną zależność. W przypadku JUnit Jupiter (Aggregator), jest to zależność, która zawiera wszystkie moduły JUnit 5, co pozwala na korzystanie z pełnej funkcjonalności JUnit 5 w projekcie za pomocą jednej zależności.  
> W skład "JUnit Jupiter (Aggregator)" wchodzą m.in.:  
> **JUnit Jupiter API:** Moduł zawierający interfejsy i adnotacje potrzebne do tworzenia testów w stylu JUnit 5.  
> **JUnit Jupiter Engine:** Silnik uruchamiający testy napisane z użyciem JUnit 5.  
> **JUnit Vintage Engine:** Silnik kompatybilny wstecznie, który pozwala na uruchamianie testów napisanych z użyciem JUnit 3 i JUnit 4.  
> Używanie **"JUnit Jupiter (Aggregator)"** jako zależności w projekcie Java pozwala na łatwe korzystanie z pełnej funkcjonalności JUnit 5 bez konieczności ręcznego dodawania pojedynczych modułów. Wystarczy dodać tę zależność do pliku konfiguracyjnego (np. pom.xml w Maven lub build.gradle w Gradle), a narzędzie budujące automatycznie pobiera i zarządza wszystkimi modułami JUnit 5.*
</details>
<details>
    <summary>2. JUnit Platform Suite (Aggregator)</summary>

> ***JUnit Platform Suite (Aggregator)** to moduł JUnit 5, który pozwala na definiowanie i uruchamianie grup testów przy użyciu adnotacji takich jak **@Suite, @SelectPackages, i @SelectClasses**. Jest częścią ekosystemu JUnit Platform i służy jako centralne narzędzie do agregowania testów w zestawy, co ułatwia organizację i kontrolę nad ich wykonywaniem.  
> Najważniejsze cechy JUnit Platform Suite:  
> **Agregowanie testów** - Pozwala na grupowanie testów z różnych pakietów lub klas w jeden zestaw testów.  
> **Adnotacje wspierane przez Suite API:**  
> `@Suite`: Definiuje klasę jako zestaw testów.  
> `@SelectPackages`: Wybiera wszystkie klasy testowe z określonych pakietów.  
> `@SelectClasses`: Wskazuje specyficzne klasy testowe do wykonania.  
> `@IncludeTags` i `@ExcludeTags`: Wybiera lub wyklucza testy na podstawie tagów.  
> `@IncludeEngines` i `@ExcludeEngines`: Pozwala selektywnie używać silników testowych.  
> **Obsługa różnych silników testowych**  
> JUnit Platform Suite działa z różnymi silnikami testowymi, takimi jak:  
> JUnit Jupiter (JUnit 5)  
> JUnit Vintage (JUnit 4)  
> Spock, TestNG, Cucumber, czy inne wspierające JUnit Platform.  
> **Elastyczna konfiguracja**  
> Pozwala na uruchamianie testów zarówno w oparciu o ich lokalizację w projekcie, jak i dodatkowe kryteria (np. tagi).  
> **Wsparcie dla filtrowania**  
> Możesz uruchamiać tylko te testy, które spełniają określone kryteria, np. zawierają tag "critical" lub "regression".  
> **Integracja z Mavenem i Gradle**  
> Bezproblemowe uruchamianie zestawów testów w popularnych narzędziach budujących.  
> **Wsparcie w IDE**  
> JUnit Platform Suite jest w pełni wspierany w IDE takich jak IntelliJ IDEA czy Eclipse, co ułatwia konfigurację i uruchamianie testów.*
</details>
<details>
    <summary>3. AssertJ Core</summary>

> *Dependency o nazwie **"AssertJ Core"** odnosi się do biblioteki AssertJ, która jest popularnym narzędziem do tworzenia testów asercyjnych w języku Java. AssertJ pozwala na pisanie czytelnych, ekspresyjnych i łatwych w utrzymaniu testów poprzez dostarczenie bogatego zestawu metod asercyjnych, które sprawdzają zachowanie kodu w sposób intuicyjny i precyzyjny.  
> Oto kilka głównych funkcji, za które odpowiada AssertJ Core:  
> **Metody asercyjne:** AssertJ dostarcza bogaty zestaw metod asercyjnych, które umożliwiają sprawdzenie różnych warunków w testach. Na przykład, metoda "assertThat" pozwala na sprawdzenie czy wartość jest równa oczekiwanej, czy zawiera określony fragment, czy jest null itp.  
> **Wsparcie dla różnych typów danych:** AssertJ zapewnia metody asercyjne dostosowane do różnych typów danych, takich jak kolekcje, mapy, obiekty, liczby, tekst itp. Dzięki temu testowanie zachowania kodu dla różnych typów danych jest proste i czytelne.  
> **Bogata obsługa błędów:** AssertJ zapewnia czytelne komunikaty o błędach, które pomagają w diagnozowaniu problemów w przypadku niepowodzenia testu. Komunikaty te zawierają jasne informacje o tym, która asercja zawiodła i dlaczego.  
> **Łatwa integracja:** AssertJ jest łatwa w integracji z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Mockito, czy Spock. Można go również używać z różnymi narzędziami budowania, takimi jak Maven czy Gradle.  
> W skrócie, **"AssertJ Core"** jest głównym modułem biblioteki AssertJ, który zawiera podstawowe metody asercyjne i narzędzia potrzebne do pisania czytelnych, ekspresyjnych i precyzyjnych testów w języku Java. Dodanie AssertJ Core jako zależności do projektu umożliwia łatwe i efektywne pisanie testów asercyjnych.*
</details>
<details>
    <summary>4. Java Faker</summary>

> *Dependency o nazwie **"Java Faker"** jest biblioteką do generowania danych testowych w języku Java. Pozwala ona tworzyć losowe dane o różnym charakterze, takie jak imiona, nazwiska, adresy e-mail, numery telefonów, daty, numery PESEL itp. Biblioteka Java Faker jest użyteczna w procesie testowania aplikacji, gdy potrzebne są realistyczne, ale losowe dane do zasilenia testów.  
> Oto kilka głównych funkcji, za które odpowiada Java Faker:  
> **Generowanie różnych typów danych:** Java Faker pozwala generować różnorodne typy danych, takie jak imiona, nazwiska, adresy, daty, numery telefonów, adresy e-mail, numery PESEL, numery identyfikacyjne itp.  
> **Losowość:** Biblioteka ta generuje losowe dane każdorazowo, kiedy jest wywoływana, co zapewnia zróżnicowanie danych testowych w każdym uruchomieniu testów.  
> **Elastyczność:** Java Faker oferuje dużą elastyczność w dostosowywaniu generowanych danych poprzez dostęp do różnych lokalizacji, ustawień regionalnych, a także możliwość tworzenia niestandardowych dostawców danych.  
> **Łatwa integracja:** Java Faker jest łatwa w użyciu i integruje się dobrze z różnymi narzędziami do testowania, takimi jak JUnit, TestNG czy Selenium. Może być również wykorzystywana w różnych scenariuszach testowych, w tym testach jednostkowych, testach integracyjnych oraz testach automatycznych interfejsu użytkownika.  
> Dzięki **"Java Faker"** możliwe jest szybkie i łatwe generowanie różnorodnych danych testowych, co znacząco ułatwia proces testowania aplikacji. Jest to szczególnie przydatne w sytuacjach, gdy potrzebne są realistyczne dane, ale nie jest konieczne korzystanie z rzeczywistych danych użytkowników.*
</details>
<details>
    <summary>5. Dotenv Java</summary>

> *Biblioteka **Dotenv Java** (często nazywana `java-dotenv`) to narzędzie, które umożliwia bezpośrednie ładowanie zmiennych środowiskowych z pliku `.env` do aplikacji napisanej w Javie. Jest szczególnie przydatna podczas pracy z aplikacjami wymagającymi różnych ustawień konfiguracyjnych, które nie powinny być zapisywane bezpośrednio w kodzie, np. dane logowania, klucze API, adresy URL.  
> Kluczowe cechy Dotenv Java:  
> **Łatwe ładowanie zmiennych:** Dotenv Java pozwala na odczyt zmiennych środowiskowych z pliku .env bez potrzeby dodatkowych konfiguracji.  
> **Obsługa zmiennych środowiskowych:** Zmienne te mogą być dostępne w aplikacji jako wartości, które łatwo uzyskać przy użyciu dedykowanej metody.  
> **Bezpieczeństwo:** Przechowywanie danych w pliku .env ułatwia oddzielenie danych wrażliwych od kodu źródłowego i chroni je przed przypadkowym dodaniem do repozytoriów publicznych (gdy .env jest na przykład wykluczony z wersjonowania).  
> **Prosta konfiguracja:** Dotenv jest prosty w użyciu i integracji, co sprawia, że jest popularnym wyborem do zarządzania zmiennymi środowiskowymi.*
>
> *Dlaczego warto używać Dotenv Java?*  
> *Dotenv Java jest szczególnie przydatna, gdy:*
> - *Chcesz oddzielić dane konfiguracyjne od kodu (np. dane dostępowe do bazy danych).*
> - *Pracujesz z różnymi środowiskami (deweloperskim, testowym, produkcyjnym), gdzie potrzebujesz różnych wartości zmiennych.*
> - *Chcesz zredukować ryzyko przypadkowego ujawnienia wrażliwych danych w repozytoriach kodu.*
</details>
<details>
    <summary>6. Allure Report</summary>

> Biblioteka **Allure Report** to wszechstronny framework do generowania raportów z testów, który dostarcza bogate w szczegóły i interaktywne raporty, umożliwiające łatwe analizowanie wyników testów. Jest kompatybilny z wieloma narzędziami testowymi i językami programowania, co czyni go jednym z najczęściej używanych rozwiązań w świecie QA i automatyzacji testów.
> Najważniejsze cechy Allure Report
> 1. Interaktywne raporty
   Raporty generowane przez Allure są interaktywne i dostarczają kompleksowych informacji o:
> - Wynikach testów (sukcesy, niepowodzenia, pominięcia),
> - Strukturze uruchamianych testów,
> - Logach, załącznikach (np. zrzuty ekranu, logi aplikacji),
> - Czasach wykonania testów.
> 2. Wsparcie dla różnych frameworków
   Allure integruje się z popularnymi frameworkami testowymi, takimi jak:
> - JUnit 4, JUnit 5,
> - TestNG,
> - Cucumber,
> - Selenium,
> - Pytest (dla Python),
> - Mocha, Jasmine (dla JavaScript).
> 3. Łatwość konfiguracji
   Allure jest stosunkowo prosty w konfiguracji i pozwala na automatyczne generowanie raportów przy użyciu wtyczek dla Maven, Gradle lub bezpośredniej konfiguracji w kodzie testowym.
> 4. Struktura raportu
   Raport jest zorganizowany w sposób przejrzysty:
> - Test Suites – zestawy testów z podziałem na klasy i metody,
> - Behaviors – raportowanie na podstawie zachowań (np. tagi @Feature, @Story w testach),
> - Graphs – statystyki w formie wykresów,
> - Timeline – szczegóły dotyczące czasu wykonania testów,
> - Attachments – załączniki (zrzuty ekranu, pliki z logami),
> - Retries – śledzenie testów powtarzanych (retries).
> 5. Możliwość rozszerzeń
   Allure wspiera integracje z:
> - CI/CD (np. Jenkins, GitLab, GitHub Actions),
> - Narzędziami do zarządzania testami (np. TestRail),
> - Bazami danych lub własnymi wtyczkami za pomocą API Allure.
> Jak działa Allure?
> 1. Integracja z frameworkiem testowym  
Dodaje się odpowiednie zależności do projektu (np. Maven/Gradle) i konfiguruje listener Allure, aby zbierać dane o wynikach testów.
> 2. Zbieranie danych podczas testów  
Podczas uruchamiania testów Allure zbiera dane, takie jak:
> - Wynik testu (pass/fail/skip),
> - Czas wykonania,
> - Logi i załączniki (np. zrzuty ekranu),
> - Tagi (feature, story, owner).
>3. Generowanie raportu  
Na podstawie danych zapisanych w formacie JSON Allure generuje HTML-owy raport za pomocą polecenia:  
>`allure serve <katalog wyników>`
> 
> Zalety Allure Report:
> - Przejrzystość: Raporty są czytelne i intuicyjne, co ułatwia analizę wyników.
> - Rozszerzalność: Możliwość dostosowania do specyficznych potrzeb projektu.
> - Szerokie wsparcie: Obsługuje wiele języków i narzędzi.
> - Wizualizacja danych: Wykresy, statystyki i szczegóły testów.
> 
> Wady:
> - Konfiguracja początkowa: Może być czasochłonna, szczególnie w dużych projektach.
> - Zależność od narzędzi: Generowanie raportów wymaga narzędzi CLI Allure lub integracji w CI/CD.
</details>

#### Frontend

<details>
    <summary>1. Selenium Java</summary>

> *Dependency o nazwie **"Selenium Java"** to biblioteka, która umożliwia automatyzację testów interfejsu użytkownika (UI) w aplikacjach internetowych przy użyciu języka Java. Selenium jest jednym z najpopularniejszych narzędzi do testowania automatycznego webowego i pozwala programistom na symulowanie interakcji użytkownika z aplikacją w przeglądarce internetowej.  
> Oto kilka głównych funkcji, za które odpowiada Selenium Java:  
> **Automatyzacja akcji użytkownika:** Selenium umożliwia programistom symulowanie różnych akcji użytkownika w przeglądarce internetowej, takich jak kliknięcia, wprowadzanie danych, nawigacja po stronach, przewijanie, wysyłanie formularzy itp.  
> **Testowanie wielu przeglądarek:** Selenium obsługuje wiele przeglądarek internetowych, takich jak Chrome, Firefox, Edge, Safari, Opera, co pozwala na testowanie aplikacji na różnych platformach i przeglądarkach.  
> **Współpraca z różnymi narzędziami:** Selenium integruje się z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Maven, Gradle, Jenkins, co ułatwia automatyzację testów i integrację z procesami ciągłej integracji i dostarczania (CI/CD).  
> **Wsparcie dla wielu języków programowania:** Selenium dostępne jest w wielu językach programowania, w tym w Javie, Pythonie, JavaScript, Ruby, co umożliwia wybór preferowanego języka przez programistę.  
> **Obsługa różnych systemów operacyjnych:** Selenium działa na różnych systemach operacyjnych, takich jak Windows, Linux, macOS, co pozwala na testowanie aplikacji na różnych platformach.  
> Dzięki **"Selenium Java"** możliwe jest tworzenie skryptów testowych, które automatyzują interakcje użytkownika z aplikacją internetową w sposób programatyczny. Jest to niezwykle przydatne narzędzie do automatyzacji testów w środowiskach Agile, DevOps i Continuous Integration (CI), gdzie szybkość, skuteczność i niezawodność testów są kluczowe.*
</details>
<details>
    <summary>2. Selenium Support</summary>

> *Główną zaletą **"Selenium Support"**, o której dowiedziałem się na kursie, jest to, że dodaje nam obsługę pól typu drop-down.  
> Dependency o nazwie **"Selenium Support"** to część biblioteki Selenium, która zawiera narzędzia i funkcje pomocnicze, które ułatwiają automatyzację testów interfejsu użytkownika (UI) w aplikacjach internetowych.  
> Oto kilka głównych funkcji, za które odpowiada "Selenium Support":  
> **Wsparcie dla różnych elementów interfejsu użytkownika:** "Selenium Support" zapewnia narzędzia i funkcje pomocnicze do interakcji z różnymi elementami interfejsu użytkownika, takimi jak przyciski, pola tekstowe, listy rozwijane, checkboxy, radio buttony, elementy tabel itp.  
> **Manipulacja oknami przeglądarki:** Biblioteka ta umożliwia otwieranie, zamykanie, przełączanie między oknami i zakładkami przeglądarki internetowej, co jest przydatne w przypadku testów wymagających interakcji z wieloma oknami.  
> **Obsługa alertów i potwierdzeń:** Selenium Support pozwala na obsługę alertów, potwierdzeń i promptów, które mogą pojawić się podczas interakcji z aplikacją internetową.  
> **Czekanie na warunki:** Biblioteka ta dostarcza funkcje, które pozwalają czekać na określone warunki, takie jak pojawienie się elementu na stronie, zmiana wartości pola tekstowego, czy zakończenie ładowania strony.  
> **Obsługa ramek i iframe'ów:** Selenium Support umożliwia przełączanie się między różnymi ramkami (frame'ami) i iframe'ami na stronie internetowej, co jest niezbędne w przypadku testów, które wymagają interakcji z elementami znajdującymi się w różnych ramkach.  
> **"Selenium Support"** jest kluczową częścią biblioteki Selenium, która dostarcza programistom narzędzia i funkcje pomocnicze do efektywnej automatyzacji testów interfejsu użytkownika w aplikacjach internetowych. Dzięki temu programiści mogą pisać bardziej stabilne, czytelne i niezawodne testy UI.*
</details>
<details>
    <summary>3. WebDriverManager</summary>

> *Dependency o nazwie **"WebDriverManager"** to narzędzie, które ułatwia zarządzanie i automatyczne pobieranie niezbędnych binarnych plików (driverów) do obsługi różnych przeglądarek internetowych podczas korzystania z biblioteki Selenium WebDriver w języku Java.  
> Oto główne funkcje, za które odpowiada "WebDriverManager":  
> **Automatyczne pobieranie i zarządzanie driverami:** "WebDriverManager" automatycznie pobiera niezbędne binarne pliki (drivery) dla wybranej przeglądarki internetowej (np. Chrome, Firefox, Edge, Safari) oraz odpowiednią wersję w zależności od konfiguracji i wymagań projektu.  
> **Aktualizacje i zarządzanie wersjami:** Narzędzie to zapewnia aktualizacje i zarządzanie wersjami driverów, co pozwala na łatwe utrzymanie i aktualizowanie driverów w projekcie.  
> **Integracja z różnymi narzędziami budowania:** "WebDriverManager" jest łatwy w integracji z różnymi narzędziami budowania, takimi jak Maven, Gradle, czy inne, co pozwala na automatyczne zarządzanie driverami w procesie budowania projektu.  
> **Obsługa wielu platform:** Narzędzie to obsługuje różne platformy, takie jak Windows, Linux, macOS, co umożliwia korzystanie z niego w różnych środowiskach.  
> Dzięki **"WebDriverManager"** programiści mogą uniknąć ręcznego pobierania, aktualizowania i zarządzania driverami przeglądarek, co pozwala zaoszczędzić czas i zapewnia bardziej spójne i niezawodne środowisko testowe. Jest to szczególnie przydatne w projektach wykorzystujących Selenium WebDriver do automatyzacji testów interfejsu użytkownika w aplikacjach internetowych.*
</details>

#### Backend

<details>
    <summary>1. REST Assured</summary>

> *Dependency o nazwie **"REST Assured"** to biblioteka, która ułatwia testowanie interfejsów API (RESTful) w języku Java. "REST Assured" dostarcza prosty i czytelny sposób na pisanie testów automatycznych dla aplikacji, które komunikują się za pomocą protokołu HTTP, takich jak serwisy internetowe, mikroserwisy, czy RESTful API.  
> Oto główne funkcje, za które odpowiada "REST Assured":  
> **Zapytania HTTP:** "REST Assured" umożliwia tworzenie zapytań HTTP do zasobów API, takich jak GET, POST, PUT, DELETE, PATCH, co pozwala na interakcję z aplikacją za pomocą różnych metod HTTP.  
> **Sprawdzanie odpowiedzi:** Biblioteka ta dostarcza funkcje asercyjne, które pozwalają na sprawdzenie odpowiedzi zwracanych przez API, takich jak status odpowiedzi, nagłówki, treść odpowiedzi (np. w formacie JSON lub XML), co umożliwia weryfikację poprawności działania API.  
> **Obsługa autoryzacji:** "REST Assured" umożliwia obsługę różnych mechanizmów autoryzacji, takich jak podstawowa autoryzacja HTTP, autoryzacja z użyciem tokenów, OAuth itp.  
> **Testowanie RESTful funkcjonalności:** "REST Assured" pozwala na testowanie różnych aspektów funkcjonalnych interfejsów API, takich jak obsługa parametrów zapytań, obsługa nagłówków, obsługa zasobów statycznych i dynamicznych, obsługa błędów itp.  
> **Integracja z narzędziami testowania:** "REST Assured" jest łatwy w integracji z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Maven, Gradle, co umożliwia automatyzację testów API w ramach procesów CI/CD.  
> Dzięki **"REST Assured"** programiści mogą pisać czytelne, ekspresyjne i niezawodne testy automatyczne dla swoich interfejsów API, co pomaga w zapewnieniu jakości kodu i funkcjonalności aplikacji. Jest to niezwykle przydatne narzędzie w dzisiejszych projektach, które często opierają się na architekturze mikrousługowej i komunikacji między serwisami za pomocą RESTful API.*
</details>
<details>
    <summary>2. JSON Schema Validator</summary>

> *Dependency o nazwie **"JSON Schema Validator"** to biblioteka umożliwiająca walidację danych JSON względem schematu JSON (JSON Schema). JSON Schema to język opisowy używany do definiowania struktury i ograniczeń danych w formacie JSON. Biblioteka "JSON Schema Validator" pozwala programistom na walidację danych JSON zgodnie z określonym schematem JSON, co umożliwia sprawdzenie poprawności danych w stosunku do oczekiwanych reguł i ograniczeń.  
> Oto główne funkcje, za które odpowiada "JSON Schema Validator":  
> **Walidacja danych JSON:** Biblioteka ta umożliwia walidację danych JSON zgodnie z określonym schematem JSON. Sprawdza, czy dane JSON spełniają określone wymagania i ograniczenia zdefiniowane w schemacie JSON.  
> **Sprawdzanie struktury danych:** "JSON Schema Validator" pozwala na sprawdzenie, czy struktura danych JSON jest zgodna z oczekiwaną strukturą zdefiniowaną w schemacie JSON. Można kontrolować obecność i typy pól, zagnieżdżone obiekty, tablice, wartości null itp.  
> **Walidacja typów danych:** Biblioteka ta umożliwia walidację typów danych JSON, takich jak liczby, łańcuchy znaków, wartości logiczne, tablice, obiekty itp. Można określać oczekiwane typy danych oraz inne ograniczenia dotyczące wartości.  
> **Obsługa niestandardowych walidacji:** "JSON Schema Validator" pozwala na definiowanie niestandardowych reguł walidacji danych JSON poprzez dodawanie własnych walidatorów i funkcji sprawdzających.  
> **Integracja z różnymi narzędziami:** Biblioteka ta jest łatwa w integracji z różnymi narzędziami do testowania i walidacji danych JSON, takimi jak JUnit, TestNG, Maven, Gradle itp., co umożliwia automatyzację procesu walidacji danych w ramach testów automatycznych i procesów CI/CD.  
> Dzięki **"JSON Schema Validator"** programiści mogą zapewnić poprawność danych JSON poprzez ich walidację względem określonych schematów JSON, co jest kluczowe w przypadku komunikacji między różnymi serwisami, klientami i systemami, które wymieniają dane w formacie JSON.*
</details>
<details>
    <summary>3. Project Lombok</summary>

> *Dependency o nazwie **"Project Lombok"** to biblioteka w języku Java, która umożliwia programistom automatyzację generowania rutynowego kodu, takiego jak metody dostępowe (gettery i settery), metody `toString()`, `equals()`, `hashCode()`, a także wiele innych, poprzez dodanie adnotacji do kodu źródłowego.  
> Oto główne funkcje, za które odpowiada "Project Lombok":  
> **Generowanie metod dostępowych (gettery i settery):** "Project Lombok" automatycznie generuje metody dostępowe (gettery i settery) dla pól klasy, co eliminuje potrzebę pisania ich ręcznie.  
> **Generowanie metody `toString()`:** Biblioteka ta automatycznie generuje metodę `toString()` dla klasy, która zwraca czytelną reprezentację obiektu, zawierającą nazwy pól i ich wartości.  
> **Generowanie metod `equals()` i `hashCode()`:** "Project Lombok" automatycznie generuje metody `equals()` i `hashCode()` dla klasy, co umożliwia porównywanie obiektów na podstawie ich wartości.  
> **Inne funkcje pomocnicze:** Biblioteka ta dostarcza również inne funkcje pomocnicze, takie jak automatyczne tworzenie konstruktorów, metod `builder()`, `cleanUp()`, obsługa wyjątków itp.  
> **Redukcja powtarzalnego kodu:** Użycie "Project Lombok" pozwala programistom znacznie zmniejszyć ilość powtarzalnego kodu w aplikacji poprzez automatyczne generowanie rutynowych fragmentów kodu na podstawie adnotacji.  
> Dzięki **"Project Lombok"** programiści mogą pisać bardziej zwięzły i czytelny kod źródłowy, eliminując potrzebę pisania rutynowych fragmentów kodu ręcznie. Jest to szczególnie przydatne w przypadku klas modelu danych, gdzie duża część kodu może być generowana automatycznie.*
</details>
<details>
    <summary>4. Jackson Databind (opcjonalne)</summary>

> *Dependency o nazwie **"Jackson Databind"** jest częścią biblioteki Jackson, która umożliwia przekształcanie danych między formatem JSON a obiektami Java oraz pomiędzy innymi formatami danych a obiektami Java. Jest to jedna z najpopularniejszych bibliotek do przetwarzania danych JSON w języku Java.  
> Oto główne funkcje, za które odpowiada "Jackson Databind":  
> **Serializacja i deserializacja JSON:** "Jackson Databind" umożliwia konwersję danych JSON na obiekty Java (deserializacja) oraz obiektów Java na dane JSON (serializacja). Pozwala to na łatwe komunikowanie się z serwisami webowymi, bazami danych, czy innymi źródłami danych, które używają formatu JSON.  
> **Wsparcie dla różnych typów danych:** Biblioteka ta obsługuje różnorodne typy danych Java, takie jak proste typy danych, kolekcje, mapy, obiekty złożone, enumy itp., co umożliwia przetwarzanie różnych struktur danych.  
> **Konfigurowalność:** "Jackson Databind" jest konfigurowalna i elastyczna, co pozwala dostosować sposób przetwarzania danych do indywidualnych potrzeb projektu. Można dostosować reguły serializacji i deserializacji, obsługę różnych typów danych, formatowanie danych itp.  
> **Obsługa adnotacji:** Biblioteka ta obsługuje różne adnotacje, które można użyć do konfiguracji procesu serializacji i deserializacji danych, takie jak `@JsonProperty`, `@JsonDeserialize`, `@JsonSerialize`, co daje programiście większą kontrolę nad procesem przetwarzania danych.  
> **Wsparcie dla różnych formatów danych:** Oprócz formatu JSON, "Jackson Databind" obsługuje również inne popularne formaty danych, takie jak XML, YAML, CSV itp., co sprawia, że jest to uniwersalne narzędzie do przetwarzania danych w języku Java.  
> Dzięki **"Jackson Databind"** programiści mogą łatwo przekształcać dane między formatem JSON a obiektami Java, co jest niezbędne w wielu aplikacjach, które komunikują się z zewnętrznymi serwisami, bazami danych, czy klientami poprzez format JSON.*
</details>
<details>
    <summary>5. Jakarta JSON Processing API (opcjonalne)</summary>

> *Dependency o nazwie **"Jakarta JSON Processing API"** to biblioteka służąca do przetwarzania danych w formacie JSON w języku Java zgodnie ze standardami Jakarta EE (wcześniej znane jako Java EE). Jest to część Jakarta EE, która zapewnia interfejsy i klasy umożliwiające czytanie, zapisywanie i manipulowanie danymi w formacie JSON.  
> Oto główne funkcje, za które odpowiada "Jakarta JSON Processing API":  
> **Przetwarzanie JSON:** Biblioteka ta umożliwia łatwe przetwarzanie danych w formacie JSON, w tym parsowanie danych wejściowych JSON na obiekty Java oraz generowanie danych JSON z obiektów Java.  
> **Obsługa różnych typów danych:** "Jakarta JSON Processing API" obsługuje różne typy danych JSON, takie jak obiekty, tablice, liczby, łańcuchy znaków, wartości logiczne, wartości null itp.  
> **Wsparcie dla strumieniowania:** Biblioteka ta dostarcza interfejsy do strumieniowego przetwarzania danych JSON, co umożliwia efektywne przetwarzanie dużych ilości danych bez konieczności wczytywania całego pliku JSON do pamięci.  
> **Manipulacja danymi:** "Jakarta JSON Processing API" umożliwia manipulację danymi JSON, taką jak dodawanie, usuwanie i modyfikowanie elementów obiektów JSON oraz tablic JSON.  
> **Wsparcie dla standardów Jakarta EE:** Biblioteka ta jest zgodna ze standardami Jakarta EE, co oznacza, że może być używana w aplikacjach opartych na platformie Jakarta EE, takich jak serwery aplikacji Jakarta EE, bez dodatkowych konfiguracji.  
> Dzięki **"Jakarta JSON Processing API"** programiści mogą łatwo integrować obsługę formatu JSON w swoich aplikacjach opartych na platformie Jakarta EE, co jest szczególnie przydatne w przypadku aplikacji, które wymieniają dane w formacie JSON z innymi serwisami lub klientami.*
</details>
