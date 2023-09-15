package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class BasePageObject {
    public BasePageObject() {
    }

    //get the driver object
    public WebDriver getDriver(){
        return DriverFactory.getDriver();
    }

    public void navigateToUrl(String url){
        getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

}
