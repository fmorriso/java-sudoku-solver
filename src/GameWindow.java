import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//
import javax.swing.*;

/**
 * This is the main window of the game.
 */
public class GameWindow extends JFrame {
    private static final int UPPER_PANEL_ROW_SPAN = 8;
    private Dimension scaledSize;
    private GameController gameController;

    public GameController getGameController() { return gameController;}

    private GridBagConstraints gbc = new GridBagConstraints();

    private GameWindow() {/* prevent uninitialized instances */}
    public  GameWindow(String title, GameController gameController){
        super(title);
        this.gameController = gameController;
        this.scaledSize = gameController.getScaledSize();

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


    // 3 of 4 ROWS
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

    // BOTTOM ROW
    private void createGameControlsPanel() {
        PuzzleControlsSubPanel gameControlsSubPanel = new PuzzleControlsSubPanel(this);
        gameControlsSubPanel.setBackground(Color.RED);

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
