package farmyard;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class PoopCollector extends Animals {
  private ArrayList<AnimalManure> belly = new ArrayList<>();
  private AnimalManure target = null;

  public PoopCollector(String id, int x, int y) {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance(id);
    this.setLocation(x, y);
  }
}
