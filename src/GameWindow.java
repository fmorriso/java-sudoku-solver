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
    private Dimension scaledSize;
    private GameController gameController;
    private PuzzlePanel puzzlePanel;
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

    private void createGameControlsPanel() {

    }

    private void createPuzzlePanel() {
        PuzzlePanel puzzlePanel = new PuzzlePanel(this, gameController);
        puzzlePanel.setBackground(Color.BLUE);
        // puzzle panel takes two out of three rows in the layout
        gbc.gridx = 0;       // First column
        gbc.gridy = 0;       // First row

        gbc.gridwidth = 1;   // Occupy one column
        gbc.gridheight = GridBagConstraints.RELATIVE; // 2;  // Span two rows

        gbc.weightx = 1;     // Stretch horizontally
        gbc.weighty = 2;     // Stretch vertically (relative weight)
        gbc.fill = GridBagConstraints.BOTH; // Fill the entire cell

        getContentPane().add(puzzlePanel, gbc);
    }
}
