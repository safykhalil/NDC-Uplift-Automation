package AdminPages.Master.Flight.Airport;

import AdminPages.Master.Master_Common;
import com.shaft.driver.SHAFT;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class AirportTCs extends TestBase_TC {

    Airport_Page airport;
    public LogIn_Page logIn;
    SHAFT.TestData.JSON testData;
    public Master_Common Airport;

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        airport = new Airport_Page(driver);
        Airport = new Master_Common(driver);
        testData = new SHAFT.TestData.JSON("Airport.json");
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
        Airport.clickMaster().clickFlight().clickAirport();
    }

    @Test(priority = 1)
    public void AddAirport() throws InterruptedException {
        airport=new Airport_Page(driver);
        airport.ClickOnAddAirport();
        airport.EnterIATACode(testData.getTestData("Add.IATA"));
        airport.EnterAirportname(testData.getTestData("Add.AirportName"));
        airport.EnterCountry(testData.getTestData("Add.Country"));
        airport.EnterCity(testData.getTestData("Add.City"));
        airport.ClickOnStation(testData.getTestData("Add.Station"));
        airport.ClickOnDomestic();
        airport.TypeOnLatitude(testData.getTestData("Add.Latitude"));
        airport.TypeOnLongitude(testData.getTestData("Add.Longitude"));
        airport.ClickOnSendForApproval();
        String Expected = "Added Successfully";
        Assert.assertEquals(airport.ActualCreate(),Expected);
    }

    @Test(priority = 2)
    public void SearchAirport() throws InterruptedException {
        airport=new Airport_Page(driver);
        airport.EnterIATACode(testData.getTestData("Search.IATA"));
        airport.EnterAirportName(testData.getTestData("Search.AirportName"));
        airport.EnterCountry(testData.getTestData("Search.Country"));
        airport.EnterCity(testData.getTestData("Search.City"));
        airport.ClickOnTypeAndChooseIndex(testData.getTestData("Search.Type"));
        airport.ClickOnStationAndChooseIndex(testData.getTestData("Search.Station"));
        airport.ClickOnInActiveStatus();
        airport.ClickOnSearch();
        airport.ClickOnThumbsUp();
        airport.TxtRemarks("test").Btn_Save();
        airport.ClickOnActiveStatus();
        airport.ClickOnSearch();
    }

    @Test(priority = 3)
    public void UpdateAirport() throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.ClickOnEdit();
        airport.clearFields();
        airport.EnterIATACode(testData.getTestData("Update.IATA1"));
        airport.EnterAirportname(testData.getTestData("Update.AirportName1"));
        airport.EnterCountry(testData.getTestData("Update.Country1"));
        airport.EnterCity(testData.getTestData("Update.City1"));
        airport.ClickOnStation(testData.getTestData("Update.Station"));
        airport.ClickOnInternational();
        airport.TypeOnLatitude(testData.getTestData("Update.Latitude"));
        airport.TypeOnLongitude(testData.getTestData("Update.Longitude"));
        airport.UpdateApprove();
        String Expected = "Updated Successfully";
        Assert.assertEquals(airport.ActualUpdate(),Expected);
        airport.EnterIATACode(testData.getTestData("Update.IATA1"));
        airport.EnterAirportName(testData.getTestData("Update.AirportName1"));
        airport.ClickOnSearch();
        Thread.sleep(2000);
        Assert.assertEquals(airport.AssertIATA(),testData.getTestData("Update.IATA1"));
        Assert.assertEquals(airport.AssertName(),testData.getTestData("Update.AirportName1"));
    }

}