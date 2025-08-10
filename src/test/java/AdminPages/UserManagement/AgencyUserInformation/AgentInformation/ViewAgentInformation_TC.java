package AdminPages.UserManagement.AgencyUserInformation.AgentInformation;

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

public class ViewAgentInformation_TC extends TestBase_TC {
    AgentInformationnn_Page agentInformation;
    String ExpectedResult;
    private LogIn_Page logIn;

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
        agentInformation = new AgentInformationnn_Page(driver);
        agentInformation.NavigateToAgencyInfo();
        agentInformation.OpenAgentInformation();
        agentInformation.OpenAGENTINFORMATION();
    }

    @Test (dataProvider = "ViewAgentInformation",priority = 1)
    public void ValidView(Map <String,String> View) throws InterruptedException {

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = View.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        String AgencyName= View.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt)

        agentInformation.ClickonSearch();

        driver.element().click(agentInformation.Viewbutton);
        WebElement Select = driver.getDriver().findElement(agentInformation.SelectTextFrompopup);
        ExpectedResult = Select.getText();
        String Name = View.get("Name");
        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case ValidView Passed");

        } else {
            throw new RuntimeException("Test Case ValidView Failed");
        }
    }

    @Test (dataProvider = "ViewAgentInformation",priority = 2)
    public void ValidCloseView(Map <String,String> View) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = View.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        String AgencyName= View.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt)

        agentInformation.ClickonSearch();

        driver.element().click(agentInformation.Viewbutton);
        agentInformation.ClickonClose();
        WebElement Select = driver.getDriver().findElement(agentInformation.SelectTextFromTable);
        ExpectedResult = Select.getText();
        String Name = View.get("Name");

        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case ValidCloseView Passed");

        } else {
            throw new RuntimeException("Test Case ValidCloseView Failed");
        }
    }
    @Test (dataProvider = "ViewAgentInformation",priority = 4)
    public void UnlockClickableAndClickYes(Map <String,String> View) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = View.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);

        Thread.sleep(2000);
        String AgencyName= View.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt)

        agentInformation.ClickonSearch();

        agentInformation.ClickonViewAndYes();

        Thread.sleep(1000);
        Validations.verifyThat().element(driver.getDriver(), agentInformation.SuccessfullAlert).isVisible().perform();





    }

    @Test (dataProvider = "ViewAgentInformation",priority = 3)
    public void UnlockClickableAndClickNoClickable(Map <String,String> View) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = View.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        String AgencyName= View.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt)

        agentInformation.ClickonSearch();

        agentInformation.ClickonViewAndNo();

        WebElement Select = driver.getDriver().findElement(agentInformation.SelectTextFromTable);
        ExpectedResult = Select.getText();
        String Name = View.get("Name");

        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case UnlockClickableAndClickNoClickable Passed");

        } else {
            throw new RuntimeException("Test Case UnlockClickableAndClickNoClickable Failed");
        }

    }

}