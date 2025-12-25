package AdminPages.RuleEngine.ServiceCharge;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.RuleEngine.RuleEngine_Common;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchserviceCharge extends TestBase_TC {
    private SHAFT.TestData.JSON testData;
    private ServiceCharge_page service;
    private RuleEngine_Common ser;


    @BeforeTest
    public void login() {
        testData = new SHAFT.TestData.JSON("ServiceCharge.json");
        new LogIn_Page(driver).ClickSuperAdmin();
        new LogIn_Page(driver).ClickOnLoginButton();
        service = new ServiceCharge_page(driver);
        ser = new RuleEngine_Common(driver);


    }


    @Test
    public void TC002_filterActive() {
        ser.clickRuleEngine().clickServiceCharge();

        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");


        service.search_ServiceCharge(country, branch);
        service.activestatus();
        driver.verifyThat().element(service.StatusCellActive).exists();
    }
    @Test
    public void TC003_filterInactive() {
        ser.clickRuleEngine().clickServiceCharge();
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");


        service.search_ServiceCharge(country, branch);
        service.inactivestatus();
        driver.verifyThat().element(service.StatusCellInactive).exists();
    }
    @Test
    public void TC004_filterBoth() {
        ser.clickRuleEngine().clickServiceCharge();
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");


        service.search_ServiceCharge(country, branch);
        service.bothstatus();
        driver.verifyThat().element(service.Table_FirstRow).exists();
    }
    @Test
    public void TC005_paginationNext() {
        ser.clickRuleEngine().clickServiceCharge();
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");


        service.search_ServiceCharge(country, branch);
        service.goToNextPage();
        driver.verifyThat().element(service.Table_FirstRow).exists();
    }
    @Test
    public void TC006_paginationLast() {
        ser.clickRuleEngine().clickServiceCharge();
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");


        service.search_ServiceCharge(country, branch);
        service.goToLastPage();
        driver.verifyThat().element(service.Table_FirstRow).exists();
    }
    @Test
    public void TC007_ApproveService()
    {
        ser.clickRuleEngine().clickServiceCharge();
        String servicename = testData.getTestData("Actions.servicename");
        String remark  = testData.getTestData("Actions.remark");
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");
        service.search_ServiceCharge(country, branch);
        service.inactivestatus();
        service.approveAction(servicename,remark);
        service.activestatus();
        String actualMessage = driver.element().getText(By.xpath("//div[contains(@class,'toast-message')]"));

// Construct expected message
        String expectedMessage = servicename + " is Approved Successfully";

// Assertion
        Assert.assertEquals(actualMessage, expectedMessage, "The approval message is incorrect!");

    }
    @Test
    public void TC008_RejectService()
    {
        ser.clickRuleEngine().clickServiceCharge();
        String servicename = testData.getTestData("Actions.servicename");
        String remark  = testData.getTestData("Actions.remark");
        String country = testData.getTestData("SearchSet1.Country");
        String branch  = testData.getTestData("SearchSet1.Branch");
        service.search_ServiceCharge(country, branch);
        service.activestatus();
        service.rejectAction(servicename,remark);
        service.inactivestatus();
        String actualMessage = driver.element().getText(By.xpath("//div[contains(@class,'toast-message')]"));

// Construct expected message
        String expectedMessage = servicename + " is Rejected Successfully";

// Assertion
        Assert.assertEquals(actualMessage, expectedMessage, "The approval message is incorrect!");


    }
}



