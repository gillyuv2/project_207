package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Chicken extends Animals {


  private ArrayList<AnimalFood> belly = new ArrayList<>();

  boolean goingRight;
  private ArrayList<AnimalFood> myBasket = new ArrayList<AnimalFood>();
  AnimalFood target = null;


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

    // Sometimes food doesn't sit well in the stomach, so I have to clear my stomach
    double d1 = Math.random();
    if (d1 < 0.2) {
      digest();
    }

    double d = Math.random();
    if (d < 0.25) {
      this.setLocation(this.getX(), this.getY()+1);
    } else if (0.25 < d && d < 0.5) {
      this.setLocation(this.getX(), this.getY()-1);
    } else if (0.5 < d && d < 0.75) {
      this.setLocation(this.getX() + 1, this.getY());
    } else{
      this.setLocation(this.getX() - 1, this.getY());
    }
    double f = Math.random();
    if (f < 0.1) {
      turnAround();
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
    Egg egg = new Egg(this.getX(), this.getY());
    Farm.eggList.add(egg);
    Farm.myFarmAnimals[this.getY()][this.getX()] = egg;

    }
}
