package pages;

import config.Configuration;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import providers.PageUtils;

import static org.fluentlenium.assertj.FluentLeniumAssertions.*;

/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class LoginPage extends PageUtils {

    private String townsendurl = Configuration.cafetownsendbaseurl;

    @FindBy(css = "input[type=\"text\"]")
    private FluentWebElement username;
    @FindBy(css = "input[type=\"password\"]")
    private FluentWebElement password;
    @FindBy(css = "button[type=\"submit\"]")
    private FluentWebElement loginButton;
    @FindBy(css = "#greetings")
    private FluentWebElement greetings;

    @Override
    public String getUrl() {
        return townsendurl;
    }

    @Override
    public void isAt() {
        assertThat(window().title()).contains("CafeTownsend-AngularJS-Rails");
    }

    public void owner_logs_in_to_cafe_townsend() {
        waitForElementVisible(username);
        username.fill().with("Luke");
        password.fill().with("Skywalker");
        loginButton.click();
        waitForElementVisible(greetings);
    }

    public static void verifyOwnerIsLoggedIn()  {

    }
}
