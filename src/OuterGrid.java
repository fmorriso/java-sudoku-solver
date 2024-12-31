import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.UUID;

/**
 * This is the GUI component that holds the outer 3 x 3 set of 3 x 3 inner grids
 */
public class OuterGrid extends JPanel {

    private static final Color BACKGROUND_COLOR = new Color(255*2/3, 255*3/4, 255);
    private static final Border BORDER = BorderFactory.createLineBorder(Color.black, 4);

    private UUID uniqueId;
    private final PuzzleGridSubPanel parentWindow;
    private final PuzzleGrid grid;
    private final GameController gameController;

    public OuterGrid(PuzzleGridSubPanel parentWindow, PuzzleGrid grid, GameController gameController) {
        this.parentWindow = parentWindow;
        this.grid = grid;
        this.gameController = gameController;
        this.uniqueId = UUID.randomUUID();

        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(BORDER);
        this.setToolTipText(String.format("Outer Grid %s", this.uniqueId));

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            InnerGrid innerGrid = new InnerGrid(this, gameController);
        }
    }
}
