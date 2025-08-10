package AdminPages.Reports.Quotation;


import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QuotationTCs extends TestBase {
   private SHAFT.TestData.JSON testData;

   @BeforeTest
    public void login(){
       testData = new SHAFT.TestData.JSON("QuotationReport.json");
       new LogIn_Page(driver).ClickAdmin();
       new LogIn_Page(driver).ClickOnLoginButton();
   }


   @Test
    public void VerifyThatUserCanSearchWithMandatoryFieldOnly() throws InterruptedException {
       new Quotation_Page(driver)
               .SelectReports()
               .SelectQuotationReport()
               .SelectBranch()
               .SelectDate_CreationDate()
               .SelectDuration_DateRange()
               .ClickSearch()
               .VerifyThatTheExportButtonIsClickable();
   }

   @Test
   public void VerifyThatUserCanSearchWithBranchAndAgency() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatTheExportButtonIsClickable();
   }

   @Test
   public void VerifyThatUserCanSearchWithBranchAndAgencyWithSpecificDate() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .SelectFromDate(testData.getTestData("validData.FromDate"))
              .SelectToDate_(testData.getTestData(("validData.ToDate")))
              .ClickSearch()
              .VerifyThatTheExportButtonIsClickable();
   }

   @Test
   public void VerifyThatUserCanSearchWithBranchAndAgencyWithTravelDate() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SelectDate_TravelDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatTheExportButtonIsClickable();
   }

   @Test
   public void VerifyThatUserCanSearchWithName() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SendName(testData.getTestData("validData.Name"))
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatClientNameDisplaysCorrectly();
   }

   @Test
   public void VerifyThatUserCanSearchWithEmailID() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SendEmail(testData.getTestData("validData.EmailID"))
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatEmailIDDisplaysCorrectly();
   }

   @Test
   public void VerifyThatUserCanSearchWithQuotesNo() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SendQuoteNo(testData.getTestData("validData.SendQuotesNo"))
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatQuotesNoDisplaysCorrectly();
   }

   @Test
   public void VerifyThatUserCanPaginateTheResult() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .PaginateTheResults()
              .VerifyThatUserCanPaginateResultsCorrectly();
   }

   @Test
   public void VerifyThatUserCanSearchWithTodayAndNoDataMessageShowsCorrectly() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SelectDate_CreationDate()
              .SelectDuration_Today()
              .ClickSearch()
              .VerifyThatNoFoundDataShowsCorrectly();
   }

   @Test
   public void VerifyThatUserCanSearchWithAllFields() throws InterruptedException {
      new Quotation_Page(driver)
              .SelectReports()
              .SelectQuotationReport()
              .SelectBranch()
              .SelectAgency()
              .SendName(testData.getTestData("validData.Name"))
              .SendEmail(testData.getTestData("validData.EmailID"))
              .SendQuoteNo(testData.getTestData("validData.SendQuotesNo"))
              .SelectQuoteStatus()
              .SelectDate_CreationDate()
              .SelectDuration_DateRange()
              .ClickSearch()
              .VerifyThatClientNameDisplaysCorrectly();
   }

   @AfterMethod
   public void navigateBackToURL() {
      // Optionally close the browser
      // driver.quit();
      driver.browser().navigateToURL("http://192.168.1.90");
   }

}
