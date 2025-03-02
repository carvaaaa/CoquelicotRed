import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.HashMap;
import java.util.LinkedList;

public class TestRectangles {

    private Rectangle hitTestRec;
    private java.awt.Rectangle hitTestJavaRec;

    private LinkedList<java.awt.Rectangle> hitJavaRectsList = new LinkedList<>();
    private LinkedList <Rectangle> hitRectsList = new LinkedList<>();

    private HashMap <Rectangle, java.awt.Rectangle> hitRectsMap = new HashMap<>();

    private Rectangle merchant = new Rectangle(200,360,60,80);

    public java.awt.Rectangle getMerchantJava() {
        return merchantJava;
    }

    private java.awt.Rectangle merchantJava = new java.awt.Rectangle(merchant.getX(),merchant.getY(), merchant.getWidth(), merchant.getHeight());

    public Text getMerchantText() {
        return merchantText;
    }

    public void setMerchantText(Text merchantText) {
        this.merchantText = merchantText;
    }

    private Text merchantText = new Text(merchant.getX()+ 40, merchant.getY()-10, "Hey boy! can ya help me?");



    public TestRectangles(){

        merchantText.setColor(Color.WHITE);

        for (int i = 0; i < 7 ; i++) {

            hitTestRec = new Rectangle((70 + (i*100)),280,80,100);
            hitTestJavaRec = new java.awt.Rectangle(hitTestRec.getX(), hitTestRec.getY(), hitTestRec.getWidth(), hitTestRec.getHeight());

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

            for (int j = 0; j < 20; j++) {
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
