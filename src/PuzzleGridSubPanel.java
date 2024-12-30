import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This is the puzzle portion of the game GUI, which appears in the
 * upper two-thirds of the main window.
 */
public class PuzzleGridSubPanel extends JPanel {

    private GameController gameController;
    private GameWindow parentWindow;
    private ArrayList gridList;

    private PuzzleGridSubPanel() {/* prevent uninitialized instances. */}
    public PuzzleGridSubPanel(GameWindow parentWindow) {

        this.parentWindow = parentWindow;
        this.parentWindow.getGameController();
        this.gridList = new ArrayList<PuzzleGrid>();

        /* TODO: why does turning on this code mess up the Puzzle Grid layout?
        GridLayout gridLayout = new GridLayout(3, 3);
        this.setLayout(gridLayout);
        setUpNewGrids();
        */
    }

    private void setUpNewGrids() {
        gridList.clear();
        int gridNumber = 1;
        for(int row = 1; row < PuzzleGrid.CELLS_PER_GRID_ROW; row++) {
            for(int col = 1; col < PuzzleGrid.CELLS_PER_GRID_COL; col++) {
                UUID uniqueId = UUID.randomUUID();
                PuzzleGrid grid = new PuzzleGrid(uniqueId, gridNumber, row, col, gameController);
                gridList.add(grid);
                OuterGrid outerGrid = new OuterGrid(this, grid,gameController);
                this.add(outerGrid);

                gridNumber++;
            }
        }
    }


}
