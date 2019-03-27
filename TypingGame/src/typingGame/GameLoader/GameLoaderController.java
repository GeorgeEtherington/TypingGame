package typingGame.GameLoader;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.layout.BorderPane;
import typingGame.EndScreen.EndScreenController;
import typingGame.GameScreen.GameScreenController;
import typingGame.LevelGenerator.LevelGenerator;
import typingGame.LoadSceneButton;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoaderController {
    GameScreenController gameScreenController = new GameScreenController();
    EndScreenController endScreenController = new EndScreenController();
    GameTask GameTask = new GameTask();
    private boolean unlimited = false;
    private static Timer Timer;
    private static int TimePassed;
    public BorderPane loaderContainer;
    LevelGenerator generateLevel = new LevelGenerator();
    public int Difficulty;
    public int Round = 0;
    public String GeneratedLevel;
    public String UserInputtedValue;
    public double Score;

    public void loadLevel() {
        Round++;
        generateRound();
        if (Round == 1) {
            startTimer();
        }
        getInput();

    }

    public void setDifficulty(int difficultyLevel) {
        Difficulty = difficultyLevel;
    }

    public void generateRound() {
        GeneratedLevel = generateLevel.generateLevel(Difficulty, Round);
    }

    public void getInput() {
        if (Round == 1) {
            gameScreenController = LoadSceneButton.loadScene("GameScreen/gameScreen.fxml", loaderContainer);
        }
        gameScreenController.setLevel(GeneratedLevel);
    }

    public void setUnlimited() {
        unlimited = true;
        System.out.println("test");
    }

    public class GameTask extends TimerTask {
        public void run() {

            Platform.runLater(() -> {
                setInterval();
            });
            if (gameScreenController.userInput != null) {
                UserInputtedValue = gameScreenController.userInput;
                gameScreenController.userInput = null;
                gameScreenController.levelBox.setText(null);
                gameScreenController.inputBox.setText(null);
                checkInput();
                TimePassed = 10;
            }
        }
    }
        public void startTimer() {
            int delay = 1000;
            int period = 1000;
            Timer = new Timer();

                TimePassed = Integer.parseInt("10");
                Timer.scheduleAtFixedRate(GameTask, delay, period);

        }

        private final int setInterval() {
            if (TimePassed == 1) {
              cancelTimer();
                gameScreenController.loadScene(false, Score);
            }
            TimePassed--;
            gameScreenController.timerLabel.textProperty().bind(new SimpleIntegerProperty(TimePassed).asString());
            return TimePassed;
        }

        public void cancelTimer() {
            GameTask.cancel();
        }

        public void checkInput() {
        boolean missingChartrue = false;
            String[] inputArray = UserInputtedValue.split("");
            String[] levelArray = GeneratedLevel.split("");

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
                    count--;
                }
            }

                count = inputArray.length - count;

            if (missingChartrue){
                loopVariable = levelArray.length;
            }

            Score = (Score +((Double.valueOf(count) / Double.valueOf(loopVariable) * 100.00)*Double.valueOf(Difficulty)*Double.valueOf(TimePassed)));
            Platform.runLater(() -> {
                gameScreenController.scoreLabel.textProperty().bind(new SimpleIntegerProperty((int)Math.round(Score)).asString());
            });

            if (Round == Difficulty + 2 && !unlimited ) {
                cancelTimer();
                if (Score <= 500.00){
                    gameScreenController.loadScene(false, Score);
                }
                else {
                    gameScreenController.loadScene(true, Score);
                };
            } else {
                UserInputtedValue = null;
                loadLevel();
            }
        }
    }

