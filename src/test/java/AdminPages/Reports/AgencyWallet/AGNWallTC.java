package AdminPages.Reports.AgencyWallet;


import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Reports.Statement.State;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AGNWallTC extends TestBase_TC {
    AGnWall SearchWall;
    private LogIn_Page logIn;
    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }
    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();

    }
    @Test(priority = 1, dataProvider = "JsonProvider")
    public void SearchValidData(Map<String,String> search) throws InterruptedException {
        SearchWall = new AGnWall(driver);
        String branch = search.get("branch");
        String agency = search.get("agency");
        String currency = search.get("currency");
        SearchWall.SearchValid(branch,agency,currency);
        Thread.sleep(3000);
        assertEquals("Test",SearchWall.Table(0,"Test"));

    }
    @Test(priority = 2, dataProvider = "JsonProvider")
    public void SearchinvalidBranch(Map<String,String> search){
        SearchWall = new AGnWall(driver);
        String currency = search.get("currency");
        SearchWall.SearchInvalidBranch(currency);
        String Actual=driver.element().getText(SearchWall.ErrorBranch);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 3, dataProvider ="JsonProvider")
    public void SearchInvalidCurrency(Map<String,String> search) throws InterruptedException {
        SearchWall = new AGnWall(driver);
        String branch = search.get("branch");
        String agency = search.get("agency");
        SearchWall.SearchInvalidCurrency(branch,agency);
        String Actual=driver.element().getText(SearchWall.ErrorCurrency);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
}
