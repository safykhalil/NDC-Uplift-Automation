package AdminPages.Admin.Staff;
import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class SearchStaff_TC extends TestBase_TC {
    private Staff_Page staff;
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
    public void SearchStaff(Map<String,String> st) throws InterruptedException {
        staff = new Staff_Page(driver);
        staff.Clickonadmin();
        staff.ClickonStuff();
        staff.setBoth();
        String StaffName = st.get("StaffName");
        String UserName = st.get("UserName");
        String Branch = st.get("Branch");
        String Department = st.get("Department");
        staff.fill(StaffName,UserName,Branch,Department);

    }

    @Test(dataProvider = "JsonProvider")
    public void SearchStaffInvalid(Map<String,String> st) throws InterruptedException {
        staff = new Staff_Page(driver);
        staff.Clickonadmin();
        staff.ClickonStuff();
        String StaffName = st.get("StaffName");
        String UserName = st.get("UserName");
        String Branch = st.get("Branch");
        String Department = st.get("Department");
        staff.fill(StaffName,UserName,Branch,Department);
        String Expected = "No data has been found!";
        Assert.assertEquals(staff.Actual_(),Expected);

    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.90");
    }
}