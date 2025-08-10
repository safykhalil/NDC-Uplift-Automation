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

public class ActionAirportTCs extends TestBase_TC {
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
    @Test(priority =1)
    public void EyeIsClickable() throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.navigateToAirportPage();
        airport.EnterIATACode("CAI");
        airport.ClickOnSearch();
        String Expected = airport.NameOfAirportOnSearch();
        airport.ClickOnEye();
        Thread.sleep(1000);
        String Actual = airport.NameOfAirportOnEye();
        airport.ClickOnClose();
        assertEquals(Expected,Actual);

    }

    @Test(dataProvider = "JsonProvider",priority = 2)
    public void ActionAirport(Map<String,String>actions) throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.Reload();
        airport.EnterIATACode("CAI");
        airport.ClickOnSearch();
        airport.ClickOnEdit();
        Thread.sleep(1000);
        String EditUrl = actions.get("EditUrl");
        String CurrentUrl = driver.getDriver().getCurrentUrl();
        Assert.assertTrue(CurrentUrl.contains(EditUrl), "Edit page URL is incorrect!");

    }
    @Test(priority =3)
    public void ActiveIsClickable() throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.Reload();
        airport.EnterIATACode("CAI");
        airport.ClickOnSearch();
        airport.ClickOnActiveCircle();
        airport.ClickOnInactive();
        airport.ClickOnSearch();
        assertEquals("CAI",airport.NameOfAirportOnSearch());

    }
//    @Test(priority = 4)
//    public void InactiveIsClickable() throws InterruptedException {
//        airport = new Airport_Page(driver);
//        airport.Reload();
//        airport.ClickOnInactive();
//        airport.EnterIATACode("MRD");
//        airport.ClickOnSearch();
//        airport.ClickOnInactiveCircle();
//        airport.ClickOnActive();
//        airport.ClickOnSearch();
//        assertEquals("MRD",airport.NameOfAirportOnSearch());
//
//    }
    @Test(priority = 5)
    public void ThumbsUpIsClickable() throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.Reload();
        airport.ClickOnInactive();
        airport.EnterIATACode("IST");
        airport.ClickOnSearch();
        airport.ClickOnThumbsUp();
        Thread.sleep(1000);
        airport.ClickOnActive();
        airport.EnterIATACode("IST");
        airport.ClickOnSearch();
        Thread.sleep(1000);
        assertEquals("IST",airport.NameOfAirportOnSearch());

    }
    @Test(priority = 6)
    public void ThumbsDownIsClickable() throws InterruptedException {
        airport = new Airport_Page(driver);
        airport.Reload();
        airport.ClickOnActive();
        airport.EnterIATACode("IST");
        airport.ClickOnSearch();
        airport.ClickOnThumbsDown();
        Thread.sleep(1000);
        airport.ClickOnInactive();
        airport.EnterIATACode("IST");
        airport.ClickOnSearch();
        Thread.sleep(1000);
        assertEquals("IST",airport.NameOfAirportOnSearch());

    }


}