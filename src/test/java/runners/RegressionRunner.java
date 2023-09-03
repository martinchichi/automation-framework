package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        tags = "@regression", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/login.htm", "json:target/login.json"})
public class RegressionRunner extends AbstractTestNGCucumberTests {
}


