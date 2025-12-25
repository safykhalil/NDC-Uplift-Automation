package AdminPages.Master.Miscellaneous.Region;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Country_Page {
    public Country_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_AddCountry = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
    By Txt_CountryCode = By.xpath("//input[@id=\"id-Countrycode\"]");
    By Txt_CountryNameSearch = By.xpath("//input[@id=\"id-CountryName\"]");
    By Txt_CountryCodeSearch = By.xpath("//input[@id=\"id-CountryCode\"]");
    By Txt_AirLine  = By.xpath("//input[@id=\"id-Airline\"]");
    By Btn_SendForAprroval = By.xpath("//button[@type=\"submit\"]");
    By Rbtn_InternationalpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-Yes\"]]");
    By Rbtn_InternationalpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-No\"]]");
    By Rbtn_DomesticpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-Yes\"]]");
    By Rbtn_DomesticpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-No\"]]");
    //*//
    By Btn_Country = By.xpath("//button[@routerlink=\"country\"]");
   // By Txt_CountryName = By.xpath("//input[@id=\"id-CountryName\"]");
    // By Txt_CountryCode = By.xpath("//input[@id=\"id-CountryCode\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Update = By.xpath("//i[@class=\"pi pi-pencil\"]");
//    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
//    By Txt_CountryCode = By.xpath("//input[@id=\"id-Countrycode\"]");
//    By Txt_AirLine  = By.xpath("//input[@id=\"id-Airline\"]");
//    By Btn_SendForAprroval = By.xpath("//button[@type=\"submit\"]");
//    By Rbtn_InternationalpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-Yes\"]]");
//    By Rbtn_InternationalpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-No\"]]");
//    By Rbtn_DomesticpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-Yes\"]]");
//    By Rbtn_DomesticpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-No\"]]");
    By Btn_ThumbUp = By.xpath("//i[@class=\"pi pi-thumbs-up\"]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit = By.xpath("//span[contains(text(),'Submit')]");
    By Btn_ActiveIcon = By.xpath("//i[@class=\"pi pi-circle\"]");
    By Btn_InActiveIcon = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_ThumbDown = By.xpath("//i[@class=\"pi pi-thumbs-down\"]");
    By Txt_Remarks1 = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit1 = By.xpath("//span[contains(text(),'Submit')]");
//    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
//    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
//    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");

    public void AddCountry(){
        System.out.println("Start Method : Add a new Country");
        driver.element().click(Btn_AddCountry);
    }

    public void InternationalpassportmandatoryYes(){
        System.out.println("Start Method : Add InternationalpassportmandatoryYes");
        driver.element().click(Rbtn_InternationalpassportmandatoryYes);
    }

    public void InternationalpassportmandatoryNo(){
        System.out.println("Start Method : Add InternationalpassportmandatoryNo");
        driver.element().click(Rbtn_InternationalpassportmandatoryNo);
    }

    public void DomesticpassportmandatoryYes(){
        System.out.println("Start Method : Add DomesticpassportmandatoryYes");
        driver.element().click(Rbtn_DomesticpassportmandatoryYes);
    }

    public void DomesticpassportmandatoryNo(){
        System.out.println("Start Method : Add DomesticpassportmandatoryNo");
        driver.element().click(Rbtn_DomesticpassportmandatoryNo);
    }

    public void AddOperatingCountryName(String countryname , String countrycode , String airline){
        System.out.println("Start Method : AddOperatingCountryName");
        driver.element().type(Txt_CountryName,countryname);
        driver.element().type(Txt_CountryCode,countrycode);
//        driver.element().click(AirLine);
//        By option = By.xpath(String.format("//span[text()='%s']", airline));
//        driver.element().click(option);
        driver.element().type(Txt_AirLine,airline);
        driver.element().select(Txt_AirLine,airline);
        driver.element().click(Btn_SendForAprroval);

    }
    public String Actual()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));
        return S;
    }
    public void verifyURLorErrorMessages() {
        String expectedURL = "http://192.168.1.70/master/miscellaneous/region/country";
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
/// ***SearchCountry_Page***///////////////////////////////////////
public void setCountry(){
    driver.element().click(Btn_Country);
}

    public void ClickSearchcountry(String countryname ,String countrycode){

        System.out.println("Start Method : ClickSearchcountry");

        driver.element().type(Txt_CountryNameSearch,countryname);
        driver.element().type(Txt_CountryCodeSearch,countrycode);

    }

    public void ClickActive(){
        System.out.println("Start Method : Click Active");
        driver.element().click(Rbtn_Active);
    }

    public void ClickInactive(){
        System.out.println("Start Method : Click Inactive");
        driver.element().click(Rbtn_Inactive);
    }

    public void ClickBoth(){
        System.out.println("Start Method : Click Both");
        driver.element().click(Rbtn_Both);
    }

    public void ClickSearchGrid()
    {
        System.out.println("Start Method : ClickSearchGrid");
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
/// *** Action Country Page *** /////////////////////////////////////////////////////////////////
public void Setupdate(String countryname,String countrycode,String airline){
    driver.element().click(Btn_Update);
    driver.element().type(Txt_CountryName,countryname);
    driver.element().type(Txt_CountryCode,countrycode);
    driver.element().type(Txt_AirLine,airline);
    driver.element().select(Txt_AirLine,airline);
    driver.element().click(Btn_SendForAprroval);
}

    public void setThumbUp(String remarks){
        driver.element().click(Btn_ThumbUp);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Btn_Submit);

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

    public void setActive1(){
        driver.element().click(Rbtn_Active);
    }
    public void setInactive1(){
        driver.element().click(Rbtn_Inactive);
    }
    public void setBoth1(){
        driver.element().click(Rbtn_Both);
    }

    public void setInternationalpassportmandatoryYes1(){
        driver.element().click(Rbtn_InternationalpassportmandatoryYes);
    }

    public void setInternationalpassportmandatoryNo1(){
        driver.element().click(Rbtn_InternationalpassportmandatoryNo);
    }

    public void setDomesticpassportmandatoryYes1(){
        driver.element().click(Rbtn_DomesticpassportmandatoryYes);
    }

    public void setDomesticpassportmandatoryNo1(){
        driver.element().click(Rbtn_DomesticpassportmandatoryNo);
    }




}
