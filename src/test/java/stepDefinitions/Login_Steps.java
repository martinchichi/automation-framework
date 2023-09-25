package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasePageObject;
import pageObjects.Login_PO;

public class Login_Steps extends BasePageObject {

    private Login_PO loginPo;

    public Login_Steps(Login_PO loginPo) {
        this.loginPo = loginPo;
    }

    @Given("I access the webdriver university login page")
    public void iAccessTheWebdriverUniversityLoginPage() {
        loginPo.navigateToWebDriverUniversityLoginPage();
    }

    @When("I enter a username {}")
    public void iEnterAUsername(String username) {
        loginPo.setUsername(username);
    }

    @When("I enter a username")
    public void iEnterAUsername() {
        loginPo.setRandomUsername();
    }
    @And("I enter a password {}")
    public void iEnterAPassword(String password) {
        loginPo.setPassword(password);
    }

    @And("I enter a password")
    public void iEnterAPassword() {
        loginPo.setRandomPassword();
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPo.clickLoginButton();
    }

    @Then("I should be presented with the successful login message")
    public void iShouldBePresentedWithTheSuccessfulLoginMessage() {
        loginPo.validateSuccesfulLoginMessage();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void iShouldBePresentedWithTheUnsuccessfulLoginMessage() {
        loginPo.validateUnsuccesfulLoginMessage();
    }

    @Then("I should be presented with the following login validation message {}")
    public void iShouldBePresentedWithTheFollowingLoginValidationMessage(String expectedMessage) {
        waitForAlertAndValidateText(expectedMessage);
    }


}