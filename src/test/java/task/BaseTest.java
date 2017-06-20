package task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.Setup;

/**
 * Created by SANYA on 5/29/2017.
 */
public class BaseTest {
    public HomePage homepage;
    protected WebDriver driver;



    @BeforeMethod(alwaysRun = true)
    public void before()

    // Setup for BROWSER, ADDRESS(domain) and ENVIRONMENT which used for this test run

    {
        driver = Setup.CrossBrows("chrome", "www.google.com","");
    }

    @AfterMethod(alwaysRun = true)
    public void after(){
        if (driver != null) {
            driver.quit();
        }
    }
}
