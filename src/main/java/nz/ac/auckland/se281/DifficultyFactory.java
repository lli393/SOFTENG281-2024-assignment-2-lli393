package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  int roundNumber;
  // get amount of
  int evenCount;

  // get player's choice
  Choice choice;

  public DifficultyFactory(int roundNumber, int evenCount, Choice choice) {
    this.roundNumber = roundNumber;
    this.evenCount = evenCount;
    this.choice = choice;
  }

  public DifficultyLevel createDifficulty(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        // if the difficulty is easy, use a Easy
        return new EasyLevel();

      case MEDIUM:
        // if the difficulty is medium, use a Medium
        return new MediumLevel(roundNumber, choice, evenCount);

      case HARD:
        // if the difficulty is hard, use a Hard
        return null;
    }
    return null;
  }
}
