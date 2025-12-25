package AdminPages.Reports.ImportPNRRepo;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ImportPNRrep_Page {
    public ImportPNRrep_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;

    public String alertText;
    Alert alert;

    By Btn_BackDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By Btn_ClickImport = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[11]/div/div[1]");
    By Lst_ChooseBranch = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/ndc-fg-dropdown-input/p-multiselect/div/div[2]/div");
    By Lst_SelectBranch = By.xpath("//li[@aria-label=\"Test\"]");
    By Dpick_ClickDate = By.id("id-InvoiceFromDate");
    By Btn_BackDate2= By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By Dpick_ClickEndDate = By.id("id-InvoiceToDate");



    By Btn_Search = By.xpath("//span[@class=\"p-button-label\"]");
    By Btn_ClickAGN = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/ndc-fg-dropdown-input/p-multiselect/div");
    By Lst_ChooseAGN = By.xpath("//li[@aria-label=\"All\"]");

    By Txt_BranchError = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/span");
    By Txt_FromDateError = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/span");
    By Txt_ToDateError = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-import-pnr/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/span");
    By Btn_ClickReport = By.xpath("//a[@href=\"/reports\"]");
    By Txt_EndDate61 = By.xpath("(//td[@class=\"ng-tns-c47-4 ng-star-inserted\"])[28]");
    By Txt_StartDate61 = By.xpath("(//td[@class=\"ng-tns-c47-3 ng-star-inserted\"])[1]");
    By Btn_Before = By.xpath("//span[@class=\"p-datepicker-prev-icon pi pi-chevron-left ng-tns-c47-3\"]");

    public void SearchValidData(String branch,String AGN,String FromDate,String ToDate) throws InterruptedException {
        driver.element()
                .click(Lst_ChooseBranch)
                .select(Lst_SelectBranch, branch)
                .click(Btn_ClickAGN)
               .select(Lst_ChooseAGN,AGN);

        driver.element()
                .click(Dpick_ClickDate).click(Btn_BackDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", FromDate));
        driver.element().click(option4);
        driver.element().click(Dpick_ClickEndDate).click(Btn_BackDate2);
        By option3 = By.xpath(String.format("//span[text()='%s']", ToDate));
        driver.element().click(option3)
                .click(Btn_Search);

    }
    public void SearchinvalidBranch(String AGN, String FromDate, String ToDate){
        driver.element()
                .click(Btn_ClickAGN)
                .select(Lst_ChooseAGN,AGN)
                .click(Dpick_ClickDate).click(Btn_BackDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", FromDate));
        driver.element().click(option4)
                .click(Dpick_ClickEndDate).click(Btn_BackDate2);
        By option3 = By.xpath(String.format("//span[text()='%s']", ToDate));
        driver.element().click(option3)
                .click(Btn_Search);

    }
    public void SearchInvalidFromDate(String branch,String AGN,String ToDate) throws InterruptedException {
        driver.element()
                .click(Lst_ChooseBranch)
                .select(Lst_SelectBranch, branch)
                .click(Btn_ClickAGN)
                .select(Lst_ChooseAGN, AGN)
                .click(Dpick_ClickEndDate).click(Btn_BackDate2);
        By option3 = By.xpath(String.format("//span[text()='%s']", ToDate));
        driver.element().click(option3)

                .click(Btn_Search);
    }
    public void SearchInvalidToDate(String branch,String AGN,String FromDate) throws InterruptedException {
        driver.element()
                .click(Lst_ChooseBranch)
                .select(Lst_SelectBranch, branch)
                .click(Btn_ClickAGN)
                .select(Lst_ChooseAGN, AGN)
                .click(Dpick_ClickDate).click(Btn_BackDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", FromDate));
        driver.element().click(option4)
                .click(Btn_Search);
    }
    public void SearchInvalidDate61(String branch,String AGN,String InvalidStartDate61,String InvalidEndDate61) throws InterruptedException {
        driver.element()
                .click(Lst_ChooseBranch)
                .select(Lst_SelectBranch, branch)
                .click(Btn_ClickAGN)
                .select(Lst_ChooseAGN, AGN)
                .click(Dpick_ClickDate).click(Btn_BackDate);
//                .doubleClick(Before);
        By option4 = By.xpath(String.format("//span[text()='%s']", InvalidStartDate61));
        driver.element().click(option4)
                .click(Dpick_ClickEndDate).click(Btn_BackDate2);
        By option3 = By.xpath(String.format("//span[text()='%s']", InvalidEndDate61));
        driver.element().click(option3)
                .click(Btn_Search);
    }
//    public String Actual(){
//        String S = ElementActions.getInstance().getText(By.xpath("//*[@id=\"pr_id_4-table\"]/tbody/tr[1]/td[1]"));
//        return S;
//
//    }
//    public String Act61(){
//        String D = ElementActions.getInstance().getText(By.xpath("//div[@role=\"alert\"] "));
//        return D;
//    }



    public String Table(int ColumnSearch, String ExpectedSearch) {
        WebElement table = driver.getDriver().findElement(By.xpath("//div[@class=\"table-area\"]")); // Adjust the XPath to match your table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String actualResult = ExpectedSearch;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > ColumnSearch) {
                String columnText = cells.get(ColumnSearch).getText();
                if (!columnText.equals(actualResult)) {
                    actualResult = "Test";
                    break;
                }
            }


        }
        return actualResult;
    }
}
