package AdminPages.RuleEngine.CancellationCharge;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.RuleEngine.RuleEngine_Common;
import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CancellationCharge_TC extends TestBase_TC {
    private LogIn_Page logIn;
    private CancellationCharge_Page cancellationChargePage;
    public String Charge_Code;
    private RuleEngine_Common cancel;
    SHAFT.TestData.JSON testData;

    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        cancellationChargePage = new CancellationCharge_Page(driver);
        cancel = new RuleEngine_Common(driver);
        testData = new SHAFT.TestData.JSON("CancellationCharge.json");
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();
        cancel.clickRuleEngine().clickCancellationCharge();
    }

    ////////////////////////// to run E2E scenario = Run the CancellationCharge_TC class/////////////////
    @Test(priority = 1)
    public void CreateCancellationCharge(){
        cancellationChargePage = new CancellationCharge_Page(driver);
        cancellationChargePage.BtnAddCancellationCharge();
        cancellationChargePage.Txt_CancellationChargeName(testData.getTestData("Create.Name"));
        cancellationChargePage.TxtCancellationChargeDescription(testData.getTestData("Create.Description"));
        cancellationChargePage.Dpick_ValidityPeriodFrom(testData.getTestData("Create.ValidityPeriodFrom"));
        cancellationChargePage.Dpick_ValidityPeriodTo(testData.getTestData("Create.ValidityPeriodTo"));
        cancellationChargePage.Lst_CountryPos();
        cancellationChargePage.Btn_Select();
        cancellationChargePage.LstFareType(testData.getTestData("Create.FareType"));
        cancellationChargePage.TxtAdult(testData.getTestData("Create.Adult"));
        cancellationChargePage.TxtChild(testData.getTestData("Create.Child"));
        cancellationChargePage.TxtInfant(testData.getTestData("Create.Infant"));
        cancellationChargePage.BtnSendForApproval();
        String Expected = "Added Successfully";
        Assert.assertEquals(cancellationChargePage.ActualCreate(),Expected);
        cancellationChargePage.Rbtn_Active();
        cancellationChargePage.Txt_CancellationChargeName(testData.getTestData("Create.Name"));
        cancellationChargePage.Btn_Search();
        Charge_Code = cancellationChargePage.Get_CancellationChargeCode();
        System.out.println(Charge_Code);
    }

    @Test(priority = 2)
    public void SearchCancellationCharge() throws InterruptedException {
      cancellationChargePage = new CancellationCharge_Page(driver);
      //cancellationChargePage.Rbtn_Active();                        //Uncomment this to run the search TC independent
      cancellationChargePage.Txt_CancellationChargeName(testData.getTestData("Search.Name"));
      cancellationChargePage.Lst_Country(testData.getTestData("Search.Country"));
      cancellationChargePage.Txt_CancellationChargeCode(Charge_Code);
      cancellationChargePage.Btn_Search();
      cancellationChargePage.Btn_ThumpUp().TxtRemarks("test").Btn_Save();
      cancellationChargePage.Rbtn_Active();
      cancellationChargePage.Txt_CancellationChargeCode(Charge_Code);
      cancellationChargePage.Btn_Search();
      Thread.sleep(1000);
    }

    @Test(priority = 3)
    public void UpdateCancellationCharge(){
        cancellationChargePage = new CancellationCharge_Page(driver);
        cancellationChargePage.BtnUpdate();
        cancellationChargePage.Txt_CancellationChargeName(testData.getTestData("Update.Name"));
        cancellationChargePage.TxtCancellationChargeDescription(testData.getTestData("Update.Description"));
        cancellationChargePage.Dpick_ValidityPeriodFrom(testData.getTestData("Update.ValidityPeriodFrom"));
        cancellationChargePage.Dpick_ValidityPeriodTo(testData.getTestData("Update.ValidityPeriodTo"));
        cancellationChargePage.LstFareType(testData.getTestData("Update.FareType"));
        cancellationChargePage.TxtAdult(testData.getTestData("Update.Adult"));
        cancellationChargePage.TxtChild(testData.getTestData("Update.Child"));
        cancellationChargePage.TxtInfant(testData.getTestData("Update.Infant"));
        cancellationChargePage.TxtRemarks("test").BtnApprove();
    }

    @Test(priority = 4)
    public void DeleteCancellationCharge (){
        cancellationChargePage.Btn_Delete();
        String Expected = "No data has been found!";
        String Actual = cancellationChargePage.EmptySearch();
        Assert.assertEquals(Actual, Expected);
    }

}
