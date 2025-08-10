package AdminPages.Master.Flight.BSPCommission;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Flight.BSPCommission_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class SearchBSPCommission_TC extends TestBase_TC {
    private BSPCommission_Page createBSPCommission;
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

    @Test
    public void setSearchBSPCommission() throws InterruptedException {
        createBSPCommission = new BSPCommission_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        createBSPCommission.setMaster();
        createBSPCommission.setFlight();
        createBSPCommission.setBSP();
        createBSPCommission.setAirlineName("Egyptair");
        createBSPCommission.setBoth();
        createBSPCommission.setSearchButton();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            createBSPCommission.performAssertionsAirlineName();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }
        Thread.sleep(5000);
    }


    @Test
    public void setGDSSearchBSPCommission() throws InterruptedException {
        createBSPCommission = new BSPCommission_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        createBSPCommission.setMaster();
        createBSPCommission.setFlight();
        createBSPCommission.setBSP();
        createBSPCommission.setGDSSupplier("Galileo");
        createBSPCommission.setBoth();
        createBSPCommission.setSearchButton();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            createBSPCommission.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }

    }

    @Test
    public void setGDSsSearchBSPCommission() throws InterruptedException {
        createBSPCommission = new BSPCommission_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        createBSPCommission.setMaster();
        createBSPCommission.setFlight();
        createBSPCommission.setBSP();
        createBSPCommission.setGDSSupplier("Amadeus");
        createBSPCommission.setBoth();
        createBSPCommission.setSearchButton();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            createBSPCommission.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }

    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.95");
    }
}
