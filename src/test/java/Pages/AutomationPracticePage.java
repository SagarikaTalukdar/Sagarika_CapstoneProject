package Pages;

import java.util.List;
import org.openqa.selenium.Keys;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
public class AutomationPracticePage {

    WebDriver driver;

    public AutomationPracticePage(WebDriver driver) {

        this.driver = driver;
    }

    public void fillForm(JSONObject data) {

        driver.findElement(By.id("name"))
                .sendKeys(data.getString("name"));

        driver.findElement(By.id("email"))
                .sendKeys(data.getString("email"));

        driver.findElement(By.id("phone"))
                .sendKeys(data.getString("phone"));

        driver.findElement(By.id("textarea"))
                .sendKeys(data.getString("address"));

        // Gender

        driver.findElement(By.id("male"))
                .click();

        // Days

        driver.findElement(By.id("monday"))
                .click();

        driver.findElement(By.id("wednesday"))
                .click();

        driver.findElement(By.id("friday"))
                .click();

        // Country

        Select country =
                new Select(driver.findElement(
                        By.id("country")));

        country.selectByVisibleText(
                data.getString("country"));

        System.out.println(
                "Form Section Completed");
        
        //Alert
        
        driver.findElement(By.id("alertBtn")).click();         
        driver.switchTo().alert().accept();
        
        driver.findElement(By.id("confirmBtn")).click();         
        driver.switchTo().alert().accept();
        
        driver.findElement(By.id("promptBtn")).click();         
        driver.switchTo().alert().accept();
    }
    
    public void handleDropdownsAndDatePickers(JSONObject data) {

        try {

            // Colors Multi Select

            Select colors = new Select(
                    driver.findElement(By.id("colors")));

            colors.selectByVisibleText("Red");
            colors.selectByVisibleText("Blue");
            colors.selectByVisibleText("Green");

            // Sorted List

            Select animals = new Select(
                    driver.findElement(By.id("animals")));

            animals.selectByVisibleText("Cat");
            animals.selectByVisibleText("Dog");

            // Date Picker 1

            driver.findElement(By.id("datepicker"))
                    .sendKeys(data.getString("datePicker1"));

            System.out.println("Date Picker 1 Completed");

            // Date Picker 2

            WebElement dp2 =
                    driver.findElement(By.id("txtDate"));

            ((JavascriptExecutor) driver)
                    .executeScript(
                    "arguments[0].removeAttribute('readonly')",
                    dp2);

            dp2.clear();

            dp2.sendKeys(
                    data.getString("datePicker2"));

            System.out.println(
                    "Date Picker 2 Completed");
            // Date Picker 3

            try {

    WebElement startDate =
            driver.findElement(
            By.id("start-date"));

    WebElement endDate =
            driver.findElement(
            By.id("end-date"));

    startDate.clear();
    startDate.sendKeys(
            data.getString("startDate"));

    Thread.sleep(1000);

    endDate.clear();
    endDate.sendKeys(
            data.getString("endDate"));

    Thread.sleep(1000);

    driver.findElement(
            By.xpath("//button[text()='Submit']"))
            .click();

    System.out.println(
            "Date Range Completed");

} catch(Exception e) {

    System.out.println(
            "Date Range Failed");

    e.printStackTrace();
}

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    public void handleActionsAndUpload(JSONObject data) {

        Actions actions = new Actions(driver);

        // Double Click

        try {

            WebElement copyButton =
                    driver.findElement(
                    By.xpath("//button[text()='Copy Text']"));

            actions.doubleClick(copyButton)
                    .perform();

            System.out.println(
                    "Double Click Completed");

        } catch(Exception e) {

            System.out.println(
                    "Double Click Failed");
        }

        // Drag And Drop

        try {

            WebElement source =
                    driver.findElement(
                    By.id("draggable"));

            WebElement target =
                    driver.findElement(
                    By.id("droppable"));

            actions.dragAndDrop(
                    source,
                    target)
                    .perform();

            System.out.println(
                    "Drag And Drop Completed");

        } catch(Exception e) {

            System.out.println(
                    "Drag And Drop Failed");
        }

        // Slider

        try {

            WebElement slider =
                    driver.findElement(
                    By.xpath("//span[contains(@class,'ui-slider-handle')]"));

            actions.clickAndHold(slider)
                    .moveByOffset(100, 0)
                    .release()
                    .perform();

            System.out.println(
                    "Slider Completed");

        } catch(Exception e) {

            System.out.println(
                    "Slider Failed");

            e.printStackTrace();
        }
        // Single File Upload

        try {

            WebElement upload =
                    driver.findElement(
                    By.id("singleFileInput"));

            upload.sendKeys(
                    data.getString("singleFile"));
            driver.findElement(
            		By.xpath("//button[contains(text(),'Upload Single File')]"))
            		.click();

            		Thread.sleep(2000);
            System.out.println(
                    "Single Upload Completed");

        } catch(Exception e) {

            System.out.println(
                    "Single Upload Failed");
        }

        // Multiple File Upload

        try {

            String files =
                    data.getString("multiFile1")
                    + "\n"
                    + data.getString("multiFile2");

            WebElement upload =
                    driver.findElement(
                    By.id("multipleFilesInput"));

            upload.sendKeys(files);
            driver.findElement(
            		By.xpath("//button[contains(text(),'Upload Multiple Files')]"))
            		.click();

            		Thread.sleep(2000);
            System.out.println(
                    "Multiple Upload Completed");

        } catch(Exception e) {

            System.out.println(
                    "Multiple Upload Failed");
        }
    }
    public void handleTablesAndLinks() {

        try {

            // Static Web Table

            List<WebElement> staticRows =
                    driver.findElements(
                    By.xpath("//table[@name='BookTable']//tr"));

            System.out.println(
                    "Static Table Rows : "
                    + staticRows.size());

            for(WebElement row : staticRows) {

                System.out.println(
                        row.getText());
            }

        } catch(Exception e) {

            System.out.println(
                    "Static Table Failed");
        }

        try {

            WebElement cpu =
                    driver.findElement(
                    By.xpath(
                    "//*[contains(text(),'CPU load')]"));

            System.out.println(
                    cpu.getText());

        } catch(Exception e) {

            System.out.println(
                    "Dynamic Table Failed");
        }

        try {

            // SVG Element

            WebElement svgElement =
                    driver.findElement(
                    By.xpath("(//*[local-name()='svg'])[1]"));

            svgElement.click();

            System.out.println(
                    "SVG Click Completed");

        } catch(Exception e) {

            System.out.println(
                    "SVG Failed");
        }

        try {

            // Scrolling Dropdown

            WebElement comboBox =
                    driver.findElement(
                    By.id("comboBox"));

            comboBox.click();

            comboBox.sendKeys("Item 5");

            comboBox.sendKeys(Keys.ENTER);

            System.out.println(
                    "Scrolling Dropdown Completed");

        } catch(Exception e) {

            System.out.println(
                    "Scrolling Dropdown Failed");
        }

        try {

            // Labels

            List<WebElement> labels =
                    driver.findElements(
                    By.xpath("//label"));

            System.out.println(
                    "Labels Found : "
                    + labels.size());

        } catch(Exception e) {

            System.out.println(
                    "Labels Failed");
        }

        try {

            // Laptop Links

            List<WebElement> laptopLinks =
                    driver.findElements(
                    By.xpath("//a"));

            System.out.println(
                    "Total Links Found : "
                    + laptopLinks.size());

        } catch(Exception e) {

            System.out.println(
                    "Links Failed");
        }
    }
    
    public void handlePaginationShadowDomAndFooter() {

        // Pagination Table

        try {

            List<WebElement> pages =
                    driver.findElements(
                    By.xpath("//ul[@id='pagination']//li"));

            System.out.println(
                    "Pagination Pages : "
                    + pages.size());

            for(int i = 1; i <= 4; i++) {

                try {

                    driver.findElement(
                            By.linkText(
                            String.valueOf(i)))
                            .click();

                    Thread.sleep(1000);

                    System.out.println(
                            "Clicked Page : "
                            + i);

                } catch(Exception ex) {

                    System.out.println(
                            "Page "
                            + i
                            + " not found");
                }
            }

        } catch(Exception e) {

            System.out.println(
                    "Pagination Failed");
        }

        // Broken Links Section

        try {

            WebElement broken =
                    driver.findElement(
                    By.xpath(
                    "//*[contains(text(),'Broken Links')]"));

            System.out.println(
                    "Broken Link Section Found");

        } catch(Exception e) {

            System.out.println(
                    "Broken Link Section Failed");
        }

        // Shadow DOM Section

        try {

            WebElement shadowDomTitle =
                    driver.findElement(
                    By.xpath(
                    "//h2[contains(text(),'ShadowDOM')]"));

            System.out.println(
                    "Shadow DOM Found : "
                    + shadowDomTitle.isDisplayed());

        } catch(Exception e) {

            System.out.println(
                    "Shadow DOM Failed");
        }

        // Form Section

        try {

            List<WebElement> formInputs =
                    driver.findElements(
                    By.xpath(
                    "//input[@type='text']"));

            if(formInputs.size() >= 3) {

                formInputs.get(
                        formInputs.size()-3)
                        .sendKeys("Section1");

                formInputs.get(
                        formInputs.size()-2)
                        .sendKeys("Section2");

                formInputs.get(
                        formInputs.size()-1)
                        .sendKeys("Section3");
            }

            System.out.println(
                    "Form Section Completed");

        } catch(Exception e) {

            System.out.println(
                    "Form Section Failed");
        }

        // Footer Links

        try {

            List<WebElement> footerLinks =
                    driver.findElements(
                    By.xpath(
                    "//a"));

            System.out.println(
                    "Footer Links Count : "
                    + footerLinks.size());

        } catch(Exception e) {

            System.out.println(
                    "Footer Links Failed");
        }
    }
}