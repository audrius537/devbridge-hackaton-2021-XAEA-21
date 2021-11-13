package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MusicPage extends Base {
    public static By DRUMS_STAGE = By.cssSelector("section.main-wrapper");
    public static By PIANO_STAGE = By.cssSelector("section#wrap");
    public static By GUITAR_STAGE = By.cssSelector("div.ukulele-model");

    public MusicPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getMusicStage(By element) {
        return getDriver().findElement(element);
    }
}
