import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class GUI implements Runnable{
    private String title;
    public GUI(String title) {
        this.title = title;
    }
    private GUI() {/* prevent uninitalized instances */}
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        final int multipleof = 10;
        Dimension scaledSize = SwingScreenUtilities.getScaledSize(0.5, multipleof, true);
        
        GameWindow frame = new GameWindow(title, scaledSize);
        frame.setSize(scaledSize);
        frame.setPreferredSize(scaledSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // puts the JFrame in the middle of the physical screen
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
