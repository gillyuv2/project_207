package farmyard;

import javafx.scene.paint.Color;

/** AnimalManure class to make animal manure object on the java fx when the animation starts. */
public class AnimalManure extends FarmMethods {

  /**
   * Constructor for the AnimalManure. Instantiates the AnimalManure and sets its location, color,
   * appearance and adds it to the Farm.track2 and Farm.manureList.
   *
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   */
  AnimalManure(int x, int y) {
    this.setLocation(x, y);
    this.setColor(Color.BLACK.darker().darker().darker());
    this.setAppearance("");
    Farm.track2.add(this);
    Farm.manureList.add(this);
  }
}
