package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.en.*;
import org.openqa.selenium.safari.SafariDriver;

public class LoginStep {
    WebDriver driver;

    @Given("the user is on the login page")
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

    @When("the user enters valid credentials")
    public void userEntersCredentials() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        username.sendKeys("student");
        password.sendKeys("Password123");
    }

    @And("clicks on the login button")
    public void userClicksLogin() {
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
    }

    @Then("the user should be redirected to the dashboard")
    public void userRedirectedToDashboard() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl --> "+currentUrl);
        if (!currentUrl.contains("logged-in-successfully")) {
            throw new AssertionError("User not redirected to dashboard");
        }
        driver.quit();
    }
}
