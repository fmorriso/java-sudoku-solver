import javax.swing.*;
import java.awt.*;

/**
 * A class to make the contents of a JComboBox&lt;String&gt; render those values centered horizontally.
 */
public class CenteredCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        // Call the superclass method for default styling
        JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // Center align the text
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        return renderer;
    }
}