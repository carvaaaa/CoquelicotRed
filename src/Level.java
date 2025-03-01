import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Level {

    private boolean levelStart;
    public void level1Start() {

        levelStart = true;

        //Define the screen
        Screen screen = new Screen("resources/big-tree.jpeg");
        Player player = new Player();

        MyKeyboard myKeyboard = new MyKeyboard();
        myKeyboard.init();
        myKeyboard.setPlayer(player);
        player.setKeyboard(myKeyboard);

    }
}
