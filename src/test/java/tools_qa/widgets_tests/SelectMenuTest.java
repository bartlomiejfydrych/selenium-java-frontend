package tools_qa.widgets_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools_qa.base.TestBase;
import tools_qa.pages.commons.HomePage;
import tools_qa.pages.commons.TrainingPage;
import tools_qa.pages.normal.widgets_pages.SelectMenuPage;
import tools_qa.pages.normal.widgets_pages.WidgetsPage;

import java.util.Arrays;
import java.util.List;

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

        List<String> valueListInSelectValue = Arrays.asList(
                "Group 1, option 1",
                "Group 1, option 2",
                "Group 2, option 1",
                "Group 2, option 2",
                "A root option",
                "Another root option"
        );
        String valueToSelect = selectMenuPage.getRandomElementFromList(valueListInSelectValue);

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

    }

    @Test
    public void shouldSelectValueInOldStyleSelectMenu() {

    }

    @Test
    public void shouldSelectValueInMultiSelectDropDown() {

    }

    @Test
    public void shouldSelectValueInStandardMultiSelect() {

    }
}
