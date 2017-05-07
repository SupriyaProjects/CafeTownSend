import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Supriya Pawar on 6/05/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/",
        format = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"}, tags = {"@test"})
public class RunCukesTest {
}
