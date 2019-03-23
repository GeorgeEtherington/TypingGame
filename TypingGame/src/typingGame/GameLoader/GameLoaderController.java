package typingGame.GameLoader;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.BorderPane;
import typingGame.GameScreen.GameScreenController;
import typingGame.LevelGenerator.LevelGenerator;
import typingGame.LoadSceneButton;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoaderController {
    GameScreenController gameScreenController = new GameScreenController();
    Task task = new Task();
    private static Timer timer;
    private static int interval;
    public BorderPane loaderContainer;
    LevelGenerator generateLevel = new LevelGenerator();
    public int difficulty;
    public int round = 0;
    public String generatedLevel;
    public String userInputtedValue;


    public void loadLevel() {
        round++;
        generateRound();
        if (round == 1) {
            startTimer();
        }
        getInput();

    }

    public void setDifficulty(int difficultyLevel) {
        difficulty = difficultyLevel;
    }

    public void generateRound() {
        generatedLevel = generateLevel.generateLevel(difficulty, round);
    }

    public void getInput() {
        System.out.println(round);
        if (round < 2) {
            gameScreenController = LoadSceneButton.loadScene("GameScreen/gameScreen.fxml", loaderContainer);
        }
        gameScreenController.setLevel(generatedLevel);
    }

    public class Task extends TimerTask {
        public void run() {

            Platform.runLater(() -> {
                System.out.println(String.valueOf(setInterval()));
            });
            if (gameScreenController.userInput != null) {
                userInputtedValue = gameScreenController.userInput;
                gameScreenController.userInput = null;
                gameScreenController.levelBox.setText(null);
                gameScreenController.inputBox.setText(null);
                System.out.println(userInputtedValue);
                checkInput();
                interval = 10;
            }
        }
    }
        public void startTimer() {
            int delay = 1000;
            int period = 1000;
            timer = new Timer();

                interval = Integer.parseInt("10");

                timer.scheduleAtFixedRate(task, delay, period);

        }

        private final int setInterval() {
            if (interval == 1) {
              cancelTimer();
            }
            interval--;
            gameScreenController.timerLabel.textProperty().bind(new SimpleIntegerProperty(interval).asString());
            return interval;
        }

        public void cancelTimer() {
            task.cancel();
        }

        public void checkInput() {
        boolean missingChartrue = false;
            String[] inputArray = userInputtedValue.split("");
            String[] levelArray = generatedLevel.split("");

            int loopVariable = 0;
            if (levelArray.length<= inputArray.length){
                loopVariable = levelArray.length;


            }
            else{
                missingChartrue = true;
                loopVariable = inputArray.length;
            }

            int count = inputArray.length;
            for (int i = 0; i < loopVariable; i++) {
                if (inputArray[i].equals(levelArray[i])) {
                    System.out.println("true");
                    count--;
                } else {
                    System.out.println("false");

                }
            }

                count = inputArray.length - count;

            if (missingChartrue){
                loopVariable = levelArray.length;
            }

            System.out.println(Double.valueOf(count) / Double.valueOf(loopVariable) * 100.00);
            if (round == difficulty + 2) {
                System.out.println("you win");
                cancelTimer();
                gameScreenController.loadScreen();
            } else {
                userInputtedValue = null;
                loadLevel();
            }
        }
    }

