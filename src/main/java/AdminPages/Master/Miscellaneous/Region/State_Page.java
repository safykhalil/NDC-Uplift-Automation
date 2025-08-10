package AdminPages.Master.Miscellaneous.Region;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class State_Page {
    public State_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;
    By Btn_AddState = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
    By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Lst_CountryName = By.xpath("//p-dropdown[.//input[@id=\"id-CountryName\"]]");
    By Btn_SendForApproval = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_State = By.xpath("//button[@routerlink=\"state\"]");
    //  By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
    // By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Txt_CountryName = By.xpath("//p-dropdown[.//input[@id=\"id-Countryname\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Edit = By.xpath("//i[@class=\"pi pi-pencil\"]");
    // By Txt_StateName = By.xpath("//input[@id=\"id-Statename\"]");
   // By Lst_CountryName = By.xpath("//p-dropdown[.//input[@id=\"id-CountryName\"]]");
    By Txt_Remarks = By.xpath("//textarea[@placeholder=\"remarks...\"]");
   // By Btn_SendForApproval = By.xpath("(//button[@type=\"submit\"])[3]");


    public void setAddState(String statename, String statecode, String countryname) {
        System.out.println("Start Method : setAddState");
        driver.element().click(Btn_AddState);
        driver.element().type(Txt_StateName, statename);
        driver.element().type(Txt_StateCode, statecode);
        driver.element().click(Lst_CountryName);
        By option = By.xpath(String.format("//span[text()='%s']", countryname));
        driver.element().click(option);
        driver.element().click(Btn_SendForApproval);
    }

    public void verifyURLorErrorMessages() {
        String expectedURL = "http://192.168.1.70/master/miscellaneous/region/state";
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

    public String Actual() {
        String S = driver.element().getText(By.xpath("//div[@aria-label=\"Your Top up has been processed successfully and sent for approval!!\"]"));
        return S;
    }

    /// *** Search State Page ***/////////////////////////////////////////////////////////////////////////////////////////

    public void setState(String statename, String statecode, String countryname) {
        System.out.println("Start Method : setState");
        driver.element().type(Txt_StateName, statename);
        driver.element().type(Txt_StateCode, statecode);
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

    public void ClickStatebtn() {
        System.out.println("Start Method : ClickStatebtn");
        driver.element().click(Btn_State);
    }

    public void ClickActive() {
        System.out.println("Start Method : ClickActive");
        driver.element().click(Rbtn_Active);
    }

    public void ClickInactive() {
        System.out.println("Start Method : ClickInactive");
        driver.element().click(Rbtn_Inactive);
    }

    public void ClickBoth() {
        System.out.println("Start Method : ClickBoth");
        driver.element().click(Rbtn_Both);
    }

    public void ClickSearch() {
        System.out.println("Start Method : ClickSearch");
        driver.element().click(Btn_Search);

    }
    /// *** Action State Page ***//////////////////////////////////////////////////////////////////////////////////
    public void AddState( String remarks , String countryname){
        System.out.println("Start Method : Add State");
        driver.element().click(Btn_Edit);
        //  driver.element().type(Txt_StateName,statename);
        driver.element().type(Txt_Remarks,remarks);
        driver.element().click(Lst_CountryName);
        By option = By.xpath(String.format("//span[text()='%s']", countryname));
        driver.element().click(option);
        driver.element().click(Btn_SendForApproval);
    }

}
