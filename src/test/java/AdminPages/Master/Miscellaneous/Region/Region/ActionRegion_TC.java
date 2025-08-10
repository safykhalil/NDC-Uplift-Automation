package AdminPages.Master.Miscellaneous.Region.Region;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Miscellaneous.Region.City.SearchCity_Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class ActionRegion_TC extends TestBase_TC {
    private SearchCity_Page regionSearchCity;
    private SearchRegion_Page searchRegion;
    private ActionRegion_Page actionRegion;
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

    @Test(priority = 1)
    public void setActionRegion(){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        actionRegion = new ActionRegion_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchRegion.setRegionName("SALALA","SAL");
        searchRegion.setBoth();
        searchRegion.setSearch();
        actionRegion.setUpdate("SALALAA","Ecuador","Approved");
        searchRegion.setBoth();
        searchRegion.setRegionName("SALALAA","SAL");
        searchRegion.setSearch();
    }

    @Test(priority = 2)
    public void setInActive(){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        actionRegion = new ActionRegion_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchRegion.setRegionName("SALALAA","SAL");
        searchRegion.setBoth();
        searchRegion.setSearch();
        actionRegion.setThumbUp("approved");
        actionRegion.setInActiveIcon();
    }


    @Test(priority = 3)
    public void setActive(){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        actionRegion = new ActionRegion_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchRegion.setRegionName("SALALAA","SAL");
        searchRegion.setBoth();
        searchRegion.setSearch();
        actionRegion.setActiveIcon();
    }

    @Test(priority = 4)
    public void SetReject(){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        actionRegion = new ActionRegion_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchRegion.setRegionName("SALALAA","SAL");
        searchRegion.setBoth();
        searchRegion.setSearch();
        actionRegion.setThumbDown("Reject");
    }


    @Test(priority = 5)
    public void SetApprove(){
        regionSearchCity = new SearchCity_Page(driver);
        searchRegion = new SearchRegion_Page(driver);
        actionRegion = new ActionRegion_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchRegion.setRegionName("SALALAA","SAL");
        searchRegion.setBoth();
        searchRegion.setSearch();
        actionRegion.setThumbUp("Approve");
    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}
