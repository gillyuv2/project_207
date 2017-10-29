package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Pig extends Animals {
    /**
     * How this Pig appears on the screen.
     */
    private ArrayList<AnimalFood> belly = new ArrayList<>();
    private GraphicsContext g;
    boolean goingRight;
    private AnimalFood target = null;
    /**
     * Constructs a new Pig.
     */
    public Pig(int x, int y) {
        this.setColor(Color.PINK.darker().darker().darker());
        this.setAppearance(":(8)");
        this.setManure("*");
        this.goingRight = true;
        this.setLocation(x,y);
    }


    /**
     * Causes this item to take its turn in the farm-pen simulation.
     */
    public void move() {
        double d = Math.random();
        if (target == null) {
            target = Animals.foodLocator();
        }

        if (target != null) {

            // Am I on an egg?
            if (this.getX() == target.getX() && this.getY() == target.getY()) {
//        System.out.println("Egg!");
                System.out.println(
                        "Target acquired: " + target.getX() + " " + target.getX() + "| Me: " + target.getY() + " " + target.getY());
                System.out.println(this.getX() + " ----  " + this.getY());
                Farm.animalFoodList.remove(target);
                this.belly.add(target);
//                target = null;

                target = Animals.foodLocator();



            } else {

                // move toward the egg
                if (this.getX() < target.getY()) {
                    this.setLocation(this.getX(), this.getY() + 1);
                } else if (this.getY() > target.getX()) {
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


            // Figure out whether I should drop food.


            // Figure out whether I turn around.
            double f = Math.random();
            if (f < 0.3) {
                turnAround();
            }
        }


        if (Math.random() < 0.2) {
            digest();
        }

        if (Math.random() < 0.1) {
            turnAround();
        }
    }

}
