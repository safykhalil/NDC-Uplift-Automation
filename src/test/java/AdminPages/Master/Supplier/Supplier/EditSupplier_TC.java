package AdminPages.Master.Supplier.Supplier;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class EditSupplier_TC extends TestBase_TC {
    private SearchCity_Page searchCity;
    private SearchSupplier_Page searchSupplier;
    private ActionSupplier_Page actionSupplier;
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
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }
    @Test( dataProvider = "JsonProvider")
    public void SearchSupplier(Map<String, String> search) throws InterruptedException {
        searchSupplier = new SearchSupplier_Page(driver);
        searchCity = new SearchCity_Page(driver);
        actionSupplier = new ActionSupplier_Page(driver);
        searchCity.ClickonMaster();
        searchSupplier.clickonsupplier();
        String SupplierName = search.get("SupplierName");
        searchSupplier.searchsupplierdata(SupplierName);
        searchSupplier.setBoth();
        actionSupplier.setEditBtn("GDS","egy","mahmd@gmail.com","cai","1125","ada","Cai","approve");
}

}
