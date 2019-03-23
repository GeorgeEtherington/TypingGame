package typingGame.GameScreen;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import typingGame.LevelGenerator.LevelGenerator;
import typingGame.LoadSceneButton;

public class GameScreenController {

    public TextField inputBox;
    public TextField levelBox;
    public static String userInput;
    public Button submitButton;
    public BorderPane screenController;
    public Label timerLabel;

    public void setLevel(String level){

        levelBox.setText(level);
        inputBox.setText(null);
    }


    public void submitInput(ActionEvent actionEvent) {
        System.out.println("test");

            userInput = inputBox.getText();
        }


    public void loadScreen(){
        LoadSceneButton loadSceneButton = new LoadSceneButton();
        loadSceneButton.loadScene("LevelSelect/LevelSelectMenu.fxml", screenController);

    }
}
