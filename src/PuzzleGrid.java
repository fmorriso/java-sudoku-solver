import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Contains the non-GUI information about a single 9 x 9 grid of cells used by the puzzle.
 */
public class PuzzleGrid {
    public static final int CELLS_PER_GRID_ROW = 3;
    public static final int CELLS_PER_GRID_COL = 3;

    private  int gridNumber; // the grid number, 1-9 of this 3 x 3 grid within the parent puzzle
    private  UUID gridUniqueId;
    private ArrayList<Cell> cells;
    private GameController gameController;

    private PuzzleGrid() {/* prevent uninitialized instances */}
    public PuzzleGrid(UUID gridUniqueId, int gridNumber, int row, int col, GameController gameController) {
        LoggingUtilities.displayCurrentMethod();
        this.gridUniqueId = gridUniqueId;
        this.gridNumber = gridNumber;
        this.gameController = gameController;
        cells = new ArrayList<>(9);
    }

    private void InitPuzzleGrid() {

    }

    public UUID getGridUniqueId() {return gridUniqueId;}
    public int getGridNumber() {return gridNumber;}

    @Override
    public String toString() {
        return MessageFormat.format("Grid'{'gridUniqueId={0}, gridNumber={1}, cells={2}'}'"
                , gridUniqueId, gridNumber, cells);
    }


    /**
     * Generates an empty 3 x 3 grid of "empty" (as far as the user is concerned) cells.
     *
     * We also let the Cell know who its parent grid is in case it needs to signal something to that parent grid.
     */
    public void createEmptyGrid() {
        for (int row = 1; row <= CELLS_PER_GRID_ROW; row++) {
            for (int col = 1; col <= CELLS_PER_GRID_COL; col++) {
                // NOTE: we use a value of zero (0) to signify an empty cell in the grid.
                Cell cell = new Cell(row, col, 0, gameController);
                System.out.format("Cell: %s%n", cell);
                cells.add(cell);
                gameController.addCell(cell);
            }
        }
    }

}
