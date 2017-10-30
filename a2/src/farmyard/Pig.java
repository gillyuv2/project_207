package farmyard;

import javafx.scene.paint.Color;

/** Pig class to make pig object on the java fx when the animation starts. */
public class Pig extends Animals {

  /**
   * Constructor for the Pig. Instantiates the Pig and sets its location, color, appearance and
   * manure.
   *
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   * @return None
   */
  public Pig(int x, int y) {
    this.setColor(Color.PINK.darker().darker().darker());
    this.setAppearance(":(8)");
    this.setManure("*");
    this.setLocation(x, y);
  }
}
