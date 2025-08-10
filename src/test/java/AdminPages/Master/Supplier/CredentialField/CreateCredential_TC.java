package AdminPages.Master.Supplier.CredentialField;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import AdminPages.Master.Supplier.Supplier.SearchSupplier_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateCredential_TC extends TestBase_TC {

    private SearchSupplier_Page supplier;
    private SearchCredentialField_Page searchCredentialField;
    private LogIn_Page logIn;
    private SearchCity_Page regionSearchCity;
    private CreateCredentialField_Page createCredentialField;

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

    @Test(priority = 1, dataProvider = "JsonProvider")
    public void CreateCredential(Map<String, String> credentialField){
        supplier = new SearchSupplier_Page(driver);
        searchCredentialField = new SearchCredentialField_Page(driver);
        regionSearchCity = new SearchCity_Page(driver);
        createCredentialField = new CreateCredentialField_Page(driver);
        regionSearchCity.ClickonMaster();
        supplier.clickonsupplier();
        searchCredentialField.setCredintial();
        String SupplierCredintial = credentialField.get("SupplierCredintial");
        String Supplier = credentialField.get("Supplier");
        createCredentialField.setSupplierCredintial(SupplierCredintial,Supplier);
        String Expected = "Added Successfully";
        Assert.assertEquals(createCredentialField.Actual(),Expected);


    }

    @Test(priority = 2)
    public void setInvalidCreateCredentialField(){
        supplier = new SearchSupplier_Page(driver);
        searchCredentialField = new SearchCredentialField_Page(driver);
        regionSearchCity = new SearchCity_Page(driver);
        createCredentialField = new CreateCredentialField_Page(driver);
        regionSearchCity.ClickonMaster();
        supplier.clickonsupplier();
        searchCredentialField.setCredintial();
        createCredentialField.setSupplierCredintial("","Amadeus");
        String expected1 = "Required";
        Assert.assertEquals(createCredentialField.Actual2(),expected1);

    }



}
