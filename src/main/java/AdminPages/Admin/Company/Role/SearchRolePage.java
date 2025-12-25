package AdminPages.Admin.Company.Role;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchRolePage {
    public SearchRolePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_Company = By.linkText("Company");
    By Btn_Role = By.linkText("Role");
    By Txt_RoleName = By.xpath("//input[@id=\"id-Rolename\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//button[@type=\"submit\"]");

    public void setRole(String rolename) throws InterruptedException {
        driver.element().click(Btn_Company);
        Thread.sleep(1000);
        driver.element().click(Btn_Role);
        Thread.sleep(1000);
        driver.element().type(Txt_RoleName,rolename);
    }

    public void setInactive(){
        driver.element().click(Rbtn_Inactive);
    }
    public void setActive(){
        driver.element().click(Rbtn_Active);
    }
    public void setBoth(){
        driver.element().click(Rbtn_Both);
    }
    public void setSearchGrid(){
        driver.element().click(Btn_SearchGrid);
    }
}
