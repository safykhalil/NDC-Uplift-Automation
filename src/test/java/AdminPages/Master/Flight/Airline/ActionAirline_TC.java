package AdminPages.Master.Flight.Airline;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Master_Common;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ActionAirline_TC extends TestBase_TC {
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
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
    }
    @Test(priority =1)
    public void EyeIsClickable() throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
//        String Expected = airline.NameOfAirlineOnSearch();
        airline.ClickOnEye();
        Thread.sleep(1000);
//        String Actual = airline.NameOfAirlineOnEye();
        airline.ClickOnClose();
//        assertEquals(Expected,Actual);

    }

    @Test(dataProvider = "JsonProvider",priority = 2)
    public void ActionAirline(Map<String,String>actions) throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.ClickOnEdit();
        Thread.sleep(1000);
        String EditUrl = actions.get("EditUrl");
        String CurrentUrl = driver.getDriver().getCurrentUrl();
        Assert.assertTrue(CurrentUrl.contains(EditUrl), "Edit page URL is incorrect!");

    }
    @Test(priority =3)
    public void ActiveIsClickable() throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.EnterAirLineCode("DC");
        airline.SearchButton();
        airline.ClickOnActiveCircle();
        airline.ClickOnInactive();
        airline.SearchButton();
        assertEquals("DC",airline.TableColumnDataExtractorForCode(0,"DC"));

    }
    @Test(priority = 4)
    public void InactiveIsClickable() throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.ClickOnInactive();
        airline.EnterAirLineCode("DC");
        airline.SearchButton();
        airline.ClickOnInactiveCircle();
        airline.ClickOnActive();
        airline.SearchButton();
        assertEquals("DC",airline.TableColumnDataExtractorForCode(0,"DC"));

    }
    @Test(priority = 5)
    public void ThumbsUpIsClickable() throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.ClickOnInactive();
        airline.EnterAirLineCode("a");
        airline.SearchButton();
        airline.ClickOnThumbsUp();
        Thread.sleep(1000);
        airline.ClickOnActive();
        airline.EnterAirLineCode("a");
        airline.SearchButton();
        Thread.sleep(1000);
        assertEquals("a",airline.TableColumnDataExtractorForCodeAction(0,"a"));

    }
    @Test(priority = 6)
    public void ThumbsDownIsClickable() throws InterruptedException {
        airline = new Airline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.ClickOnActive();
        airline.EnterAirLineCode("a");
        airline.SearchButton();
        airline.ClickOnThumbsDown();
        Thread.sleep(1000);
        airline.ClickOnInactive();
        airline.EnterAirLineCode("a");
        airline.SearchButton();
        Thread.sleep(1000);
        assertEquals("a",airline.TableColumnDataExtractorForCodeAction(0,"a"));

    }

}