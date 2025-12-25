package AdminPages.Master.Miscellaneous.Region.Country;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateCountry_Page {
    public CreateCountry_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_AddCountry = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-Countryname\"]");
    By Txt_CountryCode = By.xpath("//input[@id=\"id-Countrycode\"]");
    By Txt_AirLine  = By.xpath("//input[@id=\"id-Airline\"]");
    By Btn_SendForAprroval = By.xpath("//button[@type=\"submit\"]");
    By Rbtn_InternationalpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-Yes\"]]");
    By Rbtn_InternationalpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Internationalpassportmandatory-No\"]]");
    By Rbtn_DomesticpassportmandatoryYes = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-Yes\"]]");
    By Rbtn_DomesticpassportmandatoryNo = By.xpath("//p-radiobutton[.//input[@id=\"id-Domesticpassportmandatory-No\"]]");

    public void setAddCountry(){
        driver.element().click(Btn_AddCountry);
    }

    public void setInternationalpassportmandatoryYes(){
        driver.element().click(Rbtn_InternationalpassportmandatoryYes);
    }

    public void setInternationalpassportmandatoryNo(){
        driver.element().click(Rbtn_InternationalpassportmandatoryNo);
    }

    public void setDomesticpassportmandatoryYes(){
        driver.element().click(Rbtn_DomesticpassportmandatoryYes);
    }

    public void setDomesticpassportmandatoryNo(){
        driver.element().click(Rbtn_DomesticpassportmandatoryNo);
    }

    public void setOperatingCountryName(String countryname , String countrycode , String airline){
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
}
