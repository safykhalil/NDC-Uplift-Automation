package AdminPages.Admin.Company;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class OperatingCountry_Page {
    public OperatingCountry_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_AddCountry = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_AddOperatingCountryName = By.xpath("//input[@id=\"id-OperatingCountryName\"]");
    By Txt_SearchOperatingCountryName = By.xpath("//input[@id=\"id-Operatingcountryname\"]");
    By Lst_SelectCountry = By.xpath("//p-dropdown[.//input[@id=\"id-SelectCountry\"]]");
    By Lst_SelectCurrency = By.xpath("//p-dropdown[.//input[@id=\"id-Currency\"]]");
    By Btn_Company = By.linkText("Company");
    By Btn_OperatingCountry = By.xpath("//a[@href=\"/admin/operating-country\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//button[@type=\"submit\"]");
    By Btn_SendForApproval = By.xpath("//button[@type=\"submit\"]");
    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Btn_ThumpUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Btn_ThumpDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_RemarksUp = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submitup =  By.xpath("//span[contains(text(),'Submit')]");
    By Txt_RemarkDown = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_SubmitDown =  By.xpath("//span[contains(text(),'Submit')]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");


    public void AddCountry(String opcountryname , String selectcountry , String selectcurrency) throws InterruptedException {
        System.out.println("Start Method : Add Country");
        driver.element().click(Btn_AddCountry);
        Thread.sleep(1000);
        driver.element().type(Txt_AddOperatingCountryName,opcountryname);
        //Thread.sleep(1000);
        driver.element().click(Lst_SelectCountry);
        By option = By.xpath(String.format("//span[text()='%s']", selectcountry));
        driver.element().click(option);
        Thread.sleep(1000);
        driver.element().click(Lst_SelectCurrency);
        By option1 = By.xpath(String.format("//span[text()='%s']", selectcurrency));
        driver.element().click(option1);
        Thread.sleep(1000);
        driver.element().click(Btn_SendForApproval);
    }

    ///SearchCountry//////////////////////////////////


    public void OperatingCountry(String operatingcountryname,String selectcountry) throws InterruptedException {
        System.out.println("Start Method : Search for Operating Country");
//        driver.element().click(Company);
//        Thread.sleep(1000);
        driver.element().click(Btn_OperatingCountry);
//        Thread.sleep(1000);
        driver.element().type(Txt_SearchOperatingCountryName,operatingcountryname);
        Thread.sleep(1000);
        driver.element().click(Lst_SelectCountry);
        By option = By.xpath(String.format("//span[text()='%s']", selectcountry));
        driver.element().click(option);


    }

    public void setInactive() throws InterruptedException {
        driver.element().click(Rbtn_Inactive);
        Thread.sleep(1000);
    }

    public void setActive() throws InterruptedException {

        driver.element().click(Rbtn_Active);
        Thread.sleep(1000);
    }

    public void setBoth() throws InterruptedException {

        driver.element().click(Rbtn_Both);
        Thread.sleep(1000);
    }

    public void setSearchGrid(){
        driver.element().click(Btn_SearchGrid);
    }

    //Action Operating Country///////////////////////


    public void Action(String opcountryname ,String remarks) throws InterruptedException {
        System.out.println("Start Method : Edit Operating Country");
        driver.element().click(Btn_Edit);
        driver.element().type(Txt_AddOperatingCountryName,opcountryname);
        Thread.sleep(1000);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_SendForApproval);
    }

    public void ThumpUp(String remarksup){
        System.out.println("Start Method : Approve operating country");
        driver.element().click(Btn_ThumpUp);
        driver.element().type(Txt_RemarksUp,remarksup);
        driver.element().click(Btn_Submitup);
    }

    public void ThumpDown(String remarksdown){
        System.out.println("Start Method : Reject operating country");
        driver.element().click(Btn_ThumpDown);
        driver.element().type(Txt_RemarkDown,remarksdown);
        driver.element().click(Btn_SubmitDown);
    }
}