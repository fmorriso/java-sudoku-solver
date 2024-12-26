import javax.swing.*;
import java.awt.*;

public class InnerGrid extends JPanel {

    private final OuterGrid parentWindows;
    private final GameController gameController;

    public InnerGrid(OuterGrid parentWindow, GameController gameController) {
        this.parentWindows = parentWindow;
        this.gameController = gameController;
        this.setLayout(new GridLayout(3, 3));
    }
}
