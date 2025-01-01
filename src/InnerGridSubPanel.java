import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.MessageFormat;
import java.util.UUID;

public class InnerGridSubPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = new Color(255, 219, 164);
    private static final Border BORDER = BorderFactory.createLineBorder(Color.red, 2);

    private final UUID uniqueId;
    private final OuterGridSubPanel parentWindow;
    private final GameController gameController;

    public InnerGridSubPanel(OuterGridSubPanel parentWindow, GameController gameController) {
        this.uniqueId = UUID.randomUUID();
        this.parentWindow = parentWindow;
        this.gameController = gameController;
        this.setLayout(new GridLayout(3, 3));

        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(BORDER);

        generateDisplayCells();
    }

    private void generateDisplayCells()    {
        for (int row = 0; row < PuzzleGrid.CELLS_PER_GRID_ROW; row++) {
            for (int col = 0; col < PuzzleGrid.CELLS_PER_GRID_COL; col++) {
                Cell cell = new Cell(row, col, 0, gameController);
                CellDisplay cellDisplay = new CellDisplay(cell);
                gameController.addCell(cell);
                this.add(cellDisplay);
            }
        }

    }

    @Override
    public String toString() {
        return MessageFormat.format("InnerGrid '{' uniqueId={0} '}'", uniqueId);
    }
}
