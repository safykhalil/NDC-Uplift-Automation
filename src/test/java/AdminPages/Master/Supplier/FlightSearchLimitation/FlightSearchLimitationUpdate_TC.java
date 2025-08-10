package AdminPages.Master.Supplier.FlightSearchLimitation;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class FlightSearchLimitationUpdate_TC extends TestBase_TC {

    String ExpectedResult;

    private LogIn_Page logIn;
    FlightSearchLimitation_Page FlightLimit;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void SignIn (){
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("E.saady");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();
        FlightLimit = new FlightSearchLimitation_Page(driver);
        FlightLimit.NavigateToMaster();
        FlightLimit.OpenSupplier();
        FlightLimit.OpenFlightSearchLimitation();

    }

    @Test(dataProvider = "JsonProvider",priority = 1)
    public void VerifyThatSupplierNameIsNotClickable(Map<String ,String > Update) throws InterruptedException {

        FlightLimit.ClickOnEditButton();

        Validations.verifyThat().element(driver.getDriver(), FlightLimit.EditSupplierName).isVisible().perform();
    }

    @Test(dataProvider = "JsonProvider",priority = 2)
    public void VerifyThatSupplierCredentialIsNotClickable(Map<String ,String > Update) throws InterruptedException {
        FlightLimit.Reload();
        FlightLimit.ClickOnEditButton();

        Validations.verifyThat().element(driver.getDriver(), FlightLimit.EditSupplierCredentials).isVisible().perform();

    }

    @Test(dataProvider = "JsonProvider",priority = 3)
    public void VerifyThatUpdateIsUpdatedSuccessfully(Map<String ,String > Update) throws InterruptedException{
        FlightLimit.LoginAsSuperAdmin();
        FlightLimit.Reload();
        FlightLimit.ClickOnEditButton();
        String IndexChoose = Update.get("IndexChoose");
        FlightLimit.ClickonLimitDropDown(IndexChoose);
        FlightLimit.ClickOnUpdate();
        WebElement Select = driver.getDriver().findElement(FlightLimit.SuccessfullAlert);
        ExpectedResult = Select.getText();
        String Edit = Update.get("Edit");

        if(Edit.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatUpdateIsUpdatedSuccessfully passed");
        }
        else {
            throw new RuntimeException("Test Case VerifyThatUpdateIsUpdatedSuccessfully Failed");
        }
    }
    @Test(dataProvider = "JsonProvider",priority = 4)
    public void VerifyThatCanselIsNotUpdated(Map<String ,String > Update) throws InterruptedException{
        FlightLimit.Reload();
        FlightLimit.ClickOnEditButton();
        String AnotherIndexChoose = Update.get("AnotherIndexChoose");
        FlightLimit.ClickonLimitDropDown(AnotherIndexChoose);
        FlightLimit.ClickOnCancel();
        WebElement Select = driver.getDriver().findElement(FlightLimit.GetLimit);
        ExpectedResult = Select.getText();
        String IndexInSearch = Update.get("IndexInSearch");
        if(IndexInSearch.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatCanselIsNotUpdated passed");
        }
        else {
            throw new RuntimeException("Test Case VerifyThatCanselIsNotUpdated Failed");
        }
    }
    //Reflections
    @Test(dataProvider = "JsonProvider",priority = 5)
    public void VerifyThatSuccessfulUpdatedOnSupplier(Map<String ,String > Update) throws InterruptedException {
//        FlightLimit.LoginAsSuperAdmin();
        FlightLimit.Reload();

        FlightLimit.ClickOnEditButton();
        String IndexChoose = Update.get("IndexChoose");
        FlightLimit.ClickonLimitDropDown(IndexChoose);
        FlightLimit.ClickOnUpdate();
        WebElement Select = driver.getDriver().findElement(FlightLimit.GetLimit);
        ExpectedResult = Select.getText();

        String IndexInSearch = Update.get("IndexInSearch");
        if(IndexInSearch.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatUpdateIsUpdatedSuccessfully passed");
        } else {
            throw new RuntimeException("Test Case VerifyThatUpdateIsUpdatedSuccessfully Failed");
        }
    }
    @Test(dataProvider = "JsonProvider",priority = 6)
    public void VerifyThatSuccessfulUpdatedFromSupplierCredentialOnSearch(Map<String ,String > Update) throws InterruptedException {
        FlightLimit.Reload();
        FlightLimit.ClickOnEditButton();
        String AnotherIndexChoose = Update.get("AnotherIndexChoose");
        FlightLimit.ClickonLimitDropDown(AnotherIndexChoose);
        FlightLimit.ClickOnUpdate();
        FlightLimit.NavigateToSupplierCredential();
        FlightLimit.ClickOnEditButton();
        String IndexSupplierCredential = Update.get("IndexSupplierCredential");
        FlightLimit.ClickOnLimitOnSupplierCredentialAndChoose(IndexSupplierCredential);
        Thread.sleep(15000);
        FlightLimit.ClickOnSaveInSupplierCredential();
        FlightLimit.Reload();
        FlightLimit.ClickOnSearch();
        WebElement Select = driver.getDriver().findElement(FlightLimit.GetLimit);
        ExpectedResult = Select.getText();

        if (AnotherIndexChoose.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatUpdateIsUpdatedSuccessfully passed");
        } else {
            throw new RuntimeException("Test Case VerifyThatUpdateIsUpdatedSuccessfully Failed");
        }
    }
}