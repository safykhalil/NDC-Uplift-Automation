package AdminPages.Master.Flight.Airport;
import com.shaft.validation.Validations;
import AdminPages.Login.LogIn_TC;
import utilities.JsonDataUtil;
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

import static org.junit.Assert.assertEquals;
public class SearchAirportTCs extends TestBase_TC {
    //Valid TestCases
    Airport_Page airport;
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
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
    }
    @Test(dataProvider = "JsonProvider",priority = 2)
    public void SearchAirport(Map<String,String>Search) throws InterruptedException {
        airport=new Airport_Page(driver);
        String IATA = Search.get("IATA");
        String AirportName = Search.get("AirportName");
        String Country = Search.get("Country");
        String City = Search.get("City");
        String Type = Search.get("Type");
        String Station = Search.get("Station");
        airport.navigateToAirportPage();
        airport.EnterIATACode(IATA);
        airport.EnterAirportName(AirportName);
        airport.EnterCountry(Country);
        airport.EnterCity(City);
        airport.ClickOnTypeAndChooseIndex(Type);
        airport.ClickOnStationAndChooseIndex(Station);
        airport.ClickOnSearch();
        Thread.sleep(3000);
        Validations.verifyThat().element(airport.Table).isDisabled();
    }


}