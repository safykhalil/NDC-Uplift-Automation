package AdminPages.UserManagement.AgencyUserInformation.AgentInformation;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.UserManagement.UserManagement_Common;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class ActionActiveDeactiveAgentInformation_TC extends TestBase_TC {
    AgentInformationnn_Page agentInformation;
    private LogIn_Page logIn;
    String ExpectedResult;
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

   }
    @Test (dataProvider = "ActionAgentInformation", priority = 1)
      public void VerifyClickingOnActiveButtonForAgentOrAdmin(Map<String , String> ActionAgentInformation) throws InterruptedException {
    agentInformation = new AgentInformationnn_Page(driver);
        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
        String EnterAgency = ActionAgentInformation.get("AgencyName");
        agentInformation.SelectAgency(EnterAgency);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        String AgencyName = ActionAgentInformation.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt);
        agentInformation.ClickonSearch();
        agentInformation.ClickOnActiveButtonAdmin();


    }
    @Test (dataProvider = "ActionAgentInformation",priority = 2)
    public void VerifyClickingOnInActiveButtonForAgentOrAdminToActive(Map<String , String> ActionAgentInformation) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
        agentInformation = new AgentInformationnn_Page(driver);


        String EnterAgency = ActionAgentInformation.get("AgencyName");
        agentInformation.SelectAgency(EnterAgency);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName = ActionAgentInformation.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt);
        agentInformation.ClickonSearch();
        agentInformation.ClickOnActiveButtonAdmin2();




    }
    @Test (dataProvider = "ActionAgentInformation",priority = 3)
    public void VerifyClickingOnActiveButtonForAgencyOwner(Map<String , String> ActionAgentInformation) throws InterruptedException {
        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
        agentInformation = new AgentInformationnn_Page(driver);



        String EnterAgency = ActionAgentInformation.get("AgencyName");
        agentInformation.SelectAgency(EnterAgency);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName = ActionAgentInformation.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt);
        agentInformation.ClickonSearch();
        agentInformation.ClickOnActiveButtonAO();
        //agentInformation.ClickOnActiveButtonAO2();


    }

@Test (dataProvider = "ActionAgentInformation",priority = 5)
public void VerifyThatAgencyOwnerCanLoginPortal(Map<String , String> ActionAgentInformation) throws InterruptedException {


    agentInformation.EnterNDCPortal();
    String Select = driver.getDriver().getCurrentUrl();

    if (Select.equals(agentInformation.urlfordashboardportal)) {
        System.out.println("Test Case VerifyThatAgencyOwnerCanLoginPortal Passed");

    } else {
        throw new RuntimeException("Test Case VerifyThatAgencyOwnerCanLoginPortal Failed");
    }


}

}
