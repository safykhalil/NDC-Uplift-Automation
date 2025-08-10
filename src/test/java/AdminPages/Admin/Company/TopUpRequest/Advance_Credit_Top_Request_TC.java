package AdminPages.Admin.Company.TopUpRequest;
import AdminPages.Admin.Company.Department_Page;
import AdminPages.Admin.Company.TopUpRequest_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class Advance_Credit_Top_Request_TC extends TestBase_TC {
    private Department_Page createDepartment;
    private TopUpRequest_Page TopupRequest;
    private LogIn_Page logIn;
    private AdminPages.Helper.PaginationHelper paginationHelper;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }
    @Test(dataProvider = "JsonProvider")
    public void TopUpRequest(Map<String, String> top) throws InterruptedException {

        createDepartment = new Department_Page(driver);
        TopupRequest = new TopUpRequest_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        TopupRequest.Advance_Credit();
        String Agencyname = top.get("Agencyname");
        String FromDate = top.get("FromDate");
        String ToDate = top.get("ToDate");
        String Status = top.get("Status");
        String PaymentType = top.get("PaymentType");
        String TopUpReferenceNumber = top.get("TopUpReferenceNumber");
        String ReceiptNumber = top.get("ReceiptNumber");
        String Paymentmode = top.get("Paymentmode");
        TopupRequest.setTopUpRequest(Agencyname,FromDate,ToDate, Status,PaymentType, TopUpReferenceNumber, ReceiptNumber,  Paymentmode);
        TopupRequest.setSearchGrid();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            TopupRequest.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }
    }






    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }


}
