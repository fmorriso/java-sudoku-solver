import javax.swing.JFrame;
import java.awt.Dimension;

public class GUI implements Runnable{
    private String title;
    private GameController gameController;

    public GUI(String title, GameController gameController) {
        this.title = title;
        this.gameController = gameController;
    }

    private GUI() {/* prevent uninitalized instances */}

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        // be smart about using the available device screen size instead of hard-coding like most people do.d
        final int multipleof = 10;
        Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.4, multipleof, true);

        GameWindow frame = new GameWindow(title, scaledSize, gameController);
        frame.setSize(scaledSize);
        frame.setPreferredSize(scaledSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // puts the JFrame in the middle of the physical screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
