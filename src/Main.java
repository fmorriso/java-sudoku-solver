import javax.swing.SwingUtilities;

public class Main {



    public static void main(String[] args) throws Exception {
        String title = String.format("Sudoku Solver using java version %s", getJavaVersion());
        System.out.println(title);

        LoggingUtilities.displayCurrentMethod();


        KeyValueSettingsUtilities.setFileName("settings.txt");
        boolean debugOn = Boolean.parseBoolean(KeyValueSettingsUtilities.getValue("debug"));
        String logFilename = KeyValueSettingsUtilities.getValue("logfile");

        LoggingUtilities.configureLogger(logFilename);
        LoggingUtilities.log(title);

        GameController gameController = new GameController();
        GUI gui = new GUI(title, gameController);
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