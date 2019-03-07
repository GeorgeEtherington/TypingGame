package typingGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import typingGame.LevelGenerator.LevelGenerator;

import java.io.IOException;

public class TypingGameController {

    public Button levelSelectButton;

    public void loadLevelSelect(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen/gameScreen.fxml"));
            Parent root = loader.load();
            levelSelectButton.getScene().setRoot(root);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }


    public void loadHighScores(ActionEvent actionEvent) {
    }

    public void loadHelp(ActionEvent actionEvent) {
    }

//    private void loadScene(String scene) {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
//            Parent root = loader.load();
//            levelSelectButton.getScene().setRoot(root);
//        } catch (
//                IOException e) {
//            e.printStackTrace();
//        }
//    }
}
