import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String title = String.format("Sudoku Solver using java version %s", getJavaVersion());
        System.out.println(title);

        configureLogger();
        logger.info(title);

        GameController gameController = new GameController();

        GUI gui = new GUI(title, gameController);
        SwingUtilities.invokeLater(gui);
    }

    private static void configureLogger() {
        try {
            // Create a FileHandler
            FileHandler fileHandler = new FileHandler("application-log.txt", true);
            fileHandler.setFormatter(new CustomLoggingFormatter()); // Use the custom formatter

            // Add the handler to the logger
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
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