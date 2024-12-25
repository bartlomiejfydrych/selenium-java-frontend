package tools_qa.pages.normal.elements_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tools_qa.pages.base.BasePage;

import java.util.List;

public class CheckboxPage extends BasePage {

    // -----------
    // CONSTRUCTOR
    // -----------

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Buttons
    @FindBy(css = "button[title='Expand all']")
    private WebElement plusExpandAllButton;
    @FindBy(css = "button[title='Collapse all']")
    private WebElement minusCollapseAllButton;
    // Result
    @FindBy(css = "#result")
    private WebElement resultTextField;
    // Checkboxes
    @FindBy(css = "label[for^='tree-node']")
    private List<WebElement> allCheckboxButtons;
    @FindBy(css = "label[for^='tree-node'] input")
    private List<WebElement> allCheckboxInputsForAssert;

    // -------
    // METHODS
    // -------

    // Buttons methods

    public CheckboxPage clickExpandAll() {
        plusExpandAllButton.click();
        return this;
    }

    public CheckboxPage clickCollapseAll() {
        minusCollapseAllButton.click();
        return this;
    }

    // Checkboxes methods

    public CheckboxPage clickCheckbox(String checkboxName) {
        allCheckboxButtons.stream()
                .filter(label -> label.getDomAttribute("for").endsWith(checkboxName))
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }

    public boolean isCheckboxSelected(String checkboxName) {
        return allCheckboxInputsForAssert.stream()
                .filter(input -> input.getDomAttribute("id").equals("tree-node-" + checkboxName))
                .findFirst()
                .map(WebElement::isSelected)
                .orElse(false);
    }

    public boolean isCheckboxDisplayed(String checkboxName) {
        return allCheckboxInputsForAssert.stream()
                .filter(input -> input.getDomAttribute("id").equals("tree-node-" + checkboxName))
                .findFirst()
                .map(WebElement::isDisplayed)
                .orElse(false);
    }

    // -------
    // GETTERS
    // -------

    public WebElement getResultTextField() {
        return resultTextField;
    }
}

/*

-------------
NOTES FOR ME:
-------------

public CheckboxPage clickCheckbox(String checkboxName) {
    allCheckboxButtons.stream()
            .filter(label -> label.getDomAttribute("for").endsWith(checkboxName))
            .findFirst()
            .ifPresent(WebElement::click);
    return this;
}

Metoda clickCheckbox jest odpowiedzialna za kliknięcie checkboxa, którego atrybut for kończy się na podaną wartość
checkboxName. Oto szczegółowe wyjaśnienie:

DZIAŁANIE KROK PO KROKU:

1. allCheckboxButtons.stream()
Co to robi? Tworzy strumień (Stream) z kolekcji allCheckboxButtons.

allCheckboxButtons to lista elementów WebElement, która zawiera etykiety <label> reprezentujące checkboxy na stronie.
Dlaczego używamy strumienia? Strumienie pozwalają operować na danych w sposób deklaratywny i łatwiejszy do
odczytania, np. filtrować, mapować czy znajdować elementy w kolekcjach.

2. .filter(label -> label.getDomAttribute("for").endsWith(checkboxName))
Co to robi? Filtruje strumień, pozostawiając tylko te elementy, których atrybut for kończy się na wartość checkboxName.

Jak działa label.getDomAttribute("for")?
Metoda getDomAttribute pobiera wartość atrybutu for z danego elementu label.
Przykład: Jeśli checkbox ma <label for="tree-node-workspace">, to getDomAttribute("for") zwróci "tree-node-workspace".

Co robi .endsWith(checkboxName)?
Sprawdza, czy pobrana wartość for kończy się wartością przekazaną jako argument checkboxName.

Dlaczego stosujemy .endsWith zamiast equals?
Atrybut for może zawierać dodatkowy prefiks (np. tree-node-), więc sprawdzamy, czy końcówka zgadza się z nazwą checkboxa.

3. .findFirst()
Co to robi?
Przerywa przeszukiwanie strumienia, gdy znajdzie pierwszy pasujący element.
Zwraca go jako obiekt Optional<WebElement>, co oznacza, że element może istnieć lub nie.

4. .ifPresent(WebElement::click)
Co to robi?
Jeśli element został znaleziony (czyli Optional nie jest pusty), wykonuje na nim akcję kliknięcia.
WebElement::click to referencja do metody click obiektu WebElement.

-------------------------------------------
CO ROBI:
.map(WebElement::isDisplayed).orElse(false)
-------------------------------------------

PODSUMOWANIE:
Cel: Pobranie przekształconej wartości lub domyślnej
Transformacja wartości: Transformuje wartość (isDisplayed)
Typ zwracany: Wynik transformacji (boolean)
Przeznaczenie: Wywoływanie metod zwracających wynik (np. isDisplayed)

Działanie:
Cel: Transformuje wartość zawartą w Optional, a jeśli wartość nie istnieje, zwraca domyślną wartość.

Zachowanie:
Jeśli wartość istnieje, wywołuje podaną metodę (isDisplayed) i zwraca jej wynik.
Jeśli wartość nie istnieje, zwraca domyślną wartość przekazaną do .orElse().

Gdy wartość istnieje:
Wywołuje isDisplayed na someWebElement i zwraca wynik (np. true lub false).

Gdy wartość jest pusta (null):
Zwraca wartość domyślną, czyli false.

*/
