package AdminPages.BookingMidOffice.Booking;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Map;

public class SearchBooking_TC extends TestBase_TC {

   private SearchBookingPage searchBooking;
   private LogIn_Page logIn;

   @BeforeTest
   public void sign(){
      logIn = new LogIn_Page(driver);
      logIn.EnterUserName("E.saady");
      logIn.EnterPassword("qqE6)Cxp6>B8");
      logIn.ClickOnLoginButton();

   }

   @Test(dataProvider = "Booking")
   public void setSearchBooking(Map<String,String> Book) throws InterruptedException {
      searchBooking = new SearchBookingPage(driver);
      String SelectBranch = Book.get("SelectBranch");
      String StartingFrom = Book.get("StartingFrom");
      String GoingTo = Book.get("GoingTo");
      searchBooking.setBooking(SelectBranch,StartingFrom,GoingTo);

   }
}
