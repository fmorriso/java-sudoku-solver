import java.awt.*;
import java.util.ArrayList;

/**
 * The game controller that manages all aspects of the game except the user interface.
 * The idea is to separate the function of the game from any specific user interface,
 * be that a simple console type using a Scanner plus println() or a fancy graphical user interface
 * using Swing.
 */
public class GameController {
    private static final int NUMBER_OF_GRIDS = 9;

    private Dimension scaledSize;

    private ArrayList<Cell> cells;

    public GameController() {
        // be smart about using the available device screen size instead of hard-coding like most people do.d
        final int multipleof = 10;
        scaledSize = SwingScreenUtilities.getScaledSize(0.4, multipleof, true);
    }


    public Dimension getScaledSize() { return scaledSize; }


    public void startNewPuzzle() {
        // create and populate the nine 3 x 3 grids that comprise the current puzzle.


    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public void cellValueChanged(Cell changedCell) {
        //TODO: use the value of the cell that changed to set the
        // allowable values of other cells:
        // 1. in the same 3 x 3 grid (siblings)
        // 2. in the same row of other 3 x 3 grids
        // 3. in the same column of other 3 x 3 grids
    }

}
