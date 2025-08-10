package AdminPages.Master.Miscellaneous;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class RateOfExchange_Page {

    private final SoftAssert softAssert;
    public String columnText;

    public RateOfExchange_Page(SHAFT.GUI.WebDriver driver) {

        this.softAssert = new SoftAssert();

        this.driver = driver;
    }

    SHAFT.GUI.WebDriver driver;
    By Btn_ClickRate = By.xpath("//li[@id=\"ROE\"]");
    By Lst_FromCurrency = By.xpath("//p-dropdown[.//input[@id=\"id-Fromcurrency\"]]");
    By Lst_ToCurrency = By.xpath("//p-dropdown[.//input[@id=\"id-ToCurrency\"]]");
    // By SearchInGrid=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div/div/ndc-rate-of-exchange/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/div/div/button/span");
    By Btn_SearchInGrid = By.xpath("//button[@type=\"submit\"]");
    // By AddRateOfExchange = By.xpath("//button[@routerlink=\"add\"]");
    By Btn_AddRateOfExchange = By.xpath("//button[@routerlink=\"add\"]");
    By Lst_AddFromCurrency = By.xpath("//p-dropdown[.//input[@id=\"id-Fromcurrency\"]]");
    By Lst_AddToCurrency = By.xpath("//p-dropdown[.//input[@id=\"id-Tocurrency\"]]");

    // By AddExchangeRate = By.xpath("//span[.//input[@id=\"id-Exchangerate\"]]");
    By Btn_AddExchangeRate = By.xpath("//*[@id=\"id-Exchangerate\"]");
    By Btn_SendForApprovel = By.xpath("//button[@type=\"submit\"] ");
    By Btn_Cancel = By.xpath("//button[@type=\"reset\"]");
    By Btn_Master =By.xpath("//a[@href=\"/master\"]");
    By Btn_Miscellaneous= By.linkText("Miscellaneous");
    By Btn_RateOfExchange=By.linkText("Rate of Exchange");
    By Btn_firstPageButton = By.xpath(" //span[@id=\"frist\"]");
    By lastPageButton = By.id("id=\"last\"");
    By nextPageButton = By.xpath(" //button[@class=\"next\"]");
    By prevPageButton = By.xpath(" //button[@class=\"prev\"]");
    By Btn_pageNumbers = By.xpath("//a[contains(@href, 'page')]");
    By Btn_firstPage = By.linkText("First");
    By Btn_lastPage = By.linkText("Last");
    By Btn_nextPage = By.linkText("»");
    By prevPage = By.linkText("«");
    public By Txt_NoDataFounded=By.xpath("//td[@class=\"message\"]");
    public By Txt_ValidationErrorToCurrency=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-rate-of-exchange/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[2]/span");
    public By Txt_ValidationErrorFromCurrency=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-rate-of-exchange/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[1]/span");
    public By Txt_ValidationErrorForRate=By.xpath("/html/body/ndc-root/ndc-layout/div/div[2]/div[1]/div/ndc-add-rate-of-exchange/div/div/ndc-fg-form-container/div/ndc-fg-form-generator/form/ndc-fg-input[3]/span");
    public By Txt_ValidationOnCancelButton=By.xpath("//div[@class=\"col-sm-12 col-lg-6 form-title\"]");
    public void NavigateToRateOfExchangePage(){
        System.out.println("Start Method : Go to Rate Of Exchange ");
        driver.element().click(Btn_Master);
        driver.element().click(Btn_Miscellaneous);
        driver.element().click(Btn_RateOfExchange);

    }
    public RateOfExchange_Page SelectFromCurrency(String Currency) {
        System.out.println("Start Method : SelectFromCurrency ");
        driver.element().click(Lst_FromCurrency);
        By option = xpath(String.format("//span[text()='%s']", Currency));
        driver.element().click(option);
        return this;
    }

    public RateOfExchange_Page SelectToCurrency(String Currency) {
        System.out.println("Start Method : SelectToCurrency ");
        driver.element().click(Lst_ToCurrency);
        By option = xpath(String.format("//span[text()='%s']", Currency));
        driver.element().click(option);
        return this;
    }

    public RateOfExchange_Page ClickSearchButton() {
        System.out.println("Start Method : ClickSearchButton ");

        driver.element().click(Btn_SearchInGrid);
        return this;
    }

    public RateOfExchange_Page AddRateButton() {
        System.out.println("Start Method : AddRateButton ");
        driver.element().click(Btn_AddRateOfExchange);
        return this;

    }

    public RateOfExchange_Page AddFromCurrency(String Currency1) {
        System.out.println("Start Method : AddFromCurrency ");
        driver.element().click(Lst_AddFromCurrency);
        By option = xpath(String.format("//span[text()='%s']", Currency1));
        driver.element().click(option);
        return this;
    }

    public RateOfExchange_Page AddToCurrency(String Currency2) {
        System.out.println("Start Method : AddToCurrency ");
        driver.element().click(Lst_AddToCurrency);
        By option = xpath(String.format("//span[text()='%s']",Currency2));
        driver.element().click(option);
        return this;
    }

    public RateOfExchange_Page AddRateOfExchange(String Rate) {
        System.out.println("Start Method : AddRateOfExchange ");
        //ouble doubleValue = Double.parseDouble(Rate);


        driver.element().type(Btn_AddExchangeRate, String.valueOf(Double.parseDouble(Rate)));
        return this;
    }

    public RateOfExchange_Page ClickSendForApprovel() {
        System.out.println("Start Method : ClickSendForApprovel ");

        driver.element().click(Btn_SendForApprovel);
        return this;
    }

    public RateOfExchange_Page ClickCancel() {
        System.out.println("Start Method : ClickCancel ");

        driver.element().click(Btn_Cancel);
        return this;
    }

    public String TableColumnDataExtractor(int ColumnSearch, String ExpectedSearch) {
        WebElement table = driver.getDriver().findElement(By.xpath("//div[@class=\"table-area\"]")); // Adjust the XPath to match your table
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        String actualResult = ExpectedSearch;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() > ColumnSearch) {
                String columnText = cells.get(ColumnSearch).getText();
                if (!columnText.equals(actualResult)) {
                    actualResult = null;
                    break;
                }
            }
            // i will add  assertEquals(ExpectedSearch, columnText);

        }
        return actualResult;
    }

    public RateOfExchange_Page PaginationAutomation() {

        List<WebElement> pageNumbers = driver.getDriver().findElements(By.xpath("//a[contains(@href, 'page')]"));
        for (WebElement page : pageNumbers) {
            driver.element().click((By) page);
        }
        driver.element().click(nextPageButton);
        driver.element().click(lastPageButton);
        return this;
    }
    public void paginateAndVerifyData() {
        driver.element().click(Btn_firstPageButton);
        List<WebElement> pages = driver.getDriver().findElements(Btn_pageNumbers);

        // Loop through all the pages
        for (int i = 0; i < pages.size(); i++) {
            pages.get(i).click();

            List<WebElement> dataRows = driver.getDriver().findElements(xpath("//div[@class='data-row']"));
            if (dataRows.isEmpty()) {
                System.out.println("No data found on page: " + (i + 1));
                break; // If no data is found, stop the loop or handle the error accordingly
            } else {
                System.out.println("Data found on page: " + (i + 1));
            }

            // Re-fetch the list of pages to prevent StaleElementReferenceException
            pages = driver.getDriver().findElements(Btn_pageNumbers);
        }

        // After looping through pages, you can return to the first page or last page
        driver.element().click(Btn_firstPageButton); // Or use lastPageButton if needed
    }
    public void assertFieldAcceptsOnlyNumbers( By AddToCurrency) {
        // Locate the input field
        WebElement inputField = driver.getDriver().findElement(AddToCurrency);

        // Clear the field if needed
        inputField.clear();

        // Attempt to input a string value
        String stringInput = "abcd1234";
        inputField.sendKeys(stringInput);

        // Get the actual value after attempting to input a string
        String actualValue = inputField.getAttribute("value");

        // Assert that the input field did not accept the non-numeric part
        if (!actualValue.matches("\\d*")) { // Regex to match only digits
            System.out.println("Test failed: The input field accepted non-numeric characters.");
        } else {
            System.out.println("Test passed: The input field accepts only numeric characters.");
        }

        // Alternatively, you can use assertions from your test framework
        Assert.assertTrue(actualValue.matches("\\d*"), "The input field should accept only numeric characters.");
    }

}