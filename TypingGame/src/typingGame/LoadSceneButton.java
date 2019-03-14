package typingGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;

public class LoadSceneButton {

public void loadScene(String scene, Button button) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(scene));
        Parent root = loader.load();
        button.getScene().setRoot(root);
    } catch (
            IOException e) {
        e.printStackTrace();
    }
}

}


