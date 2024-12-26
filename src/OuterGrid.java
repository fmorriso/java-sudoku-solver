import javax.swing.*;
import java.awt.*;

/**
 * This is the GUI component that holds the outer 3 x 3 set of 3 x 3 inner grids
 */
public class OuterGrid extends JPanel {

    private final PuzzleGridSubPanel parentWindow;
    private final PuzzleGrid grid;
    private final GameController gameController;

    public OuterGrid(PuzzleGridSubPanel parentWindow, PuzzleGrid grid, GameController gameController) {
        this.parentWindow = parentWindow;
        this.grid = grid;
        this.gameController = gameController;
        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            InnerGrid innerGrid = new InnerGrid(this, gameController);
        }
    }
}
