package AdminPages.Master.Miscellaneous.Region.Region;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ActionRegion_Page {
    public ActionRegion_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_UpdateIcon = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Txt_RegionName = By.xpath("//input[@id=\"id-Region\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
    By Btn_SendforAprroval = By.xpath("(//button[@type=\"submit\"])[3]");
    By Btn_ThumbUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit = By.xpath("(//span[contains(text(),'Submit')])[3]");
    By Btn_ActiveIcon = By.xpath("//i[@class=\"pi pi-circle\"]");
    By Btn_InActiveIcon = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ThumbDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_Remarks1 = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit1 = By.xpath("//span[contains(text(),'Submit')]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");


    public void setUpdate(String regionName   , String countryName,String remarks){
        driver.element().click(Btn_UpdateIcon);
        driver.element().type(Txt_RegionName,regionName);
        driver.element().type(Txt_CountryName,countryName);
        driver.element().select(Txt_CountryName,countryName);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_SendforAprroval);
    }

    public void setThumbUp(String remarks){
        driver.element().click(Btn_ThumbUp);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_Submit1);

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
}
