package personal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class TestPage extends BasePage {
    private static final By PLAY_BTN = By.cssSelector("#splashScreen a");
    private static final By WINNER_SCREEN_SCORE = By.cssSelector("#winnerScreen h3");

    public WebElement getPlayBtn() {
        return getWaitHelper().waitUntilVisible(PLAY_BTN);
    }

    public WebElement getWinnerScreenScore() {
        return getDriver()
                .findElement(WINNER_SCREEN_SCORE);
    }
}
