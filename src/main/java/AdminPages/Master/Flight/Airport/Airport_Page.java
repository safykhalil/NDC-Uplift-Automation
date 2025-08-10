package AdminPages.Master.Flight.Airport;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static org.openqa.selenium.By.xpath;

public class Airport_Page {
    private final SoftAssert softAssert;
    private final SHAFT.GUI.WebDriver driver;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// Search
    private final By Master = xpath("//a[@href=\"/master\"]");
    private final By Flight = By.xpath("(//a[@class=\"ng-star-inserted\"])[1]");
    private final By Airport = xpath("//a[@href=\"/master/flight/airport\"]");
    private final By IATACode = xpath("//input[@id=\"id-IATACode\"]");
    private final By AirportName = xpath("//input[@id=\"id-AirportName\"]");
    private final By Country = xpath("//input[@id=\"id-Country\"]");
    private final By City = xpath("//input[@id=\"id-City\"]");
    private final By Type = xpath("(//div[@role])[1]");
    private final By Station = xpath("(//div[@role])[2]");
    private final By Inactive_Active = xpath("(//div[@class=\"p-radiobutton-box\"])[1]");
    private final By Both = xpath("(//div[@class=\"p-radiobutton-box\"])[2]");
    private final By Search = xpath("//button[@type=\"submit\"]");
    public final By Table = xpath("(//td)[1]");

    public Airport_Page Reload(){
        driver.browser().navigateToURL("http://192.168.1.70/master/flight/airport");
        return this;
    }
    public Airport_Page(SHAFT.GUI.WebDriver driver) {
        this.softAssert = new SoftAssert();

        this.driver = driver;

    }
    public void navigateToAirportPage() {
                driver.element().click(Master);
                driver.element().click(Flight);
                driver.element().click(Airport);

    }
    public void EnterIATACode(String IATA){
        driver.element().type(IATACode,IATA);
    }
    public void EnterAirportName(String Name){
        driver.element().type(AirportName,Name);
    }
    public void EnterCountry(String Name) throws InterruptedException {
        driver.element().click(Country);
        driver.element().type(Country,Name);
        Thread.sleep(1000);
        final By DropdownCountry_City = xpath("(//ul//li[@role=\"option\"])[1]");
        Thread.sleep(1000);
        driver.element().click(DropdownCountry_City);
    }
    public void EnterCity(String Name) throws InterruptedException {
        driver.element().click(City);
        driver.element().type(City,Name);
        Thread.sleep(1000);
        final By DropdownCountry_City = xpath("(//ul//li[@role=\"option\"])[1]");
        Thread.sleep(1000);
        driver.element().click(DropdownCountry_City);
    }
    public Airport_Page ClickOnTypeAndChooseIndex(String Check) throws InterruptedException {
        driver.element().click(Type);
        Thread.sleep(500);
        final By SelectIndex = xpath("//p-dropdown//p-overlay//div//div//ul//p-dropdownitem["+ Check+"]");
        driver.element().click(SelectIndex);
        return this;
    }
    public Airport_Page ClickOnStationAndChooseIndex(String Check) throws InterruptedException {

        driver.element().click(Station);
        Thread.sleep(500);
        final By SelectIndex = xpath("//p-dropdown//p-overlay//div//div//ul//p-dropdownitem["+ Check+"]");
        driver.element().click(SelectIndex);
        return this;
    }
    public Airport_Page ClickOnSearch (){
        driver.element().click(Search);
        return this;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// Add
    private final By AddButton = xpath("//span[@style=\"margin-inline-end: 10px;\"]");
    private final By Domestic = xpath("(//div[@class=\"p-checkbox p-component\"])[1]");
    private final By International = xpath("(//div[@class=\"p-checkbox p-component\"])[2]");
    private final By BothOfType = xpath("(//div[@class=\"p-checkbox p-component\"])[3]");
    private final By Latitude = xpath("//input[@id=\"id-Latitude\"]");
    private final By Longitude = xpath("//input[@id=\"id-Longitude\"]");
    private final By DontDisplayToPOS = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-airport/div/div/ndc-fg-form-container/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[9]/ndc-chips-dropdown-input/div/div[1]/div/div");
    private final By NearByAirport = xpath("//li[@class=\"p-autocomplete-input-token ng-tns-c39-17\"]");
    private final By Supplier = xpath("(//p)[2]");
    private final By Supplier2 = xpath("(//p)[3]");
    private final By Cancel = By.xpath("(//span[@style=\"margin-inline-end: 10px;\"])[1]");
    private final By SendForApproval  = By.xpath("(//button[@type=\"submit\"])[3]");
    private final By Right = By.xpath("//i[@class=\"pi pi-arrow-right\"]");
    private final By Left = By.xpath("//i[@class=\"pi pi-arrow-left\"]");
    private final By Airportname = xpath("//input[@id=\"id-AirportName\"]");
    private final By station = xpath("//p-dropdown[.//input[@id=\"id-Station\"]]");

    public String GetSupplierText(){
        String s = driver.element().getText(Supplier);
        return s;
    }
    public String GetSupplierText2(){
        String s = driver.element().getText(Supplier2);
        return s;
    }
   public Integer NumberOfSupplier() {
       String S = GetSupplierText();
       char array[] = S.toCharArray();
       StringBuilder Array = null;
       int Res;
       for (int i = 1; i <= 5; i++) {
           if (array[i]=='0' || array[i]=='1' ||array[i]=='2' ||array[i]=='3' ||array[i]=='4' ||array[i]=='5' ||array[i]=='6'
                   ||array[i]=='7' ||array[i]=='8' ||array[i]=='9' ){
               Array.append(array[i]);
           }

       }
       String s = Array.toString();
       Res = Integer.parseInt(s);
        return Res;
   }
    public Integer NumberOfSupplier2() {
        String S = GetSupplierText2();
        char array[] = S.toCharArray();
        StringBuilder Array = null;
        int Res;
        for (int i = 1; i <= 5; i++) {
            if (array[i]=='0' || array[i]=='1' ||array[i]=='2' ||array[i]=='3' ||array[i]=='4' ||array[i]=='5' ||array[i]=='6'
                    ||array[i]=='7' ||array[i]=='8' ||array[i]=='9' ){
                Array.append(array[i]);
            }

        }
        String s = Array.toString();
        Res = Integer.parseInt(s);
        return Res;
    }
    public Airport_Page ClickOnStation(String Check) throws InterruptedException {

        driver.element().click(station);
        Thread.sleep(500);
        final By SelectIndex = xpath("(//p-dropdown//p-overlay//div//div//ul//p-dropdownitem//li)["+ Check+"]");
        driver.element().click(SelectIndex);
        return this;
    }
   public void ClickOnSuppliers(int i){
       final By Suppliers = xpath("(//div[@class=\"p-checkbox p-component\"])["+i+3+"]");
       driver.element().click(Suppliers);
   }
    public Airport_Page EnterAirportname(String S){
        driver.element().type(Airportname,S);
        return this;
    }
   public Airport_Page ClickOnCancel(){
       driver.element().click(Cancel);
       return this;
   }
    public Airport_Page ClickOnSendForApproval(){
        driver.element().click(SendForApproval);
        return this;
    }
    public Airport_Page ClickOnAddAirport(){
        driver.element().click(AddButton);
        return this;
    }
    public Airport_Page ClickOnDomestic(){
        driver.element().click(Domestic);
        return this;
    }
    public Airport_Page ClickOnInternational(){
        driver.element().click(International);
        return this;
    }
    public Airport_Page ClickOnBoth(){
        driver.element().click(BothOfType);
        return this;
    }
    public Airport_Page TypeOnLatitude(String s){
        driver.element().type(Latitude,s);
        return this;
    }
    public Airport_Page TypeOnLongitude(String s){
        driver.element().type(Longitude,s);
        return this;
    }
    public Airport_Page ClickOnRight(){
        driver.element().click(Right);
        return this;
    }
    public Airport_Page ClickOnLeft(){
        driver.element().click(Left);
        return this;
    }
    public void DontDisplayToPOS (String Name) throws InterruptedException {
        driver.element().click(DontDisplayToPOS);
        driver.element().type(DontDisplayToPOS,Name);
        Thread.sleep(1000);
        final By DontDisplayToPOS = xpath("(//ul//li[@role=\"option\"])[1]");
        Thread.sleep(1000);
        driver.element().click(DontDisplayToPOS);
    }
    public void NearByAirport(String Name) throws InterruptedException {
        driver.element().click(NearByAirport);
        driver.element().type(NearByAirport,Name);
        Thread.sleep(1000);
        final By NearByAirport = xpath("(//ul//li[@role=\"option\"])[1]");
        Thread.sleep(1000);
        driver.element().click(NearByAirport);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///Edit
    final By Editbutton = By.xpath("(//i[@class=\"pi pi-pencil\"])[1]");
    public Airport_Page ClickOnEdit(){
        driver.element().click(Editbutton);
        return this;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///Action
    private final By Active=xpath("//p-radiobutton[ .//input[@ id=\"id-Status-Active\"]]");
    private final By InActive=xpath("//p-radiobutton[ .//input[@ id=\"id-Status-Inactive\"]]");
    public Airport_Page ClickOnEye(){By Eye = By.xpath("(//i[@class=\"pi pi-eye\"])[1]");driver.element().click(Eye);return this;}
    public Airport_Page ClickOnClose(){By Close = By.xpath("(//button[@type=\"button\"])[5]");driver.element().click(Close);return this;}
    public Airport_Page ClickOnActiveCircle(){By Circle = By.xpath("(//i[@class=\"pi pi-circle-fill\"])[1]");driver.element().click(Circle);return this;}
    public Airport_Page ClickOnInactiveCircle(){By Circle = By.xpath("(//i[@class=\"pi pi-circle\"])[1]");driver.element().click(Circle);return this;}
    public Airport_Page ClickOnActive(){driver.element().click(Active);return this;}
    public Airport_Page ClickOnInactive(){driver.element().click(InActive);return this;}
    public Airport_Page ClickOnThumbsUp(){By ThumbsUp = By.xpath("(//i[@class=\"pi pi-thumbs-up\"])[1]");driver.element().click(ThumbsUp);
        By Remark = By.xpath("//textarea[@class=\"p-inputtextarea p-inputtext p-component p-element ng-untouched ng-pristine ng-invalid\"]");driver.element().type(Remark,"Ok");
        By Approve = By.xpath("(//span[@class=\"p-button-label\"])[3]");driver.element().click(Approve);return this;}
    public Airport_Page ClickOnThumbsDown(){By ThumbsDown = By.xpath("(//i[@class=\"pi pi-thumbs-down\"])[1]");driver.element().click(ThumbsDown);
        By Remark = By.xpath("//textarea[@class=\"p-inputtextarea p-inputtext p-component p-element ng-untouched ng-pristine ng-invalid\"]");driver.element().type(Remark,"Ok");
        By Reject = By.xpath("(//span[@class=\"p-button-label\"])[3]");driver.element().click(Reject);return this;
    }
    public String NameOfAirportOnEye(){String S = ElementActions.getInstance().getText(By.xpath("(//td[@class=\"ng-star-inserted\"])[8]"));return S;}
    public String NameOfAirportOnSearch(){String S = ElementActions.getInstance().getText(By.xpath("(//td[@class=\"ng-star-inserted\"])[1]"));return S;}
}