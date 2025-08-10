package AdminPages.Admin.Agency.AgentLoginDetails;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SearchLoginDetails_Page {
    public SearchLoginDetails_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;

    By Btn_Back = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[2]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By Btn_BackDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[1]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By Btn_ClickAgency = By.xpath("/html/body/ndc-root/ndc-layout/div/div[1]/tilde-theme-side-menu/div/ul/li[3]/tilde-theme-accordion/header/a");
    By Btn_ClickSearch = By.xpath("//a[@href=\"/admin/login-details\"]");
    By Lst_ClickAGN = By.xpath("//p-multiselect[.//input[@id=\"id-AgencyName\"]]");
    By Lst_ClickStaffAGN = By.xpath("//p-multiselect[.//input[@id=\"id-Agencystaff\"]]");
    By Txt_WriteAGN = By.xpath("//input[@class=\"p-multiselect-filter p-inputtext p-component\"]");
    By Cbox_ClickAll = By.xpath("//li[@class=\"p-ripple p-element p-multiselect-item\"]");
    By Dpick_DateRange = By.xpath("//label[@for=\"id-Duration-DateRange\"]");
    By Dpick_StartDate = By.id("id-StartDate");
    By Before = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[1]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]/span");
   // By ChooseStartDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[1]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[2]/table/tbody/tr[1]/td[1]/span");
    By Dpick_EndDate = By.id("id-EndDate");
   // By ChooseEndDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[2]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[2]/table/tbody/tr[3]/td[4]/span");
    By Rbtn_Details = By.xpath("//label[@for=\"id-Type-Detailed\"]");
    By Btn_ClickSearch1 = By.xpath("//button[@type=\"submit\"]");
    By StartDateError = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[1]/span");
    By EndDateError = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-login-details/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-radio-input/div/div/div[2]/ndc-fg-input[2]/span");


    public void ValidData(String agn ,String FromDate,String ToDate) throws InterruptedException {
        driver.element().click(Btn_ClickAgency)
                .click(Btn_ClickSearch)
                .select(Lst_ClickAGN, agn)
                .click(Lst_ClickStaffAGN)
                .type(Txt_WriteAGN,"All")
                .click(Cbox_ClickAll)
                .click(Dpick_DateRange)
                .click(Dpick_StartDate).click(Btn_BackDate);

        By option4 = By.xpath(String.format("//span[text()='%s']", FromDate));
        driver.element().click(option4)
                .click(Dpick_EndDate).click(Btn_Back);
        By option3 = By.xpath(String.format("//span[text()='%s']", ToDate));
        driver.element().click(option3)
                .click(Rbtn_Details)
                .click(Btn_ClickSearch1);
        Thread.sleep(3000);
        Actions actions = new Actions(driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    public void InvalidStartDate(String agn,String ToDate){
        driver.element().click(Btn_ClickAgency)
                .click(Btn_ClickSearch)
                .select(Lst_ClickAGN, agn)
                .click(Lst_ClickStaffAGN)
                .type(Txt_WriteAGN,"All")
                .click(Cbox_ClickAll)
                .click(Dpick_DateRange)
                .click(Dpick_EndDate).click(Btn_Back);
        By option3 = By.xpath(String.format("//span[text()='%s']", ToDate));
        driver.element().click(option3)
                .click(Rbtn_Details)
                .click(Btn_ClickSearch1);

    }
    public void InvalidEndDate(String agn,String FromDate){
        driver.element().click(Btn_ClickAgency)
                .click(Btn_ClickSearch)
                .select(Lst_ClickAGN, agn)
                .click(Lst_ClickStaffAGN)
                .type(Txt_WriteAGN,"All")
                .click(Cbox_ClickAll)
                .click(Dpick_DateRange)
                .click(Dpick_StartDate).click(Btn_BackDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", FromDate));
        driver.element().click(option4)
                .click(Rbtn_Details)
                .click(Btn_ClickSearch1);

    }
    public String Table(int ColumnSearch, String ExpectedSearch) {
        WebElement table = driver.getDriver().findElement(By.xpath("//div[@class=\"table-area\"]")); // Adjust the XPath to match your table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String actualResult = ExpectedSearch;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > ColumnSearch) {
                String columnText = cells.get(ColumnSearch).getText();
                if (!columnText.equals(actualResult)) {
                    actualResult = "Test Egypt";
                    break;
                }
            }




        }
        return actualResult;

    }

}
