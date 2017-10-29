package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class FarmMethods {
    private String appearance;

    private int x;
    private Color color;
    private int y;

    public FarmMethods(){
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }

    void setColor(Color newColor){
        this.color = newColor;
    }
    Color getColor(){
        return this.color;
    }

    void drawString(GraphicsContext g, String s, int x, int y) {
        g.setFill(this.color);
        g.fillText(s, x * 10, y * 6);
    }

    public void draw(GraphicsContext g) {

        drawString(g, appearance, x, y);
    }

    public String getAppearance(){
        return appearance;
    }

    void setAppearance(String newAppearance){
        this.appearance = newAppearance;
    }

}
