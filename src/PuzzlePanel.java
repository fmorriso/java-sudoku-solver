import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PuzzlePanel extends JPanel {
    private JFrame parentFrame;
    private Dimension panelSize;

    private PuzzlePanel(){/* prevent uninitialized instances */}
    public PuzzlePanel(JFrame frame) {
        this.parentFrame = frame;
        this.setLayout(new GridLayout(2, 0));
        panelSize = frame.getSize();
        this.setPreferredSize(panelSize);

        initializePuzzleGridDisplay();
        initializePuzzleControlsDisplay();
    }

    private void initializePuzzleGridDisplay() {
        //TODO: create Sub-JPanel to display the game controls (JButtons) in a single 1 row by any # cols GridLayout
    }

    private void initializePuzzleControlsDisplay() {
        //TODO: create Sub-JPanel to display the 9 grids in a 3 row x 3 column GridLayout
    }
}
