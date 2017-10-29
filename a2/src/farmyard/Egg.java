package farmyard;

import javafx.scene.paint.Color;

/** An egg that a farmer collects. */
public class Egg extends FarmMethods {

  /**
   * How this piece of food appears on the screen.
   */
  private char eggShape = 'o';

  Egg() {
    this.setColor(Color.ROSYBROWN);
    this.setAppearance("O");
  }
}
//  @Override
  /**
   * Draws this farm pen item.
   *
   * @param g the graphics context in which to draw this item.
   */
//  public void draw(GraphicsContext g) {
////    System.out.println("Brown stuff");
//    g.setFill(Color.ROSYBROWN);
//    g.fillText(String.valueOf(eggShape), y * 10, x * 6);
//  }


