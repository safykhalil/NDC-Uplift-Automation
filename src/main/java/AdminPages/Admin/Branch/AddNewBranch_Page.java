package AdminPages.Admin.Branch;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class AddNewBranch_Page {

   public AddNewBranch_Page(SHAFT.GUI.WebDriver driver) {
      this.driver = driver;
   }
   SHAFT.GUI.WebDriver driver ;

   /////////////Branch Details//////////////

   By Branch = By.xpath("//a[@href=\"/admin/branch\"]");
   By AddBranch = By.xpath("//a[@href=\"/odeysysadmin/Admin/addBranchView\"]");
   By SelectBrand = By.xpath("//select[@id=\"brand\"]");
   By SelectOperatingCountry = By.xpath("//input[@id=\"operatingCountry\"]");
   By BranchName = By.xpath("//input[@id=\"groupName\"]");
   By Country = By.xpath("//input[@id=\"countryName\"]");
   By State = By.xpath("//select[@id=\"state\"]");
   By City = By.xpath("//select[@id=\"city\"]");
   By Address = By.xpath("//textarea[@id=\"address1\"]");
   By PostOffice = By.xpath("//input[@id=\"zip\"]");
   By PhoneNO = By.xpath("//input[@id=\"phoneOne1\"]");

   //////////Branch Email Config Info//////////

   By EmailID = By.xpath("//input[@id=\"branchEmail\"]");
   By Password = By.xpath("//input[@type=\"password\"]");

   ////////////Branch Contact Info//////////////

   By Name = By.xpath("//input[@id=\"name1\"]");
   By Email = By.xpath("//input[@id=\"email\"]");
   By Phone = By.xpath("//input[@id=\"phone1\"]");
   By SelectDepartment = By.xpath("//a[@class=\"select-form-control branch-dept-arrow\"]");
   By branchManagerIcon = By.xpath("//input[@value=\"GDS\"]");
   By CreditLimit = By.xpath("//input[@id=\"creditLimit\"]");
   By TopUpLimit = By.xpath("//input[@id=\"topupLimit\"]");
   By CreditTerms = By.xpath("//input[@id=\"creditTerms\"]");
   By PaymentMode = By.xpath("(//label[@for=\"check0\"])[2]");
   By Supplier = By.xpath("//label[@for=\"check[0]\"]");
   By Description = By.xpath("//input[@id=\"desc_0\"]");
   By SupplierCredential = By.xpath("//*[@id=\"credentialGalileo0\"]/option[2]");
   // By ManagerName = By.xpath("//input[@id=\"managerNameGalileo0\"]");
   By SupplierDescription = By.xpath("//input[@id=\"descriptionPccGalileo0\"]");
   By SendApprove = By.xpath("//input[@id=\"create\"]");
   Alert alert;

   public void BranchDetails(String brand , String country ,String operatingcountry , String branchname , String state , String city
           , String address, String postoffice, String phoneno, String emailid, String password, String name
           , String email, String phone, String creditlimit, String topup,String creditterm
           ,String description,String supplierdescription) throws InterruptedException {
      driver.element().click(Branch);
      driver.element().click(AddBranch);
      Thread.sleep(Long.parseLong("1000"));
      driver.element().select(SelectBrand,brand);
      driver.element().type(SelectOperatingCountry,operatingcountry);
      driver.element().select(SelectOperatingCountry,country);
      driver.element().type(BranchName,branchname);
      Thread.sleep(Long.parseLong("1000"));
      driver.element().select(State,state);
      driver.element().select(City,city);
      driver.element().type(Address,address);
      driver.element().type(PostOffice,postoffice);
      driver.element().type(PhoneNO,phoneno);
      driver.element().type(EmailID,emailid);
      driver.element().type(Password,password);
      driver.element().type(Name,name);
      driver.element().type(Email,email);
      driver.element().type(Phone,phone);
      driver.element().click(SelectDepartment).scrollToElement(branchManagerIcon).click(branchManagerIcon);
      driver.element().type(CreditLimit,creditlimit);
      driver.element().type(TopUpLimit,topup);
      driver.element().type(CreditTerms,creditterm);
      driver.element().click(PaymentMode);
      driver.element().click(Supplier);
      driver.element().type(Description,description);
      driver.element().click(SupplierCredential);
      //driver.element().type(ManagerName,managername);
      driver.element().type(SupplierDescription,supplierdescription);
      driver.element().click(SendApprove);


   }
   public void Alert() throws InterruptedException {
      Thread.sleep(1000);
      alert = driver.getDriver().switchTo().alert();
      // alertText = alert.getText();
      alert.accept();
      Thread.sleep(1000);
      alert.accept();
      Thread.sleep(1000);
      alert.accept();
      Thread.sleep(1000);


   }
   public void performAssertions () {
      String expectedHeaderStatus = "Approval Status";
      // String expectedHeaderApproval = "Payment Mode";
      String[] allowedStatusValues = {"Approved"};
      //     String[] allowedApprovalValues = {"Offline", "Online"};

      try {
         // Wait for the table to be present and the text to be loaded
         Thread.sleep(1000);

         // Find and verify the table headers
         String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[6]"));
         Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");


         // Get the number of rows in the table body
         List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
         int numberOfRows = rows.size();

         // Iterate through each row and verify the data in the relevant columns
         for (int i = 1; i <= numberOfRows; i++) {
            String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[6]"));

            Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                    "Row " + i + ": The 'Status' column data (" + actualDataStatus + ") does not match any of the allowed values.");



         }

      } catch (Exception e) {
         // Print the stack trace to help with debugging if an exception occurs
         e.printStackTrace();
         Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
      }
   }


   private boolean isValueInArray (String value, String[]array){
      for (String element : array) {
         if (element.equals(value)) {
            return true;
         }
      }
      return false;
   }
}