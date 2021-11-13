package org.example;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTests extends BaseTest {

    @BeforeAll
    public static void beforeAll() {
        initDriver();
        initDriver2();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
        driver2.quit();
    }

    @SneakyThrows
    @Test
    public void strategy1() {
        Thread.sleep(3000);
        By redLetterToNavigate = By.cssSelector("span.t-red");
        driver.findElement(redLetterToNavigate).click();
        driver2.findElement(redLetterToNavigate).click();

        Thread.sleep(6000);
        driver.findElement(By.cssSelector("span#talknwatch")).click();
        driver2.findElement(By.cssSelector("span#talknwatch")).click();

        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#speedmenubase"))).build().perform();
        driver.findElements(By.cssSelector("#speedmenu span.menuitem")).get(5).click();

        Actions action2 = new Actions(driver2);
        action2.moveToElement(driver2.findElement(By.cssSelector("#speedmenubase"))).build().perform();
        driver2.findElements(By.cssSelector("#speedmenu span.menuitem")).get(5).click();

        driver.findElement(By.cssSelector("input#cbinputbox")).sendKeys("Hi!");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div#cbsayit")).click();

        Thread.sleep(2000);
        for(int i = 0; i < 25; i++){
            copyAnswer(driver, driver2, wait);
            copyAnswer(driver2, driver, wait2);
        }
    }

    @SneakyThrows
    public void copyAnswer(WebDriver driverToCopyFrom, WebDriver driverToCopyTo, WebDriverWait waiter) {
        waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span#cblineAnim")));
        WebElement lastAnswerSpan = driverToCopyFrom.findElement(By.cssSelector("span#cblineAnim"));
        String lastAnswer = (lastAnswerSpan.findElement(By.xpath("..")).getText()).substring(4);
        driverToCopyTo.findElement(By.cssSelector("input#cbinputbox")).sendKeys(lastAnswer);
        Thread.sleep(200);
        driverToCopyTo.findElement(By.cssSelector("div#cbsayit")).click();
        Thread.sleep(1000);
    }
}
