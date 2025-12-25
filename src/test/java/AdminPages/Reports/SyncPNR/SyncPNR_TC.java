package AdminPages.Reports.SyncPNR;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Reports.Reports_Common;
import org.testng.annotations.*;
import utilities.JsonDataUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class SyncPNR_TC extends TestBase_TC {
    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }
    @BeforeTest
    public void login() {
        new LogIn_Page(driver).ClickAdmin();
        new LogIn_Page(driver).ClickOnLoginButton();
    }
    @Test(priority = 1)
    public void verifyThatTheMessageNotFoundDisplaysCorrectly() throws FileNotFoundException, InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateWithNoData()
                .chooseToDateWithNoDatat()
                .clickSubmit()
                .VerifyNoFoundMessageIsDisplaying();
    }

    @Test(priority = 2)
    public void verifyThatTheUserSearchDataWithMendatoryFieldOnly() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .clickSubmit()
                .VerifyThatOrderIdDisplaysCorrectly();
    }

    @Test(priority = 3)
    public void verifyThatUserCanSearchWithAllFields() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .sendOrderID()
                .sendFBBookingQRrefNo()
                .clickSubmit()
                .VerifyThatOrderIdDisplaysCorrectly()
                .VerifyThatBookingIdDisplaysCorrectly();
    }

    @Test(priority = 4)
    public void verifyThatUserCanSearchWithDateAndOrderId() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .sendOrderID()
                .clickSubmit()
                .VerifyThatOrderIdDisplaysCorrectly();
    }
    @Test(priority = 5)
    public void verifyThatUserCanSearchWithDateAndBookingId() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .sendFBBookingQRrefNo()
                .clickSubmit()
                .VerifyThatBookingIdDisplaysCorrectly();
    }

    @Test(priority = 6)
    public void verifyThatTheUserCanPaginateCorrectly() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .clickSubmit()
                .clickthePaginateButton()
                .VerifyThatsystemPaginateCorrectly();
    }

    @Test(priority = 7)
    public void verifyThatUserCanExportTheReportAsExcel() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .chooseFromDateReturnData()
                .chooseToDateReturnDatat()
                .clickSubmit()
                .verifyThatTheExportToExcelIsClickable();
    }

    @Test(priority = 8)
    public void verifyThatSystemDefendsThatUserSearchWithEmptyData() throws InterruptedException {
        new Reports_Common(driver).clickReports().clickSyncPNR();
        new SyncPNR_Page(driver)
                .clickSubmit()
                .VerifyThatSystemdShowErrorMessage();
    }

    @AfterMethod
    public void navigateBackToURL() {
//        driver.quit();
        driver.browser().navigateToURL("http://192.168.1.70");
    }

}
