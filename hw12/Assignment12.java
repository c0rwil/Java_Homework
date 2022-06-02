
/**
 * Assignment 12.java 
 * Name:        Carlos Corral-Williams
 * Student ID:  1222280826
 * Lecture:     MWF 10:10am-11:00am
 * Description: This class constructs the application and sets the scene for our panels to launch onto.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Assignment12 extends Application
{
    public static final int WIN_WIDTH = 450;
    public static final int WIN_HEIGHT = 300;
    private static String WIN_TITLE = "CSE205 Assignment 12";

    @Override
    public void start(Stage primaryStage)
    {
        ControlPanel root = new ControlPanel(WIN_WIDTH, WIN_HEIGHT);
        root.setPrefSize(WIN_WIDTH, WIN_HEIGHT);

        Scene scene = new Scene(root, WIN_WIDTH, WIN_HEIGHT);
        primaryStage.setTitle(WIN_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
