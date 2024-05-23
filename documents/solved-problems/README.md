# 💥Rozwiązane problemy

## 📑Spis

1. [Przycisk zasłonięty przez inny element strony](#1)
2. [Przyciski zasłonięte przez reklamę - usunięcie elementu strony](#2)
3. [Brak dostępu do prywatnego WebElementu na potrzeby Asercji w teście](#3)
4. [Sprawdzanie czy element nie jest widoczny - błąd znajdowania elementu](#4)
5. [Przycisk - widoczny, ale wewnątrz innego elementu](#5)
6. [Przycisk - czy element jest klikalny](#6)

## 📄Opis

### 1. Przycisk zasłonięty przez inny element strony <a name="1"></a>

**Linki:**  
[Dlaczego kliknięcia Selenium nie działają](https://www.lucidchart.com/techblog/2020/01/21/why-selenium-clicks-fail/)  
[Wait - element_to_be_clickable()](https://stackoverflow.com/questions/48665001/can-not-click-on-a-element-elementclickinterceptedexception-in-splinter-selen)  
[Jak użyć JavaScript w języku Java](https://stackoverflow.com/questions/11430773/how-to-use-javascript-with-selenium-webdriver-java)  
Dodatkowe:  
https://stackoverflow.com/questions/75412264/how-to-use-click-function-of-selenium-in-case-of-button-attribute-in-html  
https://stackoverflow.com/questions/54192441/how-to-click-link-being-covered-by-another-element-python-3-6-and-selenium

Podczas testów strony [Tools QA](https://demoqa.com/) okazało się, że wyskakujące reklamy zasłaniają przycisk **\[Submit\]**.
Przy standardowych próbach kliknięcia był zwracany błąd, że kolejny oczekiwany element po tym kliknięciu nie istnieje.
Po dodaniu *wait'a*, który miał czekać, aż element będzie klikalny, zaczął być zwracany komunikat z błędem informujący, że
element nie mógł zostać kliknięty, ponieważ został zasłonięty przez inny element (oraz wymieniono jego nazwę).
![](images/1_przycisk_zasloniety.png)
Ostatecznie okazało się, że najlepszym sposobem jest użycie JavaScriptu, ponieważ ma on zdolność "omijania" przysłaniających
elementów strony.  
Można jego obiekt inicjować w `BasePage` dzięki czemu będziemy mieli do niego łatwiejszy dostęp, jakbyśmy musieli używać go
dla wielu metod klikających.  
Wydaje mi się, że można by próbować jeszcze zasymulować naciśniecie klawisza **\[PgDn\]**, który by przewinął całą stronę
niżej, po czym moglibyśmy kliknąć odsłonięty przycisk.

Próba 1 - użycie 'actions'

```
actions.moveToElement(this.submitButton).click().perform();
lub
actions.scrollToElement(this.submitButton).click().perform();
```

Próba 2 - dodanie zwykłego wait'a

`driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));`

Próba 3 - napisanie wait'a, który czeka aż element będzie klikalny

`defaultWait.until(ExpectedConditions.elementToBeClickable(this.submitButton)).click();`

Próba 4 - użycie JavaScript

```
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("arguments[0].click();", this.submitButton);
```

### 2. Przyciski zasłonięte przez reklamę - usunięcie elementu strony <a name="2"></a>

**Linki:**  
https://stackoverflow.com/questions/70222166/how-do-i-remove-an-element-in-selenium-python

Podczas testów strony [Tools QA](https://demoqa.com/) okazało się, że wyskakująca reklama na dole strony blokuje wszystkie
przyciski na każdej pod-stronie. Samo omijanie tego tak jak to zrobiono w punkcie wyżej, nie wystarczyło.
![](images/2_usuniecie_elementu.png)
Postanowiłem usuwać tego DIV'a przy każdym wejściu na tę stronę.  
Użyłem poniższego kodu:  
`jse.executeScript("arguments[0].remove();", adFrame);`

### 3. Brak dostępu do prywatnego WebElementu na potrzeby Asercji w teście <a name="3"></a>

**Linki:**  
https://www.w3schools.com/java/java_encapsulation.asp

Pisząc testy, trzymałem się założenia, że asercje powinny być w testach, a nie w metodach page'y.
Gdy chciałem w teście sprawdzić stan danego WebElementu to nie mogłem tego zrobić, ponieważ w klasie Page został on
zadeklarowany jako prywatny.  
Rozwiązaniem tego okazało się napisanie Gettera:
```
Klasa z Page:
@FindBy(css = "label[for='tree-node-home'] input")
private WebElement assertHomeCheckBox;

public WebElement getAssertHomeCheckBox() {
    return assertHomeCheckBox;
}

Klasa z testem:
assertThat(checkBoxPage.getAssertHomeCheckBox().isSelected()).isTrue();
```

### 4. Sprawdzanie czy element nie jest widoczny - błąd znajdowania elementu <a name="4"></a>

**Linki:**
https://stackoverflow.com/a/62684271

W teście chciałem sprawdzić czy dany element nie jest już widoczny.  
Asercja, która to miała sprawdzać, zwracała błąd, ponieważ już na początkowym etapie WebElement nie był odnajdywany.  
Rozwiązaniem tego było napisanie takiej, ogólnodostępnej funkcji:
```
public class WebElementMethods {

    public boolean isElementPresent(WebElement webElement) {
        try{
            webElement.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    };
}

Asercja w teście:
assertThat(webElementMethods.isElementPresent(desktopCheckBox)).isFalse();
```

### 5. Przycisk - widoczny, ale wewnątrz innego elementu <a name="5"></a>

**Linki:**
https://stackoverflow.com/a/19763087

![](images/5_przycisk_zasloniety_widoczny.png)
Jeżeli przycisk jest **widoczny** na stronie, ale znajduje się wewnątrz innego elementu to można użyć `Actions`:
```
public RadioButtonPage clickYesRadioButton() {
    actions.moveToElement(this.yesRadioButton).click().perform();
    return this;
}
```

### 6. Przycisk - czy element jest klikalny <a name="6"></a>

![](images/6_przycisk_klikalny.png)
Przy próbie kliknięcia przycisku, który nie jest klikalny, zwracany jest błąd.  
Żeby takie coś sprawdzać, warto napisać i stosować poniższą metodę:
```
public boolean isElementClickable(WebElement webElement) {
    try {
        actions.moveToElement(webElement).click().perform();
        return true;
    } catch (JsonException e) {
        return false;
    }
}

Test:
assertThat(webElementMethods.isElementClickable(noRadioButton)).isFalse();
```
