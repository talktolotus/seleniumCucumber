import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@menu", dryRun = false, plugin = { "pretty", "html:target/test-cucumber-report.html" })
public class Run {
}

