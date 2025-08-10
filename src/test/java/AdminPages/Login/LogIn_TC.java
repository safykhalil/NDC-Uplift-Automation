package AdminPages.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogIn_TC extends TestBase_TC {
    //Valid
    LogIn_Page login;

    @Test (priority = 1)
    public void LogInWithAdminValidData() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("e.saady\n");  // Use the inherited logIn object
        login.EnterPassword("qqE6)Cxp6>B8");
        // logIn.ClickRememberMe();
        login.ClickOnLoginButton();
        Thread.sleep(3000);
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "http://192.168.1.90/admin/operating-country";
        Assert.assertEquals(ActualResult, ExpectedResult, "User is logged in successfully");
        Thread.sleep(3000);
        login.ClickOnLogOutLinkButton("Logout");

        String ExpectedResult2 =  "http://192.168.1.90/auth/login";
        String ActualResult2 = driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ActualResult2, ExpectedResult2, "User is logged out successfully");
        Thread.sleep(3000);
    }
    @Test(priority = 2)
    public void LogInWithSuperAdminValidData() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("odeysysadmin");
        login.EnterPassword("qqE6)Cxp6>B8");
        login.ClickOnLoginButton();
        Thread.sleep(3000);
        String ActualResult = driver.getDriver().getCurrentUrl();
//        String ExpectedResult = "http://192.168.1.90/admin/operating-country";
//        Assert.assertEquals(ActualResult, ExpectedResult, "User is logged in  not successfully");
        login.ClickOnLogOutLinkButton("Logout");

        String ExpectedResult2 = "http://192.168.1.90/auth/login";
        String ActualResult2 = driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ActualResult2, ExpectedResult2, "User is logged out successfully");
        Thread.sleep(3000);
    }
    //InValid
    @Test(priority = 3)
    public void LogInWithEmptyFields() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("");  // Use the inherited logIn object
        login.EnterPassword("");
        login.ClickOnLoginButton();
        String ActualResult = driver.element().getText(login.Txt_ErrorOfUserName);
        String ExpectedResult = "Username is required";
        Assert.assertEquals(ActualResult, ExpectedResult, "Filed Not Empty or not equal ");
        String ExpectedResult2 = "Password is required";
        String ActualResult2 = driver.element().getText(login.Txt_ErrorOfPassword);
        Assert.assertEquals(ActualResult2, ExpectedResult2, "Filed Not Empty or not equal");
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void LogInWithInvalidUerName() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("Asmaa");  // Use the inherited logIn object
        login.EnterPassword("qqE6)Cxp6>B8");
        login.ClickOnLoginButton();
        String ErrorMessage=driver.element().getText(login.Txt_InValidCred);
        String ErrorMessage2="Invalid credentials, Please try again.";
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "http://192.168.1.70/auth/login";
        Assert.assertEquals(ActualResult, ExpectedResult, " the user is login successfully  ");
        Assert.assertEquals(ErrorMessage, ErrorMessage2, " the user is login successfully  ");
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void LogInWithInvalidPassword() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("e.saady");  // Use the inherited logIn object
        login.EnterPassword("invalid password");
        login.ClickOnLoginButton();
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "http://192.168.1.70/auth/login";
        String ErrorMessage=driver.element().getText(login.Txt_InValidCred);
        String ErrorMessage2="Invalid credentials, Please try again.";
        Assert.assertEquals(ActualResult, ExpectedResult, " the user is login successfully  ");
        Assert.assertEquals(ErrorMessage, ErrorMessage2, " the user is login successfully  ");
        Thread.sleep(3000);

    }

    @Test(priority =6)
    public void LogInWithArabicAndValidPassword() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("اسماء");  // Use the inherited logIn object
        login.EnterPassword("qqE6)Cxp6>B8");
        login.ClickOnLoginButton();
        String ActualResult = driver.element().getText(login.Txt_ErrorOfUserName);
//        String ExpectedResult = "required validation error";
//        Assert.assertEquals(ActualResult, ExpectedResult, "Filed Not Empty or not equal ");
        String ActualResult2 = driver.getDriver().getCurrentUrl();
        String ExpectedResult2 = "http://192.168.1.70/auth/login";
        Assert.assertEquals(ActualResult2, ExpectedResult2, " the user is login successfully  ");
        Thread.sleep(3000);

    }
    @Test(priority = 7)
    public void LogInWithInvalidCreditional() throws InterruptedException {
        login = new LogIn_Page(driver);
        login.EnterUserName("Asmaa");  // Use the inherited logIn object
        login.EnterPassword("qqE6)Cxp6>B8");
        login.ClickOnLoginButton();
        String ActualResult = driver.getDriver().getCurrentUrl();
        String ExpectedResult = "http://192.168.1.70/auth/login";
        Assert.assertEquals(ActualResult, ExpectedResult, " the user is login successfully  ");
        Thread.sleep(3000);
    }
}