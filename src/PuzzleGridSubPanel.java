import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This is the puzzle portion of the game GUI, which appears in the
 * upper two-thirds of the main window.
 */
public class PuzzleGridSubPanel extends JPanel {

    private GameController gameController;
    private GameWindow parentWindow;
    private ArrayList<Grid> gridList;

    private PuzzleGridSubPanel() {/* prevent uninitialized instances. */}
    public PuzzleGridSubPanel(GameWindow parentWindow) {

        this.parentWindow = parentWindow;
        this.parentWindow.getGameController();
        this.gridList = new ArrayList<>();

        GridLayout gridLayout = new GridLayout(3, 3);
        this.setLayout(gridLayout);
        setUpNewGrids();
    }

    private void setUpNewGrids() {
        gridList.clear();
        int gridNumber = 1;
        for(int row = 1; row < Grid.CELLS_PER_GRID_ROW; row++) {
            for(int col = 1; col < Grid.CELLS_PER_GRID_COL; col++) {
                Grid grid = new Grid(gridNumber, gameController);
                gridList.add(grid);
                gridNumber++;
            }
        }
    }


}
