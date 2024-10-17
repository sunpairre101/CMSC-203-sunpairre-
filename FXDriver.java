/*
 * Class: CMSC203 
 * Instructor:Professor Tarek
 * Description: Lab2
 * Due: 10/16/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Sunpairre Tamene
*/
package L2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXDriver extends Application {

    @Override
    public void start(Stage stage) {
        // Instantiate the FXMainePaine (this is the root of your scene)
        FXMainePaine root = new FXMainePaine();

        // Create a Scene with the root (FXMainePaine)
        Scene scene = new Scene(root, 400, 200);

        // Set the scene to the stage
        stage.setScene(scene);

        // Set the stage title
        stage.setTitle("Hello World GUI");

        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}

