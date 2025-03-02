import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;

public class Flower {


    private static final String FLOWERPATH = "resources/poppy.png";
    private Picture poppyImage = new Picture(10, 400,FLOWERPATH);
    private Rectangle poppy = new Rectangle(poppyImage.getX(), poppyImage.getY(), poppyImage.getWidth(), poppyImage.getHeight());
    private java.awt.Rectangle poppyjava = new java.awt.Rectangle(poppyImage.getX(), poppyImage.getY(), poppyImage.getWidth(), poppyImage.getHeight());
    private Player player;
    private LinkedList <Picture> poppyList = new LinkedList<>();


    public void setPlayer(Player player) {
        this.player = player;
    }


    public Flower(){

        poppyImage.grow(-4,-4);
        poppyImage.delete();

        for (int i = 0; i < 5; i++) {
            poppyImage = new Picture(poppyImage.getX() + 120, poppyImage.getY(), FLOWERPATH);
            //poppyImage.grow(-3,-3);
            poppy = new Rectangle(poppyImage.getX(), poppyImage.getY(), poppyImage.getWidth(), poppyImage.getHeight());
            poppyjava = new java.awt.Rectangle(poppyImage.getX(), poppyImage.getY(), poppyImage.getWidth(), poppyImage.getHeight());

            poppyImage.draw();

        }
    }

    public Picture getPoppyImage() {
        return poppyImage;
    }

    public LinkedList<Picture> getPoppyList() {
        return poppyList;
    }

    public Rectangle getPoppy() {
        return poppy;
    }

    public void setPoppy(Rectangle poppy) {
        this.poppy = poppy;
    }

    public java.awt.Rectangle getPoppyjava() {
        return poppyjava;
    }

    public void setPoppyjava(java.awt.Rectangle poppyjava) {
        this.poppyjava = poppyjava;
    }
}

