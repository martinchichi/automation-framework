package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {
    private WebDriver driver;
    String loginUrl = "https://www.webdriveruniversity.com/Login-Portal/index.html?";

    @Before("@login")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the webdriver university login page")
    public void iAccessTheWebdriverUniversityLoginPage() {
        driver.get(loginUrl);
    }

    @When("I enter a username {string}")
    public void iEnterAUsername(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @When("I enter a username")
    public void iEnterAUsername() {
        driver.findElement(By.id("text")).sendKeys(generateRandomString(9));
    }

    @And("I enter a password {}")
    public void iEnterAPasswordWebdriver(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I enter a password")
    public void iEnterAPassword() {
        driver.findElement(By.id("password")).sendKeys(generateRandomString(9));
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the successful login message")
    public void iShouldBePresentedWithTheSuccessfulLoginMessage() {
//        Duration timeoutDuration = Duration.ofSeconds(5);
//        WebDriverWait wait = new WebDriverWait(driver,timeoutDuration);
//        wait.until(ExpectedConditions.alertIsPresent());
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");

    }

    @Then("I should be presented with the unsuccessful login message")
    public void iShouldBePresentedWithTheUnsuccessfulLoginMessage() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
    }


}
