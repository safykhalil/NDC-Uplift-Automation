package AdminPages.Reports.SyncPNR;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class SyncPNR_Page {
    private SHAFT.GUI.WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    private SHAFT.TestData.JSON testData;

    public SyncPNR_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.testData = new SHAFT.TestData.JSON("Sync.json");

    }

    private final By Btn_reportSelect = By.xpath("//a[@href='/reports']");
    private final By Btn_selectSyncPNRReport = By.xpath("//div/a[@href='../Reports/syncPNRReport?menu=reports']");
    private final By Dpick_fromDateSelect = By.xpath("//input[@id='id-Sync.PNRFromDate']");
    private final By Dpick_toDateSelect = By.xpath("//input[@id='id-Sync.PNRToDate']");
    private final By Txt_orderIdSelect = By.xpath("//input[@id='id-OrderID']");
    private final By Txt_FBBookinQrefNo = By.xpath("//input[@id='id-FBbookingrefno.']");
    private final By Btn_submitClick = By.xpath("//button[@type='submit']");
    private final By message = By.xpath("//td[@class='message']");
    private final By orderId = By.xpath("//tbody/tr[1]/td[1]");
    private final By bookingId = By.xpath("//tbody/tr[1]/td[2]");
    private final By paginate = By.xpath("//div[@class='pager ng-star-inserted']/button[3]");
    private final By showingMessage = By.xpath("//div[@class='results ng-star-inserted']/p");
    private final By Btn_exportExcel = By.xpath("//div[@class='col-6']/button[@type='button']");
    private final By errorMessage = By.xpath("//ndc-fg-input[1]/span[@class='fg-error']");

    public SyncPNR_Page navigateToReports() {
        driver.element().click(Btn_reportSelect);
        return this;
    }

    public SyncPNR_Page clickSyncPNR() {
        driver.element().click(Btn_selectSyncPNRReport);
        return this;
    }

    public SyncPNR_Page chooseFromDateReturnData() {
        driver.element().type(Dpick_fromDateSelect, testData.getTestData("validData.fromDate"));
        return this;
    }

    public SyncPNR_Page chooseToDateReturnDatat() {
        driver.element().type(Dpick_toDateSelect, testData.getTestData("validData.toDate"));
        return this;
    }

    public SyncPNR_Page chooseFromDateWithNoData() {
        driver.element().type(Dpick_fromDateSelect, testData.getTestData("validDataNoOutput.fromDate"));
        return this;
    }

    public SyncPNR_Page chooseToDateWithNoDatat() {
        driver.element().type(Dpick_toDateSelect, testData.getTestData("validDataNoOutput.toDate"));
        return this;
    }

    public SyncPNR_Page VerifyNoFoundMessageIsDisplaying() {
        softAssert.assertEquals(driver.element().getText(message), testData.getTestData("validData.noDataMessage"));
        softAssert.assertAll();
        return this;
    }

    public SyncPNR_Page sendOrderID() {
        driver.element().type(Txt_orderIdSelect, testData.getTestData("validData.orderId"));
        return this;
    }

    public SyncPNR_Page VerifyThatOrderIdDisplaysCorrectly() {
        softAssert.assertEquals(driver.element().getText(orderId), testData.getTestData("validData.orderId"));
        softAssert.assertAll();
        return this;
    }

    public SyncPNR_Page sendFBBookingQRrefNo() {
        driver.element().type(Txt_FBBookinQrefNo, testData.getTestData("validData.FBBookinQrefNo"));
        return this;
    }

    public SyncPNR_Page VerifyThatBookingIdDisplaysCorrectly() {
        softAssert.assertEquals(driver.element().getText(bookingId), testData.getTestData("validData.FBBookinQrefNo"));
        softAssert.assertAll();
        return this;
    }

    public SyncPNR_Page clickthePaginateButton() throws InterruptedException {
        driver.element().click(paginate);
        Thread.sleep(1000);
        return this;
    }

    public SyncPNR_Page VerifyThatsystemPaginateCorrectly() {
        softAssert.assertEquals(driver.element().getText(showingMessage), "Showing 20 results of 80 results");
        softAssert.assertAll();
        return this;
    }

    public SyncPNR_Page verifyThatTheExportToExcelIsClickable(){
    boolean click = driver.element().isElementClickable(Btn_exportExcel);
        softAssert.assertTrue(click,"ok");
        softAssert.assertAll();
        return this;
}

    public SyncPNR_Page clickSubmit() throws InterruptedException {
        driver.element().click(Btn_submitClick);
        Thread.sleep(1000);
        return this;
    }

    public SyncPNR_Page VerifyThatSystemdShowErrorMessage() {
        softAssert.assertEquals(driver.element().getText(errorMessage), testData.getTestData("validData.errorMessage"));
        softAssert.assertAll();
        return this;
    }

}
