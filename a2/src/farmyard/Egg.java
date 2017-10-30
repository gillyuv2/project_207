package farmyard;

import javafx.scene.paint.Color;

/** An egg that a farmer collects. */
public class Egg extends FarmMethods {

  /**
   * How this piece of food appears on the screen.
   */

  Egg(int x, int y) {
    this.setColor(Color.ROSYBROWN);
    this.setAppearance("O");
    this.setLocation(x,y);
  }
}


