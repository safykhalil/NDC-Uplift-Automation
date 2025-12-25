package AdminPages.RuleEngine.ServiceCharge;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import AdminPages.Login.TestBase_TC;
import AdminPages.RuleEngine.RuleEngine_Common;
import AdminPages.RuleEngine.ServiceCharge.ServiceCharge_page;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEndService extends TestBase_TC {
    private SHAFT.TestData.JSON testData;
    private ServiceCharge_page service1;
    private RuleEngine_Common ser1;
    @BeforeTest
    public void login(){
        testData = new SHAFT.TestData.JSON("ServiceCharge.json");
        new LogIn_Page(driver).ClickAdmin();
        new LogIn_Page(driver).ClickOnLoginButton();
        service1 = new ServiceCharge_page(driver);
        ser1 = new RuleEngine_Common(driver);
        ser1.clickRuleEngine().clickServiceCharge();
    }
    @Test(priority = 1)
    public void E2E() throws InterruptedException {

        new ServiceCharge_page(driver)

                .ClickAtAddServiceCharge()
                .EnterServiceName(testData.getTestData("Set1.ServiceChargeName"))
                .SelectValidityDate(testData.getTestData("Set1.ValidityFrom"), testData.getTestData("Set1.ValidityTo"))
                .EnterServiceDescription(testData.getTestData("Set1.ServiceChargeDescription"))
                .SelectListCountryPOS(testData.getTestData("Set1.CountryPOS"))
                .SelectListBranch(testData.getTestData("Set1.Branch"))
                .SelectAttribute()
                .SelectOperator()
                .SelectValue()
                .EnterFareType(testData.getTestData("Set1.Value"))
                .Submit();
                service1.search_ServiceCharge(testData.getTestData("SearchSet1.Country"), testData.getTestData("SearchSet1.Branch"));
                service1.bothstatus();
                service1.Edit(testData.getTestData("Update.name"), testData.getTestData("Update.ServicechargeName"),
                        testData.getTestData("Update.ServicechargeDescription"),
                        testData.getTestData("Update.remark"));



    }
        //  .Search(testData.getTestData("Branch"))

}
