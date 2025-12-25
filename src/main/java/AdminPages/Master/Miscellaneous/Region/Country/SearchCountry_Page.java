package AdminPages.Master.Miscellaneous.Region.Country;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchCountry_Page {

    public SearchCountry_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Country = By.xpath("//button[@routerlink=\"country\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-CountryName\"]");
    By Txt_CountryCode = By.xpath("//input[@id=\"id-CountryCode\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//button[@type=\"submit\"]");

    public void setCountry(){
        driver.element().click(Btn_Country);
    }

    public void setSearchcountry(String countryname ,String countrycode){

        driver.element().type(Txt_CountryName,countryname);
        driver.element().type(Txt_CountryCode,countrycode);

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

    public void setSearchGrid()
   {
    driver.element().click(Btn_SearchGrid);
   }

    public void performAssertions() {
        String expectedHeaderStatus = "Status";
        String expectedHeaderApproval = "Approval Status";
        String[] allowedStatusValues = {"Active", "Inactive"};
        String[] allowedApprovalValues = {"Pending for approval", "Approved", "Rejected"};

        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");

            String actualHeaderApproval = driver.element().getText(By.xpath("//table/thead/tr/th[3]"));
            Assert.assertEquals(actualHeaderApproval, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");

            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
                String actualDataApproval = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[3]"));

                Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                        "Row " + i + ": The 'Status' column data (" + actualDataStatus + ") does not match any of the allowed values.");

                Assert.assertTrue(isValueInArray(actualDataApproval, allowedApprovalValues),
                        "Row " + i + ": The 'Approval Status' column data (" + actualDataApproval + ") does not match any of the allowed values.");

                // Additional validation: If Approval Status is "Rejected", Status cannot be "Active"
                if (actualDataApproval.equals("Rejected")) {
                    Assert.assertNotEquals(actualDataStatus, "Active",
                            "Row " + i + ": The 'Status' cannot be 'Active' if the 'Approval Status' is 'Rejected'.");
                }
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
