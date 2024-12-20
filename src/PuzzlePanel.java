import java.awt.Dimension;
import java.awt.GridLayout;
//
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PuzzlePanel extends JPanel {
    private JFrame parentFrame;
    private Dimension panelSize;
    private GameController gameController;

    private PuzzlePanel(){/* prevent uninitialized instances */}
    public PuzzlePanel(JFrame frame, GameController gameController) {
        this.parentFrame = frame;

        panelSize = frame.getSize();
        this.setPreferredSize(panelSize);

        initializePuzzleGridDisplay();
        initializePuzzleControlsDisplay();
    }

    private void initializePuzzleGridDisplay() {
        // create Sub-JPanel to display the 9 grids in a 3 row x 3 column GridLayout
        PuzzleGridSubPanel subPanel = new PuzzleGridSubPanel(gameController, this);
        this.add(subPanel);
    }

    private void initializePuzzleControlsDisplay() {
        //TODO: create Sub-JPanel to display the game controls (JButtons) in a single 1 row by any # cols GridLayout
    }
}
