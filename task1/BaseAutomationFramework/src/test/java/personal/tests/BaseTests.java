package personal.tests;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import personal.framework.helpers.ActionsHelper;
import personal.framework.pages.TestPage;

@Getter
@SpringBootTest
public abstract class BaseTests {

    @Value("${testUrl}")
    private String testUrl;

    @Autowired
    private WebDriver driver;

    @Autowired
    private ActionsHelper actionsHelper;

    @Autowired
    private TestPage testPage;
}
