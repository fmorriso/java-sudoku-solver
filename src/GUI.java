public class GUI implements Runnable {
    private String title;
    private GameController gameController;

    private GUI() {/* prevent uninitialized instances */}

    public GUI(String title, GameController gameController) {
        this.title = title;
        this.gameController = gameController;
    }


    /**
     * Starts and runs the game.
     */
    @Override
    public void run() {
        try {
            LoggingUtilities.displayCurrentMethod();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        MainGameFrame frame = null;
        try {
            frame = new MainGameFrame(title, gameController);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        frame.setVisible(true);
    }
}
