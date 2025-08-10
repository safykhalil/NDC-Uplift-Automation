package AdminPages.Master.Miscellaneous;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Currency_Page {

    public Currency_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_Admin = By.xpath("//a[@href=\"/master\"]");
    By Btn_Miscellaneous = By.linkText("Miscellaneous");
    By Btn_Add = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CurrencyName = By.xpath("//input[@id=\"id-Currencyname\"]");
    By Txt_CurrencyCode = By.xpath("//input[@id=\"id-Currencycode\"]");
    By Lst_DecimalCount = By.xpath("//p-dropdown[.//input[@id=\"id-Decimalcount\"]]");
    By Txt_Country = By.xpath("//input[@id=\"id-Country\"]");
    By Btn_SendforApproval = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Currency = By.xpath("//a[@href=\"/master/miscellaneous/currency\"]");
    By TXT_CurrencyName = By.xpath("//input[@id=\"id-Currencyname\"]");
    By TXT_CurrencyCode = By.xpath("//input[@id=\"id-Currencycode\"]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_SearchGrid = By.xpath("//button[@type=\"submit\"]");


    public void CreateCurrencyy(String currencyname , String currencycode , String decimal, String country) throws InterruptedException {
        System.out.println("Start Method : Create a new Currency ");
        driver.element().click(Btn_Add);
        driver.element().type(Txt_CurrencyName,currencyname);
        driver.element().type(Txt_CurrencyCode,currencycode);
        driver.element().select(Lst_DecimalCount,decimal);
//        driver.element().click(DecimalCount);
//        By option = By.xpath(String.format("//span[text()='%s']", decimal));
//        driver.element().click(option);
        Thread.sleep(2000);
        driver.element().type(Txt_Country,country);
        Thread.sleep(3000);
        driver.element().select(Txt_Country,country);
        Thread.sleep(3000);


    }
    public String Actual()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));;
        return S;
    }
    /// **SearchCurrency**///////////////////////////////////////////////////////
    public void ClickonMaster(){
        driver.element().click(Btn_Admin);
    }
    public void ClickonMiscellanous(){
        driver.element().click(Btn_Miscellaneous);
    }
    public void setSendforApproval(){
        driver.element().click(Btn_SendforApproval);
    }
    public void SearchCurrency(String currencyname , String currencycode){
        System.out.println("Start Method : Search a Currency ");

        driver.element().type(TXT_CurrencyName,currencyname);
        driver.element().type(TXT_CurrencyCode,currencycode);

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
    private boolean isValueInArray(String value, String[] array) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void setCurrency(){driver.element().click(Btn_Currency);
        System.out.println("Start Method : setCurrency");}

    public void ClickActive(){
        System.out.println("Start Method : ClickActive");
        driver.element().click(Rbtn_Active);
    }

    public void ClickInactive(){
        System.out.println("Start Method : ClickInactive");
        driver.element().click(Rbtn_Inactive);
    }

    public void ClickBoth(){
        System.out.println("Start Method : ClickBoth");
        driver.element().click(Rbtn_Both);
    }

    public void ClickSearchGrid()
    {
        System.out.println("Start Method : ClickSearchGrid ");
        driver.element().click(Btn_SearchGrid);
    }

}
