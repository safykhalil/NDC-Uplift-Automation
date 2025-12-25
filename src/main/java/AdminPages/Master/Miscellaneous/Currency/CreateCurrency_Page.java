package AdminPages.Master.Miscellaneous.Currency;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CreateCurrency_Page {

    public CreateCurrency_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;
    By Btn_Add = By.xpath("//button[@routerlink=\"add\"]");
    By Txt_CurrencyName = By.xpath("//input[@id=\"id-Currencyname\"]");
    By Txt_CurrencyCode = By.xpath("//input[@id=\"id-Currencycode\"]");
    By Lst_DecimalCount = By.xpath("//p-dropdown[.//input[@id=\"id-Decimalcount\"]]");
    By Txt_Country = By.xpath("//input[@id=\"id-Country\"]");
    By Btn_SendforApproval = By.xpath("//button[@type=\"submit\"]");


    public void CreateCurrencyy(String currencyname , String currencycode , String decimal, String country) throws InterruptedException {
        driver.element().click(Btn_Add);
        driver.element().type(Txt_CurrencyName,currencyname);
        driver.element().type(Txt_CurrencyCode,currencycode);
        driver.element().select(Lst_DecimalCount,decimal);
//        driver.element().click(DecimalCount);
//        By option = By.xpath(String.format("//span[text()='%s']", decimal));
//        driver.element().click(option);
        Thread.sleep(2000);
        driver.element().type(Txt_Country,country);
        Thread.sleep(3000);
        driver.element().select(Txt_Country,country);
        Thread.sleep(3000);


    }
    public String Actual()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));;
        return S;
    }
    public void setSendforApproval(){
        driver.element().click(Btn_SendforApproval);
    }
}
