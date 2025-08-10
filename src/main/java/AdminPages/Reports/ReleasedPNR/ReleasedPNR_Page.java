package AdminPages.Reports.ReleasedPNR;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ReleasedPNR_Page {

                                                //Create object from needed classes
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;


    //constructor

   public ReleasedPNR_Page (SHAFT.GUI.WebDriver driver){
       this.driver =driver;
       this.testData= new SHAFT.TestData.JSON("ReleasedPNR.json");
   }

                                                 //Define locators of used elements

   private final By Btn_reportSelect = By.xpath("//a[@href='/reports']"); // Report module
   private final By Btn_SelectRealesedPNRReport = By.xpath("//a[@href='../Reports/releasedPNRReport']//div[@class='row']//div[@class='col-md-4 col Statement_report']"); //Release Report
   private final By Dpick_fromDateSelect = By.id("id-Released.PNRFromDate"); // Select date from
   private final By Dpick_toDateSelect = By.id("id-Released.PNRToDate"); // Select date to
   private final By Txt_OrderID = By.id("id-OrderID"); // order id ( Optional )
   private final By Txt_BookingReference = By.id("id-FBBookingRef.No."); //Booking reference (Optional)
   private final By Btn_Search = By.className("p-button-label"); //search
   private final By Btn_ExportToExcel = By.xpath("//button[@class='p-element p-ripple p-button-outlined p-button p-component upper-table-btn']"); //Export To excel
   private final By BookingReference = By.xpath("//tbody/tr[1]/td[@class='ng-star-inserted'][3]"); //booking reference that assert on it
   private final By OrderID = By.xpath("(//tbody/tr[1]/td[@class='ng-star-inserted'][2])[1]"); //Order id that assert on it
   private final By NoDataFoundMessage = By.xpath("//td[@class='message']"); //no data found message
   private final By ErrorMessage = By.xpath("//ndc-fg-input[2]//span[@class='fg-error']"); //Required message
   private final By Paginate = By.xpath("//div[@class='pager ng-star-inserted']//button[3]"); //pagination 3
   private final By OrderIDColum = By.xpath("//th[normalize-space()='Order ID']"); //pagination 3
   private final By ShowingMessage =By.xpath("//p[normalize-space()='Showing 20 results of 26 results']");



    //Actions

    public void navigateToReports() {
        driver.element().click(Btn_reportSelect);
    }

    public void navigateToReleasedPNRReport() {
        driver.element().click(Btn_SelectRealesedPNRReport);
    }
    public void SelectFromDate (){
        driver.element().type(Dpick_fromDateSelect,testData.getTestData("validData.fromDate"));
    }
    public void SelectToDate (){
        driver.element().type(Dpick_toDateSelect,testData.getTestData("validData.toDate"));

    }
    public void SendOrderID (){
        driver.element().type(Txt_OrderID,testData.getTestData("validData.orderId"));
    }
    public void SendBookingReference(){
        driver.element().type(Txt_BookingReference,testData.getTestData("validData.FBBookinQrefNo"));
    }
    public void ClickOnSearch (){
        driver.element().click(Btn_Search);
    }
    public void ClickOnExport (){
        driver.element().click(Btn_ExportToExcel);
    }
    public void AssertOnOrderID (){

        Assert.assertEquals(driver.element().getText(OrderID), testData.getTestData("validData.orderId"));


    }
    public void AssertOnBookingRef (){

        Assert.assertEquals(driver.element().getText(BookingReference), testData.getTestData("validData.FBBookinQrefNo"));
    }
    public void NoDateSelected (){

        Assert.assertEquals(driver.element().getText(ErrorMessage), testData.getTestData("validData.errorMessage"));

    }
    public void OrderIDColumExist (){
        Assert.assertEquals(driver.element().getText(OrderIDColum), testData.getTestData("validData.orderIdColum"));

    }
    public void NoDataMatched (){
        Assert.assertEquals(driver.element().getText(NoDataFoundMessage), testData.getTestData("validData.noDataMessage"));

    }
    public void SelectFromDateWitNoOutput (){
        driver.element().type(Dpick_fromDateSelect,testData.getTestData("validDataNoOutput.fromDate"));
    }
    public void SelectToDateWitNoOutput (){
        driver.element().type(Dpick_toDateSelect,testData.getTestData("validDataNoOutput.toDate"));

    }
    public void SystemPaginateCorrectly (){
        driver.element().click(Paginate);
        Assert.assertEquals(driver.element().getText(ShowingMessage), testData.getTestData("validData.ShowingMessage"));

    }


























}
