package personal.framework.pages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.xguzm.pathfinding.grid.GridCell;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ParsedGrid {
    private int[] key;
    private int[] exit;
    private int[] executorStart;

    private GridCell[][] grid;
}
