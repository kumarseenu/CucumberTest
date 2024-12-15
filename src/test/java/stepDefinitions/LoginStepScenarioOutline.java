package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class LoginStepScenarioOutline {
    WebDriver driver;

    @Given("I navigate to the login page")
    public void userOnLoginPage() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new SafariDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("I enter the username {string} and password {string}")
    public void userEntersCredentials(String username, String password) {
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));
        userName.sendKeys(username);
        passWord.sendKeys(password);
    }

    @And("I clicks on the login button")
    public void iClicksLogin() {
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }

    @Then("I should see {string}")
    public void userRedirectedToDashboard(String expectedMessage) {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl --> "+currentUrl);
        if (!currentUrl.contains(expectedMessage)) {
            throw new AssertionError("User not redirected to dashboard");
        }
        driver.quit();
    }
}
