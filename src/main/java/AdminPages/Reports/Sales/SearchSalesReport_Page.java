package AdminPages.Reports.Sales;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchSalesReport_Page {
    public SearchSalesReport_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Reports = By.xpath("//a[@href=\"/reports\"]");
    By Btn_Sales = By.xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[3]/div/div[1]");
    By Lst_BranchName = By.xpath("//p-multiselect[.//input[@name=\"Branch Name\"]]");
    By Lst_AgencyName = By.xpath("//p-multiselect[.//input[@id=\"id-AgencyName\"]]");
    By Dpick_Date = By.xpath("//button[@class=\"p-element p-ripple p-datepicker-trigger ng-tns-c49-3 p-button p-component p-button-icon-only ng-star-inserted\"]");
    By Dpick_EndDate = By.xpath("//button[@class=\"p-element p-ripple p-datepicker-trigger ng-tns-c49-4 p-button p-component p-button-icon-only ng-star-inserted\"]");
    By Txt_InvoiceNumber = By.xpath("//input[@placeholder=\"Invoice number\"]");
    By Txt_CustomerName = By.xpath("//input[@id=\"id-CustomerName\"]");
    By Dpick_PaymentDate = By.xpath("//button[@class=\"p-element p-ripple p-datepicker-trigger ng-tns-c49-5 p-button p-component p-button-icon-only ng-star-inserted\"]");
    By Txt_TransactionID = By.xpath("//input[@id=\"id-TransactionID\"]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");

    public void setReports(){
        driver.element().click(Btn_Reports).click(Btn_Sales);
    }

    public void setBranchName(String branch){
        driver.element().select(Lst_BranchName,branch);
        By option4 = By.xpath(String.format("//span[text()='%s']", branch));
        driver.element().click(option4);
    }

    public void setAgencyName(String agency){
        driver.element().click(Lst_AgencyName);
        By option4 = By.xpath(String.format("//span[text()='%s']", agency));
        driver.element().click(option4);
    }

    public void setDate(String date){
        driver.element().click(Dpick_Date);
        By option4 = By.xpath(String.format("//span[text()='%s']", date));
        driver.element().click(option4);
    }

    public void setEndDate(String date){
        driver.element().click(Dpick_EndDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", date));
        driver.element().click(option4);
    }

    public void setInvoiceNumber(String invoiceNumber){
        driver.element().type(Txt_InvoiceNumber,invoiceNumber);
    }

    public void setCustomerName(String customerName){
        driver.element().type(Txt_CustomerName,customerName);
    }

    public void setPaymentDate(String date){
        driver.element().click(Dpick_PaymentDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", date));
        driver.element().click(option4);
    }

    public void setTransactionID(String transactionID){
        driver.element().type(Txt_TransactionID,transactionID);
    }
    public void setSearch()
    {
      driver.element().click(Btn_Search);
    }

}


