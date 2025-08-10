package AdminPages.Reports.Statement;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static org.openqa.selenium.By.xpath;

public class State {
    public State( SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver;
    By Branch = xpath("//p-multiselect[.//input[@id=\"id-BranchName\"]]");
    By Agency = xpath("//p-multiselect[.//input[@id=\"id-AgencyName\"]]");
    By InvoiceFromDate = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By InvoiceToDate = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By Submit = xpath("//button[@type=\"submit\"]");
    By Reports = xpath("//a[@href=\"/reports\"]");
    By StatementRep = xpath("//*[@id=\"content_wrap\"]/div/div[2]/div[2]/a[9]/div");
   // By CheckBox = xpath("//p-multiselect[.//div[@class=\"p-checkbox-box\"]]");
   // By WriteBRN = xpath("//p-multiselect[.//input[@class=\"p-multiselect-filter p-inputtext p-component\"]]");
    By BranchError = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/span");
    By FromError = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/span");
    By ToError = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/span");
    By ErrorToafterFrom = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/span");
    By BeforeBTN = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By BeforeError = xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-statement/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[4]/span");

    public void searchValidState(String branch,String agency,String From, String To){
        driver.element().click(Reports)
                        .click(StatementRep);
        driver.element().select(Branch,branch)

                .click(Agency);
        driver.element().click(InvoiceFromDate);
        By option = xpath(String.format("//span[text()='%s']", From));
        driver.element().click(option);
        driver.element().click(InvoiceToDate);
        By option1 = xpath(String.format("//span[text()='%s']", To));
        driver.element().click(option1);
                driver.element().click(Submit);
    }
    public void searchinvalidBranch(String From, String To){
        driver.element().click(Reports)
                .click(StatementRep);
        driver.element().click(InvoiceFromDate);
        By option = xpath(String.format("//span[text()='%s']", From));
        driver.element().click(option);
        driver.element().click(InvoiceToDate);
        By option1 = xpath(String.format("//span[text()='%s']", To));
        driver.element().click(option1);
        driver.element().click(Submit);

    }
    public void SearchinvalidFromDate(String branch,String To){
        driver.element().click(Reports)
                .click(StatementRep);
        driver.element().select(Branch,branch)
                .click(Agency);
        driver.element().click(InvoiceToDate);
        By option1 = xpath(String.format("//span[text()='%s']", To));
        driver.element().click(option1);
        driver.element().click(Submit);

    }
    public void SearchinvalidToDate(String branch,String From){
        driver.element().click(Reports)
                .click(StatementRep);
        driver.element().select(Branch,branch)
                .click(Agency);
        driver.element().click(InvoiceFromDate);
        By option = xpath(String.format("//span[text()='%s']", From));
        driver.element().click(option);
        driver.element().click(Submit);

    }
    public void SearchInvalidToafterFrom(String branch,String InvoiceBefore ,String InvoiceAfter){

        driver.element().click(Reports)
                .click(StatementRep);
        driver.element().select(Branch,branch)
                .click(Agency);
        driver.element().click(InvoiceFromDate);
        By option = xpath(String.format("//span[text()='%s']", InvoiceBefore));
        driver.element().click(option);
        driver.element().click(InvoiceToDate);
        By option1 = xpath(String.format("//span[text()='%s']", InvoiceAfter));
        driver.element().click(option1);
        driver.element().click(Submit);
    }
    public void SearchInvalid60Days(String branch,String InvoiceBefore ,String InvoiceAfter){

        driver.element().click(Reports)
                .click(StatementRep);
        driver.element().select(Branch,branch)
                .click(Agency);
        driver.element().click(InvoiceFromDate);
        driver.element().click(BeforeBTN).click(BeforeBTN).click(BeforeBTN);
        By option = xpath(String.format("//span[text()='%s']", InvoiceBefore));
        driver.element().click(option);
        driver.element().click(InvoiceToDate);
        By option1 = xpath(String.format("//span[text()='%s']", InvoiceAfter));
        driver.element().click(option1);
        driver.element().click(Submit);
    }

    }



