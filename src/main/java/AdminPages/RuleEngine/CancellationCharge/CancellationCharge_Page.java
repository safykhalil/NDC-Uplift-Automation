package AdminPages.RuleEngine.CancellationCharge;
import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CancellationCharge_Page {

    public CancellationCharge_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;


    /////////////// RuleEngine Route /////////////

    By BtnRuleEngine = By.xpath("//a[@href=\"/rule-engine\"]");
    By BtnCancellationCharge = By.xpath("//a[@href=\"/odeysysadmin/Rules/searchRuleCancellationCharge\"]");


    //////////////// Search CancellationCharge /////////////////

    By Txt_CancellationChargeName = By.xpath("//input[@id=\"id-CancellationChargeName\"]");
    By Lst_Country = By.xpath("//p-dropdown[.//input[@id=\"id-Country\"]]");
    By Txt_CancellationChargeCode = By.xpath("//input[@id=\"id-CancellationChargecode\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");

    //////////////// Action CancellationCharge /////////////////

    By Btn_ThumpUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Btn_ThumpDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Btn_Clone = By.xpath("//i[@class=\"pi pi-clone ng-star-inserted\"]");
    By Txt_NewCancellationChargeName = By.xpath("//input[@id=\"id-NewCancellationChargeName\"]");
    By Btn_Save = By.linkText("Save");
    By Btn_Delete = By.xpath("//i[@class=\"pi pi-trash ng-star-inserted\"]");

    //////////////// Create CancellationCharge /////////////////

    By BtnAddCancellationCharge = By.xpath("//button[@routerlink=\"add\"]");
    By TxtCancellationChargeDescription = By.xpath("//textarea[@placeholder=\"Type your Cancellation charge description...\"]");
    By Dpick_ValidityPeriodFrom = By.xpath("//p-calendar[.//input[@id=\"id-ValidityPeriodFrom\"]]");
    By Dpick_ValidityPeriodTo = By.xpath("//p-calendar[.//input[@id=\"id-ValidityPeriodTo\"]]");
    By Lst_CountryPos = By.xpath("//div[@class=\"selected-chips\"]");
    By Txt_SearchContainer = By.xpath("//input[@placeholder=\"Search\"]");
    By Btn_Select = By.xpath("(//input[@type=\"checkbox\"])[2]");
    By BtnSendForApproval = By.xpath("//button[@type=\"submit\"]");
    By NextDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-cancellation-charge/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div/ndc-fg-input[3]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[2]/span");
    By Next = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-cancellation-charge/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div/ndc-fg-input[4]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[2]/span");
    //////////////// Create CancellationCharge /////////////////

    By LstLeviedBy = By.xpath("//p-dropdown[.//input[@id=\"id-LeviedBy\"]]");
    By LstFareType = By.xpath("//p-dropdown[.//input[@id=\"id-FareType\"]]");

    //////////////// Create CancellationCharge PerPerson /////////////////

    By TxtAdult = By.xpath("//input[@id=\"id-Adult\"]");
    By TxtChild = By.xpath("//input[@id=\"id-Child\"]");
    By TxtInfant = By.xpath("//input[@id=\"id-Infant\"]");

    //////////////// Create CancellationCharge PerTrip /////////////////

    By TxtEnterValue = By.xpath("//input[@id=\"id-Entervalue\"]");

    //////////////// Update CancellationCharge  /////////////////

    By BtnUpdate = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Dpick_UpdateValidityPeriodFrom = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-cancellation-charge/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div/ndc-fg-input[3]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By Dpick_UpdateValidityPeriodTo = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-cancellation-charge/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div/ndc-fg-input[4]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By TxtRemarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By BtnReject = By.xpath("(//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element p-ripple p-button p-component justify-content-center ng-star-inserted\"])[1]");
    By BtnApprove = By.xpath("(//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element p-ripple p-button p-component justify-content-center ng-star-inserted\"])[2]");
    By BtnUpdateSendForApproval = By.xpath("(//button[@class=\"col-sm-12 col-md-6 col-lg-2 p-element p-ripple p-button p-component justify-content-center ng-star-inserted\"])[3]");


    public void Txt_CancellationChargeName(String Txt){
        driver.element().type(Txt_CancellationChargeName,Txt);
    }

    public void Lst_Country(String Select){
        driver.element().select(Lst_Country,Select);
    }

    public void Txt_CancellationChargeCode(String Txt){
        driver.element().type(Txt_CancellationChargeCode,Txt);
    }

    public void Rbtn_Inactive(){
        driver.element().click(Rbtn_Inactive);
    }

    public void Rbtn_Active(){
        driver.element().click(Rbtn_Active);
    }

    public void Rbtn_Both(){
        driver.element().click(Rbtn_Both);
    }

    public void Btn_Search(){
        driver.element().click(Btn_Search);
    }

    public void Btn_ThumpUp(){
        driver.element().click(Btn_ThumpUp);
    }

    public void Btn_ThumpDown(){
        driver.element().click(Btn_ThumpDown);
    }

    public void Btn_Clone(){
        driver.element().click(Btn_Clone);
    }

    public void Txt_NewCancellationChargeName(String Txt){
        driver.element().type(Txt_NewCancellationChargeName,Txt);
    }

    public void Btn_Save(){
        driver.element().click(Btn_Save);
    }

    public void Btn_Delete(){
        driver.element().click(Btn_Delete);
    }

    public void BtnAddCancellationCharge(){
        driver.element().click(BtnAddCancellationCharge);
    }

    public void TxtCancellationChargeDescription(String Txt){
        driver.element().type(TxtCancellationChargeDescription,Txt);
    }

    public void Dpick_ValidityPeriodFrom(String Select){
        driver.element().click(Dpick_ValidityPeriodFrom).click(NextDate);
        By option11 = By.xpath(String.format("//span[contains(text(), '%s')]", Select));
        driver.element().click(option11);
    }

    public void Dpick_ValidityPeriodTo(String Select){
        driver.element().click(Dpick_ValidityPeriodTo).click(Next);
        By option11 = By.xpath(String.format("//span[contains(text(), '%s')]", Select));
        driver.element().click(option11);
    }

    public void Lst_CountryPos(){
     driver.element().click(Lst_CountryPos);


    }

    public void Txt_SearchContainer(String Txt) throws InterruptedException {
        driver.element().type(Txt_SearchContainer,Txt);
        Thread.sleep(1500);
//        driver.element().select(Txt_SearchContainer,Txt);

    }

    public void Btn_Select(){
        driver.element().click(Btn_Select);
    }

    public void BtnSendForApproval(){
        driver.element().click(BtnSendForApproval);
    }

    public void LstLeviedBy(String Select){
        driver.element().select(LstLeviedBy,Select);
    }

    public void LstFareType(String Select){
        driver.element().select(LstFareType,Select);
    }

    public void TxtAdult(String Txt){
        driver.element().type(TxtAdult,Txt);
    }

    public void TxtChild(String Txt){
        driver.element().type(TxtChild,Txt);
    }

    public void TxtInfant(String Txt){
        driver.element().type(TxtInfant,Txt);
    }

    public void TxtEnterValue(String Txt){
        driver.element().type(TxtEnterValue,Txt);
    }

    public void BtnUpdate(){
        driver.element().click(BtnUpdate);
    }

    public void Dpick_UpdateValidityPeriodFrom(String Select){
        driver.element().select(Dpick_UpdateValidityPeriodFrom,Select);
    }

    public void Dpick_UpdateValidityPeriodTo(String Select){
        driver.element().select(Dpick_UpdateValidityPeriodTo,Select);
    }

    public void TxtRemarks(String Txt){
        driver.element().type(TxtRemarks,Txt);
    }

    public void BtnReject(){
        driver.element().click(BtnReject);
    }

    public void BtnApprove(){
        driver.element().click(BtnApprove);
    }

    public void BtnUpdateSendForApproval(){
        driver.element().click(BtnUpdateSendForApproval);
    }

    public void BtnCancellationCharge(){
        driver.element().click(BtnCancellationCharge);
    }

    public void BtnRuleEngine(){
        driver.element().click(BtnRuleEngine);
    }
    public String ActualCreate()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));
        return S;
    }
//    public void Next(){
//        driver.element().click(NextDate);
//    }
}
