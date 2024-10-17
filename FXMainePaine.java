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

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainePaine extends VBox {

    // Declare buttons, label, and text field
    private Button helloButton, howdyButton, chineseButton, clearButton, exitButton;
    private Label label;
    private TextField textField;
    private HBox buttonBox, inputBox;

    // Declare an instance of DataManager
    private DataManager dataManager;

    public FXMainePaine() {
        // Instantiate the buttons, label, and text field
        helloButton = new Button("Hello");
        howdyButton = new Button("Howdy");
        chineseButton = new Button("Chinese");
        clearButton = new Button("Clear");
        exitButton = new Button("Exit");

        label = new Label("Greeting:");
        textField = new TextField();

        // Instantiate the HBoxes
        buttonBox = new HBox(10);  // 10 is the spacing between elements
        inputBox = new HBox(10);

        // Instantiate the DataManager instance
        dataManager = new DataManager();

        // Add the label and text field to the inputBox
        inputBox.getChildren().addAll(label, textField);

        // Add the buttons to the buttonBox
        buttonBox.getChildren().addAll(helloButton, howdyButton, chineseButton, clearButton, exitButton);

        // Set margins and set alignment of the components
        inputBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        inputBox.setPadding(new Insets(20));
        buttonBox.setPadding(new Insets(20));

        // Add the HBoxes to this FXMainPanel (VBox)
        this.getChildren().addAll(inputBox, buttonBox);

        // Handle button actions
        helloButton.setOnAction(e -> textField.setText(dataManager.getHello()));
        howdyButton.setOnAction(e -> textField.setText(dataManager.getHowdy()));
        chineseButton.setOnAction(e -> textField.setText(dataManager.getChinese()));
        clearButton.setOnAction(e -> textField.clear());
        exitButton.setOnAction(e -> Platform.exit());
    }
}
	