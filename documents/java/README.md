# ☕Java - notatki

## 📑Spis

1. [Builder](#1)
2. TODO: JavaFaker
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
6. Można też coś utworzyć na sztywno
7. Można też tworzyć coś pobierając dane z bazy danych

Przykładowy kod jest w linku lub zastosowany tutaj:
- `java` -> `models` -> `TableRow`
- `java` -> `providers` -> `TableRowProvider`