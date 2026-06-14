package Tests;

import org.json.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.AutomationPracticePage;
import Utilities.JsonReader;
import Utilities.TestListener;

@Listeners(TestListener.class)

public class EndToEndTest extends BaseTest {

    @Test
    public void completeAutomation() throws Exception {

        JSONObject data =
                JsonReader.getData();

        AutomationPracticePage page =
                new AutomationPracticePage(driver);

        page.fillForm(data);

        page.handleDropdownsAndDatePickers(data);

        page.handleActionsAndUpload(data);

        page.handleTablesAndLinks();

        page.handlePaginationShadowDomAndFooter();

        System.out.println(
                "Test Execution Completed");
    }
}