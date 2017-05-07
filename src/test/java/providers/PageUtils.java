package providers;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import java.util.concurrent.TimeUnit;

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

    public void waitForTextVisible(String text, FluentWebElement element) {
        await().atMost(10, TimeUnit.SECONDS).until(element).displayed();
    }

}
