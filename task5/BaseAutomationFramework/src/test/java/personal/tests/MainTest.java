package personal.tests;

import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import personal.framework.util.PathFinder;

public class MainTest extends BaseTests {

    @Autowired
    @Getter
    private PathFinder pathFinder;

    @BeforeAll
    public void beforeAll() {
        getDriver().get(getTestUrl());
    }

    @SneakyThrows
    @Test
    public void test() {
        var stopWatch = new StopWatch("Hackathon Task 4 time tracker");
        stopWatch.start("start test");

        var gridMapping1 = getTestPage()
                .getGridMappingByJs();
        var keyDirections = getPathFinder()
                .getDirections(gridMapping1, gridMapping1.getExecutorStart(), gridMapping1.getKey());
        getActionsHelper()
                .getActions()
                .sendKeys(keyDirections)
                .perform();

        var gridMapping2 = getTestPage()
                .getGridMappingByJs();
        var keyToExitDirections = getPathFinder()
                .getDirections(gridMapping2, gridMapping2.getExecutorStart(), gridMapping2.getExit());
        getActionsHelper()
                .getActions()
                .sendKeys(keyToExitDirections)
                .perform();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        //Score not required for task so not including it in the test runtime.
        String score = getTestPage()
                .getScore()
                .getText();
        System.out.println("score = " + score);

//        Uncomment to verify that key has been picked up and other details.
//        Thread.sleep(30_000);
    }
}
