import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private static final int SPAWNX = 300;
    private static final int SPAWNY = 410;
    private MyKeyboard keyboard;

    public void setKeyboard(MyKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    private Picture playerPic;

    // will have the hitbox of the player but needs to have its own class
    private Rectangle rectangleHit;

    public Player() {

        System.out.println("Im entering here");
        playerPic = new Picture(SPAWNX,SPAWNY,"resources/marioRight.png");
        rectangleHit = new Rectangle(SPAWNX,SPAWNY,100,100);

        playerPic.draw();
        rectangleHit.draw();

    }

    public void moveRight() {

        playerPic.translate(5, 0);
        rectangleHit.translate(5, 0);
        System.out.println("Im moving1");

    }

    public void moveUp() {

        playerPic.translate(0, -10);
        rectangleHit.translate(0, -10);
        playerPic.grow(-1,-1);
        rectangleHit.grow(-1,-1);
        System.out.println("Im moving2");

    }

    public void moveDown() {
        playerPic.translate(0, 10);
        rectangleHit.translate(0, 10);

        playerPic.grow(1,1);
        rectangleHit.grow(1,1);

        System.out.println("Im moving3");
    }

    public void moveLeft() {

        playerPic.translate(-5, 0);
        rectangleHit.translate(-5, 0);
        System.out.println("Im moving4");

    }

    public Picture getPlayerPic() {
        return playerPic;
    }

    public Rectangle getRectangleHit() {
        return rectangleHit;
    }
}
