package AdminPages.Admin.Agency.Agency;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class AddAgencyCore_Page {
    public AddAgencyCore_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Agency = By.linkText("Agency");
    By SelectAgency = By.xpath("//a[@href=\"/admin/agency\"]");
    By AddButton = By.id("add_click");
    By BranchDropDown = By.id("groupId");
    By AgencyNameText = By.id("groupName");
    By StateDropDown = By.xpath("//select[@id='state']");
    By cityDropDown = By.id("city");
    By PostOfficeText = By.id("orgModal.zipcode");
    By AddressText = By.id("orgModal.address");
    By PhoneNumberText = By.id("agencyphone");
    By Date = By.id("uploadBtn_0_contractStartDate0");
    By Date2 = By.xpath("//input[@id=\"uploadBtn_0_contractEndDate0\"]");
    By ContractStartDate = By.id("uploadBtn_0_contractStartDate0");
    By ContractEndDate = By.id("uploadBtn_0_contractEndDate0");
    By Browse = By.id("uploadBtn_0");
    By Upload = By.xpath("(//input[@value=\"Upload\"])[1]");
    By UploadLogo = By.xpath("(//input[@value=\"Upload\"])[6]");
    By BrowseLogo = By.id("uploadBtnA");

    /*------------------Agency Owner Details--------------------------  */
    By ContactPersonText =By.id("orgModal.organizationContactModel0.name");
    By EmailText =By.id("email");
    By AgencyOwnerPhoneText = By.id("agencyphone1");

    /*------------------Wonder Travel Sales Contact--------------------------  */
    By WonderTravelSalesName  = By.id("sales_name");
    By WonderTravelSalesTextEmail = By.id("sales_email");
    By WonderTravelSalesTextPhone = By.id("sales_phone");
    /*------------------Payment Settings--------------------------  */
    By  InvoiceGeneration = By.id("invoiceGenFrequency");
    By  CreditLimit = By.id("creditLimit");
    By  TopUpLimit = By.id("topupLimit");
    By CreditTerms = By.id("creditTerms");

    By Cash = By.xpath("//label[contains(@for, 'checkk0')]");
    By Wallet =By.xpath("//label[contains(text(), 'Wallet')]");
    By SendForApprovalButton = By.id("createAgn");
    By InActiveButton = By.xpath("//label[contains(@for, 'radio_opr_edit_status_0')]");
    By SearchField = By.xpath("//input[@name=\"groupName\"]");
    By Searchbutton = By.id("searchButton");
    By RemarksText = By.xpath("//textarea[contains(@id, 'remarksValue')]");
    By ApproveButtonPopUpWindow =By.xpath("//button[contains(@id,'approveRemarks')]");
    Alert alert;
    public void ClickAgency(){
        driver.element().click(Agency).click(SelectAgency);

    }

    public void AddButton(){
        driver.element().click(AddButton);
    }

    public void SelectBranch(String branch){
        driver.element().select(BranchDropDown,branch);

    }

    public void AgencyName(String agency){
        driver.element().type(AgencyNameText,agency);
    }

    public void StateDropDown(String state_dropdown){
        driver.element().select(StateDropDown,state_dropdown);

    }

    public void CityDropDown(String city_dropdown){
        driver.element().select(cityDropDown,city_dropdown);
    }

    public void PostOfficeText(String post){
        driver.element().type(PostOfficeText,post);
    }

    public void AddressText(String address_text){
        driver.element().type(AddressText,address_text);
    }

    public void PhoneNumberText(String phone_number){
        driver.element().type(PhoneNumberText,phone_number);
    }

    public void Date(){
        driver.element().click(Date);
    }

    public void Date2(){
        driver.element().click(Date2);
    }

    public void ContractStartDate(String contract_start){
        driver.element().select(ContractStartDate,contract_start);
    }

    public void ContractEndDate(String contract_end){
        driver.element().select(ContractEndDate,contract_end);
    }

    public void ContactPersonText(String Text){
        driver.element().type(ContactPersonText,Text);
    }

    public void EmailText(String Text){
        driver.element().type(EmailText,Text);
    }

    public void AgencyOwnerPhoneText(String Text){
        driver.element().type(AgencyOwnerPhoneText,Text);
    }

    public void Browse(){
        driver.element().click(Browse);
    }

    public void Upload(){
        driver.element().click(Upload);
    }

    public void BrowseLogo(){
        driver.element().click(BrowseLogo);
    }

    public void UploadLogo(){
        driver.element().click(UploadLogo);
    }

    public void WonderTravelSalesName(String Name){
        driver.element().type(WonderTravelSalesName,Name);
    }

    public void WonderTravelSalesTextEmail(String Email){
        driver.element().type(WonderTravelSalesTextEmail,Email);
    }

    public void WonderTravelSalesTextPhone(String Phone){
        driver.element().type(WonderTravelSalesTextPhone,Phone);
    }

    public void InvoiceGeneration(String invoice){
        driver.element().select(InvoiceGeneration,invoice);
    }

    public void CreditLimit(String credit){
        driver.element().type(CreditLimit,credit);
    }

    public void TopUpLimit(String topup){
        driver.element().type(TopUpLimit,topup);
    }

    public void CreditTerms(String credit){
        driver.element().type(CreditTerms,credit);
    }

    public void Cash(){
        driver.element().click(Cash);
    }

    public void Wallet(){
        driver.element().click(Wallet);

    }

    public void SendForApproval(){
        driver.element().click(SendForApprovalButton);
    }

    public void Alert() throws InterruptedException {
        Thread.sleep(1000);
        alert = driver.getDriver().switchTo().alert();
        // alertText = alert.getText();
        alert.accept();
        Thread.sleep(1000);
        alert.accept();
    }

    public void SelectContractStartDate(String Months, String Year, String Day) {
        driver.element().click(ContractStartDate);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-year']"), Year);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-month']"), Months);
        driver.element().click(By.xpath("//a[contains(@class, 'ui-state-default') and text()='" + Day + "']"));


    }

    public  void SelectContractEndDate(String Months1, String Year1, String Day1) {
        driver.element().click(ContractEndDate);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-year']"), Year1);
        driver.element().select(By.xpath("//select[@class='ui-datepicker-month']"), Months1);
        driver.element().click(By.xpath("//a[contains(@class, 'ui-state-default') and text()='" + Day1 + "']"));


}
}
