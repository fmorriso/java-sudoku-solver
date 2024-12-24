import javax.swing.*;
//
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

public class PuzzleControlsSubPanel extends JPanel {
    private GameController gameController;
    private GameWindow parentWindow;

    private PuzzleControlsSubPanel() {/* prevent uninitialized instances. */}
    public PuzzleControlsSubPanel(GameWindow parentWindow) {
        this.parentWindow = parentWindow;
        this.gameController = this.parentWindow.getGameController();
        //
        this.setLayout(new GridLayout(1,0));
        this.add(createStartNewGameButton());
        this.add(createExitButton());

    }

    private JButton createExitButton() {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener((ActionEvent e) -> System.exit(0));
        return exitButton;
    }

    private JButton createStartNewGameButton() {
        JButton resetButton = new JButton("New Game");
        resetButton.addActionListener((ActionEvent e) -> gameController.startNewPuzzle());
        return resetButton;
    }

}
