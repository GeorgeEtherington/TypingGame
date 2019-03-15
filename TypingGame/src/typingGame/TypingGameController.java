package typingGame;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class TypingGameController {

    public Button levelSelectButton;
    private LoadSceneButton loadSceneButton = new LoadSceneButton();

    public void loadLevelSelect(ActionEvent actionEvent) {
        loadSceneButton.loadScene("GameScreen/gameScreen.fxml", levelSelectButton);
    }

        public void loadHighScores (ActionEvent actionEvent){
            loadSceneButton.loadScene("HighScores/highScores.fxml", levelSelectButton);
        }

        public void loadHelp (ActionEvent actionEvent){
        loadSceneButton.loadScene("GetHelp/getHelp.fxml", levelSelectButton);
        }
    }

