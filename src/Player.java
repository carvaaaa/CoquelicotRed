import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private static final int SPAWNX = 100;//300;
    private static final int SPAWNY = 100;//410;
    private MyKeyboard keyboard;
    private Screen screen;
    private int counterVertical = 0;

    public void setKeyboard(MyKeyboard keyboard) {
        this.keyboard = keyboard;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    private Picture playerPic;

    // will have the hitbox of the player but needs to have its own class
    private Rectangle rectangleHit;
    private java.awt.Rectangle rectangleHitJava;

    public Player() {

        System.out.println("Im entering here");
        playerPic = new Picture(SPAWNX,SPAWNY,"resources/standing.png");
        playerPic.grow(-200,-270);
        rectangleHit = new Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());
        rectangleHitJava = new java.awt.Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());

        playerPic.draw();
        rectangleHit.draw();

    }

    public void changePic(String resource){
        playerPic.delete();
        playerPic.load(resource);
        //playerPic.grow(-200,-270);
        playerPic.draw();
    }

    public void moveRight() {

        tryChangeScreen();

        changePic("resources/goingRight.png");

        if(screen.getScreenJavaHit().contains(rectangleHitJava) && (rectangleHitJava.getX() + rectangleHitJava.getWidth() + 7) <= screen.getScreenJavaHit().getX() + screen.getScreenJavaHit().getWidth()) {

            playerPic.translate(5, 0);
            rectangleHit.translate(5, 0);
            rectangleHitJava.translate(5, 0);
            System.out.println("Im moving1");
        }

    }

    public void moveUp() {

        tryChangeScreen();

        changePic("resources/goingUp.png");

        if(checkLimits("up")) {

            playerPic.translate(0, -5);
            rectangleHit.translate(0, -5);
            rectangleHitJava.translate(0, -5);

            if(counterVertical == 1) {
                playerPic.grow(-1,-1);
                rectangleHit.grow(-1,-1);
                rectangleHitJava.grow(-1, -1);
                counterVertical = 0;
            }
            counterVertical++;
        }

    }

    public void moveDown() {

        tryChangeScreen();

        changePic("resources/goingDown.png");

        if(checkLimits("down")) {


            playerPic.translate(0, 5);
            rectangleHit.translate(0, 5);
            rectangleHitJava.translate(0, 5);

            if(counterVertical == 1) {
                playerPic.grow(1,1);
                rectangleHit.grow(1,1);
                rectangleHitJava.grow(1, 1);
                counterVertical = 0;
            }
            counterVertical++;
        }
    }

    public void moveLeft() {

        tryChangeScreen();

        if(screen.getScreenJavaHit().contains(rectangleHitJava) && (rectangleHitJava.getX() - 7) >= screen.getScreenJavaHit().getX()) {


            playerPic.translate(-5, 0);
            rectangleHit.translate(-5, 0);
            rectangleHitJava.translate(-5, 0);
            System.out.println("Y: " + rectangleHit.getY() + " H: " + rectangleHit.getHeight());
        }

        changePic("resources/goingLeft.png");

    }

    private java.awt.Rectangle changeScreenRect = new java.awt.Rectangle(0,370,50,100);

    public void tryChangeScreen() {
        if(changeScreenRect.intersects(rectangleHitJava)) {
            screen.getBackground().load("resources/rice-pink-tree.jpeg");
            screen.getBackground().draw();
        }
    }

    public boolean checkLimits(String direction) {
        if(direction.equals("down")) {
            return screen.getScreenJavaHit().contains(rectangleHitJava)
                    &&
                    (rectangleHitJava.getY() + rectangleHitJava.getHeight() + 7) <= screen.getScreenJavaHit().getY() + screen.getScreenJavaHit().getHeight()
                    &&
                    (rectangleHitJava.getX() + rectangleHitJava.getWidth() + 7) <= screen.getScreenJavaHit().getX() + screen.getScreenJavaHit().getWidth()
                    &&
                    (rectangleHitJava.getX() - 7) >= screen.getScreenJavaHit().getX();
        } else {
            return screen.getScreenJavaHit().contains(rectangleHitJava)
                    &&
                    (rectangleHitJava.getY() - 7) >= screen.getScreenJavaHit().getY()
                    &&
                    (rectangleHitJava.getX() + rectangleHitJava.getWidth() + 7) <= screen.getScreenJavaHit().getX() + screen.getScreenJavaHit().getWidth()
                    &&
                    (rectangleHitJava.getX() - 7) >= screen.getScreenJavaHit().getX();
        }
    }
}
