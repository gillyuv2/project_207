package farm_simulation;

import farmyard.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Our take on the "classical" game Farm Ville */
public class Main extends Application {

  /** The width of a character. */
  public static final int charWidth = 6;
  /** The height of a character. */
  public static final int charHeight = 10;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("FarmVille");

    Group root = new Group();
    Scene theScene = new Scene(root);
    primaryStage.setScene(theScene);
    Canvas canvas = new Canvas(1024, 720);
    root.getChildren().add(canvas);

    GraphicsContext gc = canvas.getGraphicsContext2D();

    Farm.myFarmAnimals[0][0] = new Chicken(0, 0);

    Farm.myFarmAnimals[6][12] = new Chicken(6, 12);

    Farm.myFarmAnimals[17][4] = new Chicken(17, 4);

    Farm.myFarmAnimals[15][28] = new Chicken(15, 28);

    Farm.myFarmAnimals[23][18] = new Chicken(23, 18);

    Farm.myFarmAnimals[16][35] = new Chicken(16, 35);

    Farm.myFarmAnimals[16][22] = new Chicken(16, 22);

    Farm.myFarmAnimals[23][18] = new Chicken(23, 18);

    Farm.myFarmAnimals[6][12] = new Chicken(6, 12);

    Farm.myFarmAnimals[10][20] = new Pig(10, 20);

    Farm.myFarmAnimals[20][10] = new Pig(20, 10);

    Farm.myFarmAnimals[30][30] = new Human(30, 30);


    drawShapes(gc);

    Timeline gameLoop = new Timeline();
    gameLoop.setCycleCount(Timeline.INDEFINITE);
    final long timeStart = System.currentTimeMillis();

    KeyFrame kf =
        new KeyFrame(
            Duration.seconds(0.5),
            new EventHandler<ActionEvent>() {
              public void handle(ActionEvent ae) {
                double t = (System.currentTimeMillis() - timeStart) / 1000.0;

                for (int a = 0; a != (int) (1024); a++) {
                  for (int b = 0; b != (int) (720); b++) {
                    if (Farm.myFarmAnimals[a][b] != null)
                      if (Farm.myFarmAnimals[a][b] instanceof Chicken) {
                        ((Chicken) Farm.myFarmAnimals[a][b]).move();
                      } else if (Farm.myFarmAnimals[a][b] instanceof Pig) {
                        ((Pig) Farm.myFarmAnimals[a][b]).move();
                      } else if (Farm.myFarmAnimals[a][b] instanceof Human) {
                        ((Human) Farm.myFarmAnimals[a][b]).move();
                      } else if (Farm.myFarmAnimals[a][b] instanceof AnimalManure) {

                      }
                      else if (Farm.myFarmAnimals[a][b] instanceof AnimalFood) {
                      // Figure out whether to float left or right, if at all.
                        AnimalFood lolfood = (AnimalFood) Farm.myFarmAnimals[a][b];

                        lolfood.d = Wind.windHorizontal();
                        if (lolfood.d == -1) lolfood.blownUp();
                        if (lolfood.d == 1) lolfood.blownDown();
                        lolfood.d = Wind.windVertical();
                        if (lolfood.d == -1) lolfood.blownLeft();
                        if (lolfood.d == 1) lolfood.blownRight();
                      }
                  }
                }

                // Clear the canvas
                gc.clearRect(0, 0, 1024, 720);
                drawShapes(gc);
              }
            });

    gameLoop.getKeyFrames().add(kf);
    gameLoop.play();
    primaryStage.show();
  }

  private void drawShapes(GraphicsContext gc) {
    // Tell all the farmyard items to draw themselves.
    for (int a = 0; a != (int) (1024); a++) {
      for (int b = 0; b != (int) (720); b++) {
        if (Farm.myFarmAnimals[a][b] != null) {

          if (Farm.myFarmAnimals[a][b] instanceof Chicken) {

            ((Chicken) Farm.myFarmAnimals[a][b]).draw(gc);
          } else if (Farm.myFarmAnimals[a][b] instanceof Pig) {
            ((Pig) Farm.myFarmAnimals[a][b]).draw(gc);
          } else if (Farm.myFarmAnimals[a][b] instanceof Human) {
            ((Human) Farm.myFarmAnimals[a][b]).draw(gc);
          } else if (Farm.myFarmAnimals[a][b] instanceof AnimalManure) {
            ((AnimalManure) Farm.myFarmAnimals[a][b]).draw(gc);
          }
          if (Farm.myFarmAnimals[a][b] instanceof AnimalFood) {
            ((AnimalFood) Farm.myFarmAnimals[a][b]).draw(gc);
          }
          if (Farm.myFarmAnimals[a][b] instanceof Egg) {
            ((Egg) Farm.myFarmAnimals[a][b]).draw(gc);
          }
        }
      }
    }
  }
}
