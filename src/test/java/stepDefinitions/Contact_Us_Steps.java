package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static driver.DriverFactory.getDriver;


public class Contact_Us_Steps  {

    String contactUsUrl = "https://www.webdriveruniversity.com/Contact-Us/contactus.html";

    private WebDriver driver = getDriver();

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    @Given("I access the webdriver university contact us page")
    public void iAccessTheWebdriverUniversityContactUsPage() {
        driver.get(contactUsUrl);
    }

    @When("I enter a unique first name")
    public void iEnterAUniqueFirstName() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }

    @And("I enter a specific email address {word}")
    public void iEnterASpecificEmailAddress(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test" + generateRandomString(10));
    }

    @And("I enter a specific comment {string}")
    public void iEnterASpecificComment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @And("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void iShouldBePresentedWithASuccessfulContactUsSubmissionMessage() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");


    }
}
