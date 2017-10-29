package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Chicken extends Animals {
  /** How this Chicken appears on the screen. */
  String appearance;

  /** Indicates whether this Chicken is moving right. */
  boolean goingRight;

  /** This Chicken's first coordinate. */

  /** The colour of this Chicken. */

  /** This Chicken's second coordinate. */


  /** Constructs a new Chicken. */
  public Chicken() {
    this.setColor(Color.RED);
    this.setAppearance("/'/>");
    this.setManure(".");
    this.goingRight = true;
  }

  /** Set this item's location. */
  public static Egg aneggishere() {
    for (int r = 0; r != Human.myFarmAnimals.length; r++)
      for (int c = 0; c != Human.myFarmAnimals[0].length; c++)
        if (Human.myFarmAnimals[r][c] instanceof Egg) return (Egg) Human.myFarmAnimals[r][c];
    return null;
  }


  /** Causes this item to take its turn in the farm-pen simulation. */
  public void move() {

    // Sometimes food doesn't sit well in the stomach, so I have to clear my stomach
    double d1 = Math.random();
    if (d1 < 0.2) {
      digest();
    }

    // Move one spot to the right or left.
    if (goingRight) {
      this.setLocation(this.getX()+1, this.getY());
    } else {
      this.setLocation(this.getX()-1, this.getY());
    }

    // Every now and then lay an egg.
    double d2 = Math.random();
    if (d1 < 0.1) {
      layEgg();
    }

    double d3 = Math.random();
    if (d1 < 0.1) {
      turnAround();
    }
  }

  /** Lay an egg. */
  private void layEgg() {
//    System.out.println("Breakfast! " + "Egg loc: " + c + " " + r);

    Egg egg = new Egg();
    egg.setLocation(this.getX(), this.getY());

    Human.myFarmAnimals[this.getY()][this.getX()] = egg;
  }


}
