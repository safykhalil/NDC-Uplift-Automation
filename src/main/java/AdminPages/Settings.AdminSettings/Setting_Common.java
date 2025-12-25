package AdminPages.Settings.AdminSettings;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Setting_Common {
    SHAFT.GUI.WebDriver driver;

    private final By btn_Setting = By.xpath("//a[@id='p-tabpanel-4-label']");
    private final By btn_Supplier = By.xpath("//a[@href='/settings/suppliers']");
    private final By btn_AdminSetting = By.xpath("//a[@href='/settings/admin-settings']");

    public Setting_Common(SHAFT.GUI.WebDriver driver){
        this.driver  =driver;
    }

    public Setting_Common clickSetting(){
        driver.element().click(btn_Setting);
        return this;
    }
    public Setting_Common clickSupplier(){
        driver.element().click(btn_Supplier);
        return this;
    }
    public Setting_Common clickAdminSetting(){
        driver.element().click(btn_AdminSetting);
        return this;
    }

}