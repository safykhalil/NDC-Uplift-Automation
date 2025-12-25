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

public class UpdateAirline_TC extends TestBase_TC {
    private Airline_Page airline;
    private UpdateAirline_Page updateAirline;
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

    @Test(dataProvider = "JsonProvider")
    public void UpdateAirline(Map<String,String> Search) {
        airline = new Airline_Page(driver);
        updateAirline = new UpdateAirline_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickFlight()
                .clickAirline();
        airline.EnterAirLineCode("012");
        airline.setBoth();
        airline.SearchButton();
        updateAirline.setEditAirline();
        String AirlineCode = Search.get("AirlineCode");
        String AirlineName = Search.get("AirlineName");
        String Alliance = Search.get("Alliance");
        String AirlineType = Search.get("AirlineType");
        String NetworkType = Search.get("NetworkType");
        String CountryPOS = Search.get("CountryPOS");
        String BranchPOS = Search.get("BranchPOS");
        String RestrictedAgencies = Search.get("RestrictedAgencies");
        updateAirline.AirlineDetails(AirlineCode,AirlineName,Alliance,AirlineType,NetworkType);
        updateAirline.SendForApproval("Approved");
        String Expected = "Updated Successfully";
        Assert.assertEquals(updateAirline.Actual2(),Expected);
    }

}
