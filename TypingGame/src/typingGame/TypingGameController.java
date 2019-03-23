package typingGame;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import typingGame.GameLoader.GameLoaderController;

public class TypingGameController {

    public Button levelSelectButton;
    private LoadSceneButton loadSceneButton = new LoadSceneButton();

    public void loadLevelSelect(ActionEvent actionEvent) {
       loadSceneButton.loadScene("LevelSelect/LevelSelectMenu.fxml", levelSelectButton);

    }

        public void loadHighScores (ActionEvent actionEvent){
            //loadSceneButton.loadScene("HighScores/highScores.fxml", levelSelectButton);

            GameLoaderController controller = LoadSceneButton.loadScene("GameLoader/gameLoader.fxml", levelSelectButton);
            controller.loadLevel();
        }

        public void loadHelp (ActionEvent actionEvent){
        loadSceneButton.loadScene("GetHelp/getHelp.fxml", levelSelectButton);
        }
    }

