package farmyard;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * A FarmMethods Class which is the highest class in the package farmyard. Provides all the basic
 * variables and methods.
 */
public abstract class FarmMethods {

  private String appearance;
  private int x;
  private Color color;
  private int y;

  /** An empty constructor for the FarmMethods. */
  public FarmMethods() {}

  /**
   * Sets the location of FarmMethods Object at the given parameters.
   *
   * @param x x co-ordinate of FarmMethods
   * @param y y co-ordinate of FarmMethods
   * @return None
   */
  void setLocation(int x, int y) {

    if (x >= 48) {
      this.x = 48;
    } else if (x < 0) {
      this.x = 1;
    } else {
      this.x = x;
    }
    if (y >= 640 / 6) {
      this.y = (640 / 6) - 1;
    } else if (y < 0) {
      this.y = 1;
    } else {
      this.y = y;
    }
  }

  /**
   * Returns the value of x co-ordinate.
   *
   * @return x
   */
  int getX() {
    return x;
  }
  /**
   * Returns the value of y co-ordinate.
   *
   * @return y
   */
  int getY() {
    return y;
  }

  /**
   * Sets the colour of the FarmMethod.
   *
   * @return None
   */
  void setColor(Color newColor) {
    this.color = newColor;
  }

  /**
   * Draws the String representation of the FarmMethod on the java fx during animation.
   *
   * @param g Object for the GraphicContext
   * @param s string representation of FarmMethod.
   * @param x the x co-ordinate
   * @param y the y-co-ordinate
   * @return None
   */
  void drawString(GraphicsContext g, String s, int x, int y) {
    g.setFill(this.color);
    g.fillText(s, x * 10, y * 6);
  }

  /**
   * Draws the representation of the FarmMethod on the java fx during animation.
   *
   * @param g Object for the GraphicContext
   * @return None
   */
  public void draw(GraphicsContext g) {

    drawString(g, appearance, x, y);
  }

  /**
   * Returns the string appearance of the FarmMethod.
   *
   * @return appearance
   */
  String getAppearance() {
    return appearance;
  }

  /**
   * Sets the string appearance of the FarmMethod.
   *
   * @param newAppearance String representation of the FarmMethod.
   */
  void setAppearance(String newAppearance) {
    this.appearance = newAppearance;
  }
}
