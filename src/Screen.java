import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private static final int PADDING = 10;

    public Screen(String path) {
        Rectangle screen = new Rectangle(PADDING,PADDING,768,512);
        Picture background = new Picture(PADDING,PADDING,path);
        screen.setColor(Color.GREEN);
        screen.draw();
        background.draw();
    }
}
