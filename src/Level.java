public class Level {

    private boolean levelStart;
    public void level1Start() {

        levelStart = true;

        //Define the screen
        Screen screen = new Screen("resources/rice-field.jpeg");
        Player player = new Player();

        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.setScreen(screen);
        myKeyboard.init();
        myKeyboard.setPlayer(player);
        player.setKeyboard(myKeyboard);
        player.setScreen(screen);

        TestRectangles testRectangles = new TestRectangles();
        testRectangles.movingRects(testRectangles.getHitRectsMap());


    }
}
