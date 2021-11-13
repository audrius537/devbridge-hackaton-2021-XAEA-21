package personal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestPage extends BasePage {
    private static final String CELL_BASE = "[data-square='%s']";
    private static final By PIECE = By.cssSelector("[data-piece]");

    public void movePiece(String cellSource, String cellDestination) {
        var start = getCell(cellSource);
        var end = getCell(cellDestination);

        getActionsHelper()
                .getActions()
                .moveToElement(start)
                .clickAndHold()
                .pause(1_000)
                .moveToElement(end)
                .pause(1_000)
                .release()
                .perform();
    }

    public String getDataPiece(String cell) {
        var cellElem = getCell(cell);
        try {
            var piece = getPieceInCell(cellElem);
            return piece.getAttribute("data-piece");
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isPiecePresent(String cell) {
        WebElement cellElem = getCell(cell);
        return isPiecePresent(cellElem);
    }

    public boolean isPiecePresent(WebElement cell) {
        try {
            getPieceInCell(cell);
            return true;
        }  catch (NoSuchElementException e) {
            return false;
        }
    }

    private WebElement getPieceInCell(WebElement cell) {
        return cell.findElement(PIECE);
    }

    public WebElement getCell(String cell) {
        var selector = By.cssSelector(String.format(CELL_BASE, cell));

        return getWaitHelper().waitUntilVisible(selector);
    }
}