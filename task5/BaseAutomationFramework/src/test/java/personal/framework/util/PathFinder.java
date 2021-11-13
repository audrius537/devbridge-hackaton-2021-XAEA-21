package personal.framework.util;

import org.openqa.selenium.Keys;
import org.springframework.stereotype.Component;
import org.xguzm.pathfinding.grid.GridCell;
import org.xguzm.pathfinding.grid.NavigationGrid;
import org.xguzm.pathfinding.grid.finders.AStarGridFinder;
import org.xguzm.pathfinding.grid.finders.GridFinderOptions;
import personal.framework.pages.ParsedGrid;

import java.util.List;

@Component
public class PathFinder {

    public String getDirections(ParsedGrid parsedGrid, int[] start, int end[]) {
        var current = new int[][]{start};
        var path = getPath(parsedGrid, start, end);
        var res = new StringBuilder();
        path.stream()
                .map(e -> new int[]{e.getX(), e.getY()})
                .forEach(e -> {
                    res.append(getActionKey(current[0], e));
                    current[0] = e;
                });

        return res.toString();
    }

    private Keys getActionKey(int[] current, int[] next) {
        var yDiff = current[0] - next[0];

        if (yDiff == -1) {
            return Keys.DOWN;
        } else if (yDiff == 1) {
            return Keys.UP;
        }

        var xDiff = current[1] - next[1];
        if (xDiff == -1) {
            return Keys.RIGHT;
        } else {
            return Keys.LEFT;
        }
    }

    public List<GridCell> getPath(ParsedGrid parsedGrid, int[] start, int end[]) {
        NavigationGrid<GridCell> navGrid = new NavigationGrid(parsedGrid.getGrid());

        var options = new GridFinderOptions();
        options.allowDiagonal = false;
        AStarGridFinder<GridCell> finder = new AStarGridFinder(GridCell.class, options);

        return finder.findPath(start[0], start[1], end[0], end[1], navGrid);
    }
}
