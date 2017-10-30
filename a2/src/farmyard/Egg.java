package farmyard;

import javafx.scene.paint.Color;

/** Egg class to make egg object on the java fx when the animation starts. */
public class Egg extends FarmMethods {

  /**
   * Constructor for the Egg. Instantiates the Egg and sets its location, color.
   *
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   */
  Egg(int x, int y) {
    this.setColor(Color.ROSYBROWN);
    this.setAppearance("O");
    this.setLocation(x, y);
  }
}
