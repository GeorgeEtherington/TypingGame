package typingGame.GameScreen;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import typingGame.LevelGenerator.LevelGenerator;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreenController {

    private static int interval;
    private static Timer timer;
    public TextField inputBox;
    public TextField levelBox;
    public TextField timerTextbox;
    private int difficultyLevel;
    private int round = 1;
    private  LevelGenerator generator = new LevelGenerator();

    public void setLevel(){
       String level = generator.generateLevel(difficultyLevel, round);
        levelBox.setText(level);
    }

    public void submitInput(ActionEvent actionEvent) {
        checkInput();

        if (round > difficultyLevel + 2) {
            System.out.println("You win");
            round = 1;
            difficultyLevel++;
        }
            inputBox.setText("");
            setLevel();
            cancelTimer();
            startTimer();
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
        startTimer();

    }
    public int startTimer() {

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = Integer.parseInt("10");
        System.out.println("10");
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timerTextbox.setText(String.valueOf(setInterval()));
            }
        }, delay, period);
        return interval;
    }

    private  final int setInterval() {
        if (interval == 0)
            cancelTimer();
        return --interval;
    }

    public void cancelTimer(){
        timer.cancel();
    }
}

