import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;
//
import java.util.logging.LogRecord;
import java.util.logging.Formatter;

public class LoggingUtilities {
    private static final Logger logger = Logger.getLogger(LoggingUtilities.class.getName());

    public static void configureLogger(String logFilename) {
        try {
            // Create a FileHandler
            FileHandler fileHandler = new FileHandler(logFilename, true);
            fileHandler.setFormatter(new CustomLoggingFormatter()); // Use the custom formatter

            // Add the handler to the logger
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        logger.log(Level.INFO, message);
    }

    public static void log(String message, Level level) {
        logger.log(level, message);
    }

    private static void sanityCheck(String message) {

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





class CustomLoggingFormatter extends Formatter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String dateTime = dateFormat.format(new Date(record.getMillis()));
        return String.format("[%s] [%s] %s%n", dateTime, record.getLevel(), record.getMessage());
    }
}
