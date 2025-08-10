package AdminPages.Reports.TotalDueToNDC;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class TotalDueToNDC_TC extends TestBase_TC {

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void login() {
        new LogIn_Page(driver).ClickAdmin();
        new LogIn_Page(driver).ClickOnLoginButton();
    }

    @Test(groups = "group1")
    public void validSearchForTotalDue() throws FileNotFoundException {
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectAgency()
                .selectValidDate()
                .clickSearchInGrid()
                .verifyThatResultsIsDisplayed();
    }

    @Test(groups = "group1")
    public void validSearchForTotalDueWithMandatoryFieldsOnly10() {
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectValidDate()
                .clickSearchInGrid()
                .verifyThatResultsIsDisplayed();
    }

    @Test(groups = "group1")
    public void searchForTotalDueWithNoOutputAndSelectSameDayFromDate() {
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectSameDateWithNoOutput()
                .clickSearchInGrid()
                .verifyThatNoOutputMessageIsDisplayedWhenThereIsNoOutput();
    }

    @Test(groups = "group1")
    public void validateThatPaginationWorksCorrectly() throws InterruptedException {
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectAgency()
                .selectValidDate()
                .clickSearchInGrid()
                .clickOnNextButton()
                .verifyThatThePaginationIsWorkingCorrectly();
    }

    @Test(groups = "group1")
    public void validateThatUserCanSearchWithAllField() {
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectAgency()
                .selectValidDate()
                .sendInvoiceNumber()
                .sendCustomerName()
                .sendBookingRefernce()
                .clickSearchInGrid()
                .verifyThatResultsIsDisplayed();
    }
    @Test
    public void validateThatUserCanExportTheFile(){
        new TotalDueToNDC_Page(driver)
                .selectTotalDueReport()
                .selectBranch()
                .selectAgency()
                .selectValidDate()
                .clickSearchInGrid()
                .VerifyThatTheExportButtonIsClickable();
    }
    @AfterMethod
    public void navigateBackToURL() {
//        driver.quit();
        driver.browser().navigateToURL("http://192.168.1.33");
    }
    /*@AfterMethod
    public void quit() {
        driver.quit();
    }*/
}
