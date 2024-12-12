import javax.swing.JFrame;
import java.awt.*;

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
        Dimension scaledSize = gameController.getScaledSize();

        GameWindow frame = new GameWindow(title, gameController);
        frame.setSize(scaledSize);
        frame.setPreferredSize(scaledSize);

        // the main JPanel within the JFrame should take up the entire JFrame because
        // we will introduce sub-JPanels later on to further subdivide that main JPanel.
        frame.setLayout(new GridLayout(1, 1));
        // tell the main JPanel who its parent is and give it a way to communicate with the game controller.
        PuzzlePanel puzzlePanel = new PuzzlePanel(frame, gameController);
        frame.getContentPane().add(puzzlePanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // puts the JFrame in the middle of the physical screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
