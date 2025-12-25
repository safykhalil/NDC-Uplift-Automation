package AdminPages.RuleEngine.OfferPricing;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import AdminPages.RuleEngine.RuleEngine_Common;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.FileUploadUtil;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;



public class TC_UpdateOffer extends TestBase {
    private UpdateOffer_Page Edit;
    private LogIn_Page logIn;
    private SearchOffer_Page Search;

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
        Thread.sleep(3000);
    }
    @Test(dataProvider = "JsonProvider")
    public void UpdateOffer(Map<String, String> Offer) throws InterruptedException {
        Edit = new UpdateOffer_Page(driver);
        Search = new SearchOffer_Page(driver);
        new RuleEngine_Common(driver).clickRuleEngine().clickOfferPricing();
        Search.setBoth();
        Search.search();
        String Discreption = Offer.get("Discreption");
        String Remarks = Offer.get("Remarks");
        Edit.UpdateOffer(Discreption,Remarks);
        Edit.Sendapprove();
        String Expected = "Updated Successfully";
        Assert.assertEquals(Edit.Actual(),Expected);


    }
    @AfterMethod
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.90");
    }

}
