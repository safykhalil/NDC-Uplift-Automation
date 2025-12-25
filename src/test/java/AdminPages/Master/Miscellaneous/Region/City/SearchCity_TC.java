package AdminPages.Master.Miscellaneous.Region.City;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Master_Common;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class SearchCity_TC extends TestBase_TC {
    private SearchCity_Page regionSearchCity;
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
    @Test(priority = 2,dataProvider = "JsonProvider")
    public void SearchCityInActive(Map<String, String> city) throws InterruptedException {
        regionSearchCity = new SearchCity_Page(driver);
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        new Master_Common(driver).clickMaster()
                .clickMiscellaneous()
                .clickRegion();
        regionSearchCity.ClickonCity();
        String StateName = city.get("StateName");
        String StateCode = city.get("StateCode");
        String CountryName = city.get("CountryName");
        String CityName = city.get("CityName");
        String CityCode = city.get("CityCode");
        regionSearchCity.SearchRegionCity(StateName,StateCode,CountryName,CityName,CityCode);
        // regionSearchCity.setActiveBtn();
        regionSearchCity.setInActiveBtn();
        regionSearchCity.setClickinactive();
        // Handle pagination and assertions separately
        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            regionSearchCity.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }
        }
    }


    @Test(priority = 3, dataProvider = "JsonProvider")
    public void SearchCityActive(Map<String, String> city) throws InterruptedException {
        regionSearchCity = new SearchCity_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickMiscellaneous()
                .clickRegion();
        regionSearchCity.ClickonCity();
        String StateName = city.get("StateName");
        String StateCode = city.get("StateCode");
        String CountryName = city.get("CountryName");
        String CityName = city.get("CityName");
        String CityCode = city.get("CityCode");
        regionSearchCity.SearchRegionCity(StateName,StateCode,CountryName,CityName,CityCode);
        regionSearchCity.setActiveBtn();
        regionSearchCity.setClickactive();

    }
    @Test(priority = 1,dataProvider = "JsonProvider")
    public void SearchCityBoth(Map<String, String> city) throws InterruptedException {
        regionSearchCity = new SearchCity_Page(driver);
        new Master_Common(driver).clickMaster()
                .clickMiscellaneous()
                .clickRegion();
        regionSearchCity.ClickonCity();
        String StateName = city.get("StateName");
        String StateCode = city.get("StateCode");
        String CountryName = city.get("CountryName");
        String CityName = city.get("CityName");
        String CityCode = city.get("CityCode");
        regionSearchCity.SearchRegionCity(StateName,StateCode,CountryName,CityName,CityCode);
        regionSearchCity.setBoth();

    }



    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}