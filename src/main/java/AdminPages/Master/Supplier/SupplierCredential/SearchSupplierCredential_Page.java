package AdminPages.Master.Supplier.SupplierCredential;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchSupplierCredential_Page {
    public SearchSupplierCredential_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;


    By Btn_SupplerCredential = By.xpath("//a[@href=\"/master/supplier/supplier-credentials\"]");
    By Txt_CredentialName = By.xpath("//input[@id=\"id-Credentialname\"]");
    By Lst_Supplier = By.xpath("//p-dropdown[.//input[@id=\"id-Supplier\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    By Btn_InActiveCircle = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ActiveCircle = By.xpath("//i[@class=\"pi pi-circle\"]");

    public void ClickonSupplierCredential(){
        driver.element().click(Btn_SupplerCredential);
    }

    public void setSearchCredential(String credentialname ,String supplier){

        driver.element().type(Txt_CredentialName,credentialname);
        driver.element().click(Lst_Supplier);
        By option = By.xpath(String.format("//span[text()='%s']", supplier));
        driver.element().click(option);

    }

    public void setActive(){
        driver.element().click(Rbtn_Active);
        driver.element().click(Btn_Search);
    }

    public void setInactive(){
        driver.element().click(Rbtn_Inactive);
        driver.element().click(Btn_Search);
    }

    public void setBoth(){
        driver.element().click(Rbtn_Both);
        driver.element().click(Btn_Search);
    }

    public void setActiveCircle(){
        driver.element().click(Btn_ActiveCircle);
    }

    public void setInactiveCircle(){
        driver.element().click(Btn_InActiveCircle);
    }

}
