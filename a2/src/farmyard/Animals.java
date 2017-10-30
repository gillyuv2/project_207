package farmyard;

import java.util.ArrayList;

/**
 * A Animals Class which is the super class in the package farmyard for the Chicken, Pig, Human and
 * PoopCollector. Provides all the basic variables and methods for its subclasses.
 */
public class Animals extends FarmMethods {

  // An ArrayList to hold the FarmMethods for the subclasses.
  private ArrayList<FarmMethods> collector = new ArrayList<>();
  // A string to represent the manure of Animals.
  private String manure;
  // A target FarmMethod to capture.
  private FarmMethods target = null;

  /**
   * An Empty Constructor for the Animals class.
   *
   * @return None
   */
  public Animals() {}

  /**
   * Method to set the given Manure string for the Animals.
   *
   * @param newManure Manure representation for the Animals.
   */
  void setManure(String newManure) {
    this.manure = newManure;
  }

  /**
   * Reverses the appearance of the Animal.
   *
   * @return String
   */
  private String reverseAppearance() {

    StringBuilder reverse = new StringBuilder();
    for (int i = this.getAppearance().length() - 1; i >= 0; i--) {
      switch (this.getAppearance().charAt(i)) {
        case '\\':
          reverse.append('/');
          break;

        case '/':
          reverse.append('\\');
          break;
        case ')':
          reverse.append('(');
          break;
        case '(':
          reverse.append(')');
          break;
        case '>':
          reverse.append('<');
          break;
        case '<':
          reverse.append('>');
          break;
        default:
          reverse.append(this.getAppearance().charAt(i));
          break;
      }
    }
    return reverse.toString();
  }

  /**
   * Reverses the direction of the Animal and its appearance.
   *
   * @return None
   */
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

  /**
   * A method to digest the food of the animal and creates the AnimalManure for the animal with
   * particular appearance.
   *
   * @return None
   */
  private void digest() {

    AnimalManure newManure = new AnimalManure(this.getX(), this.getY());
    newManure.setAppearance(this.manure);
  }

  /**
   * Clears the this.collector.
   *
   * @return None
   */
  void clearCollection() {
    this.collector.clear();
  }

  /**
   * Return the this.collection for a particular Animal.
   *
   * @return this.collection
   */
  ArrayList getCollection() {
    return this.collector;
  }

  /**
   * Locates the Egg for as the target.
   *
   * @return Egg
   */
  private static Egg eggLocator() {
    if (Farm.eggList.size() != 0) {
      return Farm.eggList.get(0);
    }
    return null;
  }
  /**
   * Locates the AnimalFood for as the target.
   *
   * @return AnimalFood
   */
  private static AnimalFood foodLocator() {
    if (Farm.foodList.size() != 0) {
      return Farm.foodList.get(0);
    }
    return null;
  }
  /**
   * Locates the AnimalManure for as the target.
   *
   * @return AnimalManure
   */
  private static AnimalManure manureLocator() {
    if (Farm.manureList.size() != 0) {
      return Farm.manureList.get(0);
    }
    return null;
  }

  /**
   * Moves the animal towards the specific target and randomly if the target is null. It turns the
   * animals around randomly and digests the food if the collection is fill upto certain limit.
   * @return None
   */
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
