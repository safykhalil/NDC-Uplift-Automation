package AdminPages.RuleEngine.TermsAndConditions;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.Flight.Airline.Airline_Page;
import AdminPages.RuleEngine.RuleEngine_Common;
import org.python.antlr.ast.Str;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ActionTermsAndConditions_TC extends TestBase_TC {
    private TermsAndConditions_Page TermAndCon;
    String Remarks = "Ok";
    private TermsAndConditions_Page createTerm;
    private LogIn_Page logIn;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign() throws InterruptedException {
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
        Thread.sleep(2000);

    }


    @Test(priority =1)
    public void VerifyThumbsUp() throws InterruptedException {
        TermAndCon = new TermsAndConditions_Page(driver);
        new RuleEngine_Common(driver).clickRuleEngine().clickTermsAndConditions();
        TermAndCon.ClickOnActiveAndInactive();
        TermAndCon.ClickOnSearch();
        TermAndCon.ActiveTerm(Remarks);
        TermAndCon.ClickOnSearch();
        String Expected= "Galileo";
        String Expected2= "pending For Approval";
        Thread.sleep(2000);
        assertEquals(TermAndCon.GetSupplier(), Expected);
        assertEquals(TermAndCon.GetStatus(), Expected2);

    }
    @Test(priority =2)
    public void VerifyThumbsDown() throws InterruptedException {
        TermAndCon = new TermsAndConditions_Page(driver);
        new RuleEngine_Common(driver).clickRuleEngine().clickTermsAndConditions();
        TermAndCon.ClickOnSearch();
        TermAndCon.RejectTerm(Remarks);
        TermAndCon.ClickOnActiveAndInactive();
        TermAndCon.ClickOnSearch();
        String Expected= "Galileo";
        String Expected2= "Reject";
        Thread.sleep(2000);
        assertEquals(TermAndCon.GetSupplier(), Expected);
        assertEquals(TermAndCon.GetStatus(), Expected2);
        Thread.sleep(2000);
        TermAndCon.ActiveTerm(Remarks);

    }


    @Test(priority = 3)
    public void ActiveTerm() throws InterruptedException {
        TermAndCon = new TermsAndConditions_Page(driver);
        new RuleEngine_Common(driver).clickRuleEngine().clickTermsAndConditions();
        TermAndCon.ClickOnActiveAndInactive();
        TermAndCon.ClickOnSearch();
        TermAndCon.ActiveTerm(Remarks);
        String Expected= "Galileo";
        String Expected2= "pending For Approval";
        Thread.sleep(2000);
        assertEquals(TermAndCon.GetSupplier(), Expected);
        assertEquals(TermAndCon.GetStatus(), Expected2);

    }
    @Test(priority = 4)
    public void InactiveTerm() throws InterruptedException {
        TermAndCon = new TermsAndConditions_Page(driver);
        new RuleEngine_Common(driver).clickRuleEngine().clickTermsAndConditions();
        TermAndCon.ClickOnSearch();
        TermAndCon.ClickOnInactiveCircle();
        TermAndCon.ClickOnActiveAndInactive();
        TermAndCon.ClickOnSearch();
        String Expected= "Galileo";
        String Expected2= "Approved";
        Thread.sleep(2000);
        assertEquals(TermAndCon.GetSupplier(), Expected);
        assertEquals(TermAndCon.GetStatus(), Expected2);
        TermAndCon.ClickOnEdit();
        TermAndCon.ClickOnSendForApprovalEdit();
        Thread.sleep(2000);
        String Expected3 = "http://192.168.1.216/rule-engine/terms";
        String Actual = driver.browser().getCurrentURL();
        Assert.assertEquals(Actual, Expected3);
    }

}