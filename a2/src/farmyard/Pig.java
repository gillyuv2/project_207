package farmyard;

import javafx.scene.paint.Color;



public class Pig extends Animals {



  /** Constructs a new Pig. */
  public Pig(int x, int y) {
    this.setColor(Color.PINK.darker().darker().darker());
    this.setAppearance(":(8)");
    this.setManure("*");
    this.setLocation(x, y);
  }
}
