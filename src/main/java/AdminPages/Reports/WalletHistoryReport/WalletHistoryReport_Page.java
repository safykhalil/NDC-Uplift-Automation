package AdminPages.Reports.WalletHistoryReport;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class WalletHistoryReport_Page {


    public WalletHistoryReport_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    public static final String P_DROPDOWN_INPUT_ID_ID_BRANCH_NAME = "//p-dropdown[.//input[@id=\"id-BranchName\"]]";
    public static final String P_DROPDOWN_INPUT_ID_ID_AGENCY_NAME = "//p-dropdown[.//input[@id=\"id-AgencyName\"]]";
    public static final String BUTTON_CLASS_P_ELEMENT_P_RIPPLE_P_DATEPICKER_TRIGGER_NG_TNS_C_47_3_P_BUTTON_P_COMPONENT_P_BUTTON_ICON_ONLY_NG_STAR_INSERTED = "//button[@class=\"p-element p-ripple p-datepicker-trigger ng-tns-c51-3 p-button p-component p-button-icon-only ng-star-inserted\"]";
    public static final String BUTTON_CLASS_P_ELEMENT_P_RIPPLE_P_DATEPICKER_TRIGGER_NG_TNS_C_47_4_P_BUTTON_P_COMPONENT_P_BUTTON_ICON_ONLY_NG_STAR_INSERTED = "//button[@class=\"p-element p-ripple p-datepicker-trigger ng-tns-c51-4 p-button p-component p-button-icon-only ng-star-inserted\"]";
    public static final String BUTTON_TYPE_SUBMIT = "//button[@type=\"submit\"]";
    public static final String A_HREF_REPORTS = "//a[@href=\"/reports\"]";
    public static final String IMG_SRC_STATIC_IMAGES_ICONS_ARROW_7_PNG_6 = "(//img[@src=\"../static/images/icons/arrow_7.png\"])[6]";

    By Btn_Reports = By.xpath(A_HREF_REPORTS);
    By Btn_WalletReport = By.xpath(IMG_SRC_STATIC_IMAGES_ICONS_ARROW_7_PNG_6);
    By Lst_BranchName = By.xpath(P_DROPDOWN_INPUT_ID_ID_BRANCH_NAME);
    By Lst_AgencyName = By.xpath(P_DROPDOWN_INPUT_ID_ID_AGENCY_NAME);
    By Dpick_FromDate = By.xpath(BUTTON_CLASS_P_ELEMENT_P_RIPPLE_P_DATEPICKER_TRIGGER_NG_TNS_C_47_3_P_BUTTON_P_COMPONENT_P_BUTTON_ICON_ONLY_NG_STAR_INSERTED);
    By Dpick_ToDate = By.xpath(BUTTON_CLASS_P_ELEMENT_P_RIPPLE_P_DATEPICKER_TRIGGER_NG_TNS_C_47_4_P_BUTTON_P_COMPONENT_P_BUTTON_ICON_ONLY_NG_STAR_INSERTED);
    By Btn_SearchButton = By.xpath(BUTTON_TYPE_SUBMIT);


    public void setBranchName(String branch){
        driver.element().click(Lst_BranchName);
        By option1 = By.xpath(String.format("//span[contains(text(), '%s')]",branch ));
        driver.element().click(option1);
    }

    public void setAgencyName(String agency){
        driver.element().click(Lst_AgencyName);
        By option1 = By.xpath(String.format("//span[contains(text(), '%s')]",agency ));
        driver.element().click(option1);
    }

    public void setFromDate(String date){
        driver.element().click(Dpick_FromDate);
        By option1 = By.xpath(String.format("//span[contains(text(), '%s')]",date ));
        driver.element().click(option1);
    }

    public void setToDate(String date){
        driver.element().click(Dpick_ToDate);
        By option1 = By.xpath(String.format("//span[contains(text(), '%s')]",date ));
        driver.element().click(option1);
    }
    public void setReports(){
        driver.element().click(Btn_Reports);
    }
    public void setWalletReport(){
        driver.element().click(Btn_WalletReport);
    }
    public void setSearchButton(){
        driver.element().click(Btn_SearchButton);
    }
}
