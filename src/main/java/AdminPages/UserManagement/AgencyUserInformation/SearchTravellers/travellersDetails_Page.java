package AdminPages.UserManagement.AgencyUserInformation.SearchTravellers;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static org.openqa.selenium.By.xpath;

public class travellersDetails_Page {
    private final SoftAssert softAssert;

    public travellersDetails_Page(SHAFT.GUI.WebDriver driver) {

        this.softAssert = new SoftAssert();

        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver;
    By Btn_UserManagment = By.xpath("//a[@href=\"/management\"]");
    By Btn_AgencyUser = By.linkText("Agency User Information");
    By Btn_Profile = By.xpath("//a[@href=\"/management/agency/travellers-details\"]");
    private final By Txt_Agency =By.xpath("//input[@id=\"id-Agency\"]");
    private final By Lst_Agent =By.xpath("//p-dropdown[.//input[@id=\"id-Agent\"]]");
    private final By Txt_ClientID=By.id("id-ClientID");
    private final By Txt_ClientName =By.id("id-Clientname");
    private final By  Txt_EmailID  =By.id("id-EmailID");
    private final By  Txt_PhoneNumber  =By.xpath("//input[@id=\"phone number\"]");
    private final By  Lst_SelectCorporate  =By.id("id-Selectcorporate");
    private final By  Txt_Type  =By.xpath("//div[@class=\"p-multiselect-label p-placeholder\"]");
    private final By  Lst_Nationality  =By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-travellers-details/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[7]/ndc-fg-dropdown-input/p-dropdown/div/div[2]/span");
    private final By Btn_SearchInGrid=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-travellers-details/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div/div/button/span");
    private final By Btn_InActiveButton=By.xpath("//label[@ for=\"id-Status-Inactive\"]");
    private final By Btn_ActiveButton=By.xpath("//label[@ for=\"id-Status-Active\"]");
    private final By UserManagement=By.linkText("User Management");
    private final By  AgencyUserInfo=By.linkText("Agency User Info");
    private final By  TravellersDetails=By.linkText("Travellers Details");
    public final By  ValidationOnAgency=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-travellers-details/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/span");
    public final By ValidationOnAgent=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-travellers-details/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/span");
    public final By NoDataFound=By.xpath("//td[@class=\"message\"]");
    public final By validatePhoneNumber=By.xpath(" //span[contains(text(),' validatePhoneNumber validation error ')]");
    public final By validateEmail=By.xpath("//span[contains(text(),'pattern validation error')]");
    public final By validateID=By.xpath("//span[contains(text(),' Please match the requested format, only numeric values are allowed ')]");
    public final By EsaamSaady=By.xpath("//*[@id=\"pr_id_22_label\"]");
    public void NavigateToTravellersDetails()

    {
        driver.element().click(Btn_UserManagment);
        driver.element().click(Btn_AgencyUser);
        driver.element().click(Btn_Profile);

    }
    public travellersDetails_Page SelectAgency(String agency) {
        driver.element().type(Txt_Agency,agency);

        return this;
    }

    public travellersDetails_Page SelectAgent(String agent) throws InterruptedException {
//        driver.element().click(Agent);
//        By option = xpath(String.format("//span[text()='%s']",agent));
//        Thread.sleep(3000);
//        driver.element().click(option);
        driver.element().select(Lst_Agent,agent);
        return this;
    }
    public travellersDetails_Page SelectAgentByIndex(int index) {
        driver.element().click(Lst_Agent);
        // Use XPath with index. Indexes are 1-based in XPath.
        By option = By.xpath(String.format("(//span)[%d]", index));
        driver.element().click(option);
        return this;
    }


    public travellersDetails_Page EnterClientID(String clientID) {
        driver.element().type(Txt_ClientID,clientID);
        return this;
    }
    public travellersDetails_Page EnterClientName(String clientName) {
        driver.element().type(Txt_ClientName,clientName);
        return this;
    }

    public travellersDetails_Page EnterEmailID(String emailID) {
        driver.element().type(Txt_EmailID,emailID);
        return this;
    }
    public travellersDetails_Page EnterPhoneNumber(String phoneNumber) {
        driver.element().type(Txt_PhoneNumber, phoneNumber);
        return this;
    }
    public travellersDetails_Page SelectCorporate(String Corporate) {
        driver.element().click(Lst_SelectCorporate);
        By option = xpath(String.format("//span[text()='%s']",Corporate));
        driver.element().click(option);
        return this;
    }
    public travellersDetails_Page SelectType(String type) {
        driver.element().click(Txt_Type);
        By option = xpath(String.format("//span[text()='%s']",type));
        driver.element().click(option);
        return this;
    }
    public travellersDetails_Page SelectNationality(String nationality) {
        driver.element().click(Lst_Nationality);
        By option = xpath(String.format("//span[text()='%s']",nationality));
        driver.element().click(option);
        return this;
    }
    public void  ClickOnSearchInGrid()
    {
        driver.element().click(Btn_SearchInGrid);
    }
    public void  ClickOnInActiveButton()
    {
        driver.element().click(Btn_InActiveButton);
    }

    public void  ClickOnActiveButton()
    {
        driver.element().click(Btn_ActiveButton);
    }
    public void  ScrollToElement()
    {
        driver.element().scrollToElement(EsaamSaady);
    }
    public void  ClickOnActiveAgent()
    {
        driver.element().click(EsaamSaady);
    }

    public travellersDetails_Page SelectAgent2(String agent) {
        driver.element().click(Lst_Agent);
        ScrollToElement();
        By option = xpath(String.format("//span[text()='%s']",agent));
        driver.element().click(option);
        return this;
    }
}