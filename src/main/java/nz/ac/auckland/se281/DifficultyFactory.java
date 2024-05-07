package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public DifficultyLevel createDifficulty(Difficulty difficulty) {

    switch (difficulty) {
      case EASY:
        // if the difficulty is easy, use a Easy
        return new EasyLevel();

      case MEDIUM:
        // if the difficulty is medium, use a Medium
        return new MediumLevel();

      case HARD:
        // if the difficulty is hard, use a Hard
        return null;
    }
    return null;
  }
}
