package AdminPages.Reports.Statement;


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

public class StateTC extends TestBase_TC {

    State SearchState;
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
    public void SearchValidDataState(Map<String,String> search) throws InterruptedException {
        SearchState = new State(driver);
        String branch = search.get("branch");
        String Agency = search.get("Agency");
        String InvoiceFromDate = search.get("InvoiceFromDate");
        String InvoiceToDate = search.get("InvoiceToDate");

        SearchState.searchValidState(branch,Agency,InvoiceFromDate,InvoiceToDate);
        Thread.sleep(3000);

    }
    @Test(priority = 2, dataProvider = "JsonProvider")
    public void SearchinvalidBranch(Map<String,String> search){
        SearchState = new State(driver);
        String InvoiceFromDate = search.get("InvoiceFromDate");
        String InvoiceToDate = search.get("InvoiceToDate");
        SearchState.searchinvalidBranch(InvoiceFromDate,InvoiceToDate);
        String Actual=driver.element().getText(SearchState.BranchError);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 3, dataProvider = "JsonProvider")
    public void SearchinvalidFromDate(Map<String,String> search){
        SearchState = new State(driver);
        String branch = search.get("branch");
        String InvoiceToDate = search.get("InvoiceToDate");
        SearchState.SearchinvalidFromDate(branch,InvoiceToDate);
        String Actual=driver.element().getText(SearchState.FromError);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 4, dataProvider = "JsonProvider")
    public void SearchinvalidToDate(Map<String,String> search){
        SearchState = new State(driver);
        String branch = search.get("branch");
        String InvoiceFromDate = search.get("InvoiceFromDate");
        SearchState.SearchinvalidToDate(branch,InvoiceFromDate);
        String Actual=driver.element().getText(SearchState.ToError);
        String Expected="Required";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 5, dataProvider = "JsonProvider")
    public void SearchInvalidToafterFrom(Map<String,String> search){
        SearchState = new State(driver);
        String branch = search.get("branch");
        String InvoiceBefore = search.get("InvoiceBefore");
        String InvoiceAfter = search.get("InvoiceAfter");
        SearchState.SearchInvalidToafterFrom(branch,InvoiceBefore,InvoiceAfter);
        String Actual=driver.element().getText(SearchState.ErrorToafterFrom);
        String Expected="'Invoice To' date must be after 'Invoice From' date.";
        Assert.assertEquals(Actual,Expected);

    }
    @Test(priority = 6, dataProvider = "JsonProvider")
    public void SearchInvalid60Days(Map<String,String> search){
        SearchState = new State(driver);
        String branch = search.get("branch");
        String InvoiceBefore = search.get("InvoiceBefore");
        String InvoiceAfter = search.get("InvoiceAfter");
        SearchState.SearchInvalid60Days(branch,InvoiceBefore,InvoiceAfter);
        String Actual=driver.element().getText(SearchState.BeforeError);
        String Expected="Date difference between 'From' and 'To' should not exceed 60 days.";
        Assert.assertEquals(Actual,Expected);

    }






}
