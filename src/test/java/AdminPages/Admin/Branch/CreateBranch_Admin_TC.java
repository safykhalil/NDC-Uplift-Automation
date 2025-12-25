package AdminPages.Admin.Branch;
//import AdminPages.Login.LogIn_Page;
//import AdminPages.Login.TestBase_TC;
//import AdminPages.Master.PaymentGateway.PaymentMethod.Add;
import AdminPages.Admin.AdminMenu;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;

import utilities.DataaUtils;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

public class CreateBranch_Admin_TC extends TestBase_TC {
    Faker faker = new Faker();
    private Branch_Page addNewBranch;
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
        new LogIn_Page(driver).ClickAdmin();
        new LogIn_Page(driver).ClickOnLoginButton();
        new AdminMenu(driver).openSubAdmin().openBranch();

    }

    @Test
    public void CreateBranch() throws InterruptedException {
        addNewBranch = new Branch_Page(driver);
        searchBranch = new Branch_Page(driver);
//        searchBranch.RouteBranch();
        addNewBranch.Btn_CreateBranch();
        String SupplierName = DataaUtils.getJsonData("SupplierData", "SupplierName");
        String PhoneNo = DataaUtils.getJsonData("NewBranchData", "PhoneNo");
        String EnterEmailPassword = DataaUtils.getJsonData("NewBranchData", "EnterEmailPassword");
        String EnterEmailID = DataaUtils.getJsonData("NewBranchData", "EnterEmailID");
        String Name = DataaUtils.getJsonData("NewBranchData", "Name");
        String EnterCreditLimit = DataaUtils.getJsonData("NewBranchData", "EnterCreditLimit");
        String TopUpLimit = DataaUtils.getJsonData("NewBranchData", "TopUpLimit");
        String CreditTermsDays = DataaUtils.getJsonData("NewBranchData", "CreditTermsDays");
        String selectOperatingCountry = DataaUtils.getJsonData("NewBranchData","SelectOperating Country");
        String State = DataaUtils.getJsonData("NewBranchData","State");
        String City = DataaUtils.getJsonData("NewBranchData","City");
        String Description = DataaUtils.getJsonData("NewBranchData","Description");
        // public  String  branchName = faker.name().firstName();
        String  branchName = DataaUtils.getJsonData("NewBranchData","EnterBranchName");
        boolean isGds = Boolean.parseBoolean(DataaUtils.getJsonData("NewBranchData", "isGds"));

        String CredentialName = DataaUtils.getJsonData("FlightDate", "CredentialName");
        String Email = faker.internet().emailAddress();
        String Address = faker.address().streetAddress();
        int Post = faker.number().randomDigit();



//        String OperatingCountry = Branch.get("OperatingCountry");
//        String BranchName = Branch.get("BranchName");
//        String State = Branch.get("State");
//        String City = Branch.get("City");
//        String Address = Branch.get("Address");
//        String PostOffice = Branch.get("PostOffice");
//        String PhoneNo = Branch.get("PhoneNo");
//        String EmailID = Branch.get("EmailID");
//        String Password = Branch.get("Password");
//        String Name = Branch.get("Name");
//        String Email = Branch.get("Email");
//        String Phone = Branch.get("Phone");
//        String Creditlimit = Branch.get("Creditlimit");
//        String TopupLimit = Branch.get("TopupLimit");
//        String Creditterms = Branch.get("Creditterms");
//        String SupplierCredential = Branch.get("SupplierCredential");
//        String Description = Branch.get("Description");
//        String Supplierdescription = Branch.get("Supplierdescription");
        Thread.sleep(4000);
        addNewBranch.Txt_OperatingCountry(selectOperatingCountry);
    //    Thread.sleep(2000);
        addNewBranch.Txt_Name(branchName);
      //  Thread.sleep(5000);
        addNewBranch.Lst_StateCreate(State,selectOperatingCountry);
        addNewBranch.Lst_CityCreate(City);
        addNewBranch.Txt_Address1(Address);
        addNewBranch.Txt_PostOffice(String.valueOf(Post));
        addNewBranch.Txt_PhoneNo(PhoneNo);
        addNewBranch.Txt_EmailID(EnterEmailID);
        addNewBranch.Txt_EmailPassword(EnterEmailPassword);
        addNewBranch.Txt_NameContact(Name);
        addNewBranch.Txt_EmailIdContact(Email);
        addNewBranch.Txt_PhoneNumber(PhoneNo);
        addNewBranch.Txt_CreditLimit(EnterCreditLimit);
        addNewBranch.Txt_TopUpLimit(TopUpLimit);
        addNewBranch.Txt_CreditTerms(CreditTermsDays);
        addNewBranch.Cbox_Cash();
        addNewBranch.Cbox_Wallet();
        addNewBranch.selectSupplier(SupplierName);
        if(isGds == true) {
            addNewBranch.Lst_SupplierCredential(CredentialName);
            addNewBranch.addPccForGds();
            addNewBranch.Txt_SupplierDescription(Description);
        }
        else
        {
            addNewBranch.addCredForLcc(SupplierName,CredentialName);
            System.out.println("GDS is False");
        }
        addNewBranch.Txt_Description(Description,SupplierName);


        addNewBranch.Btn_Submit();
        String Expected = "Added Successfully";
        Assert.assertEquals(addNewBranch.Actual(),Expected);


//        addNewBranch.Alert();
//        Thread.sleep(Long.parseLong("1000"));
        searchBranch.Txt_BranchName(branchName);
        searchBranch.Btn_Inactive();
        searchBranch.Btn_Search();
        searchBranch.Btn_ThumbUp("Approved");
//        DataaUtils.updateJsonValue("AddAgencyData.json","branchName",branchName);
//        DataaUtils.updateJsonValue("DiscountData.json","BranchName",branchName);
//        DataaUtils.updateJsonValue("ServiceChargeData.json","BranchName",branchName);
//        DataaUtils.updateJsonValue("searchBookingBrData.json","brName",branchName);





    }

//    @AfterMethod
//    public void navigateBackToURL() {
//        driver.browser().navigateToURL("http://192.168.1.92");
//    }
}