package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"classpath:features"}, glue = {"stepDefinitions"},
        tags = "", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber.htm", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
/* This method overrides the "scenarios" method and enables parallel test execution
 by using the "@DataProvider" annotation. It provides test data and returns the
 data obtained from the superclass's "scenarios" method.*/
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}


