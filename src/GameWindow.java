import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//
import javax.swing.JFrame;

/**
 * This is the main window of the game.
 */
public class GameWindow extends JFrame {
    private static final int UPPER_PANEL_ROW_SPAN = 8;
    private GameController gameController;

    public GameController getGameController() {
        return gameController;
    }

    private final GridBagConstraints gbc = new GridBagConstraints();

    private GameWindow() {/* prevent uninitialized instances */}

    public GameWindow(String title, GameController gameController) {
        super(title);

        this.gameController = gameController;

        Dimension scaledSize = this.gameController.getScaledSize();
        this.setSize(scaledSize);
        this.setPreferredSize(scaledSize);
        this.setMinimumSize(scaledSize);

        //  layout to make a 3-row by 1-column grid
        setLayout(new GridBagLayout());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // puts the JFrame in the middle of the physical screen
        this.setLocationRelativeTo(null);

        createPuzzlePanel();
        createGameControlsPanel();
    }


    /**
     * The upper portion of the main window is devoted to holding the grids of sudoku numbers
     */
    private void createPuzzlePanel() {
        //PuzzlePanel puzzlePanel = new PuzzlePanel(this, gameController);
        PuzzleGridSubPanel puzzlePanel = new PuzzleGridSubPanel(this);
        puzzlePanel.setBackground(Color.BLUE);

        gbc.gridx = 0;       // First column
        gbc.gridy = 0;       // First row

        gbc.gridwidth = 1;   // Occupy one column
        gbc.gridheight = UPPER_PANEL_ROW_SPAN;  // number of rows to span

        gbc.weightx = 1;     // Stretch horizontally
        gbc.weighty = UPPER_PANEL_ROW_SPAN;     // Stretch vertically (relative weight)

        gbc.fill = GridBagConstraints.BOTH; // Fill the entire cell

        getContentPane().add(puzzlePanel, gbc);
    }


    /**
     * The bottom portion of the main window is devoted to holding game controls (mostly buttons).
     */
    private void createGameControlsPanel() {
        PuzzleControlsSubPanel gameControlsSubPanel = new PuzzleControlsSubPanel(this);

        // use the last row of the main window for game control buttons
        gbc.gridx = 0;       // First column
        gbc.gridy = UPPER_PANEL_ROW_SPAN;       // relative (to zero) row

        gbc.gridwidth = 1;   // Occupy one column
        gbc.gridheight = 1;  // Span one row

        gbc.weightx = 1;     // Stretch horizontally
        gbc.weighty = 1;     // Stretch vertically (relative weight)

        gbc.fill = GridBagConstraints.BOTH; // Fill the entire cell

        getContentPane().add(gameControlsSubPanel, gbc);
    }
}
