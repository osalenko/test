package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByCssSelector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import static org.apache.commons.lang3.BooleanUtils.and;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by SANYA on 5/20/2017.
 */
public class HomePage {

    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
       }

    private By searchfield = By.name("q");
    private By searchButton = By.id("_fZl");
    private By firstLink = By.id("vs0p1c0");
    private By nextButton = By.xpath("//*[@id='pnnext']/span[2]");
    boolean console = true;


    public void doSearchAutomation(String searchKeyword)
    // fill search field by request and click "Search" button.
    {
        driver.findElement(searchfield).sendKeys(searchKeyword);
        Reporter.log("Fill search field", console);
        driver.findElement(searchButton).click();
        Reporter.log("Click search button", console);
    }

    public boolean openLinkAssert(String expectedTitle) {
        driver.findElement(firstLink).click();
        Reporter.log("Open first Link", true);
        String actualTitle = driver.getTitle();
        Reporter.log("Get title to verify", true);
        if (
            actualTitle.toLowerCase().contains(expectedTitle)) {
            Reporter.log("The actual title is - " + actualTitle,true);
            Reporter.log("The expected title is - " + expectedTitle,true);
            return true;
        } else
            {
            Reporter.log("The actual title is - " + actualTitle,true);
            Reporter.log("The expected title is - " + expectedTitle,true);
            return false;
        }
        //  assertEquals(expectedTitle, actualTitle.toLowerCase());

    }

    public boolean expectDomain(String domain)
    // Verify if expected domain is displayed in search results on pages from 1 to 5.
    {
        for (int i =1; i < 5; i++) {
            Reporter.log("Search domain on page " + i, console);
            if (driver.getPageSource().contains(domain)) {
                System.out.println("Link on page " + i);
                return true;
            } else {
                System.out.println("Text is absent on page " + i);
                Reporter.log("Click next button", console);

                WebDriverWait wait = new WebDriverWait(driver, 30, 500);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("flyr")));
                driver.findElement(nextButton).click();

                /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException exc) {
                    exc.printStackTrace();
                }*/

            }
        } return false;
    }
}


