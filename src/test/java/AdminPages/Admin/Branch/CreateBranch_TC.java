package AdminPages.Admin.Branch;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import AdminPages.Master.PaymentGateway.PaymentMethod.Add;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class CreateBranch_TC extends TestBase_TC {
    private Branch_Page addNewBranch;
    private LogIn_Page logIn;
    private Branch_Page searchBranch;
    String Branchcode = "";
    String Branchname = "";
    String Selectcountry = "";
    String Selectstate = "";
    String Selectcity = "";

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign(){
        logIn = new LogIn_Page(driver);
        logIn.EnterUserName("odeysysadmin");
        logIn.EnterPassword("qqE6)Cxp6>B8");
        logIn.ClickOnLoginButton();


    }

    @Test(dataProvider = "JsonProvider")
    public void CreateBranch(Map<String, String> Branch) throws InterruptedException {
        addNewBranch = new Branch_Page(driver);
        searchBranch = new Branch_Page(driver);
        searchBranch.RouteBranch();
        addNewBranch.Btn_CreateBranch();
        String OperatingCountry = Branch.get("OperatingCountry");
        String BranchName = Branch.get("BranchName");
        String State = Branch.get("State");
        String City = Branch.get("City");
        String Address = Branch.get("Address");
        String PostOffice = Branch.get("PostOffice");
        String PhoneNo = Branch.get("PhoneNo");
        String EmailID = Branch.get("EmailID");
        String Password = Branch.get("Password");
        String Name = Branch.get("Name");
        String Email = Branch.get("Email");
        String Phone = Branch.get("Phone");
        String Creditlimit = Branch.get("Creditlimit");
        String TopupLimit = Branch.get("TopupLimit");
        String Creditterms = Branch.get("Creditterms");
        String SupplierCredential = Branch.get("SupplierCredential");
        String Description = Branch.get("Description");
        String Supplierdescription = Branch.get("Supplierdescription");
        addNewBranch.Txt_OperatingCountry(OperatingCountry);
        addNewBranch.Txt_Name(BranchName);
        addNewBranch.Lst_StateCreate(State);
        addNewBranch.Lst_CityCreate(City);
        addNewBranch.Txt_Address1(Address);
        addNewBranch.Txt_PostOffice(PostOffice);
        addNewBranch.Txt_PhoneNo(PhoneNo);
        addNewBranch.Txt_EmailID(EmailID);
        addNewBranch.Txt_EmailPassword(Password);
        addNewBranch.Txt_NameContact(Name);
        addNewBranch.Txt_EmailIdContact(Email);
        addNewBranch.Txt_PhoneNumber(Phone);
        addNewBranch.Txt_CreditLimit(Creditlimit);
        addNewBranch.Txt_TopUpLimit(TopupLimit);
        addNewBranch.Txt_CreditTerms(Creditterms);
        addNewBranch.Cbox_Cash();
        addNewBranch.Cbox_Amadeus();
        addNewBranch.Txt_Description(Description);
        addNewBranch.Lst_SupplierCredential(SupplierCredential);
        addNewBranch.Txt_SupplierDescription(Supplierdescription);
        addNewBranch.Btn_Submit();
        String Expected = "Added Successfully";
        Assert.assertEquals(addNewBranch.Actual(),Expected);


//        addNewBranch.Alert();
//        Thread.sleep(Long.parseLong("1000"));
        searchBranch.Txt_BranchName(BranchName);
        searchBranch.Btn_Inactive();
        searchBranch.Btn_Search();
        searchBranch.Btn_ThumbUp("Approved");





    }

    @AfterMethod
    public void navigateBackToURL() {
        driver.browser().navigateToURL("http://192.168.1.70");
    }
}