package AdminPages.Profile;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Profile_Common {
    SHAFT.GUI.WebDriver driver;
    private final By btn_Profile = By.xpath("//a[@id='p-tabpanel-7-label']");
    private final By btn_Traveller = By.xpath("//a[@href=\"/profile\"]");

    public Profile_Common(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    public Profile_Common clickProfile(){
        driver.element().click(btn_Profile);
        return this;
    }
    public Profile_Common clickTraveller(){
        driver.element().click(btn_Traveller);
        return this;
    }
}
