package farmyard;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Animals extends FarmMethods {

    private ArrayList<FarmMethods> collector = new ArrayList<FarmMethods>();
    private String manure;
    private FarmMethods target = null;
    private GraphicsContext g;




    public Animals(){
    }

    void setManure(String newManure){
        this.manure = newManure;
    }

    public void setTarget(FarmMethods newTarget){
        this.target = newTarget;
    }

    String reverseAppearance() {
        String reverse = "";
        for (int i = this.getAppearance().length() - 1; i >= 0; i--) {
            switch (this.getAppearance().charAt(i)) {
                case '\\':
                    reverse += '/';
                    break;

                case '/':
                    reverse += '\\';
                    break;
                case ')':
                    reverse += '(';
                    break;
                case '(':
                    reverse += ')';
                    break;
                case '>':
                    reverse += '<';
                    break;
                case '<':
                    reverse += '>';
                    break;
                case '}':
                    reverse += '{';
                    break;
                case '{':
                    reverse += '}';
                    break;
                case '[':
                    reverse += ']';
                    break;
                case ']':
                    reverse += '[';
                    break;
                default:
                    reverse += this.getAppearance().charAt(i);
                    break;
            }
        }
        return reverse;
    }

    void turnAround() {
        this.setAppearance(this.reverseAppearance());
    }

    boolean digest() {
//    System.out.println("Pig stink");

        AnimalManure newManure = new AnimalManure(this.getX(), this.getY());
        newManure.setAppearance(this.manure);
        return true;
    }

    static Egg eggLocator() {
        if (Farm.eggList.size() != 0 ){
            return Farm.eggList.get(0);
        }
        return null;
    }
    static AnimalFood foodLocator() {
        if (Farm.foodList.size() != 0){
            return  Farm.foodList.get(0);
        }
        return null;
    }

    public static AnimalManure manureLocator() {
        if (Farm.manureList.size() != 0 ){
            return Farm.manureList.get(0);

        }
        return null;
    }

    public void moveAnimal() {
        double d = Math.random();
        if (target == null) {
            target = Animals.eggLocator();
            System.out.println(target);
        }

        if (target != null) {

            // Am I on an egg?
            if (this.getX() == target.getX() && this.getY() == target.getY()) {

                this.collector.add(target);
                Farm.myFarmAnimals.remove(target);
                target = null;

                if (collector.size() % 12 == 0) {
                    this.collector.clear();
                    this.draw(g);
                }

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

        double f = Math.random();
        if (f < 0.3) {
            turnAround();
        }

    }
}
