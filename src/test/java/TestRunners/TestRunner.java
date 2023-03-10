package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"StepsDefinition"},
        plugin = {"html:target/cucumber.html"})
//plugin = {"json:target/cucumber.json"}

public class TestRunner {


}
