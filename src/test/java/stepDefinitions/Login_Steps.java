package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.BasePageObject;

public class Login_Steps extends BasePageObject {

    String loginUrl = "https://www.webdriveruniversity.com/Login-Portal/index.html?";

    private WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void iAccessTheWebdriverUniversityLoginPage() {
        navigateToUrl(loginUrl);
    }

    @When("I enter a username {}")
    public void iEnterAUsername(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @When("I enter a username")
    public void iEnterAUsername() {
        driver.findElement(By.id("text")).sendKeys(generateRandomString(5));
    }

    @And("I enter a password {}")
    public void iEnterAPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I enter a password")
    public void iEnterAPassword() {
        driver.findElement(By.id("password")).sendKeys(generateRandomString(5));
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with the successful login message")
    public void iShouldBePresentedWithTheSuccessfulLoginMessage() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void iShouldBePresentedWithTheUnsuccessfulLoginMessage() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
    }

    @Then("I should be presented with the following login validation message {}")
    public void iShouldBePresentedWithTheFollowingLoginValidationMessage(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedMessage);
    }


}