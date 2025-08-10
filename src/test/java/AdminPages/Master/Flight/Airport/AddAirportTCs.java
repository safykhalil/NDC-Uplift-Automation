package AdminPages.Master.Flight.Airport;

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

public class AddAirportTCs extends TestBase_TC {
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
    public void AddAirport(Map<String,String>Add) throws InterruptedException {
        airport=new Airport_Page(driver);
        String IATA = Add.get("IATA");
        String AirportName = Add.get("AirportName");
        String Country = Add.get("Country");
        String City = Add.get("City");
        String Station = Add.get("Station");
        String Latitude = Add.get("Latitude");
        String Longitude = Add.get("Longitude");
        String DDt = Add.get("Don't display to(POS)");
        String Nba = Add.get("Near by airport");
        String SupplierWhitelist = Add.get("Supplier Whitelist");
        int supplierWhitelist =Integer.parseInt(SupplierWhitelist);
        String SupplierBlacklist = Add.get("Supplier Blacklist");
        int supplierBlacklist =Integer.parseInt(SupplierBlacklist);

        airport.navigateToAirportPage();
        airport.ClickOnAddAirport();
        airport.EnterIATACode(IATA);
        airport.EnterAirportname(AirportName);
        airport.EnterCountry(Country);
        airport.EnterCity(City);
        airport.ClickOnStation(Station);
        airport.ClickOnDomestic();
        airport.TypeOnLatitude(Latitude);
        airport.TypeOnLongitude(Longitude);
        //airport.DontDisplayToPOS(DDt);
        //airport.NearByAirport(Nba);
        if (airport.GetSupplierText().equals("Supplier Whitelist => 0")){
            airport.ClickOnSuppliers(supplierWhitelist);
            airport.ClickOnRight();
        }
        else {
            airport.ClickOnSuppliers(supplierWhitelist);
            airport.ClickOnLeft();
        }
        airport.ClickOnSendForApproval();
        Thread.sleep(5000);
        String URL = driver.getDriver().getCurrentUrl();
        String url = Add.get("url");

        Assert.assertEquals(URL,url);
    }


}