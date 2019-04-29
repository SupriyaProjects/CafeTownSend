package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.core.annotation.Page;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import providers.DriverFactory;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import providers.ReportiumHelper;


/**
 * Created by Supriya Pawar on 7/05/2017.
 */

public class LoginSteps extends FluentCucumberTest {

    RemoteWebDriver remoteDriver;
    @Page
    private LoginPage loginPage;

    @Before
    public void before(Scenario scenario) {
        super.before(scenario);
    }

    @After
    public void after(Scenario scenario) {
        super.after(scenario);
    }

    @Override
    public WebDriver newWebDriver() {
        return new DriverFactory().getDriver();
    }

//    public WebDriver newdriver() {
//    try {
//      DesiredCapabilities capabilities = new DesiredCapabilities("chrome", "", Platform.ANY);
//
//      capabilities.setCapability("scriptName", "Qantas-Windows-Test");
//      capabilities.setCapability("platformName", "Windows");
//      capabilities.setCapability("platformVersion", "10");
//      capabilities.setCapability("browserName", "Chrome");
//      capabilities.setCapability("browserVersion", "73");
//      capabilities.setCapability("resolution", "1920x1080");
//      capabilities.setCapability("location", "AP Sydney");
//      capabilities.setCapability("securityToken", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJzbFV4OFFBdjdVellIajd4YWstR0tTbE43UjFNSllDbC1TRVJiTlU1RFlFIn0.eyJqdGkiOiI4ZWQxZTU5MS1iNGY0LTQ5OGUtOGZmMC02YzEyOTViMjE3NzQiLCJleHAiOjAsIm5iZiI6MCwiaWF0IjoxNTU0Njc5NTg2LCJpc3MiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwiYXVkIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJzdWIiOiI4NWZjNDc3OC05NDg4LTQyODQtODcyZC1mNDU2YzUwNjFkNTEiLCJ0eXAiOiJPZmZsaW5lIiwiYXpwIjoib2ZmbGluZS10b2tlbi1nZW5lcmF0b3IiLCJhdXRoX3RpbWUiOjAsInNlc3Npb25fc3RhdGUiOiIzYTQzNTc3MC1jY2U4LTQ2YmEtYjU5Mi1jMTQ1MDI2MTljOTgiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX19.COPHHIusTAGlKZH0Ivj5OFLnIsnhp4ynYeRXAEhd3fgiWsMNWcXq2FPwrYtAt4d0ww0PBRmyoc1e8CHUHcudHA8sv32cCL6RNWZEBMIY_oSiEKVo3LJAg583Uzj4QmqnReSlbEPzylxzGohb0EDOVBn8kPwMYdhSuta1GJjaZRcgBgMZ1rk2jnXAqIfC3Bk4me3_77Y6KVFaan8y2BN2plrE0O75JiGPaqwAADscRNsBjRL3Ny7FBJO4cGIWOuFTUZa97_Yxb9KujQKX5xRKElPUhNBfIBrt1VxaJgZQDl0gzP0SUoVAfHBiS9ayDBnekE8_4fI9DD7h2YkGhe2IEA");
//
//      remoteDriver = new RemoteWebDriver(new URL("https://demo.perfectomobile.com/nexperience/perfectomobile/wd/hub/fast"), capabilities);
//  } catch (MalformedURLException e) {
//     e.printStackTrace();
//    }
//   ReportiumHelper reportiumHelper = new ReportiumHelper(remoteDriver);
//
//   return remoteDriver;
//}

    @Given("^the owner is on the Login Page$")
    public void the_owner_is_on_the_login_page() {
        goTo(loginPage);
    }

    @And("^the owner is logged in$")
    public void the_owner_is_logged_in() {
        loginPage.owner_logs_in_to_cafe_townsend();
    }

}

