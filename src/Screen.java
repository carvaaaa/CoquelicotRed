import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen {

    private static final int PADDING = 10;

    private Picture background;
    private Rectangle screen;
    private java.awt.Rectangle screenJava;
    private String path;

    public Screen(String path) {
        this.path = path;
        screen = new Rectangle(PADDING,PADDING,768,512);
        screenJava = new java.awt.Rectangle(screen.getX(),screen.getY(),screen.getWidth(),screen.getHeight());
        this.background = new Picture(PADDING,PADDING,path);
        screen.setColor(Color.GREEN);
        screen.draw();
        background.draw();
    }

    public java.awt.Rectangle getScreenJavaHit() {
        return screenJava;
    }

    public Picture getBackground() {
        return background;
    }
}
