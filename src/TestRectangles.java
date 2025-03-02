import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.HashMap;
import java.util.LinkedList;

public class TestRectangles {

    private Rectangle hitTestRec;
    private java.awt.Rectangle hitTestJavaRec;

    private LinkedList<java.awt.Rectangle> hitJavaRectsList = new LinkedList<>();
    private LinkedList <Rectangle> hitRectsList = new LinkedList<>();

    private HashMap <Rectangle, java.awt.Rectangle> hitRectsMap = new HashMap<>();



    public TestRectangles(){
        for (int i = 0; i < 7 ; i++) {

            hitTestRec = new Rectangle((15 + (i*100)),370,80,120);
            hitTestJavaRec = new java.awt.Rectangle(hitTestRec.getX(), hitTestRec.getY(), hitTestRec.getWidth(), hitTestRec.getHeight());
            hitTestRec.draw();

            hitRectsList.add(hitTestRec);
            hitJavaRectsList.add(hitTestJavaRec);
            hitRectsMap.put(hitTestRec, hitTestJavaRec);

        }


    }

    public void movingRects(HashMap<Rectangle, java.awt.Rectangle> hitRectsMap){

        int xmove = 0;
        int ymove = -10;
        int growth = -1;
        int growthCounter = 0;
        for (int i = 0; i < hitRectsList.size() ; i++) {
            hitTestRec = hitRectsList.get(i);
            hitTestJavaRec = hitJavaRectsList.get(i);

            for (int j = 0; j < 35; j++) {
                growthCounter++;
                hitTestRec.translate(xmove,ymove);
                hitTestJavaRec.translate(xmove, ymove);
                if(growthCounter%2==0) {
                    hitTestRec.grow(growth, growth);
                    hitTestJavaRec.grow(growth, growth);
                    growthCounter = 0;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }



    public Rectangle getHitTestRec() {
        return hitTestRec;
    }

    public void setHitTestRec(Rectangle hitTestRec) {
        this.hitTestRec = hitTestRec;
    }

    public java.awt.Rectangle getHitTestJavaRec() {
        return hitTestJavaRec;
    }

    public void setHitTestJavaRec(java.awt.Rectangle hitTestJavaRec) {
        this.hitTestJavaRec = hitTestJavaRec;
    }

    public LinkedList<java.awt.Rectangle> getHitJavaRectsList() {
        return hitJavaRectsList;
    }

    public void setHitJavaRectsList(LinkedList<java.awt.Rectangle> hitJavaRectsList) {
        this.hitJavaRectsList = hitJavaRectsList;
    }

    public LinkedList<Rectangle> getHitRectsList() {
        return hitRectsList;
    }

    public void setHitRectsList(LinkedList<Rectangle> hitRectsList) {
        this.hitRectsList = hitRectsList;
    }

    public HashMap<Rectangle, java.awt.Rectangle> getHitRectsMap() {
        return hitRectsMap;
    }

    public void setHitRectsMap(HashMap<Rectangle, java.awt.Rectangle> hitRectsMap) {
        this.hitRectsMap = hitRectsMap;
    }


}
