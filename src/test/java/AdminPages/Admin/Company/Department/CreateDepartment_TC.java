package AdminPages.Admin.Company.Department;
import AdminPages.Admin.AdminMenu;
import AdminPages.Admin.Company.Department_Page;
import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateDepartment_TC extends TestBase_TC {
    private Staff_Page staff;
    private Department_Page departmentPage;
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
        new AdminMenu(driver).openSubAdmin().Company().Department();

    }

    @Test(dataProvider = "JsonProvider")
    public void CreateDepartment(Map<String, String> department) throws InterruptedException {
        departmentPage = new Department_Page(driver);
        staff = new Staff_Page(driver);
        staff.Clickonadmin();

        String DepartmentName = department.get("DepartmentName");
        String AssignedQueue = department.get("AssignedQueue");

//        departmentPage.setCompany();
//        departmentPage.ClickSideMDepartment();
        departmentPage.AddDepartment(DepartmentName, AssignedQueue);
        departmentPage.setSendApprroval();

        String expectedURL = "http://192.168.1.90/admin/department";
        String expectedError2 = "unique validation error";
        String expectedError = "required validation error";

        Thread.sleep(3000);

        // Get the current URL
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
                errorText1 = driver.getDriver().findElement(By.xpath("/html/body/ndc-root/ndc-layout" +
                        "/div/div[2]/div[1]/div/ndc-add-department/div/div" +
                        "/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/span")).getText();
            } catch (Exception e) {
                System.out.println("First error message element not found.");
            }

            // Try to find the second error message
            try {
                errorText2 = driver.getDriver().findElement(By.cssSelector("ndc-fg-input.col-lg-6:nth-child(1) > span:nth-child(2)")).getText();
            } catch (Exception e) {
                System.out.println("Second error message element not found.");
            }

            // Check if the first error text matches the expected error
            if (!errorText1.isEmpty() && errorText1.equals(expectedError)) {
                System.out.println("First error message verification passed.");
                Assert.assertEquals(errorText1, expectedError);
            }
            // Check if the second error text matches the expected error
            else if (!errorText2.isEmpty() && errorText2.equals(expectedError)) {
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



    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.90/master/flight/preferAirline/add");
    }
}
