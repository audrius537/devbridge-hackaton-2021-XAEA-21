package personal.framework.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import personal.framework.helpers.JavascriptHelper;

import static lombok.AccessLevel.PROTECTED;

@Getter(PROTECTED)
public abstract class BasePage {

    @Autowired
    private JavascriptHelper javascriptHelper;

    @Autowired
    private WebDriver driver;
}
