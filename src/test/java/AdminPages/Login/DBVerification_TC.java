package AdminPages.Login;

import DBs_Query_Execution.A_Run_Query_OnSTG_DB_TC;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBVerification_TC extends TestBase_TC {

    LogIn_Page login;
    SHAFT.TestData.JSON testData;
    OTPCodeVerification_Page Otp;
    A_Run_Query_OnSTG_DB_TC DB;


    @BeforeTest
    public void sign(){
        login = new LogIn_Page(driver);
        testData = new SHAFT.TestData.JSON("MailCredentials.json");
        login.EnterUserName(testData.getTestData("admin.Username"));
        login.EnterPassword(testData.getTestData("admin.Password"));
        login.ClickOnLoginButton();

    }

    @Test
    public void OTPVerificationValidCode() throws InterruptedException {
        Otp = new OTPCodeVerification_Page(driver);
        DB = new A_Run_Query_OnSTG_DB_TC();
        Otp.OTPRequest();
        String otp = DB.getLatestOTP();
        Otp.OTPSubmit(otp);
        Thread.sleep(3000);
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "operating-country";
        Assert.assertTrue(ActualResult.contains(ExpectedResult), "the user is logged in successfully");
    }

    @Test
    public void ResendOTP() throws InterruptedException {
        Otp = new OTPCodeVerification_Page(driver);
        DB = new A_Run_Query_OnSTG_DB_TC();
        Otp.OTPRequest();
        String old_otp = DB.getLatestOTP();
        System.out.println("old_otp = " + old_otp);
        Otp.OTPResend();
        String new_otp = DB.getLatestOTP();
        System.out.println("new_otp = " + new_otp);
        Assert.assertNotEquals(old_otp, new_otp, "The new code generated successfully");
        Otp.OTPSubmit(old_otp);
        String ActualResult1 = Otp.InvalidCode();
        String ExpectedResult2 = "Invalid";
        Assert.assertTrue(ActualResult1.contains(ExpectedResult2), "the error message appears successfully");
        Otp.OTPSubmit(new_otp);
        Thread.sleep(3000);
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "operating-country";
        Assert.assertTrue(ActualResult.contains(ExpectedResult), "the user is logged in successfully");
    }
}
