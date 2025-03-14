import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler{

    private Keyboard keyboard;



    private Screen screen;

    private Player player;

    private TestRectangles testRects;

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private boolean space;

    public boolean isSpace() {
        return space;
    }

    private int moveCounter = 0;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void init() {

        testRects = new TestRectangles();

        keyboard = new Keyboard(this);

        KeyboardEvent spaceBar = new KeyboardEvent();
        spaceBar.setKey(KeyboardEvent.KEY_SPACE);
        spaceBar.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceBar);

        KeyboardEvent spaceBarRelease = new KeyboardEvent();
        spaceBarRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceBarRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spaceBarRelease);

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
        int sprintPoint = 20;


        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                space = true;
                break;

            case KeyboardEvent.KEY_W:
                up = true;

                moveCounter++;

                if(left){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveUp();
                            player.moveLeft();
                        }
                        player.moveUp();
                        player.moveLeft();
                    }
                    player.moveUp();
                    player.moveLeft();
                } else if (right){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveUp();
                            player.moveRight();
                        }
                        player.moveUp();
                        player.moveRight();
                    }
                    player.moveUp();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveUp();
                        }
                        player.moveUp();
                    }
                    player.moveUp();
                }
                break;
            case KeyboardEvent.KEY_S:
                down = true;

                moveCounter++;

                if(left){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveDown();
                            player.moveLeft();
                        }
                        player.moveDown();
                        player.moveLeft();
                    }
                    player.moveDown();
                    player.moveLeft();
                } else if (right){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveDown();
                            player.moveRight();
                        }
                        player.moveDown();
                        player.moveRight();
                    }
                    player.moveDown();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveDown();
                        }
                        player.moveDown();
                    }
                    player.moveDown();
                }
                break;
            case KeyboardEvent.KEY_A:
                left = true;

                moveCounter++;

                if(up){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveUp();
                            player.moveLeft();
                        }
                        player.moveUp();
                        player.moveLeft();
                    }
                    player.moveUp();
                    player.moveLeft();
                } else if (down){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveDown();
                            player.moveLeft();
                        }
                        player.moveDown();
                        player.moveLeft();
                    }
                    player.moveDown();
                    player.moveLeft();
                } else {
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveLeft();
                        }
                        player.moveLeft();
                    }
                    player.moveLeft();
                }
                break;
            case KeyboardEvent.KEY_D:
                right = true;

                moveCounter++;

                if(up){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveUp();
                            player.moveRight();
                        }
                        player.moveUp();
                        player.moveRight();
                    }
                    player.moveUp();
                    player.moveRight();
                } else if (down){
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveDown();
                            player.moveRight();
                        }
                        player.moveDown();
                        player.moveRight();
                    }
                    player.moveDown();
                    player.moveRight();
                } else {
                    if(moveCounter >= speedPoint) {
                        if(moveCounter >= sprintPoint) {
                            player.moveRight();
                        }
                        player.moveRight();
                    }
                    player.moveRight();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:

                space = false;

                break;

            case KeyboardEvent.KEY_W:
                up = false;

                moveCounter = 0;

                break;

            case KeyboardEvent.KEY_S:
                down = false;

                moveCounter = 0;

                break;
            case KeyboardEvent.KEY_A:
               left = false;

                moveCounter = 0;

                break;
            case KeyboardEvent.KEY_D:
                right = false;

                moveCounter = 0;

                break;

        }
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public TestRectangles getTestRects() {
        return testRects;
    }
}
