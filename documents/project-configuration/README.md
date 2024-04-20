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
    - Pod <properties> musimy dodać <dependencies></dependencies>
    - Pomiędzy <dependencies> wklejamy nasze <dependency> z repozytorium Maven
16. Wrzucamy następujące `<dependencies>`:  
(Szczegóły o nich w osobnej sekcji z Maven - dependencies)
    - Uniwersalne:
        - JUnit Jupiter (Aggregator)
        - AssertJ Core
        - Java Faker
    - Frontend:
        - Selenium Java
        - Selenium Support
        - WebDriverManager
    - Backend:
        - REST Assured
        - Jakarta JSON Processing API
        - Jackson Databind
        - JSON Schema Validator
        - Hamcrest
        - Project Lombok

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

### Lista pluginów

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

### Lista z opisem

#### Uniwersalne

1. **JUnit Jupiter (Aggregator)**  
*Dependency o nazwie "JUnit Jupiter (Aggregator)" w kontekście projektów Java jest związana z platformą testową JUnit 5, która składa się z kilku modułów. "JUnit Jupiter" jest jednym z tych modułów, odpowiedzialnym za obsługę testów opartych na nowej składni, wprowadzonej w JUnit 5.  
Aggregator dependency jest zestawem zależności, który agreguje lub grupuje różne moduły lub artefakty w jedną zależność. W przypadku JUnit Jupiter (Aggregator), jest to zależność, która zawiera wszystkie moduły JUnit 5, co pozwala na korzystanie z pełnej funkcjonalności JUnit 5 w projekcie za pomocą jednej zależności.  
W skład "JUnit Jupiter (Aggregator)" wchodzą m.in.:  
`JUnit Jupiter API:` Moduł zawierający interfejsy i adnotacje potrzebne do tworzenia testów w stylu JUnit 5.  
`JUnit Jupiter Engine:` Silnik uruchamiający testy napisane z użyciem JUnit 5.  
`JUnit Vintage Engine:` Silnik kompatybilny wstecznie, który pozwala na uruchamianie testów napisanych z użyciem JUnit 3 i JUnit 4.  
Używanie "JUnit Jupiter (Aggregator)" jako zależności w projekcie Java pozwala na łatwe korzystanie z pełnej funkcjonalności JUnit 5 bez konieczności ręcznego dodawania pojedynczych modułów. Wystarczy dodać tę zależność do pliku konfiguracyjnego (np. pom.xml w Maven lub build.gradle w Gradle), a narzędzie budujące automatycznie pobiera i zarządza wszystkimi modułami JUnit 5.*
2. **AssertJ Core**  
*Dependency o nazwie "AssertJ Core" odnosi się do biblioteki AssertJ, która jest popularnym narzędziem do tworzenia testów asercyjnych w języku Java. AssertJ pozwala na pisanie czytelnych, ekspresyjnych i łatwych w utrzymaniu testów poprzez dostarczenie bogatego zestawu metod asercyjnych, które sprawdzają zachowanie kodu w sposób intuicyjny i precyzyjny.  
Oto kilka głównych funkcji, za które odpowiada AssertJ Core:  
`Metody asercyjne:` AssertJ dostarcza bogaty zestaw metod asercyjnych, które umożliwiają sprawdzenie różnych warunków w testach. Na przykład, metoda "assertThat" pozwala na sprawdzenie czy wartość jest równa oczekiwanej, czy zawiera określony fragment, czy jest null itp.  
`Wsparcie dla różnych typów danych:` AssertJ zapewnia metody asercyjne dostosowane do różnych typów danych, takich jak kolekcje, mapy, obiekty, liczby, tekst itp. Dzięki temu testowanie zachowania kodu dla różnych typów danych jest proste i czytelne.  
`Bogata obsługa błędów:` AssertJ zapewnia czytelne komunikaty o błędach, które pomagają w diagnozowaniu problemów w przypadku niepowodzenia testu. Komunikaty te zawierają jasne informacje o tym, która asercja zawiodła i dlaczego.  
`Łatwa integracja:` AssertJ jest łatwa w integracji z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Mockito, czy Spock. Można go również używać z różnymi narzędziami budowania, takimi jak Maven czy Gradle.  
W skrócie, AssertJ Core jest głównym modułem biblioteki AssertJ, który zawiera podstawowe metody asercyjne i narzędzia potrzebne do pisania czytelnych, ekspresyjnych i precyzyjnych testów w języku Java. Dodanie AssertJ Core jako zależności do projektu umożliwia łatwe i efektywne pisanie testów asercyjnych.*
3. **Java Faker**  
*Dependency o nazwie "Java Faker" jest biblioteką do generowania danych testowych w języku Java. Pozwala ona tworzyć losowe dane o różnym charakterze, takie jak imiona, nazwiska, adresy e-mail, numery telefonów, daty, numery PESEL itp. Biblioteka Java Faker jest użyteczna w procesie testowania aplikacji, gdy potrzebne są realistyczne, ale losowe dane do zasilenia testów.  
Oto kilka głównych funkcji, za które odpowiada Java Faker:  
`Generowanie różnych typów danych:` Java Faker pozwala generować różnorodne typy danych, takie jak imiona, nazwiska, adresy, daty, numery telefonów, adresy e-mail, numery PESEL, numery identyfikacyjne itp.  
`Losowość:` Biblioteka ta generuje losowe dane każdorazowo, kiedy jest wywoływana, co zapewnia zróżnicowanie danych testowych w każdym uruchomieniu testów.  
`Elastyczność:` Java Faker oferuje dużą elastyczność w dostosowywaniu generowanych danych poprzez dostęp do różnych lokalizacji, ustawień regionalnych, a także możliwość tworzenia niestandardowych dostawców danych.  
`Łatwa integracja:` Java Faker jest łatwa w użyciu i integruje się dobrze z różnymi narzędziami do testowania, takimi jak JUnit, TestNG czy Selenium. Może być również wykorzystywana w różnych scenariuszach testowych, w tym testach jednostkowych, testach integracyjnych oraz testach automatycznych interfejsu użytkownika.  
Dzięki Java Faker możliwe jest szybkie i łatwe generowanie różnorodnych danych testowych, co znacząco ułatwia proces testowania aplikacji. Jest to szczególnie przydatne w sytuacjach, gdy potrzebne są realistyczne dane, ale nie jest konieczne korzystanie z rzeczywistych danych użytkowników.*

#### Frontend

1. **Selenium Java**  
*Dependency o nazwie "Selenium Java" to biblioteka, która umożliwia automatyzację testów interfejsu użytkownika (UI) w aplikacjach internetowych przy użyciu języka Java. Selenium jest jednym z najpopularniejszych narzędzi do testowania automatycznego webowego i pozwala programistom na symulowanie interakcji użytkownika z aplikacją w przeglądarce internetowej.  
Oto kilka głównych funkcji, za które odpowiada Selenium Java:  
`Automatyzacja akcji użytkownika:` Selenium umożliwia programistom symulowanie różnych akcji użytkownika w przeglądarce internetowej, takich jak kliknięcia, wprowadzanie danych, nawigacja po stronach, przewijanie, wysyłanie formularzy itp.  
`Testowanie wielu przeglądarek:` Selenium obsługuje wiele przeglądarek internetowych, takich jak Chrome, Firefox, Edge, Safari, Opera, co pozwala na testowanie aplikacji na różnych platformach i przeglądarkach.  
`Współpraca z różnymi narzędziami:` Selenium integruje się z różnymi narzędziami do testowania, takimi jak JUnit, TestNG, Maven, Gradle, Jenkins, co ułatwia automatyzację testów i integrację z procesami ciągłej integracji i dostarczania (CI/CD).  
`Wsparcie dla wielu języków programowania:` Selenium dostępne jest w wielu językach programowania, w tym w Javie, Pythonie, JavaScript, Ruby, co umożliwia wybór preferowanego języka przez programistę.  
`Obsługa różnych systemów operacyjnych:` Selenium działa na różnych systemach operacyjnych, takich jak Windows, Linux, macOS, co pozwala na testowanie aplikacji na różnych platformach.  
Dzięki Selenium Java możliwe jest tworzenie skryptów testowych, które automatyzują interakcje użytkownika z aplikacją internetową w sposób programatyczny. Jest to niezwykle przydatne narzędzie do automatyzacji testów w środowiskach Agile, DevOps i Continuous Integration (CI), gdzie szybkość, skuteczność i niezawodność testów są kluczowe.*
2. **Selenium Support**  
*Główną zaletą Selenium Support, o której dowiedziałem się na kursie, jest to, że dodaje nam obsługę pól typu drop-down.  
Dependency o nazwie "Selenium Support" to część biblioteki Selenium, która zawiera narzędzia i funkcje pomocnicze, które ułatwiają automatyzację testów interfejsu użytkownika (UI) w aplikacjach internetowych.  
Oto kilka głównych funkcji, za które odpowiada "Selenium Support":  
`Wsparcie dla różnych elementów interfejsu użytkownika:` "Selenium Support" zapewnia narzędzia i funkcje pomocnicze do interakcji z różnymi elementami interfejsu użytkownika, takimi jak przyciski, pola tekstowe, listy rozwijane, checkboxy, radio buttony, elementy tabel itp.  
`Manipulacja oknami przeglądarki:` Biblioteka ta umożliwia otwieranie, zamykanie, przełączanie między oknami i zakładkami przeglądarki internetowej, co jest przydatne w przypadku testów wymagających interakcji z wieloma oknami.  
`Obsługa alertów i potwierdzeń:` Selenium Support pozwala na obsługę alertów, potwierdzeń i promptów, które mogą pojawić się podczas interakcji z aplikacją internetową.  
`Czekanie na warunki:` Biblioteka ta dostarcza funkcje, które pozwalają czekać na określone warunki, takie jak pojawienie się elementu na stronie, zmiana wartości pola tekstowego, czy zakończenie ładowania strony.  
`Obsługa ramek i iframe'ów:` Selenium Support umożliwia przełączanie się między różnymi ramkami (frame'ami) i iframe'ami na stronie internetowej, co jest niezbędne w przypadku testów, które wymagają interakcji z elementami znajdującymi się w różnych ramkach.  
"Selenium Support" jest kluczową częścią biblioteki Selenium, która dostarcza programistom narzędzia i funkcje pomocnicze do efektywnej automatyzacji testów interfejsu użytkownika w aplikacjach internetowych. Dzięki temu programiści mogą pisać bardziej stabilne, czytelne i niezawodne testy UI.*
3. **WebDriverManager**  
*Dependency o nazwie "WebDriverManager" to narzędzie, które ułatwia zarządzanie i automatyczne pobieranie niezbędnych binarnych plików (driverów) do obsługi różnych przeglądarek internetowych podczas korzystania z biblioteki Selenium WebDriver w języku Java.  
Oto główne funkcje, za które odpowiada "WebDriverManager":  
`Automatyczne pobieranie i zarządzanie driverami:` "WebDriverManager" automatycznie pobiera niezbędne binarne pliki (drivery) dla wybranej przeglądarki internetowej (np. Chrome, Firefox, Edge, Safari) oraz odpowiednią wersję w zależności od konfiguracji i wymagań projektu.  
`Aktualizacje i zarządzanie wersjami:` Narzędzie to zapewnia aktualizacje i zarządzanie wersjami driverów, co pozwala na łatwe utrzymanie i aktualizowanie driverów w projekcie.  
`Integracja z różnymi narzędziami budowania:` "WebDriverManager" jest łatwy w integracji z różnymi narzędziami budowania, takimi jak Maven, Gradle, czy inne, co pozwala na automatyczne zarządzanie driverami w procesie budowania projektu.  
`Obsługa wielu platform:` Narzędzie to obsługuje różne platformy, takie jak Windows, Linux, macOS, co umożliwia korzystanie z niego w różnych środowiskach.  
Dzięki "WebDriverManager" programiści mogą uniknąć ręcznego pobierania, aktualizowania i zarządzania driverami przeglądarek, co pozwala zaoszczędzić czas i zapewnia bardziej spójne i niezawodne środowisko testowe. Jest to szczególnie przydatne w projektach wykorzystujących Selenium WebDriver do automatyzacji testów interfejsu użytkownika w aplikacjach internetowych.*

#### Backend