package AdminPages.Admin.Company.OperatingCountry;
import AdminPages.Admin.AdminMenu;
import AdminPages.Admin.Company.OperatingCountry_Page;
import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateCountry_TC extends TestBase_TC {
    private Staff_Page staff;
    private OperatingCountry_Page operatingCountryPage;
    private LogIn_Page logIn;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }


    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();
        new AdminMenu(driver).openSubAdmin().Company().OperatingCountry();

    }


    @Test(dataProvider = "JsonProvider")
    public void CreateOperatingCountry(Map<String, String> OP) throws InterruptedException {
        staff = new Staff_Page(driver);
        operatingCountryPage = new OperatingCountry_Page(driver);
//        staff.Clickonadmin();
        String OperatingCountryName = OP.get("OperatingCountryName");
        String Country = OP.get("Country");
        String Currency = OP.get("Currency");
        operatingCountryPage.AddCountry(OperatingCountryName, Country, Currency);
    

    }

//    @Test(dataProvider = "OpCountrySearch", dataProviderClass = JsonDataProvider.class)
//    public void setSearchCompanyBoth(Map<String, String> OP) throws InterruptedException {
//        staff = new Staff_Page(driver);
//        operatingCountryPage = new OperatingCountry_Page(driver);
//        staff.Clickonadmin();
//        operatingCountryPage.setOperatingCountry("Ahmedd", "Andorra");
//        operatingCountryPage.setBoth();
//        operatingCountryPage.setSearchGrid();
//
//
//
//    }
//    public void verifyURLorErrorMessages() {
//        String expectedURL = "http://192.168.1.93/admin/operating-country";
//        String expectedError2 = "unique validation error";
//        String expectedError = "required validation error";
//        String actualURL = driver.browser().getCurrentURL();
//
//        // First check: Verify the URL
//        if (actualURL.equals(expectedURL)) {
//            System.out.println("URL verification passed.");
//            driver.verifyThat().browser().url().isEqualTo(expectedURL).perform();
//            Assert.assertEquals(actualURL, expectedURL, "URL does not match the expected value.");
//        } else {
//            System.out.println("URL verification failed. Attempting to check for an error message...");
//
//            // Initialize variables to hold error messages
//            String errorText1 = "";
//            String errorText2 = "";
//
//            // Try to find the first error message
//            try {
//                errorText1 = driver.getDriver().findElement(By.xpath("//span[contains(text(),' required validation error ')]")).getText();
//            } catch (Exception e) {
//                System.out.println("First error message element not found.");
//            }
//
//            // Try to find the second error message
//            try {
//                errorText2 = driver.getDriver().findElement(By.xpath("//span[contains(text(),'unique validation error')]")).getText();
//            } catch (Exception e) {
//                System.out.println("Second error message element not found.");
//            }
//
//            // Check if the first error text matches the expected error
//            if (!errorText1.isEmpty() && errorText1.equals(expectedError)) {
//                System.out.println("First error message verification passed.");
//                Assert.assertEquals(errorText1, expectedError);
//            }
//            // Check if the second error text matches the expected error
//            else if (!errorText2.isEmpty() && errorText2.equals(expectedError2)) {
//                System.out.println("Second error message verification passed.");
//                Assert.assertEquals(errorText2, expectedError2);
//            }
//            // If neither error message matches
//            else {
//                System.out.println("Neither the URL nor any error messages matched the expected values.");
//                Assert.fail("Test failed: Neither the URL nor any error messages matched the expected values.");
//            }
//        }
//    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}