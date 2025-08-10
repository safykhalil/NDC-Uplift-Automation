package AdminPages.Master.Flight.PreferAirline;

import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

public class CreatePreferAirLine_TC extends TestBase_TC {
    // Valid
    PreferAirLine_Page preferAirLine;

    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }


    @Test(dataProvider = "JsonProvider", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testCreateForPreferAirLine1(String AirLineName, String supplierName,String SupplierPcc) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("Aero Lanka",AirLineName);
        preferAirLine.SelectAddSupplierName(supplierName);
        preferAirLine.SelectAddPCCSupplierName(SupplierPcc);
        preferAirLine.SendForApprovalButton();
        preferAirLine.clickOnCancelButton();
        preferAirLine.EnterAirlineName(AirLineName);
        preferAirLine .SelectSupplierName(supplierName);
        preferAirLine.clickBothButton()
                .clickOnSearchInGrid();
        assertEquals(AirLineName,preferAirLine.TableColumnDataExtractor(0,AirLineName));
        assertEquals(supplierName,preferAirLine.TableColumnDataExtractor(1,supplierName));


    }
    // Valid
    @Test
    public void testCreateForPreferAirLine() throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("Aeropelican Air Services","Aeropelican Air Services");
        preferAirLine.SelectAddSupplierName("Amadeus");
        preferAirLine.SelectAddPCCSupplierName("Amadeus Live");
        preferAirLine.SendForApprovalButton();
        String Acual =driver.element().getText(By.xpath("//div[@aria-label=\"Prefer Airline already exists.\"]"));
        String Expected="Prefer Airline already exists.";
        Assert.assertEquals(Acual,Expected,"This Behaviour not correct ");
        preferAirLine.clickOnCancelButton();
        preferAirLine.EnterAirlineName("Aeropelican Air Services");
        preferAirLine .SelectSupplierName("Amadeus");
        preferAirLine.clickBothButton()
                .clickOnSearchInGrid();
        assertEquals("Aeropelican Air Services",preferAirLine.TableColumnDataExtractor(0,"Aeropelican Air Services"));
        assertEquals("Amadeus",preferAirLine.TableColumnDataExtractor(1,"Amadeus"));
    }
    @Test(dataProvider = "CreatePreferAirLineWithValidDataAlreadyExist", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testCreateForPreferAirLine2(String AirLineName, String supplierName ,String SupplierPcc) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("Aer", AirLineName);
        preferAirLine.SelectAddSupplierName(supplierName);
        preferAirLine.SelectAddPCCSupplierName(SupplierPcc);
        preferAirLine.SendForApprovalButton();
        Thread.sleep(1000);
        String Acual =driver.element().getText(By.xpath("//div[@aria-label=\"Prefer Airline already exists.\"]"));
        String Expected="Prefer Airline already exists.";
        Assert.assertEquals(Acual,Expected,"This Behaviour not correct ");


    }
    @Test
    public void testCreateForPreferAirLineWithRestractedAirLine( ) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("Dev"," Dev Create");
        preferAirLine.SelectAddSupplierName("Galileo");
        preferAirLine.SelectAddPCCSupplierName("Live Egypt PCC");
        preferAirLine.SendForApprovalButton();
        String Acual =driver.element().getText(preferAirLine.RestricatedAirLine);
        String Expected="Remove the restricted airlines to add prefer airline";
        Assert.assertEquals(Acual,Expected,"This Behaviour not correct ");
        Thread.sleep(1000);

    }

    @Test(dataProvider = "CreatePreferAirLineWithValidDataWithSupplierPCC", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testCreateForPreferAirLine3(String AirLineName, String supplierName,String supplierPCC) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("40-", AirLineName);
        preferAirLine.SelectAddSupplierName(supplierName);
        preferAirLine.SelectAddPCCSupplierName(supplierPCC);
        preferAirLine.SendForApprovalButton();
        Thread.sleep(1000);
        String Acual =driver.element().getText(preferAirLine.RestricatedAirLine);
        String Expected="Remove the restricted airlines to add prefer airline";
        Assert.assertEquals(Acual,Expected,"This Behaviour not correct ");

    }

    @Test(dataProvider = "CreatePreferAirLineWithINValidName", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testCreateForPreferAirLine5(String AirLineName, String supplierName,String supplierPCC) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirLineName2(AirLineName);
        preferAirLine.SelectAddSupplierName(supplierName);
        preferAirLine.SelectAddPCCSupplierName(supplierPCC);
        preferAirLine.SendForApprovalButton();
        Assert.assertEquals(driver.element().getText(preferAirLine.ValidationOnAirLineName),"Airline name is required");
    }
    @Test(dataProvider = "CreatePreferAirLineWithoutName", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testCreateForPreferAirLine6(String AirLineName, String supplierName) throws InterruptedException {
        preferAirLine.clickAddAirLineButton();
        preferAirLine.AddAirlineName("40-",AirLineName);
        preferAirLine.SelectAddSupplierName(supplierName);
        preferAirLine.SendForApprovalButton();
        Assert.assertEquals(driver.element().getText(preferAirLine.ValidationOnPCCName),"Supplier Pcc is required");

    }



}
