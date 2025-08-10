package AdminPages.Master.Flight.Airport;

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

public class UpdateAirportTCs extends TestBase_TC {
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
    public void UpdateAirport(Map<String,String>Update) throws InterruptedException {
        airport=new Airport_Page(driver);
        String IATA = Update.get("IATA");
        String AirportName = Update.get("AirportName");
        String Country = Update.get("Country");
        String City = Update.get("City");
        String Station = Update.get("Station");
        String Latitude = Update.get("Latitude");
        String Longitude = Update.get("Longitude");
        String DDt = Update.get("Don't display to(POS)");
        String Nba = Update.get("Near by airport");
        String SupplierWhitelist = Update.get("Supplier Whitelist");
        int supplierWhitelist =Integer.parseInt(SupplierWhitelist);
        String SupplierBlacklist = Update.get("Supplier Blacklist");
        int supplierBlacklist =Integer.parseInt(SupplierBlacklist);
        String IATA1 = Update.get("IATA1");
        String AirportName1 = Update.get("AirportName1");
        String Country1 = Update.get("Country1");
        String City1 = Update.get("City1");
        String Type1 = Update.get("Type1");
        String Station1 = Update.get("Station1");
        airport.navigateToAirportPage();
        airport.EnterIATACode(IATA1);
        airport.EnterAirportName(AirportName1);
        airport.EnterCountry(Country1);
        airport.EnterCity(City1);
        airport.ClickOnTypeAndChooseIndex(Type1);
        airport.ClickOnStationAndChooseIndex(Station1);
        airport.ClickOnSearch();
        airport.ClickOnEdit();
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
//        if (airport.GetSupplierText().equals("Supplier Whitelist => 0")){
//            airport.ClickOnSuppliers(supplierWhitelist);
//            airport.ClickOnRight();
//        }
//        else {
//            airport.ClickOnSuppliers(supplierWhitelist);
//            airport.ClickOnLeft();
//        }
        airport.ClickOnSendForApproval();
        Thread.sleep(5000);
        String URL = driver.getDriver().getCurrentUrl();
        String url = Update.get("url");

        Assert.assertEquals(URL,url);
    }


}