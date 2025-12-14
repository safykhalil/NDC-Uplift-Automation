package AdminPages.Admin;

import AdminPages.Admin.Agency.Agency.AgencySection;
import AdminPages.Admin.Company.CompanySection;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AdminMenu {
    public AdminMenu(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;
    By Btn_Admin = By.xpath("//a[@id=\"p-tabpanel-1-label\"]");
    By Btn_Company = By.xpath("//span[normalize-space()='Company']");
    By Btn_Branch = By.xpath("(//a[@class=\"ng-star-inserted\"])[2]");
    By Btn_Agency = By.xpath("(//a[@class=\"ng-star-inserted\"])[3]");
    By Btn_Staff = By.xpath("(//a[@class=\"ng-star-inserted\"])[4]");
    By Btn_SubAgency = By.xpath("(//i[@class=\"pi pi-briefcase\"])[2]");
    By Btn_SearchLoginDetails = By.xpath("//a[@href=\"/admin/login-details\"]");
    By Btn_RegistrationRequests = By.xpath("//a[@href=\"/admin/registration-requests\"]");
    By Btn_OperatingCountry = By.xpath("//a[@href=\"/admin/operating-country\"]");
    By Btn_Role = By.xpath("(//li[@class=\"child ng-star-inserted\"])[2]");
    By Btn_Department = By.xpath("(//li[@class=\"child ng-star-inserted\"])[3]");
    By Btn_TopUp = By.xpath("(//li[@class=\"child ng-star-inserted\"])[4]");

    public void openSubAdmin(){
        driver.element().click(Btn_Admin);

    }
    public void openCompanySection(CompanySection section) {
        switch (section) {
            case COMPANY:
                driver.element().click(Btn_Company);
                break;
            case OPERATING_COUNTRY:
                driver.element().click(Btn_OperatingCountry);
                break;
            case ROLE:
                driver.element().click(Btn_Role);
                break;
            case DEPARTMENT:
                driver.element().click(Btn_Department);
                break;
            case TOPUP:
                driver.element().click(Btn_TopUp);
                break;
            default:
                throw new IllegalArgumentException("Invalid section: " + section);
        }
    }
    public void openBranch(){
        driver.element().click(Btn_Branch);
    }
    public void openSection(AgencySection section) {
        SHAFT.Report.log("Opening Admin section: " + section);

        switch (section) {
            case AGENCY:
                driver.element().click(Btn_Agency);
                driver.element().click(Btn_SubAgency);
                break;
            case SEARCH_LOGIN_DETAILS:
                driver.element().click(Btn_SearchLoginDetails);
                break;
            case REGISTRATION_REQUESTS:
                driver.element().click(Btn_RegistrationRequests);
                break;
            default:
                throw new IllegalArgumentException("Invalid Admin section: " + section);
        }
    }
    public void openStaff(){
        driver.element().click(Btn_Staff);
    }


}
