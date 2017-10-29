package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** A Human */
public class Human extends Animals {

  /** The animal food the human is feeding his/her beloved animals. */

  /** (int)(640/6) columns, (int)(480/10) rows. */
  public static FarmMethods[][] myFarmAnimals = new FarmMethods[(int) (480 / 10)][(int) (640 / 6)];
  /** How this lovely human appears on the screen. */

  /** Indicates whether this human is moving right. */
  boolean goingRight;
  /** This human's first coordinate. */
  int r;

  Egg target = null;
  /** This human's second coordinate. */
  private int c;

  private ArrayList<Egg> myBasket = new ArrayList<Egg>();
  private GraphicsContext g;

  /** Constructs a new Human. */
  public Human() {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance("human");

    this.goingRight = true;
  }

  /** Causes human to drop down 4 piece s of food all around. */
  protected void dropFood() {
    AnimalFood fooood = new AnimalFood();
    fooood.setLocation(this.getX() - 1, this.getY() - 1);
    myFarmAnimals[this.getY() - 1][this.getX() - 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(this.getX() - 1, this.getY() + 1);
    myFarmAnimals[this.getY() - 1][this.getX() + 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(this.getX() + 1, this.getY() - 1);
    myFarmAnimals[this.getY() + 1][this.getX() - 1] = fooood;

    fooood = new AnimalFood();
    fooood.setLocation(this.getX() + 1, this.getY() + 1);
    myFarmAnimals[this.getY() + 1][this.getX() + 1] = fooood;
  }



  public void draw(GraphicsContext g) {
    g.fillText("Eggs: " + myBasket.size(), 2 * 10, 2 * 6);
    drawString(g, this.getAppearance(), this.getX(), this.getY());
  }



  /** Causes this item to take its turn in the farm-pensimulation. */
  public void move() {

    if (target == null) {
      target = Chicken.aneggishere();
    }

    if (target != null) {
//      System.out.println(
//          "Target acquired: " + target.getX() + " " + target.y + "| Me: " + c + " " + r);
      // Am I on an egg?
      if (this.getY() == target.getX() && this.getX() == target.getY()) {
//        System.out.println("Egg!");
        this.myBasket.add(target);
        target = null;
        if (myBasket.size() % 12 == 0) {
//          System.out.println("Dozen!");
          g.fillText("Eggs: " + myBasket.size(), 1 * 10, 1 * 6);
        }

      } else {

        // move toward the egg
        if (this.getY() < target.getX()) {
          this.setLocation(this.getX(), this.getY()+1);
        } else {
          this.setLocation(this.getX(), this.getY()-1);
        }
        if (c < target.getY()) {
          this.setLocation(this.getX()+1, this.getY());
        } else {
          this.setLocation(this.getX()-1, this.getY());
        }
      }
    } else // no egg to pick up
    // Move one spot to the right or left.
    if (goingRight) {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        this.setLocation(this.getX(), this.getY()+1);
      } else if (d < 0.2) {
        this.setLocation(this.getX(), this.getY()-1);
      }
      this.setLocation(this.getX()+1, this.getY());
    } else {
      // Figure out whether to move up or down, or neither.
      double d = Math.random();
      if (d < 0.1) {
        this.setLocation(this.getX(), this.getY()+1);
      } else if (d < 0.2) {
        this.setLocation(this.getX(), this.getY()-1);
      }
      this.setLocation(this.getX()-1, this.getY());
    }

    // Figure out whether I should drop food.
    double d = Math.random();
    if (d < 0.05) {
      dropFood();
    }

    // Figure out whether I turn around.
    d = Math.random();
    if (d < 0.1) {
      turnAround();
    }
  }
}
