import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PuzzlePanel extends JPanel {
    private JFrame parentFrame;
    public PuzzlePanel(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
}
