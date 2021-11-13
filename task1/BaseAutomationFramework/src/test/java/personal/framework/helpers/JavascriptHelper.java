package personal.framework.helpers;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PROTECTED;

@Component
public class JavascriptHelper {

    @Autowired
    @Getter(PROTECTED)
    private WebDriver driver;

    public Object execute(String script, Object... objects) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, objects);
    }

    public void scrollIntoView(WebElement element) {
        execute("arguments[0].scrollIntoView()", element);
    }

    public void setValue(WebElement element, String value) {
        execute("arguments[0].value = arguments[1]", element, value);
    }

    public void click(WebElement element) {
        execute("arguments[0].click()", element);
    }
}
