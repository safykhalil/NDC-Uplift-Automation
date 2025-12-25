package AdminPages.Reports.Booking;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import AdminPages.Reports.Reports_Common;
import com.shaft.validation.Validations;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.openqa.selenium.interactions.Actions;
import utilities.JsonDataUtil;

public class BookingReport_TC extends TestBase {

    String ExpectedResult;
    BookingReport bookingReport;
    private LogIn_Page logIn;

    @BeforeTest
    public void SignIn() {
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("E.saady");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();
        bookingReport = new BookingReport(driver);

    }

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }


    @Test(dataProvider = "JsonProvider")
        public void BookingReport(Map <String, String> Search) throws InterruptedException {
            Thread.sleep(2000);
        new Reports_Common(driver).clickReports().clickBooking();
            Thread.sleep(2000);
            bookingReport = new BookingReport(driver);
            bookingReport.ClickSearch();
            Validations.verifyThat().element(bookingReport.RequiredForBranch).isVisible();
            Validations.verifyThat().element(bookingReport.RequiredForFromBookingDate).isVisible();
            Validations.verifyThat().element(bookingReport.RequiredForToBookingDate).isVisible();


        }
        @Test(dataProvider = "JsonProvider")
        public void ValidSearchBooking_TC(Map <String, String> Search) throws InterruptedException {

            new Reports_Common(driver).clickReports().clickBooking();
            bookingReport = new BookingReport(driver);
            Thread.sleep(2000);
            String BranchName = Search.get("BranchName");
            String AgencyName = Search.get("AgencyName");
            String Email = Search.get("Email");
            String FromBookingDate = Search.get("FromBookingDate");
            String ToBookingDate = Search.get("ToBookingDate");
            String ClientName = Search.get("ClientName");
            String PhoneNumber = Search.get("PhoneNumber");
            String TripsStartDate = Search.get("TripsStartDate");
            String TripsReturnDate = Search.get("TripsReturnDate");
            String InvoiceNumber = Search.get("InvoiceNumber");
            String BookingReference = Search.get("BookingReference");
            String AirlinePNR = Search.get("AirlinePNR");
            String TicketNumber = Search.get("TicketNumber");
            String TicketStatus = Search.get("TicketStatus");
            Thread.sleep(2000);
            bookingReport.SelectBranch(BranchName);
            bookingReport.SelectAgency(AgencyName);
            bookingReport.FillMail(Email);
            bookingReport.FromDate(FromBookingDate);
            bookingReport.ToDate(ToBookingDate);
            bookingReport.FillClientName(ClientName);
            Actions a=new Actions(driver.getDriver());
            WebElement an=driver.getDriver().findElement( bookingReport.Locator);
            a.moveToElement(an).click().build().perform();
            bookingReport.FillPhoneNumber(PhoneNumber);
            bookingReport.ClickSearch();
            bookingReport.performAssertions();
            Validations.verifyThat().element(bookingReport.DataReturn).isVisible();
            Thread.sleep(2000);

        }


    }



