package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/** A Human */
public class Human extends Animals {

  private Egg target = null;
  /** This human's second coordinate. */
  private int c;

  private ArrayList<Egg> myBasket = new ArrayList<Egg>();
  private GraphicsContext g;

  /** Constructs a new Human. */
  public Human(int x, int y) {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance("human");
    this.setLocation(x, y);
  }

  /** Causes human to drop down 4 piece s of food all around. */
  private void dropFood() {

    AnimalFood fooood = new AnimalFood(this.getX() - 1, this.getY() - 1);
    Farm.track2.add(fooood);

    fooood = new AnimalFood(this.getX() - 1, this.getY() + 1);
    Farm.track2.add(fooood);

    fooood = new AnimalFood(this.getX() + 1, this.getY() - 1);
    Farm.track2.add(fooood);

    fooood = new AnimalFood(this.getX() + 1, this.getY() + 1);

    Farm.track2.add(fooood);
  }

  public void draw(GraphicsContext g) {
    g.fillText("Eggs: " + myBasket.size(), 20, 30);
    drawString(g, this.getAppearance(), this.getX(), this.getY());
  }

  /** Causes this item to take its turn in the farm-pensimulation. */
  public void humanMove() {
      this.move();
      myBasket.addAll(this.getCollection());
      this.clearCollection();
      if (Math.random() < 0.05){
      this.dropFood();
      }
  }
}


