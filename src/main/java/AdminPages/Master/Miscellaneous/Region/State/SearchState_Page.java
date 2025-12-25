package AdminPages.Master.Miscellaneous.Region.State;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SearchState_Page {

    public SearchState_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver;
    By Btn_State = By.xpath("//button[@routerlink=\"state\"]");
    By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
    By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Txt_CountryName = By.xpath("//p-dropdown[.//input[@id=\"id-Countryname\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");

   public void setState(String statename, String statecode , String countryname){
       driver.element().type(Txt_StateName,statename);
       driver.element().type(Txt_StateCode,statecode);
       driver.element().click(Txt_CountryName);
       By option = By.xpath(String.format("//span[text()='%s']", countryname));
       driver.element().click(option);

   }
    public void performAssertions() {

        String expectedHeaderApproval = "Approval Status";
        String[] allowedApprovalValues = {"Pending for approval", "Approved", "Rejected"};

        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);



            String actualHeaderApproval = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
            Assert.assertEquals(actualHeaderApproval, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");

            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataApproval = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));


                Assert.assertTrue(isValueInArray(actualDataApproval, allowedApprovalValues),
                        "Row " + i + ": The 'Approval Status' column data (" + actualDataApproval + ") does not match any of the allowed values.");


            }

        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }
    }

    private boolean isValueInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void setStatebtn(){
       driver.element().click(Btn_State);
    }
    public void setActive(){
        driver.element().click(Rbtn_Active);
    }
    public void setInactive(){
        driver.element().click(Rbtn_Inactive);
    }
    public void setBoth(){
        driver.element().click(Rbtn_Both);
    }
    public void setSearch(){
        driver.element().click(Btn_Search);

    }









}
