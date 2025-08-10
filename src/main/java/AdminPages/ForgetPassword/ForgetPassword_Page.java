package AdminPages.ForgetPassword;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ForgetPassword_Page {
    private final SoftAssert softAssert;
    private final SHAFT.GUI.WebDriver driver;

    public ForgetPassword_Page(SHAFT.GUI.WebDriver driver) {

        this.softAssert = new SoftAssert();

        this.driver = driver;
    }
    public final By Btn_ForgetPasswordButton = By.xpath("//a[@href=\"/auth/forgot\"]");
    public ForgetPassword_Page ClickOnForgetPassword()
    {
        driver.element().click(Btn_ForgetPasswordButton);
        return this;
    }
    public final By Txt_UserName = By.xpath("//input[@type=\"text\"]");
    public ForgetPassword_Page ClickAndTypeUserName(String Write){
        driver.element().type(Txt_UserName,Write);
        return this;
    }
    public final By Btn_ConfirmButton = By.xpath("//button[@type=\"submit\"]");
    public ForgetPassword_Page ClickOnConfirm(){
        driver.element().click(Btn_ConfirmButton);
        return this;
    }
    public ForgetPassword_Page Reload() {
        driver.browser().navigateToURL("http://192.168.1.90/auth/login");
        return this;
    }
    public final By Txt_MessageRequired = By.xpath("//span[@class=\"fg-error\"]");
    public final By Txt_ErrorMessage = By.xpath("//div[@role=\"alert\"]");
    public ForgetPassword_Page OpenGmail()
    {
        driver.getDriver().get("https://mail.google.com/mail/u/0/?tab=rm&ogbl#inbox");
        return this;
    }
    public final By Txt_NewPassword = By.xpath("(//input[@type='password'])[1]");
    public final By Txt_ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
    public final By Txt_ConfirmResetButton = By.xpath("//span[@class='p-button-label']");
    public ForgetPassword_Page ClickOnNewPassword(String Password){
        driver.element().type(Txt_NewPassword, Password);
        return this;
    }
    public ForgetPassword_Page ClickOnConfirmPassword(String Password){
        driver.element().type(Txt_ConfirmPassword, Password);
        return this;
    }
    public ForgetPassword_Page ClickOnConfirmButton(){
        driver.element().click(Txt_ConfirmResetButton);
        return this;
    }
    public ForgetPassword_Page ReloadConfirmPage(String Page)
    {
        driver.browser().navigateToURL(Page);
        return this;
    }
    public final By Txt_Required1 = By.xpath("(//span[@class=\"fg-error\"])[1]");
    public final By Txt_Required2 = By.xpath("(//span[@class=\"fg-error\"])[1]");


}
