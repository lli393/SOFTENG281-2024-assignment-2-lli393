package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Medium Level class gets the strategy if player have chosen medium difficulty base on which round
 * player is on.
 *
 * <p>Random strategy for the first three round, then switch to top strategy.
 */
public class MediumLevel extends ArtificialIntelligence {
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
