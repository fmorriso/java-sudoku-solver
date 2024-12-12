import javax.swing.*;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        String title = String.format("Sudoku Solver using java version %s", getJavaVersion());
        System.out.println(title);
        GUI gui = new GUI(title);
        SwingUtilities.invokeLater(gui);
    }

    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version rtv = Runtime.version();
        return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
    }
}