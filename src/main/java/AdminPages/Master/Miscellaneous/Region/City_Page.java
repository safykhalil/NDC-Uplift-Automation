package AdminPages.Master.Miscellaneous.Region;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class City_Page {
    public static final int MILLIS1 = 1000;
    public static final int MILLIS = 1000;
 //   public static final int MILLIS = 1000;

    public City_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_AddCity = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-CountryName\"]");
    By Txt_StateName = By.xpath("//input[@id=\"id-StateName\"]");
    By Txt_StateNameSearch = By.xpath("//input[@id=\"id-Statename\"]");
    By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Txt_CityName = By.xpath("//input[@id=\"id-Cityname\"]");
    By Txt_CityCode = By.xpath("//*[@id=\"id-CityCode\"]");
    By Btn_SendApproval = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Admin = By.xpath("//a[@href=\"/master\"]");
    By Btn_Miscellaneous = By.linkText("Miscellaneous");

    //    By Region = By.xpath("//a[@href=\"/master/miscellaneous/region/region\"]");
    By Btn_Region = By.xpath("//a[@href=\"/master/miscellaneous/region/region\"]");
    By Btn_City = By.xpath("//button[@routerlink=\"city\"]");
   // By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
   // By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Txt_CountryNameSearch = By.xpath("//input[@id=\"id-Countryname\"]");
  //  By Txt_CityName = By.xpath("//input[@id=\"id-Cityname\"]");
 //   By Txt_CityCode = By.xpath("//input[@id=\"id-CityCode\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchBtn = By.xpath("//button[@type=\"submit\"]");
    By Btn_setinActive = By.xpath("//i[@class=\"pi pi-circle-fill\"]");
    By Btn_setactive = By.xpath("//i[@class=\"pi pi-circle\"]");

    public void AddcityDetails(String countryname ,String statename,String cityname,String citycode) throws InterruptedException {
        System.out.println("Start Method : Add City Details ");
        driver.element().click(Btn_AddCity);
        Thread.sleep(MILLIS);
        driver.element().type(Txt_CountryName,countryname).select(Txt_CountryName,countryname);
        Thread.sleep(MILLIS);
        driver.element().type(Txt_StateName,statename);
        Thread.sleep(MILLIS);
        driver.element().select(Txt_StateName,statename);
        Thread.sleep(MILLIS);
        driver.element().type(Txt_CityName,cityname);
        Thread.sleep(MILLIS);
        driver.element().type(Txt_CityCode,citycode);
        Thread.sleep(MILLIS);
        driver.element().click(Btn_SendApproval);
        Thread.sleep(MILLIS);
    }

    public String Actual()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));
        return S;
    }

    public void verifyURLorErrorMessages() {
        String expectedURL = "http://192.168.1.70/master/miscellaneous/region/city";
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
    /// ***SearchRegionCity***/////////////////////////////////////////////////
    public void ClickonMaster(){
        System.out.println("Start Method : ClickonMaster ");
        driver.element().click(Btn_Admin);
    }
    public void ClickonMiscellanous(){
        System.out.println("Start Method : ClickonMiscellanous ");
        driver.element().click(Btn_Miscellaneous);
    }
    public void ClickonRegion(){
        System.out.println("Start Method : ClickonRegion ");
        driver.element().click(Btn_Region);
    }
    public void ClickonCity() throws InterruptedException {
        System.out.println("Start Method : ClickonCity ");
        driver.element().click(Btn_City);
        Thread.sleep(MILLIS1);
    }
    public void SearchRegionCity(String statename , String statecode,String countryname ,String cityname , String citycode) throws InterruptedException {
        System.out.println("Start Method : Search Region City ");

        driver.element().type(Txt_StateNameSearch,statename);
        Thread.sleep(MILLIS1);
        driver.element().type(Txt_StateCode,statecode);
        Thread.sleep(MILLIS1);
        driver.element().type(Txt_CountryNameSearch,countryname);
        Thread.sleep(MILLIS1);
        driver.element().type(Txt_CityName,cityname);
        Thread.sleep(MILLIS1);
        driver.element().type(Txt_CityCode,citycode);
    }

    public void ClickInActiveBtn() throws InterruptedException {
        System.out.println("Start Method : ClickInActiveBtn ");
        driver.element().click(Rbtn_Inactive);
        Thread.sleep(MILLIS1);
        driver.element().click(Btn_SearchBtn);
    }
    public void ClickActiveBtn() throws InterruptedException {
        System.out.println("Start Method : ClickActiveBtn ");
        driver.element().click(Rbtn_Active);
        Thread.sleep(MILLIS1);
        driver.element().click(Btn_SearchBtn);
    }
    public void ClickBoth(){
        System.out.println("Start Method : ClickBoth ");
        driver.element().click(Rbtn_Both);
        driver.element().click(Btn_SearchBtn);
    }

    public void Clickactive(){
        System.out.println("Start Method : Clickactive ");
        driver.element().click(Btn_setinActive);

    }
    public void Clickinactive(){
        System.out.println("Start Method : Clickinactive ");
        driver.element().click(Btn_setactive);

    }

    public void performAssertions() {
        String expectedHeaderApproval = "Approval Status";
        String[] allowedApprovalValues = {"Pending for approval", "Approved", "Rejected"};

        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");



            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));


                Assert.assertTrue(isValueInArray(actualDataStatus, allowedApprovalValues),
                        "Row " + i + ": The 'Approval Status' column data (" + actualDataStatus + ") does not match any of the allowed values.");


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