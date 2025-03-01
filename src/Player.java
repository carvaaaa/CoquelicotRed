import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private static final int SPAWNX = 100;//300;
    private static final int SPAWNY = 100;//410;
    private MyKeyboard keyboard;

    public void setKeyboard(MyKeyboard keyboard) {
        this.keyboard = keyboard;
    }

    private Picture playerPic;

    // will have the hitbox of the player but needs to have its own class
    private Rectangle rectangleHit;

    public Player() {

        System.out.println("Im entering here");
        playerPic = new Picture(SPAWNX,SPAWNY,"resources/standing.png");
        playerPic.grow(-200,-270);
        rectangleHit = new Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());

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

        changePic("resources/goingRight.png");

        playerPic.translate(5, 0);
        rectangleHit.translate(5, 0);
        System.out.println("Im moving1");

    }

    public void moveUp() {

        changePic("resources/goingUp.png");

        playerPic.translate(0, -5);
        rectangleHit.translate(0, -5);
        playerPic.grow(-1,-1);
        rectangleHit.grow(-1,-1);
        System.out.println("Im moving2");

    }

    public void moveDown() {

        changePic("resources/goingDown.png");

        playerPic.translate(0, 5);
        rectangleHit.translate(0, 5);

        playerPic.grow(1,1);
        rectangleHit.grow(1,1);

        System.out.println("Im moving3");
    }

    public void moveLeft() {

        changePic("resources/goingLeft.png");

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
