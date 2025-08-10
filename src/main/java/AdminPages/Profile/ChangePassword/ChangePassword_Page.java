package AdminPages.Profile.ChangePassword;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


public class ChangePassword_Page {
    public   boolean foundError ;

    public ChangePassword_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver ;
//    }

    By Btn_changePassword = By.linkText("Change Password");
    By Txt_yourOldPassword = By.xpath("//input[@id=\"id-Enteryourpassword\"]");
    By Txt_enterNewPasword = By.xpath("//*[@id=\"id-Enteryournewpassword\"]");
    By Txt_enterConfirmPassword = By.xpath("//*[@id=\"id-ConfirmPassword\"]");
    By Btn_confirm = By.xpath(" //span[@class=\"p-button-label\"]");
    By Btn_eyeForOldPassword =By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/ndc-fg-password-input/span/i");
    By Btn_eyeFornewPassword = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/ndc-fg-password-input/span/i");
    By Btn_eyeForConfirmNewPassword = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/ndc-fg-password-input/span/i");
    By Lst_Sign = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/tilde-theme-header/div/div/div[2]/div/div[2]/div/i");
    // By ValidEmptyField=By.xpath("//span[@class=\"fg-error\"]");
    By ValidEmptyField=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/span");
    By ValidMisMatchField=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/span");
    By ValidMaxField=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/span");
    By ValidMinField=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-change-password-page/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/span");
    public  By InValidOldPassWord=By.xpath("//div[@aria-label=\"Password change was not successful: Old password is wrong, Please enter correct password\"]");
    public  By  ValidationInOldPass=By.xpath("//span[contains(text(),'New password cannot be same as old Password.')]");

    public void ChangePasswordButton()
    {
        driver.element().click(Btn_changePassword);
    }
    public Void SelectOldPassword(String User)
    {
        driver.element().type(Txt_yourOldPassword,User);
        return null;

    }
    public String GetOldPassword ()
    {
        driver.element().click(Btn_eyeForOldPassword);
        String oldPassword = driver.element().getText(Txt_yourOldPassword);
        return oldPassword;
    }
    public String changeOldPassword(String oldPassword) {

        driver.element().clear(Txt_yourOldPassword);
        driver.element().type(Txt_yourOldPassword, oldPassword);
        return oldPassword;
    }

    public void SetNewPassword(String x)
    {
        driver.element().type(Txt_enterNewPasword,x);
    }

    public String GetNewPassword()
    {
        driver.element().click(Btn_eyeFornewPassword);
        String Newpassword = driver.element().getText(Txt_enterNewPasword);
        return Newpassword;
    }

    public void SetConfirmPassword (String x)
    {
        driver.element().type(Txt_enterConfirmPassword,x);
    }
    public String GetConfirmPassword ()
    {
        driver.element().click(Btn_eyeForConfirmNewPassword);
        String ConfirmPassword = driver.element().getText(Txt_enterConfirmPassword);
        return ConfirmPassword;
    }
    public void ClickConfirm ()
    {
        driver.element().click(Btn_confirm);
    }
    public void ClickDropdwnSign()
    {
        driver.element().click(Lst_Sign);
    }

    public boolean ChangePasswordValidation(String Message) {
        LogEntries logEntries = driver.getDriver().manage().logs().get(LogType.BROWSER);

        // Iterate through logs to find validation error
        boolean foundError = false;
        for (LogEntry entry : logEntries) {
            if (entry.getMessage().contains(Message)) {
                foundError = true;
                break;
            }
        }

        return  foundError;
// Assert validation error message is found in logs
        //  Assert.assertTrue("Validation error message not found in logs", foundError);
    }
}