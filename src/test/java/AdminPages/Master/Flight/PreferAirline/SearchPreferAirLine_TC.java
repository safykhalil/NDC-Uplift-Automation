package AdminPages.Master.Flight.PreferAirline;
import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase_TC;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class SearchPreferAirLine_TC extends TestBase_TC {
    //Valid
    PreferAirLine_Page preferAirLine;
    LogIn_Page logIn;


    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @Test(dataProvider = "JsonProvider", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testSearchForPreferAirLine1(String AirLineName ,String SupplierName) throws InterruptedException {
        preferAirLine.EnterAirlineName(AirLineName);
        preferAirLine .SelectSupplierName(SupplierName);
        preferAirLine.clickBothButton();
        preferAirLine .clickOnSearchInGrid();
        Thread.sleep(1000);
      //  assertEquals("Air Cairo",preferAirLine.TableColumnDataExtractor(0,"Air Cairo"));
        assertEquals("Galileo",preferAirLine.TableColumnDataExtractor(1,"Galileo"));
    }
    @Test(dataProvider = "SearchWithValidDataPreferAirLine Name only and active status", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testSearchForPreferAirLine2(String AirLineName ) throws InterruptedException {

        preferAirLine.EnterAirlineName(AirLineName);
        preferAirLine.clickInActiveButton()
                .clickOnSearchInGrid();
        Thread.sleep(1000);
        assertEquals( AirLineName,preferAirLine.TableColumnDataExtractor(0,AirLineName));
       assertEquals("Inactive",preferAirLine.TableColumnDataExtractor(3,"Inactive"));

    }



    @Test(dataProvider = "SearchWithValidDataPreferAirLine Supplier only and inActive Status", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testSearchForPreferAirLine3(String supplierName) throws InterruptedException {
        preferAirLine.SelectSupplierName(supplierName);
        preferAirLine.clickInActiveButton()
                .clickOnSearchInGrid();
        Thread.sleep(1000);
        assertEquals( supplierName,preferAirLine.TableColumnDataExtractor(1,supplierName));
        assertEquals("Inactive",preferAirLine.TableColumnDataExtractor(3,"Inactive"));
        Thread.sleep(1000);
    }


    @Test// SearchBookingTC With  InActive   Status
    public void testSearchForPreferAirLine5() throws InterruptedException {

        logIn.ClickOnLoginButton();
        preferAirLine.clickInActiveButton();
        preferAirLine.clickOnSearchInGrid();
        Thread.sleep(1000);
        assertEquals("Inactive",preferAirLine.TableColumnDataExtractor(3,"Inactive"));
    }
    @Test // SearchBookingTC With  Active   Status
    public void testSearchForPreferAirLine6() throws InterruptedException {

        logIn.ClickOnLoginButton();
        preferAirLine.clickActiveButton();
        preferAirLine.clickOnSearchInGrid();
        assertEquals("Active",preferAirLine.TableColumnDataExtractor(3,"Active"));

    }
    @Test // SearchBookingTC With Both Status
    public void testSearchForPreferAirLine7() throws InterruptedException {

        // logIn.ClickOnLoginButton();
        preferAirLine.clickBothButton();
        preferAirLine.clickOnSearchInGrid();

    }
    @Test(dataProvider = "SearchWith ValidDataPreferAirLine with Name,Supplier name and Both Status", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testSearchForPreferAirLine8(String AirLineName,String supplierName) throws InterruptedException {
        preferAirLine.EnterAirlineName(AirLineName);
        preferAirLine.SelectSupplierName(supplierName);
        preferAirLine.clickBothButton();
        preferAirLine.clickOnSearchInGrid();
    }

    //Invalid Data
    @Test(dataProvider = "SearchWith ValidDataPreferAirLine with Name and Supplier name DataNotFounded", dataProviderClass = PreferAirLineDataProvider_TC.class)
    public void testSearchForPreferAirLine11(String AirLineName ,String SupplierName) throws InterruptedException {
        preferAirLine.EnterAirlineName(AirLineName);
        preferAirLine .SelectSupplierName(SupplierName)
                .clickOnSearchInGrid();
        String ActualResult=  driver.getDriver().findElement(By.xpath("//td[@class=\"message\"]")).getText();
        assertEquals("No data has been found!", ActualResult);

    }

}
