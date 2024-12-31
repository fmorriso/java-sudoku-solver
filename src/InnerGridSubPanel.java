import javax.swing.*;
import java.awt.*;
import java.text.MessageFormat;
import java.util.UUID;

public class InnerGridSubPanel extends JPanel {

    private final UUID uniqueId;
    private final OuterGridSubPanel parentWindow;
    private final GameController gameController;

    public InnerGridSubPanel(OuterGridSubPanel parentWindow, GameController gameController) {
        this.uniqueId = UUID.randomUUID();
        this.parentWindow = parentWindow;
        this.gameController = gameController;
        this.setLayout(new GridLayout(3, 3));
    }

    @Override
    public String toString() {
        return MessageFormat.format("InnerGrid '{' uniqueId={0} '}'", uniqueId);
    }
}
