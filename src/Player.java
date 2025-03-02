import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.HashMap;
import java.util.LinkedList;

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

    private final String INITIALIMAGE = "resources/standing.png";

    private int counterFrames = 0;

    private Rectangle hitTestRec;
    private java.awt.Rectangle hitTestJavaRec;
    
    private LinkedList <java.awt.Rectangle> hitJavaRectsList = new LinkedList<>();
    private LinkedList <Rectangle> hitRectsList = new LinkedList<>();

    private HashMap <Rectangle, java.awt.Rectangle> hitRectsMap = new HashMap<>();

    //private Hitbox hitboxes;
    

    public Player() {

        System.out.println("Im entering here");
        playerPic = new Picture(SPAWNX,SPAWNY,INITIALIMAGE);
        playerPic.grow(-200,-270);
        rectangleHit = new Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());
        rectangleHitJava = new java.awt.Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());

        playerPic.draw();
        rectangleHit.draw();


    }


    public void initRects(){

        hitRectsList = keyboard.getTestRects().getHitRectsList();
        hitJavaRectsList = keyboard.getTestRects().getHitJavaRectsList();
        hitRectsMap = keyboard.getTestRects().getHitRectsMap();

        hitTest(hitRectsMap);
    }




    public boolean hitTest(HashMap <Rectangle, java.awt.Rectangle> hitRectsMap){

        this.hitRectsMap = hitRectsMap;

        for (int i = 0; i < hitRectsList.size(); i++) {

            hitTestRec = hitRectsList.get(i);
            hitTestJavaRec = hitJavaRectsList.get(i);
            //hitTestJavaRec = hitRectsMap.get(hitTestRec);

            if(!hitTestJavaRec.intersects(rectangleHitJava) || !rectangleHitJava.intersects(hitTestJavaRec)){
                rectangleHit.setColor(Color.BLACK);
                hitTestRec.setColor(Color.BLACK);
                rectangleHit.draw();
            } else {
                rectangleHit.setColor(Color.BLUE);
                hitTestRec.setColor(Color.ORANGE);
                rectangleHit.draw();
            }
            if(hitTestJavaRec.contains(rectangleHitJava)){
                rectangleHit.setColor(Color.GREEN);
                hitTestRec.setColor(Color.RED);
                rectangleHit.draw();
            }

        }
        return false;
    }



    public void changePic(String resource){
        playerPic.delete();
        playerPic.load(resource);
        //playerPic.grow(-200,-270);
        playerPic.draw();
    }

    public void moveRight() {

        hitTest(hitRectsMap);
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

        hitTest(hitRectsMap);
        tryChangeScreen();

        changePic("resources/goingUp.png");

        if(checkLimits("up") && playerPic.getHeight()> 12) {

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

        hitTest(hitRectsMap);
        tryChangeScreen();
        counterFrames ++;

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


            if(counterFrames%2 == 0){
                changePic(INITIALIMAGE);
                counterFrames = 0;
            }
            counterVertical++;
        }
    }

    public void moveLeft() {

        hitTest(hitRectsMap);
        tryChangeScreen();
        changePic("resources/goingLeft.png");

        if(screen.getScreenJavaHit().contains(rectangleHitJava) && (rectangleHitJava.getX() - 7) >= screen.getScreenJavaHit().getX()) {


            playerPic.translate(-5, 0);
            rectangleHit.translate(-5, 0);
            rectangleHitJava.translate(-5, 0);
            System.out.println("Y: " + rectangleHit.getY() + " H: " + rectangleHit.getHeight());
        }


    }

    private java.awt.Rectangle changeScreenRect = new java.awt.Rectangle(0,370,50,100);

    public void tryChangeScreen() {
        if(changeScreenRect.intersects(rectangleHitJava)) {
            screen.getBackground().load("resources/rice-pink-tree.jpeg");
            screen.getBackground().draw();

            rectangleHit.delete();
            playerPic.delete();
            playerPic = new Picture(500,120,INITIALIMAGE);
            playerPic.grow(-200,-270);
            playerPic.draw();

            rectangleHit = new Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());
            rectangleHitJava = new java.awt.Rectangle(playerPic.getX(), playerPic.getY(), playerPic.getWidth(), playerPic.getHeight());
            /*picSetLocation(playerPic, (screen.getBackground().getWidth() - playerPic.getWidth()), playerPic.getY());
            rectSetLocation(rectangleHit, playerPic.getX(), playerPic.getY());
            rectangleHitJava.setLocation(rectangleHit.getX(), rectangleHit.getY());
            rectangleHit.draw();*/

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

    public void rectSetLocation(Rectangle rec, int newX, int newY){
            int h = rec.getHeight();
            int w = rec.getWidth();
            rec = new Rectangle(newX, newY, w, h);
    }

    public void picSetLocation(Picture pic, int newX, int newY){
        int h = pic.getHeight();
        int w = pic.getWidth();
        pic.delete();
        pic = new Picture(newX, newY,INITIALIMAGE);
        pic.grow(-200,-270);
        pic.draw();
    }
}
