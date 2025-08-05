package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestContext {
    private WebDriver driver;
    
    public TestContext() {
        setupDriver();
    }
    
    private void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    
    public WebDriver getDriver() {
        return driver;
    }
    
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
