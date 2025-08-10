package AdminPages.Login;
import com.shaft.driver.DriverFactory;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase_TC {

    protected SHAFT.GUI.WebDriver driver ;

    @BeforeTest
    public void setupBrowse() throws InterruptedException {
        driver = new SHAFT.GUI.WebDriver(DriverFactory.DriverType.CHROME);
        driver.browser().maximizeWindow();
        driver.browser().navigateToURL("http://192.168.1.70");

    }

//    @AfterTest
//    public void Quit() {
//        driver.quit();
//    }
}