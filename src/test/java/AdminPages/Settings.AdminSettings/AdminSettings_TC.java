package AdminPages.Settings.AdminSettings;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class AdminSettings_TC extends TestBase_TC {

    String ExpectedResult;
    AdminSettings_Page adminsettings;
    private LogIn_Page logIn;


    @BeforeTest
    public void SignIn() {
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("odeysysadmin");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();
        adminsettings = new AdminSettings_Page(driver);
        adminsettings.NavigateToAdminSetting();

    }


    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @Test(dataProvider = "JsonProvider")
    public void AdminSettings(Map<String, String> Setting) throws InterruptedException {
        System.out.println("Valid Admin Setting For Flight Limitation");
        adminsettings = new AdminSettings_Page(driver);
        String ValueFlightLimit = Setting.get("ValueFlightLimit");
        adminsettings.EditNewFlightNum(ValueFlightLimit);
        String IndexChoose = Setting.get("IndexChoose");
        String BaseValueOfFlight = Setting.get("BaseValueOfFlight");

        adminsettings.NavigateToFlightLimitation(IndexChoose);
        WebElement Select = driver.getDriver().findElement(adminsettings.GetLimit);
        ExpectedResult = Select.getText();
        String IndexInSearch = Setting.get("ValueFlightLimit");
        if(IndexInSearch.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatCanselIsNotUpdated passed");
        }
        else {
            throw new RuntimeException("Test Case VerifyThatCanselIsNotUpdated Failed");
        }
        adminsettings.NavigateToAdminSetting();
        adminsettings.EditNewFlightNum(BaseValueOfFlight);

    }
    @Test(dataProvider = "JsonProvider")
    public void ValidAdminSetting_TC2(Map<String, String> Setting) throws InterruptedException {
        System.out.println("Valid Admin Setting For Up-Selling");
        adminsettings = new AdminSettings_Page(driver);

        String UpSelling1 = Setting.get("UpSelling1");
        String UpSelling2 = Setting.get("UpSelling2");

        adminsettings.EditNewUpsellingNum(UpSelling1);
        adminsettings.LoginAsAdmin();
        adminsettings.NavigateToBooking();
        adminsettings.LoginAsSuperAdmin();
        adminsettings.NavigateToAdminSetting();
        adminsettings.EditNewUpsellingNum(UpSelling2);

    }

}
