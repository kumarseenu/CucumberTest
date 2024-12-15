package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions/LoginStep",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunnerHook3 extends AbstractTestNGCucumberTests {
}
