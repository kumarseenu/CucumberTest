package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginStepScenarioOutline {
    WebDriver driver;

    @Given("I navigate to the login page")
    public void userOnLoginPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use headless mode (for Chrome 109+ use --headless=new)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
// Generate a unique user-data-dir for each session
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver(options);
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
