package AdminPages.Admin.Agency.AgencyRegistrationRequest;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegistrationRequest_Page {

    public RegistrationRequest_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver ;


    By Btn_Agency = By.linkText("Agency");
    By Btn_RegistrationRequest = By.xpath("//a[@href=\"/admin/registration-requests\"]");
    By Txt_AgencyName = By.xpath("//input[@id=\"id-Agencyname\"]");
    By Txt_ContactName = By.xpath("//input[@id=\"id-Contactname\"]");
    By Txt_Requestdate = By.xpath("//input[@id=\"id-Requestdate\"]");
    By Dpick_CleanderClick = By.xpath("//span[@class=\"calender-icon\"]");
    By Txt_Email = By.xpath("//input[@id=\"id-email\"]");
    By Rbtn_New = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-New\"]]");
    By Rbtn_inProgress = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inprogress\"]]");
    By Rbtn_Rejected = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Rejected\"]]");
    By Btn_Searchgrid = By.xpath("//button[@type=\"submit\"]");

    public void setAgency(){
        driver.element().click(Btn_Agency);
    }

    public void setRegistrationRequest(String agencyname, String contactname, String email, String requestdate){
        driver.element().click(Btn_RegistrationRequest);
        driver.element().type(Txt_AgencyName,agencyname);
        driver.element().type(Txt_ContactName,contactname);
        driver.element().type(Txt_Requestdate,requestdate);
        driver.element().click(Dpick_CleanderClick);
        //driver.element().click(Selectdate);
        driver.element().type(Txt_Email,email);
    }
    public void setNew(){
        driver.element().click(Rbtn_New);
    }

    public void setInProgress(){
        driver.element().click(Rbtn_inProgress);
    }

    public void setRejected(){
        driver.element().click(Rbtn_Rejected);
    }

    public void setSearchgrid(){
        driver.element().click(Btn_Searchgrid);
    }


}