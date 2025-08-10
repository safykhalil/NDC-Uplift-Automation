package AdminPages.BookingMidOffice.Booking;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchBookingPage {
    public SearchBookingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By BookingMidOffice = By.xpath("//a[@href=\"/booking\"]");
    By BookingMidOfficeCore = By.xpath("//li[@id=\"MidOfficeBooking\"]");
    By Booking = By.xpath("//li[@id=\"Booking\"]");
    By SelectBranch = By.xpath("//select[@id=\"branchListId\"]");
    By StartingFrom = By.xpath("//input[@id='startingFrom_1']");
    By CAI = By.xpath("//div[@title=\"CAI - Cairo - Egypt - Cairo International Airport\"]");
    By GoingTo = By.xpath("//input[@id=\"goingTo_1\"]");
    By JED = By.xpath("//div[@title=\"JED - Jeddah - Saudi Arabia - King Abdulaziz International\"]");
    By DateOfJourney = By.xpath("//input[@id=\"datePicker_1\"]");
    By SelectDate = By.linkText("31");
    By SearchBtn = By.xpath("(//input[@class=\"searchFlights btn orange-btn\"])[1]");


    public void setBooking(String branch,String start1 ,String going1) throws InterruptedException {
        driver.element().click(BookingMidOffice);
        driver.element().hover(BookingMidOfficeCore);
        driver.element().click(Booking);
        Thread.sleep(5000);
        driver.element().click(SelectBranch);
        driver.element().select(SelectBranch,branch);
        driver.element().type(StartingFrom,start1);
        driver.element().click(CAI);
        driver.element().type(GoingTo,going1);
        driver.element().click(JED);
        driver.element().click(DateOfJourney);
        driver.element().click(SelectDate);
        driver.element().click(SearchBtn);
        Thread.sleep(2000000);


    }
}
