package runners;

import io.cucumber.testng.CucumberOptions;

/**
 * Test runner for smoke tests.
 * Runs scenarios tagged with @smoke.
 */
@CucumberOptions(
    features = "src/test/java/features",
    glue = {"stepDefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/CucumberTestReport.json"
    },
    tags = "@smoke",
    monochrome = true
)
public class SmokeTestRunner extends TestRunner {
    // Uses all configuration from TestRunner
}
