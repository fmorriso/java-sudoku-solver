import javax.swing.*;
import java.awt.*;

public class CenteredComboBox extends JComboBox<String> {
    private GameController gameController;
    public CenteredComboBox(String[] items, GameController gameController) {
        super(items);
        this.gameController = gameController;
    }

}
