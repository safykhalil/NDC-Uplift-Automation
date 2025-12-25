package AdminPages.Admin.Company.Role;

import AdminPages.BookingMidOffice.SearchBooking.SearchBooking_Page;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Role_Page {
    private SHAFT.GUI.WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    private SHAFT.TestData.JSON testData;

    public Role_Page(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
        this.testData = new SHAFT.TestData.JSON("Role.json");
    }
    int i = 1, j= 1 , k=1;
        //////////////searchPage////////////////
    private final By btn_AddRole = By.xpath("//button[@routerlink = 'add']");
    private final By txt_searchRoleName = By.xpath("//input[@id = 'id-Rolename']");
    private final By Rbtn_Inactive = By.xpath("(//p-radiobutton)[1]");
    private final By Rbtn_Active = By.xpath("(//p-radiobutton)[2]");
    private final By Rbtn_Both = By.xpath("(//p-radiobutton)[3]");
    private final By btn_Search = By.xpath("//button[@type='submit']");
    private final By btn_Edit = By.xpath("(//div[@class='action ng-star-inserted'])[1]");
    private final By btn_Approve = By.xpath("(//div[@class='action exception-buttons ng-star-inserted'])[1]");
    private final By btn_Reject = By.xpath("(//div[@class='action exception-buttons ng-star-inserted'])[2]");
    private final By btn_Copy = By.xpath("(//div[@class='action exception-buttons ng-star-inserted'])[3]");
    private final By btn_Paginate = By.xpath("//button[@class='next']");
    private final By RoleNameField = By.xpath("//tr[1]/td[1]");
        ///////////////AddPage///////////////////
    private final By txt_RoleName = By.xpath("//input[@placeholder='Role Name']");
    private final By btn_DashBoard_Tab = By.xpath("//a[@id='p-tabpanel-13-label']");
    private final By btn_Admin_Tab = By.xpath("//a[@id='p-tabpanel-14-label']");
    private final By btn_Master_Tab = By.xpath("//a[@id='p-tabpanel-15-label']");
    private final By btn_RuleEngine_Tab = By.xpath("//a[@id='p-tabpanel-16-label']");
    private final By btn_Setting_Tab = By.xpath("//a[@id='p-tabpanel-17-label']");
    private final By btn_UserManagement_Tab = By.xpath("//a[@id='p-tabpanel-18-label']");
    private final By btn_BookingMidOffice_Tab = By.xpath("//a[@id='p-tabpanel-19-label']");
    private final By btn_Profile_Tab = By.xpath("//a[@id='p-tabpanel-20-label']");
    private final By btn_Reports_Tab = By.xpath("//a[@id='p-tabpanel-21-label']");
    private final By btn_PNRQuery_Tab = By.xpath("//a[@id='p-tabpanel-22-label']");
    private final By btn_TransferPNR_Tab = By.xpath("//a[@id='p-tabpanel-23-label']");
        //////subMenu//////////
    private final By btn_Company_Tab = By.xpath("//a[@id='p-tabpanel-24-label']");
    private final By btn_Branch_Tab = By.xpath("//a[@id='p-tabpanel-25-label']");
    private final By btn_Agency_Tab = By.xpath("//a[@id='p-tabpanel-26-label']");
    private final By btn_Staff_Tab = By.xpath("//a[@id='p-tabpanel-27-label']");
    private final By btn_Flight_Tab = By.xpath("//a[@id='p-tabpanel-28-label']");
    private final By btn_Supplier_Tab = By.xpath("//a[@id='p-tabpanel-29-label']");
    private final By btn_Miscellaneous_Tab = By.xpath("//a[@id='p-tabpanel-30-label']");
    private final By btn_PaymentGateway_Tab = By.xpath("//a[@id='p-tabpanel-31-label']");
       /////////Actions//////////////
    private final By btn_isView= By.xpath("(//p-checkbox[@formcontrolname='isView']/div[@class='p-checkbox p-component'])["+ i +"]");
    private final By btn_isEdit= By.xpath("(//p-checkbox[@formcontrolname='isEdit']/div[@class='p-checkbox p-component'])["+ j +"]");
    private final By btn_isApprove= By.xpath("(//p-checkbox[@formcontrolname='isApprove']/div[@class='p-checkbox p-component'])["+ k +"]");
    private final By btn_SendForApprove= By.xpath("//button[@type='submit']");
    private final By txt_Remark= By.xpath("//textarea");
    private final By btn_Submit= By.xpath("(//button[@type='submit'])[2]");

            ////////////////reflections////////
    private final By Reject= By.xpath("(//i[@class='pi pi-thumbs-down'])[1]");
    private final By Edit= By.xpath("(//i[@class='pi pi-pencil'])[1]");
    private final By View= By.xpath("(//p[@class='ng-star-inserted'])[1]");


    public Role_Page ClickAddRole() {
        driver.element().click(btn_AddRole);
        return this;
    }
    public Role_Page EnterRoleName(String s) {
        driver.element().type(txt_searchRoleName,s);
        return this;
    }
    public Role_Page ClickInactive() {
        driver.element().click(Rbtn_Inactive);
        return this;
    }
    public Role_Page ClickActive() {
        driver.element().click(Rbtn_Active);
        return this;
    }
    public Role_Page ClickBoth() {
        driver.element().click(Rbtn_Both);
        return this;
    }
    public Role_Page ClickSearch() {
        driver.element().click(btn_Search);
        return this;
    }
    public Role_Page ClickEdit() {
        driver.element().click(btn_Edit);
        return this;
    }
    public Role_Page ClickApprove() {
        driver.element().click(btn_Approve);
        return this;
    }
    public Role_Page ClickReject() {
        driver.element().click(btn_Reject);
        return this;
    }
    public Role_Page ClickCopy() {
        driver.element().click(btn_Copy);
        return this;
    }
    public Role_Page ClickPaginate() {
        driver.element().click(btn_Paginate);
        return this;
    }
    public Role_Page EnterAddRoleName(String s) {
        driver.element().type(txt_RoleName,s);
        return this;
    }
    public Role_Page ClickDashBoard_Tab() {
        driver.element().click(btn_DashBoard_Tab);
        return this;
    }
    public Role_Page ClickAdmin_Tab() {
        driver.element().click(btn_Admin_Tab);
        return this;
    }
    public Role_Page ClickMaster_Tab() {
        driver.element().click(btn_Master_Tab);
        return this;
    }
    public Role_Page ClickRuleEngine_Tab() {
        driver.element().click(btn_RuleEngine_Tab);
        return this;
    }
    public Role_Page ClickSetting_Tab() {
        driver.element().click(btn_Setting_Tab);
        return this;
    }
    public Role_Page ClickUserManagement_Tab() {
        driver.element().click(btn_UserManagement_Tab);
        return this;
    }
    public Role_Page ClickBookingMidOffice_Tab() {
        driver.element().click(btn_BookingMidOffice_Tab);
        return this;
    } public Role_Page ClickProfile_Tab() {
        driver.element().click(btn_Profile_Tab);
        return this;
    }
    public Role_Page ClickReports_Tab() {
        driver.element().click(btn_Reports_Tab);
        return this;
    }
    public Role_Page ClickPNRQuery_Tab() {
        driver.element().click(btn_PNRQuery_Tab);
        return this;
    }
    public Role_Page ClickTransferPNR_Tab() {
        driver.element().click(btn_TransferPNR_Tab);
        return this;
    }
    public Role_Page ClickCompany_Tab() {
        driver.element().click(btn_Company_Tab);
        return this;
    }
     public Role_Page ClickBranch_Tab() {
    driver.element().click(btn_Branch_Tab);
    return this;
        }
     public Role_Page ClickAgency_Tab() {
    driver.element().click(btn_Agency_Tab);
    return this;
    }
    public Role_Page ClickStaff_Tab() {
    driver.element().click(btn_Staff_Tab);
    return this;
    }
     public Role_Page ClickFlight_Tab() {
    driver.element().click(btn_Flight_Tab);
    return this;
    }
     public Role_Page ClickSupplier_Tab() {
    driver.element().click(btn_Supplier_Tab);
    return this;
    }
    public Role_Page ClickMiscellaneous_Tab() {
        driver.element().click(btn_Miscellaneous_Tab);
        return this;
    }
    public Role_Page ClickPaymentGateway_Tab() {
        driver.element().click(btn_PaymentGateway_Tab);
        return this;
    }
    public Role_Page ClickIsViewAtAllFields() {
        for (i=1;i<60;i++){
            if(i==1){
                driver.element().click(btn_DashBoard_Tab);
            }
            if(i==2){
                driver.element().click(btn_Admin_Tab);
            }
            if(i==6){

                driver.element().click(btn_Branch_Tab);
            }
            if(i==7){

                driver.element().click(btn_Agency_Tab);
            }
            if(i==11){

                driver.element().click(btn_Staff_Tab);
            }
            if(i==12){

                driver.element().click(btn_Master_Tab);
            }
            if(i==18){

                driver.element().click(btn_Supplier_Tab);
            }
            if(i==22){

                driver.element().click(btn_Miscellaneous_Tab);
            }
            if(i==26){

                driver.element().click(btn_PaymentGateway_Tab);
            }
            if(i==27){

                driver.element().click(btn_RuleEngine_Tab);
            }
            if(i==35){

                driver.element().click(btn_Setting_Tab);
            }
            if(i==37){

                driver.element().click(btn_UserManagement_Tab);
            }
            if(i==39){

                driver.element().click(btn_BookingMidOffice_Tab);
            }
            if(i==43){

                driver.element().click(btn_Profile_Tab);
            }
            if(i==44){

                driver.element().click(btn_Reports_Tab);
            }
            if(i==58){

                driver.element().click(btn_PNRQuery_Tab);
            }
            if(i==59){

                driver.element().click(btn_TransferPNR_Tab);
            }
            driver.element().click(btn_isView);
        }

        return this;
    }
    public Role_Page ClickIsEditAtAllFields() {
        for (j=1;j<60;j++) {
            if(j==1){
                driver.element().click(btn_DashBoard_Tab);
            }
            if(j==2){
                driver.element().click(btn_Admin_Tab);
            }
            if(j==6){

                driver.element().click(btn_Branch_Tab);
            }
            if(j==7){

                driver.element().click(btn_Agency_Tab);
            }
            if(j==11){

                driver.element().click(btn_Staff_Tab);
            }
            if(j==12){

                driver.element().click(btn_Master_Tab);
            }
            if(j==18){

                driver.element().click(btn_Supplier_Tab);
            }
            if(j==22){

                driver.element().click(btn_Miscellaneous_Tab);
            }
            if(j==26){

                driver.element().click(btn_PaymentGateway_Tab);
            }
            if(j==27){

                driver.element().click(btn_RuleEngine_Tab);
            }
            if(j==35){

                driver.element().click(btn_Setting_Tab);
            }
            if(j==37){

                driver.element().click(btn_UserManagement_Tab);
            }
            if(j==39){

                driver.element().click(btn_BookingMidOffice_Tab);
            }
            if(j==43){

                driver.element().click(btn_Profile_Tab);
            }
            if(j==44){

                driver.element().click(btn_Reports_Tab);
            }
            if(j==58){

                driver.element().click(btn_PNRQuery_Tab);
            }
            if(j==59){

                driver.element().click(btn_TransferPNR_Tab);
            }
            driver.element().click(btn_isEdit);
        }
        return this;
    }
    public Role_Page ClickIsApproveAtAllFields() {
        for (k=1;k<60;k++) {
            if(k==1){
                driver.element().click(btn_DashBoard_Tab);
            }
            if(k==2){
                driver.element().click(btn_Admin_Tab);
            }
            if(k==6){

                driver.element().click(btn_Branch_Tab);
            }
            if(k==7){

                driver.element().click(btn_Agency_Tab);
            }
            if(k==11){

                driver.element().click(btn_Staff_Tab);
            }
            if(k==12){

                driver.element().click(btn_Master_Tab);
            }
            if(k==18){

                driver.element().click(btn_Supplier_Tab);
            }
            if(k==22){

                driver.element().click(btn_Miscellaneous_Tab);
            }
            if(k==26){

                driver.element().click(btn_PaymentGateway_Tab);
            }
            if(k==27){

                driver.element().click(btn_RuleEngine_Tab);
            }
            if(k==35){

                driver.element().click(btn_Setting_Tab);
            }
            if(k==37){

                driver.element().click(btn_UserManagement_Tab);
            }
            if(k==39){

                driver.element().click(btn_BookingMidOffice_Tab);
            }
            if(k==43){

                driver.element().click(btn_Profile_Tab);
            }
            if(k==44){

                driver.element().click(btn_Reports_Tab);
            }
            if(k==58){

                driver.element().click(btn_PNRQuery_Tab);
            }
            if(k==59){

                driver.element().click(btn_TransferPNR_Tab);
            }
            driver.element().click(btn_isApprove);
        }
        return this;
    }
    public Role_Page ClickSendForApprove() {
        driver.element().click(btn_SendForApprove);
        return this;
    }
    public Role_Page VerifyTheRoleName(){
        softAssert.assertEquals(testData.getTestData("validData.roleName"),driver.element().getText(RoleNameField));
        softAssert.assertAll();
        return this;
    }
    public Role_Page EnterRemarkText(String s) {
        driver.element().type(txt_Remark,s);
        return this;
    }
    public Role_Page ClickSubmit() {
        driver.element().click(btn_Submit);
        return this;
    }
    public Role_Page verifyUserHasPermissionsViewOnly(){
        softAssert.assertEquals(driver.element().isElementClickable(View),true);
        softAssert.assertEquals(driver.getDriver().findElements(Edit).size(), 0);
        softAssert.assertEquals(driver.getDriver().findElements(Reject).size(), 0);
        softAssert.assertAll();
        return this;
    }
    public Role_Page verifyUserHasPermissionsViewAndEdit(){
        softAssert.assertEquals(driver.element().isElementClickable(View),true);
        softAssert.assertEquals(driver.element().isElementClickable(Edit),true);
        softAssert.assertEquals(driver.getDriver().findElements(Reject).size(), 0);
        softAssert.assertAll();
        return this;
    }
    public Role_Page verifyUserHasPermissionsViewAndApprove(){
        softAssert.assertEquals(driver.element().isElementClickable(View),true);
        softAssert.assertEquals(driver.element().isElementClickable(Reject),true);
        softAssert.assertEquals(driver.getDriver().findElements(Edit).size(), 0);

        softAssert.assertAll();
        return this;
    }
    public Role_Page extractUserNameAndPassword(String gmail){
        Pattern pUser = Pattern.compile("User Name:\\s*(.*)");
        Pattern pPass = Pattern.compile("Password:\\s*(.*)");

        Matcher mUser = pUser.matcher(gmail);
        Matcher mPass = pPass.matcher(gmail);
        return this;
    }
}
