public class GUI implements Runnable{
    private String title;
    private GameController gameController;

    private GUI() {/* prevent uninitialized instances */}
    public GUI(String title, GameController gameController) {
        this.title = title;
        this.gameController = gameController;
    }



    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        GameWindow frame = new GameWindow(title, gameController);
        frame.setVisible(true);
    }
}
