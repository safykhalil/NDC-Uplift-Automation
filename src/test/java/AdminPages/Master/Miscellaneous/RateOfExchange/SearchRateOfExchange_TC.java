package AdminPages.Master.Miscellaneous.RateOfExchange;


import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class SearchRateOfExchange_TC extends TestBase_TC {
    private LogIn_Page logIn;
    private RateOfExchange_Page rateOfExchange;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();

    }
    //Valid TestCases
    @Test
    public void searchWithoutAnyData() {
        rateOfExchange= new RateOfExchange_Page(driver);
        rateOfExchange.NavigateToRateOfExchangePage();
        rateOfExchange.ClickSearchButton();
        // rateOfExchange.PaginationAutomation();
        rateOfExchange.paginateAndVerifyData();
    }
    @Test
    public void searchWithFromCurrency()   {
        rateOfExchange= new RateOfExchange_Page(driver);
        rateOfExchange.NavigateToRateOfExchangePage();
        rateOfExchange.SelectFromCurrency("Egyptian Pound");
        rateOfExchange.ClickSearchButton();
        assertEquals("Egyptian Pound",rateOfExchange.TableColumnDataExtractor(1,"Egyptian Pound"));
    }
    @Test
    public void searchWithToCurrency() throws InterruptedException {
        rateOfExchange= new RateOfExchange_Page(driver);
        rateOfExchange.NavigateToRateOfExchangePage();
        rateOfExchange.SelectToCurrency("Egyptian Pound");
        rateOfExchange.ClickSearchButton();
        Thread.sleep(Long.parseLong("5000"));
        assertEquals("Egyptian Pound",rateOfExchange.TableColumnDataExtractor(2,"Egyptian Pound"));
    }
    @Test
    public void searchWithFromAndToCurrency() throws InterruptedException {
        rateOfExchange= new RateOfExchange_Page(driver);
        rateOfExchange.NavigateToRateOfExchangePage();
        rateOfExchange.SelectFromCurrency("United States Dollar");
        rateOfExchange.SelectToCurrency("Egyptian Pound");
        rateOfExchange.ClickSearchButton();
        Thread.sleep(Long.parseLong("5000"));
        assertEquals("United States Dollar",rateOfExchange.TableColumnDataExtractor(1,"United States Dollar"));
        assertEquals("Egyptian Pound",rateOfExchange.TableColumnDataExtractor(2,"Egyptian Pound"));

    }
    //inValid
    @Test
    public void searchWithFromAndToCurrencyNoData() throws InterruptedException {
        rateOfExchange= new RateOfExchange_Page(driver);
        rateOfExchange.NavigateToRateOfExchangePage();
        rateOfExchange.SelectFromCurrency("Algerian Dinar");
        rateOfExchange.SelectToCurrency("Euro");
        rateOfExchange.ClickSearchButton();
        Thread.sleep(Long.parseLong("5000"));
        String Actual =driver.element().getText(rateOfExchange.Txt_NoDataFounded);
        assertEquals("No data has been found!",Actual);

    }


}

