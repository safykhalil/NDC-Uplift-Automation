package AdminPages.Profile;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Travellers_Page {

    public Travellers_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    SHAFT.GUI.WebDriver driver ;

    By Btn_Add = By.xpath("//button[@routerlink=\"add\"]");
    By Lst_BranchName = By.xpath("//p-dropdown[.//input[@id=\"id-BranchName\"]]");
    By Lst_Title = By.xpath("//p-dropdown[.//input[@id=\"id-Title\"]]");
    By Txt_Firstname = By.xpath("//input[@id=\"id-FirstName\"]");
    By Txt_LastName = By.xpath("//input[@id=\"id-LastName\"]");
    By Btn_BackDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-traveller/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div[2]/ndc-fg-input[6]/ndc-fg-date-picker-input/span/p-calendar/span/div/div/div/div[1]/button[1]");
    By Dpick_Date = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-add-traveller/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div[2]/ndc-fg-input[6]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By Txt_Email = By.xpath("//input[@id=\"id-EmailID\"]");
    By Lst_Nationality = By.xpath("//p-dropdown[.//input[@id=\"id-Nationality\"]]");
    By Lst_Gender = By.xpath("//p-dropdown[.//input[@id=\"id-Gender\"]]");
    By Txt_Phonenumber = By.xpath("//input[@id=\"phone number\"]");
    By Txt_Address = By.xpath("//input[@id=\"id-Address\"]");
    By Btn_Save = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Profile = By.xpath("//a[@href=\"/profile\"]");
   // By Lst_BranchName = By.xpath("//p-dropdown[.//input[@id=\"id-BranchName\"]]");
    By Txt_ClientID = By.xpath("//input[@id=\"id-ClientID\"]");
    By Txt_ClientName = By.xpath("//input[@id=\"id-Clientname\"]");
    By Txt_EmailID = By.xpath("//input[@id=\"id-EmailID\"]");
    By Txt_PhoneNo = By.xpath("//input[@id=\"phone number\"]");
    By Lst_Country = By.xpath("//p-dropdown[.//input[@id=\"id-Country\"]]");
    By Rbtn_Active = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Active\"]]");
    By Rbtn_Inactive = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Inactive\"]]");
    By Rbtn_Both = By.xpath("//p-radiobutton[.//input[@id=\"id-Status-Both\"]]");
    By Btn_Search = By.xpath("//button[@type=\"submit\"]");
    //*//
    By Btn_Update = By.xpath("//i[@class=\"pi pi-pencil\"]");
//    By Lst_BranchName = By.xpath("//p-dropdown[.//input[@id=\"id-BranchName\"]]");
//    By Lst_Title = By.xpath("//p-dropdown[.//input[@id=\"id-Title\"]]");
//    By Txt_Firstname = By.xpath("//input[@id=\"id-FirstName\"]");
//    By Txt_LastName = By.xpath("//input[@id=\"id-LastName\"]");
//    By Dpick_Date = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-add-traveller/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[1]/div[2]/ndc-fg-input[6]/ndc-fg-date-picker-input/span/p-calendar/span/button");
//    By Txt_Email = By.xpath("//input[@id=\"id-EmailID\"]");
//    By Lst_Nationality = By.xpath("//p-dropdown[.//input[@id=\"id-Nationality\"]]");
//    By Lst_Gender = By.xpath("//p-dropdown[.//input[@id=\"id-Gender\"]]");
//    By Txt_Phonenumber = By.xpath("//input[@id=\"phone number\"]");
//    By Txt_Address = By.xpath("//input[@id=\"id-Address\"]");
//    By Btn_Save = By.xpath("//button[@type=\"submit\"]");


    ////////// Passport Details/////////////

    By Txt_PassportNo = By.xpath("//input[@id=\"id-PassportNumber\"]");
    By Dpick_ExpDate = By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-add-traveller/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div[2]/div[2]/ndc-fg-input[2]/ndc-fg-date-picker-input/span/p-calendar/span/button");
    By Lst_CountryofIssue = By.xpath("(//p-dropdown[.//input[@id=\"id-CountryOfIssue\"]])[1]");


    public void AddPersonalDetail(String branch, String title , String firstname , String lastname , String date , String
                                  email, String nationality ,String gender , String phonenumber , String address) throws InterruptedException {
        System.out.println("Start Method : Add Personal Details ");
        driver.element().click(Btn_Add);
        driver.element().click(Lst_BranchName);
        By option = By.xpath(String.format("//span[text()='%s']", branch));
        driver.element().click(option);

        driver.element().click(Lst_Title);
        By option1 = By.xpath(String.format("//span[text()='%s']", title));
        driver.element().click(option1);

        driver.element().type(Txt_Firstname,firstname);
        driver.element().type(Txt_LastName,lastname);

//        driver.element().click(Date);
//        driver.element().click(BackDate);
//        Thread.sleep(3000);

        driver.element().click(Dpick_Date).click(Btn_BackDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", date));
        driver.element().click(option4);

        driver.element().type(Txt_Email,email);

        driver.element().click(Lst_Nationality);
        By option2 = By.xpath(String.format("//span[text()='%s']", nationality));
        driver.element().click(option2);

        driver.element().click(Lst_Gender);
        By option3 = By.xpath(String.format("//span[text()='%s']", gender));
        driver.element().click(option3);

        driver.element().type(Txt_Phonenumber,phonenumber);
        driver.element().type(Txt_Address,address);


    }


    public void AddPassportdetails(String passportno , String expdate , String countryissue){
        System.out.println("Start Method : Add Passport Details ");
        driver.element().type(Txt_PassportNo,passportno);
        driver.element().click(Dpick_ExpDate);
        By option4 = By.xpath(String.format("//span[text()='%s']", expdate));
        driver.element().click(option4);

        driver.element().click(Lst_CountryofIssue);
        By option3 = By.xpath(String.format("//span[text()='%s']", countryissue));
        driver.element().click(option3);
    }

    public void ClickSave(){
        System.out.println("Start Method : Click Save Button ");
        driver.element().click(Btn_Save);
    }
    public String Actual()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Added Successfully\"]"));
        return S;
    }
    /// *** Search Travellers Page *** ///////////////////////////////////////////////////////////////
    public void setProfile(){

        driver.element().click(Btn_Profile);

    }
    public void setSearchTravellers(String branch , String clientid, String clientname,String emailid,String phone , String country){
//        driver.element().click(Lst_BranchName);
//        By option = By.xpath(String.format("//span[text()='%s']", branch));
//        driver.element().click(option);
        driver.element().type(Txt_ClientID,clientid);
        driver.element().type(Txt_ClientName,clientname);
        driver.element().type(Txt_EmailID,emailid);
        driver.element().type(Txt_PhoneNo,phone);
//        driver.element().click(Country);
//        By option1 = By.xpath(String.format("//span[text()='%s']", country));
//        driver.element().click(option1);


    }


    public void ClickActive(){
        System.out.println("Start Method : ClickActive");
        driver.element().click(Rbtn_Active);
    }
    public void ClickInactive(){
        System.out.println("Start Method : ClickInactive");
        driver.element().click(Rbtn_Inactive);
    }
    public void ClickBoth(){
        System.out.println("Start Method : ClickBoth");
        driver.element().click(Rbtn_Both);
    }
    public void ClickSearch(){
        System.out.println("Start Method : ClickSearch");

        driver.element().click(Btn_Search);

    }
    /// *** Update Travellers *** /////////////////////////////////////////////////////////////////////////
    public void setPersonalDetail(String branch, String title , String firstname , String lastname , String date , String
            email, String nationality ,String gender , String phonenumber , String address)
    {
        driver.element().click(Btn_Update);
        driver.element().click(Lst_BranchName);
        By option = By.xpath(String.format("//span[text()='%s']", branch));
        driver.element().click(option);

//        driver.element().click(Title);
//        By option1 = By.xpath(String.format("//span[text()='%s']", title));
//        driver.element().click(option1);

//        driver.element().type(Firstname,firstname);
//        driver.element().type(LastName,lastname);

//        driver.element().click(Date);
//        By option4 = By.xpath(String.format("//span[text()='%s']", date));
//        driver.element().click(option4);
//
//        driver.element().type(Email,email);
//
//        driver.element().click(Nationality);
//        By option2 = By.xpath(String.format("//span[text()='%s']", nationality));
//        driver.element().click(option2);

//        driver.element().click(Gender);
//        By option3 = By.xpath(String.format("//span[text()='%s']", gender));
//        driver.element().click(option3);

//        driver.element().type(Phonenumber,phonenumber);
        driver.element().type(Txt_Address,address);


    }


    public void setPassportdetails(String passportno , String expdate , String countryissue){
//        driver.element().type(PassportNo,passportno);
//        driver.element().click(ExpDate);
//        By option4 = By.xpath(String.format("//span[text()='%s']", expdate));
//        driver.element().click(option4);

        driver.element().click(Lst_CountryofIssue);
        By option3 = By.xpath(String.format("//span[text()='%s']", countryissue));
        driver.element().click(option3);
    }

    public void setSave(){
        driver.element().click(Btn_Save);
    }
    public String Actual1()
    {
        String  S =driver.element().getText(By.xpath("//div[@aria-label=\"Updated Successfully\"]"));
        return S;
    }
}
