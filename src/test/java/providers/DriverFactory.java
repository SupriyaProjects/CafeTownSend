package providers;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class DriverFactory {

    protected WebDriver driver;

    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }
    private void createNewDriverInstance() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/lib/chromedriver");
        HashMap<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("binary", "/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public void destroyDriver() {
        driver.quit();
        driver = null;
    }

}
