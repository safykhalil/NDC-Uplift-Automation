package AdminPages.Master.Supplier.CredentialField;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import AdminPages.Master.Supplier.Supplier.SearchSupplier_Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class SearchCredentialField_TC extends TestBase_TC {
    private SearchSupplier_Page supplier;
    private SearchCredentialField_Page searchCredentialField;
    private LogIn_Page logIn;
    private SearchCity_Page regionSearchCity;
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
    public void SearchCredential(Map<String, String> credentialField) throws InterruptedException {
        supplier = new SearchSupplier_Page(driver);
        searchCredentialField = new SearchCredentialField_Page(driver);
        regionSearchCity = new SearchCity_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        regionSearchCity.ClickonMaster();
        supplier.clickonsupplier();
        searchCredentialField.setCredintial();
        String SupplierCredintialFieldName = credentialField.get("SupplierCredintialFieldName");
        String Supplier = credentialField.get("Supplier");
        searchCredentialField.setSupplierCredintialFieldName(SupplierCredintialFieldName,Supplier);
        searchCredentialField.setSearchGrid();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            searchCredentialField.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }
    }


}
