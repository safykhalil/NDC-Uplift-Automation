package AdminPages.UserManagement.AgencyUserInformation.SearchTravellers;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class travellersDetails_TC extends TestBase_TC {
    travellersDetails_Page TravellersDetails;
    private LogIn_Page logIn;


    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }
    @Test
    public void SearchWithValidAgentInformation() throws InterruptedException {
      TravellersDetails  = new travellersDetails_Page(driver);
      TravellersDetails.NavigateToTravellersDetails();
      TravellersDetails.SelectAgency("Test Egypt") ;
      Thread.sleep(3000);
        TravellersDetails.SelectAgent("Nagy abdelhamid");

        TravellersDetails.ClickOnSearchInGrid();

    }
    @Test//
    public void SearchWithValidAgentInformation2NoData() throws InterruptedException {
        TravellersDetails  = new travellersDetails_Page(driver);
        TravellersDetails.SelectAgency("Test Egypt") ;
        TravellersDetails.SelectAgent("ffdfgfg");
        TravellersDetails.ClickOnSearchInGrid();
        String Actual=driver.element().getText(TravellersDetails.NoDataFound);
        Assert.assertEquals(Actual,"No data has been found!");

    }
    @Test
    public void SearchWithOutAgentInformation()
    {
        TravellersDetails  = new travellersDetails_Page(driver);
        TravellersDetails.ClickOnSearchInGrid();
        String Actual=driver.element().getText(TravellersDetails.ValidationOnAgency);
        String Actual2=driver.element().getText(TravellersDetails.ValidationOnAgent);
        Assert.assertEquals(Actual,"required validation error");
        Assert.assertEquals(Actual2,"required validation error");
    }
    @Test
    public void SearchWithInValidPhoneAgentInformation() throws InterruptedException {
        TravellersDetails  = new travellersDetails_Page(driver);
        TravellersDetails.SelectAgency("Test Egypt") ;
        TravellersDetails.SelectAgent("aaaa");
        TravellersDetails.EnterPhoneNumber("123");
        TravellersDetails.ClickOnSearchInGrid();
        String Actual=driver.element().getText(TravellersDetails.validatePhoneNumber);
        Assert.assertEquals(Actual,"validatePhoneNumber validation error");
    }
    @Test
    public void SearchWithInValidEmailAgentInformation() throws InterruptedException {
        TravellersDetails  = new travellersDetails_Page(driver);
        TravellersDetails.SelectAgency("Test Egypt") ;
        TravellersDetails.SelectAgent("aaaa");
        TravellersDetails.EnterEmailID("bvdfb");
        TravellersDetails.ClickOnSearchInGrid();
        String Actual=driver.element().getText(TravellersDetails.validateEmail);
        Assert.assertEquals(Actual,"pattern validation error");
    }
    @Test
    public void SearchWithValidEmailAgentInformation() throws InterruptedException {
        TravellersDetails  = new travellersDetails_Page(driver);
        TravellersDetails.SelectAgency("Test Egypt") ;
        TravellersDetails.SelectAgent("aaaa");
        TravellersDetails.EnterClientID("bvdfb");
        TravellersDetails.ClickOnSearchInGrid();
        String Actual=driver.element().getText(TravellersDetails.validateID);
        Assert.assertEquals(Actual,"Please match the requested format, only numeric values are allowed");
    }
//    @Test
//    public void SearchWithValidEmailAgentInformation2() throws InterruptedException {
//        TravellersDetails.SelectAgency("Test Egypt") ;
//        driver.element().scrollToElement(By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-travellers-details/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/ndc-fg-dropdown-input/p-dropdown/div/p-overlay/div/div/div/div/ul/p-dropdownitem[17]/li/span"));
//
//        TravellersDetails.SelectAgentByIndex(16);
//        Thread.sleep(200000);
//      //  TravellersDetails.ClickOnActiveAgent();
//        TravellersDetails.EnterClientID("115536");
//        TravellersDetails.EnterEmailID("ayafathy3322@gmail.com");
//        TravellersDetails.EnterPhoneNumber("01001212608");
//        TravellersDetails.EnterClientName("asmaa");
//        TravellersDetails.SelectNationality("Egypt");
//        TravellersDetails.ClickOnSearchInGrid();
//
//    }



}

