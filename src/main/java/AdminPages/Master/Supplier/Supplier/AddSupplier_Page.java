package AdminPages.Master.Supplier.Supplier;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddSupplier_Page {
    public AddSupplier_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By AddSupplier = By.xpath("//button[@routerlink=\"add\"]");
    By SelectProduct = By.xpath("//p-dropdown[.//input[@id=\"id-Products\"]]");
    By SupplierName = By.xpath("//p-dropdown[.//input[@id=\"id-Suppliername\"]]");
    By Country = By.xpath("//input[@id=\"id-Country\"]");
    By EmailID = By.xpath("//input[@id=\"id-EmailID\"]");
    By PinCode = By.xpath("//input[@id=\"id-PINcode\"]");
    By City = By.xpath("//input[@id=\"id-City\"]");
    By Address1 = By.xpath("//input[@id=\"id-Address1\"]");
    By SupplierType = By.xpath("//p-dropdown[.//input[@id=\"id-Suppliertype\"]]");

    ///////////////////////Supplier contact person info///////////////
    By Name = By.xpath("//input[@id=\"id-Name\"]");

}
