package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumLevel extends AIInstance {
  Choice choice;
  int evenCount;
  int oddCount;

  public MediumLevel(Choice choice) {
    this.choice = choice;
  }

  @Override
  public Strategy getStrategy(int evenCount, int oddCount, boolean win) {

    // use random strategy for the first 3 round, switch to top strategy afterwards
    if (roundNumber <= 3) {
      return new RandomStrategy();
    } else {
      return new TopStrategy(choice, evenCount, oddCount);
    }
  }
}
