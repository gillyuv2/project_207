package farmyard;

import javafx.scene.paint.Color;

/** Chicken class to make chicken object on the java fx when the animation starts. */
public class Chicken extends Animals {

  /**
   * Constructor for the Chicken. Instantiates the Chicken and sets its location, color, appearance
   * and manure.
   *
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   * @return None
   */
  public Chicken(int x, int y) {
    this.setColor(Color.RED);
    this.setAppearance("/'/>");
    this.setManure(".");
    this.setLocation(x, y);
  }

  /**
   * Moves the chicken and lays egg randomly. It takes the move method from Animal and layEgg()
   * method to lay eggs randomly.
   *
   * @return None
   */
  public void chickenMove() {
    this.move();
    // Randomly spawns the eggs after some time.
    if (Math.random() < 0.01) {
      layEgg();
    }
  }

  /**
   * Lay an egg. Adds it to the Farm.track2 and Far.eggList.
   *
   * @return None
   */
  private void layEgg() {
    Egg egg = new Egg(this.getX(), this.getY());
    Farm.track2.add(egg);
    Farm.eggList.add(egg);
  }
}
