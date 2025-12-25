package AdminPages.Master.Supplier;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SupplierCredential_Page {
    public SupplierCredential_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_Admin = By.xpath("//a[@href=\"/admin\"]");
    By Btn_AddSupplierCredential = By.xpath("//button[@routerlink=\"add\"]");
    By Lst_Supplier = By.xpath("//p-dropdown[.//input[@id=\"id-Supplier\"]]");
    By Lst_CredentialName = By.xpath("//input[@id=\"id-CredentialName\"]");
    By Lst_CountryPOC = By.xpath("//p-multiselect[.//input[@id=\"id-CountryPOC\"]]");
    By Lst_Currency = By.xpath("//p-dropdown[.//input[@id=\"id-Currency\"]]");
    By Lst_CredentialType = By.xpath("//p-dropdown[.//input[@id=\"id-CredentialType\"]]");
    By Lst_FlightSearchLimit = By.xpath("//p-dropdown[.//input[@id=\"id-FlightSearchLimit\"]]");
    By Lst_ConnectionTime = By.xpath("//p-dropdown[.//input[@id=\"id-ConnectionTimeout\"]]");
    By Lst_ReadTimeOut = By.xpath("//p-dropdown[.//input[@id=\"id-ReadTimeout\"]]");
    By Txt_EndpointURL = By.xpath("//input[@id=\"id-EndpointURL\"]");
    By Password = By.xpath("//input[@id=\"id-password\"]");
    By DisplayName = By.xpath("//input[@id=\"id-displayname\"]");
    By Cbox_DevCreate = By.xpath("(//p-checkbox[.//input[@type=\"checkbox\"]])[1]");
    By Btn_Save = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_SupplerCredential = By.xpath("//a[@href=\"/master/supplier/supplier-credentials\"]");
    By Txt_CredentialName = By.xpath("//input[@id=\"id-Credentialname\"]");
    //By Lst_Supplier = By.xpath("//p-dropdown[.//input[@id=\"id-Supplier\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    By Btn_InActiveCircle = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ActiveCircle = By.xpath("//i[@class=\"pi pi-circle\"]");
    //*//
    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
   // By Txt_CredentialName = By.xpath("//input[@id=\"id-CredentialName\"]");
    //*//
   By Btn_Branch = By.xpath("//a[@href=\"/admin/branch\"]");
    By Btn_AddBranch = By.xpath("//a[@id=\"add_click\"]");
    By Lst_SelectOpCountry = By.xpath("//input[@id=\"operatingCountry\"]");
    By Cbox_CheckAmadeus = By.xpath("//label[@for=\"check[1]\"]");
    By Btn_Cancel = By.xpath("//input[@value=\"Cancel\"]");
    By Btn_Agency = By.linkText("Agency");
    By Btn_Agency1 = By.xpath("//a[@href=\"/admin/agency\"]");
    By Btn_AddAgency = By.xpath("//a[@id=\"add_click\"]");
    By Lst_SelectBranch = By.xpath("//select[@id=\"groupId\"]");
    By Btn_AmadeusPcc = By.xpath("//a[@href=\"#AmadeusPccTabDiv\"]");




    public void setAddSupplierCredential(String supplier, String credentialname, String countrypoc, String currency
    , String credentialtype,String flightsearchlimit,String connectiontime,String readtimeout){
        System.out.println("Start Method : Add Supplier Credential ");
        driver.element().click(Btn_AddSupplierCredential);
        driver.element().click(Lst_Supplier);
        By option = By.xpath(String.format("//span[text()='%s']", supplier));
        driver.element().click(option);
        driver.element().type(Lst_CredentialName,credentialname);
        driver.element().click(Lst_CountryPOC);
        By option1 = By.xpath(String.format("//span[text()='%s']", countrypoc));
        driver.element().click(option1);
        driver.element().click(Lst_Currency);
        By option2 = By.xpath(String.format("//span[text()='%s']", currency));
        driver.element().click(option2);
        driver.element().click(Lst_CredentialType);
        By option3 = By.xpath(String.format("//span[text()='%s']", credentialtype));
        driver.element().click(option3);
        driver.element().click(Lst_FlightSearchLimit);
        By option4 = By.xpath(String.format("//span[text()='%s']", flightsearchlimit));
        driver.element().click(option4);
//        driver.element().select(ConnectionTime,connectiontime);
//        driver.element().select(ReadTimeOut,readtimeout);
        driver.element().click(Lst_ConnectionTime);
        By option5 = By.xpath(String.format("//span[text()='%s']", connectiontime));
        driver.element().click(option5);
        driver.element().click(Lst_ReadTimeOut);
        By option6 = By.xpath(String.format("//span[text()='%s']", readtimeout));
        driver.element().click(option6);

    }

    public void GDS(String endpointurl  ){

        driver.element().type(Txt_EndpointURL,endpointurl);
//        driver.element().type(Password,password);
//        driver.element().type(DisplayName,displayname);

    }

    public void RestrictedAirline(){
        System.out.println("Start Method :  RestrictedAirline ");
        driver.element().click(Cbox_DevCreate);
    }

    public void setSaveBtn(){
        System.out.println("Start Method : Click SaveBtn ");
        driver.element().click(Btn_Save);
    }
    public void setAdmin(){
        System.out.println("Start Method : Click Admin ");
        driver.element().click(Btn_Admin);
    }
    /// *** Search Supplier Credential Page *** ////////////////////////////////////////////////////////////////////////
    public void ClickonSupplierCredential(){
        System.out.println("Start Method : ClickonSupplierCredential ");
        driver.element().click(Btn_SupplerCredential);
    }

    public void setSearchCredential(String credentialname ,String supplier){
        System.out.println("Start Method : ClickSearchCredential ");

        driver.element().type(Txt_CredentialName,credentialname);
        driver.element().click(Lst_Supplier);
        By option = By.xpath(String.format("//span[text()='%s']", supplier));
        driver.element().click(option);

    }

    public void setActive(){
        System.out.println("Start Method : ClickActive ");
        driver.element().click(Rbtn_Active);
        driver.element().click(Btn_Search);
    }

    public void setInactive(){
        System.out.println("Start Method : ClickInactive ");
        driver.element().click(Rbtn_Inactive);
        driver.element().click(Btn_Search);
    }

    public void setBoth(){
        System.out.println("Start Method : ClickBoth ");
        driver.element().click(Rbtn_Both);
        driver.element().click(Btn_Search);
    }

    public void setActiveCircle(){
        System.out.println("Start Method : ClickActiveCircle ");
        driver.element().click(Btn_ActiveCircle);
    }

    public void setInactiveCircle(){
        System.out.println("Start Method : ClickInactiveCircle ");
        driver.element().click(Btn_InActiveCircle);
    }
    /// *** Edit Supplier Credential Page *** ////////////////////////////////////////////////////////////////////////////
    public void setEditSuppliercredential(String credentialname){
        System.out.println("Start Method : ClickEditSuppliercredential ");

        driver.element().click(Btn_Edit);
        driver.element().type(Txt_CredentialName,credentialname);
    }
    /// **** Reflection For Supplier Credential page *** ////////////////////////////////////////////////////////////////
    public void setBranch(String OP,String country ) throws InterruptedException {
        System.out.println("Start Method : ClickBranch ");
        driver.element().click(Btn_Branch);
        driver.element().click(Btn_AddBranch);
        driver.element().type(Lst_SelectOpCountry,OP);
        driver.element().select(Lst_SelectOpCountry,country);
        Thread.sleep(5000);
        driver.element().click(Cbox_CheckAmadeus);
        Thread.sleep(5000);
//        driver.element().click(Cancel);
//        Thread.sleep(6000);
    }

    public void SetAgency(String selectbranch){
        System.out.println("Start Method : ClickAgency ");
        driver.element().click(Btn_Agency);
        driver.element().click(Btn_Agency1);
        driver.element().click(Btn_AddAgency);
        driver.element().select(Lst_SelectBranch,selectbranch);
        driver.element().click(Btn_AmadeusPcc);
        // driver.element().click(Cancel);
    }


}


