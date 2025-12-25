package AdminPages.RuleEngine.OfferPricing;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static io.netty.handler.ssl.OpenSslCertificateCompressionConfig.AlgorithmMode.Both;
import static org.sikuli.script.Mouse.click;

public class SearchOffer_Page {
    private final AdminPages.Helper.PaginationHelper paginationHelper;

    public SearchOffer_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
        this.paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
    }

    SHAFT.GUI.WebDriver driver;
    By Btn_Rule = By.xpath("//a[@href=\"/rule-engine\"]");
    By Btn_Offer = By.xpath("(//div[@class=\"panel-heading accordion-toggle\"])[5]");
    By Lst_Discount = By.xpath("//p-dropdown[.//input[@id=\"id-Discount\"]]");
    By Rbtn_ActiveandInactive = By.xpath("(//p-radiobutton[.//div[@class=\"p-radiobutton-box\"]])[1]");
    By Rbtn_Both = By.xpath("(//p-radiobutton[.//div[@class=\"p-radiobutton-box\"]])[2]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    By Btn_ThumpUp = By.xpath("(//i[@class=\"pi pi-thumbs-up\"])[1]");
    By Txt_RemarksUp = By.xpath("//textarea[@placeholder=\"remarks...\"]");
    By Btn_Submit = By.xpath("(//button[@type=\"submit\"])[2]");
    By Btn_ThumpDown = By.xpath("(//i[@class=\"pi pi-thumbs-down\"])[1]");



    public void navigateToOfferSection() {
        driver.element().click(Btn_Rule)
                .click(Btn_Offer);
    }
    public void SetSearchOffer(String Discount) {
                driver.element().click(Lst_Discount);
        By dropdownOption = By.xpath("//*[contains(text(),'" + Discount + "')]");
        driver.element().click(dropdownOption);

    }

    public void setActive() {
        driver.element().click(Rbtn_ActiveandInactive);
    }

    public void search() {
        driver.element().click(Btn_Search);
    }

    public void setInactive() {
        driver.element().click(Rbtn_ActiveandInactive);
    }

    public void setBoth() {
        driver.element().click(Rbtn_Both);
    }

    public void setThumpUp(String remarksup) {
        driver.element().click(Btn_ThumpDown);
        driver.element().click(Txt_RemarksUp);
        driver.element().type(Txt_RemarksUp, remarksup);
        driver.element().click(Btn_Submit);
    }
        public void performAssertions() {
            String expectedHeaderStatus = "Status";
         //   String expectedHeaderApproval = "Status";
            String[] allowedStatusValues = {"Active", "Inactive"};
            String[] allowedApprovalValues = {"Active", "Inactive"};

            try {
                // Wait for the table to be present and the text to be loaded
                Thread.sleep(1000);

                // Find and verify the table headers
                String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
                Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");

                String actualHeaderApproval = driver.element().getText(By.xpath("//table/thead/tr/th[4]"));
               // Assert.assertEquals(actualHeaderApproval, expectedHeaderApproval, "The 'Approval Status' table header does not match the expected value.");

                // Get the number of rows in the table body
                List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
                int numberOfRows = rows.size();

                // Iterate through each row and verify the data in the relevant columns
                for (int i = 1; i <= numberOfRows; i++) {
                    String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
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



