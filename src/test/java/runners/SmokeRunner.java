package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        tags = "@smoke", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/login.htm", "json:target/login.json"})
public class SmokeRunner extends AbstractTestNGCucumberTests {
}


