package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardLevel extends AIInstance {
  Choice choice;
  int evenCount;
  int oddCount;

  public HardLevel(Choice choice) {

    this.choice = choice;
    // counts doesn't include for this round, so minus 1
    oddCount = roundNumber - evenCount - 1;
  }

  @Override
  public Strategy getStrategy(int evenCount, int oddCount, boolean win) {

    // use random strategy for the first 3 round, can switch between random or top strategy
    // afterwards
    if (roundNumber <= 3) {
      strategy = new RandomStrategy();
    } else if (roundNumber > 3 && win) {
      // if player win and ai lose, switch the strategy
      // if ai is at random strategy change to top strategy
      if (strategy instanceof RandomStrategy) {
        strategy = new TopStrategy(choice, evenCount, oddCount);
      } else if (strategy instanceof TopStrategy) {
        // if ai is at top strategy change to random strategy
        strategy = new RandomStrategy();
      }
    }

    return strategy;
  }
}
