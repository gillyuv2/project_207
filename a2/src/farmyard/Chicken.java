package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Chicken extends Animals {


  private ArrayList<AnimalFood> belly = new ArrayList<>();

  boolean goingRight;
  private ArrayList<AnimalFood> myBasket = new ArrayList<AnimalFood>();
  AnimalFood target = null;
  private GraphicsContext g;


  /** Constructs a new Chicken. */
  public Chicken(int x, int y) {
    this.setColor(Color.RED);
    this.setAppearance("/'/>");
    this.setManure(".");
    this.goingRight = true;
    this.setLocation(x,y);
  }

  /** Set this item's location. */



  /** Causes this item to take its turn in the farm-pen simulation. */
  public void move() {

    double d = Math.random();
    if (target == null) {
      target = Animals.foodLocator();

    }

    if (target != null) {

      // Am I on an egg?
      if (this.getX() == target.getX() && this.getY() == target.getY()) {

        this.belly.add(target);
        Farm.animalFoodList.remove(target);
        Farm.myFarmAnimals[target.getY()][target.getX()] = null;
        target = null;


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
    }

    if (this.belly.size() > 1){
      this.belly.clear();
      System.out.println("Pooooooooooooooooooop");
      digest();}
    // Every now and then lay an egg.
    double d2 = Math.random();
    if (Math.random() < 0.1) {
      layEgg();
    }

    double d3 = Math.random();
    if (Math.random() < 0.1) {
      turnAround();
    }
  }

  /** Lay an egg. */
  private void layEgg() {
    Egg egg = new Egg(this.getX(), this.getY());
    Farm.eggList.add(egg);
    Farm.myFarmAnimals[this.getY()][this.getX()] = egg;

    }
}
