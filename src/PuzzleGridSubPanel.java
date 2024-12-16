import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PuzzleGridSubPanel extends JPanel {

    private GameController gameController;
    private JPanel parentPanel;
    private ArrayList<Grid> gridList;

    public PuzzleGridSubPanel(GameController gameController, JPanel parentPanel) {
        this.gameController = gameController;
        this.parentPanel = parentPanel;
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
                Grid grid = new Grid(gridNumber);
                gridList.add(grid);
                gridNumber++;
            }
        }
    }

    private PuzzleGridSubPanel() {/* prevent uninitialized instances. */}
}
