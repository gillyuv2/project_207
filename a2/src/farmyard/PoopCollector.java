package farmyard;

import javafx.scene.paint.Color;

import java.util.ArrayList;


public class PoopCollector extends Animals {
    private ArrayList<AnimalManure> belly = new ArrayList<>();
    private AnimalManure target = null;
    public PoopCollector(String id, int x, int y) {
        this.setColor(Color.SANDYBROWN.darker());
        this.setAppearance(id);
        this.setLocation(x,y);

    }


    public void move() {
        double d = Math.random();
        if (target == null) {
            target = Animals.manureLocator();
            System.out.println(target);
        }

        if (target != null) {

            // Am I on an egg?
            if (this.getX() == target.getX() && this.getY() == target.getY()) {

                this.belly.add(target);
                Farm.track1.add(target);
                Farm.manureList.remove(target);
//                Farm.myFarmAnimals.remove(target);
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

        if (Math.random() < 0.1) {
            turnAround();
        }


    }


}
