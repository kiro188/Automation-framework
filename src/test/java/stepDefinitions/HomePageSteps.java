package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import pages.HomePage;
import testdata.TestProducts;
import utils.TestContext;
import utils.LoggerUtil;

import static org.testng.Assert.assertTrue;
import static pages.HomePage.BASE_URL;

public class HomePageSteps {

    private final TestContext context;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        this.context = context;
        this.homePage = new HomePage(context.getDriver());
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        LoggerUtil.info("Navigating to home page: {}", BASE_URL);
        homePage.navigateTo(BASE_URL);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page did not load successfully");
    }

    @Then("I should see the home page elements")
    public void i_should_see_the_home_page_elements() {
        LoggerUtil.info("Verifying home page elements are displayed");
        Assert.assertTrue(homePage.isPageLoaded(), "Home page elements are not displayed");
    }

    @When("I select the {string} category")
    public void i_select_the_category(String categoryName) {
        homePage.selectCategory(categoryName);
    }

    @When("I select the product {string}")
    public void i_select_the_product(String productName) {
        // Handle both direct string and TestProducts constant references
        String actualProductName = productName;
        if (productName.startsWith("SAMSUNG_GALAXY_S6")) {
            actualProductName = TestProducts.SAMSUNG_GALAXY_S6;
        }
        LoggerUtil.info("Selecting product: {}", actualProductName);
        homePage.selectProduct(actualProductName);
    }

    @Then("I should see products in the {string} category")
    public void i_should_see_products_in_the_category(String category) {
        LoggerUtil.info("Verifying products in {} category are displayed", category);
        int productCount = homePage.getProductCount();
        Assert.assertTrue(productCount > 0, "No products found in " + category + " category");
        LoggerUtil.info("Found {} products in {} category", productCount, category);
    }

    @Then("I should see search results containing {string}")
    public void i_should_see_search_results_containing(String searchTerm) {
        LoggerUtil.info("Verifying search results for: " + searchTerm);
        int productCount = homePage.getProductCount();
        Assert.assertTrue(productCount > 0, "No search results found for: " + searchTerm);
        LoggerUtil.info("Found " + productCount + " search results for: " + searchTerm);
    }

    @Then("I should see Add to Cart button")
    public void i_should_see_add_to_cart_button() {
        LoggerUtil.info("Verifying Add to Cart button is displayed");
        assertTrue(homePage.isAddToCartButtonDisplayed(), "Add to Cart button is not displayed");
    }

    @And("I select the Add to Cart button")
    public void i_select_the_add_to_cart_button() {
        LoggerUtil.info("Selecting Add to Cart button");
        homePage.selectAddToCartButton();
    }

    @Then("^I should see \"([^\"]*)\" alert$")
    public void i_should_see_alert(String expectedMessage) {
        LoggerUtil.info("Verifying alert with message: {}", expectedMessage);
        homePage.verifyAndAcceptAlert(expectedMessage);
    }
}
