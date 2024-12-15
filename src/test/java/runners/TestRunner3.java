package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",  // Path to your feature files
        glue = "stepDefinitions",                  // Path to your step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports",        // HTML report
                "json:target/cucumber.json",           // JSON report for Allure
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // Allure plugin
        }
)
public class TestRunner3 extends AbstractTestNGCucumberTests {
}
