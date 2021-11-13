package personal.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class MainTest extends BaseTests {

    @BeforeAll
    public void beforeAll() {
        getDriver().get(getTestUrl());
    }

    @Test
    public void test() {
        getTestPage()
                .getSearchInput()
                .sendKeys("Test" + Keys.ENTER);

        getTestPage()
                .getTopSellers();
    }
}
