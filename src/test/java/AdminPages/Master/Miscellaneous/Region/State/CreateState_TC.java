package AdminPages.Master.Miscellaneous.Region.State;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import AdminPages.Master.Miscellaneous.Region.Region.SearchRegion_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateState_TC extends TestBase_TC {
    private SearchCity_Page regionSearchCity;
    private SearchRegion_Page searchRegion;
    private SearchState_Page searchState;
    private CreateState_Page createState;
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
    public void setSearchState(Map<String, String> state){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        searchState = new SearchState_Page(driver);
        createState = new CreateState_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchState.setStatebtn();
        String StateName = state.get("StateName");
        String StateCode = state.get("StateCode");
        String CountryName = state.get("CountryName");
        createState.setAddState(StateName,StateCode,CountryName);
        String Expected = "Added Successfully";
        Assert.assertEquals(createState.Actual(),Expected);

    }



}
