package farmyard;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Pig extends Animals {
  /** How this Pig appears on the screen. */
  private ArrayList<AnimalFood> belly = new ArrayList<>();

  private AnimalFood target = null;

  /** Constructs a new Pig. */
  public Pig(int x, int y) {
    this.setColor(Color.PINK.darker().darker().darker());
    this.setAppearance(":(8)");
    this.setManure("*");
    this.setLocation(x, y);
  }
}
