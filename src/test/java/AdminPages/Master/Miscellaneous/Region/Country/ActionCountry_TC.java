package AdminPages.Master.Miscellaneous.Region.Country;

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

public class ActionCountry_TC extends TestBase_TC {
    private ActionCountry_Page actionCountry;
    private SearchCity_Page regionSearchCity;
    private SearchCountry_Page searchCountry;
    private LogIn_Page logIn;
    private AdminPages.Helper.PaginationHelper paginationHelper;

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
    public void setInActive(){
        regionSearchCity = new SearchCity_Page(driver);
        searchCountry = new SearchCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        actionCountry = new ActionCountry_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchCountry.setCountry();
        searchCountry.setSearchcountry("United Arab Emirates","AE");
        searchCountry.setBoth();
        searchCountry.setSearchGrid();
        actionCountry.setInActiveIcon();

    }


    @Test(priority = 2)
    public void setActive(){
        regionSearchCity = new SearchCity_Page(driver);
        searchCountry = new SearchCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        actionCountry = new ActionCountry_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchCountry.setCountry();
        searchCountry.setSearchcountry("United Arab Emirates","AE");
        searchCountry.setBoth();
        searchCountry.setSearchGrid();
        actionCountry.setActiveIcon();

    }


    @Test(priority = 3)
    public void setReject(){
        regionSearchCity = new SearchCity_Page(driver);
        searchCountry = new SearchCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        actionCountry = new ActionCountry_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchCountry.setCountry();
        searchCountry.setSearchcountry("United Arab Emirates","AE");
        searchCountry.setBoth();
        searchCountry.setSearchGrid();
        actionCountry.setThumbDown("Reject");

    }


    @Test(priority = 4)
    public void setApproved(){
        regionSearchCity = new SearchCity_Page(driver);
        searchCountry = new SearchCountry_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        actionCountry = new ActionCountry_Page(driver);
        regionSearchCity.ClickonMaster();
        regionSearchCity.ClickonMiscellanous();
        regionSearchCity.ClickonRegion();
        searchCountry.setCountry();
        searchCountry.setSearchcountry("United Arab Emirates","AE");
        searchCountry.setBoth();
        searchCountry.setSearchGrid();
        actionCountry.setThumbUp("Approved");

    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}
