package AdminPages.RuleEngine.CancellationCharge;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CancellationCharge_TC extends TestBase_TC {
    private LogIn_Page logIn;
    private CancellationCharge_Page cancellationChargePage;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }

    @Test(dataProvider = "JsonProvider")
    public void SearchCancellationCharge(Map<String, String> Search) throws InterruptedException {
      cancellationChargePage = new CancellationCharge_Page(driver);
      String CancellationChargeName = Search.get("CancellationChargeName");
      String Country = Search.get("Country");
      String CancellationChargeCode = Search.get("CancellationChargeCode");
      cancellationChargePage.BtnRuleEngine();
      cancellationChargePage.BtnCancellationCharge();
      cancellationChargePage.Txt_CancellationChargeName(CancellationChargeName);
      cancellationChargePage.Lst_Country(Country);
      cancellationChargePage.Txt_CancellationChargeCode(CancellationChargeCode);
      cancellationChargePage.Btn_Search();
      Thread.sleep(1000);
    }


    @Test(dataProvider = "JsonProvider")
    public void CreateCancellationCharge(Map<String, String> Create) throws InterruptedException {
        cancellationChargePage = new CancellationCharge_Page(driver);
        String CancellationChargeName = Create.get("CancellationChargeName");
        String CancellationChargeDescription = Create.get("CancellationChargeDescription");
        String ValidityPeriodFrom = Create.get("ValidityPeriodFrom");
        String ValidityPeriodTo = Create.get("ValidityPeriodTo");
        String CountryPos = Create.get("CountryPos");
        String FareType = Create.get("FareType");
        String Adult = Create.get("Adult");
        String Child = Create.get("Child");
        String Infant = Create.get("Infant");
        cancellationChargePage.BtnRuleEngine();
        cancellationChargePage.BtnCancellationCharge();
        cancellationChargePage.BtnAddCancellationCharge();
        cancellationChargePage.Txt_CancellationChargeName(CancellationChargeName);
        cancellationChargePage.TxtCancellationChargeDescription(CancellationChargeDescription);
        cancellationChargePage.Dpick_ValidityPeriodFrom(ValidityPeriodFrom);
        cancellationChargePage.Dpick_ValidityPeriodTo(ValidityPeriodTo);
        cancellationChargePage.Lst_CountryPos();
        cancellationChargePage.Txt_SearchContainer(CountryPos);
        cancellationChargePage.Btn_Select();
        cancellationChargePage.LstFareType(FareType);
        cancellationChargePage.TxtAdult(Adult);
        cancellationChargePage.TxtChild(Child);
        cancellationChargePage.TxtInfant(Infant);
        cancellationChargePage.BtnSendForApproval();
        String Expected = "Added Successfully";
        Assert.assertEquals(cancellationChargePage.ActualCreate(),Expected);
    }
}
