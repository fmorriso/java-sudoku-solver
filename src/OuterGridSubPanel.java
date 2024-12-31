import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
//
import java.awt.Color;
import java.awt.GridLayout;
//
import java.util.UUID;
import java.util.ArrayList;

/**
 * This is the GUI component that holds the outer 3 x 3 set of 3 x 3 inner grids
 */
public class OuterGridSubPanel extends JPanel {

    private static final Color BACKGROUND_COLOR = new Color(164, 219, 255);
    private static final Border BORDER = BorderFactory.createLineBorder(Color.black, 2);

    private UUID uniqueId;
    private final PuzzleGridSubPanel parentWindow;
    private final PuzzleGrid grid;
    private final GameController gameController;
    private ArrayList<InnerGridSubPanel> innerGrids; //

    public OuterGridSubPanel(PuzzleGridSubPanel parentWindow, PuzzleGrid grid, GameController gameController) {
        this.parentWindow = parentWindow;
        this.grid = grid;
        this.gameController = gameController;
        this.uniqueId = UUID.randomUUID();
        this.innerGrids = new ArrayList<InnerGridSubPanel>();

        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(BORDER);
        this.setToolTipText(String.format("Outer Grid %s", this.uniqueId));

        setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            InnerGridSubPanel innerGrid = new InnerGridSubPanel(this, gameController);
            innerGrids.add(innerGrid);
            this.add(innerGrid);
        }
    }
}
