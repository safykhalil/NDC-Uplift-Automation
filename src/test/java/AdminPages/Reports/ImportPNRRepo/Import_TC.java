package AdminPages.Reports.ImportPNRRepo;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


public class Import_TC extends TestBase_TC {
    ImportPNRrep_Page Importobj;
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
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }

    @Test(priority = 1, dataProvider = "JsonProvider")
    public void ImportPNR(Map<String,String> search) throws InterruptedException {
        Importobj = new ImportPNRrep_Page(driver);
        String Branch = search.get("Branch");
        String AGN = search.get("AGN");
        String FromDate = search.get("FromDate");
        String ToDate = search.get("ToDate");
        Importobj.SearchValidData(Branch,AGN,FromDate,ToDate);
        Thread.sleep(3000);
        String Expected = "Test";
//        Assert.assertEquals(Importobj.Actual(),Expected);


    }

    @Test(priority = 2, dataProvider = "JsonProvider") //
    public void ImportPNRValid(Map<String,String> search) throws InterruptedException {

        Importobj = new ImportPNRrep_Page(driver);
        String Branch = search.get("Branch");
        String AGN = search.get("AGN");
        String ToDate = search.get("ToDate");
        Importobj.SearchInvalidFromDate(Branch,AGN,ToDate);// Select date range
        String Actual=driver.element().getText(Importobj.Txt_FromDateError);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 3, dataProvider = "JsonProvider") //
    public void ImportPNRToDateValid(Map<String,String> search) throws InterruptedException {

        Importobj = new ImportPNRrep_Page(driver);
        String Branch = search.get("Branch");
        String AGN = search.get("AGN");
        String FromDate = search.get("FromDate");
        Importobj.SearchInvalidToDate(Branch,AGN,FromDate);// Select date range
        String Actual=driver.element().getText(Importobj.Txt_ToDateError);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }



}

