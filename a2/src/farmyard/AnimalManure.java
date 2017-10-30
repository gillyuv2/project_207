package farmyard;

import javafx.scene.paint.Color;

public class AnimalManure extends FarmMethods {

    AnimalManure(int x, int y) {
        this.setLocation(x,y);
        this.setColor(Color.BLACK.darker().darker().darker());
        this.setAppearance("");
        Farm.track2.add(this);
        Farm.manureList.add(this);
    }

}
