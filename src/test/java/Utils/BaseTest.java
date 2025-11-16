package Utils;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // get the System Property
        String browser = System.getProperty("browser");
        String grid_enable_status = System.getProperty("selenium.grid.enabled");
        System.out.println("Browser is "+browser+ " grid_enable_status is "+grid_enable_status);
        Capabilities capabilities;
        if(browser.equalsIgnoreCase("chrome")){
            capabilities = new ChromeOptions();
        }else{
            capabilities = new FirefoxOptions();
        }
        if(grid_enable_status.equalsIgnoreCase("true")){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        }else{
            driver = new ChromeDriver();
        }
        driver.get("https://www.saucedemo.com"); // Replace with your practice website URL
    }

//    @BeforeMethod
//    public void setUp() throws MalformedURLException {
//        // Initialize the WebDriver
////        driver = new SafariDriver();
////        driver.manage().window().maximize();
////        driver.get("https://www.saucedemo.com"); // Replace with your practice website URL
//
////        System.setProperty("selenium.trace.openTelemetry", "false");
////        System.setProperty("selenium.trace", "false");
////        Capabilities capabilities = new ChromeOptions();
//        Capabilities capabilities = new FirefoxOptions();
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
//
//
////        driver.manage().window().maximize();
//        driver.get("https://www.saucedemo.com"); // Replace with your practice website URL
//    }


    @AfterMethod
    public void tearDown() {
        // Close the browser after test execution
        if (driver != null) {
            driver.quit();
        }
    }
}
