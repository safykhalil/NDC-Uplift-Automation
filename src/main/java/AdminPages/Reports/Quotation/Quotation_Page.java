package AdminPages.Reports.Quotation;


import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Quotation_Page {
    private SHAFT.GUI.WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    private SHAFT.TestData.JSON testData;

    public Quotation_Page(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
        this.testData = new SHAFT.TestData.JSON("QuotationReport.json");
    }
    private final By Btn_Report = By.xpath("//a[@href='/reports']");
    private final By Btn_QuotationReport = By.xpath("//a[@href=\"../dashboard/myQuoteReport\"]");

    private final By Lst_branchName = By.xpath("//div[@role='button']");
    private final By Lst_agencyName = By.xpath("(//div[@class='p-multiselect-trigger'])[1]");
    private final By Txt_Name = By.xpath("//input[@placeholder='Name']");
    private final By Txt_EmailID = By.xpath("//input[@placeholder='Email@email.com']");
    private final By Txt_QuotesNo = By.xpath("//input[@id='id-QuotesNo.']");
    private final By Lst_QuoteStatus = By.xpath("(//div[@class='p-multiselect-trigger'])[2]");
    private final By Rbtn_creationDate = By.xpath("(//p-radiobutton)[1]");
    private final By Rbtn_travelDate = By.xpath("(//p-radiobutton)[2]");
    private final By Rbtn_Today = By.xpath("(//p-radiobutton)[3]");
    private final By Rbtn_currentWeek = By.xpath("(//p-radiobutton)[4]");
    private final By Rbtn_dateRange = By.xpath("(//p-radiobutton)[5]");
    private final By Dpick_fromDate = By.xpath("//input[@id='id-FromDate']");
    private final By Dpick_toDate = By.xpath("//input[@id='id-ToDate']");
    private final By Btn_search = By.xpath("//button[@label='Primary']");

    private final By selectBranch = By.xpath("//li[@aria-label='Test']");
    private final By selectAgency = By.xpath("//div[@role='checkbox']");
    private final By clickX = By.xpath("//button[@class='p-ripple p-element p-multiselect-close p-link ng-star-inserted']");
    private final By selectQuoteStatus= By.xpath("//div[@role='checkbox']");

    private final By Btn_Paginate = By.xpath("//button[@class='next']");
    private final By Btn_ExportExcel = By.xpath("(//button[@label='Primary'  and @type = 'button'])[2]");
    private final By Result = By.xpath("(//P)[2]");

    private final By QuotesNo_field = By.xpath("//tbody/tr[1]/td[1]");
    private final By ClientName_field = By.xpath("//tbody/tr[1]/td[2]");
    private final By Email_field = By.xpath("//tbody/tr[1]/td[5]");
    private final By noFoundMSG = By.xpath("//td[@class='message']");


    public Quotation_Page SelectReports(){
        driver.element().click(Btn_Report);
        return this;
    }

    public Quotation_Page SelectQuotationReport(){
        driver.element().click(Btn_QuotationReport);
        return this;
    }

    public Quotation_Page SelectBranch(){
        driver.element().click(Lst_branchName);
        driver.element().click(selectBranch);
        return this;
    }

    public Quotation_Page SelectAgency(){
        driver.element().click(Lst_agencyName);
        driver.element().click(selectAgency);
        driver.element().click(clickX);
        return this;
    }

    public Quotation_Page SendName (String s){
        driver.element().type(Txt_Name,s);
        return this;
    }

    public Quotation_Page SendEmail (String s){
        driver.element().type(Txt_EmailID,s);
        return this;
    }

    public Quotation_Page SelectQuoteStatus() {
        driver.element().click(Lst_QuoteStatus);
        driver.element().click(selectQuoteStatus);
        driver.element().click(clickX);
        return this;
    }

    public Quotation_Page SendQuoteNo (String s){
        driver.element().type(Txt_QuotesNo,s);
        return this;
    }

    public Quotation_Page SelectDuration_Today() {
        driver.element().click(Rbtn_Today);
        return this;
    }

    public Quotation_Page SelectDuration_CurrentWeek() {
        driver.element().click(Rbtn_currentWeek);
        return this;
    }
    public Quotation_Page SelectDuration_DateRange() throws InterruptedException {
        driver.element().click(Rbtn_dateRange);
        Thread.sleep(1000);
        return this;
    }

    public Quotation_Page SelectDate_CreationDate() {
        driver.element().click(Rbtn_creationDate);
        return this;
    }

    public Quotation_Page SelectDate_TravelDate() {
        driver.element().click(Rbtn_travelDate);
        return this;
    }

    public Quotation_Page SelectFromDate(String from ) {
        driver.element().type(Dpick_fromDate,from);
        return this;
    }
    public Quotation_Page SelectToDate_( String to) {
        driver.element().type(Dpick_toDate,to);
        return this;
    }
    public Quotation_Page ClickSearch() {
        driver.element().click(Btn_search);
        return this;
    }

    public Quotation_Page PaginateTheResults(){
        driver.element().click(Btn_Paginate);
        return this;
    }

    public Quotation_Page VerifyThatTheExportButtonIsClickable() {
        boolean click = driver.element().isElementClickable(Btn_ExportExcel);
        softAssert.assertTrue(click,"ok");
        softAssert.assertAll();
        return this;
    }


    public Quotation_Page VerifyThatClientNameDisplaysCorrectly(){
        softAssert.assertEquals(driver.element().getText(ClientName_field),testData.getTestData("validData.Name"));
        softAssert.assertAll();
        return this;
    }

    public Quotation_Page VerifyThatEmailIDDisplaysCorrectly(){
        softAssert.assertEquals(driver.element().getText(Email_field),testData.getTestData("validData.EmailID"));
        softAssert.assertAll();
        return this;
    }

    public Quotation_Page VerifyThatQuotesNoDisplaysCorrectly(){
        softAssert.assertEquals(driver.element().getText(QuotesNo_field),testData.getTestData("validData.QuotesNo"));
        softAssert.assertAll();
        return this;
    }

    public Quotation_Page VerifyThatUserCanPaginateResultsCorrectly(){
        softAssert.assertEquals(driver.element().getText(Result),testData.getTestData("validData.Results"));
        softAssert.assertAll();
        return this;
    }

    public Quotation_Page VerifyThatNoFoundDataShowsCorrectly(){
        softAssert.assertEquals(driver.element().getText(noFoundMSG),testData.getTestData("validData.NoData"));
        softAssert.assertAll();
        return this;
    }
}
