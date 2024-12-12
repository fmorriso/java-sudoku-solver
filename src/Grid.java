import java.util.ArrayList;

/**
 * Contains the information about a single 9 x 9 grid of cells used by the puzzle.
 */
public class Grid {
    private static final int CELLS_PER_GRID_ROW = 3;
    private static final int CELLS_PER_GRID_COL = 3;

    public int getGridNumber() { return gridNumber; }

    private int gridNumber; // the grid number, 1-9 of this 3 x 3 grid within the parent puzzle
    private ArrayList<Cell> cells;

    public Grid(int gridNumber) {
        this.gridNumber = gridNumber;
        cells = new ArrayList<>(9);
    }


    @Override
    public String toString() {
        return "Grid{" +
                "gridNumber=" + gridNumber +
                ", cells=" + cells +
                '}';
    }

    public void createEmptyGrid() {
        for (int row = 1; row <= CELLS_PER_GRID_ROW; row++) {
            for (int col = 1; col <= CELLS_PER_GRID_COL; col++) {
                // NOTE: we use a value of zero (0) to signify an empty cell in the grid.
                Cell cell = new Cell(row, col, 0, this);
                cells.add(cell);
            }
        }
    }

}
