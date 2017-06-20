package task;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Setup;
import pages.HomePage;

    /**
     * Created by SANYA on 5/20/2017.
     */
    @Listeners(listener.Listener.class)
    public class TestCases extends BaseTest {


        @Test
        public void searchAutomation()
        {   // open google.com
            homepage = new HomePage(driver);
            // search for "automation" request
            homepage.doSearchAutomation("automation");
            // open first link and verify if Title as EXPECTED
            assert(homepage.openLinkAssert("automation"));
        }

       @Test
        public void searchDomain()
       {   // open google.com
           homepage = new HomePage(driver);
           // search for "automation" request
           homepage.doSearchAutomation("automation");
           // verify if "testautomationday.com" present ir result on pages from 1 to 5
           assert(homepage.expectDomain("testautomationday.com"));
        }
}

