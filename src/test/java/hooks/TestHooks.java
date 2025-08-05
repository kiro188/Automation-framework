package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContext;

public class TestHooks {
    private final TestContext testContext;

    public TestHooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take a screenshot if the scenario fails
            byte[] screenshot = ((TakesScreenshot) testContext.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        testContext.closeDriver();
    }
}
