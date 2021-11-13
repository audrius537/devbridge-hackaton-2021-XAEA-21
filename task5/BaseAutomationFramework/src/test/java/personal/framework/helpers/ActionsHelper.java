package personal.framework.helpers;

import lombok.Getter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PROTECTED;

@Component
public class ActionsHelper {


    @Autowired
    @Getter(PROTECTED)
    private WebDriver driver;

    public Actions getActions() {
        return new Actions(getDriver());
    }

    public void mouseOverElement(WebElement element) {
        getActions()
                .moveToElement(element)
                .perform();
    }

    public void clickElement(WebElement element) {
        getActions()
                .click(element)
                .perform();
    }

    public void rightClickElement(WebElement element) {
        getActions()
                .contextClick(element)
                .click();
    }

    public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
        getActions()
                .dragAndDrop(sourceElement, targetElement)
                .perform();
    }

    public void dragAndDrop(WebElement sourceElement, int xOffset, int yOffset) {
        getActions()
                .dragAndDropBy(sourceElement, xOffset, yOffset)
                .perform();
    }

    public void doubleClickElement(WebElement element) {
        getActions()
                .moveToElement(element)
                .doubleClick()
                .perform();
    }

    public void clickElementAndReplaceInput(WebElement element, CharSequence... input) {
        getActions()
                .click(element)
                .pause(500)
                .keyDown(Keys.CONTROL)
                .pause(200)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .pause(100)
                .sendKeys(input)
                .perform();
    }


}
