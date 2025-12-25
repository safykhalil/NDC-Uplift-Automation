package AdminPages.Reports.WalletHistoryReport;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Reports.Reports_Common;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class WalletHistoryReport_TC extends TestBase_TC {

    private WalletHistoryReport_Page walletHistoryReportPage;
    private LogIn_Page logIn;
    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }
    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();

    }

    @Test(dataProvider = "JsonProvider")
    public void WalletHistoryReport(Map<String, String> search){
        walletHistoryReportPage = new WalletHistoryReport_Page(driver);
        String BranchName = search.get("BranchName");
        String AgencyName = search.get("AgencyName");
        String FromDate = search.get("FromDate");
        String ToDate = search.get("ToDate");
        new Reports_Common(driver).clickReports().clickWalletHistory();
        walletHistoryReportPage.setBranchName(BranchName);
        walletHistoryReportPage.setFromDate(FromDate);
        walletHistoryReportPage.setToDate(ToDate);
    }
}
