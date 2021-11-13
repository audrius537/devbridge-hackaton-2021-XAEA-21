package personal.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.xguzm.pathfinding.grid.GridCell;

@Component
public class TestPage extends BasePage {
    private static final By ROW = By.cssSelector("#maze > div");
    private static final By CELL = By.tagName("div");
    private static final By SCORE = By.id("maze_score");

    private static final String WALL = "wall";
    private static final String KEY = "key";
    private static final String EXIT = "exit";
    private static final String EXECUTOR = "hero";

    public ParsedGrid getGridMappingByJs() {
        int rowIndex = 0;
        int cellIndex = 0;

        var parsedGrid = new ParsedGrid();

        var cells = getJavascriptHelper().getMazeCellClasses();
        int height = cells.size();
        parsedGrid.setGrid(new GridCell[height][]);

        for (var row : cells) {
            parsedGrid.getGrid()[rowIndex] = new GridCell[row.size()];

            cellIndex = 0;
            for (var aClass : row) {

                GridCell parsedCell = new GridCell(rowIndex, cellIndex, !aClass.contains(WALL));
                if (aClass.contains(KEY)) {
                    parsedGrid.setKey(new int[]{rowIndex, cellIndex});
                } else if (aClass.contains(EXIT)) {
                    parsedGrid.setExit(new int[]{rowIndex, cellIndex});
                } else if (aClass.contains(EXECUTOR)) {
                    parsedGrid.setExecutorStart(new int[]{rowIndex, cellIndex});
                }

                parsedGrid.getGrid()[rowIndex][cellIndex] = parsedCell;

                cellIndex++;
            }
            rowIndex++;
        }

        return parsedGrid;
    }

    public WebElement getScore() {
        return getDriver().findElement(SCORE);
    }

//    public ParsedGrid getGridMapping() {
//        int rowIndex = 0;
//        int cellIndex = 0;
//
//        var parsedGrid = new ParsedGrid();
//
//        var cells = getCells();
//        int height = cells.size();
//        parsedGrid.setGrid(new GridCell[height][]);
//
//        for (List<WebElement> row : cells) {
//            parsedGrid.getGrid()[rowIndex] = new GridCell[row.size()];
//
//            cellIndex = 0;
//            for (WebElement cell : row) {
//
//                String aClass = cell.getAttribute("class");
//                GridCell parsedCell = new GridCell(rowIndex, cellIndex, !aClass.contains(WALL));
//                if (aClass.contains(KEY)) {
//                    parsedGrid.setKey(new int[]{rowIndex, cellIndex});
//                } else if (aClass.contains(EXIT)) {
//                    parsedGrid.setExit(new int[]{rowIndex, cellIndex});
//                } else if (aClass.contains(EXECUTOR)) {
//                    parsedGrid.setExecutorStart(new int[]{rowIndex, cellIndex});
//                }
//
//                parsedGrid.getGrid()[rowIndex][cellIndex] = parsedCell;
//
//                cellIndex++;
//            }
//            rowIndex++;
//        }
//
//        return parsedGrid;
//    }

//    public List<List<WebElement>> getCells() {
//        return getRows()
//                .stream()
//                .map(e -> e.findElements(CELL))
//                .collect(Collectors.toList());
//    }
//
//    public List<WebElement> getRows() {
//        getWaitHelper().waitUntilVisible(ROW);
//
//        return getDriver().findElements(ROW);
//    }

}
