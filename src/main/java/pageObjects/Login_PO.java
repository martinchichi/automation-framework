package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GlobalVariables;

public class Login_PO extends BasePageObject {
    String loginUrl = GlobalVariables.WEBDRIVER_UNIVERSITY_HOME_URL + "/Login-Portal/index.html?";

    private @FindBy(id = "text")
    WebElement usernameTextFied;

    private @FindBy(id = "password")
    WebElement passwordTextFied;

    private @FindBy(id = "login-button")
    WebElement loginButton;

    public Login_PO(){
        super();
    }
    public void navigateToWebDriverUniversityLoginPage(){
        navigateToUrl(loginUrl);
    }
    public void setUsername(String username){
        sendKeys(usernameTextFied,username);
    }
    public void setRandomUsername(){
        sendRandomKeys(usernameTextFied, generateRandomNumber(5));
    }
    public void setRandomPassword(){
        sendRandomKeys(passwordTextFied, generateRandomNumber(5));
    }

    public void setPassword(String password){
        sendKeys(passwordTextFied,password);
    }
    public void clickLoginButton(){
        waitForWebElementAndClick(loginButton);
    }
    public void validateSuccesfulLoginMessage(){
        waitForAlertAndValidateText("validation succeeded");
    }

    public void validateUnsuccesfulLoginMessage(){
        waitForAlertAndValidateText("validation failed");
    }






}
