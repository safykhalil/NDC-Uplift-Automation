package AdminPages.Master.Flight.Airline;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class SearchAirline_TC extends TestBase_TC {
    //Valid TestCases
    Airline_Page airline;
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

    @Test(priority = 2)
    public void searchWithAirLineName() throws InterruptedException {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterAirLineName("Abacus International");
        airline.SearchButton();

        assertEquals("Abacus International" ,airline.TableColumnDataExtractor(1,"Abacus International"));
    }
    @Test(priority = 3)
    public void searchWithAirLineType1() {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterAirLineType("LCC");
        airline.SearchButton();
        assertEquals("LCC" ,airline.TableColumnDataExtractor(2,"LCC"));

    }
    @Test(priority = 4)
    public void searchWithAirLineType2() {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterAirLineType("GDS");
        airline.SearchButton();
        assertEquals("GDS",airline.TableColumnDataExtractor(2,"GDS"));

    }
//    @Test
//    public void searchWithAirLineType3() {
//        airline = new Airline(driver);
//        airline.navigateToAirlinePage();
//        airline.EnterAirLineType("Both");
//        airline.SearchButton();
//        assertEquals("Both" ,airline.TableColumnDataExtractor(2,"Both"));
//
//    }
    @Test(priority = 5)
    public void searchWithNetWorkType1() {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterNetworkType("Domestic");
        airline.SearchButton();
        assertEquals("Domestic" ,airline.TableColumnDataExtractor(3,"Domestic"));

    }
    @Test(priority = 6)
    public void searchWithNetWorkType2() {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterNetworkType("International");
        airline.SearchButton();
        assertEquals("International" ,airline.TableColumnDataExtractor(3,"International"));

    }
//    @Test
//    public void searchWithNetWorkType3() {
//        airline = new Airline(driver);
//        airline.navigateToAirlinePage();
//        airline.EnterNetworkType("Both");
//        airline.SearchButton();
////        assertEquals("Both" ,airline.TableColumnDataExtractor(3,"Both"));
//
//    }
    @Test(priority = 1)
    public  void SearchWithFULLsENARIO1() throws InterruptedException {
        airline = new Airline_Page(driver);
        airline.navigateToAirlinePage();
        airline.EnterAirLineCode("JP");
        airline.EnterAirLineName("Adria Airways");
        airline.EnterAirLineType("GDS");
        airline.EnterNetworkType("Both");
        airline.SearchButton();
        assertEquals("JP",airline.TableColumnDataExtractorForCode(0,"JP"));
        assertEquals("Adria Airways" ,airline.TableColumnDataExtractor(1,"Adria Airways"));
        assertEquals("GDS" ,airline.TableColumnDataExtractor(2,"GDS"));
        assertEquals("Both" ,airline.TableColumnDataExtractor(3,"Both"));

    }
//    @Test(priority = 7)
//    public void searchWithoutAnyData() throws InterruptedException {
//        airline = new Airline(driver);
//        airline.navigateToAirlinePage();
//        airline.EnterAirLineCode("Q5");
//        airline.SearchButton();
//        Thread.sleep(3000);
//        assertEquals("Q5",airline.TableColumnDataExtractorForCode(0,"Q5"));
//    }
}
