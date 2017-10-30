package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** Human class to make human object on the java fx when the animation starts. */
public class Human extends Animals {

  // A basket to hold the eggs collected from the chicken
  private ArrayList<Egg> myBasket = new ArrayList<>();

  /**
   * Constructor for the Human. Instantiates the Human and sets its location, color and appearance.
   *
   * @param x sets the x co-ordinate
   * @param y sets the y co-ordinate
   * @return None
   */
  public Human(int x, int y) {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance("human");
    this.setLocation(x, y);
  }

  /**
   * Human drops four pieces of food around it in Java fx.
   *
   * @return None
   */
  private void dropFood() {

    AnimalFood food = new AnimalFood(this.getX() - 1, this.getY() - 1);
    Farm.track2.add(food);

    food = new AnimalFood(this.getX() - 1, this.getY() + 1);
    Farm.track2.add(food);

    food = new AnimalFood(this.getX() + 1, this.getY() - 1);
    Farm.track2.add(food);

    food = new AnimalFood(this.getX() + 1, this.getY() + 1);

    Farm.track2.add(food);
  }

  /**
   * Draw method for human to show the Egg counter in the java fx during animation.
   *
   * @return None
   */
  public void draw(GraphicsContext g) {
    g.fillText("Eggs: " + myBasket.size(), 20, 30);
    drawString(g, this.getAppearance(), this.getX(), this.getY());
  }

  /**
   * Moves the Human object during the animation.
   *
   * @return None
   */
  public void humanMove() {
    this.move();
    myBasket.addAll(this.getCollection());
    this.clearCollection();
    if (Math.random() < 0.05) {
      this.dropFood();
    }
  }
}
