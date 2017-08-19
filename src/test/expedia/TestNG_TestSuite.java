package expedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pageclasses.SearchPage;

import java.io.File;
import java.util.concurrent.TimeUnit;


public class TestNG_TestSuite {
    private WebDriver driver;
    private String baseUrl;
    static Logger log = Logger.getLogger(TestNG_TestSuite.class);
    SearchPage searchPage;

    @BeforeClass
    public void beforeClass() {
        File f = new File ("src");
        File fs = new File (f,"geckodriver.exe");

        System.setProperty("webdriver.gecko.driver", fs.getAbsolutePath());

        driver = new FirefoxDriver();
        baseUrl = "http://www.expedia.de";

        // Maximize the browser's window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(baseUrl);
    }

    @Test
    public void fillBasicInfo() throws Exception {
        searchPage.clickFlightsTab(driver);
        SearchPage.navigateToFlightsTab(driver);
        SearchPage.fillOriginTextBox(driver, "New York");
        SearchPage.fillDestinationTextBox(driver, "Chicago");
        SearchPage.fillDepartureDateTextBox(driver, "12/25/2015");
        SearchPage.fillReturnDateTextBox(driver, "12/31/2015");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
