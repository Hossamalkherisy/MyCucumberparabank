package stepsDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue={"stepsDefinitions"},
plugin = { "pretty", "html:target/site/cucumber-pretty/Reports.html","json:target/cucumber.json" },
monochrome = true

)
public class RuneerCucumberTest {

}
