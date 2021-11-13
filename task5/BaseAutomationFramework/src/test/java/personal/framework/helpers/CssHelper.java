package personal.framework.helpers;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CssHelper {
    private static final String BACKGROUND_COLOR = "background-color";
    private static final String BORDER_COLOR = "border-color";

    public String getBackgroundColor(WebElement element) {
        return element.getCssValue(BACKGROUND_COLOR);
    }

    public String getBorderColor(WebElement element) {
        return element.getCssValue(BORDER_COLOR);
    }
}
