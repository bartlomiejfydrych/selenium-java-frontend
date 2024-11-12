# 📚Notatki - dotyczące samej konfiguracji projektu

## 🔧Konfiguracja

1. Instalujemy `IntelliJ IDEA`
   - `JDK` - Jest już wbudowane w IDE. Nie trzeba go pobierać osobno tak jak kiedyś
   - `Zmienne środowiskowe` - nimi również nie musimy się przejmować tak jak kiedyś
2. Klikamy utworzenie nowego projektu
   - Jeżeli już jesteśmy w jakimś projekcie to:
     - Klikamy na "Hamburger Menu" w lewym, górnym rogu
     - Klikamy `New`
     - Klikamy `Project`
3. Podajemy `nazwę projektu`
   - Dla projektów Git najlepiej stosować format `nazwa-mojego-projektu`  
4. Wybieramy `lokalizację` projektu
5. Pomijamy `Create new Git repository`, ponieważ lepiej to zrobić jak będziemy mieć już skonfigurowany plik `.gitignore`
6. Wybieramy `język: Java`
7. Wybieramy `Build system: Maven`
   - Maven jest fajny do zarządzania frameworkami
8. Wybieramy `JDK`
   - Jeżeli nie ma na liście, to pobieramy.  
        Może być dowolne np. z Amazona.  
        Z Oracle może być ten problem, że mają inne prawa oraz są powiązane z Chinami (podobno).
   - JDK warto wybierać jak najnowsze (ale też nie takie, które dopiero co wyszło) oraz wybierać wersję z długotrwałym wsparciem, czyli oznaczone jako (LTS) Long Term Support.
9. Można zaznaczyć `Add sample code`
   - Żeby lepiej się orientować w katalogach. Potem się go usunie
10. Kasujemy plik `.gitignore`  
    - Stworzymy za chwilę własny za pomocą pluginu .ignore
    - Możemy też zostawić i wkleić do niego gotowy szablon z internetu
11. Instalujemy `pluginy` (więcej w sekcji z Pluginami)
12. Generujemy plik `.gitignore` za pomocą pluginu `.ignore` (więcej w sekcji z Pluginami)
13. Wrzucamy projekt na GitHub
    - Klikamy `Hamburger Menu`
    - Klikamy `VCS`
    - Klikamy `Share Project on GitHub`
    - Podajemy `nazwę` repozytorium
    - Zaznaczamy / Odznaczamy `Private`
    - Możemy dodać `opis`, ale jeżeli mamy już plik README w projekcie to lepiej zostawić puste
    - Klikamy `Share`
14. Wpisujemy w google `maven repository` lub wchodzimy na stronę:
https://mvnrepository.com/
    - Wyszukujemy interesujący nas framework
    - Klikamy na niego
    - Klikamy w najbardziej aktualną i stabilną wersję
    - Kopiujemy <dependencies> z zakładki Maven
15. Otwieramy plik `pom.xml` i tam to wklejamy
    - Pod `<properties>` musimy dodać `<dependencies></dependencies>`
    - Pomiędzy <dependencies> wklejamy nasze <dependency> z repozytorium Maven
16. Wrzucamy następujące `<dependencies>`:  
(Szczegóły o nich w osobnej sekcji z Maven - dependencies)
    - Uniwersalne:
        - JUnit Jupiter (Aggregator)
        - Java Faker
        - AssertJ Core
        - Dotenv Java
    - Frontend:
        - Selenium Java
        - Selenium Support
        - WebDriverManager
    - Backend:
        - REST Assured
        - JSON Schema Validator
        - Project Lombok
        - Jackson Databind (opcjonalne)
        - Jakarta JSON Processing API (opcjonalne)
17. Jeżeli chcemy, możemy w `<properties>` zdefiniować sobie zmienne dla numerów wersji naszych dependencies  
    (Więcej w sekcji: Maven - dependencies -> Ustawianie zmiennych...)
18. Po wklejeniu naszych dependencies gdzieś w okolicach prawego, górnego rogu powinna pojawić się ikona Mavena. Klikamy w nią.  
Sprawi to, że dependencies zostaną pobrane i zainstalowane do naszego projektu.  
Niektóre dependencies będą podkreślone z informacjami, że mają jakieś luki w zabezpieczeniach. No ale nic się z tym za bardzo nie zrobi.
19. Warto się upewnić czy dependencies zostały dodane do projektu:
    - Klikamy na pasku po prawej na ikonę Mavena (m)
    - Rozwijamy katalog `Dependencies`
    - Patrzymy czy są wszystkie, które podaliśmy w pom.xml
20. Możemy rozpocząć pisanie testów.  
Dalsze kroki w `README` katalogu `selenium-java` 

## ✔Typo - poprawienie dla plików Markdown pisanych w języku polskim

1. Klikamy `Hamburger Menu` w lewym, górnym rogu
2. Klikamy `File`
3. Klikamy `Settings`
4. Rozwijamy `Editor`
5. Klikamy `Natural Languages`
6. Klikamy `+`
7. Szukamy na liście `Polski`
8. Klikamy `Apply`
9. Klikamy `OK`

## 🔌Pluginy do IDE

### Instalacja / Lokalizacja

1. Klikamy `Hamburger Menu`
2. Klikamy `Settings`
3. Wybieramy z menu po lewej `Plugins`
4. W zakładce `Marketplace` wyszukujemy pluginy, które nas interesują
5. Klikamy `Install` przy wybranym pluginie
6. W zakładce `Installed` mamy listę pluginów, które są już zainstalowane

### Lista pluginów z opisem

1. **.ignore**  
*Służy do generowania plików .gitignore np. gotowy plik ignorujący wszystkie zbędne pliki pod Javę.*  
Sposób użycia:
   - Klikamy `prawym na katalog z projektem`
   - Klikamy `New`
   - Klikamy `.ignore File`
   - Klikamy `.gitignore File (Git)`
   - Na liście wyszukujemy i zaznaczamy następujące templatki:
     - JetBrains / IntelliJ
     - Java
     - Maven
   - Klikamy `Generate`
2. **Rainbow Brackets**  
*Lepiej i wyraźniej koloruje nam nawiasy niż standardowo robi to IDE.*
3. **Key Promoter X**  
*Służy do nauki skrótów klawiszowych jakie znajdują się w IDE.*
4. **Lombok** (Dla testów API)  
*Uwaga! Żeby z tego korzystać trzeba również do Mavena dodać dependencies z Lomboka.  
Lombok to biblioteka dla języka Java, która ma na celu uproszczenie pisania kodu poprzez automatyzację generowania standardowych fragmentów kodu, takich jak gettery, settery, konstruktory, metody equals(), hashCode() i inne.  
Dodatkowo posiada adnotację @Builder, która jest przydatna w testach API, gdy chcemy zbudować body responsa na podstawie klasy.*

## ⓂMaven - dependencies

### Ustawianie zmiennych dla numerów wersji

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
    <summary>2. AssertJ Core</summary>

> *Dependency o nazwie **"AssertJ Core"** odnosi się do biblioteki AssertJ, która jest popularnym narzędziem do tworzenia testów asercyjnych w języku Java. AssertJ pozwala na pisanie czytelnych, ekspresyjnych i łatwych w utrzymaniu testów poprzez dostarczenie bogatego zestawu metod asercyjnych, które sprawdzają zachowanie kodu w sposób intuicyjny i precyzyjny.  
> Oto kilka głównych funkcji, za które odpowiada AssertJ Core:  
> **Metody asercyjne:** AssertJ dostarcza bogaty zestaw metod asercyjnych, które umożliwiają sprawdzenie różnych warunków w testach. Na przykład, metoda "assertThat" pozwala na sprawdzenie czy wartość jest równa oczekiwanej, czy zawiera określony fragment, czy jest null itp.  
> **Wsparcie dla różnych typów danych:** AssertJ zapewnia metody asercyjne dostosowane do różnych typów danych, takich jak kolekcje, mapy, obiekty, liczby, tekst itp. Dzięki temu testowanie zachowania kodu dla różnych typów danych jest proste i czytelne.  
> **Bogata obsługa błędów:** AssertJ zapewnia czytelne komunikaty o błędach, które pomagają w diagnozowaniu problemów w przypadku niepowodzenia testu. Komunikaty te zawierają jasne informacje o tym, która asercja zawiodła i dlaczego.  
> **Łatwa integracja:** AssertJ jest łatwa w integracji z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Mockito, czy Spock. Można go również używać z różnymi narzędziami budowania, takimi jak Maven czy Gradle.  
> W skrócie, **"AssertJ Core"** jest głównym modułem biblioteki AssertJ, który zawiera podstawowe metody asercyjne i narzędzia potrzebne do pisania czytelnych, ekspresyjnych i precyzyjnych testów w języku Java. Dodanie AssertJ Core jako zależności do projektu umożliwia łatwe i efektywne pisanie testów asercyjnych.*
</details>
<details>
    <summary>3. Java Faker</summary>

> *Dependency o nazwie **"Java Faker"** jest biblioteką do generowania danych testowych w języku Java. Pozwala ona tworzyć losowe dane o różnym charakterze, takie jak imiona, nazwiska, adresy e-mail, numery telefonów, daty, numery PESEL itp. Biblioteka Java Faker jest użyteczna w procesie testowania aplikacji, gdy potrzebne są realistyczne, ale losowe dane do zasilenia testów.  
> Oto kilka głównych funkcji, za które odpowiada Java Faker:  
> **Generowanie różnych typów danych:** Java Faker pozwala generować różnorodne typy danych, takie jak imiona, nazwiska, adresy, daty, numery telefonów, adresy e-mail, numery PESEL, numery identyfikacyjne itp.  
> **Losowość:** Biblioteka ta generuje losowe dane każdorazowo, kiedy jest wywoływana, co zapewnia zróżnicowanie danych testowych w każdym uruchomieniu testów.  
> **Elastyczność:** Java Faker oferuje dużą elastyczność w dostosowywaniu generowanych danych poprzez dostęp do różnych lokalizacji, ustawień regionalnych, a także możliwość tworzenia niestandardowych dostawców danych.  
> **Łatwa integracja:** Java Faker jest łatwa w użyciu i integruje się dobrze z różnymi narzędziami do testowania, takimi jak JUnit, TestNG czy Selenium. Może być również wykorzystywana w różnych scenariuszach testowych, w tym testach jednostkowych, testach integracyjnych oraz testach automatycznych interfejsu użytkownika.  
> Dzięki **"Java Faker"** możliwe jest szybkie i łatwe generowanie różnorodnych danych testowych, co znacząco ułatwia proces testowania aplikacji. Jest to szczególnie przydatne w sytuacjach, gdy potrzebne są realistyczne dane, ale nie jest konieczne korzystanie z rzeczywistych danych użytkowników.*
</details>
<details>
    <summary>4. Dotenv Java</summary>

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
