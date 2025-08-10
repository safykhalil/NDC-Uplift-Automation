package AdminPages.Master.Miscellaneous.Region.Country;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ActionCountry_Page {
    public ActionCountry_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Update = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
    By Txt_CountryCode = By.xpath("//input[@id=\"id-Countrycode\"]");
    By Txt_AirLine  = By.xpath("//input[@id=\"id-Airline\"]");
    By Btn_SendForAprroval = By.xpath("//button[@type=\"submit\"]");
    By Rbtn_InternationalpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-Yes\"]]");
    By Rbtn_InternationalpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-No\"]]");
    By Rbtn_DomesticpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-Yes\"]]");
    By Rbtn_DomesticpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-No\"]]");
    By Btn_ThumbUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit = By.xpath("//span[contains(text(),'Submit')]");
    By Btn_ActiveIcon = By.xpath("//i[@class=\"pi pi-circle\"]");
    By Btn_InActiveIcon = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ThumbDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_Remarks1 = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit1 = By.xpath("//span[contains(text(),'Submit')]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");


    public void Setupdate(String countryname,String countrycode,String airline){
        driver.element().click(Btn_Update);
        driver.element().type(Txt_CountryName,countryname);
        driver.element().type(Txt_CountryCode,countrycode);
        driver.element().type(Txt_AirLine,airline);
        driver.element().select(Txt_AirLine,airline);
        driver.element().click(Btn_SendForAprroval);
    }

    public void setThumbUp(String remarks){
        driver.element().click(Btn_ThumbUp);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_Submit);

    }

    public void setThumbDown(String remarks){
        driver.element().click(Btn_ThumbDown);
        driver.element().type(Txt_Remarks1,remarks);
        driver.element().click(Btn_Submit1);

    }

    public void setActiveIcon(){
        driver.element().click(Btn_ActiveIcon);

    }

    public void setInActiveIcon(){
        driver.element().click(Btn_InActiveIcon);
    }

    public void setActive(){
        driver.element().click(Rbtn_Active);
    }
    public void setInactive(){
        driver.element().click(Rbtn_Inactive);
    }
    public void setBoth(){
        driver.element().click(Rbtn_Both);
    }

    public void setInternationalpassportmandatoryYes(){
        driver.element().click(Rbtn_InternationalpassportmandatoryYes);
    }

    public void setInternationalpassportmandatoryNo(){
        driver.element().click(Rbtn_InternationalpassportmandatoryNo);
    }

    public void setDomesticpassportmandatoryYes(){
        driver.element().click(Rbtn_DomesticpassportmandatoryYes);
    }

    public void setDomesticpassportmandatoryNo(){
        driver.element().click(Rbtn_DomesticpassportmandatoryNo);
    }

}
