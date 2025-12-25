package AdminPages.Master.Miscellaneous.Region.City;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateCity_Page {

    public static final int MILLIS = 1000;

    public CreateCity_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_AddCity = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CountryName = By.xpath("//input[@id=\"id-CountryName\"]");
    By Txt_StateName = By.xpath("//input[@id=\"id-StateName\"]");
    By Txt_StateCode = By.xpath("//input[@id=\"id-StateCode\"]");
    By Txt_CityName = By.xpath("//input[@id=\"id-Cityname\"]");
    By Txt_CityCode = By.xpath("//*[@id=\"id-CityCode\"]");
    By Btn_SendApproval = By.xpath("//button[@type=\"submit\"]");

    public void AddcityDetails(String countryname ,String statename,String cityname,String citycode) throws InterruptedException {
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

}