package farmyard;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Animals extends FarmMethods {

  private ArrayList<FarmMethods> collector = new ArrayList<FarmMethods>();
  private String manure;
  private FarmMethods target = null;
  private GraphicsContext g;

  public Animals() {}

  void setManure(String newManure) {
    this.manure = newManure;
  }

  public void setTarget(FarmMethods newTarget) {
    this.target = newTarget;
  }

  private String reverseAppearance() {
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

  private void turnAround() {
    this.setAppearance(this.reverseAppearance());
    if (this.getX() <= 0) {
      this.setLocation(1, this.getY());
    } else if (this.getX() >= 1024) {
      this.setLocation(1023, this.getY());
    }
    if (this.getY() <= 0) {
      this.setLocation(this.getX(), 1);
    } else if (this.getY() >= 720) {
      this.setLocation(this.getX(), 719);
    }
  }

  private void digest() {

    AnimalManure newManure = new AnimalManure(this.getX(), this.getY());
    newManure.setAppearance(this.manure);

  }
  void clearCollection(){
    this.collector.clear();
  }
  ArrayList getCollection(){
    return this.collector;
  }

  private static Egg eggLocator() {
    if (Farm.eggList.size() != 0) {
      return Farm.eggList.get(0);
    }
    return null;
  }

  private static AnimalFood foodLocator() {
    if (Farm.foodList.size() != 0) {
      return Farm.foodList.get(0);
    }
    return null;
  }

  private static AnimalManure manureLocator() {
    if (Farm.manureList.size() != 0) {
      return Farm.manureList.get(0);
    }
    return null;
  }

  public void move() {

      double d = Math.random();
      if (target == null) {
          if ((this instanceof Chicken) || (this instanceof Pig)) {
              target = Animals.foodLocator();
          } else if (this instanceof Human) {
              target = Animals.eggLocator();

          } else if (this instanceof PoopCollector) {
              target = Animals.manureLocator();
          }
      }

      if (target != null) {

          if (this.getX() == target.getX() && this.getY() == target.getY()) {

              this.collector.add(target);

              Farm.track1.add(target);
              if ((this instanceof Chicken) || (this instanceof Pig)) {
                  Farm.foodList.remove(target);
              } else if (this instanceof Human) {
                  Farm.eggList.remove(target);
              } else if (this instanceof PoopCollector) {
                  Farm.manureList.remove(target);
              }
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


          if (d < 0.25) {
              this.setLocation(this.getX(), this.getY() + 3);
          } else if (0.25 < d && d < 0.5) {
              this.setLocation(this.getX(), this.getY() - 3);
          } else if (0.5 < d && d < 0.75) {
              this.setLocation(this.getX() + 3, this.getY());
          } else {
              this.setLocation(this.getX() - 3, this.getY());
          }

      }

      if (this.collector.size() > 1) {
          this.collector.clear();
          digest();
      }

      if (Math.random() < 0.1) {
          turnAround();
      }
  }
}
