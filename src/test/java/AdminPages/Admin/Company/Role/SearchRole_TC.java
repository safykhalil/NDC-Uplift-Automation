package AdminPages.Admin.Company.Role;


import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class SearchRole_TC extends TestBase_TC {
    private Staff_Page staff;
    private SearchRolePage searchRole;
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

    @Test
    public void setSearchRoleActive() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setActive();
        searchRole.setSearchGrid();
    }

    @Test
    public void setSearchRoleInactive() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setInactive();
        searchRole.setSearchGrid();
    }


    @Test
    public void setSearchRoleBoth() throws InterruptedException {
        staff = new Staff_Page(driver);
        searchRole = new SearchRolePage(driver);
        staff.Clickonadmin();
        searchRole.setRole("Amed");
        searchRole.setBoth();
        searchRole.setSearchGrid();
    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70/master/flight/preferAirline/add");
    }
}