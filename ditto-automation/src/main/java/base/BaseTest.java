package base;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void initReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/DittoAutomationReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeClass
    @Parameters({"headless"})
    public void setup(@Optional("false") String headless) {

        WebDriverManager.chromedriver().setup();

        // Setup ChromeOptions
        ChromeOptions options = new ChromeOptions();

        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");   // modern headless mode
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            System.out.println("Running in HEADLESS mode...");
        } else {
            System.out.println("Running in NORMAL mode...");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) extent.flush();
    }
}
