package personal.tests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class MainTest extends BaseTests {

    static {
        System.setProperty("java.awt.headless", "false");
    }

    @BeforeAll
    public void beforeAll() {
        getDriver().get(getTestUrl());
        getDriver()
                .manage()
                .window()
                .maximize();
    }

    @SneakyThrows
    @Test
    public void test() {
        getTestPage()
                .getPlayBtn()
                .click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_LEFT);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_LEFT);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                getActionsHelper()
                        .getActions()
                        .sendKeys(Keys.SPACE)
                        .pause(10)
                        .perform();
            }

            try {
                String score = getTestPage()
                        .getWinnerScreenScore()
                        .getText();
                System.out.println("score = " + score);
                break;
            } catch (NoSuchElementException ignored) { }
        }
    }
}
