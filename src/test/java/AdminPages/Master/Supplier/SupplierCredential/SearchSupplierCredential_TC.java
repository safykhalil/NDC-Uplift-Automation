package AdminPages.Master.Supplier.SupplierCredential;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Master_Common;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import AdminPages.Master.Supplier.Supplier.SearchSupplier_Page;
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

public class SearchSupplierCredential_TC extends TestBase_TC {
    private LogIn_Page logIn;
    private SearchCity_Page searchCity;
    private SearchSupplierCredential_Page searchSupplierCredential;
    private SearchSupplier_Page searchSupplier;
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
    public void SearchSupplierCredential(Map<String, String> search) throws InterruptedException {
        searchCity = new SearchCity_Page(driver);
        searchSupplierCredential = new SearchSupplierCredential_Page(driver);
        searchSupplier = new SearchSupplier_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        new Master_Common(driver).clickMaster()
                .clickSupplierMenue()
                .clickSupplierCredencial();
        String CredentialName = search.get("CredentialName");
        String Supplier = search.get("Supplier");
        searchSupplierCredential.setSearchCredential(CredentialName,Supplier);
        searchSupplierCredential.setBoth();
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


    private void performAssertions() {
        String expectedHeaderStatus = "Supplier";
        String[] allowedStatusValues = {"Amadeus","MIK"};


        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[2]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Type' table header does not match the expected value.");


            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));

                Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                        "Row " + i + ": The 'Type' column data (" + actualDataStatus + ") does not match any of the allowed values.");

            }

        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }
    }

    private boolean isValueInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70/admin/operating-country");

    }


}
