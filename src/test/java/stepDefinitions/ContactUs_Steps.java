package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePageObject;
import pageObjects.ContactUs_PO;

public class ContactUs_Steps extends BasePageObject {

    private ContactUs_PO contactUsPo;
    public ContactUs_Steps(ContactUs_PO contactUsPo) {
        this.contactUsPo = contactUsPo;
    }

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        contactUsPo.navigateToWebDriverUniversityContactUsPage();
    }

    @When("I enter a unique first name")
    public void iEnterAUniqueFirstName() {
        contactUsPo.setUniqueFirstName();
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        contactUsPo.setSpecificFirstName(firstName);
    }

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        contactUsPo.setUniqueLastName();
    }

    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        contactUsPo.setSpecificLastName(lastName);
    }

    @And("I enter a specific email address {word}")
    public void iEnterASpecificEmailAddress(String email) {
        contactUsPo.setSpecificEmailAddress(email);
    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        contactUsPo.setUniqueEmailAddress();
    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        contactUsPo.setUniqueComment();
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        contactUsPo.setSpecificComment(comment);
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        contactUsPo.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        contactUsPo.validateSuccessfulSubmissionMessageText();
    }
}
