package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class FarmMethods {

  private String appearance;
  private int x;
  private Color color;
  private int y;


  public FarmMethods() {}

  void setLocation(int x, int y) {

    if (x >= 48) {
      this.x = 48;
    } else if (x < 0) {
      this.x = 1;
    }else{
        this.x = x;
    }
    if (y >= 640/6) {
      this.y = (640/6) -1 ;
    } else if (y < 0) {
      this.y = 1;
    } else{
        this.y = y;
    }
  }

  int getX() {
    return x;
  }

  int getY() {
    return y;
  }

  void setColor(Color newColor) {
    this.color = newColor;
  }

  void drawString(GraphicsContext g, String s, int x, int y) {
    g.setFill(this.color);
    g.fillText(s, x*10 , y*6 );
  }

  public void draw(GraphicsContext g) {

    drawString(g, appearance, x, y);
  }

  String getAppearance() {
    return appearance;
  }

  void setAppearance(String newAppearance) {
    this.appearance = newAppearance;
  }
}
