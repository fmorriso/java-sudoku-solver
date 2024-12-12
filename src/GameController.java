import java.util.ArrayList;

/**
 * The game controller that manages all aspects of the game except the user interface.
 * The idea is to separate the function of the game from any specific user interface,
 * be that a simple console type using a Scanner plus println() or a fancy graphical user interface
 * using Swing.
 */
public class GameController {
    private static final int NUMBER_OF_GRIDS = 9;


    private ArrayList<Grid> puzzle;
    public GameController() {
        // just for documentation purposes
    }

    public void startNewPuzzle() {
        // create and populate the nine 3 x 3 grids that comprise the current puzzle.
        puzzle = new ArrayList<Grid>(NUMBER_OF_GRIDS);
        for (int i = 1; i <= NUMBER_OF_GRIDS; i++) {
            Grid grid = new Grid(i);
            grid.populateGrid();
        }

    }

}