package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoggerUtil;

import java.time.Duration;

/**
 * HomePage class represents the main page of the application.
 * Contains all the elements and actions that can be performed on the home page.
 */
public class HomePage extends BasePage {
    
    public static final String BASE_URL = "https://www.demoblaze.com/";
    private final WebDriver driver;
    
    // ========== Page Elements ==========
    
    // Navigation
    @FindBy(id = "nava")
    private WebElement homeLink;
    
    // Category locator template
    private String categoryLink = "//a[contains(@class, 'list-group-item') and contains(., '%s')]";
    
    // Search
    @FindBy(id = "search2")
    private WebElement searchInput;
    

    
    // Product cards
    @FindBy(className = "card")
    private java.util.List<WebElement> productCards;
    
    // Product link locator template
//    private static final String PRODUCT_LINK_TEMPLATE = "//a[@class='hrefch' and contains(normalize-space(), '%s')]";
    private static final String PRODUCT_LINK_TEMPLATE = "//a[normalize-space()='%s']";

    // ========== Constructor ==========
    
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        LoggerUtil.info("Initialized HomePage");
    }
    
    // ========== Page Actions ==========
    
    /**
     * Navigates to the home page
     * @return HomePage instance for method chaining
     */
    public HomePage navigateTo(String baseUrl) {
        driver.get(baseUrl);
        LoggerUtil.info("Navigated to home page: {}", baseUrl);
        return this;
    }
    
    /**
     * Clicks on a category by name
     * @param categoryName Name of the category to click (Phones, Laptops, or Monitors)
     * @return HomePage instance for method chaining
     */
    public HomePage selectCategory(String categoryName) {
        LoggerUtil.info("Selecting category: {}", categoryName);
        String categoryXpath = String.format(categoryLink, categoryName);
        WebElement categoryElement = driver.findElement(By.xpath(categoryXpath));
        clickElement(categoryElement, categoryName + " category");
        return this;
    }
    
    /**
     * Performs a search for the given term
     * @param searchTerm The term to search for
     * @return HomePage instance for method chaining
     */
    public HomePage searchFor(String searchTerm) {
        LoggerUtil.info("Searching for: {}", searchTerm);
        // Enter search term and press Enter
        enterText(searchInput, searchTerm, "Search input");
        searchInput.sendKeys(org.openqa.selenium.Keys.RETURN);
        return this;
    }
    
    /**
     * Gets the number of products displayed on the page
     * @return Number of product cards
     */
    public int getProductCount() {
        return productCards.size();
    }
    
    /**
     * Clicks on a product with the specified name
     * @param productName The name of the product to select
     */
    public void selectProduct(String productName) {
        String productXpath = String.format(PRODUCT_LINK_TEMPLATE, productName);
        WebElement productLink = driver.findElement(By.xpath(productXpath));
        clickElement(productLink, "Product: " + productName);
    }
    
    // ========== Verification Methods ==========
    
    /**
     * Verifies if the home page is loaded
     * @return true if the home page is loaded, false otherwise
     */
    public boolean isPageLoaded() {
        try {
            return homeLink.isDisplayed();
        } catch (Exception e) {
            LoggerUtil.error("Home page not loaded: {}", e.getMessage());
            return false;
        }
    }
    
    // ========== Private Helper Methods ==========
    
    private void clickElement(WebElement element, String elementName) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            LoggerUtil.debug("Clicked on {}", elementName);
        } catch (Exception e) {
            LoggerUtil.error("Failed to click on {}: {}", elementName, e.getMessage());
            throw e;
        }
    }
    
    private void enterText(WebElement element, String text, String elementName) {
        try {
            waitForElementToBeVisible(element);
            element.clear();
            element.sendKeys(text);
            LoggerUtil.debug("Entered text '{}' in {}", text, elementName);
        } catch (Exception e) {
            LoggerUtil.error("Failed to enter text in {}: {}", elementName, e.getMessage());
            throw e;
        }
    }
    
    private void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
    }
    
    private void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
    }
}
