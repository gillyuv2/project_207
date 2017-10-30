package farmyard;

import javafx.scene.paint.Color;

/** PoopCollector class to make PoopCollector object on the java fx when the animation starts. */
public class PoopCollector extends Animals {

  /**
   * Constructor for the PoopCollector. Instantiates the PoopCollector and sets its location, color
   * and id.
   *
   * @param id A string to describe the appearance of the PoopCollector.
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   * @return None
   */
  public PoopCollector(String id, int x, int y) {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance(id);
    this.setLocation(x, y);
  }
}
