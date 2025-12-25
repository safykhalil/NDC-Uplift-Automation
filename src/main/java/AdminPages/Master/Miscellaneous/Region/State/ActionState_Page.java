package AdminPages.Master.Miscellaneous.Region.State;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ActionState_Page {

    public ActionState_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
   // By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
    By Lst_CountryName = By.xpath("//p-dropdown[.//input[@id=\"id-CountryName\"]]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_SendForApproval = By.xpath("(//button[@type=\"submit\"])[3]");

    public void setAddState( String remarks , String countryname){
        driver.element().click(Btn_Edit);
      //  driver.element().type(Txt_StateName,statename);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Lst_CountryName);
        By option = By.xpath(String.format("//span[text()='%s']", countryname));
        driver.element().click(option);
        driver.element().click(Btn_SendForApproval);
    }

}
