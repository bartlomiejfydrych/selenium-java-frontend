package testerczaki.pages.normal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testerczaki.pages.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class PrzeciagnijUpuscPage extends BasePage {

    // https://dawidkaruga.pl/testerczaki/przeciagnij

    // -----------
    // CONSTRUCTOR
    // -----------

    public PrzeciagnijUpuscPage(WebDriver driver) {
        super(driver);
    }

    // ------------
    // WEB ELEMENTS
    // ------------

    // Zadanie 1
    @FindBy(css = "#simpleList1 li")
    private List<WebElement> z1ElementyList;
    @FindBy(css = "#simpleList2")
    private WebElement z1GrupaBListGroup;
    @FindBy(css = "#alert1")
    private WebElement z1Alert;
    // Zadanie 2
    @FindBy(css = "#simpleList3 .list-group-item")
    private List<WebElement> z2ElementyList;
    @FindBy(css = "#alert2")
    private WebElement z2Alert;
    // Zadanie 3
    @FindBy(css = "#simpleList4 > li")
    private List<WebElement> z3ElementyList;
    @FindBy(css = "#test1")
    private WebElement z3Element1X;
    @FindBy(css = "#test2")
    private WebElement z3Element2X;
    @FindBy(css = "#simpleList5")
    private WebElement z3GrupaYListGroup;
    @FindBy(css = "#alert3")
    private WebElement z3Alert;

    // -------
    // METHODS
    // -------

    // Zadanie 1

    public PrzeciagnijUpuscPage z1MoveElementyToGrupaB() {
        for (WebElement element : z1ElementyList) {
            actions.dragAndDrop(element, z1GrupaBListGroup).perform();
        }
        return this;
    }

    // Zadanie 2

    public PrzeciagnijUpuscPage z2SortElementy() {
        // We sort the elements by the "data-order" attribute descending (from 5 to 1)
        List<WebElement> sortedElements = z2ElementyList.stream()
                .sorted((a, b) -> Integer.compare(
                        Integer.parseInt(b.getDomAttribute("data-order")),
                        Integer.parseInt(a.getDomAttribute("data-order"))
                ))
                .collect(Collectors.toList());
        // We move the elements to their places
        for (WebElement element : sortedElements) {
            actions.clickAndHold(element).perform(); // We hold the element
            // We move the element in 10 small steps
            for (int i = 0; i < 10; i++) {
                actions.moveByOffset(0, -30).perform();
                try {
                    Thread.sleep(50); // Short delay for smooth movement
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            actions.release().perform(); // We drop the element
        }
        return this;
    }

    // Zadanie 3

    public PrzeciagnijUpuscPage z3MoveElementyToGrupaY() {
        String jsScript = """
                function triggerDragAndDrop(source, target) {
                    var dataTransfer = new DataTransfer();
                    var dragStartEvent = new DragEvent('dragstart', { bubbles: true, cancelable: true, dataTransfer: dataTransfer });
                    source.dispatchEvent(dragStartEvent);
                
                    var dragOverEvent = new DragEvent('dragover', { bubbles: true, cancelable: true, dataTransfer: dataTransfer });
                    target.dispatchEvent(dragOverEvent);
                
                    var dropEvent = new DragEvent('drop', { bubbles: true, cancelable: true, dataTransfer: dataTransfer });
                    target.dispatchEvent(dropEvent);
                
                    var dragEndEvent = new DragEvent('dragend', { bubbles: true, cancelable: true, dataTransfer: dataTransfer });
                    source.dispatchEvent(dragEndEvent);
                }
                """;
        for (WebElement element : z3ElementyList) {
            jse.executeScript(jsScript + "triggerDragAndDrop(arguments[0], arguments[1]);", element, z3GrupaYListGroup);
        }
        return this;
    }

    // -------
    // GETTERS
    // -------

    public WebElement getZ1Alert() {
        return z1Alert;
    }

    public WebElement getZ2Alert() {
        return z2Alert;
    }

    public WebElement getZ3Alert() {
        return z3Alert;
    }
}

/*

---------
MY NOTES:
---------

ZADANIE 2 - method before refactor

    public PrzeciagnijUpuscPage posortujElementy() {
        List<WebElement> listOfAllWebElements = new ArrayList<>();
        for (int i = 5; i >= 1; i--) {
            listOfAllWebElements.add(driver.findElement(By.cssSelector("[data-order=\"" + i + "\"]")));
        }
        for (WebElement element : listOfAllWebElements) {
            Actions smoothMove = action.clickAndHold(element);
            for (int e = 0; e < 10; e++) {
                smoothMove.moveByOffset(0, -30);
            }
            smoothMove.release().perform();
        }
        return this;
    }

ZADANIE 3 - method before refactor

    public PrzeciagnijUpuscPage z3MoveElementyToGrupaY() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        File file = new File("src/test/resources/drag_and_drop_helper.js");

        String script = null;
        try {
            script = readFile(file.getAbsolutePath())
                    + "\nsimulateHTML5DragAndDrop(arguments[0], arguments[1])";
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (WebElement element : elementyZadanie3) {
            javascriptExecutor.executeScript(script, element, grupaY);
        }
        return this;
    }

    private static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

File - drag_and_drop_helper.js

    function createEvent(typeOfEvent) {
        var event = document.createEvent("CustomEvent");
        event.initCustomEvent(typeOfEvent, true, true, null);
        event.dataTransfer = {
            data: {},
            setData: function (key, value) {
                this.data[key] = value;
            },
            getData: function (key) {
                return this.data[key];
            }
        };
        return event;
    }
    function dispatchEvent(element, event, transferData) {
        if (transferData !== undefined) {
            event.dataTransfer = transferData;
        }
        if (element.dispatchEvent) {
            element.dispatchEvent(event);
        } else if (element.fireEvent) {
            element.fireEvent("on" + event.type, event);
        }
    }
    function simulateHTML5DragAndDrop(element, target) {
        element.scrollIntoView();
        var dragStartEvent = createEvent('dragstart');
        dispatchEvent(element, dragStartEvent);
        var dropEvent = createEvent('drop');
        dispatchEvent(target, dropEvent, dragStartEvent.dataTransfer);
        var dragEndEvent = createEvent('dragend');
        dispatchEvent(element, dragEndEvent, dropEvent.dataTransfer);
    }

*/
