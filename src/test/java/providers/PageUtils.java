package providers;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import java.util.concurrent.TimeUnit;

import static org.fluentlenium.core.filter.FilterConstructor.withText;

/**
 * Created by Supriya Pawar on 7/05/2017.
 */
public class PageUtils extends FluentPage{

    public void waitForElementVisible(FluentWebElement element) {
        await().atMost(10, TimeUnit.SECONDS).until(element).displayed();
    }

    public void waitForPageToLoad() {
        await().atMost(10, TimeUnit.SECONDS).untilPage().isLoaded();
    }

    public void waitForElementWithTextNoVisible(String text, String element) {
        await().atMost(20, TimeUnit.SECONDS).until($(element, withText().contains(text))).present();
    }

}