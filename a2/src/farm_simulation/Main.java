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



import java.util.ArrayList;

/** Our take on the "classical" game Farm Ville */
public class Main extends Application {

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

    Farm.myFarmAnimals.add( new Chicken(0, 0));
    Farm.myFarmAnimals.add( new Chicken(16, 12));
    Farm.myFarmAnimals.add( new Chicken(13, 10));
    Farm.myFarmAnimals.add( new Chicken(30, 30));
    Farm.myFarmAnimals.add( new Chicken(0, 30));
    Farm.myFarmAnimals.add( new Chicken(10, 0));
    Farm.myFarmAnimals.add( new Chicken(27, 0));
    Farm.myFarmAnimals.add( new Chicken(0, 18));
    Farm.myFarmAnimals.add( new Chicken(0, 27));
    Farm.myFarmAnimals.add( new Chicken(50, 0));
    Farm.myFarmAnimals.add( new Chicken(0, 10));
    Farm.myFarmAnimals.add( new Pig(6, 0));
    Farm.myFarmAnimals.add( new Pig(0, 30));
    Farm.myFarmAnimals.add( new Human(60, 0));
    Farm.myFarmAnimals.add( new PoopCollector("Cleaner1",50, 10));
    Farm.myFarmAnimals.add( new PoopCollector("Cleaner2",10, 10));
    Farm.myFarmAnimals.add( new PoopCollector("Cleaner3",20, 10));

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
                for (Object item : Farm.myFarmAnimals ) {
                    if (item != null)
                      if (item instanceof Chicken) {
                        ((Chicken) item).move();
                      } else if (item instanceof Pig) {
                        ((Pig) item).move();
                      } else if (item instanceof Human) {
                          ((Human) item).move();
                      } else if (item instanceof PoopCollector) {
                              ((PoopCollector) item).move();
                      } else if (item instanceof AnimalFood) {
                        AnimalFood lolfood = (AnimalFood) item;

                        if (Wind.windVertical() == 1) lolfood.blownUp();
                        else if (Wind.windVertical() == -1) lolfood.blownDown();

                        if (Wind.windHorizontal() == -1) lolfood.blownLeft();
                        else if (Wind.windHorizontal() == 1) lolfood.blownRight();
                      }
                }
                Farm.myFarmAnimals.removeAll(Farm.track1);
                Farm.track1.clear();
                Farm.myFarmAnimals.addAll(Farm.track2);
                Farm.track2.clear();
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
      for (Object item:Farm.myFarmAnimals) {
          if (item != null) {
              if (item instanceof Chicken) {
            ((Chicken) item).draw(gc);
          } else if (item instanceof Pig) {
            ((Pig) item).draw(gc);
          } else if (item instanceof Human) {
            ((Human) item).draw(gc);
              } else if (item instanceof PoopCollector) {
                  ((PoopCollector) item).draw(gc);
          } else if (item instanceof AnimalManure) {
            ((AnimalManure) item).draw(gc);
          } else if (item instanceof AnimalFood) {
            ((AnimalFood) item).draw(gc);
          } else if (item instanceof Egg) {
            ((Egg) item).draw(gc);
          }
        }

    }
  }
}
