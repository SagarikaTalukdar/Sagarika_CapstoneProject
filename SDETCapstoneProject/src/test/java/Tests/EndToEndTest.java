package Tests;

import org.json.JSONObject;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.AutomationPracticePage;
import Utilities.JsonReader;

public class EndToEndTest extends BaseTest {

	@Test
	public void completeAutomation() throws Exception {

        JSONObject data =
                JsonReader.getData();

        AutomationPracticePage page =
                new AutomationPracticePage(driver);

        page.fillForm(data);
        Thread.sleep(2000);

        page.handleDropdownsAndDatePickers(data);
        Thread.sleep(2000);

        page.handleActionsAndUpload(data);
        Thread.sleep(2000);

        page.handleTablesAndLinks();
        Thread.sleep(2000);

        page.handlePaginationShadowDomAndFooter();
        Thread.sleep(2000);

        System.out.println(
                "Automation Completed Successfully");
    }
}