package typingGame.LevelSelect;

import javafx.scene.layout.BorderPane;
import typingGame.GameLoader.GameLoaderController;
import typingGame.GameScreen.GameScreenController;
import typingGame.LoadSceneButton;

public class LevelSelectMenuController {
    public BorderPane container;
    public int selectedLevel;
    public void levelOneSelected() {
        selectedLevel = 1;
        runLevel();
    }

    public void levelTwoSelected(){
        selectedLevel = 2;
        runLevel();
    }

    public void runLevel() {
        GameLoaderController controller = LoadSceneButton.loadScene("GameLoader/gameLoader.fxml", container);
        controller.setDifficulty(selectedLevel);
        controller.loadLevel();
    }
}
