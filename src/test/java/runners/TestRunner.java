package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true,
        tags = "@regression"  // Default tag, can be overridden from command line
)
public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);
    private static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        logger.info("=== Test Suite Started ===");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed successfully");
        }
        logger.info("=== Test Suite Completed ===");
    }

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}