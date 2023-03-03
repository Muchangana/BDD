package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\ilabadmin\\Desktop\\BDD_Final\\src\\test\\java\\Features"},
        glue = {"StepDefinitions"},
        plugin = {"html:target/cucumber.html"}
)

public class TestRunner {


}
