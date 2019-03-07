package typingGame.GameScreen;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import typingGame.LevelGenerator.LevelGenerator;

public class GameScreenController {

    public TextField inputBox;
    public TextField levelBox;
    private int difficultyLevel;
    private int round = 1;
    private  LevelGenerator generator = new LevelGenerator();

    public void setLevel(){
       String level = generator.generateLevel(difficultyLevel, round);
        levelBox.setText(level);
    }

    public void submitInput(ActionEvent actionEvent) {
        //stopTimer();
        checkInput();

        if (round > difficultyLevel + 2) {
            System.out.println("You win");
            round = 1;
            difficultyLevel++;
        }
            inputBox.setText("");
            setLevel();
        }


    private boolean checkInput()
    {
        if (inputBox.getText().equals(levelBox.getText()) ){
            System.out.println("It Worked");
            round++;
            return true;
        }else{
            System.out.println("You either typed it wrong or something is wrong");
            return false;
        }
    }

    public void startGame(ActionEvent actionEvent) {
        difficultyLevel = 1;
       setLevel();
    }
}
