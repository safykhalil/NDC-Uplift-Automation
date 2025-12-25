package AdminPages.Master.Miscellaneous.Region;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Region_Page {
    public Region_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_AddRegion = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_RegionName = By.xpath("//input[@id=\"id-Region\"]");
    By Txt_RegionCode = By.xpath("//input[@id=\"id-Regioncode\"]");
    By Txt_RegionCodeSearch = By.xpath("//input[@id=\"id-RegionCode\"]");
    By Lst_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
    By Btn_SendforAprroval = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_UpdateIcon = By.xpath("//i[@class=\"pi pi-pencil\"]");
  //  By Txt_RegionName = By.xpath("//input[@id=\"id-Region\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
 //   By Btn_SendforAprroval = By.xpath("(//button[@type=\"submit\"])[3]");
    By Btn_ThumbUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit = By.xpath("(//span[contains(text(),'Submit')])[3]");
    By Btn_ActiveIcon = By.xpath("//i[@class=\"pi pi-circle\"]");
    By Btn_InActiveIcon = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ThumbDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_Remarks1 = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit1 = By.xpath("//span[contains(text(),'Submit')]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    //*//
//    By Txt_RegionName = By.xpath("//input[@id=\"id-Region\"]");
//    By Txt_RegionCode = By.xpath("//input[@id=\"id-RegionCode\"]");
//    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
//    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
//    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");




    public void setRegionName(String regionName , String regionCode , String countryName){
        driver.element().click(Btn_AddRegion);
        driver.element().type(Txt_RegionName,regionName);
        driver.element().type(Txt_RegionCode,regionCode);
        driver.element().type(Lst_CountryName,countryName);
        driver.element().select(Lst_CountryName,countryName);
        driver.element().click(Btn_SendforAprroval);
    }

    public void verifyURLorErrorMessages() {
        String expectedURL = "http://192.168.1.70/master/miscellaneous/region/region";
        String expectedError2 = "unique validation error";
        String expectedError = "required validation error";
        String actualURL = driver.browser().getCurrentURL();

        // First check: Verify the URL
        if (actualURL.equals(expectedURL)) {
            System.out.println("URL verification passed.");
            driver.verifyThat().browser().url().isEqualTo(expectedURL).perform();
            Assert.assertEquals(actualURL, expectedURL, "URL does not match the expected value.");
        } else {
            System.out.println("URL verification failed. Attempting to check for an error message...");

            // Initialize variables to hold error messages
            String errorText1 = "";
            String errorText2 = "";

            // Try to find the first error message
            try {
                errorText1 = driver.getDriver().findElement(By.xpath("//span[contains(text(),' required validation error ')]")).getText();
            } catch (Exception e) {
                System.out.println("First error message element not found.");
            }

            // Try to find the second error message
            try {
                errorText2 = driver.getDriver().findElement(By.xpath("//span[contains(text(),'unique validation error')]")).getText();
            } catch (Exception e) {
                System.out.println("Second error message element not found.");
            }

            // Check if the first error text matches the expected error
            if (!errorText1.isEmpty() && errorText1.equals(expectedError)) {
                System.out.println("First error message verification passed.");
                Assert.assertEquals(errorText1, expectedError);
            }
            // Check if the second error text matches the expected error
            else if (!errorText2.isEmpty() && errorText2.equals(expectedError2)) {
                System.out.println("Second error message verification passed.");
                Assert.assertEquals(errorText2, expectedError2);
            }
            // If neither error message matches
            else {
                System.out.println("Neither the URL nor any error messages matched the expected values.");
                Assert.fail("Test failed: Neither the URL nor any error messages matched the expected values.");
            }
        }
    }
/// *** Action Region Page ***////////////////////////////////////////////////////////////////
public void setUpdate(String regionName   , String countryName,String remarks){
    driver.element().click(Btn_UpdateIcon);
    driver.element().type(Txt_RegionName,regionName);
    driver.element().type(Txt_CountryName,countryName);
    driver.element().select(Txt_CountryName,countryName);
    driver.element().type(Txt_Remarks,remarks);
    driver.element().click(Btn_SendforAprroval);
}

    public void setThumbUp(String remarks){
        driver.element().click(Btn_ThumbUp);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_Submit1);

    }

    public void setThumbDown(String remarks){
        driver.element().click(Btn_ThumbDown);
        driver.element().type(Txt_Remarks1,remarks);
        driver.element().click(Btn_Submit1);

    }

    public void setActiveIcon(){
        driver.element().click(Btn_ActiveIcon);

    }

    public void setInActiveIcon(){
        driver.element().click(Btn_InActiveIcon);
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
/// *** Search Region Page ***///////////////////////////////////////////////////////////////////
public void setRegionName(String regionName , String regionCode){
    driver.element().type(Txt_RegionName,regionName);
    driver.element().type(Txt_RegionCodeSearch,regionCode);

}

    public void setActive1(){
       driver.element().click(Rbtn_Active); }
    public void setInactive1(){
        driver.element().click(Rbtn_Inactive);
    }
    public void setBoth1(){
        driver.element().click(Rbtn_Both);
    }
    public void setSearch(){
        driver.element().click(Btn_Search);

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
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[5]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");

            String actualHeaderApproval = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
            Assert.assertEquals(actualHeaderApproval, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");

            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[5]"));
                String actualDataApproval = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));

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

    private boolean isValueInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
