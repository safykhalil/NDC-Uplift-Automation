package AdminPages.Settings.AdminSettings;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class AdminSettings_Page {
    //constant
    private final SoftAssert softAssert;

    public AdminSettings_Page(SHAFT.GUI.WebDriver driver) {

        this.softAssert = new SoftAssert();

        this.driver = driver;
    }
    static SHAFT.GUI.WebDriver driver;
    public final By Username = By.id("id-Username");
    public final By Password = By.id("id-Password");
    public final By LogINButton = By.xpath("// button[@loadingicon=\"pi pi-spin pi-spinner\"]");
    private final By Master = By.xpath("//a[@href=\"/master\"]");
    private final By Supplier = By.xpath("(//a[@class=\"ng-star-inserted\"])[2]");
    private final By FlightSearchLimitationButton = By.xpath("(//a[@href=\"/master/supplier/flight-search-limitation\"])[1]");
    By Settings = By.xpath("//a[@href=\"/settings\"]");
    By AdminSettings = By.xpath("//a[@href=\"/settings/admin-settings\"]");


    public static By LogInNavigateToUrl() {
        driver.browser().maximizeWindow();
        String url = "http://192.168.1.70/auth/login";
        driver.browser().navigateToURL(url);
        driver.browser().maximizeWindow();  // Initialize the driver here

        return null;
    }
    public final By EditButton = By.xpath("(//i[@class=\"pi pi-pencil\"])[1]");

    public final By LimitSupplier = By.xpath("//p-dropdown[@class=\"p-element p-inputwrapper fg-input " +
            "ng-untouched ng-pristine ng-valid ng-star-inserted p-inputwrapper-filled\"]");
    public final By ApproveButton = By.xpath("//button[@type=\"submit\"]");
    public final By GetLimit = By.xpath("(//div//table//tbody//tr//td)[3]");
    public AdminSettings_Page NavigateToFlightLimitation(String Check)
    {
        driver.element().click(Master);
        driver.element().click(Supplier);
        driver.element().click(FlightSearchLimitationButton);
        driver.element().click(EditButton);
        driver.element().click(LimitSupplier);
        final By SelectIndex = By.xpath("(//p-dropdown//div//ul//p-dropdownitem[@class=\"p-element ng-star-inserted\"])["+Check+"]");
        driver.element().click(SelectIndex);
        driver.element().click(ApproveButton);
        return this;

    }
    public final By ClickOnSupplier = By.xpath("//span[@class=\"p-dropdown-label p-inputtext p-placeholder ng-star-inserted\"]");
    public AdminSettings_Page ClickOnSupplierAndChooseIndex(String Check){


        driver.element().click(ClickOnSupplier);
        final By SelectIndex = By.xpath("//p-dropdown//p-overlay//div//div//ul//p-dropdownitem["+ Check+"]");
        driver.element().click(SelectIndex);
        return this;
    }
    public AdminSettings_Page NavigateToAdminSetting()
    {
        driver.element().click(Settings);
        driver.element().click(AdminSettings);

        return this;

    }

    public AdminSettings_Page EditNewFlightNum(String S)
    {
        driver.element().click(EditFlight);
        driver.element().clear(EditBox);
        driver.element().type(EditBox, S);
        driver.element().click(Save);

        return this;

    }
    By BookingMidOffice = By.xpath("//a[@href=\"/booking\"]");
    By DropDownBookingMidOffice = By.xpath("(//a[@href=\"#\"])[2]");
    By Booking = By.xpath("//a[@href=\"/odeysysadmin/branchSelection/\"]");
    By BranchList = By.xpath("//select[@id=\"branchListId\"]");
    By Up_Selling = By.xpath("//input[@id=\"onewayUpselling\"]");
    public AdminSettings_Page NavigateToBooking()
    {
        driver.element().click(BookingMidOffice);
        driver.element().click(DropDownBookingMidOffice);
        driver.element().click(Booking);
        driver.element().click(BranchList);
        final By SelectIndex = By.xpath("(//option[@data-ng-repeat=\"c in branchList\"])[48]");
        driver.element().click(SelectIndex);
        driver.element().click(Up_Selling);

        return this;

    }

    public AdminSettings_Page EditNewUpsellingNum(String S)
    {
        driver.element().click(EditUpSelling);
        driver.element().clear(EditBox);
        driver.element().type(EditBox, S);
        driver.element().click(Save);

        return this;

    }
    public AdminSettings_Page EditNewRefundNum(String S)
    {
        driver.element().click(Pages);
        driver.element().click(EditRefund);
        driver.element().clear(EditBox);
        driver.element().type(EditBox, S);
        driver.element().click(Save);

        return this;

    }


    By EditFlight = By.xpath("(//i[@class=\"pi pi-pencil\"])[10]");
    By EditUpSelling = By.xpath("(//i[@class=\"pi pi-pencil\"])[10]");
    By Pages = By.xpath("//button[@class=\"page-no ng-star-inserted\"]");
    By EditRefund = By.xpath("(//i[@class=\"pi pi-pencil\"])[3]");
    By EditBox = By.xpath("//input[@id=\"id-Value\"]");
    By Save = By.xpath("//button[@type=\"submit\"]");
    protected AdminSettings_Page adminsetting1;

    private final By AngelDownForLogOut=By.xpath("//i[@style=\"font-size: 1rem;\"]");
    private final By LogOutButton = By.xpath("//span[@class=\"p-menuitem-icon pi pi-sign-out ng-star-inserted\"]");

    public AdminSettings_Page LoginAsAdmin() {

        driver.element().click(AngelDownForLogOut);
        driver.element().click(LogOutButton);

        driver.element().type(Username, "e.saady");
        driver.element().type(Password, "qqE6)Cxp6>B8");
        driver.element().click(LogINButton);
        adminsetting1 = new AdminSettings_Page(driver);

        return this;
    }
    private final By AngelDownForLogOut1=By.xpath("//img[@src=\"../static/img/dropdown_arrow_icon.png\"]");
    private final By LogOutButton1 = By.xpath("(//a[@href=\"/odeysysadmin/logout\"])[1]");

    public AdminSettings_Page LoginAsSuperAdmin() {

        driver.element().click(AngelDownForLogOut1);
        driver.element().click(LogOutButton1);

        driver.element().type(Username, "odeysysadmin");
        driver.element().type(Password, "qqE6)Cxp6>B8");
        driver.element().click(LogINButton);
        adminsetting1 = new AdminSettings_Page(driver);

        return this;
    }

}