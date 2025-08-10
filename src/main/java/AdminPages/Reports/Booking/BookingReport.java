package AdminPages.Reports.Booking;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class BookingReport {
    private final SoftAssert softAssert;
    public String columnText;
    public BookingReport(SHAFT.GUI.WebDriver driver)
    {

        this.softAssert = new SoftAssert();

        this.driver = driver;

    }
    protected BookingReport bookingreport;

    SHAFT.GUI.WebDriver driver;
    public final By Username = By.id("id-Username");
    public final By Password = By.id("id-Password");
    public final By LogINButton = By.xpath("// button[@loadingicon=\"pi pi-spin pi-spinner\"]");
    public By Reports=By.xpath("//a[@href=\"/reports\"]");
    public By BookingReport=By.xpath("(//div[@class=\"col-md-4 col\"])[5]");
    public By BranchName=By.xpath("(//div[@class=\"p-multiselect-trigger\"])[1]");
    public By AllBranches=By.xpath("//div[@class=\"p-checkbox p-component ng-star-inserted\"]");
    public By AgencyName=By.xpath("(//div[@class=\"p-multiselect-trigger\"])[2]");
    public By AllAgency=By.xpath("(//div[@class=\"p-checkbox-box\"])[1]");
    public By Email=By.xpath("//input[@id=\"id-Email\"]");
    public By FromBookingDate=By.xpath("//input[@id=\"id-FromBookingDate\"]");
    public By ToBookingDate=By.xpath("//input[@id=\"id-ToBookingDate\"]");
    public By ClientName=By.xpath("//input[@id=\"id-ClientName\"]");
    public By PhoneNumber=By.xpath("//input[@id=\"Phone Number\"]");
    public By ShowAdvanceSearch=By.xpath("//div[@class=\"toggle-text col-12\"]");
    public By TripsStartDate=By.xpath("//input[@id=\"id-Trip'sstartdate\"]");
    public By TripsReturnDate=By.xpath("//input[@id=\"id-Trip'sReturnDate\"]");
    public By InvoiceNumber=By.xpath("//input[@id=\"id-InvoiceNo\"]");
    public By BookingReference=By.xpath("//input[@id=\"id-Bookingreference\"]");
    public By AirlinePNR=By.xpath("//input[@id=\"id-AirlinePNR\"]");
    public By TicketNumber=By.xpath("//input[@id=\"id-Ticketnumber\"]");
    public By TicketStatus=By.xpath("//span[@class=\"p-dropdown-trigger-icon pi pi-chevron-down\"]");
    public By Search=By.xpath("//button[@type=\"submit\"]");
    public By ExportToExcel=By.xpath("//i[@class=\"pi pi-cloud-download btn-icon\"]");
    public By DataReturn=By.xpath("(//tr[@class=\"ng-star-inserted\"])[2]");
    public By RequiredForBranch=By.xpath("(//span[@class=\"fg-error\"])[1]");
    public By RequiredForFromBookingDate=By.xpath("(//span[@class=\"fg-error\"])[4]");
    public By RequiredForToBookingDate=By.xpath("(//span[@class=\"fg-error\"])[5]");
    By Back = By.xpath("//button[@class=\"p-ripple p-element p-datepicker-prev p-link ng-tns-c48-3 ng-star-inserted\"]");
    By Back1 = By.xpath("//button[@class=\"p-ripple p-element p-datepicker-prev p-link ng-tns-c48-4 ng-star-inserted\"]");
    public By Locator = By.xpath("//div[@class=\"w-f h-3rem\"]");

    public BookingReport NavigateToBookingReport() {
        driver.element().click(Reports);
        driver.element().click(BookingReport);
        return this;
    }
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.70/reports/reports/booking?reporthMap=false&isCoreSystem=true");
    }
    private final By AngelDownForLogOut=By.xpath("(//i[@class=\"pi pi-angle-down\"])[2]");
    private final By LogOutButton = By.xpath("//span[@class=\"p-menuitem-icon pi pi-sign-out ng-star-inserted\"]");

    public BookingReport LoginAsAdmin() {

        driver.element().click(AngelDownForLogOut);
        driver.element().click(LogOutButton);




        driver.element().type(Username, "e.saady");
        driver.element().type(Password, "qqE6)Cxp6>B8");
        driver.element().click(LogINButton);
        bookingreport = new BookingReport(driver);

        return this;
    }


    public BookingReport LoginAsSuperAdmin() {



        driver.element().type(Username, "odeysysadmin");
        driver.element().type(Password, "qqE6)Cxp6>B8");
        driver.element().click(LogINButton);
        bookingreport = new BookingReport(driver);

        return this;
    }

    public BookingReport SelectBranch(String  branch) {
        driver.element().click(BranchName);
        By option = xpath(String.format("//span[text()='%s']", branch));
        driver.element().click(option);
        return this;
    }
    public BookingReport SelectAllBranch() {
        driver.element().click(BranchName);
        driver.element().click(AllBranches);
        return this;
    }
    public BookingReport SelectAgency(String Agency) {
        driver.element().click(AgencyName);
        By option = xpath(String.format("//span[text()='%s']", Agency));
        driver.element().click(option);
        return this;
    }
    public BookingReport SelectAllAgency( ) {
        driver.element().click(AgencyName);
        driver.element().click(AllAgency);
        return this;
    }
    public BookingReport FillMail(String Mail) {
        driver.element().type(Email,Mail);
        return this;
    }
    public BookingReport FromDate(String Date) {
        driver.element().type(FromBookingDate,Date);
        return this;
    }
    public BookingReport ToDate(String Date ) {
        driver.element().type(ToBookingDate,Date);
        return this;
    }
    public BookingReport FillClientName(String S) {
        driver.element().type(ClientName,S);
        return this;
    }
    public BookingReport FillPhoneNumber(String S) {
        driver.element().type(PhoneNumber,S);
        return this;
    }
    public BookingReport ShowAdvance()
    {
        driver.element().click(ShowAdvanceSearch);
        return this;
    }
    public BookingReport TripsStartDate(String Date) {
        driver.element().type(TripsStartDate,Date);
        return this;
    }
    public BookingReport TripsReturnDate(String Date) {
        driver.element().type(TripsReturnDate,Date);
        return this;
    }
    public BookingReport FillInvoiceNumber(String S) {
        driver.element().type(InvoiceNumber,S);
        return this;
    }
    public BookingReport FillBookingReference(String S) {
        driver.element().type(BookingReference,S);
        return this;
    }
    public BookingReport FillAirlinePNR(String S) {
        driver.element().type(AirlinePNR,S);
        return this;
    }
    public BookingReport FillTicketNumber(String S) {
        driver.element().type(TicketNumber,S);
        return this;
    }
    public BookingReport ChooseBookingStatus(String Check){


        driver.element().click(TicketStatus);
        final By SelectIndex = By.xpath("//p-dropdown//p-overlay//div//div//ul//p-dropdownitem["+ Check+"]");
        driver.element().click(SelectIndex);
        return this;
    }
    public BookingReport ClickSearch()
    {
        driver.element().click(Search);
        return this;
    }
    public BookingReport ClickExportExcel()
    {
        driver.element().click(ExportToExcel);
        return this;
    }

public BookingReport NavigateAndGetTempMail() throws InterruptedException {
    driver.browser().navigateToURL("https://temp-mail.org/en/change");
    Thread.sleep(5000);
    return this;
}
public String Mail(){
        String s= ElementActions.getInstance().getText(By.xpath("//input[@id=\"mail\"]"));
        return s;
}

    public void performAssertions () {
        String expectedHeaderStatus = "Branch Name";
        String[] allowedStatusValues = {"Test"};


        try {
            // Wait for the table to be present and the text to be loaded
            Thread.sleep(1000);

            // Find and verify the table headers
            String actualHeaderStatus = driver.element().getText(By.xpath("//table/thead/tr/th[1]"));
            Assert.assertEquals(actualHeaderStatus, expectedHeaderStatus, "The 'Status' table header does not match the expected value.");


            // Get the number of rows in the table body
            List<WebElement> rows = driver.getDriver().findElements(By.xpath("//table/tbody/tr"));
            int numberOfRows = rows.size();

            // Iterate through each row and verify the data in the relevant columns
            for (int i = 1; i <= numberOfRows; i++) {
                String actualDataStatus = driver.element().getText(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));

                Assert.assertTrue(isValueInArray(actualDataStatus, allowedStatusValues),
                        "Row " + i + ": The 'Status' column data (" + actualDataStatus + ") does not match any of the allowed values.");


            }

        } catch (Exception e) {
            // Print the stack trace to help with debugging if an exception occurs
            e.printStackTrace();
            Assert.fail("An exception occurred while trying to verify the table header or data: " + e.getMessage());
        }
    }


    private boolean isValueInArray (String value, String[]array){
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
}