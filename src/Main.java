import javax.swing.SwingUtilities;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String title = String.format("Sudoku Solver using java version %s", getJavaVersion());
        System.out.println(title);

        displayCurrentMethod();

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

    /**
     * Display the currently executing class and method name.
     * If the class is located in a filename other than the name of the class,
     * that filename is included in the output.
     */
    public static void displayCurrentMethod(){
        // Get the stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuilder sbr = new StringBuilder();

        // grab the classname
        String className = stackTrace[2].getClassName();

        // grab the containing .java filename
        String fileName = stackTrace[2].getFileName();
        String[] fileParts = fileName.split("\\.");
        if(!fileParts[0].equalsIgnoreCase(className)) {
            sbr.append("|").append(fileName);
        }

        // The current method is at index 2 (0 is getStackTrace, 1 is printCurrentMethodName)
        String methodName = stackTrace[2].getMethodName();

        // assume any method initially identified as <init> is the construcotr
        if(methodName.equals("<init>")) methodName = "constructor";

        sbr.append("|").append(className)
                .append("|").append(methodName).append("|");

        System.out.println(sbr.toString());
    }
}