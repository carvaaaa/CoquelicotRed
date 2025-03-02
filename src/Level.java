public class Level {

    private boolean levelStart;
    public void level1Start() {

        levelStart = true;

        //Define the screen
        Screen screen = new Screen("resources/rice-field.jpeg");
        Player player = new Player();
        Flower flower = new Flower();

        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.setScreen(screen);
        myKeyboard.init();
        myKeyboard.setPlayer(player);
        player.setFlower(flower);
        player.setKeyboard(myKeyboard);
        player.setScreen(screen);
        player.initRects();

        TestRectangles testRectangles = new TestRectangles();
        testRectangles.movingRects(testRectangles.getHitRectsMap());


    }
}
