package AdminPages.Admin.Company.Department;
import AdminPages.Admin.AdminMenu;
import AdminPages.Admin.Company.Department_Page;

import AdminPages.Admin.Staff_Page;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


public class SearchDepartment_TC extends TestBase_TC {
    
    public LogIn_Page logIn;
    private Department_Page addDepartment;
    private Staff_Page staff;

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

    @Test(priority = 1,dataProvider = "JsonProvider")
    public void CreateDepartment(Map<String, String> department) throws InterruptedException {
        addDepartment = new Department_Page(driver);
        staff = new Staff_Page(driver);
//        staff.Clickonadmin();
        String DepartmentName = department.get("DepartmentName");
        String AssignedQueue = department.get("AssignedQueue");
        addDepartment.setCompany();
        addDepartment.ClickSideMDepartment();
        addDepartment.AddDepartment(DepartmentName, AssignedQueue);
        addDepartment.setSendApprroval();
   }
    @Test(priority = 2)
    public void searchWithValidData() throws InterruptedException {

        addDepartment = new Department_Page(driver);
//        addDepartment.setCompany();
//        addDepartment.ClickSideMDepartment();
        addDepartment.searchDepartment("NDCCCCCCCCCc");
        addDepartment.BothStatus();
        addDepartment.Search();
        Actions actions = new Actions(driver.getDriver());
        String expectedHeader = "Department";
        String expectedData = "NDCCCCCCCCCc";


        ///////////////////////Check TableData///////////////////////
    try {
        // Wait for the table to be present and the text to be loaded
        Thread.sleep(3000);

        // Find and verify the table header
        String actualHeader = driver.getDriver().findElement(By.xpath("//table/thead/tr/th[1]")).getText();
        Assert.assertEquals(actualHeader, expectedHeader, "The table header does not match the expected value.");

        // Find and verify the data in the first row under the "Operating Country" header
        String actualData = driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(actualData, expectedData, "The table data does not match the expected value.");
    } catch (Exception e) {
        // Print the stack trace to help with debugging if an exception occurs
        e.printStackTrace();
        Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
    }
    }

    @Test(priority = 3)
    public void SearchWithInvalidData() throws InterruptedException {

        addDepartment = new Department_Page(driver);
//        addDepartment.setCompany();
//        addDepartment.ClickSideMDepartment();
        addDepartment.searchDepartment("trtr");
        addDepartment.ActiveStatus();
        addDepartment.Search();
        Actions actions = new Actions(driver.getDriver());
        String expectedHeader = "Department";
        String expectedData = "AREA MANAGER";
        String expectedError = "No data has been found!";

        ///////////////////////Check TableData///////////////////////
    try {
        // Wait for the table to be present and the text to be loaded
        Thread.sleep(3000);

        // Find and verify the table header
        String actualHeader = driver.getDriver().findElement(By.xpath("//table/thead/tr/th[1]")).getText();
        Assert.assertEquals(actualHeader, expectedHeader, "The table header does not match the expected value.");

        // Find and verify the data in the first row under the "Operating Country" header
        String actualData = driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        Assert.assertEquals(actualData, expectedData, "The table data does not match the expected value.");
    } catch (Exception e) {
        try {
            String actualerror = driver.getDriver().findElement(By.xpath("//td[@class=\"message\"]")).getText();
            Assert.assertEquals(actualerror, expectedError, "The table header does not match the expected value.");
        } catch (Exception ex) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }

    }

    }
    @Test(priority = 4)
    public void SearchWithCheckData() throws InterruptedException {

        addDepartment = new Department_Page(driver);
//        addDepartment.setCompany();
//        addDepartment.ClickSideMDepartment();
        addDepartment.BothStatus();
        addDepartment.Search();
        Actions actions = new Actions(driver.getDriver());
        try {
            // Start an infinite loop to handle pagination
            while (true) {
                // Wait for the table data to load on the current page
                Thread.sleep(2000); // Give the page time to load

                // Verify that the table contains data
                List<WebElement> tableRows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
                actions.sendKeys(Keys.PAGE_DOWN).perform();
                // Check if the table has data
                if (tableRows.size() > 0) {
                    // Process table data here if needed
                    System.out.println("Table contains data on the current page.");
                } else {
                    // Log a warning if the table has no data
                    System.out.println("Warning: The table on the current page does not contain any data.");
                }

                //actions.sendKeys(Keys.PAGE_DOWN).perform();

                // Find the "Next" button
                WebElement nextButton = driver.getDriver().findElement(By.xpath("//button[@class='next']"));

                // Check if the "Next" button is visible and enabled
                boolean isNextButtonEnabled = nextButton.isDisplayed() && nextButton.isEnabled();

                if (isNextButtonEnabled) {

                    // Click the "Next" button to go to the next page
                    nextButton.click();

                    // Wait for the page to load
                    Thread.sleep(2000);  // Adjust this delay as necessary
                } else {
                    // If the "Next" button is not visible or enabled, we are on the last page
                    System.out.println("Reached the last page or the 'Next' button is not available.");
                    break; // Exit the loop
                }
            }
        } catch (NoSuchElementException e) {
            // Handle cases where the "Next" button is not found
            System.out.println("The 'Next' button was not found. Exiting.");
            e.printStackTrace();
            Assert.fail("The 'Next' button was not found: " + e.getMessage());
        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to paginate through the table: " + e.getMessage());
        }
    }
    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.94/admin/operating-country");
    }
   }


//    @Test
//    public void SearchWithvalidDataInActive() throws InterruptedException {
//        searchObj = new SearchDepartment(driver);
//        addDepartment = new CreateDepartment(driver);
//        addDepartment.setCompany();
//        addDepartment.setDepartment();
//        searchObj.searchDepartment("BRANCH MANAGER");
//        searchObj.InactiveStatus();
//        searchObj.SearchBookingTC();
//        Actions actions = new Actions(driver.getDriver());
//        String expectedHeader = "Department";
//        String expectedData = "BRANCH MANAGER";
//        //validate that an error message should be displayed\
//
//
//        ///////////////////////Check TableData///////////////////////
//    try {
//        // Wait for the table to be present and the text to be loaded
//        Thread.sleep(3000);
//
//        // Find and verify the table header
//        String actualHeader = driver.getDriver().findElement(By.xpath("//table/thead/tr/th[1]")).getText();
//        Assert.assertEquals(actualHeader, expectedHeader, "The table header does not match the expected value.");
//
//        // Find and verify the data in the first row under the "Operating Country" header
//        String actualData = driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
//        Assert.assertEquals(actualData, expectedData, "The table data does not match the expected value.");
//    } catch (Exception e) {
//        // Print the stack trace to help with debugging if an exception occurs
//        e.printStackTrace();
//        Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
//    }
//    }




//
//    @Test
//    public void SearchWithActiveStatus() throws InterruptedException {
//        searchObj = new SearchDepartment(driver);
//        addDepartment.setCompany();
//        addDepartment.setDepartment();
//        searchObj.clickOnCompany();
//        searchObj.OpenDepartment();
//        searchObj.ActiveStatus();
//        searchObj.SearchBookingTC();
//        //validate that Status column all record should be active
//        //maybe use for loop
//    }
//
//    @Test
//    public void SearchWithInactiveStatus() throws InterruptedException {
//        searchObj = new SearchDepartment(driver);
//        addDepartment.setCompany();
//        addDepartment.setDepartment();
//        searchObj.clickOnCompany();
//        searchObj.OpenDepartment();
//        searchObj.InactiveStatus();
//        searchObj.SearchBookingTC();
//        //validate that Status column all record should be inactive
//        //maybe use for loop
//    }
//
//    @Test
//    public void SearchWithBothStatus() throws InterruptedException {
//        searchObj = new SearchDepartment(driver);
//        addDepartment.setCompany();
//        addDepartment.setDepartment();
//        searchObj.clickOnCompany();
//        searchObj.OpenDepartment();
//        searchObj.BothStatus();
//        searchObj.SearchBookingTC();
//
//    }

