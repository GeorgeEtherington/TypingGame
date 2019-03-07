package typingGame.LevelGenerator;

import java.util.Random;

public class LevelGenerator {

 public String generateLevel(int level, int round)
  {
      final String levelString = setDifficulty(level);
      String generateRound = "";
      final int difficultyLength = levelString.length();

      Random r = new Random();

      for (int i = 0; i < round+2; i++)
      {
          generateRound += levelString.charAt(r.nextInt(difficultyLength));
      }

      return generateRound;
  };


    private String setDifficulty(int level)
    {
        switch (level) {
            case 1:
                return ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
            case 2:
                return ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,/?!");
            case 3:
                return ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,/?!£$%^&*()");
            case 4:
                return ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890.,/?!£$%^&*()-=+_@~{}[]");

            default:
                System.out.println("Invalid Level");
                return("");
        }
    }
}

