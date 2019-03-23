package typingGame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import typingGame.GetHelp.GetHelpController;

import java.io.IOException;

    public class LoadSceneButton {

        public static <T> T loadScene(String scene, Node node) {
            try {
                FXMLLoader loader = new FXMLLoader(LoadSceneButton.class.getResource(scene));
                Parent root = loader.load();
                node.getScene().setRoot(root);
                return loader.getController();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

}


