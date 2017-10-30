package farmyard;


import javafx.scene.paint.Color;



public class Chicken extends Animals {

  /** Constructs a new Chicken. */
  public Chicken(int x, int y) {
    this.setColor(Color.RED);
    this.setAppearance("/'/>");
    this.setManure(".");
    this.setLocation(x, y);
  }

  /** Causes this item to take its turn in the farm-pen simulation. */
  public void chickenMove() {
      this.move();

      if (Math.random() < 0.01) {
        layEgg();
      }

  }

  /** Lay an egg. */
  private void layEgg() {
    Egg egg = new Egg(this.getX(), this.getY());
    Farm.track2.add(egg);
    Farm.eggList.add(egg);
  }
}
