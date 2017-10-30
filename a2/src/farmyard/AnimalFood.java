package farmyard;

import javafx.scene.paint.Color;

/** AnimalFood class to make animal food object on the java fx when the animation starts. */
public class AnimalFood extends FarmMethods {

    /**
     * Constructor for the AnimalFood. Instantiates the AnimalManure and sets
     * its location, color, appearance and adds it to the Farm.track2 and
     * Farm.manureList.
     *
     * @param x sets the x co-ordinate
     * @param y sets the y co-ordinate
     */
  AnimalFood(int x, int y) {
    this.setColor(Color.GRAY.darker().darker().darker());
    this.setLocation(x, y);
    this.setAppearance("%");
    Farm.foodList.add(this);
    Farm.track2.add(this);
  }

  /**
   * Increases the y co-ordinate by 1.
   *
   * @return none
   */
  public void blownUp() {

    // Move upwards by one step.
    this.setLocation(this.getX(), this.getY() + 1);

  }

    /**
     * Decreases the y co-ordinate by 1.
     *
     * @return none
     */
  public void blownDown() {

    // Move downwards by one step.
    this.setLocation(this.getX(), this.getY() - 1);
  }

    /**
     * Decreases the x co-ordinate by 1.
     *
     * @return none
     */
  public void blownLeft() {

    // Move left by one step.
    this.setLocation(this.getX() - 1, this.getY());
  }

    /**
     * Increases the x co-ordinate by 1.
     *
     * @return none
     */
  public void blownRight() {

    // Move right by one step..
    this.setLocation(this.getX() + 1, this.getY());
  }

}
