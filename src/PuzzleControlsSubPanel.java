import javax.swing.*;

public class PuzzleControlsSubPanel extends JPanel {
    private GameController gameController;
    private JPanel parentPanel;

    private PuzzleControlsSubPanel() {/* prevent uninitialized instances. */}
    public PuzzleControlsSubPanel(GameController gameController, JPanel parentPanel) {
        this.gameController = gameController;
        this.parentPanel = parentPanel;
        // TODO: add Exit JButton and a few others TBD
    }
}
