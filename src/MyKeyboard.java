import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler{

    private Keyboard keyboard;

    private Player player;

    private boolean up, down, left, right;

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


        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                up = true;

                if(left){
                    player.moveUp();
                    player.moveLeft();
                    //up = false;
                    //left = false;
                } else if (right){
                    player.moveUp();
                    player.moveRight();
                    //up = false;
                    //right = false;
                } else {
                    player.moveUp();
                    //up = false;
                }
                System.out.println("keyPress, up = " + up);
                break;
            case KeyboardEvent.KEY_S:
                down = true;

                if(left){
                    player.moveDown();
                    player.moveLeft();
                    //down = false;
                    //left = false;
                } else if (right){
                    player.moveDown();
                    player.moveRight();
                    //down = false;
                    //right = false;
                } else {
                    player.moveDown();
                    //down = false;
                }
                System.out.println("keyPress, down = " + down);
                break;
            case KeyboardEvent.KEY_A:
                left = true;

                if(up){
                    player.moveUp();
                    player.moveLeft();
                    //up = false;
                    //left = false;
                } else if (down){
                    player.moveDown();
                    player.moveLeft();
                    //down = false;
                    //left = false;
                } else {
                    player.moveLeft();
                    //left = false;
                }
                System.out.println("keyPress, left = " + left);
                break;
            case KeyboardEvent.KEY_D:
                right = true;

                if(up){
                    player.moveUp();
                    player.moveRight();
                    //up = false;
                    //right = false;
                } else if (down){
                    player.moveDown();
                    player.moveRight();
                    //down = false;
                    //right = false;
                } else {
                    player.moveRight();
                    //right = false;
                }
                System.out.println("keyPress, right = " + right);
                break;

        }

        /*
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            up = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            left = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            down = true;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            right = true;
        }

        if(up && left) {
            player.moveUp();
            player.moveLeft();
            up = false;
            left = false;
        } else if(up && right) {
            player.moveUp();
            player.moveRight();
            up = false;
            right = false;
        } else if(down && right) {
            player.moveDown();
            player.moveRight();
            down = false;
            right = false;
        } else if(down && left) {
            player.moveDown();
            player.moveLeft();
            down = false;
            left = false;
        } else if(up) {
            player.moveUp();
            up = false;
        } else if(down) {
            player.moveDown();
            down = false;
        } else if(left) {
            player.moveLeft();
            left = false;
        } else if(right) {
            player.moveRight();
            right = false;
        }

         */
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                up = false;
                if(left){
                    //player.moveUp();
                    //player.moveLeft();
                    //up = false;
                    left = false;
                } else if (right){
                    //player.moveUp();
                    //player.moveRight();
                    //up = false;
                    right = false;
                }
                System.out.println("keyReleased, up = " + up);
                break;

            case KeyboardEvent.KEY_S:
                down = false;

                if(left){
                    //player.moveDown();
                    //player.moveLeft();
                    //down = false;
                    left = false;
                } else if (right){
                    //player.moveDown();
                    //player.moveRight();
                    //down = false;
                    right = false;
                }
                System.out.println("keyReleased, down = " + down);
                break;
            case KeyboardEvent.KEY_A:
               left = false;

                if(up){
                    //player.moveUp();
                    //player.moveLeft();
                    up = false;
                    //left = false;
                } else if (down){
                    //player.moveDown();
                    //player.moveLeft();
                    down = false;
                    //left = false;
                }
                System.out.println("keyReleased, left = " + left);
                break;
            case KeyboardEvent.KEY_D:
                right = false;

                if(up){
                    //player.moveUp();
                    //player.moveRight();
                    up = false;
                    //right = false;
                } else if (down){
                    //player.moveDown();
                    //player.moveRight();
                    down = false;
                    //right = false;
                }
                System.out.println("keyReleased, right = " + right);
                break;

        }

        /*        if(keyboardEvent.getKey() == KeyboardEvent.KEY_W) {
            up = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            left = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            down = false;
        }
        if(keyboardEvent.getKey() == KeyboardEvent.KEY_D) {
            right = false;
        }*/
    }



    public boolean isGoingUp() {
        return up;
    }

    public boolean isGoingDown() {
        return down;
    }

    public boolean isGoingLeft() {
        return left;
    }

    public boolean isGoingRight() {
        return right;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }
}
