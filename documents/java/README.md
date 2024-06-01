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
