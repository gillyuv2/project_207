package farmyard;

import javafx.scene.paint.Color;

/** Animal Food */
public class AnimalFood extends FarmMethods {

  public double d;


  /**
   * Constructs a new bubble at the specified cursor location (x, y).
   *
   */
  AnimalFood() {
    this.setColor(Color.GRAY.darker().darker().darker());
    // start off with o as the appearance cause all animal food looks the same
    this.setAppearance("%");
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up in
   * this case
   */
  public void blownUp() {

    // Move upwards
    this.setLocation(this.getX(), this.getY()+1);
     // no change left or right
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Down
   * in this case
   */
  public void blownDown() {

    // Move downwards
      this.setLocation(this.getX(), this.getY()-1);
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Left in this case
   */
  public void blownLeft() {

    // Move upwards.
      this.setLocation(this.getX()-1, this.getY());
  }

  /**
   * Causes this item to take its turn in the farm-pen simulation, blown due to strong winds. Up and
   * Right in this case
   */
  public void blownRight() {

    // Move upwards.
      this.setLocation(this.getX()+1, this.getY());
  }
}
