package AdminPages.Master.Supplier.FlightSearchLimitation;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;

import AdminPages.Master.Master_Common;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class FlightSearchLimitationSearch_TC extends TestBase_TC {

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
        new Master_Common(driver).clickMaster()
                .clickSupplierMenue()
                .clickFlightSearchLimitation();

    }

    @Test (dataProvider = "JsonProvider",priority = 1)
      public void VerifyThatCredentialNameIsClickableEditableValidCaseExist(Map<String,String> Search) throws InterruptedException {
        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);

        String TypeName = Search.get("TypeName");
        FlightLimit.ClickAndTypeName(TypeName);
        FlightLimit.ClickOnSearch();


        WebElement Select = driver.getDriver().findElement(FlightLimit.Lst_SelectTextFromTable);

        ExpectedResult = Select.getText();
        String Name = Search.get("Name");
        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithValidFullName Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithValidFullName Failed");
        }
    }
    @Test (dataProvider = "JsonProvider",priority = 2)
    public void VerifyThatCredentialNameIsClickableEditableInvalidCaseExist(Map<String,String> Search) throws InterruptedException {
        FlightLimit.Reload();
        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);

        String InvalidType = Search.get("InvalidType");
        FlightLimit.ClickAndTypeName(InvalidType);
        FlightLimit.ClickOnSearch();


        WebElement Select = driver.getDriver().findElement(FlightLimit.Lst_SelectNoData);

        ExpectedResult = Select.getText();
        String InvalidIndex = Search.get("InvalidIndex");
        if (InvalidIndex.equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithValidFullName Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithValidFullName Failed");
        }
    }
    @Test (dataProvider = "JsonProvider",priority = 3)
    public void VerifyThatStatusActiveThatClickableAndReturnTrueCredentialsWithitsTrueStatus(Map<String,String> Search)
            throws InterruptedException {
        FlightLimit.Reload();

        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);


        String TypeName = Search.get("TypeName");
        FlightLimit.ClickAndTypeName(TypeName);

        FlightLimit.ClickOnSearch();

        WebElement Select = driver.getDriver().findElement(FlightLimit.Lst_SelectTextFromTable);

        ExpectedResult = Select.getText();
        String Name = Search.get("Name");
        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatStatusActiveBothThatClickableAndReturnTrueCredentialsWithitsTrueStatus Passed");

        } else {
            throw new RuntimeException("Test Case VerifyThatStatusActiveBothThatClickableAndReturnTrueCredentialsWithitsTrueStatus Failed");
        }



    }
    @Test (dataProvider = "JsonProvider",priority = 4)
    public void VerifyThatStatusInactiveThatClickableAndReturnTrueCredentialsWithitsTrueStatus(Map<String,String> Search)
            throws InterruptedException {
        FlightLimit.Reload();

        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);
        String InvalidType = Search.get("InvalidType");
        FlightLimit.ClickAndTypeName(InvalidType);

        FlightLimit.ClickOnInactive();
        FlightLimit.ClickOnSearch();

        WebElement Select1 = driver.getDriver().findElement(FlightLimit.Lst_SelectNoData);

        String InvalidIndex = Search.get("InvalidIndex");
        ExpectedResult = Select1.getText();
        if (InvalidIndex.equals(ExpectedResult)) {
            System.out.println("Test Case VerifyThatStatusInactiveThatClickableAndReturnTrueCredentialsWithitsTrueStatus Passed");

        } else {
            throw new RuntimeException("Test Case VerifyThatStatusInactiveThatClickableAndReturnTrueCredentialsWithitsTrueStatus Failed");
        }
    }
    @Test (dataProvider = "JsonProvider",priority = 5)
    public void VerifyThatStatusBothThatClickableAndReturnTrueCredentialsWithitsTrueStatus(Map<String,String> Search)
            throws InterruptedException {
        FlightLimit.Reload();
        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);


        String TypeName = Search.get("TypeName");
        FlightLimit.ClickAndTypeName(TypeName);
        FlightLimit.ClickOnBoth();
        FlightLimit.ClickOnSearch();

        WebElement Select = driver.getDriver().findElement(FlightLimit.Lst_SelectTextFromTable);

        String Name = Search.get("Name");
        ExpectedResult = Select.getText();
        if (Name.equals(ExpectedResult)) {
            System.out.println("TC VerifyThatStatusBothThatClickableAndReturnTrueCredentialsWithitsTrueStatus Passed");

        } else {
            throw new RuntimeException("TC VerifyThatStatusBothThatClickableAndReturnTrueCredentialsWithitsTrueStatus Failed");
        }

    }
    @Test (dataProvider = "JsonProvider",priority = 6)
    public void VerifyThatEditButtonIsClickable (Map<String,String> Search)throws InterruptedException{
        FlightLimit.Reload();
        FlightLimit = new FlightSearchLimitation_Page(driver);
        String IndexChoose = Search.get("IndexChoose");
        FlightLimit.ClickOnSupplierAndChooseIndex(IndexChoose);
        String TypeName = Search.get("TypeName");
        FlightLimit.ClickAndTypeName(TypeName);
        FlightLimit.ClickOnBoth();
        FlightLimit.ClickOnSearch();
        FlightLimit.ClickOnEditButton();

    }
    @Test (dataProvider = "JsonProvider",priority = 7)
    public void VerifyThatPaginationButtonIsClickable (Map<String,String> Search)throws InterruptedException{
        FlightLimit.Reload();

        FlightLimit.ClickOnSearch();
        FlightLimit.ClickOnPagination();
    }

    }
