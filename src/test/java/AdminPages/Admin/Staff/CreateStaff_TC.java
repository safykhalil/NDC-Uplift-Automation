package AdminPages.Admin.Staff;

import AdminPages.Admin.AdminMenu;
import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateStaff_TC extends TestBase_TC {

    private Staff_Page addStaff;
    private Staff_Page Staff;
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
        new AdminMenu(driver).openSubAdmin().openStaff();

    }

    @Test(dataProvider = "JsonProvider")
    public void CreateStaff(SHAFT.GUI.WebDriver driver, Map<String,String> st) throws InterruptedException {

        addStaff = new Staff_Page(driver);
       // addStaff.Clickonadmin();
//        addStaff.ClickonStuff();
        addStaff.addstuff();
        String Usertype =st.get("Usertype");
        String SearchOperatingCountry=st.get("SearchOperatingCountry");
        String SearchBranch = st.get("SearchBranch");
        String SearchDepartment =st.get("SearchDepartment");
        String SearchRole = st.get("SearchRole");
        String EmployeeName = st.get("EmployeeName");
        String EmployeeEmail = st.get("EmployeeEmail");
        String EmployeePhoneNo = st.get("EmployeePhoneNo");
        String EmployeeSecondaryNo = st.get("EmployeeSecondaryNo");
        String UserName = st.get("UserName");
        String ApprovalList = st.get("ApprovalList");
        addStaff.AddStuff(Usertype,SearchOperatingCountry,SearchBranch,SearchDepartment,SearchRole
                ,EmployeeName,EmployeeEmail,EmployeePhoneNo,EmployeeSecondaryNo,UserName,ApprovalList);
        addStaff.YesUndercut();
        String Expected = "Added Successfully";
        Assert.assertEquals(addStaff.ActualCreate(),Expected);
    }


    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.90");
    }



}