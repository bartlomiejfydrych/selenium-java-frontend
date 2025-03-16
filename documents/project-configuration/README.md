# 🛠Konfiguracja projektu – notatki

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
   - [Jackson Databind vs. Jakarta JSON Processing API (JSON-P) – porównanie](#jackson_vs_jakarta)
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

Dalsze kroki opisujące jak rozpocząć pisanie testów znajdują się w:  
📁selenium-java-frontend (projekt)  
&emsp;📁documents  
&emsp;&emsp;📁notes  
&emsp;&emsp;&emsp;📂selenium-and-tests

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

## 🏆Jackson Databind vs. Jakarta JSON Processing API (JSON-P) – porównanie <a name="jackson_vs_jakarta"></a>

Obie biblioteki służą do przetwarzania JSON w Java, ale mają różne zastosowania i poziomy popularności.

### **1️⃣ Jackson Databind – Najpopularniejszy wybór 🚀**
**📌 Zalety:**  
✅ **Najpopularniejsza biblioteka** – używana w Spring Boot, Micronaut, Quarkus  
✅ **Konwersja JSON ↔️ Java Objects (POJO)** – bez potrzeby pisania kodu parsującego  
✅ **Bardzo szybka i wydajna**  
✅ **Obsługuje różne formaty (JSON, XML, YAML, CBOR itp.)**  
✅ **Łatwa konfiguracja i rozszerzalność**

**📌 Przykład:**
```java
ObjectMapper objectMapper = new ObjectMapper();
Person person = objectMapper.readValue(jsonString, Person.class);
```
👉 **Jackson Databind to standard de facto w Spring Boot i API REST.**

### **2️⃣ Jakarta JSON Processing API (JSON-P) – Standard Jakarta EE**
**📌 Zalety:**  
✅ **Część oficjalnej specyfikacji Jakarta EE**  
✅ **Lżejsza niż Jackson – nie wymaga dodatkowych zależności**  
✅ **Obsługuje zarówno model obiektowy, jak i API strumieniowe (lepsza wydajność dla dużych plików)**  
✅ **Działa dobrze w środowiskach Jakarta EE (np. aplikacje serwerowe, Java EE)**

**📌 Przykład:**
```java
JsonObject json = Json.createObjectBuilder()
    .add("imie", "Jan")
    .add("wiek", 30)
    .build();
```
👉 **Lepsza, jeśli używasz środowiska Jakarta EE i potrzebujesz lekkiego API do JSON.**

### **🔎 Które rozwiązanie wybrać?**

| Cecha                            | **Jackson Databind** 🏆                               | **Jakarta JSON-P**                              |
|----------------------------------|-------------------------------------------------------|-------------------------------------------------|
| **Popularność**                  | 🔥🔥🔥 **Najpopularniejsze** (Spring Boot, REST APIs) | 🔥 Używane w Jakarta EE                         |
| **Łatwość użycia**               | ✅ **Łatwe mapowanie JSON ↔ POJO**                     | ⚠️ Wymaga manualnej obsługi JSON                |
| **Wydajność**                    | 🚀 Bardzo szybkie                                     | ⚡ Lekkie, ale mniej optymalne dla dużych danych |
| **Obsługa POJO**                 | ✅ Automatyczna                                        | ❌ Brak natywnego wsparcia                       |
| **API Strumieniowe**             | 🔄 Obsługiwane, ale mniej elastyczne                  | ✅ Bardzo wydajne dla dużych plików              |
| **Wsparcie dla innych formatów** | ✅ JSON, XML, YAML, CBOR                               | ❌ Tylko JSON                                    |
| **Wbudowane w Jakarta EE?**      | ❌ Nie                                                 | ✅ Tak                                           |

**📌 Werdykt:**  
✔ **Użyj Jackson Databind**, jeśli pracujesz ze **Spring Boot, REST API lub potrzebujesz mapowania JSON ↔️ Java POJO**.  
✔ **Użyj Jakarta JSON-P**, jeśli pracujesz w środowisku **Jakarta EE i potrzebujesz lekkiej biblioteki JSON**.

🚀 **W większości przypadków Jackson Databind będzie lepszym wyborem!**

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

### 📕JUnit Jupiter (Aggregator) <a name="junit_jupiter_aggregator"></a>

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

---

### 📕JUnit Platform Suite (Aggregator) <a name="junit_platform_suite_aggregator"></a>

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

---

### 📕AssertJ Core <a name="assertj_core"></a>

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

---

### 📕Java Faker <a name="java_faker"></a>

🔹 **Java Faker** to biblioteka do generowania **losowych danych testowych** w języku Java. Umożliwia tworzenie
**fikcyjnych nazw, adresów, numerów telefonów, dat, tekstów i wielu innych typów danych**. Jest często używana
w **testach jednostkowych, integracyjnych oraz do populacji baz danych**.

#### **📦 Dodanie do projektu**

**Maven (pom.xml)**
```xml
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    implementation("com.github.javafaker:javafaker:1.0.2")
}
```

#### **🛠️ Jak używać Java Faker?**

```java
import com.github.javafaker.Faker;

public class FakerExample {
    public static void main(String[] args) {
        Faker faker = new Faker();

        // Generowanie danych osobowych
        System.out.println("Imię: " + faker.name().firstName());
        System.out.println("Nazwisko: " + faker.name().lastName());
        System.out.println("Adres e-mail: " + faker.internet().emailAddress());

        // Generowanie adresu
        System.out.println("Ulica: " + faker.address().streetAddress());
        System.out.println("Miasto: " + faker.address().city());
        System.out.println("Kod pocztowy: " + faker.address().zipCode());

        // Generowanie losowych danych finansowych
        System.out.println("Numer karty kredytowej: " + faker.finance().creditCard());

        // Generowanie daty urodzenia
        System.out.println("Data urodzenia: " + faker.date().birthday());

        // Generowanie numeru telefonu
        System.out.println("Numer telefonu: " + faker.phoneNumber().cellPhone());

        // Generowanie fikcyjnej firmy
        System.out.println("Firma: " + faker.company().name());

        // Generowanie losowego tekstu
        System.out.println("Randomowy tekst: " + faker.lorem().sentence());
    }
}
```

#### **📌 Kluczowe funkcjonalności Java Faker**

✅ **Generowanie danych osobowych** (`name()`, `internet().emailAddress()`)  
✅ **Adresy i lokalizacje** (`address().city()`, `address().streetName()`)  
✅ **Numery telefonów i karty kredytowe** (`phoneNumber().cellPhone()`, `finance().creditCard()`)  
✅ **Losowe daty** (`date().birthday()`, `date().past()`)  
✅ **Firmy i stanowiska pracy** (`company().name()`, `job().position()`)  
✅ **Generowanie losowych słów i zdań** (`lorem().sentence()`, `lorem().paragraph()`)

#### **🎯 Dlaczego warto używać Java Faker?**
🔹 **Automatyczne generowanie realistycznych danych** – przydatne w testach i mockowaniu danych.  
🔹 **Łatwa integracja** – szybkie wdrożenie w **JUnit, TestNG, Selenium i Spring Boot**.  
🔹 **Wsparcie dla wielu języków** – można generować dane w różnych lokalizacjach (`Faker faker = new Faker(new Locale("pl"))`).

👉 **Java Faker** to świetne narzędzie do **testowania i mockowania danych** w aplikacjach Java! 🚀

---

### 📕Dotenv Java <a name="dotenv_java"></a>

🔹 **Dotenv Java** to biblioteka umożliwiająca **wczytywanie zmiennych środowiskowych z pliku `.env`** do aplikacji
Java. Jest szczególnie przydatna w celu **przechowywania konfiguracji aplikacji** (np. kluczy API, adresów baz danych)
w sposób bezpieczny i łatwy do zarządzania.

#### **📦 Dodanie do projektu**

**Maven (pom.xml)**
```xml
<dependency>
    <groupId>io.github.cdimascio</groupId>
    <artifactId>dotenv-java</artifactId>
    <version>3.0.0</version>
</dependency>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    implementation("io.github.cdimascio:dotenv-java:3.0.0")
}
```

#### **🛠️ Jak używać Dotenv Java?**

1️⃣ **Tworzymy plik `.env` w katalogu głównym projektu:**
```
DATABASE_URL=jdbc:mysql://localhost:3306/mydb
DATABASE_USER=root
DATABASE_PASSWORD=secret
API_KEY=12345-abcdef
```

2️⃣ **Wczytujemy plik `.env` w kodzie Java:**
```java
import io.github.cdimascio.dotenv.Dotenv;

public class DotenvExample {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load(); // Automatycznie wczytuje plik .env

        String dbUrl = dotenv.get("DATABASE_URL");
        String dbUser = dotenv.get("DATABASE_USER");
        String dbPassword = dotenv.get("DATABASE_PASSWORD");
        String apiKey = dotenv.get("API_KEY");

        System.out.println("Database URL: " + dbUrl);
        System.out.println("Database User: " + dbUser);
        System.out.println("API Key: " + apiKey);
    }
}
```

#### **📌 Kluczowe funkcjonalności Dotenv Java**

✅ **Automatyczne wczytywanie pliku `.env`** – brak konieczności ustawiania zmiennych środowiskowych w systemie  
✅ **Obsługa wartości domyślnych** (`dotenv.get("VARIABLE", "default_value")`)  
✅ **Wsparcie dla różnych lokalizacji pliku** (`Dotenv.configure().directory("/custom/path").load()`)  
✅ **Łatwa integracja z aplikacjami Spring Boot, JUnit, Selenium i innymi**

#### **🎯 Dlaczego warto używać Dotenv Java?**
🔹 **Bezpieczeństwo** – zamiast przechowywać dane w kodzie źródłowym, używasz `.env`, który nie jest commitowany do repozytorium (`.gitignore`).  
🔹 **Łatwość konfiguracji** – konfiguracja aplikacji jest przechowywana w jednym miejscu i może być łatwo zmieniana.  
🔹 **Przenośność** – działa zarówno w **środowisku lokalnym**, jak i na **serwerach CI/CD**.

👉 **Dotenv Java** to świetne narzędzie do **zarządzania konfiguracją aplikacji w sposób bezpieczny i elastyczny**! 🚀

---

### 📕Allure Report <a name="allure_report_dependency"></a>

🔹 **Allure Report** to biblioteka służąca do **generowania atrakcyjnych i szczegółowych raportów z testów** w Java.
Współpracuje z popularnymi frameworkami testowymi, takimi jak **JUnit 5, TestNG, Cucumber, Serenity BDD**, a także
z narzędziami CI/CD (Jenkins, GitHub Actions).

Allure pozwala na **lepszą wizualizację wyników testów**, śledzenie historii ich wykonania oraz analizowanie błędów.

#### **📦 Dodanie Allure Report do projektu**

**Maven (pom.xml)**
```xml
<dependencies>
    <!-- Główna biblioteka Allure -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-junit5</artifactId>
        <version>2.24.0</version>
    </dependency>

    <!-- Jeśli używasz TestNG zamiast JUnit 5 -->
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.24.0</version>
    </dependency>
</dependencies>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    testImplementation("io.qameta.allure:allure-junit5:2.24.0")
}
```

#### **🛠️ Jak używać Allure Report?**

1️⃣ **Dodanie adnotacji do testów**
```java
import io.qameta.allure.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllureExampleTest {

    @Test
    @Description("Sprawdza, czy test przechodzi poprawnie")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Funkcja logowania")
    @Story("Logowanie użytkownika")
    public void sampleTest() {
        assertTrue(true, "Test powinien przejść");
    }
}
```

2️⃣ **Uruchomienie testów i wygenerowanie raportu**
- **Maven:**
    ```sh
    mvn clean test
    mvn allure:serve
    ```
- **Gradle:**
  ```sh
  ./gradlew clean test allureReport
  ./gradlew allureServe
  ```

📌 **`allure:serve`** otwiera interaktywny raport w przeglądarce.

#### **📌 Kluczowe funkcjonalności Allure Report**

✅ **Graficzna wizualizacja wyników testów** 🖥️  
✅ **Adnotacje do oznaczania testów (`@Feature`, `@Story`, `@Step`)**  
✅ **Śledzenie historii testów**  
✅ **Zrzuty ekranu i logi do analizy błędów**  
✅ **Integracja z narzędziami CI/CD (Jenkins, GitHub Actions)**

#### **🎯 Dlaczego warto używać Allure Report?**
🔹 **Przejrzyste raporty** – lepsza analiza wyników testów.  
🔹 **Świetna integracja z JUnit 5, TestNG, Cucumber itp.**  
🔹 **Łatwe debugowanie testów i śledzenie historii ich wykonania.**

👉 **Allure Report to jedno z najlepszych narzędzi do generowania raportów z testów automatycznych!** 🚀

## 🎨Frontend <a name="frontend"></a>

### 📗Selenium Java <a name="selenium_java"></a>

🔹 **Selenium Java** to biblioteka umożliwiająca **automatyzację testów przeglądarek internetowych** w języku **Java**.
Jest częścią frameworka **Selenium WebDriver**, który pozwala na interakcję z przeglądarkami w sposób zbliżony
do prawdziwego użytkownika.

Selenium obsługuje **różne przeglądarki** (Chrome, Firefox, Edge, Safari) oraz **wiele języków programowania**,
ale w przypadku **Javy** używa się dependency **Selenium Java**.

#### **📦 Dodanie Selenium Java do projektu**

**Maven (pom.xml)**
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.17.0</version>
    </dependency>
</dependencies>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.17.0")
}
```

📌 **Wersja 4.x** to najnowsza wersja Selenium, która wprowadza wiele usprawnień, m.in. **WebDriver BiDi API**
i lepszą obsługę Selenium Grid.

#### **🚀 Jak używać Selenium Java?**

1️⃣ **Uruchomienie przeglądarki i otwarcie strony**
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExample {
    public static void main(String[] args) {
        // Ustawienie ścieżki do WebDrivera (np. chromedriver.exe)
        System.setProperty("webdriver.chrome.driver", "ścieżka/do/chromedriver");

        // Tworzenie instancji przeglądarki
        WebDriver driver = new ChromeDriver();

        // Otwieranie strony
        driver.get("https://www.google.com");

        // Pobranie tytułu strony
        System.out.println("Tytuł strony: " + driver.getTitle());

        // Zamknięcie przeglądarki
        driver.quit();
    }
}
```

#### **📌 Kluczowe funkcjonalności Selenium Java**

✅ **Obsługa różnych przeglądarek** 🖥️ (Chrome, Firefox, Edge, Safari)  
✅ **Pełna interakcja z elementami strony** (kliknięcia, wpisywanie tekstu, pobieranie atrybutów)  
✅ **Obsługa alertów, ramek, nowych okien**  
✅ **Automatyzacja testów w locie lub w CI/CD**  
✅ **Obsługa headless mode (testowanie bez interfejsu przeglądarki)**  
✅ **Integracja z innymi frameworkami** (JUnit, TestNG, Cucumber, Allure Report)

#### **🔗 Przydatne dependency do Selenium Java**

📌 **WebDriver Manager** – automatyczne zarządzanie sterownikami przeglądarek
```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.7.0</version>
</dependency>
```

📌 **Selenium Support** – dodatkowe API dla Page Object Model
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-support</artifactId>
    <version>4.17.0</version>
</dependency>
```

#### **🎯 Dlaczego warto używać Selenium Java?**
🔹 **Jest to najpopularniejsze narzędzie do testowania aplikacji webowych.**  
🔹 **Pozwala na pełną automatyzację testów przeglądarkowych.**  
🔹 **Łatwa integracja z innymi narzędziami (Allure, JUnit, TestNG, Cucumber).**  
🔹 **Obsługuje testowanie w chmurze (Selenium Grid, BrowserStack, SauceLabs).**

👉 **Selenium Java to must-have dla każdego testera automatyzującego!** 🚀

---

### 📗Selenium Support <a name="selenium_support"></a>

🔹 **Selenium Support** to dodatkowy moduł dla **Selenium WebDriver**, który **rozszerza jego funkcjonalność**
i **ułatwia pracę z dynamicznymi elementami stron internetowych**.

Moduł ten zawiera narzędzia wspierające m.in.:  
✅ **Page Object Model (POM)** – wzorzec projektowy dla testów UI  
✅ **WebDriverWait** – mechanizm czekania na elementy (Explicit Waits)  
✅ **EventFiringWebDriver** – możliwość monitorowania zdarzeń w przeglądarce  
✅ **ExpectedConditions** – gotowe warunki do oczekiwania na elementy

#### **📦 Dodanie Selenium Support do projektu**

**Maven (pom.xml)**
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-support</artifactId>
    <version>4.17.0</version>
</dependency>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    implementation("org.seleniumhq.selenium:selenium-support:4.17.0")
}
```

📌 **Wersja 4.x** jest dostosowana do nowej architektury Selenium, zapewniając lepszą wydajność i stabilność.

#### **🚀 Kluczowe funkcjonalności Selenium Support**

**1️⃣ WebDriverWait – lepsza obsługa dynamicznych elementów**  
Pozwala na oczekiwanie, aż element pojawi się na stronie przed interakcją.
```java
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SeleniumSupportExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exampleElement")));

        driver.quit();
    }
}
```
✅ **Korzyści**: unikanie `NoSuchElementException`, lepsza stabilność testów.

**2️⃣ PageFactory – wsparcie dla Page Object Model (POM)**  
📌 **Automatyczne inicjalizowanie elementów strony** dzięki adnotacji `@FindBy`.
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
```
✅ **Korzyści**: czytelniejszy kod, łatwiejsza konserwacja testów.

**3️⃣ EventFiringWebDriver – śledzenie zdarzeń w Selenium**  
📌 Pozwala na monitorowanie interakcji WebDrivera i logowanie akcji użytkownika.
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.chrome.ChromeDriver;

class CustomEventListener extends AbstractWebDriverEventListener {
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Kliknięto element: " + element.getText());
    }
}

public class EventListenerExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriver eventDriver = new EventFiringDecorator(driver).register(new CustomEventListener());

        eventDriver.get("https://example.com");
        eventDriver.quit();
    }
}
```
✅ **Korzyści**: przydatne do debugowania i analizy testów.

#### **🎯 Dlaczego warto używać Selenium Support?**
🔹 **Ułatwia pracę z dynamicznymi elementami stron**  
🔹 **Wspiera wzorzec Page Object Model, poprawiając organizację kodu**  
🔹 **Daje większą kontrolę nad interakcjami WebDrivera**  
🔹 **Pomaga unikać problemów z synchronizacją testów**

👉 **Selenium Support to must-have dla każdego testera automatyzującego w Selenium!** 🚀

---

### 📗WebDriverManager <a name="web_driver_manager"></a>

🔹 **WebDriverManager** to **biblioteka ułatwiająca zarządzanie sterownikami przeglądarek (WebDrivers) w Selenium**.
Automatycznie pobiera, konfiguruje i aktualizuje sterowniki dla przeglądarek, eliminując konieczność ręcznej konfiguracji.

#### **📦 Dodanie WebDriverManager do projektu**

**Maven (pom.xml)**
```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.8.0</version>
</dependency>
```

**Gradle (build.gradle.kts)**
```kotlin
dependencies {
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")
}
```

📌 **Dzięki WebDriverManager nie musisz ręcznie pobierać i ustawiać ścieżek do sterowników przeglądarek**
(np. chromedriver.exe, geckodriver.exe).

#### **🚀 Jak działa WebDriverManager?**

**1️⃣ Uruchomienie przeglądarki bez ręcznej konfiguracji**  
✅ WebDriverManager automatycznie pobiera i konfiguruje odpowiedni sterownik:
```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // Pobiera i konfiguruje sterownik
        WebDriver driver = new ChromeDriver(); // Otwiera przeglądarkę

        driver.get("https://www.example.com");
        System.out.println("Tytuł strony: " + driver.getTitle());

        driver.quit(); // Zamknięcie przeglądarki
    }
}
```

**🔹 Korzyści:**  
✅ Nie musisz pobierać sterowników ręcznie  
✅ Nie musisz ustawiać `System.setProperty("webdriver.chrome.driver", "ścieżka")`  
✅ Biblioteka sama pobiera najnowszą wersję sterownika

#### **🛠️ Obsługiwane przeglądarki**
WebDriverManager obsługuje sterowniki dla najpopularniejszych przeglądarek:

```java
WebDriverManager.chromedriver().setup();   // Google Chrome  
WebDriverManager.firefoxdriver().setup();  // Mozilla Firefox  
WebDriverManager.edgedriver().setup();     // Microsoft Edge  
WebDriverManager.operadriver().setup();    // Opera  
WebDriverManager.safaridriver().setup();   // Safari  
```

**2️⃣ Ustawienie konkretnej wersji sterownika**  
Jeśli chcesz użyć **określonej wersji WebDrivera**, możesz to zrobić w ten sposób:
```java
WebDriverManager.chromedriver().driverVersion("120.0.6099.71").setup();
```

✅ **Przydatne, gdy masz starszą wersję przeglądarki i musisz użyć kompatybilnego sterownika.**

**3️⃣ Przechowywanie sterowników w pamięci cache**  
📌 WebDriverManager domyślnie przechowuje sterowniki w lokalnym cache, co przyspiesza uruchamianie testów:
- Windows: `C:\Users\NazwaUżytkownika\.cache\selenium`
- macOS/Linux: `~/.cache/selenium`

Jeśli chcesz **wyczyścić cache i pobrać nową wersję sterownika**, użyj:
```java
WebDriverManager.chromedriver().clearResolutionCache().setup();
```

#### **🎯 Dlaczego warto używać WebDriverManager?**
✅ **Automatyczne pobieranie i konfiguracja WebDriverów**  
✅ **Eliminacja problemów z kompatybilnością przeglądarek**  
✅ **Obsługa wielu przeglądarek w prosty sposób**  
✅ **Możliwość użycia konkretnej wersji sterownika**  
✅ **Przyspiesza i ułatwia konfigurację Selenium WebDriver**

👉 **WebDriverManager to must-have dla każdego testera automatyzującego w Selenium!** 🚀
