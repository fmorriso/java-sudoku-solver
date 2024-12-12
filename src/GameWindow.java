import java.awt.*;

import javax.swing.JFrame;
public class GameWindow extends JFrame {
    private Dimension scaledSize;
    //TODO: private DetailsPanel detailsPanel;

    private GameWindow() {}
    public  GameWindow(String title, Dimension scaledSize){
        super(title);
        this.scaledSize = scaledSize;
    }
}
