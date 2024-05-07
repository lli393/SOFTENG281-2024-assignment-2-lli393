package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel implements DifficultyLevel {

  int roundNumber;
  Choice choice;
  int evenCount;
  int oddCount;

  public MediumLevel(int roundNumber, Choice choice, int evenCount) {
    this.roundNumber = roundNumber;
    this.choice = choice;
    this.evenCount = evenCount;
    oddCount = roundNumber - evenCount;
  }

  @Override
  public Strategy getStrategy() {

    // use random strategy for the first 3 round, switch to top strategy afterwards
    if (roundNumber <= 3) {
      return new RandomStrategy();
    } else {

      return new TopStrategy(choice, evenCount, oddCount);
    }
  }
}
