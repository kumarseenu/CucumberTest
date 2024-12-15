package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",         // Path to your feature files
        glue = "stepDefinitions",                         // Path to your step definition classes
        tags = "@Sanity or @Smoke",                  // Tags to filter tests
        plugin = {"pretty", "html:target/cucumber-reports"} // Report generation
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
}
