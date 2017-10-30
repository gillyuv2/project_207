package farmyard;

import javafx.scene.paint.Color;


public class PoopCollector extends Animals {


  public PoopCollector(String id, int x, int y) {
    this.setColor(Color.SANDYBROWN.darker());
    this.setAppearance(id);
    this.setLocation(x, y);
  }
}
