package typingGame.GameScreen;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import typingGame.EndScreen.EndScreenController;
import typingGame.LoadSceneButton;


public class GameScreenController {

    public TextField inputBox;
    public TextField levelBox;
    public static String userInput;
    public Button submitButton;
    public BorderPane screenController;
    public Label timerLabel;
    public Label scoreLabel;

    public void setLevel(String level) {
        levelBox.setText(level);
        inputBox.setText(null);
    }

    public void setUserInput(){
        userInput = inputBox.getText();
    }
    public void submitInput(ActionEvent actionEvent) {
        setUserInput();
    }
    public void loadScene(Boolean gameState, Double score){
        EndScreenController endScreenController = LoadSceneButton.loadScene("EndScreen/EndScreen.fxml", screenController);
        endScreenController.showEndMessage(gameState, score);
    }

    public void checkKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode()== KeyCode.ENTER){
            setUserInput();
        }
    }
}
