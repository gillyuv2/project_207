package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * A Human
 */
public class Human extends Animals {

  /** The animal food the human is feeding his/her beloved animals. */

  /**
   * (int)(640/6) columns, (int)(480/10) rows.
   */
//  public static FarmMethods[][] myFarmAnimals = new FarmMethods[(int) (1024)][(int) (720)];
  /** How this lovely human appears on the screen. */

  /**
   * Indicates whether this human is moving right.
   */
  private boolean goingRight;
  /**
   * This human's first coordinate.
   */


  private Egg target = null;
  /**
   * This human's second coordinate.
   */
  private int c;

  private ArrayList<Egg> myBasket = new ArrayList<Egg>();
  private GraphicsContext g;

  /**
   * Constructs a new Human.
   */
  public Human(int x, int y) {
      this.setColor(Color.SANDYBROWN.darker());
      this.setAppearance("human");
      this.setLocation(x,y);
      this.goingRight = true;
  }

  /**
   * Causes human to drop down 4 piece s of food all around.
   */
  private void dropFood() {

    AnimalFood fooood = new AnimalFood(this.getX() - 1, this.getY() - 1);
    Farm.myFarmAnimals[this.getY()][this.getX()] = fooood;
    Farm.animalFoodList.add(fooood);

    fooood = new AnimalFood(this.getX() - 1, this.getY() + 1);
    Farm.myFarmAnimals[this.getY()][this.getX()] = fooood;
    Farm.animalFoodList.add(fooood);
    fooood = new AnimalFood(this.getX() + 1, this.getY() - 1);
    Farm.myFarmAnimals[this.getY()][this.getX()] = fooood;
    Farm.animalFoodList.add(fooood);
    fooood = new AnimalFood(this.getX() + 1, this.getY() + 1);
    Farm.myFarmAnimals[this.getY()][this.getX()] = fooood;
    Farm.animalFoodList.add(fooood);


  }


  public void draw(GraphicsContext g) {
    g.fillText("Eggs: " + myBasket.size(), 20, 30);
    drawString(g, this.getAppearance(), this.getX(), this.getY());
  }


  /**
   * Causes this item to take its turn in the farm-pensimulation.
   */
  public void move() {
    double d = Math.random();
    if (target == null) {
      target = Animals.eggLocator();
      System.out.println(target);
    }

    if (target != null) {

      // Am I on an egg?
      if (this.getX() == target.getX() && this.getY() == target.getY()) {

        this.myBasket.add(target);
        System.out.println(Farm.eggList);
        Farm.eggList.remove(target);
        Farm.myFarmAnimals[target.getY()][target.getX()] = null;
        target = null;

        if (myBasket.size() % 12 == 0) {
//          System.out.println("Dozen!");
          this.draw(g);
        }

      } else {

        // move toward the egg
        if (this.getY() < target.getY()) {
          this.setLocation(this.getX(), this.getY() + 1);
        } else if (this.getY() > target.getY()) {
          this.setLocation(this.getX(), this.getY() - 1);
        } else {
          this.setLocation(this.getX(), this.getY());
        }
        if (this.getX() < target.getX()) {
          this.setLocation(this.getX() + 1, this.getY());
        } else if (this.getX() > target.getX()) {
          this.setLocation(this.getX() - 1, this.getY());
        } else {
          this.setLocation(this.getX(), this.getY());
        }
      }
    } else {
      // no egg to pick up
      // Move one spot to the right or left.

      if (d < 0.25) {
        this.setLocation(this.getX(), this.getY() + 1);
      } else if (0.25 < d && d < 0.5) {
        this.setLocation(this.getX(), this.getY() - 1);
      } else if (0.5 < d && d < 0.75) {
        this.setLocation(this.getX() + 1, this.getY());
      } else {
        this.setLocation(this.getX() - 1, this.getY());
      }


      // Figure out whether I should drop food.
      double e = Math.random();
      if (e < 0.5) {
        dropFood();
      }

      // Figure out whether I turn around.
      double f = Math.random();
      if (f < 0.3) {
        turnAround();
      }
    }
  }



}

