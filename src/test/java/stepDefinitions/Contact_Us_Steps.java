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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;
    String contactUsUrl = "https://www.webdriveruniversity.com/Contact-Us/contactus.html";

    @Before("@contact-us")
    public void setup() {
        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After("@contact-us")
    public void tearDown() {
        driver.quit();
    }

    public String generateRandomNumber(int length){

        return RandomStringUtils.randomNumeric(length);
    }
    public String generateRandomString(int length){
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

    @And("I enter a unique last name")
    public void iEnterAUniqueLastName() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void iEnterAUniqueEmailAddress() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@mail.com");
    }

    @And("I enter a unique comment")
    public void iEnterAUniqueComment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test" + generateRandomString(10));
    }

    @When("I enter a specific first name {word}")
    public void iEnterASpecificFirstName(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @And("I enter a specific last name {word}")
    public void iEnterASpecificLastName(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @And("I enter a specific email address {word}")
    public void iEnterASpecificEmailAddress(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
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
