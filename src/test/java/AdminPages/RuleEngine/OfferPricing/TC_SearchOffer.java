package AdminPages.RuleEngine.OfferPricing;

import AdminPages.Login.LogIn_Page;
import AdminPages.Login.TestBase;
import AdminPages.RuleEngine.RuleEngine_Common;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.JsonDataUtil;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public class TC_SearchOffer extends TestBase {
    private SearchOffer_Page SearchOffer;
    private LogIn_Page logIn;
    private AdminPages.Helper.PaginationHelper paginationHelper;

    //    private AdminPages.Helper.PaginationHelper paginationHelper;
//
    @DataProvider(name = "JsonProvider")
    public static Object[][] provideJsonData(Method method) throws IOException {
        String fileName = method.getName();
        String filePath = "./src/test/resources/testDataFiles/" + fileName + ".json";
        return JsonDataUtil.readJsonData(filePath);
    }

    @BeforeTest
    public void sign() throws InterruptedException {
        logIn = new LogIn_Page(driver);
        logIn.ClickSuperAdmin();
        logIn.ClickOnLoginButton();
        Thread.sleep(3000);
    }

    @Test(dataProvider = "JsonProvider")
    public void Searchoffer(Map<String, String> discount) throws InterruptedException {
        paginationHelper = new AdminPages.Helper.PaginationHelper(driver);
        SearchOffer = new SearchOffer_Page(driver);
        String Discount = discount.get("Discount");
        new RuleEngine_Common(driver).clickRuleEngine().clickOfferPricing();
        SearchOffer.SetSearchOffer(Discount);
        SearchOffer.setBoth();
        SearchOffer.search();
        String remarksup = discount.get("remarksup");
        SearchOffer.setThumpUp(remarksup);
        SearchOffer.performAssertions();

        int totalPages = paginationHelper.getTotalPages();
        for (int currentPage = 1; currentPage <= totalPages; currentPage++) {
            System.out.println("Processing page: " + currentPage);

            // Perform assertions
            SearchOffer.performAssertions();

            // Navigate to the next page if not on the last page
            if (currentPage < totalPages) {
                paginationHelper.navigateToNextPage();
            }


       }


    }
    @AfterMethod
    public void Reload(){
        driver.browser().navigateToURL("http://192.168.1.90");
    }
}

