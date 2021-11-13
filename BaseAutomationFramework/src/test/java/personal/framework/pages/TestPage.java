package personal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * For hackathon just use one page for all selectors.
 */
@Component
public class TestPage extends BasePage {
    private static final By SEARCH_INPUT = By.id("search_query_top");
    private static final By TOP_SELLERS = By.id("best-sellers_block_right");

    public WebElement getSearchInput() {
        return getDriver().findElement(SEARCH_INPUT);
    }

    public WebElement getTopSellers() {
        return getDriver().findElement(TOP_SELLERS);
    }
}
