package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    /*Driver Factory class enables to create driver objet and execute test on different browsers,
    overcome the hooks issues (as it is not possible to extend a class with cucumber hooks)*/
public class DriverFactory {
        public static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/main/java/properties/config.properties";

        /*This 'webDriver' variable stores a WebDriver instance specific to each test thread.
         It helps prevent conflicts between threads when running tests in parallel.*/
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    /* This 'getDriver' method retrieves the WebDriver instance specific to the current test thread.
     If no instance exists, it creates one using the 'createDriver' method.*/
    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }
        /*This 'createDriver' method initializes and configures a WebDriver instance based on the selected browser type.
         It sets up either a Chrome or Firefox WebDriver, maximizes the browser window, and returns the driver instance.*/
    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
         /*This 'getBrowserType' method retrieves the selected browser type from a configuration file.
         It reads the 'browser' property from the configuration file and returns it as a lowercase string.*/
    private static String getBrowserType() {
        String browserType = null;
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty(CONFIG_FILE_PATH));
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }
        /* The 'cleanUpDriver' method is responsible for cleaning up and quitting the WebDriver instance.
         It ensures that the WebDriver is properly terminated and removes it from the ThreadLocal storage.*/
    public static void cleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

}

