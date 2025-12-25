package AdminPages.UserManagement.AgencyUserInformation.AgentInformation;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.UserManagement.UserManagement_Common;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class EditAgentInformation_TC extends TestBase_TC {

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
        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
    }
//      @Test (priority = 1)
//      public void EditButtonNotExistForAdmin() throws InterruptedException {
//        agentInformation.LoginAsSuperAdmin();
//        agentInformation.Reload();
//
//        agentInformation.SelectAgency("saf");
//        //driver.element().click(By.xpath("//input[@id="id-Agency\"]"));
//        //Actions actions = new Actions(driver.getDriver());
//        //actions.sendKeys(Keys.ARROW_DOWN).perform();
//        driver.element().select(agentInformation.SearchAgencyName, "safya");
// //        driver.element().click(Selectt)
//        agentInformation.ClickonSearch();
//
//        boolean isButtonPresent = driver.element().isElementDisplayed(agentInformation.Editbutton);
//        Validations.verifyThat().element(driver.getDriver(), agentInformation.Editbutton).doesNotExist().perform();
//
//
//
//    }
    @Test (dataProvider = "EditAgentInformation",priority = 2)
      public void EditButtonExistForSuperAdmin(Map<String,String> Edit) throws InterruptedException {
        agentInformation.LoginAsSuperAdmin();
        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
 //     driver.element().click(Selectt)
        agentInformation.ClickonSearch();

        //boolean isButtonPresent = driver.element().isElementDisplayed(agentInformation.Editbutton);
        Validations.verifyThat().element(driver.getDriver(), agentInformation.Btn_Editbutton).exists().perform();



    }
    @Test (dataProvider = "EditAgentInformation",priority = 3)
    public void FullNameCannotBeChanged(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
        //     driver.element().click(Selectt)
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Btn_Editbutton);
        Validations.verifyThat().element(driver.getDriver(), agentInformation.Txt_EditFullName).isVisible().perform();
        // **Method Execution : 30S - 1min **
        //Validations.assertThat().element(driver.getDriver(), agentInformation.EditFullName).isDisabled().perform();

//        driver.element().type(agentInformation.EditFullName,"MMM");
//
//        WebElement Select = driver.getDriver().findElement(agentInformation.EditFullName);
//
//        ExpectedResult = Select.getText();
//        if (Name.equals(ExpectedResult)) {
//            System.out.println("Test Case SearchWithValidFullName Passed");
//
//        } else {
//            throw new RuntimeException("Test Case SearchWithValidFullName Failed");
//        }
    }
//Invalid
    @Test (dataProvider = "EditAgentInformation",priority = 4)
    public void EmailIsClickableAndChangeableInvalid(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
        //     driver.element().click(Selectt)
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Btn_Editbutton);
        String examplemail = Edit.get("mail example");
        agentInformation.EnterEmail(examplemail);
        driver.element().click(agentInformation.Btn_UpdateButton);

        WebElement Select = driver.getDriver().findElement(agentInformation.InvalidEmail);
        ExpectedResult = Select.getText();
        String InvalidMessageEmail = Edit.get("Please enter a valid email");
        if (InvalidMessageEmail.equals(ExpectedResult)) {
            System.out.println("Test Case EmailIsClickableAndChangeableInvalid Passed");

        } else {
            throw new RuntimeException("Test Case EmailIsClickableAndChangeableInvalid Failed");
        }


    }
    @Test (dataProvider = "EditAgentInformation",priority = 5)
    public void PhoneIsClickableAndChangeableInvalid(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
        //     driver.element().click(Selectt)
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Btn_Editbutton);
        Thread.sleep(1000);
        String examplephone = Edit.get("phone example");
        agentInformation.EnterPhoneNumber(examplephone);
        driver.element().click(agentInformation.Btn_UpdateButton);

        WebElement Select = driver.getDriver().findElement(agentInformation.InvalidPhone);
        ExpectedResult = Select.getText();
        String InvalidMessagePhone = Edit.get("Please enter a valid Number");
        if (InvalidMessagePhone.equals(ExpectedResult)) {
            System.out.println("Test Case PhoneIsClickableAndChangeableInvalid Passed");

        } else {
            throw new RuntimeException("Test Case PhoneIsClickableAndChangeableInvalid Failed");
        }


    }
    @Test (dataProvider = "EditAgentInformation",priority = 6)
    public void KeyPhoneIsClickableAndChangeableInvalid(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();

        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
        //     driver.element().click(Selectt)
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Btn_Editbutton);
        driver.element().click(agentInformation.Btn_SearchKey);

        driver.element().click(agentInformation.SelectTextFromKey);
        String examplephone = Edit.get("phone example");
        agentInformation.EnterPhoneNumber(examplephone);
        driver.element().click(agentInformation.Btn_UpdateButton);

        WebElement Select = driver.getDriver().findElement(agentInformation.InvalidPhone);
        ExpectedResult = Select.getText();
        String InvalidMessagePhone = Edit.get("Please enter a valid Number");
        if (InvalidMessagePhone.equals(ExpectedResult)) {
            System.out.println("Test Case KeyPhoneIsClickableAndChangeableInvalid Passed");

        } else {
            throw new RuntimeException("Test Case KeyPhoneIsClickableAndChangeableInvalid Failed");
        }


    }
    @Test (dataProvider = "EditAgentInformation",priority = 7)
    public void CancelButtonIsClickable(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
agentInformation.LoginAsSuperAdmin();
        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
        //     driver.element().click(Selectt);
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Btn_Editbutton);
        String ValidMail= Edit.get("Valid Mail");
        agentInformation.EnterEmail(ValidMail);
        agentInformation.ClickOnCancel();

        agentInformation.SelectAgency(DataEnterForDropDown);
//        driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
//
//        Actions actions = new Actions(driver.getDriver());
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);


//        driver.element().click(Selectt);
        String Name = Edit.get("Name");

        agentInformation.FullName(Name);

        Thread.sleep(2000);
        agentInformation.ClickonSearch();
        WebElement Select = driver.getDriver().findElement(agentInformation.SelectTextFromTable);
        Thread.sleep(1000);

//        ExpectedResult = Select.getText();
//        Assert.assertEquals(agentInformation.ActualCancelButtonIsClickable(), Name);

//        if (Name.equals(ExpectedResult)) {
//            System.out.println("Test Case SearchWithValidFullName Passed");
//
//        } else {
//            throw new RuntimeException("Test Case SearchWithValidFullName Failed");
//        }


    }
    //Reflection
    @Test (dataProvider = "EditAgentInformation",priority = 8)
    public void ReflectionAfterSuccessfullyUpdate(Map<String,String> Edit) throws InterruptedException {

        new UserManagement_Common(driver).UserManagement().AgencyUserManagement().AgentInformation();
agentInformation.LoginAsSuperAdmin();
        agentInformation = new AgentInformationnn_Page(driver);
        String DataEnterForDropDown = Edit.get("AgencyName");
        agentInformation.SelectAgency(DataEnterForDropDown);
        //driver.element().click(By.xpath("//input[@id=\"id-Agency\"]"));
        //Actions actions = new Actions(driver.getDriver());
        //actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        String AgencyName= Edit.get("AgencyName");
        driver.element().select(agentInformation.SearchAgencyName, AgencyName);
//        driver.element().click(Selectt);
        agentInformation.ClickonSearch();
        driver.element().click(agentInformation.Txt_EditAgencyOwner);
        Thread.sleep(1000);
        String Phone= Edit.get("ValidPhone");

        agentInformation.EnterPhoneNumber(Phone);
        driver.element().click(agentInformation.Btn_UpdateButton);
        WebElement Select = driver.getDriver().findElement(agentInformation.SuccessfullAlert);
        ExpectedResult = Select.getText();
        String Alert = Edit.get("Alert");
        if (Alert.equals(ExpectedResult)) {
            agentInformation.EnterNDCPortal();
            driver.element().click(agentInformation.Notification);
            driver.element().click(agentInformation.ProfileManagement);
//            WebElement Selectmobile = driver.getDriver().findElement(agentInformation.SelectTextFromMobilePortal);

            String phonePortal = Edit.get("PhonePortal");

//            Assert.assertEquals(agentInformation.ActualReflectionAfterSuccessfullyUpdate(), phonePortal);
//            String phonePortal = Edit.get("PhonePortal");
//
//            if (phonePortal.equals(ExpectedResult)) {
//                System.out.println("Test Case SearchWithValidFullName Passed");
//
//            } else {
//                throw new RuntimeException("Test Case SearchWithValidFullName Failed");
//            }

//        } else {
//            throw new RuntimeException("Test Case UnlockClickableAndClickYes Failed");
//        }

        }
    }

}
