import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private static final int SPAWNX = 300;
    private static final int SPAWNY = 410;

    public Player() {

        Picture player = new Picture(SPAWNX,SPAWNY,"resources/pngegg.png");
        Rectangle hitbox = new Rectangle(SPAWNX,SPAWNY,100,100);

        player.draw();
        hitbox.draw();

    }

}
