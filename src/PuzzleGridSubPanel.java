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
    private MainGameFrame parentWindow;
    private ArrayList<PuzzleGrid> gridList;

    private PuzzleGridSubPanel() {/* prevent uninitialized instances. */}
    public PuzzleGridSubPanel(MainGameFrame parentWindow) throws Exception {
        LoggingUtilities.displayCurrentMethod();
        this.parentWindow = parentWindow;
        this.gameController = parentWindow.getGameController();

        this.gridList = new ArrayList<PuzzleGrid>(9);
        this.setToolTipText("Puzzle Grid Sub Panel");
        this.setBorder(BorderFactory.createLineBorder(Color.green.darker(), 8));

        GridLayout gridLayout = new GridLayout(3, 3);
        this.setLayout(gridLayout);

        setUpNewGrids();

    }

    private void setUpNewGrids() throws Exception {
        LoggingUtilities.displayCurrentMethod();
        gridList.clear();
        int gridNumber = 1;
        for(int row = 1; row <= PuzzleGrid.CELLS_PER_GRID_ROW; row++) {
            for(int col = 1; col <= PuzzleGrid.CELLS_PER_GRID_COL; col++) {
                LoggingUtilities.log( String.format("Setting up new PuzzleGrid number %d for row %d, col %d%n"
                        , gridNumber, row, col) );
                UUID uniqueId = UUID.randomUUID();
                PuzzleGrid grid = new PuzzleGrid(uniqueId, gridNumber, row, col, gameController);
                LoggingUtilities.log( String.format("PuzzleGrid %s%n", grid) );
                boolean add = gridList.add(grid);
                OuterGridSubPanel outerGrid = new OuterGridSubPanel(this, grid,gameController);
                this.add(outerGrid);
                gridNumber++;
            }
        }
    }


}
