package AdminPages.Admin.Company.OperatingCountry;
import AdminPages.Admin.AdminMenu;
import AdminPages.Admin.Company.OperatingCountry_Page;
import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class SearchCountry_TC extends TestBase_TC {
    private Staff_Page staff;
    private OperatingCountry_Page operatingCountryPage;
    private LogIn_Page logIn;
    private AdminPages.Helper.PaginationHelper paginationHelper;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();
        new AdminMenu(driver).openSubAdmin().Company().OperatingCountry();

    }

    @Test(dataProvider = "JsonProvider")
    public void SearchCountryBoth(Map<String, String> OP) throws InterruptedException {
        staff = new Staff_Page(driver);
        operatingCountryPage = new OperatingCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
//        staff.Clickonadmin();
        String OperatingCountryName = OP.get("OperatingCountryName");
        String SelectCountry = OP.get("SelectCountry");
        operatingCountryPage.OperatingCountry(OperatingCountryName, SelectCountry);
        operatingCountryPage.setBoth();
        operatingCountryPage.setSearchGrid();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }


    }

    @Test(dataProvider = "JsonProvider" )
    public void SearchCountryActive(Map<String,String>OP) throws InterruptedException {
        staff = new Staff_Page(driver);
        operatingCountryPage = new OperatingCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
//        staff.Clickonadmin();
        String OperatingCountryName =OP.get("OperatingCountryName");
        String SelectCountry = OP.get("SelectCountry");
        operatingCountryPage.OperatingCountry(OperatingCountryName, SelectCountry);
        operatingCountryPage.setActive();
        operatingCountryPage.setSearchGrid();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }

    }
    @Test(dataProvider = "JsonProvider" )
    public void SearchCountryInActive(Map<String,String>OP) throws InterruptedException {
        staff = new Staff_Page(driver);
        operatingCountryPage = new OperatingCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
//        staff.Clickonadmin();
        String OperatingCountryName =OP.get("OperatingCountryName");
        String SelectCountry = OP.get("SelectCountry");
        operatingCountryPage.OperatingCountry(OperatingCountryName, SelectCountry);
        operatingCountryPage.setInactive();
        operatingCountryPage.setSearchGrid();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }

    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70/admin/operating-country");
    }


    private void performAssertions () {
        String expectedHeaderStatus = "Status";
        String expectedHeaderApproval = "Approval Status";
        String[] allowedStatusValues = {"Active", "Inactive"};
        String[] allowedApprovalValues = {"Pending for approval", "Approved", "Rejected"};

        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");

            String actualHeaderApproval = driver.element().getText(By.xpath("//table/thead/tr/th[5]"));
            Assert.assertEquals(actualHeaderApproval, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");

            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
                String actualDataApproval = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[5]"));

                Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                        "Row " + i + ": The 'Status' column data (" + actualDataStatus + ") does not match any of the allowed values.");

                Assert.assertTrue(isValueInArray(actualDataApproval, allowedApprovalValues),
                        "Row " + i + ": The 'Approval Status' column data (" + actualDataApproval + ") does not match any of the allowed values.");

                // Additional validation: If Approval Status is "Rejected", Status cannot be "Active"
                if (actualDataApproval.equals("Rejected")) {
                    Assert.assertNotEquals(actualDataStatus, "Active",
                            "Row " + i + ": The 'Status' cannot be 'Active' if the 'Approval Status' is 'Rejected'.");
                }
            }

        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }
    }


    private boolean isValueInArray (String value, String[]array){
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}







