package AdminPages.Master.Supplier;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Supplier_Page {

    public Supplier_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
    By Btn_Approve = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Txt_RemarksApprove = By.xpath("//textarea[@placeholder=\"Type your remarks description...\"]");
    By Btn_Submit = By.xpath("//span[contains(text(),'Submit')]");
    By Btn_Reject = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_RemarksReject = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Lst_ProductType = By.xpath("//p-dropdown[.//input[@id=\"id-ProductsType\"]]");
    By Lst_Country = By.xpath("//input[@id=\"id-Country\"]");
    By Txt_Email = By.xpath("//input[@id=\"id-1-Email\"]");
    By Lst_City = By.xpath("//input[@id=\"id-City\"]");
    By Txt_PinCode = By.xpath("//input[@id=\"id-PINcode\"]");
    By Btn_ClearCountry = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-supplier/div/div/ndc-fg-form-container/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div/ndc-fg-input[2]/ndc-fg-auto-complete-input/span/p-autocomplete/span/i");
    By Lst_WhitelistBoard = By.xpath("//input[@id=\"id-WhitelistAirports\"]");
    By Btn_Approved = By.xpath("(//button[@type=\"submit\"])[1]");
    //*//
    By Btn_Supplier = By.linkText("Supplier");
    By Btn_Supplier1 = By.xpath("//a[@href=\"/master/supplier/supplier\"]");
    //    By Supplier1 = By.xpath("//li[@req-url=\"/odeysysadmin/Master/searchSupplier\"]");
    By Txt_SupplierName = By.xpath("//input[@id=\"id-SupplierName\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//span[@class=\"p-button-label\"]");
    //*//
    By Btn_SupplerCredential = By.xpath("//a[@href=\"/master/supplier/supplier-credentials\"]");
    By Txt_CredentialName = By.xpath("//input[@id=\"id-Credentialname\"]");
    By Lst_Supplier = By.xpath("//p-dropdown[.//input[@id=\"id-Supplier\"]]");
//    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
//    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
//    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    By Btn_InActiveCircle = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ActiveCircle = By.xpath("//i[@class=\"pi pi-circle\"]");


    public void setEditBtn(String producttype , String country , String email , String city , String pincode , String whitelistboard,String whitelistboard2,String remarks) throws InterruptedException {
     driver.element().click(Btn_Edit);
     driver.element().click(Lst_ProductType);
     By option = By.xpath(String.format("//span[text()='%s']", producttype));
     driver.element().click(option);
     driver.element().click(Btn_ClearCountry);
       Thread.sleep(5000);
     driver.element().type(Lst_Country,country);
//     Thread.sleep(5000);
     driver.element().select(Lst_Country,"Egypt");
//     By option1 = By.xpath(String.format("//span[text()='%s']", country));
//     driver.element().click(option1);
     driver.element().type(Txt_Email,email);
     driver.element().clear(Lst_City);
       Thread.sleep(5000);
     driver.element().type(Lst_City,city);
//       Thread.sleep(5000);
       driver.element().select(Lst_City,"Cairo");
//     By option2 = By.xpath(String.format("//span[text()='%s']", city));
//     driver.element().click(option2);
     driver.element().type(Txt_PinCode,pincode);
     driver.element().type(Lst_WhitelistBoard,whitelistboard);
     Thread.sleep(10000);
     driver.element().select(Lst_WhitelistBoard,"Ada Municipal").click(Lst_WhitelistBoard);
     Thread.sleep(10000);
     driver.element().type(Lst_WhitelistBoard,whitelistboard2);
     Thread.sleep(10000);
     driver.element().select(Lst_WhitelistBoard,"Cairo").click(Lst_WhitelistBoard);
     driver.element().type(Txt_RemarksApprove,remarks);
     driver.element().click(Btn_Approved);
     Thread.sleep(6000);
   }

   public void setApprove(String remarks){
       driver.element().click(Btn_Approved);
       driver.element().type(Txt_RemarksReject,remarks);
       driver.element().click(Btn_Submit);

   }

   public void setReject(String remarks){

       driver.element().click(Btn_Reject);
       driver.element().type(Txt_RemarksReject,remarks);
       driver.element().click(Btn_Submit);

   }
   /// *** Search Supplier Page *** ////////////////////////////////////////////////////////////////////////////////////
   public void clickonsupplier(){
       driver.element().click(Btn_Supplier);
   }

    public void searchsupplierdata(String suppliername  ){
        driver.element().click(Btn_Supplier1);
        driver.element().type(Txt_SupplierName,suppliername);


    }

    public void setInActiveBtn() throws InterruptedException {
        driver.element().click(Rbtn_Inactive);
        driver.element().click(Btn_SearchGrid);
    }
    public void setActiveBtn() throws InterruptedException {
        driver.element().click(Rbtn_Active);
        driver.element().click(Btn_SearchGrid);
    }
    public void setBoth(){
        driver.element().click(Rbtn_Both);
        driver.element().click(Btn_SearchGrid);
    }

    public void performAssertions() {
        String expectedHeaderStatus = "Type";

        String[] allowedStatusValues = {"GDS", "LCC","Both"};


        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[2]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Type' table header does not match the expected value.");


            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));

                Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                        "Row " + i + ": The 'Type' column data (" + actualDataStatus + ") does not match any of the allowed values.");

            }

        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }
    }

    public boolean isValueInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
