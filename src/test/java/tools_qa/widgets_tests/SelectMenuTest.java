package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.SelectMenuPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectMenuTest extends TestBase {

    HomePage homePage;
    TrainingPage trainingPage;
    WidgetsPage widgetsPage;
    SelectMenuPage selectMenuPage;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        trainingPage = new TrainingPage(driver);
        widgetsPage = new WidgetsPage(driver);
        selectMenuPage = new SelectMenuPage(driver);
    }

    @Test
    public void shouldSelectValueInSelectValue() {

        // -------
        // ARRANGE
        // -------

        List<String> valueList = Arrays.asList(
                "Group 1, option 1",
                "Group 1, option 2",
                "Group 2, option 1",
                "Group 2, option 2",
                "A root option",
                "Another root option"
        );
        String valueToSelect = selectMenuPage.getRandomElementFromList(valueList);

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToSelectMenuPage();

        selectMenuPage.selectValueInSelectValue(valueToSelect);

        // ------
        // ASSERT
        // ------

        assertThat(selectMenuPage.getSelectValueValue().getText()).isEqualTo(valueToSelect);
    }

    @Test
    public void shouldSelectValueInSelectOne() {

        // -------
        // ARRANGE
        // -------

        List<String> valueList = Arrays.asList(
                "Dr.",
                "Mr.",
                "Mrs.",
                "Ms.",
                "Prof.",
                "Other"
        );
        String valueToSelect = selectMenuPage.getRandomElementFromList(valueList);

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToSelectMenuPage();

        selectMenuPage.selectValueInSelectOne(valueToSelect);

        // ------
        // ASSERT
        // ------

        assertThat(selectMenuPage.getSelectOneValue().getText()).isEqualTo(valueToSelect);
    }

    @Test
    public void shouldSelectValueInOldStyleSelectMenu() {

        // -------
        // ARRANGE
        // -------

        List<String> valueList = Arrays.asList(
                "Red",
                "Blue",
                "Green",
                "Yellow",
                "Purple",
                "Black",
                "White",
                "Voilet", // They wrote it incorrectly on the website again
                "Indigo",
                "Magenta",
                "Aqua"
        );
        String valueToSelect = selectMenuPage.getRandomElementFromList(valueList);

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToSelectMenuPage();

        selectMenuPage.selectValueInOldStyleSelectMenu(valueToSelect);

        // ------
        // ASSERT
        // ------

        Select select = new Select(selectMenuPage.getOldStyleSelectMenuSelect());
        assertThat(select.getFirstSelectedOption().getText()).isEqualTo(valueToSelect);
    }

    @Test
    public void shouldSelectValueInMultiSelectDropDown() {

        // -------
        // ARRANGE
        // -------

        List<String> valueList = Arrays.asList(
                "Green",
                "Blue",
                "Black",
                "Red"
        );
        List<String> valuesToSelectList = selectMenuPage.getRandomElementsFromList(valueList);

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToSelectMenuPage();

        selectMenuPage.selectValueInMultiSelectDropDown(valuesToSelectList);

        // ------
        // ASSERT
        // ------

        List<WebElement> selectedValuesList = selectMenuPage.getMultiSelectDropDownValue();
        for (int i = 0; i < selectedValuesList.size(); i++) {
            assertThat(selectedValuesList.get(i).getText()).isEqualTo(valuesToSelectList.get(i));
        }
    }

    @Test
    public void shouldSelectValueInStandardMultiSelect() {

        // -------
        // ARRANGE
        // -------

        List<String> valueList = Arrays.asList(
                "Volvo",
                "Saab",
                "Opel",
                "Audi"
        );
        List<String> valuesToSelectList = selectMenuPage.getRandomElementsFromList(valueList);
        Set<String> valuesToSelectSet = new HashSet<>(valuesToSelectList);

        // ---
        // ACT
        // ---

        homePage.goToWidgetsPage();

        trainingPage.removeFooterAndAds();

        widgetsPage.goToSelectMenuPage();

        selectMenuPage.selectValueInStandardMultiSelect(valuesToSelectList);

        // ------
        // ASSERT
        // ------

        Select select = new Select(selectMenuPage.getStandardMultiSelectSelect());
        List<WebElement> selectedValuesList = select.getAllSelectedOptions();
        Set<String> selectedValuesSet = selectedValuesList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toSet());
        assertThat(selectedValuesSet).isEqualTo(valuesToSelectSet);
    }
}
