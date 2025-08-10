package AdminPages.Master.Supplier.SupplierCredential;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class EditSupplierCredential_Page {
    public EditSupplierCredential_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Txt_CredentialName = By.xpath("//input[@id=\"id-CredentialName\"]");

    public void setEditSuppliercredential(String credentialname){

        driver.element().click(Btn_Edit);
        driver.element().type(Txt_CredentialName,credentialname);
    }
}
