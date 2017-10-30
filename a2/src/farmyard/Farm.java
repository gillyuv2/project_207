package farmyard;

import java.util.ArrayList;

/** Farm class to hold all the objects to show in the java fx when the animation starts. */
public class Farm {
  public static ArrayList<FarmMethods> myFarmAnimals = new ArrayList<>();
  public static ArrayList<FarmMethods> track1 = new ArrayList<>();
  public static ArrayList<FarmMethods> track2 = new ArrayList<>();
  static ArrayList<Egg> eggList = new ArrayList<>();
  static ArrayList<AnimalFood> foodList = new ArrayList<>();
  static ArrayList<AnimalManure> manureList = new ArrayList<>();

  /** An Empty constructor for Farm. */
  public Farm() {}
}
