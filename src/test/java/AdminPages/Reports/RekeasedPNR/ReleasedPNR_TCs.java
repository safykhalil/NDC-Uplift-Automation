package AdminPages.Reports.ReleasedPNR;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Reports.SyncPNR.SyncPNR_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.asynchttpclient.netty.ws.NettyWebSocket;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class ReleasedPNR_TCs extends TestBase_TC {
    ReleasedPNR_Page releasedPNRPage;


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
        releasedPNRPage = new ReleasedPNR_Page(driver);
    }

    @Test(priority = 1)
    @Description("Verify that user can search with only mandatory fields (From Date & To Date)")
    @Severity(SeverityLevel.CRITICAL)
    public void UserCanSearchWithMandatoryFieldsOnly() {
        // Navigate to Released PNR Report page
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();

        // Select mandatory fields only
        releasedPNRPage.SelectFromDate();
        releasedPNRPage.SelectToDate();

        // Click search and validate Order ID column appears
        releasedPNRPage.ClickOnSearch();
        releasedPNRPage.OrderIDColumExist();
    }

    @Test(priority = 2)
    @Description("Validate that system paginates results correctly after search")
    @Severity(SeverityLevel.NORMAL)
    public void UserCanPaginateCorrectly() {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();
        releasedPNRPage.SelectFromDate();
        releasedPNRPage.SelectToDate();
        releasedPNRPage.ClickOnSearch();

        // Check pagination works correctly
        releasedPNRPage.SystemPaginateCorrectly();
    }

    @Test(priority = 3)
    @Description("Verify that user can filter results by Order ID")
    @Severity(SeverityLevel.NORMAL)
    public void UserCanSearchWithOrderId()  {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();
        releasedPNRPage.SelectFromDate();
        releasedPNRPage.SelectToDate();

        // Enter Order ID and search
        releasedPNRPage.SendOrderID();
        releasedPNRPage.ClickOnSearch();

        // Validate correct result appears
        releasedPNRPage.AssertOnOrderID();
    }

    @Test(priority = 4)
    @Description("Verify that user can filter results by Booking Reference")
    @Severity(SeverityLevel.NORMAL)
    public void UserCanSearchWithBookingRef() {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();
        releasedPNRPage.SelectFromDate();
        releasedPNRPage.SelectToDate();

        // Enter Booking Reference and search
        releasedPNRPage.SendBookingReference();
        releasedPNRPage.ClickOnSearch();

        // Assert correct data returned
        releasedPNRPage.AssertOnBookingRef();
    }

    @Test(priority = 5)
    @Description("Validate that Export to Excel functionality works correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void ValidateExportToExcelReport() {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();
        releasedPNRPage.SelectFromDate();
        releasedPNRPage.SelectToDate();
        releasedPNRPage.ClickOnSearch();

        // Export results to Excel
        releasedPNRPage.ClickOnExport();
    }

    @Test(priority = 6)
    @Description("Verify system displays 'No Data Found' message when no results match search")
    @Severity(SeverityLevel.NORMAL)
    public void NoDataFoundMessageDisplayedIfNoDataMatched() {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();

        // Use date range that returns no results
        releasedPNRPage.SelectFromDateWitNoOutput();
        releasedPNRPage.SelectToDateWitNoOutput();

        releasedPNRPage.ClickOnSearch();

        // Assert 'no data' message displayed
        releasedPNRPage.NoDataMatched();
    }

    @Test(priority = 7)
    @Description("Ensure user cannot search without selecting mandatory fields")
    @Severity(SeverityLevel.MINOR)
    public void UserCanNotSearchWithoutMandatoryFields() {
        releasedPNRPage.navigateToReports();
        releasedPNRPage.navigateToReleasedPNRReport();

        // Try to search without setting date range
        releasedPNRPage.ClickOnSearch();

        // Assert warning shown
        releasedPNRPage.NoDateSelected();
    }






























}
