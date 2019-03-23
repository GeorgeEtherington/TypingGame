package typingGame.GetHelp;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import typingGame.LoadSceneButton;

public class GetHelpController {
    //TODO: Make lower camel
    public Button MainMenuButton;

    public void loadMainMenu(ActionEvent actionEvent) {
        LoadSceneButton.loadScene("mainMenu.fxml", MainMenuButton);
    }
}
