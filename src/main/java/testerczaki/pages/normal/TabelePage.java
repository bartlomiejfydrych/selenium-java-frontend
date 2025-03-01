package testerczaki.pages.normal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.models_providers.tabele_models.TabeleData;
import testerczaki.pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class TabelePage extends BasePage {

    // https://dawidkaruga.pl/testerczaki/tabele

    // -----------
    // CONSTRUCTOR
    // -----------

    public TabelePage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    @FindBy(css = "#table1 tr") // All table rows (except header)
    private List<WebElement> tableRows;
    @FindBy(css = "#avg")
    private WebElement sredniaInput;
    @FindBy(css = "#age")
    private WebElement wiekInput;
    @FindBy(css = "#name")
    private WebElement imieInput;
    @FindBy(css = "#submit1")
    private WebElement sprawdzButton;
    @FindBy(css = "#alert1")
    private WebElement alert;

    // -------
    // METHODS
    // -------

    // Table

    // Reads data from a table and returns it as a list of TabeleData objects
    public List<TabeleData> getDataFromTable() {
        return tableRows.stream()
                .map(tableRow -> {
                    List<WebElement> columns = tableRow.findElements(By.tagName("td"));
                    return new TabeleData(
                            columns.get(0).getText(),
                            Integer.parseInt(columns.get(1).getText()),
                            columns.get(2).getText()
                    );
                })
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<TabeleData> tableData) {
        return tableData.stream()
                .mapToDouble(TabeleData::getWiek)
                .average()
                .orElse(0);
    }

    public int getAgeForName(List<TabeleData> tableData, String imie) {
        return tableData.stream()
                .filter(person -> person.getImie().equals(imie))
                .map(TabeleData::getWiek)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No person by name found: " + imie));
    }

    public String getNameOfCityResident(List<TabeleData> tableData, String miasto) {
        return tableData.stream()
                .filter(person -> person.getMiasto().equals(miasto))
                .map(TabeleData::getImie)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No resident of the city found: " + miasto));
    }

    // Others

    public TabelePage writeSrednia(double srednia) {
        sredniaInput.sendKeys(Double.toString(srednia));
        return this;
    }

    public TabelePage writeWiek(int wiek) {
        wiekInput.sendKeys(Integer.toString(wiek));
        return this;
    }

    public TabelePage writeImie(String imie) {
        imieInput.sendKeys(imie);
        return this;
    }

    public TabelePage clickSprawdzButton() {
        sprawdzButton.click();
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getAlert() {
        return alert;
    }
}

/*

-------------
NOTES FOR ME:
-------------

Nice data printer from object:

    tableData.forEach(d -> System.out.println("Imię: " + d.getImie() + ", Wiek: " + d.getWiek()));

Code before refactor:

    By rowSelector = By.cssSelector("td");

    String wiekJanusza = "";
    String imieWarszawiaka = "";
    double srednia = 0.0;
    int sum = 0;

    public void odczytajDaneTabeli() {
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(rowSelector);
            WebElement imie = cells.get(0);
            WebElement wiek = cells.get(1);
            WebElement miasto = cells.get(2);
            sum += Integer.parseInt(wiek.getText());

            if (imie.getText().equals("Janusz")) wiekJanusza = wiek.getText();
            if (miasto.getText().equals("Warszawa")) imieWarszawiaka = imie.getText();

            srednia = (double) sum / (double) rows.size();
        }
    }

*/
