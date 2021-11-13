package personal.framework.helpers;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static lombok.AccessLevel.PROTECTED;

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
