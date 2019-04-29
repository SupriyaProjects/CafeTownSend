package providers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class DriverFactory {

    protected static WebDriver driver;
    RemoteWebDriver remoteDriver;


    public DriverFactory() {
        initialize();
    }

    public void initialize() {
        if (driver == null)
            createNewDriverInstance();
    }
    private WebDriver createNewDriverInstance() {
        try {
        DesiredCapabilities capabilities = new DesiredCapabilities("chrome", "", Platform.ANY);

            capabilities.setCapability("securityToken", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJzbFV4OFFBdjdVellIajd4YWstR0tTbE43UjFNSllDbC1TRVJiTlU1RFlFIn0.eyJqdGkiOiJlNmQ4MTM2YS04N2ViLTQ2NzQtODdiMC0wZTdlNmZkNDBjOWIiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTU1MzE0NDQwLCJpc3MiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJzdWIiOiJjNTBmMWM2OC0yZmExLTQ1MTktYjFkOC01M2QzZjFmOWI3M2YiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiJiODJhOGU3Mi1mNWRjLTRiMjctYWZmZi05Mzc0YmMzYTJmOTIiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX19.fyIqLafM0x0Qs8UYrKNIy6ULBhrPagVPVpAKVJZqUpFpkk0RuxtLuf-IVWqQI_4Qwn8l9agdky05auE_ylX5syHklN7nmFl36woeVImyTK-FUZBF__nPJhVHpuTGYhYGts2JGDpv5qR-qDrOKGMPW8P4v1Tt9k8jCZVyQWdrPgAe5HqmILoAoE3abdFtJovVaEF8kfW5pkNEEX9-WTDhACjr4_Q550QXRwNQnXMFNVsCxdNQQjMaZZRWE8M_CCaG3y8z1MyOj-2yycHioSHKhFiZt1OPjDrDaxckCsJXZHKJ4CZnwmqVGagAffq1Ucw1p9rQCb_3dSEawY6IAA_Uag");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("platformVersion", "10");
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "73");
            capabilities.setCapability("resolution", "1280x1024");
            capabilities.setCapability("location", "AP Sydney");
            capabilities.setCapability("scriptName", "Qantas-Windows-Test Supriya ");
            remoteDriver = new RemoteWebDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/fast"), capabilities);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    ReportiumHelper reportiumHelper = new ReportiumHelper(remoteDriver);
        return remoteDriver;
}
//        System.setProperty("webdriver.chrome.driver", "src/test/java/lib/chromedriver");
//        HashMap<String, Object> chromeOptions = new HashMap<String, Object>();
//        chromeOptions.put("binary", "/Applications/Google\\ Chrome.app/Contents/MacOS/Google\\ Chrome");
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        driver = new ChromeDriver();
//    }
    public WebDriver getDriver() {
        return driver;
    }
    public void destroyDriver() {
        driver.quit();
        driver = null;
    }

}
