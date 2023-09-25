package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.GlobalVariables;

public class ContactUs_PO extends BasePageObject{
    String contactUsUrl = GlobalVariables.WEBDRIVER_UNIVERSITY_HOME_URL + "/Contact-Us/contactus.html";

    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstNameField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastNameField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement commentField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submitButton;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement successfulSubmissionMessageText;

    public ContactUs_PO() {
        super();
    }
    public void navigateToWebDriverUniversityContactUsPage(){
        navigateToUrl(contactUsUrl);
    }

    public void setUniqueFirstName(){
        sendRandomKeys(firstNameField,"AutoFN" + generateRandomNumber(5));
    }

    public void setUniqueLastName(){
        sendRandomKeys(lastNameField,"AutoLN" + generateRandomNumber(5));
    }

    public void setUniqueEmailAddress(){
        sendRandomKeys(emailField, "AutoEmail" + generateRandomNumber(10));
    }

    public void setUniqueComment(){
        sendRandomKeys(commentField,"Test" + generateRandomString(10));
    }
    public void setSpecificFirstName(String firstName){
        sendKeys(firstNameField,firstName);
    }
    public void setSpecificLastName(String lastName){
        sendKeys(lastNameField,lastName);
    }
    public void setSpecificEmailAddress(String emailAddress){
        sendKeys(emailField,emailAddress);
    }

    public void setSpecificComment(String comment){
        sendKeys(commentField,comment);
    }
    public void clickOnSubmitButton(){
        waitForWebElementAndClick(submitButton);
    }

    public void validateSuccessfulSubmissionMessageText(){
        waitFor(successfulSubmissionMessageText);
        Assert.assertEquals(successfulSubmissionMessageText.getText(), "Thank You for your Message!");
    }













}
