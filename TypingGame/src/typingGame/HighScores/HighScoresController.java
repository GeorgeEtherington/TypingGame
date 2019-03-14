package typingGame.HighScores;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import typingGame.LoadSceneButton;
import typingGame.Main;

public class HighScoresController {

    public Button MainMenuButton;
    public void loadMainMenu(ActionEvent actionEvent) {
        LoadSceneButton loadMainMenu = new LoadSceneButton();
        loadMainMenu.loadScene("mainMenu.fxml", MainMenuButton);
    }
}
