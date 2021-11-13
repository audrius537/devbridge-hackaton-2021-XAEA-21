package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainTests extends BaseTest {
    private Robot robot;

    {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initPages();
        driver.get(URL);
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @SneakyThrows
    @Test
    public void playSong() {
        driver.get("https://codepen.io/VIP_vip/pen/QWMVeaM");
        Thread.sleep(3_000);
        driver.switchTo().frame("CodePen");
        new Actions(driver).click(musicPage.getMusicStage(musicPage.DRUMS_STAGE))
                .perform();
        sendKeys("jjj");

        playDrums();
     //   playDrums();

        driver.get("https://codepen.io/CoolS2/pen/EdPxyz");

        driver.switchTo().frame("CodePen");

        new Actions(driver).click(musicPage.getMusicStage(musicPage.GUITAR_STAGE))
                .perform();
        playGuitar();
        playGuitar();

        driver.get("https://codepen.io/gabrielcarol/pen/rGeEbY");

        driver.switchTo().frame("CodePen");
        new Actions(driver).click(musicPage.getMusicStage(musicPage.PIANO_STAGE))
                .perform();

        playPiano();
    }

    @SneakyThrows
    public void playDrums() {
        String cmd = "vv";

        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(400);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_K);
        Thread.sleep(500);

        sendKeys(cmd);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(400);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_K);
        Thread.sleep(500);

        sendKeys(cmd);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_K);
        Thread.sleep(500);

        sendKeys(cmd);

        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_K);
        Thread.sleep(300);

        sendKeys("vvv");

        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_K);
        Thread.sleep(400);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_K);
    }

    @SneakyThrows
    public void playPiano() {
        String cmd = "aagghhgffddssa";
        sendKeys(cmd);
        Thread.sleep(100);
    }

    @SneakyThrows
    public void playGuitar() {
        new Actions(driver).click(driver.findElement(By.xpath("//*[text()='B']")))
                .perform();

        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_DOWN);

        new Actions(driver).click(driver.findElement(By.xpath("//*[text()='C']")))
                .perform();

        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_DOWN);

        new Actions(driver).click(driver.findElement(By.xpath("//*[text()='A']")))
                .perform();

        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_UP);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_DOWN);

        new Actions(driver).click(driver.findElement(By.xpath("//*[text()='G']")))
                .perform();

        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_UP);

    }

    @SneakyThrows
    public void sendKeys(String cmds) {
        for (char c : cmds.toCharArray()) {
            sendKey(c);
            Thread.sleep(100);
        }
    }

    @SneakyThrows
    private void sendKey(char ch) {
        int keyEvent = -1;
        switch (ch) {
            case 'v':
                keyEvent = KeyEvent.VK_V;
                break;
            case 'b':
                keyEvent = KeyEvent.VK_B;
                break;
            case 'e':
                keyEvent = KeyEvent.VK_E;
                break;
            case 'd':
                keyEvent = KeyEvent.VK_D;
                break;
            case 'c':
                keyEvent = KeyEvent.VK_C;
                break;
            case 'g':
                keyEvent = KeyEvent.VK_G;
                break;
            case 'a':
                keyEvent = KeyEvent.VK_A;
                break;
            case 'h':
                keyEvent = KeyEvent.VK_H;
                break;
            case 'j':
                keyEvent = KeyEvent.VK_J;
                break;
            case 'f':
                keyEvent = KeyEvent.VK_F;
                break;
            case 's':
                keyEvent = KeyEvent.VK_S;
                break;
        }
        robot.keyPress(keyEvent);
        Thread.sleep(500);
        robot.keyRelease(keyEvent);
    }
}
