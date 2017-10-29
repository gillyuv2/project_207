package farmyard;

import java.util.ArrayList;

public class Animals extends FarmMethods {

    private ArrayList<FarmMethods> belly = new ArrayList<FarmMethods>();
    private String manure;
    private int horizontal;
    private int vertical;
    private FarmMethods target = null;
    public Animals(){
    }

    public void setManure(String newManure){
        this.manure = newManure;

    }

    public String reverseAppearance() {
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

    public void turnAround() {
        this.setAppearance(this.reverseAppearance());
    }

    public boolean digest() {
//    System.out.println("Pig stink");

        AnimalManure newManure = new AnimalManure();
        newManure.setAppearance(this.manure);
        newManure.setLocation(this.getX(), this.getY());

        Human.myFarmAnimals[this.getX()][this.getY()] = newManure;
        return true;
    }
}
