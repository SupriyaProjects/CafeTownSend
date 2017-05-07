import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Supriya Pawar on 6/05/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/")
public class RunFeatures {
}
