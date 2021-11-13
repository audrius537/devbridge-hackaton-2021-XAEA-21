package personal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class FacebookLoginScreenPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("email");

    public WebElement getEmailInput() {
        return getDriver().findElement(EMAIL_INPUT);
    }
}
