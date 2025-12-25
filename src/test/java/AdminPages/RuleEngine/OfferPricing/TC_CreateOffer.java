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



public class TC_CreateOffer extends TestBase {
    private CreateOffer_Page Create;
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
        Thread.sleep(3000);
    }
    @Test(dataProvider = "JsonProvider")
    public void CreateOffer(Map<String, String> Offer) throws InterruptedException {
        new RuleEngine_Common(driver).clickRuleEngine().clickOfferPricing();
        Create = new CreateOffer_Page(driver);
        String Discount = Offer.get("Discount");
        String Discreption = Offer.get("Discreption");
        Create.CreateOffer(Discount,Discreption);
        Create.img();
        By fileInputLocator = By.xpath("(//input[@type='file'])[1]");
        String filePath = "C:\\Users\\Mohamed Shalaby\\Desktop\\image.jpg";
        FileUploadUtil.uploadFile(driver.getDriver(), fileInputLocator, filePath);
        Create.Sendapprove();
        String Expected = "Added Successfully";
        Assert.assertEquals(Create.Actual(),Expected);


    }
    @AfterMethod
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.90");
    }

}
