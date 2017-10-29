package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pig extends Animals {
  /** How this Pig appears on the screen. */

  /** Indicates whether this Pig is moving right. */
  boolean goingRight;

  /** Constructs a new Pig. */
  public Pig() {
      this.setColor(Color.PINK.darker().darker().darker());
      this.setAppearance(":(8)");
      this.setManure("*");
      this.goingRight = true;
  }

  /** Causes this item to take its turn in the farm-pen simulation. */


}
