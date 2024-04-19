# 📚Notatki - zapisuję tu wszystko, co może się przydać i z czym miałem problemy

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
Służy do generowania plików .gitignore np. gotowy plik ignorujący wszystkie zbędne pliki pod Javę.  
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
Lepiej i wyraźniej koloruje nam nawiasy niż standardowo robi to IDE.
3. **Key Promoter X**  
Służy do nauki skrótów klawiszowych jakie znajdują się w IDE.
4. **Lombok** (Dla testów API)  
Uwaga! Żeby z tego korzystać trzeba również do Mavena dodać dependencies z Lomboka.  
Lombok to biblioteka dla języka Java, która ma na celu uproszczenie pisania kodu poprzez automatyzację generowania standardowych fragmentów kodu, takich jak gettery, settery, konstruktory, metody equals(), hashCode() i inne.  
Dodatkowo posiada adnotację @Builder, która jest przydatna w testach API, gdy chcemy zbudować body responsa na podstawie klasy.