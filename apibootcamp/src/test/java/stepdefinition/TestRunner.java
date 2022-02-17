package stepdefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue= {"stepdefinition"},monochrome = true,
tags="@tag1"
//strict = true
//dryRun = false
)
public class TestRunner {

}
