package typingGame.LevelSelect;

import javafx.scene.layout.BorderPane;
import typingGame.GameLoader.GameLoaderController;
import typingGame.GameScreen.GameScreenController;
import typingGame.LoadSceneButton;

public class LevelSelectMenuController {
    public BorderPane container;
    public int selectedLevel;
    public boolean unlimited = false;
    public void levelOneSelected() {
        selectedLevel = 1;
        runLevel();
    }

    public void levelTwoSelected(){
        selectedLevel = 2;
        runLevel();
    }

    public void levelThreeSelected(){
        selectedLevel = 3;
        runLevel();
    }

    public void levelFourSelected(){
        selectedLevel = 4;
        runLevel();
    }

    public void levelFiveSelected(){
        selectedLevel = 5;
        runLevel();
    }

    public void levelSixSelected(){
        selectedLevel = 6;
        runLevel();
    }

    public void levelUnlimitedSelected(){
        selectedLevel = 6;
        unlimited = true;
        runLevel();
    }

    public void runLevel() {
        GameLoaderController controller = LoadSceneButton.loadScene("GameLoader/gameLoader.fxml", container);
        controller.setDifficulty(selectedLevel);
        if (unlimited){
            controller.setUnlimited();
        }
        controller.loadLevel();
    }
}
