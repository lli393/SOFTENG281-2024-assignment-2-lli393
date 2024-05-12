package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

  public AIInstance createDifficulty(Difficulty difficulty, Choice choice) {

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
