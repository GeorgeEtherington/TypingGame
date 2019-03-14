package typingGame.GetHelp;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import typingGame.LoadSceneButton;

public class GetHelpController {
    public Button MainMenuButton;

    public void loadMainMenu(ActionEvent actionEvent) {
        LoadSceneButton loadMainMenu = new LoadSceneButton();
        loadMainMenu.loadScene("mainMenu.fxml", MainMenuButton);
    }
}
