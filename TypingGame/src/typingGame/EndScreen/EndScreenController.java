package typingGame.EndScreen;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import typingGame.LoadSceneButton;
import typingGame.TypingGameController;

public class EndScreenController {
    public Label resultLabel;
    public Label ScoreLabel;
    public BorderPane endScreenContainer;

    public void showEndMessage(Boolean gameState, Double score)
    {
        if (gameState) {
            resultLabel.textProperty().bind(new SimpleStringProperty("You Win!"));
        }else{
            resultLabel.textProperty().bind(new SimpleStringProperty("You Lose"));
        }
        ScoreLabel.textProperty().bind(new SimpleIntegerProperty((int)Math.round(score)).asString());
    }

    public void toMainMenu(){
        TypingGameController mainMenu = LoadSceneButton.loadScene("mainMenu.fxml", endScreenContainer);
    }
}
