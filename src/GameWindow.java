import java.awt.*;

import javax.swing.JFrame;
public class GameWindow extends JFrame {
    private Dimension scaledSize;
    private GameController gameController;
    //TODO: private PuzzlePanel puzzlePanel;

    private GameWindow() {/* prevent uninitialized instances */}
    public  GameWindow(String title, Dimension scaledSize, GameController gameController){
        super(title);
        this.scaledSize = scaledSize;
        this.gameController = gameController;
    }
}
