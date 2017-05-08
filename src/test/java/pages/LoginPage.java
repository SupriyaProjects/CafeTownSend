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
    private FluentWebElement usernameElement;
    @FindBy(css = "input[type=\"password\"]")
    private FluentWebElement passwordElement;
    @FindBy(css = "button[type=\"submit\"]")
    private FluentWebElement loginButton;
    @FindBy(css = "#greetings")
    private FluentWebElement greetings;
    @FindBy(css="p.error-message.ng-binding")
    private FluentWebElement errorMessage;

    @Override
    public String getUrl() {
        return townsendurl;
    }

    @Override
    public void isAt() {
        assertThat(window().title()).contains("CafeTownsend-AngularJS-Rails");
    }

    public void owner_logs_in_to_cafe_townsend() {
        waitForElementVisible(usernameElement);
        usernameElement.fill().with("Luke");
        passwordElement.fill().with("Skywalker");
        loginButton.click();
        waitForElementVisible(greetings);
    }

    public void owner_enter_incorrect_username_password(String username, String password) {
        waitForElementVisible(usernameElement);
        usernameElement.fill().with(username);
        passwordElement.fill().with(password);
        loginButton.click();
    }

    public void invalid_error_message()
    {
        waitForElementVisible(errorMessage);
        assertThat(errorMessage.text()).isEqualTo("Invalid username or password!");
    }

    public void validate_the_message()
    {
        waitForElementVisible(errorMessage);
        assertThat(errorMessage.text()).isEqualTo("Invalid username or password!");
    }

    public void verifyOwnerIsLoggedIn(String username)
    {
        waitForElementVisible(greetings);
        assertThat(greetings.text()).isEqualTo("Hello "+username);
    }
}