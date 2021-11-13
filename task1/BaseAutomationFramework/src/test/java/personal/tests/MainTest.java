package personal.tests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends BaseTests {

    @BeforeAll
    public void beforeAll() {
        getDriver().get(getTestUrl());
        getDriver().manage().window().maximize();
    }

    @AfterEach
    public void afterEach() {
        getDriver()
                .navigate()
                .refresh();
    }

    @SneakyThrows
    @RepeatedTest(10)
    public void test() {
        move("e2", "e4");
        move("e4", "e5");
        move("e5", "e6");
        move("d1", "f3");

        if (!isPawnOnE6()) {
            move("f1", "c4");
        }
        moveQueenFFile();

        handleAlert();
    }

    @SneakyThrows
    private void handleAlert() {
        Thread.sleep(3000);
        var alert = getDriver()
                .switchTo()
                .alert();
        String actualMessage = alert.getText();
        assertEquals("Checkmate!", actualMessage);
        alert.accept();

    }

    private boolean isPawnOnE6() {
        return getTestPage().getDataPiece("e6").equals("wP");
    }

    private void moveQueenFFile() {
        int lastIndex = 3;

        int next = lastIndex;
        do {
            next++;
            System.out.println("lastIndex = " + lastIndex);
            System.out.println("next = " + next);

            if (getTestPage().isPiecePresent("f" + next)) {
                move("f" + lastIndex, "f" + next);
                lastIndex = next;
            } else if (next == 7) {
                move("f" + lastIndex, "f7");
            }
        } while (next < 7);
    }

    @SneakyThrows
    private void move(String cellSource, String cellDestination) {
        getTestPage()
                .movePiece(cellSource, cellDestination);
        Thread.sleep(1000);
    }
}
