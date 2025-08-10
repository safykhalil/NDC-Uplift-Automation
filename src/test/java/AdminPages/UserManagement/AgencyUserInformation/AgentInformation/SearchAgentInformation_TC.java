package AdminPages.UserManagement.AgencyUserInformation.AgentInformation;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class SearchAgentInformation_TC extends TestBase_TC {
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


    //VALID
    @Test (dataProvider = "SearchAgentInformation",priority = 1)
    public void SearchWithValidFullName(Map<String,String> Search) throws InterruptedException {

        agentInformation = new AgentInformationnn_Page(driver);
    String DataEnterForDropDown = Search.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);

        Thread.sleep(2000);
        String AgencyName= Search.get("AgencyName");

        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//
String Name = Search.get("Name");
        agentInformation.FullName(Name);


        agentInformation.ClickonSearch();

        WebElement Select = driver.getDriver().findElement(agentInformation.SelectTextFromTable);

         ExpectedResult = Select.getText();
        if (Name.equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithValidFullName Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithValidFullName Failed");
        }
    }
    @Test(dataProvider = "SearchAgentInformation",priority = 2)
    public void SearchWithValidPhone(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//        driver.element().click(Selectt);
        String Phone = Search.get("Phone");
        /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        agentInformation.EnterAgentPhoneNumber(Phone);


        agentInformation.ClickonSearch();
//        String Select = ElementActions.getInstance().getText(By.xpath("//td[contains(text(),'safy')]"));
        String Name = Search.get("Name");


//        if (Name.equals(Select)) {
//            System.out.println("Test Case SearchWithValidPhone Passed");
//
//        } else {
//            throw new RuntimeException("Test Case SearchWithValidPhone Failed");
//        }
    }
    @Test(dataProvider = "SearchAgentInformation",priority = 3)
    public void SearchWithValidEmail(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();
        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);

//        driver.element().click(Selectt);
        String Email = Search.get("Email");
        agentInformation.EnterAgentEmail(Email);


        agentInformation.ClickonSearch();

//        String Select = ElementActions.getInstance().getText(By.xpath("//td[contains(text(),'safy')]"));
        String Name = Search.get("Name");


//        if (Name.equals(Select)) {
//            System.out.println("Test Case SearchWithValidEmail Passed");
//
//        } else {
//            throw new RuntimeException("Test Case SearchWithValidEmail Failed");
//        }
    }
    @Test(dataProvider = "SearchAgentInformation",priority = 4)
    public void SearchWithValidNameAndPhoneAndEmail(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//        driver.element().click(Selectt);
        String Phone = Search.get("Phone");
        String Email = Search.get("Email");
        String Name = Search.get("Name");
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        agentInformation.EnterAgentEmail(Email);
        agentInformation.FullName(Name);
//        agentInformation.EnterAgentPhoneNumber(Phone);

        agentInformation.ClickonSearch();

//        String Select = ElementActions.getInstance().getText(By.xpath("//td[contains(text(),'safy')]"));



//        if (Name.equals(Select)) {
//            System.out.println("Test Case SearchWithValidNameAndPhoneAndEmail Passed");
//
//        } else {
//            throw new RuntimeException("Test Case SearchWithValidNameAndPhoneAndEmail Failed");
//        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Invalid
    @Test(priority = 5)
    public void SearchWithoutRequiredSelectAgency() throws InterruptedException {
        //agentInformation.SelectAgency("Saf");
        agentInformation.Reload();

        try {
            agentInformation.ClickonSearch();
            String STRING = String.valueOf(agentInformation.STR);
            if (STRING.equals(" Agency is required ")) {
                System.out.println("Test Case SearchWithoutRequiredSelectAgency Passed");
            } else {
                throw new RuntimeException("Test Case SearchWithoutRequiredSelectAgency Failed");
            }
        } catch (Exception e) {
            System.out.println("Test Case SearchWithoutRequiredSelectAgency Passed");
        }
    }


    @Test(dataProvider = "SearchAgentInformation",priority = 6)
    public void SearchWithInvalidPhoneNumber(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
//        driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
//
//        Actions actions = new Actions(driver.getDriver());
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//        driver.element().click(Selectt);
        String Name = Search.get("Name");

        agentInformation.FullName(Name);
        agentInformation.EnterAgentPhoneNumber("652+jfngg44567891");

        agentInformation.ClickonSearch();
        WebElement Select = driver.getDriver().findElement(agentInformation.SelectInvalidTextPhone);

         ExpectedResult = Select.getText();
         String InvalidMessage =Search.get("Invalid Phone Number");
        if (InvalidMessage.equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithInvalidPhoneNumber Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithInvalidPhoneNumber Failed");
        }
    }
    @Test(dataProvider = "SearchAgentInformation",priority = 7)
    public void SearchWithInvalidEmail(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();
        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
//        driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
//
//        Actions actions = new Actions(driver.getDriver());
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);

//        driver.element().click(Selectt);
        String Name = Search.get("Name");

        agentInformation.FullName(Name);
        String InvalidEmail = Search.get("InvalidEmail");
        agentInformation.EnterAgentEmail(InvalidEmail);

        agentInformation.ClickonSearch();

        WebElement Select = driver.getDriver().findElement(agentInformation.SelectInvalidTextEmail);

        ExpectedResult = Select.getText();
        String InvalidMessage= Search.get("Please enter valid email");
        if (InvalidMessage.equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithInvalidEmail Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithInvalidEmail Failed");
        }
    }
    @Test(dataProvider = "SearchAgentInformation",priority = 8)
    public void SearchWithValidDataAndNotExistName(Map<String,String> Search) throws InterruptedException {
        agentInformation.Reload();
        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Search.get("DataEnterForDropDown");
        agentInformation.SelectAgency(DataEnterForDropDown);
//        driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
//
//
//        Actions actions = new Actions(driver.getDriver());
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Search.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//        driver.element().click(Selectt);
        String AnotherName= Search.get("AnotherName");

        agentInformation.FullName(AnotherName);

        agentInformation.ClickonSearch();

        WebElement Select = driver.getDriver().findElement(agentInformation.SelectNoDataFound);

        ExpectedResult = Select.getText();
        if ("No data has been found!".equals(ExpectedResult)) {
            System.out.println("Test Case SearchWithValidDataAndNotExistName Passed");

        } else {
            throw new RuntimeException("Test Case SearchWithValidDataAndNotExistName Failed");
        }
    }

}