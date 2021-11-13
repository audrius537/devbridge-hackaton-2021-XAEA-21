package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {
    private static final int WAIT_VALUE = 20;

    protected static WebDriver driver;
    protected static WebDriver driver2;

    protected static WebDriverWait wait;
    protected static WebDriverWait wait2;

    protected static String URL = "https://www.cleverbot.com/";

    protected static void initDriver() {
        var chromeDriverPath = "drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("debuggerAddress", "localhost:9668");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, WAIT_VALUE);
        driver.get(URL);
    }

    protected static void initDriver2() {
        var chromeDriverPath = "drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("debuggerAddress", "localhost:9669");
        driver2 = new ChromeDriver(chromeOptions);
        wait2 = new WebDriverWait(driver2, WAIT_VALUE);
        driver2.get(URL);
    }
}




