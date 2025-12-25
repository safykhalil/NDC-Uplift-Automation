package AdminPages.Admin.Agency.Agency;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.FileUploadUtil;

import java.util.Map;

public class AddAgencyCore_TC extends TestBase_TC {

    private AddAgencyCore_Page addAgencyCore;
    private LogIn_Page logIn;

    @BeforeTest
    public void sign() {
        logIn = new LogIn_Page(driver);
        logIn.ClickAdmin();
        logIn.ClickOnLoginButton();

    }

    @Test(dataProvider = "AddAgencyCore")
    public void setAddAgencyCore(Map<String,String> Create) throws InterruptedException {
        addAgencyCore = new AddAgencyCore_Page(driver);
        String Branch = Create.get("Branch");
        String AgencyName = Create.get("AgencyName");
        String State = Create.get("State");
        String City = Create.get("City");
        String PostOfficeBox = Create.get("PostOfficeBox");
        String Address = Create.get("Address");
        String PhoneNo = Create.get("PhoneNo");
        String ContactPerson = Create.get("ContactPerson");
        String EmailID = Create.get("EmailID");
        String Phone = Create.get("Phone");
        String Name = Create.get("Name");
        String Email = Create.get("Email");
        String PhoneN = Create.get("PhoneN");
        String Invoice = Create.get("Invoice");
        String CreditLimit = Create.get("CreditLimit");
        String TopUpLimit = Create.get("TopUpLimit");
        String CreditTerms = Create.get("CreditTerms");
        String Year = Create.get("Year");
        String Month = Create.get("Month");
        String Day = Create.get("Day");
        String Year1 = Create.get("Year1");
        String Month1 = Create.get("Month1");
        String Day1 = Create.get("Day1");
        addAgencyCore.ClickAgency();
        addAgencyCore.AddButton();
        addAgencyCore.SelectBranch(Branch);
        addAgencyCore.AgencyName(AgencyName);
        addAgencyCore.StateDropDown(State);
        addAgencyCore.CityDropDown(City);
        addAgencyCore.PostOfficeText(PostOfficeBox);
        addAgencyCore.AddressText(Address);
        addAgencyCore.PhoneNumberText(PhoneNo);
        addAgencyCore.ContactPersonText(ContactPerson);
        addAgencyCore.EmailText(EmailID);
        addAgencyCore.AgencyOwnerPhoneText(Phone);
        addAgencyCore.Date();
        addAgencyCore.SelectContractStartDate(Month,Year,Day);
        addAgencyCore.Date2();
        addAgencyCore.SelectContractEndDate(Month1,Year1,Day1);
        addAgencyCore.WonderTravelSalesName(Name);
        addAgencyCore.WonderTravelSalesTextEmail(Email);
        addAgencyCore.WonderTravelSalesTextPhone(PhoneN);
        addAgencyCore.InvoiceGeneration(Invoice);
        addAgencyCore.CreditLimit(CreditLimit);
        addAgencyCore.TopUpLimit(TopUpLimit);
        addAgencyCore.CreditTerms(CreditTerms);
        addAgencyCore.Cash();
        addAgencyCore.Wallet();
        By fileInputLocator = By.xpath("(//input[@type='file'])[1]");
        String filePath = "C:\\Users\\Mahmoud\\Desktop\\dsdssa.pdf"; // Replace with your file path
        // Call the static uploadFile method from utilities.FileUploadUtil to upload the file
        FileUploadUtil.uploadFile(driver.getDriver(), fileInputLocator, filePath);
        addAgencyCore.Upload();
        By fileInputLocator2 = By.xpath("(//input[@type='file'])[7]");
        String filePath2 = "C:\\Users\\Mahmoud\\Desktop\\OP.png"; // Replace with your file path
        // Call the static uploadFile method from utilities.FileUploadUtil to upload the file
        FileUploadUtil.uploadFile(driver.getDriver(), fileInputLocator2, filePath2);
        addAgencyCore.UploadLogo();
        addAgencyCore.SendForApproval();
        addAgencyCore.Alert();
        Thread.sleep(5000);

    }
}
