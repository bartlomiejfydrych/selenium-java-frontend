# ✅Selenium i testy — notatki

## 📑Spis treści

- [Wzorzec Arrange-Act-Assert](#AAA)

---

## Wzorzec Arrange-Act-Assert <a name="AAA"></a>

**Linki:**  
https://automationpanda.com/2020/07/07/arrange-act-assert-a-pattern-for-writing-good-tests/

### Opis

Wzorzec *Arrange-Act-Assert* to świetny sposób na ustrukturyzowanie przypadków testowych.  
Określa kolejność operacji:
1. **Arrange — Uporządkuj** dane wejściowe i cele.  
Może zawierać:
   - Zmienne
   - Obiekty
   - Ustawienia
   - Dane / Przygotowanie bazy danych
   - Zalogowanie się do aplikacji
2. **Act — Działaj** zgodnie z zachowaniem docelowym.  
Składa się z kroków, podczas których wykonywany jest test.  
Może zawierać:
    - Wywoływane metody / funkcje
    - Wywołanie interfejsu API REST
    - Interakcje ze stroną internetową
3. **Assert — Potwierdź** oczekiwane wyniki.  
Wcześniej wykonane kroki powinny wywołać jakiś rodzaj odpowiedzi.  
Asercje te ostatecznie mają określać czy test zostanie zaliczony, czy nie.  
Może zawierać:
    - Asercje sprawdzające, czy otrzymany zestaw danych jest zgodny z oczekiwanym
    - Inne elementy, które mają sprawdzać wiele aspektów systemu

### Ciekawostka

*Behavior-Driven Development* podąża za wzorcem *Arrange-Act-Assert* pod inną nazwą: **Given-When-Then**.
Język Gherkin używa kroków *Given-When-Then* do określania zachowań w scenariuszach. *Given-When-Then* jest zasadniczo
tym samym wzorem co *Arrange-Act-Assert*.

### Przykład

Przykład z internetu:
```Python
import requests
 
def test_duckduckgo_instant_answer_api_search():
 
  # Arrange
  url = 'https://api.duckduckgo.com/?q=python+programming&format=json'
   
  # Act
  response = requests.get(url)
  body = response.json()
   
  # Assert
  assert response.status_code == 200
  assert 'Python' in body['AbstractText']
```

Przykład używany przeze mnie:
```Java
@Test
public void shouldOpenHomeLinkInNewTab() {

    //--------
    // ARRANGE
    //--------

    String expectedUrl = "https://demoqa.com/";

    //----
    // ACT
    //----

    new HomePage(driver)
            .goToElementsPage()
            .removeAdFrameAndFooter()
            .goToLinksPage()
            .clickNewTabHomeLink()
            .switchTab(1);

    //-------
    // ASSERT
    //-------

    assertThat(driver.getCurrentUrl()).isEqualTo(expectedUrl);
}
```
