import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler{

    private Keyboard keyboard;



    private Screen screen;

    private Player player;

    private boolean up, down, left, right;

    private int moveCounter = 0;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void init() {

        keyboard = new Keyboard(this);

        KeyboardEvent goUp = new KeyboardEvent();
        goUp.setKey(KeyboardEvent.KEY_W);
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goUp);

        KeyboardEvent goUpRelease = new KeyboardEvent();
        goUpRelease.setKey(KeyboardEvent.KEY_W);
        goUpRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(goUpRelease);


        KeyboardEvent goLeft = new KeyboardEvent();
        goLeft.setKey(KeyboardEvent.KEY_A);
        goLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goLeft);

        KeyboardEvent goLeftRelease = new KeyboardEvent();
        goLeftRelease.setKey(KeyboardEvent.KEY_A);
        goLeftRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(goLeftRelease);


        KeyboardEvent goDown = new KeyboardEvent();
        goDown.setKey(KeyboardEvent.KEY_S);
        goDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goDown);

        KeyboardEvent goDownRelease = new KeyboardEvent();
        goDownRelease.setKey(KeyboardEvent.KEY_S);
        goDownRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(goDownRelease);


        KeyboardEvent goRight = new KeyboardEvent();
        goRight.setKey(KeyboardEvent.KEY_D);
        goRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goRight);

        KeyboardEvent goRightRelease = new KeyboardEvent();
        goRightRelease.setKey(KeyboardEvent.KEY_D);
        goRightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(goRightRelease);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int speedPoint = 10;


        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                up = true;

                moveCounter++;

                if(left){
                    if(moveCounter >= speedPoint) {
                        player.moveUp();
                        player.moveLeft();
                    }
                    player.moveUp();
                    player.moveLeft();
                } else if (right){
                    if(moveCounter >= speedPoint) {
                        player.moveUp();
                        player.moveRight();
                    }
                    player.moveUp();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        player.moveUp();
                    }
                    player.moveUp();
                }
                System.out.println("keyPress, up = " + up + ", counter: " + moveCounter);
                break;
            case KeyboardEvent.KEY_S:
                down = true;

                moveCounter++;

                if(left){
                    if(moveCounter >= speedPoint) {
                        player.moveDown();
                        player.moveLeft();
                    }
                    player.moveDown();
                    player.moveLeft();
                } else if (right){
                    if(moveCounter >= speedPoint) {
                        player.moveDown();
                        player.moveRight();
                    }
                    player.moveDown();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        player.moveDown();
                    }
                    player.moveDown();
                }
                System.out.println("keyPress, down = " + down + "counter: " + moveCounter);
                break;
            case KeyboardEvent.KEY_A:
                left = true;

                moveCounter++;

                if(up){
                    if(moveCounter >= speedPoint) {
                        player.moveUp();
                        player.moveLeft();
                    }
                    player.moveUp();
                    player.moveLeft();
                } else if (down){
                    if(moveCounter >= speedPoint) {
                        player.moveDown();
                        player.moveLeft();
                    }
                    player.moveDown();
                    player.moveLeft();
                } else {
                    if(moveCounter >= speedPoint) {
                        player.moveLeft();
                    }
                    player.moveLeft();
                }
                System.out.println("keyPress, left = " + left + "counter: " + moveCounter);
                break;
            case KeyboardEvent.KEY_D:
                right = true;

                moveCounter++;

                if(up){
                    if(moveCounter >= speedPoint) {
                        player.moveUp();
                        player.moveRight();
                    }
                    player.moveUp();
                    player.moveRight();
                } else if (down){
                    if(moveCounter >= speedPoint) {
                        player.moveDown();
                        player.moveRight();
                    }
                    player.moveDown();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        player.moveRight();
                    }
                    player.moveRight();
                }
                System.out.println("keyPress, right = " + right + "counter: " + moveCounter);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                up = false;

                moveCounter = 0;

                System.out.println("keyReleased, up = " + up + "counter: " + moveCounter);
                break;

            case KeyboardEvent.KEY_S:
                down = false;

                moveCounter = 0;

                System.out.println("keyReleased, down = " + down + "counter: " + moveCounter);
                break;
            case KeyboardEvent.KEY_A:
               left = false;

                moveCounter = 0;

                System.out.println("keyReleased, left = " + left + "counter: " + moveCounter);
                break;
            case KeyboardEvent.KEY_D:
                right = false;

                moveCounter = 0;

                System.out.println("keyReleased, right = " + right + "counter: " + moveCounter);
                break;

        }
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
