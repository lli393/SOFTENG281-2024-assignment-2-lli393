package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * DifficultyFactory chooses the difficulty level base on player's choice for difficulty and passes
 * the choice of player to each levels to determine the output of top strategy.
 */
public class DifficultyFactory {

  /**
   * This method returns an ai base on the difficulty and passes the choice of player to win.
   *
   * @param difficulty difficulty (easy, medium, hard) of the game base on player's input
   * @param choice player's choice (even, odd) of winning, if sum number is even or odd as the same
   *     as player's choice, player win
   * @return return a ai base on chosen difficulty level
   */
  public ArtificialIntelligence createDifficulty(Difficulty difficulty, Choice choice) {

    switch (difficulty) {
      case EASY:
        // if the difficulty is easy, use a Easy
        return new EasyLevel();

      case MEDIUM:
        // if the difficulty is medium, use a Medium
        return new MediumLevel(choice);

      case HARD:
        // if the difficulty is hard, use a Hard
        return new HardLevel(choice);
    }
    return null;
  }
}
