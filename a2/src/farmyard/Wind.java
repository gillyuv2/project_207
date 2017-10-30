package farmyard;

/**
 * If the Wind is not blowing it is equally likely to move in one direction and has 10% chance to
 * remain still. If wind is moving horizontal/vertical it is 60% likely to remain in same direction,
 * 30% likely to reverse direction and 10% likely to go still.
 */
public class Wind {

  // Direction selector take 1, -1 and 0 as value
  private static int horizontal;
  private static int vertical;

  /**
   * Returns the vertical direction of the wind.
   *
   * @return int vertical
   */
  public static int windVertical() {
    vertical = Wind.windDirection(vertical);
    return vertical;
  }

  /**
   * returns the Horizontal Direction of the wind.
   *
   * @return int horizontal
   */
  public static int windHorizontal() {
    horizontal = Wind.windDirection(horizontal);
    return horizontal;
  }

  /**
   * Returns 0 if the wind still, or returns 1 or -1 randomly based on the input direction.
   * direction is always 0, 1 or -1.
   *
   * @return int direction
   */
  private static int windDirection(int direction) {
    // If the wind is still then assign the direction to wind according to the probability.
    if (direction == 0) {
        double d = Math.random();
      if (d < 0.010) {
        direction = -1;
        return direction;
      } else if (d < 0.020 && d > 0.010) {
        direction = 1;
        return direction;
      } else if (d > 0.02) {
        return direction;
      }
    }
    // If the wind is moving then change or retain direction or stops the wind.
    else {
      double d = Math.random();
      if (d > 0.09) {
        direction = 0;
        return direction;
      } else if (d < 0.045) {
        return direction;
      } else if (d < 0.09 && d > 0.045) {
        direction = -direction;
        return direction;
      }
    }return 0;
  }
}
