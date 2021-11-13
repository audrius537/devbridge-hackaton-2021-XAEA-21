package personal.framework.helpers;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PROTECTED;

@Component
@Getter(PROTECTED)
public class WaitHelper {

    @Autowired
    private WebDriver driver;

    @Value("${default.wait.seconds}")
    private int defaultWaitSeconds;

    public WebDriverWait getDefaultWait() {
        return new WebDriverWait(getDriver(), getDefaultWaitSeconds());
    }

    public WebElement waitUntilVisible(By selector) {
        return waitUntilVisible(selector, getDefaultWait());
    }

    public WebElement waitUntilVisible(By selector, WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public void waitUntilClickable(WebElement element) {
        waitUntilClickable(element, getDefaultWait());
    }

    public void waitUntilClickable(WebElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
