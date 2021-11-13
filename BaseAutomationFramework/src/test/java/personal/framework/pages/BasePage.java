package personal.framework.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import personal.framework.helpers.ActionsHelper;
import personal.framework.helpers.CssHelper;

import static lombok.AccessLevel.PROTECTED;

@Getter(PROTECTED)
public abstract class BasePage {

    @Autowired
    private WebDriver driver;

    @Autowired
    private CssHelper cssHelper;

    @Autowired
    private ActionsHelper actionsHelper;
}
