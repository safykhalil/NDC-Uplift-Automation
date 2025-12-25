package AdminPages.Master.Supplier.SupplierCredential;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ReflectionForSupplierCredential_Page {
    public ReflectionForSupplierCredential_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

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



    public void setBranch(String OP,String country ) throws InterruptedException {
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
        driver.element().click(Btn_Agency);
        driver.element().click(Btn_Agency1);
        driver.element().click(Btn_AddAgency);
        driver.element().select(Lst_SelectBranch,selectbranch);
        driver.element().click(Btn_AmadeusPcc);
       // driver.element().click(Cancel);
    }




}
