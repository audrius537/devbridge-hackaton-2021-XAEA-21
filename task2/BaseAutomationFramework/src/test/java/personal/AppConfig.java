package personal;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan
@SpringBootConfiguration
public class AppConfig {

    static {
        WebDriverManager.chromedriver().setup();
    }

    @Bean
    @Scope("singleton")
    public WebDriver driver() {
        return new ChromeDriver();
    }

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
